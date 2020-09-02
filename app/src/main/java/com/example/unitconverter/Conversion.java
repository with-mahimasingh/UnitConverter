package com.example.unitconverter;

class Conversion {
    public enum Unit {
        //LENGTH
        INCH, CENTIMETER, FOOT, YARD, METER, MILE, KILOMETER,
        //MASS
        KILOGRAM, GRAM, MILLIGRAM, MICROGRAM, IMPERIALTON, USTON, STONE, POUND, OUNCE, TONNE,
        //SPEED
        Mph, Fps, mps, Kmph, Knot,
        //TIME
        NANOSECOND,MICROSECOND,MILLISECOND,SECOND,MINUTE,HOUR,DAY,WEEK,MONTH,YEAR,DECADE,CENTURY,
        //AREA
        sqKilometer,sqMeter, sqMile, sqYard, sqFoot,sqInch, Hectare,Acre,
        //ENERGY
        JOULE,KILOJOULE, GRAMCALORIE,KILOCALORIE,WATTHOUR,KILOWATTHOUR,ELECTRONVOLT,BTU,USTHERM,FOOTPOUND;
        // Helper method to convert text to one of the above constants
        public static Unit fromString(String text) {
            if (text != null) {
                for (Unit unit : Unit.values()) {
                    if (text.equalsIgnoreCase(unit.toString())) {
                        return unit;
                    }
                }
            }

            throw new IllegalArgumentException("Cannot find a value for " + text);
        }
    }

    private final double multiplier;

    Conversion(Unit from, Unit to) {
        double constant = 1;
        // Set the multiplier, else if fromUnit = toUnit, then it is 1
        switch (from)
        {
            //--------LENGTH--------
            case INCH:
                if (to == Unit.CENTIMETER) {
                    constant = 2.54;
                } else if (to == Unit.FOOT) {
                    constant = 0.0833333;
                } else if (to == Unit.YARD) {
                    constant = 0.0277778;
                } else if (to == Unit.METER) {
                    constant = 0.0254;
                } else if (to == Unit.MILE) {
                    constant = 1.5783e-5;
                } else if (to == Unit.KILOMETER) {
                    constant = 2.54e-5;
                }
                break;
            case CENTIMETER:
                if (to == Unit.INCH) {
                    constant = 0.393701;
                } else if (to == Unit.FOOT) {
                    constant = 0.0328084;
                } else if (to == Unit.YARD) {
                    constant = 0.0109361;
                } else if (to == Unit.METER) {
                    constant = 0.01;
                } else if (to == Unit.MILE) {
                    constant = 6.2137e-6;
                } else if (to == Unit.KILOMETER) {
                    constant = 1e-5;
                }
                break;
            case FOOT:
                if (to == Unit.INCH) {
                    constant = 12;
                } else if (to == Unit.CENTIMETER) {
                    constant = 30.48;
                } else if (to == Unit.YARD) {
                    constant = 0.333333;
                } else if (to == Unit.METER) {
                    constant = 0.3048;
                } else if (to == Unit.MILE) {
                    constant = 0.000189394;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.0003048;
                }
                break;
            case YARD:
                if (to == Unit.INCH) {
                    constant = 36;
                } else if (to == Unit.CENTIMETER) {
                    constant = 91.44;
                } else if (to == Unit.FOOT) {
                    constant = 3;
                } else if (to == Unit.METER) {
                    constant = 0.9144;
                } else if (to == Unit.MILE) {
                    constant = 0.000568182;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.0009144;
                }
                break;
            case METER:
                if (to == Unit.INCH) {
                    constant = 39.3701;
                } else if (to == Unit.CENTIMETER) {
                    constant = 100;
                } else if (to == Unit.FOOT) {
                    constant = 3.28084;
                } else if (to == Unit.YARD) {
                    constant = 1.09361;
                } else if (to == Unit.MILE) {
                    constant = 0.000621371;
                } else if (to == Unit.KILOMETER) {
                    constant = 0.001;
                }
                break;
            case MILE:
                if (to == Unit.INCH) {
                    constant = 63360;
                } else if (to == Unit.CENTIMETER) {
                    constant = 160934;
                } else if (to == Unit.FOOT) {
                    constant = 5280;
                } else if (to == Unit.YARD) {
                    constant = 1760;
                } else if (to == Unit.METER) {
                    constant = 1609.34;
                } else if (to == Unit.KILOMETER) {
                    constant = 1.60934;
                }
                break;
            case KILOMETER:
                if (to == Unit.INCH) {
                    constant = 39370.1;
                } else if (to == Unit.CENTIMETER) {
                    constant = 100000;
                } else if (to == Unit.FOOT) {
                    constant = 3280.84;
                } else if (to == Unit.YARD) {
                    constant = 1093.61;
                } else if (to == Unit.METER) {
                    constant = 1000;
                } else if (to == Unit.MILE) {
                    constant = 0.621371;
                }
                break;


            //--------MASS--------

            case KILOGRAM:
                if (to == Unit.GRAM) {
                    constant = 1000;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 1e+6;
                } else if (to == Unit.MICROGRAM) {
                    constant = 1e+9;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 0.000984207;
                } else if (to == Unit.USTON) {
                    constant = 0.00110231;
                } else if (to == Unit.STONE) {
                    constant = 0.157473;
                }
                else if (to == Unit.POUND) {
                    constant = 2.20462;
                }
                else if (to == Unit.OUNCE) {
                    constant = 35.274;
                }
                else if (to == Unit.TONNE) {
                    constant = 0.001;
                }
                break;
            case GRAM:
                if (to == Unit.KILOGRAM) {
                    constant = 0.001;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 1000;
                } else if (to == Unit.MICROGRAM) {
                    constant = 1e+6;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 9.8421e-7;
                } else if (to == Unit.USTON) {
                    constant = 1.1023e-6;
                } else if (to == Unit.STONE) {
                    constant = 0.000157473;
                }
                else if (to == Unit.POUND) {
                    constant = 0.00220462;
                }
                else if (to == Unit.OUNCE) {
                    constant = 0.035274;
                }
                else if (to == Unit.TONNE) {
                    constant = 1e-6;
                }
                break;
            case MILLIGRAM:
                if (to == Unit.KILOGRAM) {
                    constant = 1e-6;
                } else if (to == Unit.GRAM) {
                    constant = 0.001;
                } else if (to == Unit.MICROGRAM) {
                    constant = 1000;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 9.8421e-10;
                } else if (to == Unit.USTON) {
                    constant = 1.1023e-9;
                } else if (to == Unit.STONE) {
                    constant = 1.5747e-7;
                }
                else if (to == Unit.POUND) {
                    constant = 2.2046e-6;
                }
                else if (to == Unit.OUNCE) {
                    constant = 3.5274e-5;
                }
                else if (to == Unit.TONNE) {
                    constant = 1e-9;
                }
                break;
            case MICROGRAM:
                if (to == Unit.KILOGRAM) {
                    constant = 1e-9;
                } else if (to == Unit.GRAM) {
                    constant = 1e-6;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 0.001;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 9.8421e-13;
                } else if (to == Unit.USTON) {
                    constant = 1.1023e-12;
                } else if (to == Unit.STONE) {
                    constant = 1.5747e-10;
                }
                else if (to == Unit.POUND) {
                    constant = 2.2046e-9;
                }
                else if (to == Unit.OUNCE) {
                    constant = 3.5274e-8;
                }
                else if (to == Unit.TONNE) {
                    constant = 1e-12;
                }
                break;
            case IMPERIALTON:
                if (to == Unit.KILOGRAM) {
                    constant = 1016.05;
                } else if (to == Unit.GRAM) {
                    constant = 1.016e+6;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 1.016+9;
                } else if (to == Unit.MICROGRAM) {
                    constant = 1.016e+12;
                } else if (to == Unit.USTON) {
                    constant = 1.12;
                } else if (to == Unit.STONE) {
                    constant = 160;
                }
                else if (to == Unit.POUND) {
                    constant = 2240;
                }
                else if (to == Unit.OUNCE) {
                    constant = 35840;
                }
                else if (to == Unit.TONNE) {
                    constant = 1.01605;
                }
                break;

            case USTON:
                if (to == Unit.KILOGRAM) {
                    constant = 907.185;
                } else if (to == Unit.GRAM) {
                    constant = 907185;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 9.072e+8;
                } else if (to == Unit.MICROGRAM) {
                    constant = 9.072e+11;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 0.892857;
                } else if (to == Unit.STONE) {
                    constant = 142.857;
                }
                else if (to == Unit.POUND) {
                    constant = 2000;
                }
                else if (to == Unit.OUNCE) {
                    constant = 32000;
                }
                else if (to == Unit.TONNE) {
                    constant = 0.907185;
                }
                break;

            case STONE:
                if (to == Unit.KILOGRAM) {
                    constant = 6.35029;
                } else if (to == Unit.GRAM) {
                    constant = 6350.29;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 6.35e+6;
                } else if (to == Unit.MICROGRAM) {
                    constant = 6.35e+9;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 0.0625;
                } else if (to == Unit.USTON) {
                    constant = 0.007;
                }
                else if (to == Unit.POUND) {
                    constant = 14;
                }
                else if (to == Unit.OUNCE) {
                    constant = 224;
                }
                else if (to == Unit.TONNE) {
                    constant = 0.00635029;
                }
                break;

            case POUND:
                if (to == Unit.KILOGRAM) {
                    constant = 0.453592;
                } else if (to == Unit.GRAM) {
                    constant = 453.592;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 453592;
                } else if (to == Unit.MICROGRAM) {
                    constant = 4.536e+8;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 0.000446429;
                } else if (to == Unit.USTON) {
                    constant = 0.0005;
                }
                else if (to == Unit.STONE) {
                    constant = 0.0714286;
                }
                else if (to == Unit.OUNCE) {
                    constant = 16;
                }
                else if (to == Unit.TONNE) {
                    constant = 0.000453592;
                }
                break;

            case OUNCE:
                if (to == Unit.KILOGRAM) {
                    constant = 0.0283495;
                } else if (to == Unit.GRAM) {
                    constant = 28.3495;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 28349.5;
                } else if (to == Unit.MICROGRAM) {
                    constant = 2.835e+7;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 2.702e-5;
                } else if (to == Unit.USTON) {
                    constant = 3.125e-5;
                }
                else if (to == Unit.STONE) {
                    constant = 0.00446429;
                }
                else if (to == Unit.POUND) {
                    constant = 0.0625;
                }
                else if (to == Unit.TONNE) {
                    constant = 2.835e-5;
                }
                break;

            case TONNE:
                if (to == Unit.KILOGRAM) {
                    constant = 1000;
                } else if (to == Unit.GRAM) {
                    constant = 1e+6;
                } else if (to == Unit.MILLIGRAM) {
                    constant = 1e+9;
                } else if (to == Unit.MICROGRAM) {
                    constant = 1e+12;
                } else if (to == Unit.IMPERIALTON) {
                    constant = 0.984207;
                } else if (to == Unit.USTON) {
                    constant = 1.10231;
                }
                else if (to == Unit.STONE) {
                    constant = 157.473;
                }
                else if (to == Unit.POUND) {
                    constant = 2204.62;
                }
                else if (to == Unit.OUNCE) {
                    constant = 35274;
                }
                break;

                //--------SPEED--------

            case Mph:
                if (to == Unit.Fps) {
                    constant = 1.467;
                } else if (to == Unit.mps) {
                    constant = 0.44704;
                } else if (to == Unit.Kmph) {
                    constant = 1.609;
                } else if (to == Unit.Knot) {
                    constant = 0.868976;
                }
                break;

            case Fps:
                if (to == Unit.Mph) {
                    constant = 0.6818;
                } else if (to == Unit.mps) {
                    constant = 0.3048;
                } else if (to == Unit.Kmph) {
                    constant = 1.097;
                } else if (to == Unit.Knot) {
                    constant = 0.59484;
                }
                break;
            case mps:
                if (to == Unit.Mph) {
                    constant = 2.237;
                } else if (to == Unit.Fps) {
                    constant = 3.281;
                } else if (to == Unit.Kmph) {
                    constant = 3.6;
                } else if (to == Unit.Knot) {
                    constant = 1.944;
                }
                break;

            case Kmph:
                if (to == Unit.Mph) {
                    constant = 0.621371;
                } else if (to == Unit.Fps) {
                    constant = 0.911344;
                } else if (to == Unit.mps) {
                    constant = 0.277778;
                } else if (to == Unit.Knot) {
                    constant = 0.539957235888;
                }
                break;

            case Knot:
                if (to == Unit.Mph) {
                    constant = 1.15078;
                } else if (to == Unit.Fps) {
                    constant = 1.68781;
                } else if (to == Unit.mps) {
                    constant = 0.5144;
                } else if (to == Unit.Kmph) {
                    constant = 1.852;
                }
                break;

            //--------TIME--------

            case NANOSECOND:
                if (to == Unit.MICROSECOND) {
                    constant = 0.001;
                } else if (to == Unit.MILLISECOND) {
                    constant = 1E-6;
                } else if (to == Unit.SECOND) {
                    constant = 1E-9;
                } else if (to == Unit.MINUTE) {
                    constant = 1.6667E-11;
                } else if (to == Unit.HOUR) {
                    constant = 2.7778E-13;
                } else if (to == Unit.DAY) {
                    constant = 1.1574E-14;
                }
                else if (to == Unit.WEEK) {
                    constant = 1.6534E-15;
                }
                else if (to == Unit.MONTH) {
                    constant = 3.8052E-16;
                }
                else if (to == Unit.YEAR) {
                    constant = 3.171E-17;
                }
                else if (to == Unit.DECADE) {
                    constant = 3.171E-18;
                }
                else if (to == Unit.CENTURY) {
                    constant = 3.171E-19;
                }
                break;

            case MICROSECOND:
                if (to == Unit.NANOSECOND) {
                    constant = 1000;
                } else if (to == Unit.MILLISECOND) {
                    constant = 0.001;
                } else if (to == Unit.SECOND) {
                    constant = 1E-6;
                } else if (to == Unit.MINUTE) {
                    constant = 1.6667E-8;
                } else if (to == Unit.HOUR) {
                    constant = 2.7778E-10;
                } else if (to == Unit.DAY) {
                    constant = 1.1574E-11;
                }
                else if (to == Unit.WEEK) {
                    constant = 1.6534E-12;
                }
                else if (to == Unit.MONTH) {
                    constant = 3.8052E-13;
                }
                else if (to == Unit.YEAR) {
                    constant = 3.171E-14;
                }
                else if (to == Unit.DECADE) {
                    constant = 3.171E-15;
                }
                else if (to == Unit.CENTURY) {
                    constant = 3.171E-16;
                }
                break;

            case MILLISECOND:
                if (to == Unit.NANOSECOND) {
                    constant = 1E+6;
                } else if (to == Unit.MICROSECOND) {
                    constant = 1000;
                } else if (to == Unit.SECOND) {
                    constant = 0.001;
                } else if (to == Unit.MINUTE) {
                    constant = 1.6667E-5;
                } else if (to == Unit.HOUR) {
                    constant = 2.7778E-7;
                } else if (to == Unit.DAY) {
                    constant = 1.1574E-8;
                }
                else if (to == Unit.WEEK) {
                    constant = 1.6534E-9;
                }
                else if (to == Unit.MONTH) {
                    constant = 3.8052E-10;
                }
                else if (to == Unit.YEAR) {
                    constant = 3.171E-11;
                }
                else if (to == Unit.DECADE) {
                    constant = 3.171E-12;
                }
                else if (to == Unit.CENTURY) {
                    constant = 3.171E-13;
                }
                break;

            case SECOND:
                if (to == Unit.NANOSECOND) {
                    constant = 1E+9;
                } else if (to == Unit.MICROSECOND) {
                    constant = 1E+6;
                } else if (to == Unit.MILLISECOND) {
                    constant = 1000;
                } else if (to == Unit.MINUTE) {
                    constant = 1.6667E-2;
                } else if (to == Unit.HOUR) {
                    constant = 2.7778E-4;
                } else if (to == Unit.DAY) {
                    constant = 1.1574E-5;
                }
                else if (to == Unit.WEEK) {
                    constant = 1.6534E-6;
                }
                else if (to == Unit.MONTH) {
                    constant = 3.8052E-7;
                }
                else if (to == Unit.YEAR) {
                    constant = 3.171E-8;
                }
                else if (to == Unit.DECADE) {
                    constant = 3.171E-9;
                }
                else if (to == Unit.CENTURY) {
                    constant = 3.171E-10;
                }
                break;

            case MINUTE:
                if (to == Unit.NANOSECOND) {
                    constant = 6E+10;
                } else if (to == Unit.MICROSECOND) {
                    constant = 6E+7;
                } else if (to == Unit.MILLISECOND) {
                    constant = 6000;
                } else if (to == Unit.SECOND) {
                    constant = 60;
                } else if (to == Unit.HOUR) {
                    constant = 0.0166667;
                } else if (to == Unit.DAY) {
                    constant = 0.00069694444;
                }
                else if (to == Unit.WEEK) {
                    constant = 9.9206E-5;
                }
                else if (to == Unit.MONTH) {
                    constant = 2.2831E-5;
                }
                else if (to == Unit.YEAR) {
                    constant = 1.9026E-6;
                }
                else if (to == Unit.DECADE) {
                    constant = 1.9026E-7;
                }
                else if (to == Unit.CENTURY) {
                    constant = 1.9026E-8;
                }
                break;

            case HOUR:
                if (to == Unit.NANOSECOND) {
                    constant = 3.6E+12;
                } else if (to == Unit.MICROSECOND) {
                    constant = 3.6E+9;
                } else if (to == Unit.MILLISECOND) {
                    constant = 3.6E+6;
                } else if (to == Unit.SECOND) {
                    constant = 3600;
                } else if (to == Unit.MINUTE) {
                    constant = 60;
                } else if (to == Unit.DAY) {
                    constant = 0.04166667;
                }
                else if (to == Unit.WEEK) {
                    constant = 0.00595238;
                }
                else if (to == Unit.MONTH) {
                    constant = 0.00136986;
                }
                else if (to == Unit.YEAR) {
                    constant = 1.1416E-4;
                }
                else if (to == Unit.DECADE) {
                    constant = 1.1416E-5;
                }
                else if (to == Unit.CENTURY) {
                    constant = 1.1416E-6;
                }
                break;

            case DAY:
                if (to == Unit.NANOSECOND) {
                    constant = 8.64E+13;
                } else if (to == Unit.MICROSECOND) {
                    constant = 8.64E+10;
                } else if (to == Unit.MILLISECOND) {
                    constant = 8.64E+7;
                } else if (to == Unit.SECOND) {
                    constant = 86400;
                } else if (to == Unit.MINUTE) {
                    constant = 1440;
                } else if (to == Unit.HOUR) {
                    constant = 24;
                }
                else if (to == Unit.WEEK) {
                    constant = 0.142867;
                }
                else if (to == Unit.MONTH) {
                    constant = 0.0328767;
                }
                else if (to == Unit.YEAR) {
                    constant = 0.00273973;
                }
                else if (to == Unit.DECADE) {
                    constant = 0.000273973;
                }
                else if (to == Unit.CENTURY) {
                    constant = 2.73973E-5;
                }
                break;

            case WEEK:
                if (to == Unit.NANOSECOND) {
                    constant = 6.048E+14;
                } else if (to == Unit.MICROSECOND) {
                    constant = 6.048E+11;
                } else if (to == Unit.MILLISECOND) {
                    constant = 6.048E+8;
                } else if (to == Unit.SECOND) {
                    constant = 604800;
                } else if (to == Unit.MINUTE) {
                    constant = 10080;
                } else if (to == Unit.HOUR) {
                    constant = 168;
                }
                else if (to == Unit.DAY) {
                    constant = 7;
                }
                else if (to == Unit.MONTH) {
                    constant = 0.230137;
                }
                else if (to == Unit.YEAR) {
                    constant = 0.0191781;
                }
                else if (to == Unit.DECADE) {
                    constant = 0.00191781;
                }
                else if (to == Unit.CENTURY) {
                    constant = 0.000191781;
                }
                break;

            case MONTH:
                if (to == Unit.NANOSECOND) {
                    constant = 2.628E+15;
                } else if (to == Unit.MICROSECOND) {
                    constant = 2.628E+12;
                } else if (to == Unit.MILLISECOND) {
                    constant = 2.628E+9;
                } else if (to == Unit.SECOND) {
                    constant = 2.628E+6;
                } else if (to == Unit.MINUTE) {
                    constant = 43800;
                } else if (to == Unit.HOUR) {
                    constant = 730.001;
                }
                else if (to == Unit.DAY) {
                    constant = 30.4167;
                }
                else if (to == Unit.WEEK) {
                    constant = 4.34524;
                }
                else if (to == Unit.YEAR) {
                    constant = 0.0833334;
                }
                else if (to == Unit.DECADE) {
                    constant = 0.00833334;
                }
                else if (to == Unit.CENTURY) {
                    constant = 0.000833334;
                }
                break;

            case YEAR:
                if (to == Unit.NANOSECOND) {
                    constant = 3.154E+16;
                } else if (to == Unit.MICROSECOND) {
                    constant = 3.154E+13;
                } else if (to == Unit.MILLISECOND) {
                    constant = 3.154E+10;
                } else if (to == Unit.SECOND) {
                    constant = 3.154E+7;
                } else if (to == Unit.MINUTE) {
                    constant = 525600;
                } else if (to == Unit.HOUR) {
                    constant = 8760;
                }
                else if (to == Unit.DAY) {
                    constant = 365;
                }
                else if (to == Unit.WEEK) {
                    constant = 52.1429;
                }
                else if (to == Unit.MONTH) {
                    constant = 12;
                }
                else if (to == Unit.DECADE) {
                    constant = 0.1;
                }
                else if (to == Unit.CENTURY) {
                    constant = 0.001;
                }
                break;

            case DECADE:
                if (to == Unit.NANOSECOND) {
                    constant = 3.154E+17;
                } else if (to == Unit.MICROSECOND) {
                    constant = 3.154E+14;
                } else if (to == Unit.MILLISECOND) {
                    constant = 3.154E+11;
                } else if (to == Unit.SECOND) {
                    constant = 3.154E+8;
                } else if (to == Unit.MINUTE) {
                    constant = 5.256E+6;
                } else if (to == Unit.HOUR) {
                    constant = 87600;
                }
                else if (to == Unit.DAY) {
                    constant = 3650;
                }
                else if (to == Unit.WEEK) {
                    constant = 521.429;
                }
                else if (to == Unit.MONTH) {
                    constant = 120;
                }
                else if (to == Unit.YEAR) {
                    constant = 10;
                }
                else if (to == Unit.CENTURY) {
                    constant = 0.1;
                }
                break;

            case CENTURY:
                if (to == Unit.NANOSECOND) {
                    constant = 3.154E+18;
                } else if (to == Unit.MICROSECOND) {
                    constant = 3.154E+15;
                } else if (to == Unit.MILLISECOND) {
                    constant = 3.154E+12;
                } else if (to == Unit.SECOND) {
                    constant = 3.154E+9;
                } else if (to == Unit.MINUTE) {
                    constant = 5.256E+7;
                } else if (to == Unit.HOUR) {
                    constant = 876000;
                }
                else if (to == Unit.DAY) {
                    constant = 36500;
                }
                else if (to == Unit.WEEK) {
                    constant = 5214.29;
                }
                else if (to == Unit.MONTH) {
                    constant = 1200;
                }
                else if (to == Unit.YEAR) {
                    constant = 100;
                }
                else if (to == Unit.DECADE) {
                    constant = 10;
                }
                break;

            //--------AREA--------

            case sqKilometer:
                if (to == Unit.sqMeter) {
                    constant = 1E+6;
                } else if (to == Unit.sqMile) {
                    constant = 0.386102;
                } else if (to == Unit.sqYard) {
                    constant = 1.196E+6;
                } else if (to == Unit.sqFoot) {
                    constant = 1.076E+7;
                } else if (to == Unit.sqInch) {
                    constant = 1.55E+9;
                } else if (to == Unit.Hectare) {
                    constant = 100;
                }
                else if (to == Unit.Acre) {
                    constant = 247.105;
                }
                break;
            case sqMeter:
                if (to == Unit.sqKilometer) {
                    constant = 1E-6;
                } else if (to == Unit.sqMile) {
                    constant = 3.86102E-7;
                } else if (to == Unit.sqYard) {
                    constant = 1.19599;
                } else if (to == Unit.sqFoot) {
                    constant = 10.7639;
                } else if (to == Unit.sqInch) {
                    constant = 1550;
                } else if (to == Unit.Hectare) {
                    constant = 1E-4;
                }
                else if (to == Unit.Acre) {
                    constant = 0.000247105;
                }
                break;
            case sqMile:
                if (to == Unit.sqKilometer) {
                    constant = 2.58999;
                } else if (to == Unit.sqMeter) {
                    constant = 2.59E+6;
                } else if (to == Unit.sqYard) {
                    constant = 3.098E+6;
                } else if (to == Unit.sqFoot) {
                    constant = 2.788E+7;
                } else if (to == Unit.sqInch) {
                    constant = 4.014E+9;
                } else if (to == Unit.Hectare) {
                    constant = 258.999;
                }
                else if (to == Unit.Acre) {
                    constant = 640;
                }
                break;
            case sqYard:
                if (to == Unit.sqKilometer) {
                    constant = 8.3613E-7;
                } else if (to == Unit.sqMeter) {
                    constant = 0.836127;
                } else if (to == Unit.sqMile) {
                    constant = 3.2283E-7;
                } else if (to == Unit.sqFoot) {
                    constant = 9;
                } else if (to == Unit.sqInch) {
                    constant = 1296;
                } else if (to == Unit.Hectare) {
                    constant = 8.3613E-5;
                }
                else if (to == Unit.Acre) {
                    constant = 0.000206612;
                }
                break;
            case sqFoot:
                if (to == Unit.sqKilometer) {
                    constant = 9.2903E-8;
                } else if (to == Unit.sqMeter) {
                    constant = 0.092903;
                } else if (to == Unit.sqMile) {
                    constant = 3.587E-8;
                } else if (to == Unit.sqYard) {
                    constant = 0.111111;
                } else if (to == Unit.sqInch) {
                    constant = 144;
                } else if (to == Unit.Hectare) {
                    constant = 9.2903E-6;
                }
                else if (to == Unit.Acre) {
                    constant = 2.2957E-5;
                }
                break;

            case sqInch:
                if (to == Unit.sqKilometer) {
                    constant = 6.4516E-10;
                } else if (to == Unit.sqMeter) {
                    constant = 0.00064516;
                } else if (to == Unit.sqMile) {
                    constant = 2.491E-10;
                } else if (to == Unit.sqYard) {
                    constant = 0.000771605;
                } else if (to == Unit.sqFoot) {
                    constant = 0.00694444;
                } else if (to == Unit.Hectare) {
                    constant = 6.4516E-8;
                }
                else if (to == Unit.Acre) {
                    constant = 1.5942E-7;
                }
                break;
            case Hectare:
                if (to == Unit.sqKilometer) {
                    constant = 0.01;
                } else if (to == Unit.sqMeter) {
                    constant = 10000;
                } else if (to == Unit.sqMile) {
                    constant = 0.00386102;
                } else if (to == Unit.sqYard) {
                    constant = 119599;
                } else if (to == Unit.sqFoot) {
                    constant = 107639;
                } else if (to == Unit.sqInch) {
                    constant = 1.55E+7;
                }
                else if (to == Unit.Acre) {
                    constant = 2.47105;
                }
                break;

            case Acre:
                if (to == Unit.sqKilometer) {
                    constant = 0.00404686;
                } else if (to == Unit.sqMeter) {
                    constant = 4046.86;
                } else if (to == Unit.sqMile) {
                    constant = 0.0015625;
                } else if (to == Unit.sqYard) {
                    constant = 4840;
                } else if (to == Unit.sqFoot) {
                    constant = 43560;
                } else if (to == Unit.sqInch) {
                    constant = 6.273E+6;
                }
                else if (to == Unit.Hectare) {
                    constant = 0.404686;
                }
                break;

            //--------ENERGY--------

            case JOULE:
                if (to == Unit.KILOJOULE) {
                    constant = 0.001;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 0.239006;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.000239006;
                } else if (to == Unit.WATTHOUR) {
                    constant = 0.000277778;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 2.7778E-7;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 6.242E+18;
                }
                else if (to == Unit.BTU) {
                    constant = 0.000947817;
                }
                else if (to == Unit.USTHERM) {
                    constant = 9.4804E-9;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 0.737562;
                }
                break;
            case KILOJOULE:
                if (to == Unit.JOULE) {
                    constant = 1000;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 239.006;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.239006;
                } else if (to == Unit.WATTHOUR) {
                    constant = 0.277778;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 2.7778E-4;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 6.242E+21;
                }
                else if (to == Unit.BTU) {
                    constant = 0.947817;
                }
                else if (to == Unit.USTHERM) {
                    constant = 9.4804E-6;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 737.562;
                }
                break;

            case GRAMCALORIE:
                if (to == Unit.JOULE) {
                    constant = 4.184;
                } else if (to == Unit.KILOJOULE) {
                    constant = 0.004814;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.001;
                } else if (to == Unit.WATTHOUR) {
                    constant = 0.00116222;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 1.1622E-6;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 2.611E+19;
                }
                else if (to == Unit.BTU) {
                    constant = 0.00396567;
                }
                else if (to == Unit.USTHERM) {
                    constant = 3.9666E-8;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 3.08596;
                }
                break;

            case KILOCALORIE:
                if (to == Unit.JOULE) {
                    constant = 4184;
                } else if (to == Unit.KILOJOULE) {
                    constant = 4.814;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 1000;
                } else if (to == Unit.WATTHOUR) {
                    constant = 1.16222;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 1.1622E-3;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 2.611E+22;
                }
                else if (to == Unit.BTU) {
                    constant = 3.96567;
                }
                else if (to == Unit.USTHERM) {
                    constant = 3.9666E-5;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 3085.96;
                }
                break;
            case WATTHOUR:
                if (to == Unit.JOULE) {
                    constant = 3600;
                } else if (to == Unit.KILOJOULE) {
                    constant = 3.6;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 860.421;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.860421;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 0.001;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 2.247e+22;
                }
                else if (to == Unit.BTU) {
                    constant = 3.41214;
                }
                else if (to == Unit.USTHERM) {
                    constant = 3.413E-5;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 2655.22;
                }
                break;

            case KILOWATTHOUR:
                if (to == Unit.JOULE) {
                    constant = 3.6E+6;
                } else if (to == Unit.KILOJOULE) {
                    constant = 3600;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 860421;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 860.421;
                } else if (to == Unit.WATTHOUR) {
                    constant = 1000;
                } else if (to == Unit.ELECTRONVOLT) {
                    constant = 2.247E+25;
                }
                else if (to == Unit.BTU) {
                    constant = 3412.14;
                }
                else if (to == Unit.USTHERM) {
                    constant = 0.0341296;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 2.655E+6;
                }
                break;

            case ELECTRONVOLT:
                if (to == Unit.JOULE) {
                    constant = 1.6022E-19;
                } else if (to == Unit.KILOJOULE) {
                    constant = 1.6022E-22;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 3.8293E-20;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 3.8293E-23;
                } else if (to == Unit.WATTHOUR) {
                    constant = 4.4505E-23;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 4.4505E-26;
                }
                else if (to == Unit.BTU) {
                    constant = 1.5186E-22;
                }
                else if (to == Unit.USTHERM) {
                    constant = 1.5189E-27;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 1.1817E-19;
                }
                break;

            case BTU:
                if (to == Unit.JOULE) {
                    constant = 1055.06;
                } else if (to == Unit.KILOJOULE) {
                    constant = 1.05506;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 252.164;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.252164;
                } else if (to == Unit.WATTHOUR) {
                    constant = 0.293071;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 0.000293071;
                }
                else if (to == Unit.ELECTRONVOLT) {
                    constant = 6.585E+21;
                }
                else if (to == Unit.USTHERM) {
                    constant = 1.0002E-5;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 778.169;
                }
                break;

            case USTHERM:
                if (to == Unit.JOULE) {
                    constant = 1.055E+8;
                } else if (to == Unit.KILOJOULE) {
                    constant = 1.5480;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 2.521E+7;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 25210.4;
                } else if (to == Unit.WATTHOUR) {
                    constant = 29300.1;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 29.3001;
                }
                else if (to == Unit.ELECTRONVOLT) {
                    constant = 6.584E+26;
                }
                else if (to == Unit.BTU) {
                    constant = 99976.1;
                }
                else if (to == Unit.FOOTPOUND) {
                    constant = 7.78E+7;
                }
                break;

            case FOOTPOUND:
                if (to == Unit.JOULE) {
                    constant = 1.35582;
                } else if (to == Unit.KILOJOULE) {
                    constant = 0.00135582;
                } else if (to == Unit.GRAMCALORIE) {
                    constant = 0.324048;
                } else if (to == Unit.KILOCALORIE) {
                    constant = 0.000324048;
                } else if (to == Unit.WATTHOUR) {
                    constant = 0.000376616;
                } else if (to == Unit.KILOWATTHOUR) {
                    constant = 3.7662E-7;
                }
                else if (to == Unit.ELECTRONVOLT) {
                    constant = 8.462E+18;
                }
                else if (to == Unit.BTU) {
                    constant = 0.00128507;
                }
                else if (to == Unit.USTHERM) {
                    constant = 1.2854E-8;
                }
                break;


            default: {
                System.out.println("No value entered");
            }
        }

        multiplier = constant;
    }

    // Convert the unit!
    double convert(double input) {
        return input * multiplier;
    }

}
