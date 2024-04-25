package org.example;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        double valor;
        ConversorMoedas conversor = new ConversorMoedas();
        String[] moedas = {"Dólar", "Peso Argentino", "Real Brasileiro", "Peso Colombiano"};
        Map<String, String> simbolo = new HashMap<>();
        simbolo.put("Dólar", "USD");
        simbolo.put("Peso Argentino", "ARS");
        simbolo.put("Real Brasileiro", "BRL");
        simbolo.put("Peso Colombiano", "COP");
        simbolo.put("Euro", "EUR");


        JComboBox<String> origemComboBox = new JComboBox<>(moedas);
        JComboBox<String> destinoComboBox = new JComboBox<>(moedas);
        JTextField valorField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Moeda de Origem:"));
        panel.add(origemComboBox);
        panel.add(new JLabel("Moeda de Destino:"));
        panel.add(destinoComboBox);
        panel.add(new JLabel("Valor:"));
        panel.add(valorField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Conversão de Moeda", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String origem = (String) origemComboBox.getSelectedItem();
            String destino = (String) destinoComboBox.getSelectedItem();
            if(!valorField.getText().isEmpty()){
                valor = Double.parseDouble(valorField.getText());
                double conversao=conversor.calculoConversao(valor,simbolo.get(origem),simbolo.get(destino));
                JOptionPane.showMessageDialog(null, "Valor convertido: " + conversao
                        + " " + simbolo.get(destino));
            }else{
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.");
        }
    }


}
