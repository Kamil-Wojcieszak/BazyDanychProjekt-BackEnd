package com.BazyDanych2Projekt.BazyDanychProjekt.RelationStoreUnderwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RelationStoreUnderwearRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RelationStoreUnderwear> getRelationStoreUnderwearList() {
        return jdbcTemplate.query("SELECT * FROM relation_store_underwear", BeanPropertyRowMapper.newInstance(RelationStoreUnderwear.class));
    }

    public String addRelationStoreUnderwear(List<RelationStoreUnderwear> relationStoreUnderwear) {
        relationStoreUnderwear.forEach(relationStoreUnderwearValue -> jdbcTemplate.update("INSERT INTO relation_store_underwear (underwear_id, store_id)" +
                "VALUES (?, ?)",
                relationStoreUnderwearValue.getUnderwear_id(),
                relationStoreUnderwearValue.getStore_id()));

        return "Success!";
    }

    public String deleteRelationStoreUnderwearByUnderwearId(int id) {
        jdbcTemplate.update("DELETE FROM relation_store_underwear WHERE underwear_id = ?", id);

        return "Success!";
    }

    public String deleteRelationStoreUnderwearByStoreId(int id) {
        jdbcTemplate.update("DELETE FROM relation_store_underwear WHERE store_id = ?", id);

        return "Success!";
    }
}
