package com.my.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City
 */

public class City implements Comparable<City>{
    private String city;
    private String province;

    public City( String city, String province) {
        this.province = province;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    /**
     *
     * @param o the object to be compared
     * @return 0, <1 or >1 if two values are equal, a<b, or a>b
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCity());
    }

    /**
     * This checks if two cities are the same or not
     * @param o
     * @return true if the city and province are the same otherwise false
     */
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(this.city,city1.city) &&
                Objects.equals(this.province,city1.province);
    }

    /**
     * This generate hash code for city
     * @return hash code value
     */
    @Override
    public int hashCode() {
        return Objects.hash(city,province);
    }
}
