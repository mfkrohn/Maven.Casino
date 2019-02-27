package io.zipcoder.casino.utilities.CasinoGame.CardGames.War;

import io.zipcoder.casino.utilities.CasinoGame.*;
import io.zipcoder.casino.utilities.CasinoGame.CardGames.CardGame;
import io.zipcoder.casino.utilities.CasinoGame.CardUtilities.Card;
import io.zipcoder.casino.utilities.CasinoGame.CardUtilities.Deck;
import io.zipcoder.casino.utilities.CasinoGame.PlayerUtilities.PlayerList;

import java.util.Stack;

public class War extends CardGame implements Game {
    public java.util.ArrayList<WarPlayer> warPlayerList;
    Console console = new Console(System.in, System.out);

    public War(PlayerList playerList) {
    }

    Stack<Card> player1Hand = new Stack<>();
    Stack<Card> player2Hand = new Stack<>();

    private Stack<Card> player1DiscardPile = new Stack<>();
    private Stack<Card> player2DiscardPile = new Stack<>();

    private Card p1WarCard;
    private Card p2WarCard;

    War() {

    }

    private static Stack<Card> getPlayerHands(Deck warPlayerDeck1, Stack<Card> player1Hand) {
        for (int i = 0; i < 52; i++) {
            Card card = warPlayerDeck1.regularDeck.pop();
            player1Hand.push(card);
        }
        return player1Hand;
    }

    public static Stack<Card> getPlayer1Hand() {
        Deck warPlayerDeck1 = new Deck();
        Stack<Card> player1Hand = new Stack<>();

        warPlayerDeck1.buildRegularDeck();
        return getPlayerHands(warPlayerDeck1, player1Hand);
    }

    public static Stack<Card> getPlayer2Hand() {
        Deck warPlayerDeck2 = new Deck();
        Stack<Card> player2Hand = new Stack<>();

        return getPlayerHands(warPlayerDeck2, player2Hand);
    }

    public void play() {
        Stack<Card> player1Hand = getPlayer1Hand();
        Stack<Card> player2Hand = getPlayer2Hand();

        while (!player1Hand.empty() || !player2Hand.empty()) {
            Card cardForTurn1 = player1Hand.pop();
            System.out.println("Player1 played: " + cardForTurn1.toString());
            Card cardForTurn2 = player2Hand.pop();
            System.out.println("Player2 played: " + cardForTurn2.toString());
            if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) > 0) {
                player1DiscardPile.push(cardForTurn1);
                player1DiscardPile.push(cardForTurn2);
                System.out.println("Player 1 wins this round");
                if (getWinner(player2Hand)) return;
            } else if (cardForTurn1.cardDefaultEnum.compareTo(cardForTurn2.cardDefaultEnum) < 0) {
                player2DiscardPile.push(cardForTurn1);
                player2DiscardPile.push(cardForTurn2);
                System.out.println("Player 2 wins this round");
                if (getWinner(player2Hand)) return;
            } else if (cardForTurn1.cardDefaultEnum.equals(cardForTurn2.cardDefaultEnum)) {
                while (!player1Hand.empty() && !player2Hand.empty()) {
                    System.out.println("War!");
                    System.out.println();

                    if (player1Hand.size() >= 4 && player2Hand.size() >= 4) {
                        WarMethod warMethod = new WarMethod(player1Hand, player2Hand).invoke();
                        Card p1WarCard1 = warMethod.getP1WarCard1();
                        Card p1WarCard2 = warMethod.getP1WarCard2();
                        Card p1WarCard3 = warMethod.getP1WarCard3();
                        Card p1WarCard4 = warMethod.getP1WarCard4();
                        Card p2WarCard1 = warMethod.getP2WarCard1();
                        Card p2WarCard2 = warMethod.getP2WarCard2();
                        Card p2WarCard3 = warMethod.getP2WarCard3();
                        Card p2WarCard4 = warMethod.getP2WarCard4();
                        System.out.println("Player 1 picked: " + p1WarCard.toString());
                        System.out.println("Player 2 picked: " + p2WarCard.toString());
                        if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) > 0) {
                            System.out.println("Player 1 wins the war");
                            putWarCardsInDiscardPiles(p1WarCard1, p1WarCard2, p1WarCard3, p1WarCard4, p2WarCard1, p2WarCard2, p2WarCard3, p2WarCard4, player1DiscardPile);
                            break;
                        } else if (p1WarCard.cardDefaultEnum.compareTo(p2WarCard.cardDefaultEnum) < 0) {
                            System.out.println("Player 2 wins the war");
                            putWarCardsInDiscardPiles(p1WarCard1, p1WarCard2, p1WarCard3, p1WarCard4, p2WarCard1, p2WarCard2, p2WarCard3, p2WarCard4, player2DiscardPile);
                        }
                    } else if (player1Hand.size() < 4 && player2Hand.size() < 4) {
                        if (player1DiscardPile.size() > player2DiscardPile.size()) {
                            System.out.println("Players are out of cards");
                            System.out.println("Player 1 wins, Game Over");
                            System.out.println();
                            return;
                        } else if (player1DiscardPile.size() < player2DiscardPile.size()) {
                            System.out.println("Players are out of cards");
                            System.out.println("Player 2 wins, Game Over");
                            System.out.println();
                            return;
                        }
                    }
                }
                if (player1Hand.isEmpty()) {
                    if (player1DiscardPile.size() > player2DiscardPile.size()) {
                        System.out.println("Player 1 wins, Game Over");
                        System.out.println();
                        return;
                    } else if (player1DiscardPile.size() < player2DiscardPile.size()) {
                        System.out.println("Player 2 wins, Game Over");
                        System.out.println();
                        return;
                    }
                }
            }

        }
    }

    private void putWarCardsInDiscardPiles(Card p1WarCard1, Card p1WarCard2, Card p1WarCard3, Card p1WarCard4, Card p2WarCard1, Card p2WarCard2, Card p2WarCard3, Card p2WarCard4, Stack<Card> player1DiscardPile) {
        System.out.println();
        player1DiscardPile.push(p1WarCard1);
        player1DiscardPile.push(p1WarCard2);
        player1DiscardPile.push(p1WarCard3);
        player1DiscardPile.push(p1WarCard4);
        player1DiscardPile.push(p2WarCard1);
        player1DiscardPile.push(p2WarCard2);
        player1DiscardPile.push(p2WarCard3);
        player1DiscardPile.push(p2WarCard4);
    }

    private boolean getWinner(Stack<Card> player2Hand) {
        System.out.println();
        if (player2Hand.isEmpty()) {
            if (player1DiscardPile.size() > player2DiscardPile.size()) {
                System.out.println("Player 1 wins, Game Over");
                System.out.println();
                return true;
            } else if (player1DiscardPile.size() < player2DiscardPile.size()) {
                System.out.println("Player 2 wins, Game Over");
                System.out.println();
                return true;
            }
        }
        return false;
    }

    public Integer getScore() {
        return null;
    }

    public Integer giveScore() {
        return null;
    }

    private class WarMethod {
        private Stack<Card> player1Hand;
        private Stack<Card> player2Hand;
        private Card p1WarCard1;
        private Card p1WarCard2;
        private Card p1WarCard3;
        private Card p1WarCard4;
        private Card p2WarCard1;
        private Card p2WarCard2;
        private Card p2WarCard3;
        private Card p2WarCard4;

        WarMethod(Stack<Card> player1Hand, Stack<Card> player2Hand) {
            this.player1Hand = player1Hand;
            this.player2Hand = player2Hand;
        }

        Card getP1WarCard1() {
            return p1WarCard1;
        }

        Card getP1WarCard2() {
            return p1WarCard2;
        }

        Card getP1WarCard3() {
            return p1WarCard3;
        }

        Card getP1WarCard4() {
            return p1WarCard4;
        }

        Card getP2WarCard1() {
            return p2WarCard1;
        }

        Card getP2WarCard2() {
            return p2WarCard2;
        }

        Card getP2WarCard3() {
            return p2WarCard3;
        }

        Card getP2WarCard4() {
            return p2WarCard4;
        }

        WarMethod invoke() {
            p1WarCard1 = player1Hand.pop();
            p1WarCard2 = player1Hand.pop();
            p1WarCard3 = player1Hand.pop();
            p1WarCard4 = player1Hand.pop();
            Integer p1Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
            System.out.println(p1Choice.toString());
            if (p1Choice == 1) {
                p1WarCard = p1WarCard1;
            } else if (p1Choice == 2) {
                p1WarCard = p1WarCard2;
            } else if (p1Choice == 3) {
                p1WarCard = p1WarCard3;
            } else if (p1Choice == 4) {
                p1WarCard = p1WarCard4;
            } else {
                p1WarCard = p1WarCard4;
            }

            p2WarCard1 = player2Hand.pop();
            p2WarCard2 = player2Hand.pop();
            p2WarCard3 = player2Hand.pop();
            p2WarCard4 = player2Hand.pop();
            Integer p2Choice = console.getIntegerInput("Choose which card to flip: 1, 2, 3, or 4", 1, 2, 3, 4);
            System.out.println(p2Choice.toString());
            if (p2Choice == 1) {
                p2WarCard = p2WarCard1;
            } else if (p2Choice == 2) {
                p2WarCard = p2WarCard2;
            } else if (p2Choice == 3) {
                p2WarCard = p2WarCard3;
            } else if (p2Choice == 4) {
                p2WarCard = p2WarCard4;
            } else {
                p2WarCard = p2WarCard4;
            }
            return this;
        }
    }
}
