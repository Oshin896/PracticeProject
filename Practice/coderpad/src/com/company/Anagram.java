package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public List<List<String>> anagrams(String[] str){
        HashMap<HashMap<Character,Integer>,List<String>> groupedAnagrams=new HashMap<>();
        for(int i=0;i<str.length;i++) {
            HashMap<Character, Integer> temp = new HashMap<>();
//insert characters and frequency into hashmap
            for (int j = 0; j < str[i].length(); j++) {
                if (temp.containsKey(str[i].charAt(j))) {
                    int count = temp.get(str[i].charAt(j));
                    temp.put(str[i].charAt(j), ++count);
                } else
                    temp.put(str[i].charAt(j), 1);
            }
            //insert string i at appropriate location
            List<String> stringList=null;
            if(groupedAnagrams.containsKey(temp)){
                groupedAnagrams.get(temp).add(str[i]);
            }else {
                stringList=new ArrayList<>();
                stringList.add(str[i]);
                groupedAnagrams.put(temp,stringList);
            }



        }
        List<List<String>> result=new ArrayList<>();
        for(HashMap<Character,Integer> map: groupedAnagrams.keySet()){
            result.add(groupedAnagrams.get(map));
        }
        return result;
    }
}
