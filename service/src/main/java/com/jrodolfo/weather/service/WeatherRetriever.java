package com.jrodolfo.weather.service;

import java.net.URL;

import com.jrodolfo.weather.model.pojo.WeatherData;
import com.jrodolfo.weather.util.Timer;
import static com.jrodolfo.weather.util.Timer.start;
import static java.lang.System.out;

public class WeatherRetriever {

    private final WeatherService jaxbService = new WeatherServiceImpl();
    private final URL serviceUrl;

    public WeatherRetriever(URL serviceUrl) {
	this.serviceUrl = serviceUrl;
    }

    public void run() {
	getWeather(jaxbService);
    }

    private void getWeather(WeatherService service) {
	final Timer t = start();
	final WeatherData result = service.getWeather(serviceUrl);
	long duration = t.stop();
	print(service, result, duration);
    }

    private void print(WeatherService service, final WeatherData result, long duration) {
	final String serviceName = service.getClass().getSimpleName();
	out.println("\n=== Parsing XML using " + serviceName + " ===\n");
	out.println(result);
	out.println("time to execute (in milliseconds): " + duration + "\n");
    }
}
