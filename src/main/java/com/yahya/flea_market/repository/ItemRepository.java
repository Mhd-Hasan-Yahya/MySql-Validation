package com.yahya.flea_market.repository;

import com.yahya.flea_market.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

  List<Item> findByPriceGreaterThan(double price);

  List<Item> findByPriceGreaterThanAndNameStartingWith(double price, String name);

}
