package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.ResultsRecord;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcResultsDao implements ResultsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcResultsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean create(ResultsRecord resultsRecord) {
        String sql = "Insert Into Results (name, price, type) " +
                "Values (?, ?, ?) " +
                "Returning item_id;";
        try{
            Integer result = jdbcTemplate.queryForObject(sql, Integer.class, resultsRecord.getName(), resultsRecord.getPrice(), resultsRecord.getType());
            return true;
        }catch (DataAccessException e)
        {
            return false;
        }
    }

    @Override
    public ResultsRecord retrieve(int resultID) {
        return null;
    }

    @Override
    public boolean update(ResultsRecord resultsRecord) {
        return false;
    }

    @Override
    public boolean delete(int resultID) {
        return false;
    }
}
