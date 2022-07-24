package com.tsuefasystem.managesystemproject.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {

    private UUID orderId;
    private String nameClient;
    private String phone;
    private Date dateOrder;
    private DateShow dateShow;
    private int price;
    private String comment;
    private Contents contents;
}
