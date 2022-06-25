package com.database.stuff;

import com.database.stuff.DAO.JdbcHappinessDao;
import com.database.stuff.Model.HappinessData;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportData {


    public ImportData() {
    }

    public static void main(String[] args) {
        ImportData iD = new ImportData();
        //iD.importData();
        //iD.putPercentagesInDatabase();
    }

    public void importData() {
        File fileName = new File("HappinessData.csv");
        try (Scanner reader = new Scanner(fileName)) {
            while (reader.hasNextLine()) {
                putImportsInMap(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }

    public void putImportsInMap(String line) {
        String data;
        String[] columnName = {"country_name", "total_score", "dystopia", "gdp", "social_support", "life_expectancy", "personal_autonomy", "generosity", "corruption"};
        File newFile;
        String[] newLine = line.split(",");
        String val = "Insert Into happiness (" + columnName[0];
        for (int i = 1; i < columnName.length; i++) {
            val = val + ", " + columnName[i];
        }
        val = val + ") ";
        String val1 = "Values('" + newLine[1] + "'";
        for (int i = 4; i < newLine.length; i++) {
            val1 = val1 + ", " + newLine[i];
        }
        val1 = val1 + ");";
        newFile = new File("happiness.sql");
        try {
            PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
            temp.println(val + val1);
            temp.flush();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public void putPercentagesInDatabase()
    {
        File newFile = new File("happiness_percentage.sql");
        List<HappinessData> data = new ArrayList<>();
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/happiness");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        JdbcHappinessDao imports = new JdbcHappinessDao(dataSource);
        data = imports.getAllReports();
        for(HappinessData result : data) {
            System.out.println(result.getCountry_name());
            double whole = (result.getTotal_score() - result.getDystopia()) / 100;
            String[] columnName = {"country_name", "total_score", "residual_percent", "gdp_percent", "social_support_percent", "life_expectancy_percent", "personal_autonomy_percent", "generosity_percent", "corruption_percent"};
            String val = "Insert Into happiness_percentage (" + columnName[0];
            for (int i = 1; i < columnName.length; i++) {
                val = val + ", " + columnName[i];
            }
            val = val + ") ";
            String val1 = "Values('" + result.getCountry_name()+"'";
            val1 = val1 +", "+result.getTotal_score();
            val1 = val1 +", "+(result.getResidual()/whole);
            val1 = val1 +", "+(result.getGdp()/whole);
            val1 = val1 +", "+(result.getSocial_support()/whole);
            val1 = val1 +", "+(result.getLife_expectancy()/whole);
            val1 = val1 +", "+(result.getPersonal_autonomy()/whole);
            val1 = val1 +", "+(result.getGenerosity()/whole);
            val1 = val1 +", "+(result.getCorruption()/whole);
            val1 = val1 + ");";
            try {
                PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
                temp.println(val + val1);
                temp.flush();
            } catch (IOException e) {
                System.out.println("Unable to write to file");
            }
        }
    }

}
