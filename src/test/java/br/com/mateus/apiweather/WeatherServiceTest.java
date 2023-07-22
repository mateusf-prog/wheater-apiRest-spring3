package br.com.mateus.apiweather;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

import br.com.mateus.apiweather.models.dto.CityData;
import br.com.mateus.apiweather.models.dto.WeatherData;
import br.com.mateus.apiweather.services.WeatherService;

@SpringBootTest
@SpringJUnitConfig
public class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private WeatherData weatherData;
    @Mock
    private CityData cityData;


    @Test
    public void testValidateLatiduteLongitude() {
        Assertions.assertTrue(weatherService.validateLatiduteLongitude(40.7128,-74.0060));
        Assertions.assertFalse(weatherService.validateLatiduteLongitude(-50, 190));
    }

    @Test
    public void testGetCityByCoordinates() {
        Assertions.assertNotNull(weatherService.getAdressByCoordinates(0, 0));
    }
}
