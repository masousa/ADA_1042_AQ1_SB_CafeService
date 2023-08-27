package tech.ada.bootcamp.arquitetura.cafeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Compra;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.RealizarCompraRequest;
import tech.ada.bootcamp.arquitetura.cafeservice.payloads.RealizarCompraResponse;
import tech.ada.bootcamp.arquitetura.cafeservice.services.CadastrarCompraService;

import java.util.List;

@RestController
@RequestMapping("/compra")
@RequiredArgsConstructor
public class CompraController {

    private final CadastrarCompraService cadastrarCompraService;
    @PostMapping(value = "/")
    public RealizarCompraResponse realizarCompra(@RequestBody RealizarCompraRequest realizarCompraRequest){
        return cadastrarCompraService.cadastrarCompra(realizarCompraRequest);
    }

    @GetMapping(value = "/")
    public List<RealizarCompraResponse> listarCompra(){
        return cadastrarCompraService.listarCompras();
    }


}
