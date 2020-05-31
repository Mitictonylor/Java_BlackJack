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

        for(int i = 0; i < numberOfPlayers; i++){
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.startTheGame();




    }
}
