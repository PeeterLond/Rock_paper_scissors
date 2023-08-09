package rockpaperscissors;

public enum GameResult {
    LOSS("Sorry, but the computer chose <option>", 0),
    DRAW("There is a draw (<option>)", 50),
    WIN("Well done. The computer chose <option> and failed", 100);


    private final String text;
    private final int score;

    GameResult(String text, int score) {

        this.text = text;
        this.score = score;
    }

    public String getText() {
        return text;
    }
    public int getScore() {
        return score;
    }
}
