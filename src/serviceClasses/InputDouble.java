package serviceClasses;

//import org.apache.commons.lang3.ArrayUtils;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class InputDouble {

    public static double doubleFromConsole(String prompt){

        Scanner scan = new Scanner(System.in);      // tworzy obiekty typu Scanner

        System.out.println(prompt);


        while(!scan.hasNextDouble()){


            try {
                scan.nextDouble();

            } catch (InputMismatchException e) {
                System.out.println("uzyłes zlego formatu, podaj jeszcze raz " + prompt);;
                scan.useLocale(Locale.US);
                scan.next();
            } catch (Exception e1) {

            }
        }
        Double amount = scan.nextDouble();

    return amount;
    }
}
