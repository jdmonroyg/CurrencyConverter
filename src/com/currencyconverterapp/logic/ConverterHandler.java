package com.currencyconverterapp.logic;

import javax.swing.*;

import static com.currencyconverterapp.logic.ValidationUtils.*;

/**
 * @author jdmon on 4/08/2023.
 * @project CurrencyConverter
 * The class in charge of selecting a converter in the application
 */
public class ConverterHandler {
    private final String converterType;

    /**
     * @param converterType
     * Constructor initialized with the name of the converter
     */
    public ConverterHandler(String converterType) {
        this.converterType = converterType;
    }

    /**
     * The method with the application logic.
     * @return a boolean to decide whether to continue with the application
     */
    public boolean performConversion() {
        boolean iterator=true;
        String numberToConvert = JOptionPane.showInputDialog(null, "Enter the value to convert: ", converterType, JOptionPane.QUESTION_MESSAGE);
        if (validateIsNull(numberToConvert)){
            iterator=false;
        }else {
            if (validateNumber(numberToConvert)) {
                double numberValue = Double.parseDouble(numberToConvert);
                Converter converter ;
                if ("Currency converter".equals(converterType)) {
                    converter = new CurrencyConverter();
                } else {
                    converter = new TemperatureConverter();
                }
                iterator=converter.convert(numberValue);
                if (iterator){
                    int response = JOptionPane.showConfirmDialog(null, "Do you want to run the program again?");
                    if(response!=0){
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
