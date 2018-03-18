import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CzytanieListyZpliku {

    static String slowa = "C:/Users/Admin/Desktop/Projekt/BazaDanych/src/slowa.txt";
    static String litery = "C:/Users/Admin/Desktop/Projekt/BazaDanych/src/litery.txt";

    static String[] t1;
    static String[] t2;
    static Map<String, String> mapa = new TreeMap<>();
    static Set<Map.Entry<String,String>> entrySet = mapa.entrySet();

    static Scanner sc=new Scanner(System.in); //do wersji konsolowej

    static String inputValue;  //wersja JOptionPane
    static String inputValue1;


    public static void main(String[] args){

        try {
            czytanieDanychZpliku();
        }catch (IOException e){
            System.out.println("Błąd czytania danych");
            e.printStackTrace();}

        mapa.put("Fajki", "15");
        mapa.put("banan", "200");

        mapa.remove("Banan");
        mapa.put("Brokul", "99");

        wprowadzanieDanych();
        rysowanieMapy();

        System.out.println(mapa.keySet()+" "+mapa.values());

        try {
            zapisDanychDoPliku();
        }catch (IOException e){
            System.out.println("Bład zapisu danych");
            e.printStackTrace();}
    }
    public static void zapisDanychDoPliku() throws IOException{
        FileWriter zapisSlow = new FileWriter(slowa);
        FileWriter zapisLiczb = new FileWriter(litery);
        BufferedWriter slowa = new BufferedWriter(zapisSlow);
        BufferedWriter liczby = new BufferedWriter(zapisLiczb);

        Set<String> klucze = mapa.keySet();
        StringBuilder trescDozapisu = new StringBuilder();
        StringBuilder trescDozapisu1 = new StringBuilder();
        for (String i : klucze) {
            trescDozapisu.append(i + "-");
            trescDozapisu1.append(mapa.get(i) + "-");
        }
        trescDozapisu.deleteCharAt(trescDozapisu.lastIndexOf("-"));
        trescDozapisu1.deleteCharAt(trescDozapisu1.lastIndexOf("-"));

        slowa.write(String.valueOf(trescDozapisu));
        liczby.write(String.valueOf(trescDozapisu1));
        slowa.close();
        liczby.close();

        System.out.println("Dokonano zapisu");
        System.out.println(trescDozapisu+" "+trescDozapisu1);
    }

    public static String podzial(String liczba){

        float liczbaFlo = Float.parseFloat(liczba);
        float wynik = liczbaFlo/15;

        DecimalFormat Dformat = new DecimalFormat();
        Dformat.setMaximumFractionDigits(2);
        Dformat.setMinimumFractionDigits(2);
        return Dformat.format(wynik);
    }

    public static void wprowadzanieDanych(){
        System.out.println("Wpisz produkt: ");
        inputValue = JOptionPane.showInputDialog("Wpisz produkt: ");
        //  String st = sc.nextLine();
        //  t1[t1.length-1]=st;
        //t1[t1.length-1]=inputValue;


        System.out.println("Wpisz cene: ");
        inputValue1 = JOptionPane.showInputDialog("Wpisz cene: ");
       // t2[t1.length-1]=inputValue1;
//        String st1 = sc.nextLine();
//        t2[t1.length-1]=st1;

        mapa.put(inputValue,inputValue1);
    }

    public static void czytanieDanychZpliku() throws IOException{

        FileReader fOdczyt3 = new FileReader(slowa);
        FileReader fOdczyt4 = new FileReader(litery);
        BufferedReader bOdczyt3 = new BufferedReader(fOdczyt3);
        BufferedReader bOdczyt4 = new BufferedReader(fOdczyt4);

        String plik1 = bOdczyt3.readLine();
        String plik2 = bOdczyt4.readLine();
        t1 = plik1.split("-");
        t2 = plik2.split("-");

        for (int i = 0; i < t1.length; i++) {
            mapa.put(t1[i],t2[i]);
        }

        System.out.println(t1.length+" "+t2.length);

        System.out.println("Dokonano odczytu");
    }

    public static void rysowanieMapy(){
        System.out.println("Lista: Produkty / Ceny / Dzielenie");
        for(Map.Entry<String, String> entry: entrySet) {
            System.out.printf("%s : %s /15= %s %n", entry.getKey(), entry.getValue(),
                    podzial(entry.getValue()));
        }

        JOptionPane.showMessageDialog(null, entrySet,
                "information", JOptionPane.INFORMATION_MESSAGE);
    }
}


