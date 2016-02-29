package edu.macalester.comp124.hw1;

public class UnitConversions {

    public static double fahrenheitToCelcius(double f) {
        double celcius = (f-32)*(5.0/9);
        return celcius;
    }

    public static double celciusToFahrenheit(double c) {
        double Fahrenheit = c*(9.0/5)+32;
        return Fahrenheit;
    }

    public static double meterToFeet(double m) {
        double feet = m*3.28084;
        return feet;
    }

    public static double feetToMeter(double ft) {
        double meter = ft*0.3048;
        return meter;
    }
}
