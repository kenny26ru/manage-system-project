package com.tsuefasystem.managesystemproject.services.impl;

import com.tsuefasystem.managesystemproject.model.Show;
import com.tsuefasystem.managesystemproject.model.ShowPrice;
import com.tsuefasystem.managesystemproject.model.dto.ShowDto;
import com.tsuefasystem.managesystemproject.repository.PriceRepository;
import com.tsuefasystem.managesystemproject.repository.ShowRepository;
import com.tsuefasystem.managesystemproject.services.ShowService;
import com.tsuefasystem.managesystemproject.utils.mappers.ShowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepo;
    private final PriceRepository priceRepo;
    private final ShowMapper showMapper;

    public ShowServiceImpl(ShowRepository showRepo, PriceRepository priceRepo, ShowMapper showMapper) {
        this.showRepo = showRepo;
        this.priceRepo = priceRepo;
        this.showMapper = showMapper;
    }

    @Override
    public List<ShowDto> getAllShow() {
        List<Show> showList = showRepo.findAll();
        return setPriceList(showList);
    }

    @Override
    public List<ShowDto> getShowsOfCategory(String category) {
        List<Show> showList = showRepo.findAllByCategory(category);
        return setPriceList(showList);
    }

    private List<ShowDto> setPriceList(List<Show> list) {
        List<ShowPrice> priceList = priceRepo.findAll();
        return list.stream()
                .map(show -> {
                    List<ShowPrice> listShow = priceList.stream()
                            .filter(showPrice -> showPrice.getShowId().equals(show.getId()))
                            .collect(Collectors.toList());
                    return showMapper.showToDto(show, listShow);
                })
                .collect(Collectors.toList());
    }
}
