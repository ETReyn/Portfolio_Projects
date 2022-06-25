package com.database.stuff;

import com.database.stuff.DAO.JdbcHappinessDao;
import com.database.stuff.Model.HappinessData;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportData {

    private String importFileName;
    private String tableName;
    private String tableNamePercentage;
    private JdbcHappinessDao imports;
    private BasicDataSource dataSource = new BasicDataSource();
    private final JdbcTemplate jdbcTemplate;



    public ImportData(String fileName, String tableName) {
        this.importFileName = fileName + ".csv";
        this.tableName = tableName + ".sql";
        tableNamePercentage = tableName + "-percentage.sql";
        dataSource.setUrl("jdbc:postgresql://localhost:5432/happiness");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        imports = new JdbcHappinessDao(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void importData() {
        File fileName = new File(importFileName);

        try (Scanner reader = new Scanner(fileName)) {
            if(reader.hasNextLine())
            {
                reader.nextLine();
            }
            while (reader.hasNextLine()) {
                putImportsInDatabase(reader.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        printFooter(tableName);
        //To create a table use a jdbc update and feed in the
    }

    public void putImportsInDatabase(String line) {
        String[] columnName = {"country_name", "total_score", "dystopia_residual", "gdp", "social_support", "life_expectancy", "personal_autonomy", "generosity", "corruption", "pure_dystopia"};
        File newFile;
        newFile = new File(tableName);
        String[] newLine = line.split(",");
        String val = "Insert Into "+tableName.substring(0, tableName.length() - 4)+" (" + columnName[0];
        for (int i = 1; i < columnName.length; i++) {
            val = val + ", " + columnName[i];
        }
        val = val + ") ";
        String val1 = "Values('" + newLine[1] + "'";
        for (int i = 4; i < newLine.length; i++) {
            val1 = val1 + ", " + newLine[i];
        }
        val1 = val1 + ");";
        try {
            PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
            temp.println(val + val1);
            temp.flush();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }

    }

    public void printHeader() {

        File newFile = new File(tableName);
        String val = "Start Transaction;\n" +
                "\n" +
                "Drop Table If Exists "+tableName.substring(0, tableName.length() - 4)+";\n" +
                "\n" +
                "Create Table "+tableName.substring(0, tableName.length() - 4)+"(\n" +
                "\n" +
                "    id serial,\n" +
                "    country_name varchar(50),\n" +
                "    total_score numeric(5,3), \n" +
                "    dystopia_residual numeric(5,3), \n" +
                "    gdp numeric(5,3), \n" +
                "    corruption numeric(5,3), \n" +
                "    life_expectancy numeric(5,3), \n" +
                "    personal_autonomy numeric(5,3), \n" +
                "    social_support numeric(5,3), \n" +
                "    generosity numeric(5,3), \n" +
                "    pure_dystopia numeric(5,3)\n" +
                "\n" +
                ");";
        try {
            PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
            temp.println(val);
            temp.flush();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public void printHeaderForPercentage() {
        File newFile = new File(tableNamePercentage);
        String val = "Start Transaction;\n" +
                "\n" +
                "Drop Table If Exists "+tableNamePercentage.substring(0, tableNamePercentage.length()-4)+";\n" +
                "\n" +
                "Create Table "+tableNamePercentage.substring(0, tableNamePercentage.length()-4)+"(\n" +
                "\n" +
                "    id serial,\n" +
                "    country_name varchar(50),\n" +
                "    total_score numeric(6,3), \n" +
                "    residual_percent numeric(6,3), \n" +
                "    gdp_percent numeric(6,3), \n" +
                "    corruption_percent numeric(6,3), \n" +
                "    life_expectancy_percent numeric(6,3), \n" +
                "    social_support_percent numeric(6,3), \n" +
                "    generosity_percent numeric(6,3), \n" +
                "    personal_autonomy_percent numeric(6,3)\n" +
                "\n" +
                ");";
        try {
            PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
            temp.println(val);
            temp.flush();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public void printFooter(String fileType) {
        File newFile = new File(fileType);
        try {
            PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
            temp.println("Commit;");
            temp.flush();
        } catch (IOException e) {
            System.out.println("Unable to write to file");
        }
    }

    public void putPercentagesInDatabase() {
        File newFile = new File(tableNamePercentage);
        List<HappinessData> data = new ArrayList<>();

        data = imports.getAllReports(tableNamePercentage);
        for (HappinessData result : data) {
            System.out.println(result.getCountry_name());
            double whole = (result.getTotal_score() - result.getDystopia()) / 100;
            String[] columnName = {"country_name", "total_score", "residual_percent", "gdp_percent", "social_support_percent", "life_expectancy_percent", "personal_autonomy_percent", "generosity_percent", "corruption_percent"};
            String val = "Insert Into "+tableNamePercentage.substring(0, tableNamePercentage.length()-4)+" (" + columnName[0];
            for (int i = 1; i < columnName.length; i++) {
                val = val + ", " + columnName[i];
            }
            val = val + ") ";
            String val1 = "Values('" + result.getCountry_name() + "'";
            val1 = val1 + ", " + result.getTotal_score();
            val1 = val1 + ", " + (result.getResidual() / whole);
            val1 = val1 + ", " + (result.getGdp() / whole);
            val1 = val1 + ", " + (result.getSocial_support() / whole);
            val1 = val1 + ", " + (result.getLife_expectancy() / whole);
            val1 = val1 + ", " + (result.getPersonal_autonomy() / whole);
            val1 = val1 + ", " + (result.getGenerosity() / whole);
            val1 = val1 + ", " + (result.getCorruption() / whole);
            val1 = val1 + ");";
            try {
                PrintWriter temp = new PrintWriter(new FileWriter(newFile, true));
                temp.println(val + val1);
                temp.flush();
            } catch (IOException e) {
                System.out.println("Unable to write to file");
            }
        }
        printFooter(tableNamePercentage);
    }

}
