import java.util.Scanner;

public class SimpleNeuralNetwork {
    private int layers;
    private int[] nodes;
    private double[][][] weights; 


    public SimpleNeuralNetwork(int layers, int[] nodes) {
        this.layers = layers;
        this.nodes = nodes;
        
        weights = new double[layers - 1][][];
        for (int i = 0; i < layers - 1; i++) {
            weights[i] = new double[nodes[i]][nodes[i + 1]];
        }
    }


    public void inputWeights() {
        Scanner scanner = new Scanner(System.in);
        for (int layer = 0; layer < layers - 1; layer++) {
            System.out.println("Layer " + (layer + 1) + " to " + (layer + 2) + ":");
            for (int node = 0; node < nodes[layer]; node++) {
                for (int nextNode = 0; nextNode < nodes[layer + 1]; nextNode++) {
                    System.out.print("Node " + (node + 1) + " to " + (nextNode + 1) + ": ");
                    weights[layer][node][nextNode] = scanner.nextDouble();
                }
            }
        }
    }

    public double fetchWeight(int fromLayer, int fromNode, int toNode) {
        return weights[fromLayer - 1][fromNode - 1][toNode - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Layers count: ");
        int layerCount = scanner.nextInt();

        int[] nodesPerLayer = new int[layerCount];
        System.out.println("Nodes per layer:");
        for (int i = 0; i < layerCount; i++) {
            nodesPerLayer[i] = scanner.nextInt();
        }

        SimpleNeuralNetwork network = new SimpleNeuralNetwork(layerCount, nodesPerLayer);
        network.inputWeights();
        
        System.out.print("From layer: ");
        int fromLayer = scanner.nextInt();
        System.out.print("From node: ");
        int fromNode = scanner.nextInt();
        System.out.print("To node: ");
        int toNode = scanner.nextInt();

        System.out.println("Weight: " + network.fetchWeight(fromLayer, fromNode, toNode));
    }
}
