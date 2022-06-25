package com.sortingalgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class TimeComplexityString implements SortMethod{

    public int ARRAY_SIZE, NUMBER_OF_RUNS, NUMBER_OF_SPOTS, UPPER_BOUND;

    public TimeComplexityString(int ARRAY_SIZE, int NUMBER_OF_RUNS, int NUMBER_OF_SPOTS, int UPPER_BOUND) {
        this.ARRAY_SIZE = ARRAY_SIZE;
        this.NUMBER_OF_RUNS = NUMBER_OF_RUNS;
        this.NUMBER_OF_SPOTS = NUMBER_OF_SPOTS;
        this.UPPER_BOUND = UPPER_BOUND;
    }
    public void sort() {
        File dataFile = new File("outputData\\StringSortingData.csv");
        PrintWriter dataOutput = null;
        try {
            dataOutput = new PrintWriter(new FileOutputStream(dataFile));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        double collectionFaster = 0, mergeFaster = 0, quickFaster = 0;
        dataOutput.println("Run #;Collection Sort;Merge Sort;Quick Sort");

        for (int x = 0; x < NUMBER_OF_RUNS; x++) {
            RandomGenerator ranGen = new RandomGenerator(ARRAY_SIZE, NUMBER_OF_SPOTS, UPPER_BOUND);
            ranGen.generateDeepCopyString(ARRAY_SIZE);
            MergeSort[] mS = ranGen.getmS();
            QuickSort[] qS = ranGen.getqS();
//
//
//
//          Creates an array of ARRAY_SIZE arraylists, each filled with NUMBER_OF_SPOTS random numbers between 0 - UPPER_BOUND
//          Creates a deep copy of the numbers stored in the first array, so each sorting algorithm uses the same numbers
//          This is meant to test three different types of program architecture to see if there is a difference
//          1) Creating seperate classes for each sorting algorithm
//          2) Using inheritance to group the sorting classes
//          3) Using methods withing the TimeComplexity class for the different algorithms
//
//
//
            long before = System.nanoTime();
            for (ArrayList<String> allDataInt : ranGen.getAllDataStrings()) {
                Collections.sort(allDataInt);
            }
            long after = System.nanoTime();
            long diff = after - before;
//
//
//
//           ^ Collection Sort ^
//
//
//
            long before1 = System.nanoTime();
            for (int i = 0; i < mS.length; i++) {
                mS[i].sort(0, mS[i].getStringArr().length - 1, mS[i].getStringArr());
            }
            long after1 = System.nanoTime();
            long diff1 = after1 - before1;
//
//
//
//            ^ Merge Sort ^
//
//
//
            long before2 = System.nanoTime();
            for (int i = 0; i < qS.length; i++) {
                qS[i].sort(0, qS[i].getStringArr().length - 1, qS[i].getStringArr());
            }
            long after2 = System.nanoTime();
            long diff2 = after2 - before2;
//
//
//
//            ^ Quick Sort ^
//
//
//
            System.out.println("On Run: "+x);
            mergeFaster += (diff1 / ARRAY_SIZE);
            dataOutput.println(x+";"+(diff / ARRAY_SIZE)+ ";"+(diff1 / ARRAY_SIZE)+";"+(diff2  / ARRAY_SIZE));
            collectionFaster += (diff / ARRAY_SIZE);
            quickFaster += (diff2  / ARRAY_SIZE);

        }
        DisplayClass dC = new DisplayClass(NUMBER_OF_RUNS);
        dC.display(dataOutput, mergeFaster, collectionFaster, quickFaster);
    }


}
