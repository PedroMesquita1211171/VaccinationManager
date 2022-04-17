package app.Converters;

import java.util.Scanner;

public class Converter {

    public static int[] toIntArray(String s){
        String[] str = s.split("");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        return arr;
    }

    public static int readInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String readWord(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int readInt(String message){
        System.out.println(message);
        return readInt();
    }

    public static String readWord(String message){
        System.out.println(message);
        return readWord();
    }

    public static String readLine(String message){
        System.out.println(message);
        return readLine();
    }
}