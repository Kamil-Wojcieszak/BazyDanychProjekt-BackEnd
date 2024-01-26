package com.BazyDanych2Projekt.BazyDanychProjekt.Underwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/underwear")
public class UnderwearController {

    @Autowired
    UnderwearRepository underwearRepository;

    @GetMapping("/test")
    public String test() {
        return "{test:\"It works\"}";
    }

    @GetMapping("/")
    public List<Underwear> getUnderwear() {
        return underwearRepository.getUnderwearList();
    }

    @GetMapping("/{id}")
    public List<Underwear> getById(@PathVariable("id") int id) {
        return underwearRepository.getUnderwearById(id);
    }

    @PostMapping("/")
    public String add(@RequestBody List<Underwear> underwear) {
        System.out.println(underwear);
        return underwearRepository.saveUnderwear(underwear);
    }

    @PutMapping("/{id}")
    public String fullyUpdateUnderwear(@PathVariable("id") int id, @RequestBody Underwear updatedUnderwear) {
        Underwear underwear = underwearRepository.getUnderwearById(id).get(0);

        if (underwear != null) {
            underwear.setUnderwear_id(updatedUnderwear.getUnderwear_id());
            underwear.setUnderwear_model_id(updatedUnderwear.getUnderwear_model_id());
            underwear.setSize(updatedUnderwear.getSize());
            underwear.setColor(updatedUnderwear.getColor());
            underwear.setSku(updatedUnderwear.getSku());
            underwear.setEan(updatedUnderwear.getEan());
            underwear.setQuantity(updatedUnderwear.getQuantity());
            underwear.setPrice(updatedUnderwear.getPrice());

            underwearRepository.updateUnderwear(underwear);

            return "SUCCESS";
        } else {
            return "ERROR";
        }
    }

    @PatchMapping("/{id}")
    public String updateUnderwear(@PathVariable("id") int id, @RequestBody Underwear updatedUnderwear) {
        Underwear underwear = underwearRepository.getUnderwearById(id).get(0);

        if (underwear != null) {
            if (updatedUnderwear.getUnderwear_model_id() > 0) {
                underwear.setUnderwear_model_id(updatedUnderwear.getUnderwear_model_id());
            }

            if (updatedUnderwear.getSize() != null) {
                underwear.setSize(updatedUnderwear.getSize());
            }

            if (updatedUnderwear.getColor() != null) {
                underwear.setColor(updatedUnderwear.getColor());
            }

            if (updatedUnderwear.getSku() != null) {
                underwear.setSku(updatedUnderwear.getSku());
            }

            if (updatedUnderwear.getEan() != null) {
                underwear.setEan(updatedUnderwear.getEan());
            }

            if (updatedUnderwear.getQuantity() > 0) {
                underwear.setQuantity(updatedUnderwear.getQuantity());
            }

            if (updatedUnderwear.getPrice() > 0) {
                underwear.setPrice(updatedUnderwear.getPrice());
            }

            underwearRepository.updateUnderwear(underwear);

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
