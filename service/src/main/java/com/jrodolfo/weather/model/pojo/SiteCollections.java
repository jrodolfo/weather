package com.jrodolfo.weather.model.pojo;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public final class SiteCollections {

    private Map<Language, Map<String, Site>> sitesMappedByLangAndName;
    private Map<Language, Map<Province, Set<Site>>> sitesMappedByLangAndProv;

    public SiteCollections() {
        sitesMappedByLangAndName = new TreeMap<>();

        for (Language lang : Language.values()) {
            sitesMappedByLangAndName.put(lang, new TreeMap<String, Site>());
        }

        sitesMappedByLangAndProv = new TreeMap<>();
        for (Language lang : Language.values()) {
            for (Province prov : Province.values()) {
                Map<Province, Set<Site>> mapFromProvinceToSetOfSites = new TreeMap<>();
                mapFromProvinceToSetOfSites.put(prov, new TreeSet<Site>());
                sitesMappedByLangAndProv.put(lang, mapFromProvinceToSetOfSites);
            }
        }
    }

    public void addToSitesMappedByLangAndName(Site site) {
        if (site != null) {
            Language lang = site.getLanguage();
            Map<String, Site> mapOfSite = sitesMappedByLangAndName.get(lang);
            mapOfSite.put(site.getName().toUpperCase(), site);
            sitesMappedByLangAndName.put(lang, mapOfSite);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Map<Language, Map<String, Site>> getSitesMappedByLangAndName() {
        return sitesMappedByLangAndName;
    }

    public void addToSitesMappedByLangAndProv(Site site) {
        if (site != null) {
            Language lang = site.getLanguage();
            Province prov = site.getProvinceCode();

            Map<Province, Set<Site>> mapFromProvToSetOfSites = sitesMappedByLangAndProv.get(lang);
            Set<Site> setOfSite = mapFromProvToSetOfSites.get(prov);

            if (setOfSite == null) {
                setOfSite = new TreeSet<>();
            }

            setOfSite.add(site);
            mapFromProvToSetOfSites.put(prov, setOfSite);
            sitesMappedByLangAndProv.put(lang, mapFromProvToSetOfSites);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Set<Site> getSitesMappedByLangAndProv(Language lang, Province prov) {
        if (lang != null && prov != null) {
            Map<Province, Set<Site>> mapFromProvinceToSetOfSites = sitesMappedByLangAndProv
                .get(lang);
            Set<Site> setOfSite = mapFromProvinceToSetOfSites.get(prov);
            return setOfSite;
        } else {
            throw new IllegalArgumentException();
        }
    }

}
