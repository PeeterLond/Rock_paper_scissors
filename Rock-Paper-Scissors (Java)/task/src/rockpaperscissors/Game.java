package rockpaperscissors;

public class Game {
    private HandOption playerHand;
    private HandOption computerHand;
    private GameResult gameResult;
    private Rating rating;

    public Game(HandOption playerHand, HandOption computerHand, Rating rating) {
        this.playerHand = playerHand;
        this.computerHand = computerHand;
        this.rating = rating;
    }

    public HandOption getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(HandOption playerHand) {
        this.playerHand = playerHand;
    }

    public HandOption getComputerHand() {
        return computerHand;
    }

    public void setComputerHand(HandOption computerHand) {
        this.computerHand = computerHand;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void updateGameScore() {
        rating.addToScore(gameResult.getScore());
    }
}
