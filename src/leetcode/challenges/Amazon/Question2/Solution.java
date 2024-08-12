package leetcode.challenges.Amazon.Question2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
data scientists at amazon are working on a utility for genome sequencing algorithms.
the untility finds anagram patterns in a pair of DNA sequence strings.
A pair of DNA is sepecial if they are anagrams after removing any number of occurrences of at most one character from each DNA sequence.
Given n pairs of DNA, for each pair, attempt to make them anagrams. Retrun a list of boolean values,
one for each pair, where True means a pair is special. Example: given, n = 1, pair and strings dna1= "safddadfs" and dna2="famafmss".
the strings are anagrams after removing all the occurrences of characters 'd' from s and character 'm' from t. return [True].
Note: it is not required that all instances of a character be removed. for example,
given 'aab' and 'ba', one 'a' can be removed from 'aab' to leave 'ab'
 */
public class Solution {

    public static List<Boolean> getSequence(List<List<String>> dna) {
        List<Boolean> result = new ArrayList<>();

        for (List<String> pair : dna) {
            String dna1 = pair.get(0);
            String dna2 = pair.get(1);

            // Find chars of the string as well as their numbers
            Map<Character, Integer> count1 = getCharCount(dna1);
            Map<Character, Integer> count2 = getCharCount(dna2);
            System.out.println(count1);
            System.out.println(count2);

            // Find the difference of char set
            int differenceCount = 0;
            boolean canBeSpecial = true;

            //loop the first dna to count the difference of chars
            for (char c : count1.keySet()) {
                int freq1 = count1.getOrDefault(c, 0);
                int freq2 = count2.getOrDefault(c, 0);
                if (freq1 != freq2) {
                    differenceCount++;
                    //if the difference is bigger than the max value, it is unlikely to meet the condition
                    if (Math.abs(freq1 - freq2) > Math.max(freq1, freq2)) {
                        canBeSpecial = false;
                        break;
                    }
                }
            }

            // check if the second dna contains the chars that the first does not contain
            for (char c : count2.keySet()) {
                if (!count1.containsKey(c)) {
                    differenceCount++;
                    //if the number of this char is bigger than 1, so it is unlikely to meet the condition
                    if (count2.get(c) > 1) {
                        canBeSpecial = false;
                        break;
                    }
                }
            }

            // only true when the difference is smaller than 2 AND can be specially process
            if (differenceCount <= 2 && canBeSpecial) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    /**
     * A function to quickly get a map of characters and its frequencies
     *
     * @param s dna string
     * @return a map that contains char and its frequency
     */
    private static Map<Character, Integer> getCharCount(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return count;
    }
}
