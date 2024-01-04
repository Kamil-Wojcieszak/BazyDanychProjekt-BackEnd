package com.BazyDanych2Projekt.BazyDanychProjekt.Underwear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Underwear {
    private int underwear_id;
    private int underwear_model_id;
    private String size;
    private String color;
    private String sku;
    private String ean;
    private int quantity;
    private float price;
}
