package com.database.stuff;

import com.database.stuff.DAO.HappinessDao;
import com.database.stuff.DAO.JdbcHappinessDao;
import com.database.stuff.DAO.JdbcHappinessPercentageDao;
import com.database.stuff.Model.HappinessData;
import com.database.stuff.Model.HappinessPercentageData;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private final JdbcHappinessDao database;
    private final JdbcHappinessPercentageDao database2;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/happiness");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        DatabaseAccess dA = new DatabaseAccess(dataSource);
        System.out.println("Totals:");
        int[][] totals = dA.maxPercentage();
        System.out.println(dA.switchCases(totals));
        System.out.println("Unduly Happy:");
        int[][] undulyHappy = dA.getUndulyHappy();
        System.out.println(dA.switchCases(undulyHappy));
        System.out.println("Top Happy:");
        int[][] topHappy = dA.getTopHappy();
        System.out.println(dA.switchCases(topHappy));
        System.out.println("Unduly Sad:");
        int[][] undulySad = dA.getUndulySad();
        System.out.println(dA.switchCases(undulySad));
        System.out.println("Top Sad:");
        int[][] topSad = dA.getTopSad();
        System.out.println(dA.switchCases(topSad));
    }

    public DatabaseAccess(DataSource dataSource) {
        database = new JdbcHappinessDao(dataSource);
        database2 = new JdbcHappinessPercentageDao(dataSource);
    }

    public void run() {

    }

    public int[][] maxPercentage() {
        //List<Double> testRecords = new ArrayList<>();
        int[][] utility = new int[7][7];
        List<HappinessPercentageData> data = database2.getAllReports();
        for (int i = 0; i < data.size(); i++) {
            double[] currentData = getCurrentData(data.get(i));
            updateMatrix(utility, currentData);
        }
        return utility;
    }

    public void printUtility(int[][] utility)
    {
        for (int k = 0; k < utility.length; k++) {
            for (int j = 0; j < utility[k].length; j++) {
                System.out.print(utility[k][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getUndulySad() {
        //List<Double> testRecords = new ArrayList<>();
        int[][] utility = new int[7][7];
        List<HappinessPercentageData> data = database2.getReportsForNegativeResidual();
        for (int i = 0; i < data.size(); i++) {
            double[] currentData = getCurrentData(data.get(i));
            updateMatrix(utility, currentData);
        }
        return utility;
    }

    public int[][] getUndulyHappy() {
        //List<Double> testRecords = new ArrayList<>();
        int[][] utility = new int[7][7];
        List<HappinessPercentageData> data = database2.getReportsForMassivelyPositiveResidual();
        for (int i = 0; i < data.size(); i++) {
            double[] currentData = getCurrentData(data.get(i));
            updateMatrix(utility, currentData);
        }
        return utility;
    }

    public int[][] getTopSad() {
        //List<Double> testRecords = new ArrayList<>();
        int[][] utility = new int[7][7];
        List<HappinessPercentageData> data = database2.getReportsForTopSad();
        for (int i = 0; i < data.size(); i++) {
            double[] currentData = getCurrentData(data.get(i));
            updateMatrix(utility, currentData);
        }
        return utility;
    }

    public int[][] getTopHappy() {
        //List<Double> testRecords = new ArrayList<>();
        int[][] utility = new int[7][7];
        List<HappinessPercentageData> data = database2.getReportsForTopHappy();
        for (int i = 0; i < data.size(); i++) {
            double[] currentData = getCurrentData(data.get(i));
            updateMatrix(utility, currentData);
        }
        return utility;
    }

    public double[] getCurrentData(HappinessPercentageData data)
    {
        double[] currentData = new double[7];
        currentData[0] = data.getGdp_percentage();
        currentData[1] = data.getResidual_percentage();
        currentData[2] = data.getCorruption_percentage();
        currentData[3] = data.getGenerosity_percentage();
        currentData[4] = data.getLife_expectancy_percentage();
        currentData[5] = data.getPersonal_autonomy_percentage();
        currentData[6] = data.getSocial_support_percentage();
        return currentData;
    }

    public void updateMatrix(int[][] utility, double[] record) {
        int[] index = sort(record);
        for (int i = 0; i < utility.length; i++) {
            utility[i][index[i]]++;
        }
    }

    public int[] sort(double[] record) {
        int[] indexes = new int[record.length];
        for (int j = 0; j < record.length; j++) {
            int max = -1;
            int maxIndex = 0;
            for (int i = 1; i < record.length; i++) {
                if (record[maxIndex] < record[i]) {
                    maxIndex = i;
                }
            }
            indexes[j] = maxIndex;
            record[maxIndex] = -10000.0;
        }
        return indexes;
    }

    public List<String> switchCases(int[][] utility)
    {
        int max = 0;
        List<String> orderOfVariables = new ArrayList<>();
        for (int i = 0; i < utility.length; i++) {
            for (int j = 0; j < utility[i].length; j++) {
               if (utility[i][max] < utility[i][j])
               {
                   max = j;
               }
            }
            switch (max)
            {
                case(0):
                    orderOfVariables.add("GDP");
                    break;
                case(1):
                    orderOfVariables.add("Residual");
                    break;
                case(2):
                    orderOfVariables.add("Corruption");
                    break;
                case(3):
                    orderOfVariables.add("Generosity");
                    break;
                case(4):
                    orderOfVariables.add("Life Expectancy");
                    break;
                case(5):
                    orderOfVariables.add("Personal Autonomy");
                    break;
                case(6):
                    orderOfVariables.add("Social Support");
                    break;
            }
        }
        return orderOfVariables;
    }
}
