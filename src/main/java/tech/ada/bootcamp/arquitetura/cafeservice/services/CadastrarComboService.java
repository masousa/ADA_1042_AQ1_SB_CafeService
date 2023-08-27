package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Combo;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ComboRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastrarComboService {
    private final ComboRepository comboRepository;

    public void cadastrarCombo(Combo combo){
        comboRepository.save(combo);
    }

    public List<Combo> listarCombos(){
        return comboRepository.findAll();
    }
}
