package com.sortingalgorithms;

public class SortingAlgorithm {

    private static final int ARRAY_SIZE = 25, NUMBER_OF_RUNS = 4, NUMBER_OF_SPOTS = 100000, UPPER_BOUND = 1000000;
    public static void main(String[] args) {
        UserInput uI = new UserInput();
        int dataType = uI.userSortMethod();
        SortMethod time = null;
        switch (dataType){
            case(1):
                time = new TimeComplexity(ARRAY_SIZE, NUMBER_OF_RUNS, NUMBER_OF_SPOTS, UPPER_BOUND);
                break;
            case(2):
                time = new TimeComplexityDouble(ARRAY_SIZE, NUMBER_OF_RUNS, NUMBER_OF_SPOTS, UPPER_BOUND);
                break;
            case(3):
                System.out.println("The quick sort algorithm is uniquely unsuited for searching through characters. \n" +
                        "Since there are only 52 characters to chose from (a-z/A-Z), many of the elements will be the same. \n" +
                        "The worst case scenario for quick sort is if all the items are in order, or if they are all the same. \n" +
                        "Since the list will have thousands of repeated letters, this slows down the speed immensely");
                time = new TimeComplexityChar(ARRAY_SIZE, NUMBER_OF_RUNS, NUMBER_OF_SPOTS, UPPER_BOUND);
                break;
            case(4):
                time = new TimeComplexityString(ARRAY_SIZE, NUMBER_OF_RUNS, NUMBER_OF_SPOTS, UPPER_BOUND);
                break;
        }
        time.sort();
    }
}
