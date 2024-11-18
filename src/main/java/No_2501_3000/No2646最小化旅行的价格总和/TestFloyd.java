package No_2501_3000.No2646最小化旅行的价格总和;

public class TestFloyd {
    public static int MaxValue = 100000;
    public static int[][] path;

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}}, trips = {{0, 3}, {2, 1}, {2, 3}};
        int[] price = {2, 2, 10, 6};

        int[][] matrix = new int[n][n];
        //初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) matrix[i][j] = MaxValue;
                else matrix[i][j] = price[i];
            }
        }

        //初始化路径数组
        path = new int[n][n];

        //初始化边权值
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            matrix[edge[1]][edge[0]] = matrix[edge[0]][edge[1]] = price[edge[0]] + price[edge[1]];
        }

        //调用算法计算最短路径
        floyd(matrix, price);
    }

    //非递归实现
    public static void floyd(int[][] matrix, int[] price) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    int cost = matrix[i][m] + matrix[m][j] - price[m];
                    if (cost < matrix[i][j]) {
                        matrix[i][j] = cost;
                        //记录经由哪个点到达
                        path[i][j] = m;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "到" + j + "不可达");
                    } else {
                        System.out.print(i + "到" + j + "的最短路径长度是：" + matrix[i][j]);
                        System.out.print("最短路径为：" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }

    }

    //递归寻找路径
    public static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }

        findPath(i, m);
        System.out.print(m + "->");
        findPath(m, j);
    }
}
