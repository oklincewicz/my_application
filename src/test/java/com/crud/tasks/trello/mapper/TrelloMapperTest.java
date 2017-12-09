package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrelloMapperTest {

    TrelloMapper mapper = new TrelloMapper();

    @Test
    public void testMapToBoard() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(new TrelloBoard("01", "Board to Test", lists));

        List<TrelloListDto> listDtos = new ArrayList<>();
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("Board to Test", "01", listDtos));

        //When
        List<TrelloBoard> trelloBoards = mapper.mapToBoard(boardDtos);

        //Then
        assertEquals(1, trelloBoards.size());
        assertEquals(boards.get(0).getLists(), trelloBoards.get(0).getLists());
        assertEquals("Board to Test", trelloBoards.get(0).getName());
        assertEquals("01", trelloBoards.get(0).getId());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        List<TrelloBoard> boards = new ArrayList<>();
        boards.add(new TrelloBoard("01", "Board to Test", lists));

        List<TrelloListDto> listDtos = new ArrayList<>();
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("Board to Test", "01", listDtos));

        //When
        List<TrelloBoardDto> trelloBoardDtos = mapper.mapToBoardDto(boards);

        //Then
        assertEquals(1, trelloBoardDtos.size());
        assertEquals(boardDtos.get(0).getLists(), trelloBoardDtos.get(0).getLists());
        assertEquals("Board to Test", trelloBoardDtos.get(0).getName());
        assertEquals("01", trelloBoardDtos.get(0).getId());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listDtos = new ArrayList<>();
        listDtos.add(new TrelloListDto("01", "List to Test", true));

        //When
        List<TrelloList> lists = mapper.mapToList(listDtos);

        //Then
        assertEquals(1, lists.size());
        assertEquals("01", lists.get(0).getId());
        assertEquals("List to Test", lists.get(0).getName());
        assertTrue(lists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList("01", "List to Test", false));

        //When
        List<TrelloListDto> listDtos = mapper.mapToListDto(lists);

        //Then
        assertEquals(1, listDtos.size());
        assertEquals("01", listDtos.get(0).getId());
        assertEquals("List to Test", listDtos.get(0).getName());
        assertFalse(listDtos.get(0).isClosed());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard card = new TrelloCard("Card to Test", "Testing card", "xxx", "0");

        //When
        TrelloCardDto trelloCardDto = mapper.mapToCardDto(card);

        //Then
        assertEquals("Card to Test", trelloCardDto.getName());
        assertEquals("Testing card", trelloCardDto.getDescription());
        assertEquals("xxx", trelloCardDto.getPos());
        assertEquals("0", trelloCardDto.getListId());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto cardDto = new TrelloCardDto("Card to Test", "Testing card", "xxx", "0");

        //When
        TrelloCard trelloCard = mapper.mapToCard(cardDto);

        //Then
        assertEquals("Card to Test", trelloCard.getName());
        assertEquals("Testing card", trelloCard.getDescription());
        assertEquals("xxx", trelloCard.getPos());
        assertEquals("0", trelloCard.getListId());
    }

}