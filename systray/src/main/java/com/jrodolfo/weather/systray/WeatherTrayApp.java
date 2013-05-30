/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jrodolfo.weather.systray;

/*
 * WeatherTrayApp.java
 */

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jrodolfo.weather.model.pojo.WeatherData;
import com.jrodolfo.weather.service.WeatherService;
import com.jrodolfo.weather.service.WeatherServiceImpl;

public class WeatherTrayApp {
    
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        // Schedule a job for the event-dispatching thread:
        // adding TrayIcon.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {

        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        final PopupMenu popup = new PopupMenu();

        // TODO: This is probably not the best way to create the initial TrayIcon object
        String imgPath = "images/01.gif";
        Image image = createImage(imgPath, "");
        final TrayIcon trayIcon = new TrayIcon(image);

        setIconAndToolTip(trayIcon);

        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        MenuItem changeLocation = new MenuItem("Change location");
        MenuItem exitItem = new MenuItem("Exit");

        // Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(changeLocation);
        popup.addSeparator();
        popup.add(exitItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "This dialog box is run from System Tray");
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane
                        .showMessageDialog(null, "Weather Tray Application (version 1.0)\n"
                + "This app uses weather data from Canada Environment (http://weather.gc.ca)");
            }
        });

        changeLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Choose the location:");
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });

        // we update the weather info every five minutes
        //int delay = 300000; // 300000 milliseconds = 5 minutes
        // TODO: remove this 10 seconds
        int delay = 10000; //15000 milliseconds = 10 seconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                setIconAndToolTip(trayIcon);
            }
        };
        new Timer(delay, taskPerformer).start();
        
    }

    // Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = WeatherTrayApp.class.getResource(path);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
    
    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
      }

    
    private static void setIconAndToolTip(TrayIcon trayIcon) {

        // debug:
        String now = now("EEEEEE MMMMM dd, yyyy 'at' HH:mm z");
        System.out.println("Call to Weather Web Service at: " + now);

        final String URL;
        
        // TODO: the weather URL should be built based on site code, province and language
        // Halifax (Shearwater)
        //URL = "http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/NS/s0000084_e.xml";
        // Halifax
        URL = "http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/NS/s0000318_e.xml";
        // Toronto
        // URL = "http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/ON/s0000458_e.xml";
        // URL = "http://dd.weatheroffice.ec.gc.ca/citypage_weather/xml/" + weatherCode + ".xml";
        
        URL url = null;
        final WeatherService weatherService;
        try {
            url = new URL(URL);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        WeatherData weatherData = null;
        weatherService = new WeatherServiceImpl();
        weatherData = weatherService.getWeather(url);
        String imgPath = "";

        String iconCode = weatherData.getIconCode();
        if (iconCode != null && !iconCode.trim().equals("")) {
            imgPath = "images/" + iconCode + ".gif";
        } else {
            imgPath = "images/questionmark.png";
        }

        // debug:
        System.out.println(weatherData);

        String conditions = weatherData.getLocation() + ": "
                + weatherData.getCondition() + "\nTemperature: "
                + weatherData.getTemperature() + weatherData.getTemperatureUnit();

        Image image = createImage(imgPath, conditions);
        if (trayIcon != null)
        {
            trayIcon.setImage(image);
        }
        else
        {
            trayIcon = new TrayIcon(image);
        }

        trayIcon.setToolTip(conditions);
        trayIcon.setImageAutoSize(true);
    }
}
