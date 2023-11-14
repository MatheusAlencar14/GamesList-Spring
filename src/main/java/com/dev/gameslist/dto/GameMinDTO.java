package com.dev.gameslist.dto;

import com.dev.gameslist.entities.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game gameEntity) {
        id = gameEntity.getId();
        title = gameEntity.getTitle();
        year = gameEntity.getYear();
        imgUrl = gameEntity.getImgUrl();
        shortDescription = gameEntity.getShortDescription();
    }
}