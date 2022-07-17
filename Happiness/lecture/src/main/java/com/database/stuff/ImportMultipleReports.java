package com.database.stuff;

public class ImportMultipleReports {

    public static void main(String[] args) {

        String[] wHR = {"WHR 2019", "WHR 2018", "WHR 2017", "WHR 2016"};
        String[] wHRTable = {"nineteen_happiness", "eighteen_happiness", "seventeen_happiness", "sixteen_happiness"};


        for (int i = 0; i < wHR.length; i++) {

            ImportData newImport = new ImportData(wHR[i], wHRTable[i]);
//            newImport.importData();
            newImport.putPercentagesInDatabase();

        }

    }

}
