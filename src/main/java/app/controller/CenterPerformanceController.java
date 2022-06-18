package app.controller;


import app.ui.console.utils.CSVConverter;

import java.util.ArrayList;

public class CenterPerformanceController { ;
    private CSVConverter converter;

    public CenterPerformanceController(){
        converter = new CSVConverter();
    }




    //MDISC
    public ArrayList<Integer> maxsumsublist (ArrayList<Integer>  sublist) {
        ArrayList<Integer> maxsumsublist = new ArrayList<>();
        int somamax = 0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                }
            }

        }

        return maxsumsublist;
    }


    public int maxsum (ArrayList<Integer>  sublist) {
        int somamax = 0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                }
            }

        }

        return somamax;
    }

    public int intervalStart (ArrayList<Integer>  sublist) {
        int somamax = 0;
        int imax = 0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                    imax = i;
                }
            }

        }

        return imax;
    }
    public int intervalEnd (ArrayList<Integer>  sublist) {
        int somamax = 0;
        int jmax = 0;
        for (int i = 0; i < ((sublist.size()) - 1); i++) {
            int soma = 0;
            for (int j = i; j < ((sublist.size()) - 1); j++) {
                soma = soma + sublist.get(j);
                if (somamax < soma) {
                    somamax = soma;
                    jmax = j;
                }
            }

        }

        return jmax;
    }




    public ArrayList<Integer> readInfoFromCSV(String file, int m){
        return converter.readInfoFromCSV(file,m);
    }
}
