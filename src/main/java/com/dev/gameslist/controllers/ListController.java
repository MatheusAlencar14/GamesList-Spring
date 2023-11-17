package com.dev.gameslist.controllers;

import com.dev.gameslist.dto.GameMinDTO;
import com.dev.gameslist.dto.ListDTO;
import com.dev.gameslist.dto.ReplacementDTO;
import com.dev.gameslist.services.GameService;
import com.dev.gameslist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    public ListService listService;

    @Autowired
    public GameService gameService;

    @GetMapping
    public List<ListDTO> findAll() {
        List<ListDTO> list = listService.findAll();
        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> list = gameService.findByList(listId);
        return list;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        listService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
