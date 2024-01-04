package com.BazyDanych2Projekt.BazyDanychProjekt.Underwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnderwearRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Underwear> getUnderwearList() {
        return jdbcTemplate.query("SELECT * FROM underwear", BeanPropertyRowMapper.newInstance(Underwear.class));
    }

    public Underwear getUnderwearById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM underwear WHERE underwear_id = ?", BeanPropertyRowMapper.newInstance(Underwear.class), id);
    }

    public String saveUnderwear(List<Underwear> underwear) {
        underwear.forEach(underwear_value -> jdbcTemplate.update("INSERT INTO underwear (underwear_id, underwear_model_id, size, color, sku, ean, quantity, price)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                underwear_value.getUnderwear_id(),
                underwear_value.getUnderwear_model_id(),
                underwear_value.getSize(),
                underwear_value.getColor(),
                underwear_value.getSku(),
                underwear_value.getEan(),
                underwear_value.getQuantity(),
                underwear_value.getPrice()));

        return "Success!";
    }

    public String fullyUpdateUnderwear(Underwear underwear) {
        jdbcTemplate.update("UPDATE underwear SET underwear_id = ?, underwear_model_id = ?, size = ?, color = ?, sku = ?, ean = ?, quantity = ?, price = ?",
                underwear.getUnderwear_id(), underwear.getUnderwear_model_id(), underwear.getSize(), underwear.getColor(),
                underwear.getSku(), underwear.getEan(), underwear.getQuantity(), underwear.getPrice());

        return "Success!";
    }

    public String partiallyUpdateUnderwear(Underwear underwear) {
        jdbcTemplate.update("UPDATE underwear SET size = ?, color = ?, sku = ?, ean = ?, quantity = ?, price = ?",
                underwear.getSize(), underwear.getColor(), underwear.getSku(), underwear.getEan(), underwear.getQuantity(), underwear.getPrice());

        return "Success!";
    }

    public String deleteUnderwear(int id) {
        jdbcTemplate.update("DELETE FROM underwear WHERE underwear_id = ?", id);

        return "Success!";
    }
}
