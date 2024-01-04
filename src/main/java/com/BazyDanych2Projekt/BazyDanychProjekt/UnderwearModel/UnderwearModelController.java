package com.BazyDanych2Projekt.BazyDanychProjekt.UnderwearModel;

import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.Underwear;
import com.BazyDanych2Projekt.BazyDanychProjekt.Underwear.UnderwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/underwear-model")
public class UnderwearModelController {

    @Autowired
    UnderwearModelRepository underwearModelRepository;

    @GetMapping("/list")
    public List<UnderwearModel> getUnderwearModelList() {
        return underwearModelRepository.getUnderwearModelList();
    }

    @GetMapping("/{id}")
    public UnderwearModel getUnderwearModelById(@PathVariable("id") int id) {
        return underwearModelRepository.getUnderwearModelById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUnderwearModel(@PathVariable("id") int id) {
        return underwearModelRepository.deleteUnderwearModel(id);
    }
}
