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
    public HappinessData getCountryData(int happiness_id, String table) {
        HappinessData data = null;
        String sql = "Select * " +
                "From "+table+" " +
                "Where id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, happiness_id);
        if(result.next())
        {
            data = mapToHappiness(result);
        }
        return data;
    }

    @Override
    public List<HappinessData> getAllReports(String table) {
        List<HappinessData> data = new ArrayList<>();
        String sql = "Select * " +
                "From "+table+";";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappiness(result));
        }
        return data;
    }


    @Override
    public HappinessData createHappinessData(HappinessData data, String table) {
        String sql = "Insert Into "+table+"  (country_name, total_score, dystopia, residual, gdp, corruption, life_expectancy, social_support, generosity, personal_autonomy) " +
                "Values(?,?,?,?,?,?,?,?,?,?) Returning id;";
        Integer newInt = jdbcTemplate.queryForObject(sql, Integer.class, data.getCountry_name(), data.getTotal_score(), data.getDystopia(), data.getResidual(),
                data.getGdp(), data.getCorruption(), data.getLife_expectancy(), data.getSocial_support(), data.getGenerosity(), data.getPersonal_autonomy());
        return getCountryData(newInt, table);
    }

    @Override
    public void deleteData(int happiness_id, String table) {
        String sql = "Delete From "+table+" " +
                "Where id = ?;";
        jdbcTemplate.update(sql, happiness_id);
    }

    @Override
    public void updateData(HappinessData data, String table) {
        String sql = "Update "+table+" " +
                "Set country_name = ?, total_score = ?, dystopia_residual = ?, gdp = ?, corruption = ?, life_expectancy = ?, social_support = ?, generosity = ?, personal_autonomy = ? " +
                "Where id = ?;";
        jdbcTemplate.update(sql, data.getCountry_name(), data.getTotal_score(), data.getResidual(),
                data.getGdp(), data.getCorruption(), data.getLife_expectancy(), data.getSocial_support(), data.getGenerosity(),
                data.getPersonal_autonomy(), data.getId());
    }

    private HappinessData mapToHappiness(SqlRowSet result)
    {
        HappinessData happiness = new HappinessData();
        happiness.setCorruption(result.getDouble("corruption"));
        happiness.setGdp(result.getDouble("gdp"));
        happiness.setDystopia(result.getDouble("pure_dystopia"));
        happiness.setResidual(result.getDouble("dystopia_residual"));
        happiness.setLife_expectancy(result.getDouble("life_expectancy"));
        happiness.setSocial_support(result.getDouble("social_support"));
        happiness.setGenerosity(result.getDouble("generosity"));
        happiness.setPersonal_autonomy(result.getDouble("personal_autonomy"));
        happiness.setId(result.getInt("id"));
        happiness.setCountry_name(result.getString("country_name"));
        happiness.setTotal_score(result.getDouble("total_score"));
        return happiness;
    }

    public void updateResidualAndDystopia(String tableName)
    {
        String sql = "Select * " +
                "From "+tableName+";";
        List<HappinessData> newList = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            newList.add(mapToHappiness(result));
        }
        for(HappinessData data : newList)
        {
            data.setResidual(data.getResidual() - data.getDystopia());
            updateData(data, tableName);
        }
    }

    public void updateIDs(String tableName, String percentName)
    {
        String sql = "Select * " +
                "From "+tableName+";";
        List<HappinessData> data = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappiness(result));
        }
        for(HappinessData newData : data)
        {
            sql = "Update "+percentName+" " +
                    "Set id = ? " +
                    "Where country_name = ?;";
            jdbcTemplate.update(sql,newData.getId(), newData.getCountry_name());
        }
    }

}
