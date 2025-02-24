package No_2001_2500.No2080区间内查询数字的频率;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {

    private Map<Integer, List<int[]>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<int[]> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.isEmpty()) {
                int[] last = new int[]{i, i};
                list.add(last);
                map.put(arr[i], list);
                continue;
            }
            int[] last = list.get(list.size() - 1);
            if (i == last[1] + 1) {
                last[1] = i;
            } else {
                last = new int[]{i, i};
                list.add(last);
            }
        }
    }

    public int query(int left, int right, int value) {
        List<int[]> indexes = map.get(value);
        if (indexes == null || indexes.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int[] index : indexes) {
            count = count + (Math.max(Math.min(index[1], right) - Math.max(index[0], left) + 1, 0));
        }
        return count;
    }


}
