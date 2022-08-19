package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.LocationRecord;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcLocationDao implements LocationDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcLocationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(LocationRecord locationRecord) {
        String sql = "Insert Into location (address, county) Values(? ?) Returning location_id;";
        try {
            int result = jdbcTemplate.queryForObject(sql, Integer.class, locationRecord.getAddress(), locationRecord.getCounty());
            return true;
        }
        catch(DataAccessException | NullPointerException e)
        {
            return false;
        }
    }

    @Override
    public LocationRecord retrieve(int locationID) {

        LocationRecord locationRecord = null;
        String sql = "Select county, address " +
                "From location " +
                "Where location_id = ?;";
        try{
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, locationID);
            if(result.next())
            {
                locationRecord = mapToLocation(result);
            }
            return locationRecord;
        } catch (Exception e)
        {
            return null;
        }
    }

    private LocationRecord mapToLocation(SqlRowSet result)
    {
        return new LocationRecord(result.getString("address"), result.getString("county"));
    }

    @Override
    public boolean delete(int locationID) {
        return false;
    }
}
