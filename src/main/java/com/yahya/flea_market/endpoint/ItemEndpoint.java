package com.yahya.flea_market.endpoint;

import com.yahya.flea_market.model.Item;
import com.yahya.flea_market.sevice.ItemService;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
@Validated
public class ItemEndpoint {
    private final ItemService service;

    @GetMapping
    List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    Optional<Item> getItem(@PathVariable("id") @Min(3) long id) {
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

    @GetMapping("/test")
    List<Item> getRequiredPrice(@RequestParam double minPrice) {
        return service.getPriceGreaterMinPrice(minPrice);
    }

    @GetMapping("/test2")
    List<Item> getRequiredPriceAndName(@RequestParam @Min(5) @Max(10) double minPrice, @RequestParam @Size(min = 2, max = 10) String name) {
        return service.getPriceGreaterMinPriceAndNameStartingWith(minPrice, name);
    }
}
