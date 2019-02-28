package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getCardNameTest() {
        //Given
        CardDefaultEnum expectedCardName = CardDefaultEnum.KING;
        Card card = new Card(expectedCardName,Suit.SPADE);

        //When
        CardDefaultEnum actualCardName = card.getDefaultEnum();

        //Then
        Assert.assertEquals(expectedCardName, actualCardName);
    }

    @Test
    public void getCardSuitTest() {
        //Given
        Suit expectedCardSuit = Suit.SPADE;
        Card card = new Card(CardDefaultEnum.KING,expectedCardSuit);

        //When
        Suit actualCardSuit = card.getSuit();

        //Then
        Assert.assertEquals(expectedCardSuit, actualCardSuit);
    }

//    @Test
//    public void getCardBlackJackValueTest() {
//        //Given
//        int expectedBlackJackValue = 10;
//        Card card = new Card("King","Spades",10,13);
//
//        //When
//        int actualBlackJackValue = card.getCardBlackJackValue();
//
//        //Then
//        Assert.assertEquals(expectedBlackJackValue, actualBlackJackValue);
//    }
//
//    @Test
//    public void getCardGeneralValueTest() {
//        //Given
//        int expectedlGeneralValue = 13;
//        Card card = new Card("King","Spades",10,13);
//
//        //When
//        int actualGeneralValue = card.getCardGeneralValue();
//
//        //Then
//        Assert.assertEquals(expectedlGeneralValue, actualGeneralValue);
//    }
//
//    @Test
//    public void toStringTest() {
//        //Given
//        String expectedString = "CardName:King Suit:Spades BlackJackValue:10 GeneralValue:13";
//        Card card = new Card("King","Spades",10,13);
//
//        //When
//        String acutalString = card.toString();
//
//        //Then
//        Assert.assertEquals(expectedString, acutalString);
//    }
}