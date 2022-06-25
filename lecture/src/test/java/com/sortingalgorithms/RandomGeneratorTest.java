package com.sortingalgorithms;

import com.sortingalgorithms.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RandomGeneratorTest {

    @Test
    public void check_random_ints()
    {
        int size = 1;
        int spots = 5;
        int bounds = 100;
        ArrayList<Integer>[] testList = new ArrayList[size];
        RandomGenerator rand = new RandomGenerator(size, spots, bounds);
        testList = rand.randomIntegerGenerator();
        boolean checkIfEqual = false;
        Set <Integer> contains = new HashSet<Integer>();
        int index = 0;
        while(!checkIfEqual && index < testList[0].size())
        {
            if(contains.contains(testList[0].get(index)))
            {
                checkIfEqual = true;
                Assert.fail("Repeat values");
            }
            contains.add(testList[0].get(index));
            index++;
        }
        Assert.assertFalse("No repeat values found", checkIfEqual);
    }

    @Test
    public void check_random_doubles()
    {
        int size = 1;
        int spots = 5;
        int bounds = 100;
        ArrayList<Double>[] testList = new ArrayList[size];
        RandomGenerator rand = new RandomGenerator(size, spots, bounds);
        testList = rand.randomDoubleGenerator();
        boolean checkIfEqual = false;
        Set <Double> contains = new HashSet<Double>();
        int index = 0;
        while(!checkIfEqual && index < testList[0].size())
        {
            if(contains.contains(testList[0].get(index)))
            {
                checkIfEqual = true;
                Assert.fail("Repeat values");
            }
            contains.add(testList[0].get(index));
            index++;
        }
        Assert.assertFalse("No repeat values found", checkIfEqual);
    }

    @Test
    public void check_random_chars()
    {
        int size = 1;
        int spots = 5;
        int bounds = 100;
        ArrayList<Character>[] testList = new ArrayList[size];
        RandomGenerator rand = new RandomGenerator(size, spots, bounds);
        testList = rand.randomCharacterGenerator();
        boolean checkIfEqual = false;
        Set <Character> contains = new HashSet<Character>();
        int index = 0;
        while(!checkIfEqual && index < testList[0].size())
        {
            if(contains.contains(testList[0].get(index)))
            {
                checkIfEqual = true;
                Assert.fail("Repeat values");
            }
            contains.add(testList[0].get(index));
            index++;
        }
        Assert.assertFalse("No repeat values found", checkIfEqual);
    }

    @Test
    public void check_random_strings()
    {
        int size = 1;
        int spots = 5;
        int bounds = 100;
        ArrayList<String>[] testList = new ArrayList[size];
        RandomGenerator rand = new RandomGenerator(size, spots, bounds);
        testList = rand.randomStringGenerator();
        boolean checkIfEqual = false;
        Set <String> contains = new HashSet<String>();
        int index = 0;
        while(!checkIfEqual && index < testList[0].size())
        {
            if(contains.contains(testList[0].get(index)))
            {
                checkIfEqual = true;
                Assert.fail("Repeat values");
            }
            contains.add(testList[0].get(index));
            index++;
        }
        Assert.assertFalse("No repeat values found", checkIfEqual);
    }
}
