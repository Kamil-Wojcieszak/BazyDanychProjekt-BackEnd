package com.BazyDanych2Projekt.BazyDanychProjekt.OrderOnline;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-online")
public class OrderOnlineController {

    @Autowired
    OrderOnlineRepository orderOnlineRepository;

    @GetMapping("/")
    public List<OrderOnline> getOrderOnlineList() {
        return orderOnlineRepository.getOrderOnlineList();
    }

    @GetMapping("/filtered")
    public List<OrderOnline> getOrderOnlineFiltered(
            @RequestParam("id") int id,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") int phoneNumber,
            @RequestParam("status") String status
    ) {
        return orderOnlineRepository.getOrderOnlineFiltered(id, email, phoneNumber, status);
    }

    @PostMapping("/add")
    public void add(@RequestBody List<OrderOnline> orderOnline) {
        orderOnlineRepository.saveOrders(orderOnline);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderOnline(@PathVariable("id") int id) {
        orderOnlineRepository.deleteOrderOnline(id);
    }
}
