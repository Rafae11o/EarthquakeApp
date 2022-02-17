package com.example.earthquakeapp;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Earthquake {

    private String location;
    private double magnitude;
    private Long timeInMilliseconds;
    private String url;

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */

    public Earthquake(String location, double magnitude, Long timeInMilliseconds, String url) {
        setLocation(location);
        setMagnitude(magnitude);
        setTimestamp(timeInMilliseconds);
        setUrl(url);
    }

    /**
     * @return location of the earthquake
     */
    public String getLocation(){
        return location;
    }

    /**
     * Returns primary location of the earthquake.
     */
    public String getPrimaryLocation() {
        if(!location.contains("of")){
            return location;
        }
        return location.substring(location.indexOf("of") + 3).trim();
    }

    /**
     * @return location offset of earthquake
     */
    public String getLocationOffset() {
        if(!location.contains("of")){
            return "Near the";
        }
        return location.substring(0, location.indexOf("of") + 2).trim();
    }

    public void setLocation(String city) {
        this.location = city;
    }

    /**
     * Returns magnitude of the earthquake.
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * @return magnitude in form 0.0
     */
    public String getFormattedMagnitude() {
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(magnitude);
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    /**
     * Returns the time of the earthquake.
     */
    public Long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    /**
     * @return date in format of "month day, year"
     */
    public String getDate(){
        Date time = new Date(timeInMilliseconds);
        DateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(time);
    }

    /**
     * @return time in format of "h:mm a"
     */
    public String getTime() {
        Date time = new Date(timeInMilliseconds);
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(time);
    }

    public void setTimestamp(Long timestamp) {
        this.timeInMilliseconds = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
