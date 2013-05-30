package com.jrodolfo.weather.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import com.jrodolfo.weather.model.pojo.Language;
import com.jrodolfo.weather.model.pojo.Province;
import com.jrodolfo.weather.model.pojo.Site;

public class Main {

    /**
     * List of sites (locations) in Canada TODO: This URL should be externalized
     */
    private static final String URL_SITES = "http://dd.weatheroffice.gc.ca/citypage_weather/siteList.xml";

    /**
     * This is the service implementation for the Java app that sits in system
     * tray, shows an icon for the current local weather, and displays weather
     * details on click.
     * 
     * @param args - the command line arguments
     * @throws MalformedURLException
     */
    public static void main(String[] args) throws MalformedURLException {
        
        // Testing SiteRetriever:
        //new SiteRetriever(new URL(URL_SITES)).run();
        
        // Create object siteRetriever to be used for the tests:
        SiteRetriever siteRetriever = new SiteRetriever(new URL(URL_SITES));
        
        // Testing getSitesByLanguageAndProvince():
        @SuppressWarnings("unused")
        Set<Site> setOfSite = siteRetriever.getSitesByLanguageAndProvince(Language.EN, Province.NS);
        
        // Testing getSiteByLanguageAndName(), so that we can build the URL for the
        // weather service. This URL should be like this:
        // http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/NS/s0000084_e.xml
        Site site = siteRetriever.getSiteByLanguageAndName(Language.EN, "halifax");
        final String prov = site.getProvinceCode().toString();
        final String siteCode = site.getSiteCode();
        final String lang = site.getLanguage().getOneLetterCode();
        final String urlFixedPart = "http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/";
        final String URL_WEATHER = urlFixedPart + prov + "/" + siteCode + "_" + lang + ".xml";
        
        // Testing WeatherRetriever using URL built in the previous lines:
        new WeatherRetriever(new URL(URL_WEATHER)).run();
    }
}
