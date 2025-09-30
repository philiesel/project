package ru.ifellow.struzhevsky.hw5;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import ru.ifellow.struzhevsky.hw5.exercise1.api.BaseApi;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.CharacterDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.EpisodeDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.ResultDto;
import ru.ifellow.struzhevsky.hw5.exercise1.utils.UtilsRickAndMorty;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchCharacterTest {
    private final BaseApi baseApi = new BaseApi();
    private final UtilsRickAndMorty utilsRickAndMorty = new UtilsRickAndMorty();
    private String characterName = "Morty Smith";

    @Test
    public void testGetRequest() {
        Response response = baseApi.getCharacterByName(characterName);
        ResultDto resultsDto = response.jsonPath().getObject("", ResultDto.class);
        String lastEpisodeUrl = utilsRickAndMorty.getLastEpisode(resultsDto);

        Response episodeResponse = baseApi.getCharacters(lastEpisodeUrl);
        EpisodeDto episodeDto = episodeResponse.jsonPath().getObject("", EpisodeDto.class);
        String lastCharacterInEpisode = utilsRickAndMorty.getLastCharacters(episodeDto);

        Response characterInfo = baseApi.getCharacters(lastCharacterInEpisode);
        CharacterDto lastCharacterResponse = characterInfo.jsonPath().getObject("", CharacterDto.class);
        CharacterDto characterMorty = resultsDto.getResults().get(0);

        boolean sameSpeciesOrLocation = UtilsRickAndMorty.checkSameSpeciesOrLocation(characterMorty, lastCharacterResponse);
        assertTrue(sameSpeciesOrLocation, "Ничего не совпадает");
    }
}
