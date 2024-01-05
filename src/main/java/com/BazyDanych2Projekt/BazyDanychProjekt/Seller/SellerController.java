package com.BazyDanych2Projekt.BazyDanychProjekt.Seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {
    
    @Autowired
    SellerRepository sellerRepository;

    @GetMapping("/list")
    public List<Seller> getSellerList() {
        return sellerRepository.getSellerList();
    }

    @PostMapping("/add")
        public String addSeller(@RequestBody List<Seller> seller) {
        return sellerRepository.addSeller(seller);
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable("id") int id) {
        return sellerRepository.getSellerById(id);
    }

    @PatchMapping("/{id}")
    public String updateSeller(@PathVariable("id") int id, @RequestBody Seller updatedSeller) {
        Seller seller = sellerRepository.getSellerById(id);

        if (seller != null) {
            if (updatedSeller.getStore_id() > 0) {
                seller.setStore_id(updatedSeller.getStore_id());
            }

            sellerRepository.updateSeller(seller);

            return "Success!";
        } else {
            return "Error";
        }
    }

    @DeleteMapping("/{id}-seller")
    public String deleteSellerBySellerId(@PathVariable("id") int id) {
        return sellerRepository.deleteSellerBySellerId(id);
    }

    @DeleteMapping("/{id}-store")
    public String deleteSellerByStoreId(@PathVariable("id") int id) {
        return sellerRepository.deleteSellerByStoreId(id);
    }
}
