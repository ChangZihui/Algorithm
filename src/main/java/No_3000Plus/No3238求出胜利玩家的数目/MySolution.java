package No_3000Plus.No3238求出胜利玩家的数目;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数 n ，表示在一个游戏中的玩家数目。同时给你一个二维整数数组 pick ，
 * 其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个颜色为 yi 的球。
 * 如果玩家 i 获得的球中任何一种颜色球的数目 严格大于 i 个，那么我们说玩家 i 是胜利玩家。换句话说：
 * 如果玩家 0 获得了任何的球，那么玩家 0 是胜利玩家。
 * 如果玩家 1 获得了至少 2 个相同颜色的球，那么玩家 1 是胜利玩家。
 * ...
 * 如果玩家 i 获得了至少 i + 1 个相同颜色的球，那么玩家 i 是胜利玩家。
 * 请你返回游戏中 胜利玩家 的数目。
 * 注意，可能有多个玩家是胜利玩家。
 * 2 <= n <= 10
 * 1 <= pick.length <= 100
 * pick[i].length == 2
 * 0 <= xi <= n - 1
 * 0 <= yi <= 10
 * 官解:
 * @see Solution
 * TODO 未能注意到提示条件yi的范围是有限的,可以使用数组记录每个玩家获得球的个数,来降低空间复杂度
 */
public class MySolution {

    public static void main(String[] args) {
        int n = 4;
        int[][] pick = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
        System.out.println(winningPlayerCount(n, pick));
    }

    public static int winningPlayerCount(int n, int[][] pick) {
        List<Integer> winners = new ArrayList<>();
        List<Map<Integer,Integer>> list=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashMap<>());
        }
        for (int[] ints : pick) {
            int index = ints[0];
            int color = ints[1];
            if (winners.contains(index)) {
                continue;
            }
            Map<Integer, Integer> map = list.get(index);
            if (map.get(color) == null) {
                if (index==0){
                    winners.add(index);
                }else {
                    map.put(color, 1);
                }
            }else {
                Integer count = map.get(color);
                if (count+1>index){
                    winners.add(index);
                }else {
                    map.put(color, count+1);
                }
            }

        }
        return winners.size();
    }

}
