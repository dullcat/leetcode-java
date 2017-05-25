package q2;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    // Amazon Online Accessment Q2
    public class Main {
         class Pair implements Comparable<Pair>{
            String pairKey;
            String pairValue;

            Pair(String pairKey, String pairValue) {
                this.pairKey = pairKey;
                this.pairValue = pairValue;
            }

            public String getPairKey() {
                return pairKey;
            }

            public String getPairValue() {
                return pairValue;
            }

            public String toString() {
                return getPairKey() + " " + getPairValue();
            }

            @Override
            public int compareTo(Pair pair) {
                int compare = pairKey.compareTo(pair.getPairKey());
                if(compare == 0) {
                    compare = pairValue.compareTo(pair.getPairValue());
                }
                return compare;
            }
        }
         List<Pair> solve(List<Pair> lunchMenuPairs, List<Pair> teamCuisinePreferencePairs){
            List<Pair> result= null;

            /***
             *  your code here
             ***/
            HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
            for (int i=0; i<lunchMenuPairs.size(); i++) {
                Pair pair = lunchMenuPairs.get(i);
                ArrayList<String> options = map.get(pair.getPairValue());
                if (!map.containsKey(pair.getPairValue())) {
                    options = new ArrayList<String>();
                }
                options.add(pair.getPairKey());
            }

            result = new ArrayList<Pair>();
            for (int i=0; i<teamCuisinePreferencePairs.size(); i++) {
                Pair person = teamCuisinePreferencePairs.get(i);
                if (person.getPairValue().equals("*")) {
                    for (Pair lunch:lunchMenuPairs) {
                        result.add(new Pair(person.getPairKey(), lunch.getPairKey()));
                    }
                }
                else {
                    List<String> options = map.get(person.getPairValue());
                    for (String option: options) {
                        result.add((new Pair(person.getPairKey(), option)));
                    }
                }
            }
            return result;
        }


        private  void print(List<?> resultPairs) {
            for (Object pair : resultPairs) {
                System.out.println(pair);
            }
        }

    }

    public static class UnitTest {
        @Test
        public void testQ2() {
            //Solution s = new Q2().new Solution();
        }
    }
}

