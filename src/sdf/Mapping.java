package sdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mapping {

    public static HashMap<String,Integer> map(String fileName) {
    BufferedReader fileReader = null;

    String line = "";

    HashMap<String, Integer> map = new HashMap<String, Integer>();
        int count = 0;

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
                        map.put(items[i], 1);
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
                        map.put(items[i], 1);
                        
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
        return map;
    }
    
}
