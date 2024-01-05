package com.BazyDanych2Projekt.BazyDanychProjekt.Seller;

import com.BazyDanych2Projekt.BazyDanychProjekt.Report.Report;
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

    public Seller getSellerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM seller WHERE seller_id = ?", BeanPropertyRowMapper.newInstance(Seller.class), id);
    }

    public String addSeller(List<Seller> sellers) {
        sellers.forEach(seller -> jdbcTemplate.update("INSERT INTO seller (seller_id, store_id)" +
                        "VALUES (?, ?)",
                seller.getSeller_id(),
                seller.getStore_id()));

        return "Success!";
    }

    public int updateSeller(Seller seller) {
        return jdbcTemplate.update("UPDATE seller SET store_id = ? WHERE seller_id = ?",
                seller.getStore_id(), seller.getSeller_id());
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
