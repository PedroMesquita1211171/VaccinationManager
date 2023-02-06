package app.comparators;

import app.domain.model.US16.Registo;

import java.util.Comparator;

public class LeavingHourDescending implements Comparator<Registo> {
    @Override
    public int compare(Registo o1, Registo o2) {
        return o2.getLeavingDateTime().compareTo(o1.getLeavingDateTime());
    }
}
