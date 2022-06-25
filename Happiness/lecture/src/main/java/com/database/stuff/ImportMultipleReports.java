package com.database.stuff;

public class ImportMultipleReports {

    public static void main(String[] args) {

        String[] wHR = {"WHR 2022", "WHR 2020", "WHR 2021"};
        String[] wHRTable = {"twenty_two_happiness", "twenty_happiness", "twenty_one_happiness"};

        for (int i = 0; i < wHR.length; i++) {
            ImportData newImport = new ImportData(wHR[i], wHRTable[i]);
            newImport.printHeader();
            newImport.importData();

        }

    }

}
