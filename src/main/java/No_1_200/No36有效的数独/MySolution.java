package No_1_200.No36有效的数独;

import java.util.HashSet;

public class MySolution {

    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * TODO
     * 拙劣的遍历了三次,分别验证行\列\单元中的情况
     * 参考官解,在可能性有限的情况下,应该考虑使用数组来记录,
     * 如使用长度为9的数组记录每个数字出现的次数,而不是使用set来记录出现的数字
     * 应该根据三种情况分别使用对应的数据结构来记录数字出现的次数,在遍历过程中即可判断是否满足要求
     *
     */
    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            characters.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (characters.contains(c)) {
                    return false;
                } else {
                    if ('.' != c) {
                        characters.add(c);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            characters.clear();
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (characters.contains(c)) {
                    return false;
                } else {
                    if ('.' != c) {
                        characters.add(c);
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                characters.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i+k][j+l];
                        if (characters.contains(c)) {
                            return false;
                        } else {
                            if ('.' != c) {
                                characters.add(c);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


}
