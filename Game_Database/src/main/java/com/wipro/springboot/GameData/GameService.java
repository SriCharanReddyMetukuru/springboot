package com.wipro.springboot.GameData;


import com.wipro.springboot.GameData.UserScore;
import com.wipro.springboot.GameData.UserScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    @Autowired
    private UserScoreRepository userScoreRepository;

    public String playGame(String name, int userGuess) {
        // Generate a random number between 1 and 100
        int numberToGuess = new Random().nextInt(100) + 1;
        int attempts = 0;
        int score = 0;

        // Game loop: Check if the guess is correct
        while (userGuess != numberToGuess) {
            attempts++;
            if (userGuess > numberToGuess) {
                return "Too high! Try again.";
            } else if (userGuess < numberToGuess) {
                return "Too low! Try again.";
            }
        }

        // Calculate score: Higher score for fewer attempts
        score = 100 - attempts;

        // Save the user's score to the database
        UserScore userScore = new UserScore(name, score);
        userScoreRepository.save(userScore);

        return "Congratulations, " + name + "! You guessed the number. Your score: " + score;
    }
}
