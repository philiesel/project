package ru.ifellow.struzhevsky.hw3.helper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TypeTask {
    TYPE_TASK("Задача"),
    TYPE_STORY("История"),
    TYPE_ERROR("Ошибка"),
    TYPE_EPIC("Epic");

    private final String task;
}
