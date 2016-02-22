package AveMinMax;

import java.util.List;

/**
 * UWW CS424 | Spring 2016 | Program 2
 * Calculates the numeric floor (i.e. minimum) from a
 * collection of numbers.
 *
 * @author Connor P Grady (1765561)
 * @version 1.0
 */
public class Minimum implements Runnable {
    public List<Integer> numbers;
    public int minimum;

    public Minimum(List<Integer> numbers) {
        this.numbers = numbers;
        this.minimum = Integer.MAX_VALUE;
    }

    /**
     * Calculates the numeric floor of the global collection of numbers.
     */
    @Override
    public void run() {
        // Make sure the numbers collection exists and is valid
        if (numbers == null || numbers.size() == 0)
            throw new IllegalArgumentException("Collection of numbers must be at least one number");

        // Iterate through each number in the collection
        // If the number is greater than the existing maximum,
        // replace the maximum with the number
        for (Integer number : numbers) {
            minimum = (number < minimum) ? number : minimum;
        }
    }
}
