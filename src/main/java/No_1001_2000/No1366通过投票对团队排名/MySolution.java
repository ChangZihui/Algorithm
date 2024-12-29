package No_1001_2000.No1366通过投票对团队排名;

import java.util.Arrays;
import java.util.List;

public class MySolution {

    /**
     * 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，
     * 每个投票者都需要按从高到低的顺序对参与排名的所有团队进行排位。
     * 排名规则如下：
     * 参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，
     * 将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
     * 如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
     * 给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
     * 请你返回能表示按排名系统 排序后 的所有团队排名的字符串
     * 1 <= votes.length <= 1000
     * 1 <= votes[i].length <= 26
     * votes[i].length == votes[j].length for 0 <= i, j < votes.length
     * votes[i][j] 是英文 大写 字母
     * votes[i] 中的所有字母都是唯一的
     * votes[0] 中出现的所有字母 同样也 出现在 votes[j] 中，其中 1 <= j < votes.length
     * TODO 使用长度为n+1的数组,在最后一位存储key,避免了使用map进行操作
     */
    public static void main(String[] args) {
//        String[] votes = {"ABC", "ACB", "ABC", "ACB", "ACB"};
        String[] votes = {"WXYZ", "XYZW"};

        System.out.println(rankTeams(votes));
    }

    /**
     * 因为参与排序的都是大写字母,所以建立一个长度为26的数组来记录每个字母获得的分数
     * 每个字母的得分用长度为26的数组来记录,每一位代表得分第i的个数,
     */
    public static String rankTeams(String[] votes) {
        int[][] rank = new int[26][27];
        for (int i = 0; i < 26; i++) {
            rank[i][26] = i + 65;
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                rank[vote.charAt(i) - 65][i] += 1;
            }
        }
        List<int[]> list = Arrays.stream(rank).sorted((a, b) -> {
            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    return b[i] - a[i];
                }
            }
            return a[26] - b[26];
        }).toList();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            result.append((char) list.get(i)[26]);
        }
        return result.toString();
    }
}
