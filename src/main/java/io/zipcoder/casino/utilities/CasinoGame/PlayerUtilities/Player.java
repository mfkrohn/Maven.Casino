package io.zipcoder.casino.utilities.CasinoGame.PlayerUtilities;

import io.zipcoder.casino.utilities.CasinoGame.CardUtilities.Hand;

public class Player {
    public String name;
    public Integer balance;
    public Hand playerHand;

    public Player(String name, Integer balance) {


        this.name = name;
        this.balance = balance;
        //playerHand playerHand =new playerHand();

    }

    public Player() {

        this("",0);
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }
 public Integer getBalance() {

        return balance;
 }

}

