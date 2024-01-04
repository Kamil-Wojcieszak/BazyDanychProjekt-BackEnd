package com.BazyDanych2Projekt.BazyDanychProjekt.Wholesaler;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
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

    @DeleteMapping("/{id}")
    public String deleteWholesaler(@PathVariable("id") int id) {
        return wholesalerRepository.deleteWholesaler(id);
    }
}
