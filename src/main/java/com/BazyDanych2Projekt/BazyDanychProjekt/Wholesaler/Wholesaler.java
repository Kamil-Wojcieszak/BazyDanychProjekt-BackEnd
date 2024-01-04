package com.BazyDanych2Projekt.BazyDanychProjekt.Wholesaler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wholesaler {
    private int wholesaler_id;
    private String name;
    private int address_id;
}
