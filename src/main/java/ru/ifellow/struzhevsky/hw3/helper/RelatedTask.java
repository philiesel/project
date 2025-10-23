package ru.ifellow.struzhevsky.hw3.helper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RelatedTask {
    RELATED_BLOCK("blocks"),
    RELATED_CLONES("clones");

    private final String related;
}
