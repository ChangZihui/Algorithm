package No_201_400.No275H指数II;

import java.time.OffsetDateTime;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {0, 1};
        System.out.println(hIndex(citations));
    }

    /**
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照
     * 升序排列 。计算并返回该研究者的 h 指数。
     * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）
     * 总共有 h 篇论文分别被引用了至少 h 次。
     * 请你设计并实现对数时间复杂度的算法解决此问题。
     */
    public static int hIndex(int[] citations) {
        //对于int[i]，满足h指数的条件是int[i]>= int.length-i
        int a = 0, b = citations.length - 1;
        int h = 0;
        while (a < b) {
            int i = (a + b) / 2;
            if (citations[i] == citations.length - i) {
                h = citations[i];
                break;
            }
            if (citations[i] < citations.length - i) {
                b = i - 1;
                if (b - a < 1) {
                    break;
                }
            } else if (citations[i] > citations.length - i) {
                a = i + 1;
                h = Math.max(h, citations.length - i);
                if (b - a < 1) {
                    break;
                }
            }
        }
        return h;
    }
}
