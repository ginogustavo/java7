package app;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Testing Java 7 features");
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
}