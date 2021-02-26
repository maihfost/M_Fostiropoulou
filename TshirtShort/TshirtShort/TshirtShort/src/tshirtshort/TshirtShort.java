package tshirtshort;

import Sorting.BubbleSort;
import Sorting.BubbleSortAttributes;
import Sorting.BucketSort;
import Sorting.BucketSortAttributes;
import Sorting.QuickSort;
import Sorting.QuickSortAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import models.RandomTshirt;

/**
 *
 * @author maihf
 */
public class TshirtShort {

    public static void main(String[] args) {
        /*
        int[] myArray = {1,22,2,9,97};
        
        //QuickSort
        int[] qsArray =Arrays.copyOf(myArray, myArray.length);
        QuickSort qs = new QuickSort();
        doIntQuickSort(qs,qsArray,0,myArray.length-1);
        
        //BubbleSort
        int[] bsArray =Arrays.copyOf(myArray, myArray.length); // allios myArray.clone();
        BubbleSort bs = new BubbleSort();
        doIntBubbleSort(bs, bsArray);
        
        //Bucket Sort
        int[] busArray = myArray.clone();
        BucketSort bus = new BucketSort();
        doIntBucketSort(bus, busArray);
         */

        //Produce Random Tshirts
        List<RandomTshirt> randomTshirts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            randomTshirts.add(new RandomTshirt());
        }
        System.out.println("------------------------------------------");

        /*Sort by Size,COlor,Fabric
            Size -- 0
            Color -- 1
            Fabric -- 2
         */
                          
        //QUICKSORT
        List<RandomTshirt> QS_rTshirtSize = new ArrayList<>(randomTshirts);
        QuickSortAttributes qsAt = new QuickSortAttributes();
        //Size in ascending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, true, 0);
        //Color in ascending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, true, 1);
        //Fabric in ascending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, true, 2);
        //Size in descending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, false, 0);
        //Color in descending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, false, 1);
        //Fabric in descending [10 marks]
        doListQuickSort(qsAt,QS_rTshirtSize, 0, QS_rTshirtSize.size()-1, false, 2);
        
        
        
        //BUBBLESORT
        List<RandomTshirt> BS_rTshirtSize = new ArrayList<>(randomTshirts);
        BubbleSortAttributes bsAt = new BubbleSortAttributes();
        //Size in ascending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, true, 0);
        //Color in ascending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, true, 1);
        //Fabric in ascending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, true, 2);
        //Size in descending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, false, 0);
        //Color in descending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, false, 1);
        //Fabric in descending [10 marks]
        doListBubbleSort(bsAt, BS_rTshirtSize, false, 2);
         
 
        //BUCKETSORT
        List<RandomTshirt> BUS_rTshirtSize = new ArrayList<>(randomTshirts);
        BucketSortAttributes busAt = new BucketSortAttributes();
        //Size in ascending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, true, 0);
        //Color in ascending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, true, 1);
        //Fabric in ascending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, true, 2);
        //Size in descending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, false, 0);
        //Color in descending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, false, 1);
        //Fabric in descending [10 marks]
        doListBucketSort(busAt, BUS_rTshirtSize, false, 2);
        
        
        
    }

    static void doListQuickSort(QuickSortAttributes qsAt, List<RandomTshirt> arrayList, int low, int high, boolean isASC, int attribute) {
        System.out.println("----------------QSAttributes---------------------");
        for (RandomTshirt randomTshirt : arrayList) {
            System.out.println(randomTshirt);
        }

        System.out.println("-------------------------------------");
        qsAt.sort(arrayList, low, high, isASC, attribute);
        for (RandomTshirt randomTshirt : arrayList) {
            System.out.println(randomTshirt);
        }
    }

    static void doListBubbleSort(BubbleSortAttributes bsAt, List<RandomTshirt> arrayList, boolean isASC, int attribute) {
        System.out.println("----------------BSAttributes---------------------");
        arrayList.forEach(randomTshirt -> {
            System.out.println(randomTshirt);
        });

        System.out.println("-------------------------------------");
        switch (attribute) {
            case 0:
                bsAt.bubbleSortSize(arrayList, isASC);
                break;
            case 1:
                bsAt.bubbleSortColor(arrayList, isASC);
                break;
            default:
                bsAt.bubbleSortFabric(arrayList, isASC);
                break;
        }
        arrayList.forEach(randomTshirt -> {
            System.out.println(randomTshirt);
        });
    }

    static void doListBucketSort(BucketSortAttributes busAt, List<RandomTshirt> arrayList, boolean isAsc, int attribute){
        System.out.println("----------------BUSAttributes---------------------");
        arrayList.forEach(randomTshirt -> {
            System.out.println(randomTshirt);
        });
        
        System.out.println("-------------------------------------");
        RandomTshirt[] sorted_Tshirts = busAt.sort(arrayList, busAt.max_value(arrayList, attribute), isAsc, attribute);
        for (RandomTshirt randomTshirt : sorted_Tshirts) {
            System.out.println(randomTshirt);
        }
    }
    
    static void doIntQuickSort(QuickSort qs, int[] myArray, int low, int high) {
        System.out.println("----------------QS---------------------");
        System.out.println(Arrays.toString(myArray));

        System.out.println("-------------------------------------");
        qs.sort(myArray, low, high);
        System.out.println(Arrays.toString(myArray));
    }

    static void doIntBubbleSort(BubbleSort bs, int[] myArray) {
        System.out.println("----------------BS---------------------");
        System.out.println(Arrays.toString(myArray));

        System.out.println("-------------------------------------");
        bs.bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    static void doIntBucketSort(BucketSort bus, int[] myArray) {
        System.out.println("----------------BUS---------------------");
        System.out.println(Arrays.toString(myArray));

        System.out.println("-------------------------------------");
        int[] busArray = bus.sort(myArray, bus.max_value(myArray));
        System.out.println(Arrays.toString(busArray));
    }

}
