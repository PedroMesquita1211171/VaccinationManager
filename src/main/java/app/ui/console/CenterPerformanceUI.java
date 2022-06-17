package app.ui.console;


import app.controller.CenterPerformanceController;
import app.ui.console.utils.Utils;
import app.ui.console.utils.CSVToMatrix;


import java.util.ArrayList;
import java.util.Scanner;

public class CenterPerformanceUI {

    private CenterPerformanceController ctrl;
//utilizador tem de especificar o caminho para o file a ser utilizado, este é lido como stirng entra como parametro no CSVReader



    public void run() {
        Scanner sc = new Scanner(System.in);
        CSVToMatrix converter = new CSVToMatrix();
            String filename = ctrl.getFileName(Utils.readLineFromConsole("Insert the file you want to analyze:"));
            int m;
            System.out.println("Select the duration of time intervals to analyze:");
            m= sc.nextInt();
            boolean validateM = converter.validateInterval(m);
            while(!validateM){
                System.out.println("Please select a valid time interval:");
                m= sc.nextInt();
                validateM = converter.validateInterval(m);
            }
            ArrayList<Integer> performanceList = converter.readInfoFromCSV(filename, m);
            System.out.println(" Os resultados para intervalos de tempo de "+m+" minutos, usando o ficheiro csv são:");
            System.out.println("[");
            for (int i=0; i<=performanceList.size(); i++){
                    if (i< performanceList.size()-1) {
                        System.out.print(performanceList.get(i)+",");
                    }else  System.out.print(performanceList.get(i));
            }
            System.out.print("]");
            System.out.println("");
            System.out.println("A sublista contígua de soma máxima é:");
            for (int i=0; i<=ctrl.maxsumsublist(performanceList).size(); i++){
                if (i< ctrl.maxsumsublist(performanceList).size()-1) {
                        System.out.print(ctrl.maxsumsublist(performanceList).get(i)+",");
                }else  System.out.print(ctrl.maxsumsublist(performanceList).get(i));
            }
            System.out.println("");
            System.out.println("A soma dos elementos da sublista contígua de soma máxima é:");
            System.out.println(ctrl.maxsum(performanceList));
            System.out.println("");
            System.out.println("O intervalo de tempo correspondente á sublista contígua de soma máxima é:");
            System.out.println("["+intervalStart(ctrl.maxsumsublist(performanceList))+","+intervalEnd(ctrl.maxsumsublist(performanceList)));
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
}
