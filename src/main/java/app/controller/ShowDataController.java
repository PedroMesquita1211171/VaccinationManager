package app.controller;

import app.controller.App;
import app.domain.model.US16.Registo;
import app.domain.model.US16.RegistoDTO;
import app.domain.model.US16.RegistoMapper;
import app.comparators.ArrivalHourAscending;
import app.comparators.ArrivalHourDescending;
import app.comparators.LeavingHourAscending;
import app.comparators.LeavingHourDescending;
import app.ui.console.utils.BubbleSort;
import app.ui.console.utils.QuickSort;


import java.util.Comparator;
import java.util.List;

public class ShowDataController {
    private List<Registo> registos;

    BubbleSort<Registo> bubbleSort;
    QuickSort<Registo> quickSort;

    public ShowDataController() {
        this.bubbleSort = new BubbleSort<>();
        this.quickSort = new QuickSort<>();
    }

    public List<Registo> bubbleSortRegistos(Comparator<Registo> comparator){
        return bubbleSort.bubbleSort(registos, comparator);
    }

    public List<Registo> quickSortRegistos(Comparator<Registo> comparator){
        return quickSort.quickSort(registos, comparator);
    }

    public List<RegistoDTO> processResult(int algorithm, int order){
        this.registos = App.getInstance().getCompany().getCenterData().getRegistos();
        Comparator<Registo> comparator = Comparator.comparing(Registo::getSnsUserNumber);

        switch(order){
            case 1:
                comparator = new ArrivalHourAscending();
                break;
            case 2:
                comparator = new LeavingHourAscending();
                break;
            case 3:
                comparator = new ArrivalHourDescending();
                break;
            case 4:
                comparator = new LeavingHourDescending();
                break;
        }

        switch (algorithm){
            case 1:
                return RegistoMapper.mapToDTO(bubbleSortRegistos(comparator));
            case 2:
                return RegistoMapper.mapToDTO(quickSortRegistos(comparator));
        }

        return List.of();
    }
}
