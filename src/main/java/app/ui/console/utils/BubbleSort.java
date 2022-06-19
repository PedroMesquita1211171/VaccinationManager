package app.ui.console.utils;

import app.domain.model.LegacyData;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * The type Bubble sort.
 */
public class BubbleSort {
    /**
     * Bubble sort.
     *
     * @param arr the arr
     * @param a   the a
     * @return
     */
    public List<LegacyData> bubbleSort(List<LegacyData> arr, int a) {
            int n = arr.size();
            LegacyData temp;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if(a==1){
                        int time1 = arr.get(i).getArrivalDateTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getArrivalDateTime().get(Calendar.MINUTE);
                        int time2 =arr.get(j).getArrivalDateTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(j).getArrivalDateTime().get(Calendar.MINUTE);
                        if (time1 < time2) {
                            //swap elements
                            Collections.swap(arr, i, j);
                        }
                    }else{
                        int time1 = arr.get(i).getLeavingTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(i).getLeavingTime().get(Calendar.MINUTE);
                        int time2 = arr.get(j).getLeavingTime().get(Calendar.HOUR_OF_DAY)*60+arr.get(j).getLeavingTime().get(Calendar.MINUTE);
                        if (time1 < time2) {
                            //swap elements
                            Collections.swap(arr, i, j);
                        }
                    }

                }
            }return arr;
        }
    }
