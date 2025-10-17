package com.my.listycity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1,cityList.getCities().size());
        City city = new City("Regina","Saskatchewan");
        cityList.add(city);
        assertEquals(2,cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));

    }
    @Test
    void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class,() ->{
            cityList.add(city);
        });
    }
    @Test
    void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0,mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testhasCity(){
        CityList cityList = mockCityList();
        City old_city = mockCity();
        City new_city = new City("Calgary", "Alberta");
        assertTrue(cityList.hasCity(old_city));
        assertFalse(cityList.hasCity(new_city));

        cityList.add(new_city);
        assertTrue(cityList.hasCity(new_city));
    }
    @Test
    void testCountCities(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Calgary", "Alberta");
        cityList.add(city);
        assertEquals(2,cityList.getCities().size());
    }
    @Test
    void testDelete(){
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        cityList.delete(mockCity());
        assertFalse(cityList.hasCity(mockCity()));
    }
    @Test
    void testDeleteException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class,() ->{
            cityList.delete(city);
        });

    }
}
