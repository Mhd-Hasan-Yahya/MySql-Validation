package com.yahya.flea_market.endpoint;

import com.yahya.flea_market.model.Item;
import com.yahya.flea_market.sevice.ItemService;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemEndpoint {
    private final ItemService service;

    @GetMapping
    List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    Optional<Item> getItem(@PathVariable long id) {
        return service.getItemById(id);
    }

    @PostMapping
    Item saveItem(@RequestBody Item item) {
        return service.saveItem(item);
    }
    @DeleteMapping("{id}")
    String deleteItem(@PathVariable long id) {
        service.deleteItemById(id);
        return "successfully deleted";
    }
    @PutMapping("{id}")
    Item update(@PathVariable long id, @RequestBody Item item){
        return service.update(id, item);
    }
}
