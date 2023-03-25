package com.yahya.flea_market.sevice;

import com.yahya.flea_market.model.Item;
import com.yahya.flea_market.repository.ItemRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository repository;

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Optional<Item> getItemById(long id) {
        return repository.findById(id);
    }

    public Item saveItem(Item item) {
        return repository.save(item);

    }

    public void deleteItemById(long id) {
        repository.deleteById(id);
    }

    public Item update(long oldId, Item item) {
        Item newItem = new Item(oldId, item.getName(), item.getPrice());
        return repository.save(newItem);

    }

}
