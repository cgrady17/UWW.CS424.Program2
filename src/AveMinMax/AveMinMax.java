package AveMinMax;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UWW CS 424 | Spring 2016 | Program 2
 * Multithreaded program that calculates various statistical values
 * from a list of numbers. Each value calculation will be performed
 * on its own thread. The primary thread then outputs the values.
 *
 * <p>Currently outputs: Average, Maximum, Minimum</p>
 *
 * @author Connor P Grady (1765561)
 * @version 1.0
 */
public class AveMinMax {

    public static void main(String[] args) {
        // Declare the numbers collection
        List<Integer> numbers = new ArrayList<>();

        // Program console header
        System.out.println("UWW CS424 | Spring 2016 | Program 2");

        // Output interrogative
        System.out.print("Please enter a set of Integer, delimited by a comma: ");

        // Instantiate the Scanner on the System's input
        Scanner scanner = new Scanner(System.in);

        // Get the input String
        String input = scanner.nextLine();

        // Split the String on comma + whitespace delimiters
        String[] inputArr = input.split("\\s*,\\s*");

        // Loop through String array, converting each element
        // to an Integer and add it to the numbers collection
        for (String s : inputArr) {
            numbers.add(Integer.parseInt(s));
        }

        // Create an AtomicInteger for Average
        // I'm using AtomicInteger to simulate pass by reference
        // Easier than creating wrapper object
        AtomicInteger average = new AtomicInteger(0);

        // Instantiate a new Thread with the Average class
        Thread avgThread = new Thread(new Average(numbers, average));

        // Start the Average Thread
        avgThread.start();

        try {
            // Wait for the Thread
            avgThread.join();
            // Output the value of average, which should now be updated
            System.out.println("The average is: " + average);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create an AtomicInteger for Maximum
        AtomicInteger maximum = new AtomicInteger(0);

        // Instantiate a new Thread with the Maximum class
        Thread maxThread = new Thread(new Maximum(numbers, maximum));

        // Start the Maximum Thread
        maxThread.start();

        try {
            // Wait for the Thread
            maxThread.join();
            // Output the value of maximum, which should now be updated
            System.out.println("The maximum is: " + maximum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create an AtomicInteger for Minimum
        AtomicInteger minimum = new AtomicInteger(0);

        // Instantiate a new Thread with the Minimum class
        Thread minThread = new Thread(new Minimum(numbers, minimum));

        // Start the Minimum Thread
        minThread.start();

        try {
            // Wait for the Thread
            minThread.join();
            // Output the value of minimum, which should now be udpated
            System.out.println("The minimum is: " + minimum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Output exit
        System.out.println("Program complete. Good-bye!");
    }
}
