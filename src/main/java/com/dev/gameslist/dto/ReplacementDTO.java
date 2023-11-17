package com.dev.gameslist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplacementDTO {

    private Integer sourceIndex;
    private Integer destinationIndex;
}
