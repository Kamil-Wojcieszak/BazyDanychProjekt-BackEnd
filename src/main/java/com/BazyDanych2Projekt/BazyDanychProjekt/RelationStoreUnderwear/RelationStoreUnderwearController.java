package com.BazyDanych2Projekt.BazyDanychProjekt.RelationStoreUnderwear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relation-store-underwear")
public class RelationStoreUnderwearController {

    @Autowired
    RelationStoreUnderwearRepository relationStoreUnderwearRepository;

    @GetMapping("/list")
    public List<RelationStoreUnderwear> getRelationStoreUnderwearList() {
        return relationStoreUnderwearRepository.getRelationStoreUnderwearList();
    }

    @PostMapping("/add")
    public String addRelationStoreUnderwear(List<RelationStoreUnderwear> relationStoreUnderwear) {
        return relationStoreUnderwearRepository.addRelationStoreUnderwear(relationStoreUnderwear);
    }

    @DeleteMapping("/{id}-store")
    public String deleteRelationStoreUnderwearByStoreId(@PathVariable("id") int id) {
        return relationStoreUnderwearRepository.deleteRelationStoreUnderwearByStoreId(id);
    }

    @DeleteMapping("/{id}-underwear")
    public String deleteRelationStoreUnderwearByUnderwearId(@PathVariable("id") int id) {
        return relationStoreUnderwearRepository.deleteRelationStoreUnderwearByUnderwearId(id);
    }
}
