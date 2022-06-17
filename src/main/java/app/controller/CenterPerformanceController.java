package app.controller;


import app.domain.model.CenterPerformance;

import java.util.ArrayList;

public class CenterPerformanceController {
    private CenterPerformance cp;

    public CenterPerformanceController(){}

    public CenterPerformanceController(CenterPerformance cp){}


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

    //calcular max sum sublist
    public ArrayList<Integer> contiguousSublistOfMaxSum (ArrayList<Integer>  sublist, int imax, int jmax) {
        ArrayList<Integer> contiguousSublistOfMaxSum = new ArrayList<>();
        for (int a=imax; a<=jmax; a++){
            for (int n=0; n<=a; n++) {
                contiguousSublistOfMaxSum.set(n,sublist.get(a));
            }
        }
        return contiguousSublistOfMaxSum;
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



    public String getFileName(String file){
        return file;
    }
}
