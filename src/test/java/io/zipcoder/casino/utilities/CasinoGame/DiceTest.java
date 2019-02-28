package io.zipcoder.casino;

import io.zipcoder.casino.utilities.CasinoGame.Dice;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.zip.InflaterInputStream;

public class DiceTest {

//    @Before
//    public void setup(){
//        Dice testDice = new Dice(2,6);
//    }

    @Test
    public void diceConstructorTest(){
        //Given
        Integer expectedSize = 6;
        Integer expectedNumberOfDice = 2;

        //When
        Dice testDice = new Dice(expectedNumberOfDice,expectedSize);
        Integer actualDice1 = testDice.getValue(0);
        Integer actualDice2 = testDice.getValue(1);
        //Then
        Assert.assertEquals(expectedSize,testDice.getValue(0));
        Assert.assertEquals(expectedSize,testDice.getValue(1));


    }

    @Test
    public void nullaryDiceConstructorTest() {
        //Given
        Integer expectedSize = 6;


        //When
        Dice testDice = new Dice();
        //Then
        Assert.assertEquals(expectedSize, testDice.getValue(0));
        Assert.assertEquals(expectedSize, testDice.getValue(1));
    }

    @Test
    public void rollTest(){
        //Given
        Dice testDice = new Dice(2,6,2L);
        Integer expectedFirstSeed = 4;
        Integer expectedSecondSeed = 3;
        //When
        testDice.rollDice();
        //Then
        Assert.assertEquals(expectedFirstSeed,testDice.getValue(0));
        Assert.assertEquals(expectedSecondSeed,testDice.getValue(1));
    }

    @Test
    public void getSumTest(){
        //Given
        Dice testDice = new Dice(2,6,  2L);
        Integer expectedSum = 7;
        //When
        testDice.rollDice();
        Integer testSum = testDice.getSum();
        //Then
        Assert.assertEquals(expectedSum,testSum);

    }
}
