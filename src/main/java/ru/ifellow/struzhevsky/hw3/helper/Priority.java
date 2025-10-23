package ru.ifellow.struzhevsky.hw3.helper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Priority {
    PRIORITY_MEDIUM("Medium"),
    PRIORITY_HIGHEST("Highest"),
    PRIORITY_LOW("Low"),
    PRIORITY_LOWEST("Lowest");

    private final String priority;
}
