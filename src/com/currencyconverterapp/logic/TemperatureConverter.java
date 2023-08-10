package com.currencyconverterapp.logic;

import javax.swing.*;
import java.util.HashMap;

import static com.currencyconverterapp.logic.ValidationUtils.validateIsNull;

/**
 * @author jdmon on 9/08/2023.
 * @project CurrencyConverter
 */
public class TemperatureConverter extends Converter{

    public TemperatureConverter(){
        super(new Object[]{"CELSIUS", "FAHRENHEIT", "KELVIN"});

    }
    public boolean convert(double value){
        boolean iterator=true;
        Object sourceCurrency = (JOptionPane.showInputDialog(null, "Select source currency", "TemperatureConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        Object targetCurrency = (JOptionPane.showInputDialog(null, "Select target currency", "TemperatureConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        if (validateIsNull(sourceCurrency) || validateIsNull(targetCurrency)){
            return false;
        }
        String conversionKey = sourceCurrency + "to" + targetCurrency;
        initializeConversions(value);
        double convertedValue = super.conversionRates.get(conversionKey);
        String temperatureSymbol = symbolList.get(targetCurrency.toString());
        String messageConvertedValue = String.format("The conversion to %s is: %.3f%s",targetCurrency,convertedValue,temperatureSymbol);
        JOptionPane.showMessageDialog(null, messageConvertedValue);
        return iterator;
    }

    private void initializeConversions(double value){
        super.conversionRates.put("CELSIUStoFAHRENHEIT",(value * 9 / 5) + 32);
        super.conversionRates.put("CELSIUStoKELVIN",value + 273.15);
        super.conversionRates.put("CELSIUStoCELSIUS",1.0);
        super.conversionRates.put("FAHRENHEITtoCELSIUS",(value - 32) * 5 / 9);
        super.conversionRates.put("FAHRENHEITtoKELVIN",(value - 32) * 5 / 9 + 273.15);
        super.conversionRates.put("FAHRENHEITtoFAHRENHEIT",1.0);
        super.conversionRates.put("KELVINtoCELSIUS",value - 273.15);
        super.conversionRates.put("KELVINtoFAHRENHEIT",(value - 273.15) * 9 / 5 + 32);
        super.conversionRates.put("KELVINtoKELVIN",1.0);

    }



    protected void initializeSymbolList(){
        symbolList.put("CELSIUS","°C");
        symbolList.put("FAHRENHEIT","°F");
        symbolList.put("KELVIN","K");

    }
}
