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
     * The ConverterApp provides options for currency conversion,
     * temperature conversion, and other converters.
     * This method displays a menu and allows the user to select
     * the desired converter. It then executes the selected converter
     * and provides options to continue or exit the program.
     */
    public static void main(String[] args) {
        Object[] converters=new Object[]{"Currency converter", "Temperature Converter"};
        boolean iterator=true;
        while (iterator) {

            Object options = (JOptionPane.showInputDialog(null, "Select conversion option", "ConverterApp", JOptionPane.QUESTION_MESSAGE, null, converters, "Select"));
            if (validateNotNull(options)){
                iterator=false;
                showEndingMessage();
                continue;
            }
            switch (options.toString()){
                case "Currency converter":
                    ConverterHandler currencyConverterHandler = new ConverterHandler("Currency converter");
                    iterator = currencyConverterHandler.performConversion();

                    if (iterator==false){
                        showEndingMessage();
                        continue;
                    }
                    break;
                case "Temperature Converter":
                    ConverterHandler temperatureConverterHandler = new ConverterHandler("Temperature Converter");
                    iterator = temperatureConverterHandler.performConversion();
                    break;
            }

        }
    }
}

