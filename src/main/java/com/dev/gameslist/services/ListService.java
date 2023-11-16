package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.ListDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.entities.GameList;
import com.dev.gameslist.repositories.ListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    @Transactional
    public List<ListDTO> findAll() {
        List<GameList> result = listRepository.findAll();
        return result.stream().map(x -> new ListDTO(x)).toList();
    }
}
