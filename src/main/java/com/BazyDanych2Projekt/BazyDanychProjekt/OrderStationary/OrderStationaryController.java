package com.BazyDanych2Projekt.BazyDanychProjekt.OrderStationary;

import com.BazyDanych2Projekt.BazyDanychProjekt.Address.Address;
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

    @PatchMapping("/{id}")
    public String updateAddress(@PathVariable("id") int id, @RequestBody OrderStationary updatedOrderStationary) {
        OrderStationary orderStationary = orderStationaryRepository.getOrderStationaryById(id);

        if (orderStationary != null) {
            if (updatedOrderStationary.getTotality() > 0) {
                orderStationary.setTotality(updatedOrderStationary.getTotality());
            }

            if (updatedOrderStationary.getDate() != null) {
                orderStationary.setDate(updatedOrderStationary.getDate());
            }

            orderStationaryRepository.updateOrderStationary(orderStationary);

            return "Success!";
        } else {
            return "Error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteOrderOnline(@PathVariable("id") int id) {
        return orderStationaryRepository.deleteOrderStationary(id);
    }
}
