package headlineBrowser;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        StringBuilder headers = new StringBuilder();
        Connection connect = Jsoup.connect("https://spidersweb.pl/autoblog/");
        try {
            Document document = connect.get();
            Elements links = document.select("h2.entry-title");
            for (Element elem : links) {
                System.out.println(elem.text());
                if (elem.toString().length() > 2) headers.append(elem.text());

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("prawdopodobnie brak dostępu do url");
        }

        String[] headersArr = headers.toString().replaceAll("\\?", "").replaceAll("!", "").split(" ");
        System.out.println(Arrays.toString(headersArr));

        try {
            FileWriter fileWriter = new FileWriter("popular_words.txt", true);
            for (String headerWord : headersArr) {
                if (headerWord.length() > 2) fileWriter.append(headerWord + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("błąd zapisu do pliku");
        }

        String[] excluded = {"gdyż", "ponieważ", "oraz", "więc", "jak", "ale"};

        File file = new File("popular_words.txt");
        StringBuilder reading = new StringBuilder();
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                reading.append(scan.nextLine() + "\n");                    // tworzy z przeczytanego pliku nowy tekst dla wszystkich słów, które nie zawieraja się w tablicy excluded
            }
        } catch (FileNotFoundException e) {
            System.out.println("nie mozna czytac z pliku");
        }

        String read1 = reading.toString();
        String read[] = read1.split("\n");
        for(int i = 0; i < read.length ;i++){
            for(int j = 0; j < excluded.length ; j++){
                if(read[i].equals(excluded[j])) read[i] = "";
            }

        }

        System.out.println(Arrays.toString(read));
        try {
            FileWriter fileWriter1 = new FileWriter("filtered_popular_words.txt", true);
            for (String readWord : read) {
                if(readWord != "")fileWriter1.append(readWord + "\n");
            }
            fileWriter1.close();
        } catch (IOException e) {
            System.out.println("błąd zapisu do pliku");

        }


    }

}
