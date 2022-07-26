package com.tsuefasystem.managesystemproject.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@RequiredArgsConstructor
public class DateShow {

    private LocalDate day;
    private LocalTime time;
}
