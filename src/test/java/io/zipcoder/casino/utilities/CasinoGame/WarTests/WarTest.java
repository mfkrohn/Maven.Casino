package io.zipcoder.casino.utilities.CasinoGame.WarTests;

import io.zipcoder.casino.utilities.CasinoGame.CardGames.War.War;
import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    @Test
    public void getPlayer1HandTest(){
        // given
        Integer expected = 52;
        // when
        Integer actual = War.getPlayer1Hand().size();
        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayer2HandTest(){
        // given
        Integer expected = 52;
        // when
        Integer actual = War.getPlayer2Hand().size();
        // then
        Assert.assertEquals(expected, actual);
    }
}
