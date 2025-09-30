package ru.ifellow.struzhevsky.hw5.exercise1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InfoDto {
        private int count;
        private int pages;
        private String next;
        private String prev;
}
