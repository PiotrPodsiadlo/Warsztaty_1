package lotto;

import com.sun.deploy.util.ArrayUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int lengthArr = 6;                                  // poczatkowe tworzenie obiektów
        Scanner scan = new Scanner(System.in);

        int[] types = new int[lengthArr];
        String type = "";
        int realtype = 0;

        System.out.println("podaj swój typ, po kolei 6 róznych liczb od 1 do 49");          // linie 22-46 to pobieranie danych od uzytkownika i zapisywanie ich w tablicy
        for (int i = 0; i < types.length; i++) {
            while (true) {                                                                  // wewnętrzna petla przerywa w przypadku podania złych danych
                type = scan.next();
                try {
                    realtype = Integer.parseInt(type);
                    if (realtype < 1 || realtype > 49) {
                        System.out.println("podaj w zakresie 1 do 49");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("podawaj tylko liczby!");
                    continue;
                }

                if (ArrayUtils.contains(types,realtype)) {                                  // sprawdza czy nie ma duplikatów za pomoca ArraysUtils
                    System.out.println("znaleziono duplikat, podaj jeszcze raz");
                    continue;
                }
                types[i] = realtype;                                                        // dopisuje do tablicy

                System.out.println("podaj nastepna");
                break;
            }
        }

        Arrays.sort(types);
        System.out.println(Arrays.toString(types));                                         // sortuje typy uzytkownika

        int[] lottoNums = new int[lengthArr];
        Random r = new Random();

        for(int j = 0; j < lottoNums.length ; j++ ){                                        // tworzy tabele losowych niepowtarzających sie liczb 1-49

            int helper = r.nextInt(49) +1;
            if(ArrayUtils.contains(lottoNums, helper)) j-- ;
            else lottoNums[j] = helper;
        }

        System.out.println(Arrays.toString(lottoNums));

        int counter = 0;
        for (int k = 0; k <lottoNums.length ; k++){
            for(int l = 0; l<lottoNums.length ; l++){
                if(lottoNums[k] == types[l]) {
                    System.out.println("trafienie");
                    counter++;
                }
            }
        }
        if (counter > 2) System.out.println("trafiłes przynajmniej trójkę");


    }

}


