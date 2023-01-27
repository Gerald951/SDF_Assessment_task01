package sdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int i;
        String fileName = args[0];

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map = Mapping.map(fileName);
        int count = Count.CountNoOfWords(fileName);

        LinkedHashMap<String, Integer> sortedMap_ = Compare.compare(fileName, map);

        int size = sortedMap_.size();

        List<String> listKeys = new ArrayList<String>(sortedMap_.keySet());
        List<Integer> listValues = new ArrayList<Integer>(sortedMap_.values());

        System.out.println("The top 10 frequently used words: ");

        for (i = size-11; i < size-1; i++) {
            double frequency = (double) listValues.get(i)/count;
            System.out.println("[Word: " + listKeys.get(i) + "] [Number of times it was used: " + listValues.get(i).toString() + "] [Frequency: " + String.valueOf(frequency) + "]");
        }

    }
}