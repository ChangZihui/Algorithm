package No_2001_2500.No2383赢得比赛需要的最少训练时长;

public class Solution {
    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1, 4}, experience = {2, 5};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));

    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience,
                                       int[] energy, int[] experience) {
        int enx = 0, exx = 0, cue = initialExperience;
        for (int i : energy) {
            initialEnergy -= i;
        }
        if (initialEnergy <= 0) {
            enx = -initialEnergy + 1;
        }
        for (int i : experience) {
            if (cue - i <= 0) {
                exx += i - cue + 1;
                cue += i - cue + 1;
            }
            cue += i;
        }
        return enx + exx;
    }
}
