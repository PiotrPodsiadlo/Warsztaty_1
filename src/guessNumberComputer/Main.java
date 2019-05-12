package guessNumberComputer;

public class Main {

    public static void main(String[] args){

        System.out.println("pomyśl liczbę od 0 do 1000 a ja zgadne ją w max 10 próbach");

        int min = 0; int max = 1000;
        String prompt = "napisz za dużo , za mało , lub wygrałeś w zależności czy podałem za dużo, za malo, czy wygrałem";

       while(true) {

           int guess = ((max-min)/2) + min;

           System.out.println("zgaduję " + guess);

            String answer = "";
           answer =  serviceClasses.InputText.textFromconsole(prompt);
           if (answer.equals("wygrałeś")) {
               System.out.println("wygrałem");
               break;
           } else if(answer.equals("za dużo")) {
               System.out.println("ok, podałem za dużo");
               max = guess;
           }
           else if (answer.equals("za mało")) {
               System.out.println("ok, podałem za mało");
               min = guess;
           }
           else {
               System.out.println("nie oszukuj");
           }

       }



    }
}
