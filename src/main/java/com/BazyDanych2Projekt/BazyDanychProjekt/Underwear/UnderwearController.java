package com.BazyDanych2Projekt.BazyDanychProjekt.Underwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/underwear")
public class UnderwearController {

    @Autowired
    UnderwearRepository underwearRepository;

    @GetMapping("/test")
    public String test() {
        return "It works";
    }

    @GetMapping("/list")
    public List<Underwear> getUnderwearList() {
        return underwearRepository.getUnderwearList();
    }

    @GetMapping("/{id}")
    public Underwear getById(@PathVariable("id") int id) {
        return underwearRepository.getUnderwearById(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody List<Underwear> underwear) {
        return underwearRepository.saveUnderwear(underwear);
    }

    @PutMapping("/{id}")
    public String fullyUpdateUnderwear(@PathVariable("id") int id, @RequestBody Underwear updatedUnderwear) {
        Underwear underwear = underwearRepository.getUnderwearById(id);

        if (underwear != null) {
            underwear.setUnderwear_id(updatedUnderwear.getUnderwear_id());
            underwear.setUnderwear_model_id(updatedUnderwear.getUnderwear_model_id());
            underwear.setSize(updatedUnderwear.getSize());
            underwear.setColor(updatedUnderwear.getColor());
            underwear.setSku(updatedUnderwear.getSku());
            underwear.setEan(updatedUnderwear.getEan());
            underwear.setQuantity(updatedUnderwear.getQuantity());
            underwear.setPrice(updatedUnderwear.getPrice());

            underwearRepository.fullyUpdateUnderwear(underwear);

            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }

    @PatchMapping("/{id}")
    public String partiallyUpdateUnderwear(@PathVariable("id") int id, @RequestBody Underwear updatedUnderwear) {
        Underwear underwear = underwearRepository.getUnderwearById(id);

        if (underwear != null) {
//            if (updatedUnderwear.getUnderwear_id() > 0) {
//                underwear.setUnderwear_id(updatedUnderwear.getUnderwear_id());
//            }
//
//            if (updatedUnderwear.getUnderwear_model_id() > 0) {
//                underwear.setUnderwear_model_id(updatedUnderwear.getUnderwear_model_id());
//            }

            if (updatedUnderwear.getSize() != null) {
                underwear.setSize(updatedUnderwear.getSize());
            }

            if (updatedUnderwear.getColor() != null) {
                underwear.setColor(updatedUnderwear.getColor());
            }

            if (!updatedUnderwear.getSku().equals(underwear.getSku()) && updatedUnderwear.getSku() != null) {
                underwear.setSku(updatedUnderwear.getSku());
            }

            if (!updatedUnderwear.getEan().equals(underwear.getEan()) && updatedUnderwear.getEan() != null) {
                underwear.setEan(updatedUnderwear.getEan());
            }

            if (updatedUnderwear.getQuantity() > 0) {
                underwear.setQuantity(updatedUnderwear.getQuantity());
            }

            if (updatedUnderwear.getPrice() > 0) {
                underwear.setPrice(updatedUnderwear.getPrice());
            }

            underwearRepository.partiallyUpdateUnderwear(underwear);

            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUnderwear(@PathVariable("id") int id) {
        return underwearRepository.deleteUnderwear(id);
    }
}
