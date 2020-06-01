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
            if (game.deck.countCard() < 2){
                game.deck.populateDeck();
                Collections.shuffle(game.deck.getCards());
            }
            Player activePlayer = game.getPlayers().get(i);
            System.out.println(activePlayer.getName() + "'s hand :");
            System.out.println(activePlayer.toString());
            System.out.println(activePlayer.getName() + "'s hand value is " + activePlayer.cardsValue());
            if ((activePlayer.cardsValue() == 21) && (activePlayer.countCard()) == 2) {
                System.out.println("Whooo, that's his majesty the blackjack");}
            System.out.println("What do you want to do?  press 1 for twist , or 2 to Stick");
            String choice = scanner.next();
            int choiceMade = parseInt(choice);
            while (choiceMade != 2) {
                if (game.deck.countCard() < 2){
                    game.deck.populateDeck();
                    Collections.shuffle(game.deck.getCards());
                }
                activePlayer.takeCard(game.deck.getCard(0));
                System.out.println("You took a :" + game.deck.getCard(0).toString());
                System.out.println("Your hand value is now " + activePlayer.cardsValue());
                game.deck.removeCard(0);
                if (activePlayer.cardsValue() > 21) {
                    System.out.println("You lost this hand");
                    activePlayer.looseCard();
                    choiceMade = 2;
                } else{
                    System.out.println("What do you want to do?  press 1 for twist , or 2 to Stand");
                    choice = scanner.next();
                    choiceMade = parseInt(choice);
                    if (activePlayer.cardsValue() > maxPlayerCardValue) {
                        maxPlayerCardValue = activePlayer.cardsValue();
                    }
                }
            }
        }


        System.out.println("Dealer Cards: " + game.dealer.toString());
        System.out.println(game.dealer.getName() + "'s hand value is " + game.dealer.cardsValue());
        if ((game.dealer.cardsValue() == 21) && (game.dealer.countCard()) == 2) {
            System.out.println("Damn, the dealer got his majesty the blackjack");
        }
        if (game.checkWinner().isEmpty()) {
            System.out.println("The Dealer won");
        } else {
            while (game.dealer.cardsValue() < 17) {
                if (game.deck.countCard() < 1){
                    game.deck.populateDeck();
                    Collections.shuffle(game.deck.getCards());
                }
                game.dealer.takeCard(game.deck.getCard(0));
                System.out.println("The Dealer took a :" + game.deck.getCard(0).toString());
                System.out.println("His  hand value is now " + game.dealer.cardsValue());
                game.deck.removeCard(0);
            }
        }

        if (game.dealer.cardsValue() > 21) {
            game.dealer.looseCard();
            for (Player player : game.checkWinner()) {
                System.out.println(player.getName() + " won with a total of " + player.cardsValue());
            }
            ;
        } else if (!game.checkWinner().isEmpty()) {
            for (Player player : game.checkWinner()) {
                System.out.println(player.getName() + " won with a total of " + player.cardsValue());
            }
        } else {
            game.checkDraw();
        for (Player player : game.players) {
            if (player.cardsValue() == game.dealer.cardsValue()) {
                System.out.println("It's a draw between the dealer and  " + player.getName() + ". You both scored " + player.cardsValue());
            }
        }
    }
    }
}


