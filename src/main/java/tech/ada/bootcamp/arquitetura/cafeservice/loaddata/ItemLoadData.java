package tech.ada.bootcamp.arquitetura.cafeservice.loaddata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Item;
import tech.ada.bootcamp.arquitetura.cafeservice.model.TipoUnidade;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemRepository;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemLoadData implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final ComboLoadData comboLoadData;

    @Override
    public void run(String... args) throws Exception {
        if(itemRepository.count()==0) {
            List<Item> items = createItems();
            items.forEach(itemRepository::save);
            comboLoadData.run();
        }
    }

    private List<Item> createItems() {
        List<String> descricaoItems = Arrays.asList("Café torra clara", "Café torra média",
                "Café torra escura");
        return descricaoItems.stream().map(this::generateItem).toList();

    }

    private Item generateItem(String descricao) {
        Item item = new Item();
        item.setDescricao(descricao);
        item.setTipoUnidade(TipoUnidade.GRAMA);
        item.setQuantidadeUnidade(250L);
        item.setValorUnitario(20.0);
        return item;
    }
}
