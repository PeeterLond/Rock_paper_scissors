package rockpaperscissors;

import java.util.List;

public class CustomGame {
    String playerHand;
    String computerHand;
    GameResult gameResult;
    Rating rating;
    List<String> playerWillWinHands;

    public CustomGame(String playerHand, String computerHand,
                      Rating rating, List<String> playerWillWinHands) {
        this.playerHand = playerHand;
        this.computerHand = computerHand;
        this.rating = rating;
        this.playerWillWinHands = playerWillWinHands;
    }
    public void updateGameScore() {
        rating.addToScore(gameResult.getScore());
    }

    public String getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(String playerHand) {
        this.playerHand = playerHand;
    }

    public String getComputerHand() {
        return computerHand;
    }

    public void setComputerHand(String computerHand) {
        this.computerHand = computerHand;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<String> getPlayerWillWinHands() {
        return playerWillWinHands;
    }

    public void setPlayerWillWinHands(List<String> playerWillWinHands) {
        this.playerWillWinHands = playerWillWinHands;
    }
}
