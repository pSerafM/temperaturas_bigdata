package br.pucpr.mapreduce;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Executa o fluxo Map -> Shuffle/Group -> Reduce.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Path input = Path.of("forestfireinput.csv");

        if (!Files.exists(input)) {
            System.err.println("Arquivo não encontrado: " + input.toAbsolutePath());
            return;
        }

        Map mapper = new Map();
        Reduce reducer = new Reduce();

        // Saída intermediária do Mapper.
        List<Double> temperatures = new ArrayList<>();

        for (String line : Files.readAllLines(input)) {
            java.util.Map<String, List<Double>> mapped = mapper.map(line);

            List<Double> mappedTemperatures = mapped.get("temperature");
            if (mappedTemperatures != null) {
                temperatures.addAll(mappedTemperatures);
            }
        }

        double average = reducer.reduce(temperatures);

        System.out.println("======================================");
        System.out.println("MapReduce - Média de Temperaturas");
        System.out.println("======================================");
        System.out.printf("Quantidade de temperaturas: %d%n", temperatures.size());
        System.out.printf("Média das temperaturas: %.2f °C%n", average);
    }
}
