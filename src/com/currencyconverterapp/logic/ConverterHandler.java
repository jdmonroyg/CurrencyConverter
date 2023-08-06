package com.currencyconverterapp.logic;

import javax.swing.*;

import static com.currencyconverterapp.logic.ValidationUtils.*;

/**
 * @author jdmon on 4/08/2023.
 * @project CurrencyConverter
 */
public class ConverterHandler {
    private String converterType;

    public ConverterHandler(String converterType) {
        this.converterType = converterType;
    }

    public boolean performConversion() {
        boolean iterator=true;
        String numberToConvert = JOptionPane.showInputDialog(null, "Enter the value to convert: ", converterType, JOptionPane.QUESTION_MESSAGE);
        if (validateNotNull(numberToConvert)){
            iterator=false;
        }else {
            if (validateNumber(numberToConvert)) {
                double numberValue = Double.parseDouble(numberToConvert);

                if ("Currency converter".equals(converterType)) {
                    CurrencyConverter currencyConverter = new CurrencyConverter();
                    iterator=currencyConverter.convertCurrency(numberValue);
                } else if ("Temperature Converter".equals(converterType)) {
                    // Lógica para el TemperatureConverter
                }
                if (iterator==true){
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to run the program again?");

                    if(response!=0){
                        System.out.println("aca");
                        iterator = false;
                    }
                }


            } else {
                JOptionPane.showMessageDialog(null, "Invalid value");
            }
        }

        return iterator;
    }

}
