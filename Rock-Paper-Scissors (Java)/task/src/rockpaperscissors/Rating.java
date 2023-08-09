package rockpaperscissors;

public class Rating {
    private String name;
    private int score;

    public Rating(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void addToScore(int score) {
        this.score += score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
