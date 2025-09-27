package ru.ifellow.struzhevsky.hw5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponseDto {
    private InfoDto info;
    private List<CharacterDto> results;
}
