import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        Deck deck = new Deck();
        Game game = new Game(deck);
        game.createDealer();


        System.out.println("How many Players there will be?");
        String input = scanner.next();
        int numberOfPlayers = parseInt(input);

        for (int i = 0; i < numberOfPlayers; i++) {
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.startTheGame();
        game.dealer.getCardAtIndex(0);
        System.out.println("The dealer has " + game.dealer.toStringFirstCard() + " and {HIDDEN} \n");
        int maxPlayerCardValue = 0;
        for (int i = 0; i < game.getPlayers().size(); i++) {
            game.lowCardInTheDeck();
            Player activePlayer = game.getPlayers().get(i);
            game.playerHandToString(activePlayer);
            game.playerHandValueToString(activePlayer);
            game.checkPlayerHasBlackjack(activePlayer);
            game.twistOrStand();
            String choice = scanner.next();
            int choiceMade = parseInt(choice);
            while (choiceMade != 2) {
                game.lowCardInTheDeck();
                activePlayer.takeCard(game.deck.getCard(0));
                System.out.println("You took a :" + game.deck.getCard(0).toString());
                game.playerHandValueToString(activePlayer);
                game.deck.removeCard(0);
                if (activePlayer.cardsValue() > 21) {
                    System.out.println("You lost this hand");
                    activePlayer.looseCard();
                    choiceMade = 2;
                } else {
                    game.twistOrStand();
                    choice = scanner.next();
                    choiceMade = parseInt(choice);
                    if (activePlayer.cardsValue() > maxPlayerCardValue) {
                        maxPlayerCardValue = activePlayer.cardsValue();
                    }
                }
            }
        }


        game.dealerHandToString(game.dealer);
        game.dealerHandValueToString(game.dealer);
        game.checkDealerHasBlackjack(game.dealer);
        if (game.checkWinner().isEmpty()) {
            System.out.println("The Dealer won");
        } else {
            while (game.dealer.cardsValue() < 17) {
                if (game.deck.countCard() < 1) {
                    game.deck.populateDeck();
                    Collections.shuffle(game.deck.getCards());
                }
                game.dealer.takeCard(game.deck.getCard(0));
                System.out.println("The Dealer took a :" + game.deck.getCard(0).toString());
                game.dealerHandValueToString(game.dealer);
                game.deck.removeCard(0);
            }
        }

        if (game.dealer.cardsValue() > 21) {
            game.dealer.looseCard();
            for (Player player : game.checkWinner()) {
                System.out.println(player.getName() + " won with a total of " + player.cardsValue());
            }
        } else if (!game.checkWinner().isEmpty()) {
            for (Player player : game.checkWinner()) {
                System.out.println(player.getName() + " won with a total of " + player.cardsValue());
            }
        } else if (game.checkDraw()){
            for (Player player : game.players) {
                if (player.cardsValue() == game.dealer.cardsValue()) {
                    System.out.println("It's a draw between the dealer and  " + player.getName() + ". You both scored " + player.cardsValue());
                }
            }
        }else{
            System.out.println("The dealer Won!");
        }
    }
}


