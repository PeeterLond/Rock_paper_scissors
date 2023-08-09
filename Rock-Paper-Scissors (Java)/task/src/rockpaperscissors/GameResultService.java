package rockpaperscissors;

public class GameResultService {

    public void processAndGetGameResult(Game game) {
        HandOption playerHand = game.getPlayerHand();
        HandOption computerHand = game.getComputerHand();
        if (playerHand.equals(computerHand)) {
            game.setGameResult(GameResult.DRAW);
        } else if (playerHand.getLoses().equals(computerHand.name().toLowerCase())) {
            game.setGameResult(GameResult.LOSS);
        } else {
            game.setGameResult(GameResult.WIN);
        }

    }

    public void printResult(Game game) {
        String resultText = game.getGameResult().getText();
        String computerHandText = game.getComputerHand().name().toLowerCase();
        System.out.println(resultText.replace("<option>", computerHandText));
    }

    public void processAndGetCustomGameResult(CustomGame customGame) {
        String playerHand = customGame.getPlayerHand();
        String computerHand = customGame.getComputerHand();
        if (playerHand.equals(computerHand)) {
            customGame.setGameResult(GameResult.DRAW);
        } else if (customGame.playerWillWinHands.contains(computerHand)) {
            customGame.setGameResult(GameResult.WIN);
        } else {
            customGame.setGameResult(GameResult.LOSS);
        }

    }

    public void printCustomGameResult(CustomGame customGame) {
        String resultText = customGame.gameResult.getText();
        System.out.println(resultText.replace("<option>", customGame.getComputerHand()));
    }
}
