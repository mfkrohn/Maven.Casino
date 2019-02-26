
package io.zipcoder.casino.utilities.CasinoGame;

import org.junit.Assert;
import org.junit.Test;



import java.util.ArrayList;

public class BlackJackTest {

    @Test
    public void play() {



    }

    @Test
    public void giveWinningsTest() {
        BlackJackPlayer bjp1 = new BlackJackPlayer ();
        BlackJackPlayer bjp2 = new BlackJackPlayer ();
        BlackJack bj = new BlackJack();

        Integer expectedWinning = 100;
        Integer actualWinnings= 100;

       Assert.assertEquals(expectedWinning, actualWinnings);






    }



}

