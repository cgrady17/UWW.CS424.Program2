package AveMinMax;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

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
    public AtomicInteger maximum;

    public Maximum(List<Integer> numbers, AtomicInteger maximum) {
        this.numbers = numbers;
        this.maximum = maximum;
    }

    /**
     * Calculates the numeric ceiling of the global collection of numbers.
     */
    @Override
    public void run() {
        // Make sure the numbers collection exists and is valid
        if (numbers == null || numbers.size() == 0)
            throw new IllegalArgumentException("Collection of numbers must be at least one number");

        int currMaximum = maximum.get();
        if (currMaximum != 0) maximum.set(0);

        // Iterate through each number in the collection
        // If the number is greater than the existing maximum,
        // replace the maximum with the number
        for (Integer number : numbers) {
            currMaximum = maximum.get();

            if (number > currMaximum) maximum.set(number);
        }
    }
}
