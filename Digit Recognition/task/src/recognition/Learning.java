package recognition;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

public class Learning implements Serializable {
    private static final long serialVersionUID = 2L;
    private final int OUTPUT_NEURONS = 10;
    private final int NEURON_WEIGHTS = 15;
    private final double[][] weights = new double[OUTPUT_NEURONS][NEURON_WEIGHTS];
    private final Random random = new Random();

    public void serialization() {
        String filename = "/home/milkbeek/IdeaProjects/Digit Recognition/bias.txt";
        try {
            SerializationUtils.serialize(learning(), filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double calculateSigmoid(double sum) {
        return 1 / (1 + Math.exp(-sum));
    }

    private double[][] learning() {
        double[][] deltaWeight = new double[OUTPUT_NEURONS][NEURON_WEIGHTS];

        int[][] data = {
                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}, // 0
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0}, // 1
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, // 2
                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // 3
                {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1}, // 4
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1}, // 5
                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1}, // 6
                {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1}, // 7
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1}, // 8
                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1}  // 9
        };
        System.out.println("Learning...");
        for (int i = 0; i < OUTPUT_NEURONS; i++) {
            for (int j = 0; j < NEURON_WEIGHTS; j++) {
                weights[i][j] = random.nextGaussian();
            }
        }
        for (int t = 0; t < 1000; t++) {
            for (int i = 0; i < OUTPUT_NEURONS; i++) {
                for (int j = 0; j < OUTPUT_NEURONS; j++) {
                    double outNeuron = 0.0;
                    for (int n = 0; n < NEURON_WEIGHTS; n++) {
                        outNeuron += data[j][n] * weights[i][n];
                    }
                    outNeuron = calculateSigmoid(outNeuron);

                    for (int m = 0; m < NEURON_WEIGHTS; m++) {
                        int desOut = i == j ? 1 : 0;
                        double learningRate = 0.5;
                        deltaWeight[j][m] = learningRate * data[j][m] * (desOut - outNeuron);
                    }
                }

                for (int r = 0; r < NEURON_WEIGHTS; r++) {
                    double mean = 0.0;
                    for (int d = 0; d < OUTPUT_NEURONS; d++) {
                        mean += deltaWeight[d][r];
                    }
                    weights[i][r] += mean / OUTPUT_NEURONS;
                }
            }
        }
        System.out.println("Done! Saved to the file.");
        return weights;
    }

}
