package com.BazyDanych2Projekt.BazyDanychProjekt.ShopsWithAddresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shops-with-addresses")
public class ShopsWithAddressesController {

    @Autowired
    ShopsWithAddressesRepository shopsWithAddressesRepository;

    @GetMapping("/list")
    public List<ShopsWithAddresses> getList() {
        return shopsWithAddressesRepository.getList();
    }
}
