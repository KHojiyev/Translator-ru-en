package module3.lesson9_API.tesk2_Translate;

import com.google.gson.Gson;
import module3.lesson9_API.tesk2_Translate.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TranslateEn_Ru {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==Welcome==");
        boolean exitCommand = false;
        while (!exitCommand) {
            System.out.println("1.Eng=>Ru  2.Ru=>Eng x.Exit");
            System.out.print("_");
            scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter word: ");
                    String searchWord = scanner.nextLine();
                    translateMachine(searchWord, "en-ru");
                    break;
                case "2":
                    System.out.print("Напишите слово: ");
                    String слово = scanner.nextLine();
                    translateMachine(слово, "ru-en");
                    break;
                case "x":
                    System.out.println("==bye==");
                    exitCommand= true;

            }
        }
    }

    private static void translateMachine(String searchWord, String language) {
        Gson gson = new Gson();
        try {
            URL url = new URL("https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=dict.1.1.20210406T070427Z.68976b0a134098e6.c44e58158ee48474d0d56bace9f632c0e026d591&lang=" + language + "&text=" + searchWord);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            Translate translate = gson.fromJson(bufferedReader, Translate.class);

            for (Def def : translate.getDef()) {
                for (Tr tr : def.tr) {
                    System.out.println("(" + def.pos + ")" + " // " + tr.getText());
                    if (tr.getMean() != null) {
                        for (Mean mean : tr.getMean()) {
                            System.out.println("   Mean: " + mean.getText());
                        }
                    }
                    if (tr.getEx() != null) {
                        for (Ex ex : tr.getEx()) {
                            System.out.print("   Examples: " + ex.text);
                            if (ex.getTr() != null) {
                                for (Tr tr1 : ex.getTr()) {
                                    System.out.println("    -" + tr1.getText());
                                }
                            }
                        }
                    }
                    if (tr.getSyn() != null && tr.getSyn().length > 0) {
                        for (Syn syn : tr.getSyn()) {
                            System.out.println("   Syn: (" + syn.getPos() + ") " + syn.getText());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
