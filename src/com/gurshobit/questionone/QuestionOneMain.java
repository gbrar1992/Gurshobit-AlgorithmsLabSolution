package com.gurshobit.questionone;

import java.util.Scanner;

public class QuestionOneMain {
    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);
        int numberOfTransactions = 0;
        int sumOfTransactions = 0;
        int numberOfTargets = 0;
        int currentTarget = 0;
        int counter = 0;

        System.out.println("Welcome to PayMoney");
        do{
            System.out.println("Enter Number of Transactions");
            numberOfTransactions = scannerInput.nextInt();
        } while(numberOfTransactions < 1);

        int[] transactions = new int[numberOfTransactions];
        System.out.println("Enter the "+((numberOfTransactions > 1) ? "transactions":"transaction" ));
        for (int i = 0; i< transactions.length; i++){
            transactions[i] = scannerInput.nextInt();
        }
        do {
            System.out.println("Enter Number of Targets");
            numberOfTargets = scannerInput.nextInt();
        } while (numberOfTargets < 1);

        for(int j = 0; j < numberOfTargets; j++){
            System.out.println("Enter the value of target " + (j+1));
            currentTarget = scannerInput.nextInt();
            if(currentTarget <= 0){
                System.out.println("Given target "+(j+1)+" is not achieved");
                continue;
            }

            for(int i = 0; i < transactions.length; i++){
                if(sumOfTransactions < currentTarget){
                    sumOfTransactions += transactions[i];
                    counter++;
                }
            }

            if(sumOfTransactions >= currentTarget){
                System.out.println("Target "+ (j+1) +" with value "+currentTarget+" is achieved after "+counter+ " " + ((counter > 1) ? "Transactions":"Transaction" ));
            } else {
                System.out.println("Target "+ (j+1) +" with value "+currentTarget+" is not achieved");
            }
            counter = 0;
            sumOfTransactions = 0;

        }
    }
}
