package lin.java.test.algorithms.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Integer capacity;

    public LruCache(int capacity) {
        this.map = new HashMap<>();
        list = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            list.remove(new Integer(key));
            list.add(key);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.put(key, value);
            return;
        }
        if (map.size() == capacity) {
            Integer first = list.get(0);
            map.remove(key);
            list.remove(first);
        }
        list.add(key);
        map.put(key, value);
    }
}
