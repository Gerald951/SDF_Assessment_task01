package sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Compare {

    public static LinkedHashMap<String, Integer> compare(String fileName, HashMap<String, Integer> map) {
    BufferedReader fileReader = null;
    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    int count = 0;

    String line = "";

        try {
            // open file 
            fileReader = new BufferedReader(new FileReader(fileName));

            if (fileName == "cat_in_the_hat.txt") {
                // read the record line by line
                while ((line = fileReader.readLine()) != null) {

                    String regex = "[!._,'-? ]";
                    String[] items = line.split(regex);
                    // map each unique words into hashmap
                    for (int i=0; i<items.length; i++) {
                        items[i] = items[i].toLowerCase();
                        //int count = 0;
                        for (int j=i+1; j<items.length; j++) {
                            items[j] = items[j].toLowerCase();
                            if (items[i].equals(items[j])) {
                                count++;
                                int values = map.get(items[i]);
                                map.put(items[i], values+=count);
                            }
                        }
                    }      
                }
            } else { 
                //skip header lines
                for (int j = 0; j < 4; j++) {
                    line = fileReader.readLine();
                }

                while ((line = fileReader.readLine()) != null) {

                    String regex = "[!._,'-?;: ]";
                    String[] items = line.split(regex);
                    
                    for (int i=0; i<items.length; i++) {
                        items[i] = items[i].toLowerCase();
                        //int count = 1;
                        for (int j=i+1; j<items.length; j++) {
                            items[j] = items[j].toLowerCase();
                            if (items[i].equals(items[j])) {
                                count++;
                                int values = map.get(items[i]);
                                map.put(items[i], values+=count);
                            }
                        }       
                    }
                }

            } 
        } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        list.add(entry.getValue());
    }
    Collections.sort(list); 
    for (int num : list) {
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(num)) {
                 sortedMap.put(entry.getKey(), num);
            }
        }
    }    
    return sortedMap;
    }
}


    

        

