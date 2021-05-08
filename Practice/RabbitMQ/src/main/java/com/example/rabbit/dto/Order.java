package com.example.rabbit.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    public String orderId;
    public String name;
    public int qty;
    public int price;
}
