package com.BazyDanych2Projekt.BazyDanychProjekt.RelationStoreWholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("relation-store-wholesaler")
public class RelationStoreWholesalerController {

    @Autowired
    RelationStoreWholesalerRepository relationStoreWholesalerRepository;

    @GetMapping("/list")
    public List<RelationStoreWholesaler> getRelationStoreWholesalerList() {
        return relationStoreWholesalerRepository.getRelationStoreWholesalerList();
    }

    @PostMapping("/add")
    public String addRelationStoreWholesaler(List<RelationStoreWholesaler> relationStoreWholesaler) {
        return relationStoreWholesalerRepository.addRelationStoreWholesaler(relationStoreWholesaler);
    }

    @DeleteMapping("/{id}-store")
    public String deleteRelationStoreWholesalerByStoreId(@PathVariable("id") int id) {
        return relationStoreWholesalerRepository.deleteRelationStoreWholesalerByStoreId(id);
    }

    @DeleteMapping("/{id}-wholesaler")
    public String deleteRelationStoreWholesalerByWholesalerId(@PathVariable("id") int id) {
        return relationStoreWholesalerRepository.deleteRelationStoreWholesalerByWholesalerId(id);
    }
}
