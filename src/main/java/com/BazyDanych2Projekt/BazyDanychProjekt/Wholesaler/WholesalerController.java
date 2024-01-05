package com.BazyDanych2Projekt.BazyDanychProjekt.Wholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wholesaler")
public class WholesalerController {

    @Autowired
    WholesalerRepository wholesalerRepository;

    @GetMapping("/list")
    public List<Wholesaler> getWholesalerList() {
        return wholesalerRepository.getWholesalerList();
    }

    @GetMapping("/{id}")
    public Wholesaler getWholesalerById(@PathVariable("id") int id) {
        return wholesalerRepository.getWholesalerById(id);
    }

    @PostMapping("/add")
    public String addWholesaler(@RequestBody List<Wholesaler> wholesalers) {
        return wholesalerRepository.saveWholesalers(wholesalers);
    }

    @PatchMapping("/{id}")
    public String updateReport(@PathVariable("id") int id, @RequestBody Wholesaler updatedWholesaler) {
        Wholesaler wholesaler = wholesalerRepository.getWholesalerById(id);

        if (wholesaler != null) {
            if (updatedWholesaler.getName() != null) {
                wholesaler.setName(updatedWholesaler.getName());
            }

            if (updatedWholesaler.getAddress_id() > 0) {
                wholesaler.setAddress_id(updatedWholesaler.getAddress_id());
            }

            wholesalerRepository.updateWholesaler(wholesaler);

            return "Success!";
        } else {
            return "Error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteWholesaler(@PathVariable("id") int id) {
        return wholesalerRepository.deleteWholesaler(id);
    }
}
