package com.BazyDanych2Projekt.BazyDanychProjekt.OrderOnline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderOnline {
    private int order_on_id;
    private float totality;
    private String email;
    private Date date;
    private int phone_number;
    private String status;
}
