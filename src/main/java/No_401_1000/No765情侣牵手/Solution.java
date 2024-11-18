package No_401_1000.No765情侣牵手;

public class Solution {
    public static void main(String[] args) {
        int[] rows = {0, 2, 1, 3};
        System.out.println(minSwapsCouples(rows));
    }

    public static int minSwapsCouples(int[] row) {
        int cnt = 0;
        int n = row.length / 2;
        for (int i = 0; i < n; i++) {
            int x = row[i * 2];
            //使用异或得到他的配偶
            int y = x ^ 1;
            if (row[i * 2 + 1] == y) continue;
            //如果是偶数，则寻找row[i*2]+1的下标
            for (int j = i * 2 + 2; j < row.length; j++) {
                if (row[j] == y) {
                    //进行交换
                    row[j] = row[i * 2 + 1];
                    row[i * 2 + 1] = y;
                    cnt++;
                }
            }

        }
        return cnt;
    }
}
