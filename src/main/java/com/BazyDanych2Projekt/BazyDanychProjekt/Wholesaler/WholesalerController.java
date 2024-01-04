package com.BazyDanych2Projekt.BazyDanychProjekt.Wholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wholesaler")
public class WholesalerController {

    @Autowired
    WholesalerRepository wholesalerRepository;


}
