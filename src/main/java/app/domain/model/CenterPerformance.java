package app.domain.model;

import java.util.ArrayList;

public class CenterPerformance {

    public ArrayList<Integer> sublist = new ArrayList<>();

    public CenterPerformance (ArrayList sublist){
       this.sublist = sublist;
    }

    public ArrayList<Integer> getSublist() {
        return sublist;
    }

    public String toString(){
        return sublist.toString();
    }


}
