package ru.ifellow.struzhevsky.hw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
}
