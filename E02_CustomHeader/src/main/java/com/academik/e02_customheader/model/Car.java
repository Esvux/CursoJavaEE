package com.academik.e02_customheader.model;

/**
 *
 * @author esvux
 */
public class Car {

    private int code;
    private String brand;
    private String model;
    private String color;
    private int year;

    public Car(int code) {
        this.code = code;
    }

    public Car(int code, String brand, String model, String color, int year) {
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public int getCode() {
        return code;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
