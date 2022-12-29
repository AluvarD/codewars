package tasks;

import java.util.ArrayList;
import java.util.List;


public class Permutations {
    //https://www.codewars.com/kata/5254ca2719453dcc0b00027d/train/java
    public static List<String> singlePermutations(String s) {
        List<String> result = new ArrayList<>();

        String[] inputArray = s.split("");

        for (int i = 0; i < inputArray.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(inputArray[i]);
            for (int j = 0; j < inputArray.length; j++) {
                if(i != j) {
                    stringBuilder.append(inputArray[j]);
                }
            }
            String var = stringBuilder.toString();
            if (!result.contains(var)) {
                result.add(var);
            }
        }

        for (int i = 0; i < inputArray.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(inputArray[i]);
            for (int k = inputArray.length - 1; k >= 0; k--) {
                if(i != k) {
                    stringBuilder.append(inputArray[k]);
                }
            }
            String var = stringBuilder.toString();
            if (!result.contains(var)) {
                result.add(var);
            }
        }

        return result;
    }
}
