package com.BazyDanych2Projekt.BazyDanychProjekt.UnderwearModel;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnderwearModelRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UnderwearModel> getUnderwearModelList() {
        return jdbcTemplate.query("SELECT * FROM underwear_model", BeanPropertyRowMapper.newInstance(UnderwearModel.class));
    }

    public UnderwearModel getUnderwearModelById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM underwear_model WHERE underwear_mod_id = ?", BeanPropertyRowMapper.newInstance(UnderwearModel.class), id);
    }

    public String deleteUnderwearModel(int id) {
        jdbcTemplate.update("DELETE FROM underwear_model WHERE underwear_id = ?", id);

        return "Success!";
    }
}
