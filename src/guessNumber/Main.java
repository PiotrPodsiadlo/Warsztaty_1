package guessNumber;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        guess();
    }

    static boolean guess() {

        Random r = new Random();
        int randNum = r.nextInt(100);

        Scanner scan = new Scanner(System.in);
        System.out.println("podaj swój typ");
        int type = 0;
        while (true) {
            while (!scan.hasNextInt()) {
                System.out.println("podaj liczbę");
                scan.next();
            }
            type = scan.nextInt();

            if (type > randNum) System.out.println("podałes za dużo");
            else if (type < randNum) System.out.println("podałes za malo");
            else {
                System.out.println("podałes dobrze");
                break;
            }


        }
        return true;
    }
}

