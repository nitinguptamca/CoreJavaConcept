package com.interview.hexaware;

import java.io.*;
import java.util.*;

public class DemoComprator {

public static void main(String[] args) {
    Map<String, Integer> map = new LinkedHashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new  File(
                    "/home/netiq/Documents/input.txt")));
            String str;
            while ((str = br.readLine()) != null) {
                Scanner sc = new Scanner(str);
                while (sc.hasNext()) {
                    String word = sc.next();
                    if (map.containsKey(word))
                        map.put(word, map.get(word) + 1);
                    else
                        map.put(word, 1);
                }

            }
           // System.out.println("yes");
        } catch (IOException e) {
            e.printStackTrace();
        }
     //   System.out.println(map);
        Comparator<String> comparator=new MyDemoComprator(map);
         Map<String,Integer> treemap=new TreeMap<String, Integer>(comparator);
        treemap.putAll(map);
     //   System.out.println(treemap);
        for(Map.Entry<String, Integer> entry:treemap.entrySet())
        {
            System.out.print(entry.getKey());
            //System.out.println(" :  "+entry.getValue());
            System.out.println();
        }

}

}

class MyDemoComprator implements Comparator<String>
    {
    Map<String,Integer> map;

   public MyDemoComprator(Map<String, Integer> map) {
      super();
       this.map = map;
    }

@Override
public int compare(String o1, String o2) {
    if(map.get(o1)>=map.get(o2))
        return -1;
    else
        return 1;
    //return 0;
}

}
