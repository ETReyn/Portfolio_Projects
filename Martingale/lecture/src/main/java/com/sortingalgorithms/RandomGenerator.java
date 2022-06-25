package com.sortingalgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private int arraySize;
    private int numberOfSpots;
    private int upperBound;
    private String dateType;
    ArrayList<String>[] allDataStrings;
    ArrayList<Integer>[] allDataIntegers;
    ArrayList<Character>[] allDataCharacters;
    ArrayList<Double>[] allDataDoubles;
    QuickSort[] qS;
    MergeSort[] mS;

    public RandomGenerator(int arraySize, int numberOfSpots, int upperBound) {
        this.arraySize = arraySize;
        this.numberOfSpots = numberOfSpots;
        this.upperBound = upperBound;
        allDataIntegers = new ArrayList[arraySize];
        allDataStrings = new ArrayList[arraySize];
        allDataDoubles = new ArrayList[arraySize];
        allDataCharacters = new ArrayList[arraySize];
        qS = new QuickSort[arraySize];
        mS = new MergeSort[arraySize];
    }

    public ArrayList<String>[] getAllDataStrings() {
        return allDataStrings;
    }

    public ArrayList<Integer>[] getAllDataIntegers() {
        return allDataIntegers;
    }

    public ArrayList<Character>[] getAllDataCharacters() {
        return allDataCharacters;
    }

    public ArrayList<Double>[] getAllDataDoubles() {
        return allDataDoubles;
    }

    public QuickSort[] getqS() {
        return qS;
    }

    public MergeSort[] getmS() {
        return mS;
    }

    public void generateDeepCopyString(int ARRAY_SIZE) {

        allDataStrings = randomStringGenerator();
        ArrayList<String>[] allDataInts2 = new ArrayList[ARRAY_SIZE];
        ArrayList<String>[] allDataInts3 = new ArrayList[ARRAY_SIZE];
        for (int i = 0; i < allDataStrings.length; i++) {
            allDataInts2[i] = new ArrayList<>();
            allDataInts3[i] = new ArrayList<>();
            for (String ints : allDataStrings[i]) {
                allDataInts2[i].add(ints);
                allDataInts3[i].add(ints);
            }
            qS[i] = new QuickSort(allDataInts2[i].toArray(new String[0]));
            mS[i] = new MergeSort(allDataInts3[i].toArray(new String[0]));
        }
    }

    public void generateDeepCopyInteger(int ARRAY_SIZE) {

        allDataIntegers = randomIntegerGenerator();
        ArrayList<Integer>[] allDataInts2 = new ArrayList[ARRAY_SIZE];
        ArrayList<Integer>[] allDataInts3 = new ArrayList[ARRAY_SIZE];
        for (int i = 0; i < allDataIntegers.length; i++) {
            allDataInts2[i] = new ArrayList<>();
            allDataInts3[i] = new ArrayList<>();
            for (Integer ints : allDataIntegers[i]) {
                allDataInts2[i].add(ints);
                allDataInts3[i].add(ints);
            }
            qS[i] = new QuickSort(allDataInts2[i].toArray(new Integer[0]));
            mS[i] = new MergeSort(allDataInts3[i].toArray(new Integer[0]));
        }
    }

    public void generateDeepCopyDouble(int ARRAY_SIZE) {

        allDataDoubles = randomDoubleGenerator();
        ArrayList<Double>[] allDataInts2 = new ArrayList[ARRAY_SIZE];
        ArrayList<Double>[] allDataInts3 = new ArrayList[ARRAY_SIZE];
        for (int i = 0; i < allDataDoubles.length; i++) {
            allDataInts2[i] = new ArrayList<>();
            allDataInts3[i] = new ArrayList<>();
            for (Double ints : allDataDoubles[i]) {
                allDataInts2[i].add(ints);
                allDataInts3[i].add(ints);
            }
            qS[i] = new QuickSort(allDataInts2[i].toArray(new Double[0]));
            mS[i] = new MergeSort(allDataInts3[i].toArray(new Double[0]));
        }
    }

    public void generateDeepCopyCharacter(int ARRAY_SIZE) {

        allDataCharacters = randomCharacterGenerator();
        ArrayList<Character>[] allDataInts2 = new ArrayList[ARRAY_SIZE];
        ArrayList<Character>[] allDataInts3 = new ArrayList[ARRAY_SIZE];
        for (int i = 0; i < allDataStrings.length; i++) {
            allDataInts2[i] = new ArrayList<>();
            allDataInts3[i] = new ArrayList<>();
            for (Character ints : allDataCharacters[i]) {
                allDataInts2[i].add(ints);
                allDataInts3[i].add(ints);
            }
            qS[i] = new QuickSort(allDataInts2[i].toArray(new Character[0]));
            mS[i] = new MergeSort(allDataInts3[i].toArray(new Character[0]));
        }
    }

    public ArrayList<String>[] randomStringGenerator() {
        ArrayList<String>[] allDataInts = new ArrayList[arraySize];
        Random rand = new Random();
        int stringLength = 10;
        char charAtIndex;
        String tempString = "";

        for (int i = 0; i < arraySize; i++) {
            //fills the array to the arraySize
            ArrayList<String> tempList = new ArrayList<>();
            for (int j = 0; j < numberOfSpots; j++) {
                //Adds a string to the list numberOfSpots times
                for (int k = 0; k < stringLength; k++) {
                    //Creates a random string, an individual character at a time
                    if (rand.nextInt(50) < 25) {
                        charAtIndex = (char) (rand.nextInt(25) + 65);
                    } else {
                        charAtIndex = (char) (rand.nextInt(25) + 97);
                    }
                    tempString += charAtIndex;
                }
                tempList.add(tempString);
                tempString = "";
            }
            allDataInts[i] = tempList;
        }
        return allDataInts;
    }

    public ArrayList<Double>[] randomDoubleGenerator() {
        ArrayList<Double>[] allDataInts = new ArrayList[arraySize];

        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            ArrayList<Double> tempList = new ArrayList<>();

            for (int j = 0; j < numberOfSpots; j++) {
                tempList.add(rand.nextDouble() * upperBound);
            }
            allDataInts[i] = tempList;
        }
        return allDataInts;
    }

    public ArrayList<Character>[] randomCharacterGenerator() {
        ArrayList<Character>[] allDataInts = new ArrayList[arraySize];
        Random rand = new Random();

        for (int i = 0; i < arraySize; i++) {
            //fills the array to the arraySize
            ArrayList<Character> tempList = new ArrayList<>();
            for (int j = 0; j < numberOfSpots; j++) {
                if (rand.nextInt(50) < 25) {
                    tempList.add((char) (rand.nextInt(25) + 65));
                } else {
                    tempList.add((char) (rand.nextInt(25) + 97));
                }
            }
            allDataInts[i] = tempList;
        }
        return allDataInts;
    }

    public ArrayList<Integer>[] randomIntegerGenerator() {
        ArrayList<Integer>[] allDataInts = new ArrayList[arraySize];

        Random rand = new Random();
        for (int i = 0; i < arraySize; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();

            for (int j = 0; j < numberOfSpots; j++) {
                tempList.add(rand.nextInt(upperBound));
            }
            allDataInts[i] = tempList;
        }
        return allDataInts;
    }
}
