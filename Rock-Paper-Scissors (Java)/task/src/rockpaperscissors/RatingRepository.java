package rockpaperscissors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatingRepository {

    public List<Rating> getAllRatingsFromFile() {
        List<Rating> ratings = new ArrayList<>();
//        String fileName = "Rock-Paper-Scissors (Java)/task/src/rockpaperscissors/rating.txt";
        String fileName = "rating.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] nameScore = line.split(" ");
                Rating rating = new Rating(nameScore[0], Integer.parseInt(nameScore[1]));
                ratings.add(rating);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratings;
    }

}