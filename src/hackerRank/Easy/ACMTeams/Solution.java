package hackerRank.Easy.ACMTeams;

import java.util.*;

public class Solution {
    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        int number = topic.size();
        int length = topic.get(0).length();

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < number - 1; i++) {
            for (int j = i + 1; j < number ; j++) {
                int count = 0;
                for (int k = 0; k < length; k++) {
                    if (topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1') {
                        count++;
                    }
                }
                map.put(count, map.getOrDefault(count, 0) + 1);
            }
        }

        int max = 0;
        for (int key :
                map.keySet()) {
            max = Math.max(key, max);
        }
        List<Integer> res = new ArrayList<>();
        res.add(max);
        res.add(map.get(max));
        return res;
    }


    public static void main(String[] args) {
        List<String> topic = new ArrayList<>(Arrays.asList(new String[]{"10101",
                "11100",
                "11010",
                "00101"}));

        acmTeam(topic);
    }

}
