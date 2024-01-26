package com.BazyDanych2Projekt.BazyDanychProjekt.OrderOnline;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderOnlineRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OrderOnline> getOrderOnlineList() {
        return jdbcTemplate.query("SELECT * FROM order_online", BeanPropertyRowMapper.newInstance(OrderOnline.class));
    }

    public List<OrderOnline> getOrderOnlineFiltered(int id, String email, int phoneNumber,String status) {
        return jdbcTemplate.query("SELECT * FROM order_online WHERE order_on_id = ? OR email = ? OR phone_number = ? OR status = ?", BeanPropertyRowMapper.newInstance(OrderOnline.class), id, email, phoneNumber, status);
    }

    public void saveOrders(List<OrderOnline> orderOnline) {
        orderOnline.forEach(orderOnlineValue -> jdbcTemplate.update("INSERT INTO order_online (order_on_id, totality, email, date, phone_number,NEW)" +
                        "VALUES (?, ?, ?, ?, ?)",
                orderOnlineValue.getOrder_on_id(),
                orderOnlineValue.getTotality(),
                orderOnlineValue.getEmail(),
                orderOnlineValue.getDate(),
                orderOnlineValue.getPhone_number()));

    }

    public void deleteOrderOnline(int id) {
        jdbcTemplate.update("DELETE FROM order_online WHERE order_on_id = ?", id);
    }
}
