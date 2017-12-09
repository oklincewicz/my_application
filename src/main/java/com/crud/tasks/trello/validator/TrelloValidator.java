package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloValidator.class);

    public void validatorCard(final TrelloCard trelloCard) {
        if(trelloCard.getName().contains("test")) {
            LOGGER.info("Someon is testing my application!");
        } else {
            LOGGER.info("Seems that my appliction is used in propery way.");
        }
    }

    public List<TrelloBoard> validatorTrelloBoard(final List<TrelloBoard> trelloBoards) {
        LOGGER.info("Starting filtering board...");
        List<TrelloBoard> filteredBoards = trelloBoards.stream()
                .filter(trelloBoard -> trelloBoard.getName().equalsIgnoreCase("test"))
                .collect(Collectors.toList());
        LOGGER.info("Board has been filtered. Current list size: " + filteredBoards.size());
        return filteredBoards;
    }
}
