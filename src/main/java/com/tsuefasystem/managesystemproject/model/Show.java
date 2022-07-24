package com.tsuefasystem.managesystemproject.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Show {

    @Id
    private UUID id;
    private String category;
    private String showName;

    private ShowPrice showPrice;
}