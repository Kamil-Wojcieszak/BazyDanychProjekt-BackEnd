package com.BazyDanych2Projekt.BazyDanychProjekt.Store;

import com.BazyDanych2Projekt.BazyDanychProjekt.Seller.Seller;
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

    @GetMapping("/{id}")
    public Store getStoreById(@PathVariable("id") int id) {
        return storeRepository.getStoreById(id);
    }

    @PostMapping("/add")
    public String addStore(@RequestBody List<Store> stores) {
        return storeRepository.addStore(stores);
    }

    @PatchMapping("/{id}")
    public String updateStore(@PathVariable("id") int id, @RequestBody Store updatedStore) {
        Store store = storeRepository.getStoreById(id);

        if (store != null) {
            if (updatedStore.getAddress_id() > 0) {
                store.setAddress_id(updatedStore.getAddress_id());
            }

            storeRepository.updateStore(store);

            return "Success!";
        } else {
            return "Error";
        }
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
