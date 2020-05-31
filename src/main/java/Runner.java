import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Welcome Message
        System.out.println("Welcome to Blackjack!");

        //Creating the Deck
        Deck deck = new Deck();
        System.out.println(deck);
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
        System.out.println("The dealer has " + game.dealer.ToStringFirstCard() + " and {HIDDEN} \n");
        for (int i = 0; i < game.players.size(); i++) {
            Player activePlayer = game.players.get(i);
            System.out.println(activePlayer.getName() + "'s hand :");
            System.out.println(activePlayer.toString());
            System.out.println(activePlayer.getName() + "'s hand value is " + activePlayer.cardsValue());
            System.out.println("What do you want to do?  press 1 for twist , or 2 to Stick");
            String choice = scanner.next();
            int choiceMade = parseInt(choice);
            while(choiceMade != 2){
                activePlayer.takeCard(game.deck.getCard(0));
                deck.removeCard(0);
                System.out.println("You took a :" + game.deck.getCard(0).toString());
                System.out.println("Your hand value is now " + activePlayer.cardsValue());
                if (activePlayer.cardsValue() > 21){
                    System.out.println("You lost this hand");
                    choiceMade = 2;
                }else{
                System.out.println("What do you want to do?  press 1 for twist , or 2 to Stick");
               choice = scanner.next();
               choiceMade = parseInt(choice);}
            }
        }
    }
}
