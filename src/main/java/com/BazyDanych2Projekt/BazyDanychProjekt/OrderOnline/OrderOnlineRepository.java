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

    public List<OrderOnline> getOrderOnlineFiltered(int id, String email, int phoneNumber) {
        return jdbcTemplate.query("SELECT * FROM order_online WHERE order_on_id = ? OR email = ? OR phone_number = ?", BeanPropertyRowMapper.newInstance(OrderOnline.class), id, email, phoneNumber);
    }

    public String saveOrders(List<OrderOnline> orderOnline) {
        orderOnline.forEach(orderOnlineValue -> jdbcTemplate.update("INSERT INTO order_online (order_on_id, totality, email, date, phone_number)" +
                        "VALUES (?, ?, ?, ?, ?)",
                orderOnlineValue.getOrder_on_id(),
                orderOnlineValue.getTotality(),
                orderOnlineValue.getEmail(),
                orderOnlineValue.getDate(),
                orderOnlineValue.getPhone_number()));

        return "Success!";
    }

    public String deleteOrderOnline(int id) {
        jdbcTemplate.update("DELETE FROM order_online WHERE order_on_id = ?", id);

        return "Success!";
    }
}
