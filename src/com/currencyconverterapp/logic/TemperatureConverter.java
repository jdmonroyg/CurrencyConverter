package com.currencyconverterapp.logic;

import javax.swing.*;
import java.util.HashMap;

import static com.currencyconverterapp.logic.ValidationUtils.validateIsNull;

/**
 * @author jdmon on 9/08/2023.
 * @project CurrencyConverter
 */
public class TemperatureConverter extends Converter{
    private final HashMap<String, Double> conversionRates;

    /**
     * Initialized units and symbols
     *
     */
    public TemperatureConverter(){
        super(new Object[]{"CELSIUS", "FAHRENHEIT", "KELVIN"});
        this.conversionRates = new HashMap<>();

    }
    /**
     * The conversion method, which uses the source and destination temperature, conversionRates list and initializeConversions()
     * @param value to convert
     * @return true for a successful event or false for a failed event
     */
    public boolean convert(double value){
        Object sourceCurrency = (JOptionPane.showInputDialog(null, "Select source currency", "TemperatureConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));
        Object targetCurrency = (JOptionPane.showInputDialog(null, "Select target currency", "TemperatureConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        if (validateIsNull(sourceCurrency) || validateIsNull(targetCurrency)){
            return false;
        }
        String conversionKey = sourceCurrency + "to" + targetCurrency;
        initializeConversions(value);
        double convertedValue = conversionRates.get(conversionKey);
        String temperatureSymbol = symbolList.get(targetCurrency.toString());
        String messageConvertedValue = String.format("The conversion to %s is: %.3f%s",targetCurrency,convertedValue,temperatureSymbol);
        JOptionPane.showMessageDialog(null, messageConvertedValue);
        return true;
    }

    /**
     * Initialize a list with key and temperature conversion values
     * @param value value used to initialize rates
     */
    private void initializeConversions(double value){
        conversionRates.put("CELSIUStoFAHRENHEIT",(value * 9 / 5) + 32);
        conversionRates.put("CELSIUStoKELVIN",value + 273.15);
        conversionRates.put("CELSIUStoCELSIUS",1.0);
        conversionRates.put("FAHRENHEITtoCELSIUS",(value - 32) * 5 / 9);
        conversionRates.put("FAHRENHEITtoKELVIN",(value - 32) * 5 / 9 + 273.15);
        conversionRates.put("FAHRENHEITtoFAHRENHEIT",1.0);
        conversionRates.put("KELVINtoCELSIUS",value - 273.15);
        conversionRates.put("KELVINtoFAHRENHEIT",(value - 273.15) * 9 / 5 + 32);
        conversionRates.put("KELVINtoKELVIN",1.0);

    }
    /**
     * Initialize symbols
     */
    protected void initializeSymbolList(){
        symbolList.put("CELSIUS","°C");
        symbolList.put("FAHRENHEIT","°F");
        symbolList.put("KELVIN","K");

    }
}
