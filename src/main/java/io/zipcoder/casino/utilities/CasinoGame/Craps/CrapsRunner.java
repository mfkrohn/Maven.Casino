package io.zipcoder.casino.utilities.CasinoGame.Craps;

import io.zipcoder.casino.utilities.CasinoGame.Console;

public class CrapsRunner {

    public static void main(String[] args) {
        Craps craps = new Craps(new CrapsPlayer(),new Console(System.in,System.out));

        craps.play();

    }
}
