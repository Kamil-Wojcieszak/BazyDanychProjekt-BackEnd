package com.BazyDanych2Projekt.BazyDanychProjekt.Store;

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

    public String addStore(List<Store> store) {
        store.forEach(StoreValue -> jdbcTemplate.update("INSERT INTO store (store_id, address_id)" +
                        "VALUES (?, ?)",
                StoreValue.getStore_id(),
                StoreValue.getAddress_id()));

        return "Success!";
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
