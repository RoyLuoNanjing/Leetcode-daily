package leetcode.challenges.BlackRock.Challenge2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = in.readLine()) != null) {
            lines.add(line);
        }

        if (lines.size() >= 2) {
            processLines(lines.get(0), lines.get(1));
        } else {
            System.out.println("NULL");
        }
    }

    private static void processLines(String line1, String line2) {
        // Split the string into arrays
        String[] set1 = line1.split(" ");
        String[] set2 = line2.split(" ");

        // Store the elements of the first string in a Set
        Set<String> set1Elements = new HashSet<>();
        for (String s : set1) {
            set1Elements.add(s);
        }

        // Find the matching data
        Set<String> matchSet = new HashSet<>();
        for (String s : set2) {
            if (set1Elements.contains(s)) {
                matchSet.add(s);
            }
        }

        // If there is no matching element, return "NUll"
        if (matchSet.isEmpty()) {
            System.out.println("NULL");
        } else {
            // Convert the set to list for sort
            List<String> sortedIntersection = new ArrayList<>(matchSet);
            // The question asked for sorted alpha-numerically result
            Collections.sort(sortedIntersection);
            System.out.println(String.join(" ", sortedIntersection));
        }
    }
}

