package app;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing Java 7 features");
        App app = new App();
        app.diamondOperator();
        app.stringSwitch();
    }

    /** Diamond operator */
    public void diamondOperator() {

        // Before
        Map<String, List<Integer>> stocks = new TreeMap<String, List<Integer>>();

        // Since Java 7
        Map<String, List<Integer>> newstocks = new TreeMap<>();

        // Omiting the diamond operator (<>) is Legal,
        // However, the compiler will generate couple of type-safety warnings
        Map<String, List<Integer>> newstocks2 = new TreeMap();

    }

    /** Using strings in switch statements */
    public void stringSwitch() {
        String status = "Default";

        // Before
        if(status.equalsIgnoreCase("ignore")){
            System.out.println("Process Ignore");
        }else if (status.equalsIgnoreCase("severe")) {
            System.out.println("Process Severe");
        }else if (status.equalsIgnoreCase("warning")) {
            System.out.println("Process Warning");
        }else{
            System.out.println("Process Default");
        }

        //Since Java 7
        switch(status){ // it use String.equals()
            case "ignore":
                System.out.println("Process Ignore");
                break;
            case "severe":
                System.out.println("Process Severe");
                break;
            case "warning":
                System.out.println("Process Warning");
                break;
            default:
                System.out.println("Process Default");
                break;
        }
    }

    /**Automatic Resource Management */
    public void autoClose() {
        
        //Before
        FileInputStream fos1 = null;
        DataOutputStream dos1 = null;
        try {
            fos1 = new FileInputStream("stocks.txt");
            dos1 = new DataOutputStream(null);
            dos1.writeUTF("testing writing files");

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                fos1.close();
                dos1.close();
            } catch (Exception e) {
                //log exception
            }
        }

        //--- Since Java 7

        //try -> resource to be closed.
        //Resources are enclosed in the try statement one after another separated by ;
        //They are automatically closed, since behind classes inherit java.lang.AutoCloseable interface

        try (FileInputStream fos = new FileInputStream("stocks.txt");
            DataOutputStream dos = new DataOutputStream(null)) {
                dos.writeUTF("Testing java 7 automatic resource management");
        } catch (Exception e) {
            // log exception
        }

    }
}