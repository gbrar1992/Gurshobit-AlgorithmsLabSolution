package com.gurshobit.questiontwo;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionTwoMain {
    public static void main(String[] args) {

        Scanner scannerInput = new Scanner(System.in);

        int numberOfDenominations = 0;
        int payableAmount = 0;

        System.out.println("Welcome Traveller");

        do{
            System.out.println("Enter the number of denominations");
            numberOfDenominations = scannerInput.nextInt();
        } while(numberOfDenominations < 1);

        int[] denominations = new int[numberOfDenominations];
        int[] denominationCounter = new int[numberOfDenominations];

        System.out.println("Enter the "+ ((numberOfDenominations > 1) ? "denominations":"denomination"));

        for(int i = 0; i< denominations.length; i++){
            denominations[i] = scannerInput.nextInt();
        }

        do {
            System.out.println("Enter the amount to be paid");
            payableAmount = scannerInput.nextInt();
        } while(payableAmount < 1);

//        Method One -- In-build Java Function

//        Arrays.sort(denominations);

//        Method Two Used -- Own Merge Sort Function

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(denominations,0, denominations.length - 1,false);

        System.out.println("Amount to be paid in following order");

        for (int i = numberOfDenominations - 1; i >= 0; i--){

            if(payableAmount >= denominations[i]){
                denominationCounter[i] = payableAmount / denominations[i];
                payableAmount = payableAmount - (denominationCounter[i] * denominations[i]);
            }

            if(denominationCounter[i] != 0){
                System.out.println("Denomination " + denominations[i] + ": " + denominationCounter[i]);
            }

        }

    }
}
