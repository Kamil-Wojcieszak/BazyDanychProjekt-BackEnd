package com.BazyDanych2Projekt.BazyDanychProjekt.Store;

import com.BazyDanych2Projekt.BazyDanychProjekt.Seller.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepository {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Store> getStoreList() {
        return jdbcTemplate.query("SELECT * FROM store", BeanPropertyRowMapper.newInstance(Store.class));
    }

    public Store getStoreById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM store WHERE store_id = ?", BeanPropertyRowMapper.newInstance(Store.class), id);
    }

    public String addStore(List<Store> stores) {
        stores.forEach(store -> jdbcTemplate.update("INSERT INTO store (store_id, address_id)" +
                        "VALUES (?, ?)",
                store.getStore_id(),
                store.getAddress_id()));

        return "Success!";
    }

    public int updateStore(Store store) {
        return jdbcTemplate.update("UPDATE store SET address_id = ? WHERE store_id = ?",
                store.getAddress_id(), store.getStore_id());
    }

    public String deleteStoreByStoreId(int id) {
        jdbcTemplate.update("DELETE FROM store WHERE store_id = ?", id);

        return "Success!";
    }

    public String deleteStoreByAddressId(int id) {
        jdbcTemplate.update("DELETE FROM Store WHERE address_id = ?", id);

        return "Success!";
    }
}
