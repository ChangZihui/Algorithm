package No_201_400.No380时间插入删除和获取随机元素;

import java.util.*;

public class RandomizedSet {

    private List<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random = new Random();

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        Integer index = map.get(val);
        if (index == null) {
            list.add(val);
            map.put(val, list.size() - 1);
        } else {
            return false;
        }
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null) return false;
        if (list.size() > 1) {
            Integer end = list.get(list.size() - 1);
            list.set(index, end);
            list.remove(list.size() - 1);
            map.remove(val);
            map.put(end, index);
        } else {
            list.remove(val);
            map.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
