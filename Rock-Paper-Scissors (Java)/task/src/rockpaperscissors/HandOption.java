package rockpaperscissors;
import java.util.Random;

public enum HandOption {
    ROCK("paper"),
    PAPER("scissors"),
    SCISSORS("rock");


    public static final Random RANDOM = new Random();
    private final String loses;

    HandOption(String loses) {

        this.loses = loses;
    }

    public String getLoses() {
        return loses;
    }

    public static HandOption getHandFromInput(String input) throws Exception {
        HandOption[] hands = HandOption.values();
        for (HandOption hand : hands) {
            if (hand.name().toLowerCase().equals(input)) {
                return hand;
            }
        }
        throw new Exception("Invalid input");
    }
    public static HandOption getRandomHand() {
        HandOption[] hands = values();
        return hands[RANDOM.nextInt(hands.length)];
    }
}
