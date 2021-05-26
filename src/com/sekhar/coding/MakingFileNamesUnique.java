package com.sekhar.coding;

import java.util.HashMap;
import java.util.HashSet;

public class MakingFileNamesUnique {

    private HashMap<String, Integer> nameData = new HashMap<>();
    private HashSet<String> resultData = new HashSet<>();
    private String[] result;
    private int resultCounter = 0;
    public String[] getFolderNames(String[] names) {
        if (names.length == 0)
            return null;
        result = new String[names.length];
        for (String eachName : names) {
            if (!nameData.containsKey(eachName)) {
                resultData.add(eachName);
                nameData.put(eachName, 0);
                result[resultCounter++] = eachName;
            } else {
                int counter = nameData.get(eachName);
                while (true) {
                    counter++;
                    String newName = eachName + "(" + counter + ")";
                    if (!resultData.contains(newName)) {
                        nameData.put(eachName, counter);
                        nameData.put(newName, 0);
                        resultData.add(newName);
                        result[resultCounter++] = newName;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
