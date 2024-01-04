package com.BazyDanych2Projekt.BazyDanychProjekt.UnderwearModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnderwearModel {
    private int underwear_mod_id;
    private String category;
    private String name;
    private String mark;
}
