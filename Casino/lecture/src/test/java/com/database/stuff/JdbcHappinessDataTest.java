package com.database.stuff;

import com.database.stuff.DAO.JdbcHappinessDao;
import com.database.stuff.Model.HappinessData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JdbcHappinessDataTest extends BaseDaoTests{
    private JdbcHappinessDao sut;
    private final HappinessData data = new HappinessData();

    @Before
    public void setup() {
        sut = new JdbcHappinessDao(dataSource);
        data.setCountry_name("Finland");
        data.setId(1);
        data.setTotal_score(7.756);
        data.setGdp(1.892);
        data.setSocial_support(1.258);
        data.setLife_expectancy(0.775);
        data.setPersonal_autonomy(0.736);
        data.setGenerosity(0.109);
        data.setCorruption(0.534);
    }

    @Test
    public void test_using_country_id_returns_correct_value()
    {
        HappinessData result = sut.getCountryData(1);
        Assert.assertEquals(data.toString(), result.toString());

    }

    @Test
    public void test_using_country_id_returns_null_when_unable_to_find_value()
    {
        HappinessData result = sut.getCountryData(-10);
        Assert.assertNull(result);
    }

    @Test
    public void get_reports_returns_all_records()
    {
        List<HappinessData> result = sut.getAllReports();

        Assert.assertNotNull(result);
        Assert.assertEquals(16, result.size());
        Assert.assertEquals("Denmark", result.get(1).getCountry_name());
        Assert.assertEquals("Australia", result.get(11).getCountry_name());
        Assert.assertEquals("Luxembourg*", result.get(5).getCountry_name());
    }

    @Test
    public void create_happiness_record_returns_correct_record()
    {
        HappinessData newData = new HappinessData(0, "Country_A", 5.0, 1.83, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2);
        HappinessData result = sut.createHappinessData(newData);
        Assert.assertEquals(result.getCountry_name(), newData.getCountry_name());
        Assert.assertEquals(result.getTotal_score(), newData.getTotal_score(), 0.001);
        Assert.assertEquals(result.getCorruption(), newData.getCorruption(), 0.001);
    }

    @Test
    public void delete_report()
    {
        sut.deleteData(1);
        Assert.assertNull(sut.getCountryData(1));
    }

    @Test
    public void update_reports()
    {
        HappinessData newData = new HappinessData(0, "Country_A", 5.0, 1.83, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2);
        HappinessData result = sut.createHappinessData(newData);

        result.setCountry_name("Country2");
        result.setCorruption(0.123);
        result.setPersonal_autonomy(0.123);
        result.setLife_expectancy(0.123);
        sut.updateData(result);
        HappinessData after = sut.getCountryData(result.getId());
        Assert.assertEquals(result.toString(), after.toString());
    }
}
