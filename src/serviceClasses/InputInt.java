package serviceClasses;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class InputInt {


    public static int intFromConsole(String prompt){

            Scanner scan = new Scanner(System.in);      // tworzy obiekty typu Scanner

            System.out.println(prompt);                 // wyswietla tekst zachęty


            while(!scan.hasNextInt()){               // jesli w obiekcie Scan nie ma kolejnego Integera przechodzi do pętli


                try {
                    scan.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println("uzyłes zlego formatu, podaj jeszcze raz " + prompt);;
                    scan.next();
                } catch (Exception e1) {

                }
            }
            int amount = scan.nextInt();

            return amount;
        }
    }



