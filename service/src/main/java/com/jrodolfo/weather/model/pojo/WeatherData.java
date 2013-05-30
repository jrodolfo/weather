package com.jrodolfo.weather.model.pojo;

/**
 * A Java Bean class that contains the weather data for a location.
 */
public final class WeatherData {

    private String location;
    private String temperature;
    private String temperatureUnit;
    private String humidity;
    private String humidityUnit;
    private String dewPoint;
    private String dewPointUnit;
    private String pressure;
    private String pressureUnit;
    private String pressureTendency;
    private String visibility;
    private String visibilityUnit;
    private String windSpeed;
    private String windSpeedUnit;
    private String windDirection;
    private String condition;
    private String iconCode;
    private String dateTimeUTC;
    private String dateTimeADT;
 

    /**
     * Returns a brief description of the weather. The exact details of the
     * representation are unspecified and subject to change, but the following
     * may be regarded as typical: <br>
     * &nbsp;<br>
     * == weather data ==<br>
     * Site: Halifax<br>
     * Condition: Cloudy<br>
     * Temperature: 7.4 &deg;C<br>
     * Relative Humidity: 52%<br>
     * Dew Point: -1.7 &deg;C<br>
     * Pressure: 101.9 kPa<br>
     * Pressure Tendency: rising<br>
     * Visibility: 24.1 km<br>
     * Wind Speed: 34 km/h, Direction: NW<br>
     * Icon code: 02<br>
     * Date and Time: Friday May 10, 2013 at 17:02 UTC<br>
     * 
     * @return String weather
     */
    @Override
    public String toString() {
    StringBuffer weather = new StringBuffer();
    weather.append("\n== weather data ==\n");
    weather.append("Site: " + location + "\n");
    weather.append("Condition: " + condition + "\n");
    weather.append("Temperature: " + temperature + temperatureUnit + "\n");
    weather.append("Humidity: " + humidity + humidityUnit + "\n");
    weather.append("Dew Point: " + dewPoint + dewPointUnit + "\n");
    weather.append("Pressure: " + pressure + " " + pressureUnit + "\n");
    weather.append("Pressure Tendency: " + pressureTendency + "\n");
    weather.append("Visibility: " + visibility + " " + visibilityUnit + "\n");
    weather.append("Wind Speed: " + windSpeed + " " + windSpeedUnit + " ");
    weather.append("Direction: " + windDirection + "\n");
    weather.append("Icon code: " + iconCode + "\n");
    //weather.append("Date and Time (UTC): " + dateTimeUTC + "\n");
    weather.append("Date and Time (ADT): " + dateTimeADT + "\n");
    return weather.toString();
    }

    public String getLocation() {
    return location;
    }

    public void setLocation(String location) {
    this.location = location;
    }

    public String getCondition() {
    return condition;
    }

    public void setCondition(String condition) {
    this.condition = condition;
    }

    public String getDewPoint() {
    return dewPoint;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getHumidityUnit() {
        return humidityUnit;
    }

    public void setHumidityUnit(String humidityUnit) {
        this.humidityUnit = humidityUnit;
    }

    public String getDewPointUnit() {
        return dewPointUnit;
    }

    public void setDewPointUnit(String dewpointUnit) {
        this.dewPointUnit = dewpointUnit;
    }

    public String getPressureUnit() {
        return pressureUnit;
    }

    public void setPressureUnit(String pressureUnit) {
        this.pressureUnit = pressureUnit;
    }

    public String getVisibilityUnit() {
        return visibilityUnit;
    }

    public void setVisibilityUnit(String visibilityUnit) {
        this.visibilityUnit = visibilityUnit;
    }

    public String getWindSpeedUnit() {
        return windSpeedUnit;
    }

    public void setWindSpeedUnit(String windSpeedUnit) {
        this.windSpeedUnit = windSpeedUnit;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public void setDewPoint(String dewPoint) {
    this.dewPoint = dewPoint;
    }

    public String getHumidity() {
    return humidity;
    }

    public void setHumidity(String humidity) {
    this.humidity = humidity;
    }

    public String getPressure() {
    return pressure;
    }

    public void setPressure(String pressure) {
    this.pressure = pressure;
    }

    public String getTemperature() {
    return temperature;
    }

    public void setTemperature(String temperature) {
    this.temperature = temperature;
    }

    public String getPressureTendency() {
    return pressureTendency;
    }

    public void setPressureTendency(String pressureTendency) {
    this.pressureTendency = pressureTendency;
    }

    public String getVisibility() {
    return visibility;
    }

    public void setVisibility(String visibility) {
    this.visibility = visibility;
    }

    public String getWindSpeed() {
    return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
    this.windSpeed = windSpeed;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public String getDateTimeUTC() {
        return dateTimeUTC;
    }

    public void setDateTimeUTC(String dateTime) {
        this.dateTimeUTC = dateTime;
    }

    public String getDateTimeADT() {
        return dateTimeADT;
    }

    public void setDateTimeADT(String dateTimeADT) {
        this.dateTimeADT = dateTimeADT;
    }

}
