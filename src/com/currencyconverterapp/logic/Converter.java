package com.currencyconverterapp.logic;

import java.util.HashMap;

/**
 * @author jdmon on 9/08/2023.
 * @project execution stack
 */
public abstract class Converter {
    protected Object[] units;
    protected HashMap<String, Double> conversionRates;
    protected HashMap<String, String> symbolList;

    public Converter(Object[] units){
        this.units = units;
        this.conversionRates = new HashMap<>();
        this.symbolList = new HashMap<>();
        initializeSymbolList();
    }
    public abstract boolean convert(double value);

    protected void initializeSymbolList() {
    }
}
