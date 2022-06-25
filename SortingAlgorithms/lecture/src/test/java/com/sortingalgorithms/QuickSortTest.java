package com.sortingalgorithms;

import com.sortingalgorithms.QuickSort;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void check_if_sorts_ints() {
        Integer[] unsorted = new Integer[]{4, 3, 2, 1};
        QuickSort sut = new QuickSort(unsorted);
        sut.sort(0, unsorted.length - 1, sut.getArr());
        for (Integer i = 1; i < 5; i++) {
            Assert.assertEquals(i, sut.getArr()[i - 1]);
        }
    }

    @Test
    public void check_if_sorts_doubles() {
        Double[] unsorted = new Double[]{4.5, 3.5, 2.5, 1.5};
        QuickSort sut = new QuickSort(unsorted);
        sut.sort(0, unsorted.length - 1, sut.getDoubleArr());
        double k = 1.5;
        for (int i = 1; i < 5; i++) {
            Assert.assertEquals(k, sut.getDoubleArr()[i - 1], 0.00000001);
            k++;
        }
    }

    @Test
    public void check_if_sorts_chars() {
        Character[] unsorted = new Character[]{'d', 'c', 'b', 'a'};
        QuickSort sut = new QuickSort(unsorted);
        sut.sort(0, unsorted.length - 1, sut.getCharArr());
        Character[] k = new Character[]{'a', 'b', 'c', 'd'};
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(k[i], sut.getCharArr()[i]);

        }
    }

    @Test
    public void check_if_sorts_strings() {
        String[] unsorted = new String[]{"dog", "cat", "beagle", "ant"};
        QuickSort sut = new QuickSort(unsorted);
        sut.sort(0, unsorted.length - 1, sut.getStringArr());
        String[] k = new String[]{"ant", "beagle", "cat", "dog"};
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(k[i], sut.getStringArr()[i]);

        }
    }


    @Test
    public void check_if_sorts_multiple_ints()
    {
        Integer[] unsorted = new Integer[]{4,3,2,1,2};
        QuickSort sut = new QuickSort(unsorted);
        Integer[] sorted = new Integer[]{1, 2, 2, 3, 4};
        sut.sort(0, unsorted.length-1, sut.getArr());
        for (Integer i = 0; i < unsorted.length; i++) {
            Assert.assertEquals(sorted[i], sut.getArr()[i]);
        }
    }
    @Test
    public void check_if_sorts_multiple_doubles()
    {
        Double[] unsorted = new Double[]{4.5, 3.5, 2.5, 1.5, 2.5};
        QuickSort sut = new QuickSort(unsorted);
        Double[] sorted = new Double[]{1.5, 2.5, 2.5, 3.5, 4.5};
        sut.sort(0, unsorted.length-1, sut.getDoubleArr());
        double k = 0.5;
        for (int i = 0; i < unsorted.length; i++) {
            Assert.assertEquals(sorted[i], sut.getDoubleArr()[i], 0.00000001);
            k++;
        }
    }
    @Test
    public void check_if_sorts_multiple_chars()
    {
        Character[] unsorted = new Character[]{'d', 'c', 'b', 'a', 'c'};
        QuickSort sut = new QuickSort(unsorted);

        sut.sort(0, unsorted.length-1, sut.getCharArr());
        Character[] k = new Character[]{'a', 'b', 'c', 'c', 'd'};

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(k[i], sut.getCharArr()[i]);
        }
    }

    @Test
    public void check_if_sorts_multiple_strings()
    {
        String[] unsorted = new String[]{"dog", "cat", "beagle", "ant", "cat"};
        QuickSort sut = new QuickSort(unsorted);

        sut.sort(0, unsorted.length-1, sut.getStringArr());
        String[] k = new String[]{"ant", "beagle", "cat", "cat", "dog"};

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(k[i], sut.getStringArr()[i]);
        }
    }
}
