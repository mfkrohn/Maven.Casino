
package io.zipcoder.casino.utilities.CasinoGame.BlackJackTests;

import io.zipcoder.casino.utilities.CasinoGame.CardGames.BlackJack.BlackJack;
import io.zipcoder.casino.utilities.CasinoGame.CardGames.BlackJack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {

    @Test
    public void play() {



    }

    @Test
    public void giveWinningsTest() {
        BlackJackPlayer bjp1 = new BlackJackPlayer();
        BlackJackPlayer bjp2 = new BlackJackPlayer ();
        BlackJack bj = new BlackJack();

        Integer expectedWinning = 100;

          bjp1.setBalance(50);
          bjp2.setBalance(20);
          if (bjp1.balance>bjp2.balance)

       Assert.assertEquals(expectedWinning,bj.giveWinnings());






    }



}

