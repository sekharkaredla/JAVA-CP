package com.sekhar.coding;

import java.util.*;

public class StringForward {
    public String forward(String input, List<Integer> subStringIndexes) {
        if (input == null)
            return null;
        HashMap<Integer, Integer> eachCharForwards = new HashMap<Integer, Integer>();
        for (int eachSubstringIndex : subStringIndexes) {
            for (int i = 0; i < eachSubstringIndex; i++) {
                if (!eachCharForwards.containsKey(i))
                    eachCharForwards.put(i, 1);
                else
                    eachCharForwards.put(i, 1 + eachCharForwards.get(i));
            }
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Integer> eachEntry : eachCharForwards.entrySet()) {
            char eachChar = input.charAt(eachEntry.getKey());
            char temp = (char)(eachChar + eachEntry.getValue());
            if (temp > 'z')
                temp = (char)(eachChar - (26 - eachEntry.getValue()));
            result.append(temp);
        }
        return result.toString();
    }

    public static String numberToOrdinal( Integer number ) {
        int lastTwoDigitsOfTheNumber = number % 100;
        int lastDigitOfTheNumber = number % 10;
        if (lastTwoDigitsOfTheNumber >= 11 && lastTwoDigitsOfTheNumber <= 13)
         return String.valueOf(number) + "th";
        else if (lastDigitOfTheNumber == 0)
            return String.valueOf(number);
        else if (lastDigitOfTheNumber == 1)
            return String.valueOf(number) + "st";
        else if (lastDigitOfTheNumber == 2)
            return String.valueOf(number) + "nd";
        else if (lastDigitOfTheNumber == 3)
            return String.valueOf(number) + "rd";
        else
            return String.valueOf(number) + "th";
    }
}
