package com.currencyconverterapp.main;

import com.currencyconverterapp.logic.ConverterHandler;

import javax.swing.*;

import static com.currencyconverterapp.logic.ValidationUtils.*;

/**
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class ConverterApp {
    /**
     *
     * @param args
     *
     * Main method to execute the ConverterApp menu.
     * The ConverterApp provides options for currency and temperature conversions,
     * this method displays a menu and allows the user to select the desired converter.
     * It then runs the selected converter and offers options to continue or exit the program.
     *
     */
    public static void main(String[] args) {
        Object[] converters=new Object[]{"Currency converter", "Temperature Converter"};
        boolean iterator=true;
        while (iterator) {
            Object options = (JOptionPane.showInputDialog(null, "Select conversion option", "ConverterApp", JOptionPane.QUESTION_MESSAGE, null, converters, "Select"));
            if (validateIsNull(options)){
                iterator=false;
                showEndingMessage();
                continue;
            }
            ConverterHandler converterHandler = new ConverterHandler(options.toString());
            iterator = converterHandler.performConversion();
            if (!iterator) {
                showEndingMessage();
            }

        }
    }
}

