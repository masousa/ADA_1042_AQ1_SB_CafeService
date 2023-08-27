package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.exceptions.NotFoundException;
import tech.ada.bootcamp.arquitetura.cafeservice.model.*;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.ItemCompraRequest;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.ItemCompraResponse;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.RealizarCompraRequest;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.RealizarCompraResponse;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ComboRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.CompraRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemCompraRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CadastrarCompraService {

    private final CompraRepository compraRepository;
    private final CadastrarUsuarioService cadastrarUsuarioService;
    private final ComboRepository comboRepository;
    private final ItemRepository itemRepository;
    private final ItemCompraRepository itemCompraRepository;

    public RealizarCompraResponse cadastrarCompra(RealizarCompraRequest realizarCompraRequest){
        Compra compra = new Compra();
        compra.setDataCompra(LocalDateTime.now());
        compra.setCliente(cadastrarUsuarioService.findUsuario(realizarCompraRequest.getIdentificadorCliente()));
        List<ItemCompra> itensCompra = converterItensCompra
                (realizarCompraRequest.getItems(),compra, compra.getCliente().getPlano());
        compra.setValorTotal(itensCompra.stream().mapToDouble(ItemCompra::getTotal).sum());
        compra.setTotalDescontos(itensCompra.stream().mapToDouble(ItemCompra::getDesconto).sum());
        Compra compraSaved = compraRepository.save(compra);
        itensCompra.forEach(itemCompra -> itemCompra.setCompra(compraSaved));
        List<ItemCompra> itemComprasSaved = itemCompraRepository.saveAll(itensCompra);
        return formatarResposta(compraSaved, itemComprasSaved);
    }

    private RealizarCompraResponse formatarResposta(Compra compraSaved, List<ItemCompra> itemComprasSaved) {
        RealizarCompraResponse realizarCompraResponse = new RealizarCompraResponse();
        realizarCompraResponse.setDataCompra(compraSaved.getDataCompra().toLocalDate());
        realizarCompraResponse.setTotal(compraSaved.getValorTotal());
        realizarCompraResponse.setItems(formatarRespostaItens(itemComprasSaved));
        return realizarCompraResponse;
    }

    private RealizarCompraResponse formatarResposta(Compra compraSaved) {
        List<ItemCompra> itemCompras = itemCompraRepository.findByCompraId(compraSaved.getId());
        return formatarResposta(compraSaved,itemCompras);
    }

    private List<ItemCompraResponse> formatarRespostaItens(List<ItemCompra> itemComprasSaved) {
        return itemComprasSaved.stream().map(this::formatarRespostaItem).toList();
    }

    private ItemCompraResponse formatarRespostaItem(ItemCompra itemCompra) {
        ItemCompraResponse itemCompraResponse = new ItemCompraResponse();
        itemCompraResponse.setValor(itemCompra.getTotal());
        itemCompraResponse.setQuantidade(itemCompra.getQuantidade());
        String identificador;
        boolean isCombo=false;
        if(Objects.nonNull(itemCompra.getCombo())){
            isCombo = true;
            identificador = itemCompra.getCombo().getDescricao();
        }else{
            identificador = itemCompra.getItem().getDescricao();

        }
        itemCompraResponse.setIdentificadorItem(identificador);
        itemCompraResponse.setCombo(isCombo);
        return itemCompraResponse;
    }

    private List<ItemCompra> converterItensCompra(List<ItemCompraRequest> items, Compra compra, Plano plano) {
        List<ItemCompra> itemsCompra = new ArrayList<>();

        for (ItemCompraRequest itemRequest :
                items) {
            ItemCompra iCompra = new ItemCompra();
            iCompra.setCompra(compra);

            iCompra.setQuantidade(itemRequest.getQuantidade());
            double valorBruto;
            if(itemRequest.isCombo()){
                Combo combo = comboRepository.findById(Long.parseLong(itemRequest.getIdentificadorItem()))
                        .orElseThrow(() -> new NotFoundException("Combo"));
                iCompra.setCombo(combo);
                valorBruto = combo.getValorFinal()*itemRequest.getQuantidade();
            }else{
                Item item = itemRepository.findById(Long.parseLong(itemRequest.getIdentificadorItem()))
                        .orElseThrow(() -> new NotFoundException("Item"));
                iCompra.setItem(item);
                valorBruto = item.getValorUnitario()*itemRequest.getQuantidade();
            }
            if(TipoDesconto.VALOR.equals(plano.getTipoDesconto())){
                iCompra.setDesconto(valorBruto-plano.getDesconto());
            }else{
                iCompra.setDesconto((valorBruto*plano.getDesconto())/100);
            }

            iCompra.setValorBruto(valorBruto);
            iCompra.setTotal(valorBruto- iCompra.getDesconto());
            itemsCompra.add(iCompra);
        }

        return itemsCompra;
    }


    public List<RealizarCompraResponse> listarCompras(){
        return compraRepository.findAll()
                .stream().map(this::formatarResposta).toList();
    }
}
