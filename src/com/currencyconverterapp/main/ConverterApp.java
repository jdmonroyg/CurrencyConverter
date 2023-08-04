package com.currencyconverterapp.main;

import javax.swing.*;

/**
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class ConverterApp {
    public static boolean validateNumber(String input){
        try {
            double value=Double.parseDouble(input);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    public static void main(String[] args) {
        boolean iterator=true;
        while (iterator) {
            String options = (JOptionPane.showInputDialog(null, "Select conversion option", "ConverterApp", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Currency converter", "Temperature Converter"}, "Select")).toString();

            switch (options) {
                case "Currency converter":
                    String numberToConvert = JOptionPane.showInputDialog(null, "Enter the value to convert: ", "Currency Converter", 3);
                    if (validateNumber(numberToConvert)) {
                        double numberValue = Double.parseDouble(numberToConvert);
                        //CurrencyConverterLogic

                        int response = JOptionPane.showConfirmDialog(null, "Do you want to run the program again?");
                        if (JOptionPane.OK_OPTION==response){

                        } else{
                            iterator=false;
                            JOptionPane.showMessageDialog(null,"The program has finished");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid value");
                    }
                    break;
                case "Temperature Converter":
                    System.out.println("pig");
                    break;
            }
        }
    }
}

