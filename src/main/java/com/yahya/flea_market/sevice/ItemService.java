package com.yahya.flea_market.sevice;

import com.yahya.flea_market.model.Item;
import com.yahya.flea_market.repository.ItemRepository;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
@Validated
@AllArgsConstructor
public class ItemService {
    private final ItemRepository repository;

    public List<Item> getAll() {
        return repository.findAll();
    }

    public Optional<Item> getItemById(long id) {
        return repository.findById(id);
    }

    public Item saveItem(@Valid Item item) {
        return repository.save(item);

    }

    public void deleteItemById(long id) {
        repository.deleteById(id);
    }

    public Item update(long oldId, Item item) {
        Item newItem = new Item(oldId, item.getName(), item.getPrice());
        return repository.save(newItem);

    }
    public List<Item> getPriceGreaterMinPrice(double minPrice) {
        return repository.findByPriceGreaterThan(minPrice);
    }
    public List<Item> getPriceGreaterMinPriceAndNameStartingWith(double minPrice, String name) {
        return repository.findByPriceGreaterThanAndNameStartingWith(minPrice, name);
    }

}
