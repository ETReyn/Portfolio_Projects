package com.database.stuff.DAO;

import com.database.stuff.Model.HappinessData;
import com.database.stuff.Model.HappinessPercentageData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcHappinessPercentageDao implements HappinessPercentageDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcHappinessPercentageDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public HappinessPercentageData getCountryData(int happiness_id, String table) {
        HappinessPercentageData data = null;
        String sql = "Select * " +
                "From " +table+"" +
                "Where id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, happiness_id);
        if(result.next())
        {
            data = mapToHappinessPercentage(result);
        }
        return data;    }

    @Override
    public List<HappinessPercentageData> getAllReports(String table) {
        List<HappinessPercentageData> data = new ArrayList<>();
        String sql = "Select * " +
                "From " +table+";";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappinessPercentage(result));
        }
        return data;
    }

    public List<HappinessPercentageData> getReportsForNegativeResidual(String table) {
        List<HappinessPercentageData> data = new ArrayList<>();
        String sql = "Select * " +
                "From "+table+" " +
                "Where residual_percent < -9.9;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappinessPercentage(result));
        }
        return data;
    }

    public List<HappinessPercentageData> getReportsForTopHappy(String table) {
        List<HappinessPercentageData> data = new ArrayList<>();
        String sql = "Select * " +
                "From "+table+" " +
                "Limit 10";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappinessPercentage(result));
        }
        return data;
    }

    public List<HappinessPercentageData> getReportsForTopSad(String table) {
        List<HappinessPercentageData> data = new ArrayList<>();
        String sql = "Select * " +
                "From "+table+" " +
                "Order By total_score Desc " +
                "Limit 10;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappinessPercentage(result));
        }
        return data;
    }

    public List<HappinessPercentageData> getReportsForMassivelyPositiveResidual(String table) {
        List<HappinessPercentageData> data = new ArrayList<>();
        String sql = "Select * " +
                "From "+table+" " +
                "Where residual_percent > 9.9;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next())
        {
            data.add(mapToHappinessPercentage(result));
        }
        return data;
    }

    @Override
    public HappinessPercentageData createHappinessData(HappinessPercentageData data, String table) {
        String sql = "Insert Into "+table+" (country_name, total_score, residual_percent, gdp_percent, corruption_percent, life_expectancy_percent, social_support_percent, generosity_percent, personal_autonomy_percent) " +
                "Values(?,?,?,?,?,?,?,?,?) Returning id;";
        Integer newInt = jdbcTemplate.queryForObject(sql, Integer.class, data.getCountry_name(), data.getTotal_score(), data.getResidual_percentage(),
                data.getGdp_percentage(), data.getCorruption_percentage(), data.getLife_expectancy_percentage(), data.getSocial_support_percentage(),
                data.getGenerosity_percentage(), data.getPersonal_autonomy_percentage());
        return getCountryData(newInt, table);    }

    @Override
    public void deleteData(int happiness_id, String table) {
        String sql = "Delete From "+table+" " +
                "Where id = ?;";
        jdbcTemplate.update(sql, happiness_id);
    }

    @Override
    public void updateData(HappinessPercentageData data, String table) {
        String sql = "Update "+table+" " +
                "Set country_name = ?, total_score = ?, residual_percent = ?, gdp_percent = ?, corruption_percent = ?, life_expectancy_percent = ?, social_support_percent = ?, generosity_percent = ?, personal_autonomy_percent = ? " +
                "Where id = ?;";
        jdbcTemplate.update(sql, data.getCountry_name(), data.getTotal_score(), data.getResidual_percentage(),
                data.getGdp_percentage(), data.getCorruption_percentage(), data.getLife_expectancy_percentage(),
                data.getSocial_support_percentage(), data.getGenerosity_percentage(), data.getPersonal_autonomy_percentage(), data.getId());
    }

    private HappinessPercentageData mapToHappinessPercentage(SqlRowSet result)
    {
        HappinessPercentageData happiness = new HappinessPercentageData();
        happiness.setResidual_percentage(result.getDouble("residual_percent"));
        happiness.setLife_expectancy_percentage(result.getDouble("life_expectancy_percent"));
        happiness.setSocial_support_percentage(result.getDouble("social_support_percent"));
        happiness.setGenerosity_percentage(result.getDouble("generosity_percent"));
        happiness.setPersonal_autonomy_percentage(result.getDouble("personal_autonomy_percent"));
        happiness.setId(result.getInt("id"));
        happiness.setGdp_percentage(result.getDouble("gdp_percent"));
        happiness.setCorruption_percentage(result.getDouble("corruption_percent"));
        happiness.setTotal_score(result.getDouble("total_score"));
        happiness.setCountry_name(result.getString("country_name"));
        return happiness;
    }
}
