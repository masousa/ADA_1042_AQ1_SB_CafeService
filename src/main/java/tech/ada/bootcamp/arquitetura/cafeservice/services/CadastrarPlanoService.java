package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Plano;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.PlanoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastrarPlanoService {

    private final PlanoRepository planoRepository;

    public void casdastrarPlano(Plano plano){
        planoRepository.save(plano);
    }

    public List<Plano> listarPlanos(){
        return planoRepository.findAll();
    }
}
