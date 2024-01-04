package com.BazyDanych2Projekt.BazyDanychProjekt.OrderStationary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStationary {
    private int order_st_id;
    private float totality;
    private Date date;
}
