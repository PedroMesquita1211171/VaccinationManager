package app.comparators;

import app.domain.model.US16.Registo;

import java.util.Comparator;

public class LeavingHourAscending implements Comparator<Registo> {
    @Override
    public int compare(Registo o1, Registo o2) {
        return o1.getLeavingDateTime().compareTo(o2.getLeavingDateTime());
    }
}
