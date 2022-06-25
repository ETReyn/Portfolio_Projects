package com.database.stuff.DAO;

import com.database.stuff.Model.HappinessData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcHappinessDao implements HappinessDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcHappinessDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public HappinessData getCountryData(int happiness_id) {
        HappinessData data = null;
        String sql = "Select * " +
                "From happiness " +
                "Where id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, happiness_id);
        if(result.next())
        {
            data = mapToHappiness(result);
        }
        return data;
    }

    @Override
    public List<HappinessData> getAllReports() {
        List<HappinessData> data = new ArrayList<>();
        String sql = "Select * " +
                "From happiness;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappiness(result));
        }
        return data;
    }


    @Override
    public HappinessData createHappinessData(HappinessData data) {
        String sql = "Insert Into happiness (country_name, total_score, dystopia, residual, gdp, corruption, life_expectancy, social_support, generosity, personal_autonomy) " +
                "Values(?,?,?,?,?,?,?,?,?,?) Returning id;";
        Integer newInt = jdbcTemplate.queryForObject(sql, Integer.class, data.getCountry_name(), data.getTotal_score(), data.getDystopia(), data.getResidual(),
                data.getGdp(), data.getCorruption(), data.getLife_expectancy(), data.getSocial_support(), data.getGenerosity(), data.getPersonal_autonomy());
        return getCountryData(newInt);
    }

    @Override
    public void deleteData(int happiness_id) {
        String sql = "Delete From happiness " +
                "Where id = ?;";
        jdbcTemplate.update(sql, happiness_id);
    }

    @Override
    public void updateData(HappinessData data) {
        String sql = "Update happiness " +
                "Set country_name = ?, total_score = ?, dystopia = ?, residual = ?, gdp = ?, corruption = ?, life_expectancy = ?, social_support = ?, generosity = ?, personal_autonomy = ? " +
                "Where id = ?;";
        jdbcTemplate.update(sql, data.getCountry_name(), data.getTotal_score(), data.getDystopia(), data.getResidual(),
                data.getGdp(), data.getCorruption(), data.getLife_expectancy(), data.getSocial_support(), data.getGenerosity(),
                data.getPersonal_autonomy(), data.getId());
    }

    private HappinessData mapToHappiness(SqlRowSet result)
    {
        HappinessData happiness = new HappinessData();
        happiness.setCorruption(result.getDouble("corruption"));
        happiness.setGdp(result.getDouble("gdp"));
        happiness.setResidual(result.getDouble("residual"));
        happiness.setLife_expectancy(result.getDouble("life_expectancy"));
        happiness.setSocial_support(result.getDouble("social_support"));
        happiness.setGenerosity(result.getDouble("generosity"));
        happiness.setPersonal_autonomy(result.getDouble("personal_autonomy"));
        happiness.setId(result.getInt("id"));
        happiness.setCountry_name(result.getString("country_name"));
        happiness.setTotal_score(result.getDouble("total_score"));
        return happiness;
    }

    public void updateResidualAndDystopia()
    {
        String sql = "Select * " +
                "From happiness";
        List<HappinessData> newList = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            newList.add(mapToHappiness(result));
        }
        for(HappinessData data : newList)
        {
            data.setResidual(data.getDystopia() - 1.83);
            data.setDystopia(1.83);
            updateData(data);
        }
    }

    public void updateIDs()
    {
        String sql = "Select * " +
                "From happiness;";
        List<HappinessData> data = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappiness(result));
        }
        for(HappinessData newData : data)
        {
            sql = "Update happiness_percentage " +
                    "Set id = ? " +
                    "Where country_name = ?;";
            jdbcTemplate.update(sql,newData.getId(), newData.getCountry_name());
        }
    }

}
