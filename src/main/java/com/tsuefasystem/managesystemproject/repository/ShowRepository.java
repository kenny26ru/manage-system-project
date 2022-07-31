package com.tsuefasystem.managesystemproject.repository;

import com.tsuefasystem.managesystemproject.exception.ShowQueryException;
import com.tsuefasystem.managesystemproject.model.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShowRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ShowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Show> findAll() {
        String query = "SELECT * FROM tsuefa_schema.programs_show";
        List<Show> showList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Show.class));
        return showList;
    }

    public Show findByName(String name) {
        String query = "SELECT * FROM tsuefa_schema.programs_show WHERE show_name= '" + name + "';";
        Show show = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Show.class));
        return show;
    }

    public List<Show> findAllByCategory(String category) {
        String query = "SELECT * FROM tsuefa_schema.programs_show WHERE category= '" + category + "';";
        List<Show> showList = jdbcTemplate.query(query, new BeanPropertyRowMapper(Show.class));
        return showList;
    }

    public List<Show> findByNumber(int number) throws ShowQueryException {
        if (number <= 0 || number > 23) {
            throw new ShowQueryException(String.format("Введено некорректное значение количества элементов {n = %s}", number));
        }
        String query = "SELECT * FROM tsuefa_schema.programs_show LIMIT(" + number + ");";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Show.class));
    }
}
