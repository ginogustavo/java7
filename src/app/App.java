package app;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing Java 7 features");
        App app = new App();
        app.diamondOperator();
        app.stringSwitch();
        new Feature3_ResourceMgmt().autoClose();

    }

    /** Feature 1: Diamond operator */
    public void diamondOperator() {

        // Before
        Map<String, List<Integer>> stocks = new TreeMap<String, List<Integer>>();

        // Since Java 7
        Map<String, List<Integer>> newstocks = new TreeMap<>();

        // Omiting the diamond operator (<>) is Legal,
        // However, the compiler will generate couple of type-safety warnings
        Map<String, List<Integer>> newstocks2 = new TreeMap();

    }

    /** Feature 2: Using strings in switch statements */
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

    /**Feature 4: Numeric Literals with Underscore for easy reading */
    public void numericLiteralsUnderscore() {
        //Before
        int thousand = 1000;

        //Since Java7
        //It is easier to read
        int thousand2 = 1_000;
        int million = 1_000_000;

        //Binary literals
        int binary = 0b1; //So you don't have to convert them to hexadecimals anymore
    }

}