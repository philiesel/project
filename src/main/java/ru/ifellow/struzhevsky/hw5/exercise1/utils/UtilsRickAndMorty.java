package ru.ifellow.struzhevsky.hw5.exercise1.utils;

import ru.ifellow.struzhevsky.hw5.exercise1.dto.CharacterDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.EpisodeDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.ResultDto;

import java.util.List;

public class UtilsRickAndMorty {
    public String getLastEpisode(ResultDto resultsDto) {
        List<CharacterDto> characters = resultsDto.getResults();
        int countEpisodes = characters.get(0).getEpisode().size();
        return characters.get(0).getEpisode().get(countEpisodes - 1);
    }

    public String getLastCharacters(EpisodeDto episodeDto) {
        List<String> lastEpisodeCharacters = episodeDto.getCharacters();
        return lastEpisodeCharacters.get(lastEpisodeCharacters.size() - 1);
    }

    public static boolean checkSameSpeciesOrLocation(CharacterDto character1, CharacterDto character2) {
        String character1Species = character1.getSpecies();
        String character1Location = character1.getLocation().getName();
        String anotherCharacterSpecies = character2.getSpecies();
        String anotherCharacterLocation = character2.getLocation().getName();

        return character1Species.equalsIgnoreCase(anotherCharacterSpecies) ||
                character1Location.equalsIgnoreCase(anotherCharacterLocation);
    }
}
