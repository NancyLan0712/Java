package CampusServiceSystem;


import java.util.*;

public class CalculateCost {

    public static void main(String[] args) {
        // 1. ask the user to enter the number of the item
        System.out.println("Please enter the number of items:");
        Scanner input = new Scanner(System.in);
        int itemNum = input.nextInt();

        // 2. ask the user to enter the unit price of each item
        // use for-loop
        System.out.println("Please enter the unit price of each item:");
        double[] unitTotalPrices = new double[itemNum];
        for (int i = 0; i < itemNum; i++) {
            unitTotalPrices[i] = input.nextDouble();
        }

        // 3. use my method to calculate the price after the discount
        double totalPrice = calculateCost(unitTotalPrices);
        int finalCost = (int) Math.floor(totalPrice);
        System.out.println("Total cost after discount: " + finalCost);
    }

    // my method
    // signature: calculateCost double --> double;
    // purpose: Design a method using the header below that accepts a double
    // array where each element in the array represents the unit total price of
    // an item you want to buy and return the final total price.
    // examples: calculateCost ({45, 40, 120}) returns 194.75 as (45+40+120)*0.95=194.75
    public static double calculateCost(double[] unitTotalPrices) {
        double firstSum = 0;

        // 1. compute the sum of these items' prices
        for (int i = 0; i < unitTotalPrices.length; i++) {
            firstSum = firstSum + unitTotalPrices[i];
        }

        // 2. apply the discount
        if (firstSum >= 200 && firstSum < 360) {
            firstSum = firstSum - firstSum * 0.05;
        } else if (firstSum >= 360 && firstSum < 520) {
            firstSum = firstSum - firstSum * 0.1;
        } else if (firstSum < 200) {
            // No discount
        } else {
            firstSum = firstSum - firstSum * 0.2;
        }

        return firstSum;
    }
}
