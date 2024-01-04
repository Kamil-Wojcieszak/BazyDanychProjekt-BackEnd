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

    @DeleteMapping("/{id}-seller")
    public String deleteSellerBySellerId(@PathVariable("id") int id) {
        return sellerRepository.deleteSellerBySellerId(id);
    }

    @DeleteMapping("/{id}-store")
    public String deleteSellerByStoreId(@PathVariable("id") int id) {
        return sellerRepository.deleteSellerByStoreId(id);
    }
}
