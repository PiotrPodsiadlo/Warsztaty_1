package dice;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args){


        String str = ("podaj opis rzutu zgodnie z instrukcją w cwiczeniu");
        int i = 0;
        String desc ="";

        do {
            desc = serviceClasses.InputText.textFromconsole(str);                                       // wywołuje juz zapisana metodę do pobierania tekstu

            if (desc.matches("([0-9]*)?(D){1,1}(4|6|8|10|12|20|100)((\\+|-)([0-9]*))?")) {          // sprawdza tekst z regexem pod katem, czy w ogóle jest sens się nim zajmować
                System.out.println("okej");
                i++;
            }
            else System.out.println("podałeś niezgodnie z wzorem, podaj jeszcze roz");
        }while (i == 0);

        String throwCount = "";                                                                         // wyciągnięta z podanego stringu ilosc rzutów
        String dicetype = "";                                                                           // wyciągnięty z podanego stringa typ kostki
        String additionalPoints = "";                                                                   // wyciągnięta liczba punktów dodatkowych
        int dPosition = 0;                                                                              // zapisuje na jakiej pozycji znajduje sie D
        int signPosition = 0;                                                                           // zapisuje na jakiej pozycji znajduje się plus lub minus
        boolean addOrSubtract = false;                                                                  // jesli false to nie wykonujemy operacji odejmowania lub dodawania
        char operation = ' ';                                                                           // mówi jaką operacje wykonujemy

        for(int j = 0; j<desc.length() ;j++){

            if(desc.charAt(j) == 'D'){                                                                  // sprawdza na której pozycji znajduje się D i wycina znaki przed nim do nowej zmiennej przechowującej liczbe rzutów
                throwCount = desc.substring(0,j);
                dPosition = j;
           //     System.out.println(throwCount);
            }
            if(desc.charAt(j) == '+' || desc.charAt(j) == '-') {                                         // wycina znaki miedzy D a +/- do zmiennej przechowujacej typ kostki
                dicetype = desc.substring(dPosition + 1, j);
            //    System.out.println(dicetype);
                signPosition = j;
                addOrSubtract = true;                                                            // sprawdza czy dodajemy lub odejmujemy punkty
                operation = desc.charAt(j);                                                         // JESLI TAK, JAKA KONKRETNIE OPERACJE WYKONUJMY
            }
            if(j+1 == desc.length() && addOrSubtract == true) {
                additionalPoints = desc.substring(signPosition+1,j+1);                         // zwraca ilośc punktów dodatkowych
              //  System.out.println(additionalPoints);
            }
            else if(j+1 == desc.length()){                                                      //  jesli nie dodajemy punktów dodatkowych to zwraca tylko typ kostki
                dicetype = desc.substring(dPosition + 1, j+1);
            //    System.out.println(dicetype);
            }
        }

        int realThrowcount = 0;
        if(throwCount.equals("")) realThrowcount =1;
        else realThrowcount = Integer.parseInt(throwCount);
        System.out.println(realThrowcount);

        int realDiceType = Integer.parseInt(dicetype);
        System.out.println(realDiceType);

        int realAdditionalPoints = 0;
        if(!additionalPoints.equals("")) realAdditionalPoints = Integer.parseInt(additionalPoints);
        if(operation == '-') realAdditionalPoints = 0 - realAdditionalPoints;                               // dodaje lub odejmuje punkty w zależności od operacji
        System.out.println(realAdditionalPoints);


        /** symulacja rzutu kostką */

        Random r = new Random();
        int numFromDice = r.nextInt(realDiceType)+1;
        System.out.println(numFromDice);
        int result = realThrowcount*numFromDice+realAdditionalPoints;
        System.out.println(result);



    }


}











// chyba najlepszy regex jaki wymysliłem dla kostki: ([0-9]*)?(D){1,1}(4|6|8|10|12|20|100)((\+|-)([0-9]*))?





/*        String[] descArr = desc.split("");
        System.out.println(Arrays.toString(descArr));
        int throwings = 1;                                                                              // zmienna do okreslania ilosci rzutów kostką
        int diceSize = 0;                                                                               // okresla rozmiar kostki
        String charOfOperation ="";                                                                     // sprawdza, czy w opisie jest plus, czy minus
        int k = 0;                                                                                      // k to licznik, jeśli podskoczy to znaczy, że wyszedłem juz np. poza sprawdzanie liczby rzutów
        int j = 0;                                                                                      // element tablicy powstałej z wprowadzonych danych

        while(k==0){
            try {
                throwings = Integer.parseInt(descArr[j]);                                           // sprawdza czy element tablicy odnosi się do liczby rzutów oczywiście rzutów może być więcej niż 10, dlatego trzeba dla liczby rzuów  coś pokombinować
                System.out.println(throwings);
            } catch (NumberFormatException e) {
                System.out.println(descArr[j]);
                k++;
            }
            j++;
        }*/


