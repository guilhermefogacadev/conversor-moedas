package org.example;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoedas {
    double valor;
    String moeda;

    public ConversorMoedas(double valor, String moeda) {
        this.valor = valor;
        this.moeda = moeda;


        JOptionPane.showMessageDialog(null, moeda);
    }

    public ConversorMoedas() {
    }



    public double calculoConversao(double valor, String moedaBase, String moedaAlvo) throws IOException {
        String url_str = String.format(" https://v6.exchangerate-api.com/v6/7683def73592835d4ace6765/pair/%s/%s/%s", moedaBase, moedaAlvo, valor);
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.setRequestMethod("GET");
        request.connect();
        InputStream stream = request.getInputStream();

        JsonParser parser = new JsonParser();
        JsonElement root = parser.parse(new InputStreamReader(stream));
        JsonObject jsonObj = root.getAsJsonObject();



        if (jsonObj.has("conversion_result")) {
            double conversionResult = jsonObj.get("conversion_result").getAsDouble();
            stream.close();
            return conversionResult;
        } else {
            return -1;
        }


    }


}
