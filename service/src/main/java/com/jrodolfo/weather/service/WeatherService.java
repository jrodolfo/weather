package com.jrodolfo.weather.service;

import java.net.URL;

import com.jrodolfo.weather.model.pojo.WeatherData;

public interface WeatherService {

    /**
     * Gets the weather data from an URL that points to the Meteorological
     * Service of Canada, which is a source of several raw meteorological data
     * types and forecast data. <br>
     * More info: http://dd.weatheroffice.ec.gc.ca/about_dd_apropos.txt <br>
     * 
     * @param weatherDataURL - The URL for the weather web service
     * @return The resulting WeatherData object
     * 
     * @throws AssertionError if assert is enable AND weatherDataUrl is null
     * @throws NullPointerException if weatherDataUrl is null
     */
    WeatherData getWeather(URL weatherDataURL);
}
