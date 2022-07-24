package com.tsuefasystem.managesystemproject.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Contents {

    private boolean operator;
    private List<Show> shows;
    private List<Animator> animators;
}
