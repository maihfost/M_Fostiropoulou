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
 * @author maih_sofi
 */
public class BubbleSortAttributes {

    public void bubbleSortSize(List<RandomTshirt> arr, boolean isASC) {
        int n = arr.size();
        if (isASC) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getSize().ordinal() > arr.get(j + 1).getSize().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getSize().ordinal() < arr.get(j + 1).getSize().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        }
    }
    
    public void bubbleSortColor(List<RandomTshirt> arr, boolean isASC) {
        int n = arr.size();
        if (isASC) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getColor().ordinal() > arr.get(j + 1).getColor().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getColor().ordinal() < arr.get(j + 1).getColor().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        }
    }
    public void bubbleSortFabric(List<RandomTshirt> arr, boolean isASC) {
        int n = arr.size();
        if (isASC) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getFabric().ordinal() > arr.get(j + 1).getFabric().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {

                    if (arr.get(j).getFabric().ordinal() < arr.get(j + 1).getFabric().ordinal()) {
                        // swap arr[j+1] and arr[j] 
                        RandomTshirt temp = arr.get(j);
                        arr.set(j, arr.get(j + 1));
                        arr.set(j + 1, temp);
                    }
                }
            }
        }
    }
}
