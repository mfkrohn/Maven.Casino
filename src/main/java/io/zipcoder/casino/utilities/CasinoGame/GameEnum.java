package io.zipcoder.casino.utilities.CasinoGame;

import io.zipcoder.casino.utilities.CasinoGame.CardGames.BlackJack.BlackJack;
import io.zipcoder.casino.utilities.CasinoGame.Craps.Craps;
import io.zipcoder.casino.utilities.CasinoGame.CardGames.GoFish.GoFish;
import io.zipcoder.casino.utilities.CasinoGame.CardGames.War.War;

import java.util.function.Supplier;

public enum GameEnum {
    BLACKJACK(BlackJack::new),
    CRAPS(Craps::new),
    GOFISH(GoFish::new),
    WAR(War::new);

    private final Supplier<Game> supplier;

    GameEnum(Supplier<Game> supplier) {
        this.supplier = supplier;
    }

    public Game create() {
        return supplier.get();
    }

    public static GameEnum getValueOf(String userInput) {
        userInput = userInput.toUpperCase();
        try {
            return valueOf(userInput);
        } catch (IllegalArgumentException iae) {
            return valueOf(userInput.replaceAll(" ", "_"));
        }
    }
}
