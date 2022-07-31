package com.tsuefasystem.managesystemproject.services;

import com.tsuefasystem.managesystemproject.model.dto.ShowDto;

import java.util.List;

public interface ShowService {

    List<ShowDto> getAllShow();
    List<ShowDto> getShowsOfCategory(String category);
}
