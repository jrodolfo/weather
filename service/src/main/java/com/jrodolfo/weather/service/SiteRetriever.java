package com.jrodolfo.weather.service;

import static com.jrodolfo.weather.util.Timer.start;
import static java.lang.System.out;

import java.net.URL;
import java.util.Set;

import com.jrodolfo.weather.model.pojo.Language;
import com.jrodolfo.weather.model.pojo.Province;
import com.jrodolfo.weather.model.pojo.Site;
import com.jrodolfo.weather.util.Timer;

public class SiteRetriever {

    private final SiteService service;

    public SiteRetriever(URL serviceUrl) {
        service = new SiteServiceImpl();
        service.loadSiteCollections(serviceUrl);
    }

    public void run() {
        getSiteByLanguageAndName(Language.EN, "halifax");
        getSitesByLanguageAndProvince(Language.EN, Province.NS);
    }

    public Site getSiteByLanguageAndName(Language lang, String siteName) {
        final Timer t = start();
        final Site result = service.getSiteByExactName(lang, siteName);
        long duration = t.stop();
        print(lang, siteName, result, duration);
        return result;
    }

    public Set<Site> getSitesByLanguageAndProvince(Language lang, Province prov) {
        final Timer t = start();
        final Set<Site> result = service.getSitesByLanguageAndProvince(lang, prov);
        long duration = t.stop();
        print(lang, prov, result, duration);
        return result;
    }

    private void print(Language lang, String siteName, Site result, long duration) {
        out.println("\n=== Retrieving site in " + lang.getName() + " using name=\"" + siteName + "\" ===\n");
        out.println(result);
        out.println("time to execute (in milliseconds): " + duration + "\n");
    }

    private void print(Language lang, Province prov, Set<Site> result, long duration) {
        out.println("\n=== Retrieving sites in " + lang.getName() + " from province " + prov.toString() + " ===\n");
        out.println(result);
        out.println("time to execute (in milliseconds): " + duration + "\n");
    }

}
