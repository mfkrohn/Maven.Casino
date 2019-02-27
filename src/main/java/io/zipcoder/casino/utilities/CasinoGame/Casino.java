package io.zipcoder.casino.utilities.CasinoGame;

import io.zipcoder.casino.utilities.CasinoGame.Console;
import io.zipcoder.casino.utilities.CasinoGame.Game;
import io.zipcoder.casino.utilities.CasinoGame.GameEnum;

import java.util.Arrays;

public class Casino {
    private static final Console console = new Console(System.in, System.out);
    public static void main(String[] args) {
        String continueString  = null;
        while(!"quit".equals(continueString)) {
            console.println("444444444444$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + "\n"+
                    "============================================================================"+ "\n"+
                    "   ___                             _  _       ___             _               " + "\n"+
                    "   / _\\ _ __  ___   _   _  _ __   | || |     / __\\ __ _  ___ (_) _ __    ___  " + "\n"+
                    "  / /_  | '__|/ _ \\ | | | || '_\\  | || |_   / /   / _` |/ __|| || '_ \\  / _\\ " + "\n"+
                    " / /_\\ | |  | (_) || |_| || |_) | |__   _| / /___| (_| |\\__ \\| || | | || (_) | " + "\n"+
                    " \\____/|_|   \\___/  \\__,_|| .__/     |_|   \\____/ \\__,_||___/|_||_| |_| \\___/  " + "\n"+
                    "                           |_|                                     ");
            console.println("From here, you can select any of the following games");
            String userInput = console.getStringInput(Arrays.toString(GameEnum.values()));
            GameEnum enumeration = GameEnum.getValueOf(userInput);
            Game gameInterface = enumeration.create();
            gameInterface.play();
            continueString = console.getStringInput("Would you like to continue?");
        }
    }
}
