package app.comparators;

import app.domain.model.US16.Registo;

import java.util.Comparator;

public class ArrivalHourDescending implements Comparator<Registo> {
    @Override
    public int compare(Registo o1, Registo o2) {
        return o2.getArrivalDateTime().compareTo(o1.getArrivalDateTime());
    }
}
