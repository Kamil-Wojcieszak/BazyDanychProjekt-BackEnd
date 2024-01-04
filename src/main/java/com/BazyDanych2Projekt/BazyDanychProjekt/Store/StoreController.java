package com.BazyDanych2Projekt.BazyDanychProjekt.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/list")
    public List<Store> getStoreList() {
        return storeRepository.getStoreList();
    }

    @PostMapping("/add")
    public String addStore(List<Store> store) {
        return storeRepository.addStore(store);
    }

    @DeleteMapping("/{id}-store")
    public String deleteStoreByStoreId(@PathVariable("id") int id) {
        return storeRepository.deleteStoreByStoreId(id);
    }

    @DeleteMapping("/{id}-address")
    public String deleteStoreByAddressId(@PathVariable("id") int id) {
        return storeRepository.deleteStoreByAddressId(id);
    }
}
