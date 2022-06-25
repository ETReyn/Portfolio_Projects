package com.sortingalgorithms;

public class MergeSort {

    private Integer[] intArr;
    private Character[] charArr;
    private Double[] doubleArr;
    private String[] stringArr;

    public MergeSort(String[] userMergeSortList)
    {
        stringArr = userMergeSortList;
    }

    public MergeSort(Integer[] userMergeSortList){

        intArr = userMergeSortList;
    }

    public MergeSort(Double[] userMergeSortList){

        doubleArr = userMergeSortList;
    }

    public MergeSort(Character[] userMergeSortList)
    {
        charArr = userMergeSortList;
    }

    public String[] getStringArr() {
        return stringArr;
    }

    public Character[] getCharArr() { return  charArr;}

    public Integer[] getArr() {
        return intArr;
    }

    public Double[] getDoubleArr() {
        return doubleArr;
    }

    public void sort(int left, int right, Integer[] arr)
    {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(left, mid, arr);
            sort( mid + 1, right, arr);
            merge(left, right, mid, arr);
        }
    }

    public void sort(int left, int right, Double[] arr)
    {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(left, mid, arr);
            sort( mid + 1, right, arr);
            merge(left, right, mid, arr);
        }
    }

    public void sort(int left, int right, Character[] arr)
    {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(left, mid, arr);
            sort( mid + 1, right, arr);
            merge(left, right, mid, arr);
        }
    }

    public void sort(int left, int right, String[] arr)
    {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(left, mid, arr);
            sort( mid + 1, right, arr);
            merge(left, right, mid, arr);
        }
    }

    public void merge (int left, int right, int mid, Integer[] arr){

        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void merge (int left, int right, int mid, Character[] charArr){

        int n1 = mid - left + 1;
        int n2 = right - mid;
        char[] leftArr = new char[n1];
        char[] rightArr = new char[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = charArr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = charArr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                charArr[k] = leftArr[i];
                i++;
            } else {
                charArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            charArr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            charArr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void merge (int left, int right, int mid, Double[] doubleArr){

        int n1 = mid - left + 1;
        int n2 = right - mid;
        Double[] leftArr = new Double[n1];
        Double[] rightArr = new Double[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = doubleArr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = doubleArr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                doubleArr[k] = leftArr[i];
                i++;
            } else {
                doubleArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            doubleArr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            doubleArr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public void merge (int left, int right, int mid, String[] stringArr){

        int n1 = mid - left + 1;
        int n2 = right - mid;
        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = stringArr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = stringArr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) < 0) {
                stringArr[k] = leftArr[i];
                i++;
            } else {
                stringArr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            stringArr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            stringArr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}
