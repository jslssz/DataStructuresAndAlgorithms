package com.hx.tree;

import com.hx.util.ReflectUtilForTreeMap;

import java.util.TreeMap;

/**
 * @author jxlgcmh
 * @date 2019-08-08 14:58
 */
public class RedBlackTreeDemo {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer,Integer> treeMap =new TreeMap<>();
        treeMap.put(1,5);
        treeMap.put(3,4);
        treeMap.put(2,6);
        treeMap.put(11,55);
        treeMap.put(22,66);
        treeMap.put(33,44);
        ReflectUtilForTreeMap.levelOrderPrintTree(treeMap);

    }
}
