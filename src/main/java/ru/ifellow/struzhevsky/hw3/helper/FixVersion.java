package ru.ifellow.struzhevsky.hw3.helper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FixVersion {
    VER_UNKNOWN("Неизвестный"),
    VER_1("Version 1.0"),
    VER_2("Version 2.0");

    private final String version;
}
