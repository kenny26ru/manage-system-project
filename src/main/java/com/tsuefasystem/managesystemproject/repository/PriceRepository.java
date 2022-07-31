package com.tsuefasystem.managesystemproject.repository;

import com.tsuefasystem.managesystemproject.model.Show;
import com.tsuefasystem.managesystemproject.model.ShowPrice;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PriceRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PriceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ShowPrice> findAll() {
        String query = "SELECT * FROM tsuefa_schema.show_price";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(ShowPrice.class));
    }

    public List<ShowPrice> findByShowId(UUID showId) {
        String query = "SELECT * FROM tsuefa_schema.show_price WHERE show_id = '" + showId + "';";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ShowPrice.class));
    }
}
