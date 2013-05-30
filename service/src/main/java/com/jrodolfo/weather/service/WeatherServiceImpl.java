package com.jrodolfo.weather.service;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jrodolfo.weather.model.jaxbgenerated.site.CurrentConditionsType;
import com.jrodolfo.weather.model.jaxbgenerated.site.SiteData;
import com.jrodolfo.weather.model.pojo.WeatherData;

public class WeatherServiceImpl implements WeatherService {

    /**
     * The XML parsing is done using JAXB: the XML structure
     * is loaded into memory and some DOM methods are used to work with it. <br>
     * @param weatherDataURL - the URL for the weather web service
     * @return - WeatherData object
     * @throws AssertionError if assert is enable AND weatherDataUrl is null
     * @throws NullPointerException if weatherDataUrl is null
     * @throws IllegalStateException in case there is a JAXBException
     */
    @Override
    public WeatherData getWeather(URL weatherDataURL) {
        assert weatherDataURL != null;

        final WeatherData weatherData = new WeatherData();
        final JAXBContext jaxbContext;
        final Unmarshaller unmarshaller;
        SiteData siteData = null;

        try {
            jaxbContext = JAXBContext.newInstance(com.jrodolfo.weather.model.jaxbgenerated.site.ObjectFactory.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            siteData = (SiteData) unmarshaller.unmarshal(weatherDataURL);
        } catch (JAXBException e) {
            throw new IllegalStateException(e);
        }

        if (siteData != null) {
            // Get the data from the XML structure and set the weather data
            weatherData.setLocation(siteData.getLocation().getName().getValue());
            weatherData.setDateTimeUTC(siteData.getDateTime().get(0).getTextSummary());
            weatherData.setDateTimeADT(siteData.getDateTime().get(1).getTextSummary());
            CurrentConditionsType cc = siteData.getCurrentConditions();
            weatherData.setCondition(cc.getCondition());
            weatherData.setIconCode(cc.getIconCode().getValue());
            weatherData.setTemperature(cc.getTemperature().getValue());
            weatherData.setTemperatureUnit(" °" + cc.getTemperature().getUnits());
            weatherData.setHumidity(cc.getRelativeHumidity().getValue());
            weatherData.setHumidityUnit(cc.getRelativeHumidity().getUnits());
            weatherData.setDewPoint(cc.getDewpoint().getValue());
            weatherData.setDewPointUnit(" °" + cc.getDewpoint().getUnits());
            weatherData.setPressure(cc.getPressure().getValue());
            weatherData.setPressureUnit(cc.getPressure().getUnits().value());
            weatherData.setPressureTendency(cc.getPressure().getTendency());
            weatherData.setVisibility(cc.getVisibility().getValue());
            weatherData.setVisibilityUnit(cc.getVisibility().getUnits().value());
            weatherData.setWindSpeed(cc.getWind().getSpeed().getValue());
            weatherData.setWindSpeedUnit(cc.getWind().getSpeed().getUnits().value());
            weatherData.setWindDirection(cc.getWind().getDirection());
        }

        return weatherData;
    }

}
