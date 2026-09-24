package br.pucpr.mapreduce;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper: lê uma linha do CSV e extrai a temperatura.
 *
 * Formato do dataset:
 * X,Y,month,day,FFMC,DMC,DC,ISI,temp,RH,wind,rain,area
 *
 * A temperatura está na coluna 9 (índice 8).
 */
public class Map {

    public java.util.Map<String, List<Double>> map(String line) {
        java.util.Map<String, List<Double>> result = new java.util.HashMap<>();

        String[] columns = line.split(",");

        // Ignora linhas inválidas.
        if (columns.length < 9) {
            return result;
        }

        try {
            double temperature = Double.parseDouble(columns[8].trim());

            List<Double> temperatures = new ArrayList<>();
            temperatures.add(temperature);

            result.put("temperature", temperatures);
        } catch (NumberFormatException ignored) {
            // Linha inválida: não produz saída.
        }

        return result;
    }
}
