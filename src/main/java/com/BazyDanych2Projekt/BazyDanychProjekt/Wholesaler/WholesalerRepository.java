package com.BazyDanych2Projekt.BazyDanychProjekt.Wholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WholesalerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Wholesaler> getWholesalerList() {
        return jdbcTemplate.query("SELECT * FROM wholesaler", BeanPropertyRowMapper.newInstance(Wholesaler.class));
    }

    public Wholesaler getWholesalerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM wholesaler WHERE wholesaler_id = ?", BeanPropertyRowMapper.newInstance(Wholesaler.class), id);
    }

    public String saveWholesalers(List<Wholesaler> wholesalers) {
        wholesalers.forEach(wholesaler -> jdbcTemplate.update("INSERT INTO wholesaler (wholesaler_id, name, address_id)" +
                "VALUES (?, ?, ?)",
                wholesaler.getWholesaler_id(),
                wholesaler.getName(),
                wholesaler.getAddress_id()));

        return "Success!";
    }

    public String deleteWholesaler(int id) {
        jdbcTemplate.update("DELETE FROM wholesaler WHERE wholesaler_id = ?", id);

        return "Success!";
    }
}
