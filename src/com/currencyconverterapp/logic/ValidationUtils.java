package com.currencyconverterapp.logic;

import javax.swing.*;

/**
 * @author jdmon on 4/08/2023.
 * @project CurrencyConverter
 * The utils class used for validates and The ending message
 */
public class ValidationUtils {
    /**
     * The method that validates a double
     * @param input Parameter entered by the user
     * @return a boolean to decide if it is a double
     */
    public static boolean validateNumber(String input){
        try {
            double value=Double.parseDouble(input);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    /**
     * Validates that the option object is null
     * @param obj
     * @return
     */
    public static boolean validateIsNull(Object obj){

        return obj==null;
    }
    public static boolean validateIsNullOrEmpty(String apiKey){
        return apiKey==null || apiKey.isEmpty();
    }

    public static boolean validateNegative(double value){
        return value<0;
    }

    public static void showEndingMessage(){
        JOptionPane.showMessageDialog(null, "The program has finished");
    }
}
