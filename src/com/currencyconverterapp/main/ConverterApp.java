package com.currencyconverterapp;

import javax.swing.*;

/**
 * @author jdmon on 3/08/2023.
 * @project CurrencyConverter
 */
public class CurrencyConverterApp {
    public static void main(String[] args) {
        ImageIcon principalIcon = new ImageIcon("../icons/icon.png");
        String options = (JOptionPane.showInputDialog(null, "Select conversion option", "ConverterApp", JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Currency converter", "Temperature Converter"}, "Select")).toString();
        switch (options){
            case "Currency converter":
                String input = JOptionPane.showInputDialog(null,"Enter the value to convert: ","Currency Converter",3);
                break;
            case "Temperature Converter":
                System.out.println("pig");
                break;
        }
    }
}

