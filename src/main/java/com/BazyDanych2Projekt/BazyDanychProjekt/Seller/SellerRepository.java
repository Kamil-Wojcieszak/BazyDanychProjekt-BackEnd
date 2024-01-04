package com.BazyDanych2Projekt.BazyDanychProjekt.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Seller> getSellerList() {
        return jdbcTemplate.query("SELECT * FROM seller", BeanPropertyRowMapper.newInstance(Seller.class));
    }

    public String addSeller(List<Seller> sellers) {
        sellers.forEach(seller -> jdbcTemplate.update("INSERT INTO underwear (seller_id, store_id)" +
                        "VALUES (?, ?)",
                seller.getSeller_id(),
                seller.getStore_id()));

        return "Success!";
    }

    public String deleteSellerBySellerId(int id) {
        jdbcTemplate.update("DELETE FROM seller WHERE seller_id = ?", id);

        return "Success!";
    }

    public String deleteSellerByStoreId(int id) {
        jdbcTemplate.update("DELETE FROM seller WHERE store_id = ?", id);

        return "Success!";
    }
}
