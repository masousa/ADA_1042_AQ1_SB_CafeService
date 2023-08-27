package tech.ada.bootcamp.arquitetura.cafeservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.ada.bootcamp.arquitetura.cafeservice.model.Item;
import tech.ada.bootcamp.arquitetura.cafeservice.repository.ItemRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CadastrarItemsService {
    private final ItemRepository itemRepository;

    public void cadastrarItem(Item item){
        itemRepository.save(item);
    }

    public List<Item> listarItems(){
        return itemRepository.findAll();
    }
}
