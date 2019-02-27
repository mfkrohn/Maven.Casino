package io.zipcoder.casino.utilities.CasinoGame.Craps;

import io.zipcoder.casino.utilities.CasinoGame.GamblingPlayer;
import io.zipcoder.casino.utilities.CasinoGame.PlayerUtilities.Player;

public class CrapsPlayer extends Player implements GamblingPlayer {

    public String name;
    public Integer balance;


    public CrapsPlayer(){
        this.name = "";
        this.balance = 10000;
    }
    public CrapsPlayer(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }


    public Integer getBalance(){
        return balance;
    }
    public void placeBet(Integer bet) {

        balance -= bet;

    }

    public void receiveWinnings(Integer winnings) {
        balance += winnings;
    }
}
