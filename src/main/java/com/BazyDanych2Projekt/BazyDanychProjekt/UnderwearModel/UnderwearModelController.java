package com.BazyDanych2Projekt.BazyDanychProjekt.UnderwearModel;

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

    @PostMapping("/add")
    public String addReport(@RequestBody List<UnderwearModel> underwearModels) {
        return underwearModelRepository.saveUnderwearModels(underwearModels);
    }

    @PatchMapping("/{id}")
    public String updateUnderwearModel(@PathVariable("id") int id, @RequestBody UnderwearModel updatedUnderwearModel) {
        UnderwearModel underwearModel = underwearModelRepository.getUnderwearModelById(id);

        if (underwearModel != null) {
            if (updatedUnderwearModel.getCategory() != null) {
                underwearModel.setCategory(updatedUnderwearModel.getCategory());
            }

            if (updatedUnderwearModel.getName() != null) {
                underwearModel.setName(updatedUnderwearModel.getName());
            }

            if (updatedUnderwearModel.getMark() != null) {
                underwearModel.setMark(updatedUnderwearModel.getMark());
            }

            underwearModelRepository.updateUnderwearMoedl(underwearModel);

            return "Success!";
        } else {
            return "Error";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUnderwearModel(@PathVariable("id") int id) {
        return underwearModelRepository.deleteUnderwearModel(id);
    }
}
