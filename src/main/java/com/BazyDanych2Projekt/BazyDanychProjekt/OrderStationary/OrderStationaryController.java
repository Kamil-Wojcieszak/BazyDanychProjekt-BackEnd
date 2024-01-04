package com.BazyDanych2Projekt.BazyDanychProjekt.OrderStationary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-stationary")
public class OrderStationaryController {

    @Autowired
    OrderStationaryRepository orderStationaryRepository;

    @GetMapping("/list")
    public List<OrderStationary> getOrderStationaryList() {
        return orderStationaryRepository.getOrderStationaryList();
    }

    @GetMapping("/{id}")
    public OrderStationary getOrderStationaryById(@PathVariable("id") int id) {
        return orderStationaryRepository.getOrderStationaryById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody List<OrderStationary> orderStationary) {
        return orderStationaryRepository.saveOrders(orderStationary);
    }
}
