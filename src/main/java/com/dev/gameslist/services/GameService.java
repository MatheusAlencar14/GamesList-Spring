package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.projections.GameMinProjection;
import com.dev.gameslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result
                .stream()
                .map(game -> new GameMinDTO(game))
                .toList();
    }

    @Transactional
    public List<GameMinDTO> findByList(Long listid) {
        List<GameMinProjection> result = gameRepository.searchByList(listid);
        return result
                .stream()
                .map(game -> new GameMinDTO(game))
                .toList();
    }
}
