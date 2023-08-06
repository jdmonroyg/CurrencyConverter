package com.currencyconverterapp.logic;

import javax.swing.*;

/**
 * @author jdmon on 4/08/2023.
 * @project CurrencyConverter
 */
public class ValidationUtils {

    public static boolean validateNumber(String input){
        try {
            double value=Double.parseDouble(input);
            return true;
        }catch (NumberFormatException numberFormatException){
            return false;
        }
    }

    public static boolean validateNotNull (Object obj){
        if (obj==null ){
            return true;
        }
        return false;
    }

    public static void showEndingMessage(){
        JOptionPane.showMessageDialog(null, "The program has finished");
    }
}
