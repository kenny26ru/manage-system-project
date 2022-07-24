package com.tsuefasystem.managesystemproject.model;


import com.tsuefasystem.managesystemproject.enums.AnimatorsName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class Animator {

    private UUID animatorId;
    // анматоры / ростовые
    private String category;
    private AnimatorsName animatorsName;
}
