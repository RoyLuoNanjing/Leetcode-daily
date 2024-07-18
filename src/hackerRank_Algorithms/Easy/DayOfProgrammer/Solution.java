package hackerRank_Algorithms.Easy.DayOfProgrammer;

public class Solution {
    public static String dayOfProgrammer(int year) {
        // Write your code here
        boolean isLeapYear = isLeapYear(year);
        int noOfDaysInFeb = isLeapYear? 29 : 28;

        if (year == 1918){
            noOfDaysInFeb -= 13;
        }

        int[] daysOfMonthArr = new int[]{31, noOfDaysInFeb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int dayOfProgrammer = 256;

        int day = 0;
        int month = 0;
        for (int i = 0; i < daysOfMonthArr.length; i++) {
            if (dayOfProgrammer > daysOfMonthArr[i]){
                dayOfProgrammer -= daysOfMonthArr[i];
            } else {
                month = i + 1;
                day = dayOfProgrammer;
                break;
            }
        }

        String dayStr = day <10 ? "0" + day : Integer.toString(day);
        String monthStr = month <10 ? "0" + month : Integer.toString(month);


        return dayStr +"."+monthStr +"."+year;


    }

    public static boolean isLeapYear(int year) {
        if (year <= 1918) {
            return year % 4 == 0;
        } else {
            return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }
    }
}
