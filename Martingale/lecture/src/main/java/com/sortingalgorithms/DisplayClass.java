package com.sortingalgorithms;

import java.io.PrintWriter;
import java.text.DecimalFormat;

public class DisplayClass {

    private int NUMBER_OF_RUNS;

    public DisplayClass(int NUMBER_OF_RUNS) {
        this.NUMBER_OF_RUNS = NUMBER_OF_RUNS;
    }

    public void display(PrintWriter dataOutput, double mergeFaster, double collectionFaster, double quickFaster)
    {
        DecimalFormat formater = new DecimalFormat("#,###.0000");
        try {
            dataOutput.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println("The Merge Sort time: " + formater.format((mergeFaster / NUMBER_OF_RUNS/1000000.0)) + " milliseconds");
        System.out.println("The Collection Sort time: " + formater.format((collectionFaster / NUMBER_OF_RUNS)/1000000.0) + " milliseconds");
        System.out.println("The Quick Sort time: " + formater.format((quickFaster / NUMBER_OF_RUNS)/1000000.0) + " milliseconds");
    }
}
