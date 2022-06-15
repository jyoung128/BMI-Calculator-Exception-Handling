package edu.cscc;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* Jonah Young
10/22/2019
Calculate the user's BMI with exception handling.
*/
public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        double lbs, inches, meters, kgs, bmi;
        String classification;

        System.out.println("Calculate BMI");
        lbs = inputWeight();
        inches = inputHeight();

        kgs = convertToKilograms(lbs);
        meters = convertToMeters(inches);
        bmi = calcBMI(kgs, meters);
        classification = bmiClassification(bmi);
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Your BMI classification is: " + classification);

    }

    private static double inputWeight() {
        String lbs = "0";
        double retVal = 0.0;
        do {
            try {
                System.out.print("Enter weight (lbs): ");
                lbs = input.nextLine();
                retVal = Double.parseDouble(lbs);
                if (retVal < 0.0) {
                    throw new NumberFormatException("Input is not valid, try again");
                }
            } catch (NumberFormatException | IllegalStateException Exception) {
                System.out.println("Input is not valid, try again");
            }
        } while (retVal == 0 || retVal <= -1);
        return retVal;
    }

    private static double inputHeight() {
        String inches;
        double retVal = 0.0;
        do {
            try {
                System.out.print("Enter height (inches): ");
                inches = input.nextLine();
                retVal = Double.parseDouble(inches);
                if (retVal < 0.0) {
                    throw new NumberFormatException("Input is not valid, try again");
                }
            } catch (NumberFormatException | NoSuchElementException Exception) {
                System.out.println("Input is not valid, try again");
            }
        } while (retVal == 0 || retVal <= -1);
        return retVal;
    }

    private static double convertToKilograms(double lbs) {
        double kgs;
        kgs = lbs / 2.2046;
        return kgs;
    }

    private static double convertToMeters(double inches) {
        double meters;
        meters = inches / 39.37;
        return meters;
    }

    private static double calcBMI(double kgs, double meters) {
        double bmi;
        bmi = kgs / (meters * meters);
        return bmi;
    }

    private static String bmiClassification(double bmi) {
        String classification = "";
        if (bmi > 18.5) {
            classification = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            classification = "Normal";
        } else if (bmi >= 25.0 && bmi < 30.0) {
            classification = "Overweight";
        } else if (bmi >= 30.0) {
            classification = "Obese";
        }
        return classification;
    }
}

