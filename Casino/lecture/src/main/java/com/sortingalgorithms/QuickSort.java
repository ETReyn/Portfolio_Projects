package com.sortingalgorithms;

public class QuickSort {

    private Integer[] intArr;
    private Double[] doubleArr;
    private Character[] charArr;
    private String[] stringArr;

    public QuickSort(String[] stringArr) {
        this.stringArr = stringArr;
    }

    public QuickSort(Integer[] userArr)
    {
        intArr = userArr;
    }

    public QuickSort(Double[] userArr)
    {
        doubleArr = userArr;
    }

    public QuickSort(Character[] userArr) { charArr = userArr;}

    public String[] getStringArr() {
        return stringArr;
    }

    public Integer[] getArr() {
        return intArr;
    }

    public Double[] getDoubleArr() {
        return doubleArr;
    }

    public Character[] getCharArr() {
        return charArr;
    }

    public int partition(int left, int right, Integer[] arr)
    {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j <= right-1; j++) {
            if(arr[j] < pivot)
            {
                i++;
                swap( i, j, arr);
            }
        }
        swap( i + 1, right, arr);
        return (i + 1);
    }

    public int partition(int left, int right, Double[] doubleArr)
    {
        double pivot = doubleArr[right];
        int i = left - 1;

        for (int j = left; j <= right-1; j++) {
            if(doubleArr[j] < pivot)
            {
                i++;
                swap( i, j, doubleArr);
            }
        }
        swap( i + 1, right, doubleArr);
        return (i + 1);
    }

    public int partition(int left, int right, Character[] charArr)
    {
        char pivot = charArr[right];
        int i = left - 1;

        for (int j = left; j <= right-1; j++) {
            if(charArr[j].compareTo(pivot) < 0)
            {
                i++;
                swap( i, j, charArr);
            }
        }
        swap( i + 1, right, charArr);
        return (i + 1);
    }

    public int partition(int left, int right, String[] stringArr)
    {
        String pivot = stringArr[right];
        int i = left - 1;

        for (int j = left; j <= right-1; j++) {
            if(stringArr[j].compareTo(pivot) < 0)
            {
                i++;
                swap( i, j, stringArr);
            }
        }
        swap( i + 1, right, stringArr);
        return (i + 1);
    }

    public void sort(int left, int right, Integer[] arr)
    {
        if (left < right)
        {
            int partition1 = partition(left, right, arr);
            sort( left, partition1 - 1, arr);
            sort( partition1 + 1, right, arr);

        }
    }

    public void sort(int left, int right, Double[] doubleArr)
    {
        if (left < right)
        {
            int partition1 = partition(left, right, doubleArr);
            sort( left, partition1 - 1, doubleArr);
            sort( partition1 + 1, right, doubleArr);

        }
    }

    public void sort(int left, int right, Character[] charArr)
    {
        if (left < right)
        {
            int partition1 = partition(left, right, charArr);
            sort( left, partition1 - 1, charArr);
            sort( partition1 + 1, right, charArr);

        }
    }
    public void sort(int left, int right, String[] stringArr)
    {
        if (left < right)
        {
            int partition1 = partition(left, right, stringArr);
            sort( left, partition1 - 1, stringArr);
            sort( partition1 + 1, right, stringArr);

        }
    }

    public void swap( int left, int right, Integer[] arr)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void swap( int left, int right, Double[] doubleArr)
    {
        double temp = doubleArr[left];
        doubleArr[left] = doubleArr[right];
        doubleArr[right] = temp;
    }

    public void swap( int left, int right, Character[] charArr)
    {
        char temp = charArr[left];
        charArr[left] = charArr[right];
        charArr[right] = temp;
    }

    public void swap( int left, int right, String[] stringArr)
    {
        String temp = stringArr[left];
        stringArr[left] = stringArr[right];
        stringArr[right] = temp;
    }
}
