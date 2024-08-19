package leetcode.easy.Q551_StudentAttendanceRecordI;

public class Solution {
    public boolean checkRecord(String s) {
        int absentTotal = 0;
        int lateDays = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'A') {
                absentTotal++;
                lateDays = 0;
            } else if (current == 'L') {
                lateDays++;
            } else {
                lateDays = 0;
            }
            if (absentTotal == 2 || lateDays == 3) {
                return false;
            }
        }
        return true;
    }
}
