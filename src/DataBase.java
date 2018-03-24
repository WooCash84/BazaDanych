import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class DataBase {

    static String product = "C:/Users/Admin/Desktop/Projekt/BazaDanych/src/products.txt";
    static String price = "C:/Users/Admin/Desktop/Projekt/BazaDanych/src/prices.txt";

    static String[] products;
    static String[] prices;
    static Map<String, String> map = new TreeMap<>();
    static Set<Map.Entry<String,String>> entrySet = map.entrySet();

    static Scanner sc=new Scanner(System.in); // console version

    static String productInputValue;  // JOptionPane version
    static String priceInputValue;


    public static void main(String[] args){

        try {
            readingFile();
        }catch (IOException e){
            System.out.println("Error - reading form file");
            e.printStackTrace();}

        enteringData();
        mapDrawing();

        try {
            writingFile();
        }catch (IOException e){
            System.out.println("Error - writing to file");
            e.printStackTrace();}
    }
    public static void writingFile() throws IOException{
        FileWriter productWriter = new FileWriter(product);
        FileWriter priceWriter = new FileWriter(price);
        BufferedWriter product = new BufferedWriter(productWriter);
        BufferedWriter price = new BufferedWriter(priceWriter);

        Set<String> keys = map.keySet();
        StringBuilder productValue = new StringBuilder();
        StringBuilder priceValue = new StringBuilder();
        for (String i : keys) {
            productValue.append(i + "-");
            priceValue.append(map.get(i) + "-");
        }
        productValue.deleteCharAt(productValue.lastIndexOf("-"));
        priceValue.deleteCharAt(priceValue.lastIndexOf("-"));

        product.write(String.valueOf(productValue));
        price.write(String.valueOf(priceValue));
        product.close();
        price.close();

        System.out.println("Writing to file - completed");
        System.out.println("Products: "+productValue+"\nPrices: "+priceValue);
    }

    public static void enteringData(){
        System.out.println("Enter product: ");
        productInputValue = JOptionPane.showInputDialog("Enter product: ");
        
        System.out.println("Enter price: ");
        priceInputValue = JOptionPane.showInputDialog("Enter price: ");

        map.put(productInputValue,priceInputValue);
    }

    public static void readingFile() throws IOException{

        FileReader productReader = new FileReader(product);
        FileReader priceReader = new FileReader(price);
        BufferedReader productBuffer = new BufferedReader(productReader);
        BufferedReader priceBuffer = new BufferedReader(priceReader);

        String plik1 = productBuffer.readLine();
        String plik2 = priceBuffer.readLine();
        products = plik1.split("-");
        prices = plik2.split("-");

        for (int i = 0; i < products.length; i++) {
            map.put(products[i],prices[i]);
        }

        System.out.println("Number of: \nproducts / prices\n"
                + products.length+" / "+prices.length);

        System.out.println("Reading from file - completed");
    }

    public static void mapDrawing(){
        System.out.println("List: \nProducts / Prices");
        for(Map.Entry<String, String> entry: entrySet) {
            System.out.println(entry.getKey()+" / "+entry.getValue());
        }

        JOptionPane.showMessageDialog(null, entrySet,
                "information", JOptionPane.INFORMATION_MESSAGE);
    }
}


