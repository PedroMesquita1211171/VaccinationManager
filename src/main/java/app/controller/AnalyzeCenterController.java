package app.controller;

import app.controller.App;
import app.domain.model.US16.CenterData;
import app.domain.model.US16.Registo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AnalyzeCenterController {

    CenterData centerData;
    private final LocalTime start = LocalTime.of(8, 0);
    private final LocalTime end = LocalTime.of(20, 0);

    public AnalyzeCenterController() {
        this.centerData = App.getInstance().getCompany().getCenterData();
    }

    public int[] result(int timeInterval, LocalDate date){
        int[] list = getList(timeInterval, date);
        return maxSumSubcontiguousList(list);
    }

    public int[] getList(int timeInterval, LocalDate date){
        if(timeInterval < 1 || timeInterval > 60)
            throw new IllegalArgumentException("Invalid time interval.\nTry again.");

        if(date.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("Invalid date.\nTry again.");

        if(centerData.getRegistos().isEmpty())
            throw new IllegalArgumentException("There are no registers.\nTry again.");

        int size = 720 / timeInterval;
        int[] list = new int[size];

        int i = 0;
        for (Registo registo : centerData.getRegistos()) {
            if(registo.getArrivalDateTime().toLocalDate().equals(date)
                    && registo.getArrivalDateTime().toLocalTime().isAfter(start)
                    && registo.getArrivalDateTime().toLocalTime().isBefore(end)){


                int index = getTimeInterval(registo.getArrivalDateTime().toLocalTime(), timeInterval, i);
                list[index] ++;// se a pessoa chegar em tal intervalo de tempo, incrementa o numero de pessoas nesse intervalo
            }

            if(registo.getLeavingDateTime().toLocalDate().equals(date)
                    && registo.getLeavingDateTime().toLocalTime().isAfter(start)
                    && registo.getLeavingDateTime().toLocalTime().isBefore(end)) {

                int index = getTimeInterval(registo.getLeavingDateTime().toLocalTime(), timeInterval, i);
                list[index]--; // se a pessoa sair em tal intervalo de tempo, decrementa o numero de pessoas nesse intervalo
            }
        }
        return list;
    }

    private int getTimeInterval(LocalTime arrivalDateTime, int timeInterval, int i) {
        int index = 0;
        for (LocalTime time = LocalTime.of(start.getHour(), start.getMinute()); time.isBefore(end); time = time.plusMinutes(timeInterval)) {
            if (arrivalDateTime.isAfter(time) && arrivalDateTime.isBefore(time.plusMinutes(timeInterval))) {
                index = i;
            }
            i++;
        }
        return index;
    }

    private int[] maxSumSubcontiguousList(int[] list){
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0, start = 0, end = 0, s = 0;

        for (int i = 0; i < list.length; i++) {
            max_ending_here += list[i];

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }

        int[] result = new int[end - start + 1];

        for(int i = 0; i < result.length; i++){
            result[i] = list[start + i];
        }

        return result;
    }
}
