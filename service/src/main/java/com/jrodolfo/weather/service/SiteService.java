package com.jrodolfo.weather.service;

import java.net.URL;
import java.util.Set;

import com.jrodolfo.weather.model.pojo.Language;
import com.jrodolfo.weather.model.pojo.Province;
import com.jrodolfo.weather.model.pojo.Site;

/**
 * Gets the sites in Canada which the Environment Canada provides
 * the weather data for. The info comes from:<br>
 * <br>
 * http://dd.weatheroffice.gc.ca/citypage_weather/siteList.xml<br>
 * <br>
 * More info:<br>
 * http://dd.weatheroffice.ec.gc.ca/about_dd_apropos.txt <br>
 */
public interface SiteService {

    /**
     * Load a map of Site objects from an url
     */
    void loadSiteCollections(URL sitesUrl);

    /**
     * @return A set of Site objects from some province, in English of French
     */
    Set<Site> getSitesByLanguageAndProvince(Language lang, Province prov);
    
    /**
     * @param String siteCode - the Environment Canada's code for each site.
     * Example: s0000318 is the code for Halifax.
     * @return The SiteData for the siteCode.
     */
    Site getSiteByCode(String siteCode);

    /**
     * This method lookup for a site and tries to match the name
     * of the site in English or French, depending on the value
     * of the lang parameter. The lookup is not case sensitive,
     * so looking up for "halifax", "Halifax", and "HALIFAX"
     * brings the same result. The method does not find similar
     * matches, i.e. even though it is possible to find
     * "Halifax" and "Halifax (Shearwater)" when looking up for "Halifax",
     * the method will only consider the exact match.
     * @param String prov - province code. Example: NS means Nova Scotia.
     * @param String lang - language used to lookup the sites. It can be either English or French.
     * @return The Site object for that site Name.
     */
     Site getSiteByExactName(Language lang, String searchExp);

     /**
      * This method lookup for a site and tries to match the name
      * of the site in English or French, depending on the value
      * of the lang parameter. The lookup is not case sensitive,
      * so looking up for "halifax", "Halifax", and "HALIFAX"
      * brings the same result. The method finds similar
      * matches, i.e. it brings "Halifax" and "Halifax (Shearwater)"
      * when looking up for "Halifax".
      * @param String prov - province code. Example: NS means Nova Scotia.
      * @param String lang - language used to lookup the sites. It can be either English or French.
      * @return The Site object for that site Name.
      */
      Site getSiteBySimilarName(Language lang, String searchExp);
}
