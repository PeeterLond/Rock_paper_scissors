package rockpaperscissors;

import java.util.*;

public class GameService {

    public static final Random RANDOM = new Random();


    public Game createNewGame(String input, Rating rating) throws Exception {
        HandOption playerHand = HandOption.getHandFromInput(input);
        HandOption computerHand = HandOption.getRandomHand();
        return new Game(playerHand, computerHand, rating);
    }

    public void playGame(Game game) {
        GameResultService gameResultService = new GameResultService();
        gameResultService.processAndGetGameResult(game);
        gameResultService.printResult(game);
        game.updateGameScore();
    }

    public Rating getGameRating(String name) {
        RatingRepository ratingRepository = new RatingRepository();
        List<Rating> ratings = ratingRepository.getAllRatingsFromFile();

        return getExistingOrNewRating(ratings, name);
    }

    private Rating getExistingOrNewRating(List<Rating> ratings, String name) {
        for (Rating rating : ratings) {
            if (rating.getName().equals(name)) {
                return rating;
            }
        }
        return new Rating(name, 0);
    }
    public CustomGame createNewCustomGame(String playerHand, Rating rating, String allHandsInput) throws Exception {
        validateAllHandsInput(playerHand, allHandsInput);
        String computerHand = getComputerHandFromAllHandsInput(allHandsInput);
        int nrOfWinningHands = calculateNumberOfWinningHands(allHandsInput);
        List<String> playerWillWinHands = getPlayerWillWinHands(playerHand, allHandsInput, nrOfWinningHands);


        return new CustomGame(playerHand, computerHand, rating, playerWillWinHands);
    }

    public void playCustomGame(CustomGame customGame) {
        GameResultService gameResultService = new GameResultService();
        gameResultService.processAndGetCustomGameResult(customGame);
        gameResultService.printCustomGameResult(customGame);
        customGame.updateGameScore();
    }

    private List<String> getPlayerWillWinHands(String playerHand, String allHandsInput, int nrOfWinningHands) {
        List<String> extendedAllHands = getExtendedAllHands(allHandsInput);
        List<String> playerWillWinHands = new ArrayList<>();
        for (int i = extendedAllHands.size() - 1; i >= 0; i--) {
            if (extendedAllHands.get(i).equals(playerHand)) {
                for (int j = 1; j <= nrOfWinningHands; j++) {
                    playerWillWinHands.add(extendedAllHands.get(i - j));
                }
                break;
            }
        }
        return playerWillWinHands;
    }

    private List<String> getExtendedAllHands(String allHandsInput) {
        String allHandsDouble = allHandsInput + "," + allHandsInput;
        String[] handsSplit = allHandsDouble.split(",");
        return Arrays.stream(handsSplit).toList();
    }

    private int calculateNumberOfWinningHands(String allHandsInput) {
        String[] split = allHandsInput.split(",");
        return (split.length - 1) / 2;
    }

    private String getComputerHandFromAllHandsInput(String allHandsInput) {
        String[] split = allHandsInput.split(",");
        return split[RANDOM.nextInt(split.length)];
    }

    private void validateAllHandsInput(String playerHand, String allHandsInput) throws Exception {
        if (!allHandsInput.contains(playerHand)) {
            throw new Exception("Invalid input");
        }
    }
}
