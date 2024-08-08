package leetcode.challenges.BlackRock.Challenge1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/*
Programming challenge description:
You've decided to make a road trip across the country in a straight line. You have chosen the direction you'd like to travel and made a list of cities in that direction that have gas stations to stop at and fill up your tank. To make sure that this route is viable, you need to know the distances between the adjacent cities in order to be able to travel this distance on a single tank of gasoline, (No one likes running out of gas.) but you only know distances to each city from your starting point.
Input:
Your program should read lines from standard input. Each line contains the list of cities and distances to them, comma delimited, from the starting point of your trip. You start your trip at point 0. The cities with their distances are separated by semicolon.
Output:
Print out the distance from the starting point to the nearest city, and the distances between two nearest cities separated by comma, in order they appear on the route.
Test 1
Test Input
Download Test 1 Input
Rkbs,5453; Wdqiz,1245; Rwds,3890; Ujma,5589; Tbzmo,1303;
Expected Output
Download Test 1 Output
1245,58,2587,1563,136

Test 2
Test Input
Download Test 2 Input
Vgdfz,70; Mgknxpi,3958; Nsptghk,2626; Wuzp,2559; Jcdwi,3761;
Expected Output
Download Test 2 Output
70,2489,67,1135,197
 */
class CityDistance {
    String city;
    int distance;

    CityDistance(String city, int distance) {
        this.city = city;
        this.distance = distance;
    }
}

public class Solutions {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            // 解析输入行并计算结果
            processLine(line);
        }
    }

private static void processLine(String line) {
    // Get the string of city name and its distance from the input lines
    String[] cityDistancePairs = line.split(";");

    //Create an Arraylist to store the city and list
    List<CityDistance> cityDistances = new ArrayList<>();

    //split the data string and store them in the object.
    for (String pair : cityDistancePairs) {
        String[] parts = pair.split(",");
        String city = parts[0].trim();
        int distance = Integer.parseInt(parts[1].trim());
        cityDistances.add(new CityDistance(city, distance));
    }

    // Sort the city distance from the closet to the furthest
    Collections.sort(cityDistances, Comparator.comparingInt(cd -> cd.distance));

    // generate the output string
    StringBuilder output = new StringBuilder();

    //initial distance is that of the closest city
    output.append(cityDistances.get(0).distance);
    for (int i = 1; i < cityDistances.size(); i++) {
        //calculate the difference between the current city and previous city
        int distanceBetweenCities = cityDistances.get(i).distance - cityDistances.get(i - 1).distance;
        output.append(",").append(distanceBetweenCities);
    }

    System.out.println(output.toString());
}
}
