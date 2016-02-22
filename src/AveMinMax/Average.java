package AveMinMax;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UWW CS424 | Spring 2016 | Program 2
 * Calculates the arithmetic average from a
 * collection of numbers.
 *
 * @author Connor P Grady (1765561)
 * @version 1.0
 */
public class Average implements Runnable {
    private List<Integer> numbers;
    private AtomicInteger average;

    /**
     * Initializes a new instance of Average with the specified collection of numbers.
     *
     * @param numbers The collection of numbers from which to calculate an average.
     */
    public Average(List<Integer> numbers, AtomicInteger average) {
        this.numbers = numbers;
        this.average = average;
    }

    /**
     * Gets the current value of the calculated average.
     *
     * @return Value of the calculated average.
     */
    public AtomicInteger getAverage() {
        return this.average;
    }

    /**
     * Calculates the arithmetic average of the global collection of numbers.
     */
    @Override
    public void run() {
        // Make sure the numbers collection exists and is valid
        if (numbers == null || numbers.size() == 0)
            throw new IllegalArgumentException("Collection of numbers must be at least one number");

        // Declare the temporary sum
        Integer sum = 0;
        // Loop through the collection, adding each number to sum
        for (Integer number : numbers) {
            sum += number;
        }

        // Assign the average as the sum divided by the number of numbers
        average.set(sum / numbers.size());
    }
}
