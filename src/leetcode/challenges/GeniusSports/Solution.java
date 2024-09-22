package leetcode.challenges.GeniusSports;

import java.util.*;

public class Solution {
    public static List<String> getOffsidePlayerIds(List<String> playersData) {
        List<String> offsidePlayers = new ArrayList<>();
        List<Double> redTeamXCoordinates = new ArrayList<>();
        Map<String, Double> blueTeamPlayers = new LinkedHashMap<>();

        // 解析玩家数据
        for (String playerData : playersData) {
            String[] data = playerData.split(",");
            String playerId = data[0];
            String team = data[1];
            double x = Double.parseDouble(data[2]);

            if (team.equals("red")) {
                redTeamXCoordinates.add(x);
            } else if (team.equals("blue")) {
                blueTeamPlayers.put(playerId, x);
            }
        }

        // 找到红队最接近球门的两名玩家
        Collections.sort(redTeamXCoordinates);

        // 获取红队最左边的两名球员的x坐标
        double secondClosestRedX = redTeamXCoordinates.get(1);

        // 检查蓝队球员是否越位
        for (Map.Entry<String, Double> bluePlayer : blueTeamPlayers.entrySet()) {
            if (bluePlayer.getValue() > secondClosestRedX) {
                offsidePlayers.add(bluePlayer.getKey());
            }
        }

        return offsidePlayers;
    }

}
