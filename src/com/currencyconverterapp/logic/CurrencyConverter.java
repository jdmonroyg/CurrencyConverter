package com.currencyconverterapp.logic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.currencyconverterapp.logic.ValidationUtils.*;

/**
 * The currency converter.
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class CurrencyConverter extends Converter{
    /**
     * Initialized units and symbols
     */
    public CurrencyConverter(){
        super(new Object[]{"COP","USD","EUR","GBP","JPY","KRW"});
    }

    /**
     * The conversion method, which uses the source and destination currency, the getApiKey() method, and initializeConversions()
     * @param value to convert
     * @return true for a successful event or false for a failed event
     */
    public boolean convert(double value){

        Object sourceCurrency = (JOptionPane.showInputDialog(null, "Select source currency", "CurrencyConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));
        Object targetCurrency = (JOptionPane.showInputDialog(null, "Select target currency", "CurrencyConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        String apiKey= getApiKey();
        if (validateIsNull(sourceCurrency) || validateIsNull(targetCurrency) || validateIsNullOrEmpty(apiKey)){
            return false;
        }

        double convertedValue = initializeConversions(apiKey,sourceCurrency.toString(),targetCurrency.toString());
        if (validateNegative(convertedValue)){
            return false;
        }
        String currencySymbol = symbolList.get(targetCurrency.toString());
        String messageConvertedValue = String.format("The conversion to %s is: %s%.3f",targetCurrency,currencySymbol,convertedValue*value);
        JOptionPane.showMessageDialog(null, messageConvertedValue);
        return true;
    }

    /**
     * @return get apiKey from configuration properties
     */
    private String getApiKey(){
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")){
            properties.load(fileInputStream);
        }catch (IOException e){
            System.out.println("Error loading configuration file");
        }
        return properties.getProperty("api.key");
    }

    /**
     * Using the library mashape.unirest
     * @param apiKey the apiKey
     * @param sourceCurrency source currency
     * @param targetCurrency target currency
     * @return the value of rate
     */
    private double initializeConversions(String apiKey,String sourceCurrency,String targetCurrency){
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/latest/"+sourceCurrency;
        double rate;
        try {
            // using mashape.unirest.java
            HttpResponse<String> response = Unirest.get(url).asString();
            JSONObject jsonResponse = new JSONObject(response.getBody());
            JSONObject conversionRates=jsonResponse.getJSONObject("conversion_rates");
            rate = conversionRates.getDouble(targetCurrency);
        }catch (Exception ignored){
            return -1;
        }
        return rate;
    }

    /**
     * Initialize symbols
     */
    protected void initializeSymbolList(){
        symbolList.put("COP", "$");
        symbolList.put("USD", "$");
        symbolList.put("EUR", "€");
        symbolList.put("GBP", "£");
        symbolList.put("JPY", "¥");
        symbolList.put("KRW", "₩");
    }
}
