/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.util.ArrayList;
import java.util.List;
import models.RandomTshirt;

/**
 *
 * @author maihf
 */
public class BucketSortAttributes {

    public RandomTshirt[] sort(List<RandomTshirt> arr, RandomTshirt maxTshirt, boolean isAsc, int attribute) {
        int max_value;
        List<List<RandomTshirt>> Bucket = new ArrayList<List<RandomTshirt>>(); //[max_value + 1]; //[max_value + 1];
        RandomTshirt[] sorted_nums = new RandomTshirt[arr.size()];
        switch (attribute) {
            case 0:
                max_value = maxTshirt.getSize().ordinal();
                for (int i = 0; i < (max_value + 1); i++) {
                    Bucket.add(new ArrayList<RandomTshirt>());//Dimiourgw max_value + 1 buckets
                }
                for (int i = 0; i < arr.size(); i++) {
                    Bucket.get(arr.get(i).getSize().ordinal()).add(arr.get(i));//Bucket[arr[i]]++;
                }
                break;
            case 1:
                max_value = maxTshirt.getColor().ordinal();
                for (int i = 0; i < (max_value + 1); i++) {
                    Bucket.add(new ArrayList<RandomTshirt>());//Dimiourgw max_value + 1 buckets
                }
                for (int i = 0; i < arr.size(); i++) {
                    Bucket.get(arr.get(i).getColor().ordinal()).add(arr.get(i));//Bucket[arr[i]]++;
                }
                break;
            default:
                max_value = maxTshirt.getFabric().ordinal();
                for (int i = 0; i < (max_value + 1); i++) {
                    Bucket.add(new ArrayList<RandomTshirt>());//Dimiourgw max_value + 1 buckets
                }
                for (int i = 0; i < arr.size(); i++) {
                    Bucket.get(arr.get(i).getFabric().ordinal()).add(arr.get(i));//Bucket[arr[i]]++;
                }
                break;
        }
        int outPos;
        if (isAsc) {
            outPos = 0;
            for (int i = 0; i < Bucket.size(); i++) {
                for (int j = 0; j < Bucket.get(i).size(); j++) {
                    sorted_nums[outPos] = Bucket.get(i).get(j);
                    outPos++;
                }
            }
        } else {
            outPos = sorted_nums.length - 1;
            System.out.println(outPos);
            for (int i = 0; i < Bucket.size(); i++) {
                for (int j = 0; j < Bucket.get(i).size(); j++) {
                    sorted_nums[outPos] = Bucket.get(i).get(j);
                    outPos--;
                }
            }
        }

        return sorted_nums;
    }

    public RandomTshirt max_value(List<RandomTshirt> arr, int attribute) {
        int max_value = 0;
        RandomTshirt maxTshirt = null;
        switch (attribute) {
            case 0:
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getSize().ordinal() > max_value) {
                        max_value = arr.get(i).getSize().ordinal();
                        maxTshirt = arr.get(i);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getColor().ordinal() > max_value) {
                        max_value = arr.get(i).getSize().ordinal();
                        maxTshirt = arr.get(i);
                    }
                }
                break;
            default:
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i).getFabric().ordinal() > max_value) {
                        max_value = arr.get(i).getSize().ordinal();
                        maxTshirt = arr.get(i);
                    }
                }
                break;
        }
        return (maxTshirt);
    }
}
