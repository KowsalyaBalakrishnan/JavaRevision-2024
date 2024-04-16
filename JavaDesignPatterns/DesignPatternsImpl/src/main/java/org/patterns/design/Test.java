package org.patterns.design;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11};
        int target = 20;

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else if (sum == target) {
                System.out.println(arr[i] + "," + arr[j]);
                i++;
                j--;
            }
        }

        // String str1 = "Today is sunny day"; find out the max occurrence of characters using only one iteration loop

        System.out.println("********************");
        String str = "Today is sunny day";
        Map<Character, Integer> stringMap = new HashMap<>();
        for (int k = 0; k < str.length(); k++) {
            if (stringMap.isEmpty()) {
                stringMap.put(str.charAt(k), 1);
            } else {
                if (stringMap.get(str.charAt(k)) == null) {
                    stringMap.put(str.charAt(k), 1);
                } else {
                    int value = stringMap.get(str.charAt(k));
                    stringMap.put(str.charAt(k), ++value);
                }
            }
        }

        stringMap.forEach((key, value) -> System.out.println(key + " -> " + value));

    }
}
