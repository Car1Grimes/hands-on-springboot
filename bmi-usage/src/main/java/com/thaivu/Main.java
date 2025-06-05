package com.thaivu;

import com.thaivu.bmi.core.BmiCalculator;
import com.thaivu.geometry.core.Calculator;
public class Main {
    public static void main(String[] args) {
        double bmiValue = BmiCalculator.getBmi(1.7, 77);
        System.out.println("BMI: " + bmiValue);
        double area = Calculator.getArea(23, 3);
        System.out.println("Area: " + area);
    }
}