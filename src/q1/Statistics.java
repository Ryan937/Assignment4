package q1;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>This class lets the user to input up to 50 integers. Then it calculates 
 * the mean and standard deviation of those numbers.</p>
 *
 * @author Ryan Sungjoo Cha
 * @version 1.0
 */
public class Statistics {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * 
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {

        final int sizelimit = 50;
        int[] numbers = new int[sizelimit];
        int count = 0;
        int sum = 0;
        float mean;
        float sumpower = 0;
        float sd;
        String q;
        boolean ongoing = true;

        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.##");

        System.out.println("Please enter the integers with a space " 
                + "between them: ");
        System.out.println("(If you want to stop inputting type q for quit)");

        while (ongoing) {
            q = scan.next();
            if (q.equalsIgnoreCase("q")) {
                ongoing = false;
            } else {
                numbers[count] = Integer.parseInt(q);
                sum += numbers[count];
                count++;
            }

        }

        if (count == 0) {
            System.out.println("There was no input");
        } else {
            mean = (float) sum / count;
            for (int i = 0; i < count; i++) {
                sumpower += Math.pow(numbers[i] - mean, 2);
            }
            sd = (float) Math.sqrt(sumpower / (count - 1));
            System.out.println("There were total of " + count 
                    + " numbers inputted.");
            System.out.println("The mean of those numbers is: " 
                    + fmt.format(mean));
            System.out.println("The standard deviation of those numbers is: " 
                    + fmt.format(sd));
        }

        System.out.println("\nQuestion one was called and ran sucessfully.");
        scan.close();
    }

};
