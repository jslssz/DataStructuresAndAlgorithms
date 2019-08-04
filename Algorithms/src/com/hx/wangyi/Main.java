package com.hx.wangyi;

/**
 * @author jxlgcmh
 * @date 2019-08-03 15:31
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> scores = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            scores.add(temp);
        }
        n = sc.nextInt();
        List<Integer> indexs = new ArrayList<>(n);
        for (int j = 0; j < n; j++) {
            int index = sc.nextInt();
            indexs.add(index);
        }
        for (int i = 0; i < scores.size(); i++) {
            int count =0;
            for (int j = 0; j < scores.size(); j++) {
                if (scores.get(i) > scores.get(j)+1) {
                    count++;
                }
            }

            DecimalFormat formatter1=new DecimalFormat("0.000000");
            String res = formatter1.format(count*100.0 / scores.size());
            System.out.println(res);
        }

    }
}
