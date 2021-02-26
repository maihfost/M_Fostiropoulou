/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.List;
import models.RandomTshirt;

/**
 *
 * @author maihf
 */
public class QuickSortAttributes {

    int partition(List<RandomTshirt> arr, int low, int high, boolean isASC, int attribute) {
        RandomTshirt pivot = arr.get(high);
        int i = (low - 1); // index of smaller element

        if (isASC) {
            switch (attribute) {
                case 0:
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (arr.get(j).getSize().ordinal() < pivot.getSize().ordinal()) {
                            i++;
                            
                            // swap arr[i] and arr[j] 
                            RandomTshirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                case 1:
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (arr.get(j).getColor().ordinal() < pivot.getColor().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTshirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
                case 2:
                    for (int j = low; j < high; j++) {
                        // If current element is smaller than the pivot 
                        if (arr.get(j).getFabric().ordinal() < pivot.getFabric().ordinal()) {
                            i++;

                            // swap arr[i] and arr[j] 
                            RandomTshirt temp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, temp);
                        }
                    }
                    break;
            }
        } else {
            for (int j = low; j < high; j++) {
                // If current element is smaller than the pivot 
                if (arr.get(j).getSize().ordinal() > pivot.getSize().ordinal()) {
                    i++;

                    // swap arr[i] and arr[j] 
                    RandomTshirt temp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
        // swap arr[i+1] and arr[high] (or pivot) 
        RandomTshirt temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    
    public void sort(List<RandomTshirt> arr, int low, int high, boolean isASC, int attribute) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high, isASC, attribute);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi - 1, isASC, attribute);
            sort(arr, pi + 1, high, isASC, attribute);
        }
    }
}
