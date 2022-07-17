//package com.database.stuff;
//
//import com.database.stuff.DAO.JdbcHappinessDao;
//import com.database.stuff.DAO.JdbcHappinessPercentageDao;
//import com.database.stuff.Model.HappinessData;
//import com.database.stuff.Model.HappinessPercentageData;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class JdbcHappinessPercentageTest extends BaseDaoTests{
//    private JdbcHappinessPercentageDao sut;
//    private final HappinessPercentageData data = new HappinessPercentageData();
//
//    @Before
//    public void setup() {
//        sut = new JdbcHappinessPercentageDao(dataSource);
//        data.setCountry_name("Finland");
//        data.setId(1);
//        data.setTotal_score(7.756);
//        data.setGdp_percentage(31.927);
//        data.setResidual_percentage(11.610);
//        data.setSocial_support_percentage(21.228);
//        data.setLife_expectancy_percentage(13.078);
//        data.setPersonal_autonomy_percentage(12.420);
//        data.setGenerosity_percentage(1.839);
//        data.setCorruption_percentage(9.011);
//    }
//
//    @Test
//    public void test_using_country_id_returns_correct_value()
//    {
//        HappinessPercentageData result = sut.getCountryData(1);
//        Assert.assertEquals(data.toString(), result.toString());
//
//    }
//
//    @Test
//    public void test_using_country_id_returns_null_when_unable_to_find_value()
//    {
//        HappinessPercentageData result = sut.getCountryData(-10);
//        Assert.assertNull(result);
//    }
//
//    @Test
//    public void get_reports_returns_all_records()
//    {
//        List<HappinessPercentageData> result = sut.getAllReports();
//
//        Assert.assertNotNull(result);
//        Assert.assertEquals(15, result.size());
//        Assert.assertEquals("Denmark", result.get(1).getCountry_name());
//        Assert.assertEquals("Australia", result.get(10).getCountry_name());
//        Assert.assertEquals("Luxembourg*", result.get(4).getCountry_name());
//    }
//
//    @Test
//    public void create_happiness_record_returns_correct_record()
//    {
//        HappinessPercentageData newData = new HappinessPercentageData(0, "Country_A", 5.0, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2);
//        HappinessPercentageData result = sut.createHappinessData(newData);
//        Assert.assertEquals(result.getCountry_name(), newData.getCountry_name());
//        Assert.assertEquals(result.getTotal_score(), newData.getTotal_score(), 0.01);
//        Assert.assertEquals(result.getCorruption_percentage(), newData.getCorruption_percentage(), 0.01);
//    }
//
//    @Test
//    public void delete_report()
//    {
//        sut.deleteData(1);
//        Assert.assertNull(sut.getCountryData(1));
//    }
//
//    @Test
//    public void update_reports()
//    {
//        HappinessPercentageData newData = new HappinessPercentageData(0, "Country_A", 5.0, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2);
//        HappinessPercentageData result = sut.createHappinessData(newData);
//
//        result.setCountry_name("Country2");
//        result.setCorruption_percentage(0.123);
//        result.setPersonal_autonomy_percentage(0.123);
//        result.setLife_expectancy_percentage(0.123);
//        sut.updateData(result);
//        HappinessPercentageData after = sut.getCountryData(result.getId());
//        Assert.assertEquals(result.toString(), after.toString());
//    }
//}
