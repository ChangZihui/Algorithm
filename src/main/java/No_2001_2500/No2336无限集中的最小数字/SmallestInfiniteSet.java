package No_2001_2500.No2336无限集中的最小数字;

import java.util.ArrayList;
import java.util.List;

public class SmallestInfiniteSet {

    //无限集的最小值，表示整个无限集
    int InfinityMin;

    //全局的最小值
    int GlobleMin;

    //addback添加的数字，表示有限集
    List<Integer> list;

    public SmallestInfiniteSet() {
        this.InfinityMin = 1;
        this.GlobleMin = 1;
        this.list = new ArrayList<>(1350);
    }

    public int popSmallest() {
        if (this.list.size() == 0) {
            this.InfinityMin++;
            this.GlobleMin++;
            return this.GlobleMin - 1;
        } else {
//            if (GlobleMin!=InfinityMin){
            //一定是在有限集中
            int result = GlobleMin;
            this.list.remove((Integer) GlobleMin);
            if (!this.list.isEmpty()) {
                this.list.sort(Integer::compareTo);
                this.GlobleMin = this.list.get(0);
            } else {
                this.GlobleMin = this.InfinityMin;
            }
            return result;
//            }
        }
    }

    public void addBack(int num) {
        if (num < this.InfinityMin) {
            if (this.list.contains(num)) {
                return;
            }
            this.list.add(num);
            if (num < this.GlobleMin) {
                this.GlobleMin = num;
            }
        }
    }
}