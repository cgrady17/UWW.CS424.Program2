package AveMinMax;

import java.util.List;

/**
 * UWW CS424 | Spring 2016 | Program 2
 * Calculates the numeric ceiling (i.e. maximum) from a
 * collection of numbers.
 *
 * @author Connor P Grady (1765561)
 * @version 1.0
 */
public class Maximum implements Runnable {
    public List<Integer> numbers;
    public int maximum;

    public Maximum(List<Integer> numbers) {
        this.numbers = numbers;
        this.maximum = 0;
    }

    /**
     * Calculates the numeric ceiling of the global collection of numbers.
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
            maximum = (number > maximum) ? number : maximum;
        }
    }
}
