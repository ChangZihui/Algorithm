package No_3000Plus.No3274检查棋盘方格颜色是否相同;

public class MySolution {
    /**
     * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
     * 以下是棋盘的参考图。
     * 如果这两个方格颜色相同，返回 true，否则返回 false。
     * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
     */
    public static void main(String[] args) {
        String coordinate1 = "a1", coordinate2 = "h3";
        System.out.println(checkTwoChessboards(coordinate1, coordinate2));
    }


    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (coordinate1.charAt(0)+coordinate1.charAt(1))%2==(coordinate2.charAt(0)+coordinate2.charAt(1))%2;
    }

}
