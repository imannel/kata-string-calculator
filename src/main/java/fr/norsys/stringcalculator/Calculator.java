package fr.norsys.stringcalculator;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";
        ArrayList negatives = new ArrayList<>();
        if (numbers.startsWith("//")) {
          //  delimiter = String.valueOf(numbers.charAt(2));
            int delimiterEnd =numbers.indexOf("\n");

            delimiter=numbers.substring(2,delimiterEnd).replaceAll("\\[|\\]","");

            System.out.println(delimiter);
            //  numbers = numbers.substring(4);
            numbers=numbers.substring(delimiterEnd+1);
        }

        String[] numberStrings = numbers.split(delimiter);
        int sum = 0;

        for (String numberString : numberStrings) {
            int num = Integer.parseInt(numberString);
            if (num < 0) {
                negatives.add(num);
            }
            if (num > 1000) {
                continue;
            }
            else sum += num;
        }
        if (!(negatives.isEmpty())) {
            //System.out.println(negatives.toString());
            throw new RuntimeException(negatives.toString());
        }


        return sum;
    }


}
