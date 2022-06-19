package app.ui.console.utils;

import app.domain.model.LegacyData;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * The type Quick sort.
 */
public class QuickSort {
    private int[] numbers;
    private int number;

    /**
     * Sort.
     *
     * @param arr the arr
     * @param a   the a
     */
    public List<LegacyData> sort(List<LegacyData> arr, int a) {
        // check for empty or null array
        if (arr ==null || arr.size()==0){
            System.out.println("Array empty");
        }

        number = arr.size();
        quicksort(0, number-1, arr, a);
        return arr;
    }

    private List<LegacyData> quicksort(int low, int high, List<LegacyData> arr, int a) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        if (a==1){int pivot =  arr.get(low + (high-low)/2).getArrivalDateTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getArrivalDateTime().get(Calendar.MINUTE);
            while (i <= j) {
                // If the current value from the left list is smaller than the pivot
                // element then get the next element from the left list
                while (arr.get(i).getArrivalDateTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getArrivalDateTime().get(Calendar.MINUTE) < pivot) {
                    i++;
                }
                // If the current value from the right list is larger than the pivot
                // element then get the next element from the right list
                while (arr.get(j).getArrivalDateTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getArrivalDateTime().get(Calendar.MINUTE) > pivot) {
                    j--;
                }

                // If we have found a value in the left list which is larger than
                // the pivot element and if we have found a value in the right list
                // which is smaller than the pivot element then we exchange the
                // values.
                // As we are done we can increase i and j
                if (i <= j) {
                    exchange(arr,i, j);
                    i++;
                    j--;
                }
            }
            // Recursion
            if (low < j)
                quicksort(low, j,arr,a);
            if (i < high)
                quicksort(i, high,arr,a);
        } else {int pivot =  arr.get(low + (high-low)/2).getLeavingTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getLeavingTime().get(Calendar.MINUTE);
            while (i <= j) {
                // If the current value from the left list is smaller than the pivot
                // element then get the next element from the left list
                while (arr.get(i).getLeavingTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getLeavingTime().get(Calendar.MINUTE) < pivot) {
                    i++;
                }
                // If the current value from the right list is larger than the pivot
                // element then get the next element from the right list
                while (arr.get(j).getLeavingTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getLeavingTime().get(Calendar.MINUTE) > pivot) {
                    j--;
                }

                // If we have found a value in the left list which is larger than
                // the pivot element and if we have found a value in the right list
                // which is smaller than the pivot element then we exchange the
                // values.
                // As we are done we can increase i and j
                if (i <= j) {
                    exchange(arr,i, j);
                    i++;
                    j--;
                }
            }
            // Recursion
            if (low < j)
                quicksort(low, j,arr,a);
            if (i < high)
                quicksort(i, high,arr,a);

        }
        return arr;
    }

    private void exchange(List<LegacyData> arr,int i, int j) {
        Collections.swap(arr, i, j);
    }


}
