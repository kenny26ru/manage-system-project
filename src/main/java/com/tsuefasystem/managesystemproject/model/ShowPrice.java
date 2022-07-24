package com.tsuefasystem.managesystemproject.model;

import com.tsuefasystem.managesystemproject.enums.Duration;
import com.tsuefasystem.managesystemproject.enums.Price;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ShowPrice {

    private int id;
    private Price price;
    private Duration duration;
}
