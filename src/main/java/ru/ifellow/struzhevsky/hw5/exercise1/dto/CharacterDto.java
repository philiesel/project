package ru.ifellow.struzhevsky.hw5.exercise1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto {
        private int id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        private LocationDto origin;
        private LocationDto location;
        private String image;
        private List<String> episode;
        private String url;
        private String created;

        @Data
        @NoArgsConstructor
        public static class Origin {
                private String name;
                private String url;
        }
        @Data
        @NoArgsConstructor
        public static class Location {
                private String name;
                private String url;
        }
}
