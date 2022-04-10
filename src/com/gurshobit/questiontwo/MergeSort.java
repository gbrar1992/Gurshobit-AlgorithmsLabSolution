package com.gurshobit.questiontwo;

public class MergeSort {

    void merge(int[] inputArray, int leftPointer, int middlePointer, int rightPointer){
        int leftHalfItems = (middlePointer - leftPointer) + 1;
        int rightHalfItems = rightPointer - middlePointer;

        int[] leftHalf = new int[leftHalfItems];
        int[] rightHalf = new int[rightHalfItems];

        for(int i = 0; i < leftHalfItems; ++i){
            leftHalf[i] = inputArray[leftPointer + i];
        }

        for(int j = 0; j < rightHalfItems; ++j){
            rightHalf[j] = inputArray[middlePointer + 1 + j];
        }

        int k = 0, l = 0, m = leftPointer ;
        while (k < leftHalfItems && l < rightHalfItems)
        {
            if (leftHalf[k] <= rightHalf[l])
            {
                inputArray[m] = leftHalf[k];
                k++;
            } else {
                inputArray[k] = rightHalf[l];
                l++;
            }
            m++;
        }

        while (k < leftHalfItems)
        {
            inputArray[m] = leftHalf[k];
            k++;
            m++;
        }

        while (l < rightHalfItems)
        {
            inputArray[m] = rightHalf[l];
            l++;
            m++;
        }
    }

    void sort(int[] inputArray, int leftPointer, int rightPointer){

        if(leftPointer >= rightPointer){
            int tempPointer = leftPointer;
            leftPointer = rightPointer;
            rightPointer = tempPointer;
        }

        if(leftPointer < rightPointer){
            int middlePointer = (leftPointer+rightPointer) / 2;

            sort(inputArray,leftPointer,middlePointer);
            sort(inputArray,middlePointer + 1,rightPointer);

            merge(inputArray,leftPointer,middlePointer,rightPointer);
        }

    }

}
