package com.dev.gameslist.dto;

import com.dev.gameslist.entities.GameList;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class ListDTO {

    private Long id;
    private String name;

    public ListDTO(GameList listEntity) {
        BeanUtils.copyProperties(listEntity, this);
    }
}
