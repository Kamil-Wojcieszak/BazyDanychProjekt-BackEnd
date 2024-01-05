package com.BazyDanych2Projekt.BazyDanychProjekt.OrderStationary;

import com.BazyDanych2Projekt.BazyDanychProjekt.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderStationaryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OrderStationary> getOrderStationaryList() {
        return jdbcTemplate.query("SELECT * FROM order_stationary", BeanPropertyRowMapper.newInstance(OrderStationary.class));
    }

    public OrderStationary getOrderStationaryById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM order_stationary WHERE order_st_id = ?", BeanPropertyRowMapper.newInstance(OrderStationary.class), id);
    }

    public String saveOrders(List<OrderStationary> orderStationary) {
        orderStationary.forEach(orderStationaryValues -> jdbcTemplate.update("INSERT INTO order_stationary (order_st_id, totality, date)" +
                        "VALUES (?, ?, ?)",
                orderStationaryValues.getOrder_st_id(),
                orderStationaryValues.getTotality(),
                orderStationaryValues.getDate()));

        return "Success!";
    }

    public int updateOrderStationary(OrderStationary orderStationary) {
        return jdbcTemplate.update("UPDATE order_stationary SET totality = ?, date = ? WHERE order_st_id = ?",
                orderStationary.getTotality(), orderStationary.getDate(), orderStationary.getOrder_st_id());
    }

    public String deleteOrderStationary(int id) {
        jdbcTemplate.update("DELETE FROM order_stationary WHERE order_st_id = ?", id);

        return "Success!";
    }
}
