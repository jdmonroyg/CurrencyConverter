package com.currencyconverterapp.logic;

import javax.swing.*;

import java.util.HashMap;
import java.util.Map;

import static com.currencyconverterapp.logic.ValidationUtils.validateNotNull;

/**
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class CurrencyConverter {
    private Object currencies[];
    private HashMap<String, Double> exchangesRates;
    private HashMap<String, String> symbolList;

    public CurrencyConverter(){
        this.currencies=new Object[]{"COP","USD","EUR","GBP","JPY","KRW"};
        this.exchangesRates = new HashMap<>();
        this.symbolList = new HashMap<>();
        initializeExchangeRates();
        initializeSymbolList();
    }
    public boolean convertCurrency(double value){
        boolean iterator=true;
        Object sourceCurrency = (JOptionPane.showInputDialog(null, "Select source currency", "ConverterCurrency", JOptionPane.QUESTION_MESSAGE, null, currencies, "Select"));

        Object targetCurrency = (JOptionPane.showInputDialog(null, "Select target currency", "ConverterCurrency", JOptionPane.QUESTION_MESSAGE, null, currencies, "Select"));

        if (validateNotNull(sourceCurrency) || validateNotNull(targetCurrency)){
            return false;
        }
        // logic to convert
        String conversionKey = sourceCurrency + "to" + targetCurrency;

        double convertedValue = exchangesRates.get(conversionKey)*value;
        String currencySymbol = symbolList.get(targetCurrency.toString());
        String messageConvertedValue = String.format("The conversion to %s is: %s%.7f",targetCurrency,currencySymbol,convertedValue);
        JOptionPane.showMessageDialog(null, messageConvertedValue);
        return iterator;
    }

    private void initializeExchangeRates(){
        //conversion values date 08-05-2023
        exchangesRates.put("COPtoCOP",1.0);
        exchangesRates.put("COPtoUSD",0.00024);
        exchangesRates.put("COPtoEUR",0.00022);
        exchangesRates.put("COPtoGBP",0.00019);
        exchangesRates.put("COPtoJPY",0.034);
        exchangesRates.put("COPtoKRW",0.32);
        exchangesRates.put("USDtoCOP",4140.21);
        exchangesRates.put("USDtoUSD",1.0);
        exchangesRates.put("USDtoEUR",0.91);
        exchangesRates.put("USDtoGBP",0.78);
        exchangesRates.put("USDtoJPY",141.75);
        exchangesRates.put("USDtoKRW",1304.04);
        exchangesRates.put("EURtoCOP",4565.20);
        exchangesRates.put("EURtoUSD",1.10);
        exchangesRates.put("EURtoEUR",1.0);
        exchangesRates.put("EURtoGBP",0.86);
        exchangesRates.put("EURtoJPY",156.31);
        exchangesRates.put("EURtoKRW",1437.90);
        exchangesRates.put("GBPtoCOP",5277.93);
        exchangesRates.put("GBPtoUSD",1.27);
        exchangesRates.put("GBPtoEUR",1.16);
        exchangesRates.put("GBPtoGBP",1.0);
        exchangesRates.put("GBPtoJPY",180.71);
        exchangesRates.put("GBPtoKRW",1662.96);
        exchangesRates.put("JPYtoCOP",29.21);
        exchangesRates.put("JPYtoUSD",0.0071);
        exchangesRates.put("JPYtoEUR",0.0064);
        exchangesRates.put("JPYtoGBP",0.0055);
        exchangesRates.put("JPYtoJPY",1.0);
        exchangesRates.put("JPYtoKRW",9.20);
        exchangesRates.put("KRWtoCOP",3.17);
        exchangesRates.put("KRWtoUSD",0.00077);
        exchangesRates.put("KRWtoEUR",0.00070);
        exchangesRates.put("KRWtoGBP",0.00060);
        exchangesRates.put("KRWtoJPY",0.11);
        exchangesRates.put("KRWtoKRW",1.0);
    }

    private void initializeSymbolList(){
        symbolList.put("COP", "$");
        symbolList.put("USD", "$");
        symbolList.put("EUR", "€");
        symbolList.put("GBP", "£");
        symbolList.put("JPY", "¥");
        symbolList.put("KRW", "₩");

    }





}
