package com.thaivu.bmi.core;

public class BmiCalculator {
    public static double getBmi(double height, double weight) {
        double bmi = weight / (height * height);
        return bmi;
    }
}
