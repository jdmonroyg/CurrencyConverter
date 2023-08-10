package com.currencyconverterapp.logic;

import javax.swing.*;

import java.util.HashMap;

import static com.currencyconverterapp.logic.ValidationUtils.validateIsNull;

/**
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class CurrencyConverter extends Converter{
    public CurrencyConverter(){
        super(new Object[]{"COP","USD","EUR","GBP","JPY","KRW"});
        initializeConversions();
    }
    public boolean convert(double value){
        boolean iterator=true;
        Object sourceCurrency = (JOptionPane.showInputDialog(null, "Select source currency", "CurrencyConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        Object targetCurrency = (JOptionPane.showInputDialog(null, "Select target currency", "CurrencyConverter", JOptionPane.QUESTION_MESSAGE, null, super.units, "Select"));

        if (validateIsNull(sourceCurrency) || validateIsNull(targetCurrency)){
            return false;
        }
        String conversionKey = sourceCurrency + "to" + targetCurrency;

        double convertedValue = super.conversionRates.get(conversionKey)*value;
        String currencySymbol = symbolList.get(targetCurrency.toString());
        String messageConvertedValue = String.format("The conversion to %s is: %s%.3f",targetCurrency,currencySymbol,convertedValue);
        JOptionPane.showMessageDialog(null, messageConvertedValue);
        return iterator;
    }

    private void initializeConversions(){
        //conversion values date 08-05-2023
        super.conversionRates.put("COPtoCOP",1.0);
        super.conversionRates.put("COPtoUSD",0.00024);
        super.conversionRates.put("COPtoEUR",0.00022);
        super.conversionRates.put("COPtoGBP",0.00019);
        super.conversionRates.put("COPtoJPY",0.034);
        super.conversionRates.put("COPtoKRW",0.32);
        super.conversionRates.put("USDtoCOP",4140.21);
        super.conversionRates.put("USDtoUSD",1.0);
        super.conversionRates.put("USDtoEUR",0.91);
        super.conversionRates.put("USDtoGBP",0.78);
        super.conversionRates.put("USDtoJPY",141.75);
        super.conversionRates.put("USDtoKRW",1304.04);
        super.conversionRates.put("EURtoCOP",4565.20);
        super.conversionRates.put("EURtoUSD",1.10);
        super.conversionRates.put("EURtoEUR",1.0);
        super.conversionRates.put("EURtoGBP",0.86);
        super.conversionRates.put("EURtoJPY",156.31);
        super.conversionRates.put("EURtoKRW",1437.90);
        super.conversionRates.put("GBPtoCOP",5277.93);
        super.conversionRates.put("GBPtoUSD",1.27);
        super.conversionRates.put("GBPtoEUR",1.16);
        super.conversionRates.put("GBPtoGBP",1.0);
        super.conversionRates.put("GBPtoJPY",180.71);
        super.conversionRates.put("GBPtoKRW",1662.96);
        super.conversionRates.put("JPYtoCOP",29.21);
        super.conversionRates.put("JPYtoUSD",0.0071);
        super.conversionRates.put("JPYtoEUR",0.0064);
        super.conversionRates.put("JPYtoGBP",0.0055);
        super.conversionRates.put("JPYtoJPY",1.0);
        super.conversionRates.put("JPYtoKRW",9.20);
        super.conversionRates.put("KRWtoCOP",3.17);
        super.conversionRates.put("KRWtoUSD",0.00077);
        super.conversionRates.put("KRWtoEUR",0.00070);
        super.conversionRates.put("KRWtoGBP",0.00060);
        super.conversionRates.put("KRWtoJPY",0.11);
        super.conversionRates.put("KRWtoKRW",1.0);
    }


    protected void initializeSymbolList(){
        symbolList.put("COP", "$");
        symbolList.put("USD", "$");
        symbolList.put("EUR", "€");
        symbolList.put("GBP", "£");
        symbolList.put("JPY", "¥");
        symbolList.put("KRW", "₩");

    }
}
