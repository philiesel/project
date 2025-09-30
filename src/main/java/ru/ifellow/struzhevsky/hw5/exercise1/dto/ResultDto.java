package ru.ifellow.struzhevsky.hw5.exercise1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResultDto {
    private InfoDto info;
    private List<CharacterDto> results;
}
