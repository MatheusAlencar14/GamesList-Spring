package com.dev.gameslist.services;

import com.dev.gameslist.dto.GameDTO;
import com.dev.gameslist.dto.ListDTO;
import com.dev.gameslist.entities.Game;
import com.dev.gameslist.entities.GameList;
import com.dev.gameslist.projections.GameMinProjection;
import com.dev.gameslist.repositories.GameRepository;
import com.dev.gameslist.repositories.ListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public List<ListDTO> findAll() {
        List<GameList> result = listRepository.findAll();
        return result.stream().map(x -> new ListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, Integer sourceIndex, Integer destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.get(sourceIndex);
        list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            listRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
