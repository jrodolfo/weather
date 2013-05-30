package com.jrodolfo.weather.service;

import java.net.URL;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.jrodolfo.weather.model.jaxbgenerated.siteList.SiteList;
import com.jrodolfo.weather.model.jaxbgenerated.siteList.SiteType;
import com.jrodolfo.weather.model.pojo.Language;
import com.jrodolfo.weather.model.pojo.Province;
import com.jrodolfo.weather.model.pojo.Site;
import com.jrodolfo.weather.model.pojo.SiteCollections;

public class SiteServiceImpl implements SiteService {
    SiteCollections siteCollections;

    public SiteServiceImpl() {
        siteCollections = new SiteCollections();
    }

    @Override
    public void loadSiteCollections(URL sitesUrl) {
        assert sitesUrl != null;

        JAXBContext jaxbContext = null;
        Unmarshaller unmarshaller = null;
        SiteList siteList = null;

        try {
            jaxbContext = JAXBContext
                    .newInstance(com.jrodolfo.weather.model.jaxbgenerated.siteList.ObjectFactory.class);
            unmarshaller = jaxbContext.createUnmarshaller();
            siteList = (SiteList) unmarshaller.unmarshal(sitesUrl);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (siteList != null) {
            for (SiteType s : siteList.getSite()) {
                Site siteEn = new Site(s.getCode(), s.getNameEn(), Language.EN,
                        Province.valueOf(s.getProvinceCode()));
                Site siteFr = new Site(s.getCode(), s.getNameFr(), Language.FR,
                        Province.valueOf(s.getProvinceCode()));
                siteCollections.addToSitesMappedByLangAndName(siteEn);
                siteCollections.addToSitesMappedByLangAndName(siteFr);
                siteCollections.addToSitesMappedByLangAndProv(siteEn);
                siteCollections.addToSitesMappedByLangAndProv(siteFr);
            }
        }
    }

    @Override
    public Site getSiteByCode(String siteCode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Site getSiteByExactName(Language lang, String searchExp) {

        Map<Language, Map<String, Site>> mapFromLangAndNameToSite = null;
        Map<String, Site> mapFromNameToSite = null;
        Site site = null;

        if (searchExp != null && lang != null) {
            mapFromLangAndNameToSite = siteCollections
                    .getSitesMappedByLangAndName();
            mapFromNameToSite = mapFromLangAndNameToSite.get(lang);
            site = mapFromNameToSite.get(searchExp.toUpperCase());
        } else {
            throw new IllegalArgumentException();
        }
        return site;
    }

    @Override
    public Site getSiteBySimilarName(Language lang, String searchExp) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Site> getSitesByLanguageAndProvince(Language lang, Province prov) {
        if (lang != null && prov != null) {
            return siteCollections.getSitesMappedByLangAndProv(lang, prov);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
