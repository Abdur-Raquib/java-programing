package geneticAlgorithm;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class GeneticNQueen {
    public static void main(String[] args) {
        int nq = 8;
        int maxFitness = (nq*(nq-1))/2;
        List<Integer> chromosome = random_chromosome(nq);
        int horizontal_collisions = 0;
        for (int i = 0; i < nq; i++) {
            int queen = chromosome.get(i);
            horizontal_collisions += chromosome.indexOf(queen) != i ? 1 : 0;
        }
        double diagonal_collisions = 0;
        int n = chromosome.size();
        List<Integer> left_diagonal = new ArrayList<Integer>(2*n);
        List<Integer> right_diagonal = new ArrayList<Integer>(2*n);
        for (int i = 0; i < 2*n; i++) {
            left_diagonal.add(0);
            right_diagonal.add(0);
        }
        for (int i = 0; i < n; i++) {
            left_diagonal.set(i + chromosome.get(i) - 1, left_diagonal.get(i + chromosome.get(i) - 1) + 1);
            right_diagonal.set(n - i + chromosome.get(i) - 2, right_diagonal.get(n - i + chromosome.get(i) - 2) + 1);
        }
        for (int i = 0; i < 2*n-1; i++) {
            int counter = 0;
            if (left_diagonal.get(i) > 1) {
                counter += left_diagonal.get(i)-1;
            }
            if (right_diagonal.get(i) > 1) {
                counter += right_diagonal.get(i)-1;
            }
            diagonal_collisions += counter / (double)(n-Math.abs(i-n+1));
        }
        int fitness = (int)(maxFitness - (horizontal_collisions + diagonal_collisions));
        double probability = probability(chromosome, maxFitness);
        List<List<Integer>> population = new ArrayList<List<Integer>>();
        List<Double> probabilities = new ArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            population.add(random_chromosome(nq));
            probabilities.add(probability(population.get(i), maxFitness));
        }
        List<Integer> x = population.get(0);
        List<Integer> y = population.get(1);
        int c = new Random().nextInt(n);
        List<Integer> child = reproduce(x, y, c);
    }

    public static List<Integer> random_chromosome(int nq) {
        List<Integer> chromosome = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < nq; i++) {
            chromosome.add(rand.nextInt(nq) + 1);
        }
        return chromosome;
    }

    public static int fitness(List<Integer> chromosome, int maxFitness) {
        int horizontal_collisions = 0;
        for (int i = 0; i < chromosome.size(); i++) {
            int queen = chromosome.get(i);
            horizontal_collisions += chromosome.indexOf(queen) != i ? 1 : 0;
        }
        double diagonal_collisions = 0;
        int n = chromosome.size();
        List<Integer> left_diagonal = new ArrayList<Integer>(2*n);
        List<Integer> right_diagonal = new ArrayList<Integer>(2*n);
        for (int i = 0; i < 2*n; i++) {
            left_diagonal.add(0);
            right_diagonal.add(0);
        }
        for (int i = 0; i < n; i++) {
            left_diagonal.set(i + chromosome.get(i) - 1, left_diagonal.get(i + chromosome.get(i) - 1) + 1);
            right_diagonal.set(n - i + chromosome.get(i) - 2, right_diagonal.get(n - i + chromosome.get(i) - 2) + 1);
        }
        for (int i = 0; i < 2*n-1; i++) {
            int counter = 0;
            if (left_diagonal.get(i) > 1) {
                counter += left_diagonal.get(i)-1;
            }
            if (right_diagonal.get(i) > 1) {
                counter += right_diagonal.get(i)-1;
            }
            diagonal_collisions += counter / (double)(n-Math.abs(i-n+1));
        }
        return (int)(maxFitness - (horizontal_collisions + diagonal_collisions));
    }

    public static double probability(List<Integer> chromosome, int maxFitness) {
        return fitness(chromosome, maxFitness) / (double)maxFitness;
    }

    public static List<Integer> reproduce(List<Integer> x, List<Integer> y, int c) {
        List<Integer> child = new ArrayList<Integer>();
        for (int i = 0; i < c; i++) {
            child.add(x.get(i));
        }
        for (int i = c; i < x.size(); i++) {
            child.add(y.get(i));
        }
        return child;
    }
}