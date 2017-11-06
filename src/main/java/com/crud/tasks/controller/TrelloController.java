package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
        //toDo (filtrowanie po fladze closed)
//        List<TrelloBoardDto> trelloBoards = trelloService.fetchTrelloBoards();
//        trelloBoards.stream()
//                .map(TrelloBoardDto::getLists)
//                .filter(x -> x.stream()
//                .filter(y -> y.isClosed()))
//                .collect(Collectors.toList());
//
//        List<TrelloBoardDto> openList = trelloBoards.stream()
//                .map(TrelloListDto::isClosed)
//                .filter(Boolean::toString)
//                .forEach(System.out::println);
//        return openList;
    }

        @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
        public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createdTrelloCard(trelloCardDto);
    }
}