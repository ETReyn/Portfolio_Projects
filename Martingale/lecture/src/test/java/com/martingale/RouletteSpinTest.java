package com.martingale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteSpinTest {

    private RouletteSpin sut;
    @Before
    public void setup()
    {
        sut = new RouletteSpin();
    }

    @Test
    public void testing_one_spin()
    {
        boolean output = sut.spin();
        int spinResults = sut.getSpinSimulation();
        if(spinResults < 16)
        {
            Assert.assertTrue(output);
        }
        else
        {
            Assert.assertFalse(output);
        }
    }
}
