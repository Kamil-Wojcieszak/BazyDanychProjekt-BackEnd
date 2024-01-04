package com.BazyDanych2Projekt.BazyDanychProjekt.RelationStoreWholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RelationStoreWholesalerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<RelationStoreWholesaler> getRelationStoreWholesalerList() {
        return jdbcTemplate.query("SELECT * FROM relation_store_wholesaler", BeanPropertyRowMapper.newInstance(RelationStoreWholesaler.class));
    }

    public String addRelationStoreWholesaler(List<RelationStoreWholesaler> relationStoreWholesaler) {
        relationStoreWholesaler.forEach(relationStoreWholesalerValue -> jdbcTemplate.update("INSERT INTO relation_store_wholesaler (wholesaler_id, store_id)" +
                        "VALUES (?, ?)",
                relationStoreWholesalerValue.getWholesaler_id(),
                relationStoreWholesalerValue.getStore_id()));

        return "Success!";
    }

    public String deleteRelationStoreWholesalerByWholesalerId(int id) {
        jdbcTemplate.update("DELETE FROM relation_store_wholesaler WHERE wholesaler_id = ?", id);

        return "Success!";
    }

    public String deleteRelationStoreWholesalerByStoreId(int id) {
        jdbcTemplate.update("DELETE FROM relation_store_Wholesaler WHERE store_id = ?", id);

        return "Success!";
    }
}
