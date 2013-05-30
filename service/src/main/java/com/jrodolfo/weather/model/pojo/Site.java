package com.jrodolfo.weather.model.pojo;

/**
 * A Java Bean class that contains the weather data for a location. The data comes from
 * Environment Canada at:
 * http://dd.weatheroffice.gc.ca/citypage_weather/siteList.xml<br>
 * Each object store the name in only one language, which is specified by the field lang.
 */
public class Site implements Comparable<Site> {

    private String code;
    private String name;
    private Language lang;
    private Province prov;

    public Site(String code, String name, Language lang, Province prov) {
        this.code = code;
        this.name = name;
        this.lang = lang;
        this.prov = prov;
    }

    @Override
    public int compareTo(Site site) {
        if (site != null) {
            return this.name.compareTo(site.getName());
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns a brief description of the site. The exact details of the
     * representation are unspecified and subject to change, but the following
     * may be regarded as typical: <br>
     * &nbsp;<br>
     * code: s0000318<br>
     * name: Halifax<br>
     * province: NS<br>
     * language: EN<br>
     * @return String site
     */
    @Override
    public String toString() {
        StringBuffer weather = new StringBuffer();
        weather.append("\ncode: " + code + "\n");
        weather.append("name: " + name + "\n");
        weather.append("province: " + prov + "\n");
        weather.append("language: " + lang + "\n");
        return weather.toString();
    }

    public String getSiteCode() {
        return code;
    }

    public void setSiteCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return lang;
    }

    public void setLanguage(Language language) {
        this.lang = language;
    }

    public Province getProvinceCode() {
        return prov;
    }

    public void setProvinceCode(Province prov) {
        this.prov = prov;
    }

    // Test for equality with another object
    @Override
    public boolean equals(Object o) {
        if (o == this) // identical references?
            return true;
        if (!(o instanceof Site)) // correct type and non-null?
            return false;
        Site that = (Site) o; // cast to our type
        if (this.code == that.code
            && this.name == that.name
            && this.lang == that.lang
            && this.prov == that.prov)
            return true; // if all fields match
        else
            return false; // if fields differ
    }

    /**
     * A hash code allows an object to be used in a hash table.
     * Equal objects must have equal hash codes. Unequal objects are allowed
     * to have equal hash codes as well, but we try to avoid that.
     * We must override this method since we also override equals().
     * This hash code algorithm is from the book Effective Java, by Joshua Bloch
     */
    @Override
    public int hashCode() {
        int result = 17; // 
        result = 37 * result + code.hashCode(); // 
        result = 37 * result + name.hashCode();
        result = 37 * result + lang.hashCode();
        result = 37 * result + prov.hashCode();
        return result;
    }
}
