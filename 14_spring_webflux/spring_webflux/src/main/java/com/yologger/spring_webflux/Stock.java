package com.yologger.spring_webflux;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Stock {
    private String name;
    private int amount;
    private int price;
    private Date date;
}
