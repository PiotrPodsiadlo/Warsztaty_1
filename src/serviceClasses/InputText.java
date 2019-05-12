package serviceClasses;

import java.util.Scanner;

public class InputText {



public static String textFromconsole(String prompt) {

    Scanner scan = new Scanner(System.in);
    System.out.println(prompt);
    String name = scan.nextLine();

    while(name.trim().length()==0 ){

        System.out.println("brak wartości, wprowadź ponownie");
        name = scan.nextLine();
    }

    return name;
    }
}