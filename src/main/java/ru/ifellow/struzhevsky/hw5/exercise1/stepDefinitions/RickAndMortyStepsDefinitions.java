package ru.ifellow.struzhevsky.hw5.exercise1.stepDefinitions;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.ifellow.struzhevsky.hw5.exercise1.api.BaseApi;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.CharacterDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.EpisodeDto;
import ru.ifellow.struzhevsky.hw5.exercise1.dto.ResultDto;
import ru.ifellow.struzhevsky.hw5.exercise1.utils.UtilsRickAndMorty;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.ifellow.struzhevsky.hw5.exercise2.utils.Configuration.getProperty;

public class RickAndMortyStepsDefinitions {
    private final BaseApi baseApi = new BaseApi();
    private final UtilsRickAndMorty utils = new UtilsRickAndMorty();
    private ResultDto mortyResult;
    private EpisodeDto lastEpisode;
    private CharacterDto lastCharacter;

    @Step("Поиск персонажа Морти Смит")
    @Когда("нашел информацию по персонажу Морти Смит")
    public void getInfoMorty() {
        Response response = baseApi.getCharacterByName(getProperty("characterName"));
        mortyResult = response.jsonPath().getObject("", ResultDto.class);
    }

    @Step("Получение последнего эпизода с участием Морти Смит")
    @И("получил последний эпизод, где появляется Морти Смит")
    public void getLastEpisodeOfMorty() {
        String lastEpisodeUrl = utils.getLastEpisode(mortyResult);
        Response episodeResponse = baseApi.getCharacters(lastEpisodeUrl);
        lastEpisode = episodeResponse.jsonPath().getObject("", EpisodeDto.class);
    }

    @Step("Последний персонаж из эпизода")
    @Тогда("я получил последнего персонажа из этого эпизода")
    public void getLastCharacterInEpisode() {
        String lastCharacterUrl = utils.getLastCharacters(lastEpisode);
        Response characterResponse = baseApi.getCharacters(lastCharacterUrl);
        lastCharacter = characterResponse.jsonPath().getObject("", CharacterDto.class);
    }

    @Step("Проверяю место нахождение и рассу последнего персонажа с Морти")
    @Затем("я сверяю нахождение и рассу персонажа с данными Морти Смита")
    public void checkSameSpeciesAndLocation() {
        CharacterDto morty = mortyResult.getResults().get(0);
        boolean sameSpeciesOrLocation = UtilsRickAndMorty.checkSameSpeciesOrLocation(morty, lastCharacter);
        assertTrue(sameSpeciesOrLocation, "Ничего не совпадает");
    }
}
