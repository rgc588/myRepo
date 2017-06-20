package com.chengong.algorithm.leetcode;

import java.util.*;

/**
 * Created by cheng on 6/4/2017.
 */
public class _380_M_InsertDeleteGetRandom {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int index = 0;
    Random ran = new Random();

    /** Initialize your data structure here. */
    public _380_M_InsertDeleteGetRandom() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, index);
            if (index < list.size()) {
                list.set(index, val);
            } else {
                list.add(val);
            }
            index++;
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int i = map.get(val);
            map.remove(val);
            list.set(i, list.get(--index));
            map.put(list.get(i), i);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = ran.nextInt(index);
        return list.get(i);
    }

    public static void main(String[] args) {
        Random ran = new Random();
        String[] command = new String[] {"RandomizedSet","insert","insert","remove","insert","remove","getRandom"};
        Integer[] value = new Integer[] {-1,0,1,0,2,1,-1};
        _380_M_InsertDeleteGetRandom sol = new _380_M_InsertDeleteGetRandom();
        for (int i = 0; i < command.length; i++) {
            String c = command[i];
            int v = value[i];
            if (c.equals("insert")) {
                sol.insert(v);
            } else if (c.equals("remove")) {
                sol.remove(v);
            } else if (c.equals("getRandom")) {
                sol.getRandom();
            }
        }
    }
}
