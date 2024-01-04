package com.BazyDanych2Projekt.BazyDanychProjekt.ShopsWithAddresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopsWithAddresses {
    private int store_id;
    private String city;
    private String street;
    private String post_code;
    private String building_number;
    private String unit_number;
}
