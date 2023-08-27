package tech.ada.bootcamp.arquitetura.cafeservice.loaddata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Combo;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ComboRepository;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemRepository;

@Component
@RequiredArgsConstructor
public class ComboLoadData{

    public static final String TODOS_OS_CAFÉS = "Todos os cafés";
    private final ItemRepository itemRepository;
    private final ComboRepository comboRepository;


    public void run() {
        if(!comboRepository.existsByDescricao(TODOS_OS_CAFÉS)){
            createDefaultCombo();
        }
    }

    private void createDefaultCombo() {
        Combo combo = new Combo();
        combo.setDescricao(TODOS_OS_CAFÉS);
        combo.setValorFinal(50.0);
        combo.setItems(itemRepository.findAll());
        comboRepository.save(combo);
    }
}
