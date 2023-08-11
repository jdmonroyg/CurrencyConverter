package com.currencyconverterapp.logic;

import java.util.HashMap;

/**
 * The parent class of converters.
 * @author jdmon on 9/08/2023.
 * @project execution stack
 */
public abstract class Converter {
    protected Object[] units;
    protected HashMap<String, String> symbolList;

    /**
     * The constructor that initializes the conversion units and their symbols
     * @param units for Initialized units
     */
    public Converter(Object[] units){
        this.units = units;
        this.symbolList = new HashMap<>();
        initializeSymbolList();
    }

    /**
     * The logic of a convert
     * @param value to convert
     * @return true for a successful event or false for a failed event
     */
    public abstract boolean convert(double value);

    protected void initializeSymbolList() {
    }
}
