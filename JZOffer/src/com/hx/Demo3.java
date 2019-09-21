package com.hx;

/**
 * @author jxlgcmh
 * @date 2019-08-11 18:10
 */
public class Demo3 {
    public static void main(String[] args) {
        /*String s ="hello boy";
        String replace = s.replace(" ", "%20");
        System.out.println(replace);*/
        String s = "hello boy";
        String result = replaceBlankToOther(s);
        System.out.println(result);
    }

    public static String replaceBlankToOther(String str) {
        StringBuffer sb = new StringBuffer(str);
        // 初始指针所在的位置
        int p1 = sb.length() - 1;
        // 统计空格,往字符串后面追加 2 个长度
        for (int i = 0; i < p1; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("   ");
            }
        }
        // 追加空格后指针所在的位置
        int p2 = sb.length() - 1;
        while (p1 > 0 && p2 > p1) {
            char c = sb.charAt(p1--);
            // 如果前指针匹配到了空格,就挨个替换
            if (c == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            }
            // 如果没有匹配到空格,就进行字符的后移操作
            else {
                sb.setCharAt(p2--, c);
            }
        }
        return sb.toString();
    }
}
