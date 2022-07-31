package com.tsuefasystem.managesystemproject.services;

import com.tsuefasystem.managesystemproject.model.dto.ShowDto;
import com.tsuefasystem.managesystemproject.services.impl.ShowServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShowServiceTest {

    @Autowired
    private ShowServiceImpl service;
    
    @Test
    void test_get_all() {
        List<ShowDto> dtoList = service.getAllShow();
        System.out.println(List.of(dtoList));
        ShowDto dto = dtoList.stream()
                .filter(d -> d.getShowName().equals("Шпионский квест"))
                .findFirst().get();
        assertEquals(2, dto.getPriceList().size());
    }
}
