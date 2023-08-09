package rockpaperscissors;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        String allHandsInput = scanner.nextLine();
        System.out.println("Okay, let's start");
        if (allHandsInput.length() == 0) {
            playClassicGame(scanner, name);
        } else {
            playCustomGame(scanner, name, allHandsInput);
        }
        System.out.println("Bye!");
    }

    private static void playCustomGame(Scanner scanner, String name, String allHandsInput) {
        GameService gameService = new GameService();
        Rating rating = gameService.getGameRating(name);
        while (true) {
            String input = scanner.nextLine();
            if ("!exit".equals(input)) {
                break;
            }
            if ("!rating".equals(input)) {
                System.out.println("Your rating: " + rating.getScore());
                continue;
            }
            try {
                CustomGame game = gameService.createNewCustomGame(input, rating, allHandsInput);
                gameService.playCustomGame(game);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void playClassicGame(Scanner scanner, String name) {
        GameService gameService = new GameService();
        Rating rating = gameService.getGameRating(name);
        while (true) {
            String input = scanner.nextLine();
            if ("!exit".equals(input)) {
                break;
            }
            if ("!rating".equals(input)) {
                System.out.println("Your rating: " + rating.getScore());
                continue;
            }
            try {
                Game game = gameService.createNewGame(input, rating);
                gameService.playGame(game);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

