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
}
