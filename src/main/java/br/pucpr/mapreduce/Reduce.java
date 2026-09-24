package br.pucpr.mapreduce;

import java.util.List;

/**
 * Reducer: recebe todas as temperaturas emitidas pelo Mapper
 * e calcula a média usando soma / quantidade.
 */
public class Reduce {

    public double reduce(List<Double> temperatures) {
        if (temperatures == null || temperatures.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma temperatura foi encontrada.");
        }

        double sum = 0.0;

        for (double temperature : temperatures) {
            sum += temperature;
        }

        // IMPORTANTE: média = soma de todas as temperaturas / quantidade de temperaturas.
        // Não devemos fazer a média das médias produzidas por grupos diferentes.
        return sum / temperatures.size();
    }
}
