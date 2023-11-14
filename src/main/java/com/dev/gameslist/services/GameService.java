package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result
                .stream()
                .map(game -> new GameMinDTO(game))
                .toList();
    }
}
