package com.wipro.springboot.GameData;


import com.wipro.springboot.GameData.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    // Endpoint to play the game by sending name and guess
    @PostMapping("/play")
    public String playGame(@RequestParam String name, @RequestParam int userGuess) {
        return gameService.playGame(name, userGuess);
    }
}
