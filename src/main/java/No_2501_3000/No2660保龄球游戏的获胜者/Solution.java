package No_2501_3000.No2660保龄球游戏的获胜者;

public class Solution {
    public static void main(String[] args) {
        int[] player1 = {2,3}, player2 = {4,1};
        System.out.println(isWinner(player1, player2));
    }

    public static int isWinner(int[] player1, int[] player2) {
        int n = player1.length;
        int doubleSignal1=0;
        int doubleSignal2=0;
        int score1=0;
        int score2=0;
        for (int i = 0; i < n; i++) {
            if (doubleSignal1>0){
                score1+=2*player1[i];
                doubleSignal1--;
            }else {
                score1+=player1[i];
            }
            if (doubleSignal2>0){
                score2+=2*player2[i];
                doubleSignal2--;
            }else {
                score2+=player2[i];
            }
            if (player1[i]==10) doubleSignal1=2;
            if (player2[i]==10) doubleSignal2=2;
        }
        System.out.println(score1);
        System.out.println(score2);
        if (score1>score2) return 1;
        else if (score1<score2) return 2;
        else return 0;
    }

}
