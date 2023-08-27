package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.model.ItemCompra;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemCompraRepository;

@Service
@RequiredArgsConstructor
public class CadastrarItemCompraService {
    private final ItemCompraRepository itemCompraRepository;

    public void cadastrarItemCompra(ItemCompra itemCompra){
        itemCompraRepository.save(itemCompra);
    }
}
