package com.hx.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jxlgcmh
 * @date 2019-08-03 16:05
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> itemList =new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            List<Integer> items = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                int temp = sc.nextInt();
                items.add(temp);
            }
            itemList.add(items);
        }
        for (List<Integer> items : itemList) {
            if (items.get(0) > items.get(1) + items.get(items.size()-1)) {
                System.out.println("NO");
                return;
            }
            if (items.get(items.size()-1) > items.get(0) + items.get(items.size()-2)) {
                System.out.println("NO");
                return;
            }
            for (int i = 1; i < items.size()-2; i++) {
                if (items.get(i) > items.get(i-1) + items.get(i+1)) {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }

    }
}
