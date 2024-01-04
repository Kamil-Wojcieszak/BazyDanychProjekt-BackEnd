package com.BazyDanych2Projekt.BazyDanychProjekt.ShopsWithAddresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopsWithAddressesRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ShopsWithAddresses> getList() {
        return jdbcTemplate.query("SELECT * FROM view_shops_with_address", BeanPropertyRowMapper.newInstance(ShopsWithAddresses.class));
    }
}
