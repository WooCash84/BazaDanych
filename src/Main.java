// TAK KLASA SIE NIE POTRZEBNA
// USUNĘ JĄ NIEBAWEM, może:)

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    static String slowa = "src/com/company/slowa.txt";
    static String litery = "src/com/company/litery.txt";

  //  static Scanner sc=new Scanner(System.in);

//taki komentarz
    public static void main(String[] args) throws FileNotFoundException, IOException {


//            FileReader fOdczyt1 = new FileReader(slowa);
//            FileReader fOdczyt2 = new FileReader(litery);
//            BufferedReader bOdczyt1 = new BufferedReader(fOdczyt1);
//            BufferedReader bOdczyt2 = new BufferedReader(fOdczyt2);
            FileReader fOdczyt3 = new FileReader(slowa);
            FileReader fOdczyt4 = new FileReader(litery);
            BufferedReader bOdczyt3 = new BufferedReader(fOdczyt3);
            BufferedReader bOdczyt4 = new BufferedReader(fOdczyt4);

        String plik1 = bOdczyt3.readLine();
        String plik2 = bOdczyt4.readLine();
        String[] t1;
        String[] t2;
        t1 = plik1.split(",");
        t2 = plik2.split("/");

        String t3;
        String[] t4= new String[13];
        String[] t5= new String[13];

        System.out.println("Wpisz produkt: ");
/**        t3=sc.nextLine();

        for (int i = 0; i < t1.length ; i++) {

            if(t1[i].equalsIgnoreCase(t3)){
                t1[i]=t3;
                t2[i]="matma";
            } else {
                t4[i]=t3;
                t5[i]="5*5";
            }
        }

        for (int i = 0; i < t1.length ; i++) {
            System.out.printf("%-10s : %10s %n",t1[i],t2[i]);
        }
        for (int i = 0; i < 1 ; i++) {
            System.out.printf("%-10s : %10s %n",t4[i],t5[i]);
        }
*/

        Map<String, String> mapa = new TreeMap<>();
        for (int i = 0; i < t1.length ; i++) {
            mapa.put(t1[i],t2[i]);
        }

        String st = "nowy wpis";
        st = sc.nextLine();

        t1[t1.length-1]=st;
        t2[t1.length-1]="6969";

        mapa.put(t1[t1.length-1], t2[t1.length-1]);

        System.out.println("Lista: Produkty / Ceny / Dzielenie");
        Set<Map.Entry<String,String>> entrySet = mapa.entrySet();
        for(Map.Entry<String, String> entry: entrySet) {
        System.out.printf("%-20s : %s /15= %s %n", entry.getKey(), entry.getValue(), podzial(entry.getValue()));
        }

//        mapa.put("Fajki", "15");
//        mapa.put("banan", "200");
//
//        mapa.remove("Banan");
//        mapa.put("Brokul", "99");
//
//
//        for(Map.Entry<String, String> entry: entrySet) {
//            System.out.printf("%-20s : %s /15= %s %n", entry.getKey(), entry.getValue(), podzial(entry.getValue()));
//        }

    }
    public static String podzial(String liczba){

        float liczbaFlo = Float.parseFloat(liczba);
        float wynik = liczbaFlo/15;

        DecimalFormat Dformat = new DecimalFormat();
        Dformat.setMaximumFractionDigits(2);
        Dformat.setMinimumFractionDigits(2);
        return Dformat.format(wynik);
    }


}


