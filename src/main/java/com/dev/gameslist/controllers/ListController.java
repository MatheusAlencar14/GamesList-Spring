package com.dev.gameslist.controllers;

import com.dev.gameslist.dto.ListDTO;
import com.dev.gameslist.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class ListController {

    @Autowired
    public ListService listService;

    @GetMapping
    public List<ListDTO> findAll() {
        List<ListDTO> list = listService.findAll();
        return list;
    }
}
