package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     * Experiment with different algorithms to find accurate results.
     * <p>
     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
     * Your code must pass all of the test cases provided in the test folder.
     *
     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */


    public static String calculate(int floatingPoint) {
        // TODO

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        BigDecimal sum = BigDecimal.ZERO;
        MathContext mc = new MathContext(floatingPoint + 2);

        for (int k = 0; k <= floatingPoint; k++) {
            BigDecimal term = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(16).pow(k), mc)
                    .multiply(BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8L * k + 1), mc)
                            .subtract(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8L * k + 4), mc))
                            .subtract(BigDecimal.ONE.divide(BigDecimal.valueOf(8L * k + 5), mc))
                            .subtract(BigDecimal.ONE.divide(BigDecimal.valueOf(8L * k + 6), mc)));
            sum = sum.add(term);
        }

        return sum.setScale(floatingPoint, BigDecimal.ROUND_DOWN).toString();
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself

    }
}
