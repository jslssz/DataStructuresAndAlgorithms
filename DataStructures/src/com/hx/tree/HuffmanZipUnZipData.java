package com.hx.tree;

import javax.management.RuntimeOperationsException;
import java.io.Serializable;
import java.util.*;

/**
 * 通过Huffman编码来压缩和解压数据
 *
 * @author jxlgcmh
 * @date 2019-08-06 08:28
 */
public class HuffmanZipUnZipData {
    /**
     * huffmanCodes，stringBuilder 全局只有一份
     */
    static HashMap<Character, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String text = "i like like like java do you like a java";
        List<DataNode> dataNodeList = createDataNodeList(text);
        DataNode root = createHuffmanTree(dataNodeList);
        /*
        huffmanCodes
        { =01, a=100, d=11000, u=11001, e=1110, v=11011, i=101, y=11010, j=0010, k=1111, l=000, o=0011}
         */
        Map<Character, String> huffmanCodes = getHuffmanCode(root);
        /**
         * huffmanByteCodes 压缩后的结果，每八位一个
         * [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
         */
        byte[] zip = zip(text, huffmanCodes);

        char[] chars = unzip(zip, huffmanCodes);
        // i like like like java do you like a java
        System.out.println(new String(chars));
        // 至此，压缩解压缩完毕


    }

    /**
     * 解压缩
     *
     * @param huffmanByteCodes 编码后的字节数组
     * @param huffmanCodes 哈夫曼编码表
     * @return 解码后的字节数组
     */
    public static char[] unzip(byte[] huffmanByteCodes, Map<Character, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < huffmanByteCodes.length; i++) {
            byte b = huffmanByteCodes[i];
            // 如果是最后一个，则flag == true
            boolean flag = (i == huffmanByteCodes.length - 1);
            // 调用 (false,b)
            sb.append(byteToBitString(!flag,b));
        }
        // for 循环结束

        // 将Huffman编码的键值位置互换
        Map<String,Character> map = new HashMap<>();
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(),entry.getKey());
        }


        List<Character> characters =new ArrayList<>();
        // 注意循环条件
        for (int i = 0; i < sb.length(); ) {
            int count =1;
            boolean flag =true;
            Character b= null;
            while (flag) {
                String key = sb.substring(i, i + count);
                b=map.get(key);
                if (b == null) {
                    count++;
                }else {
                    flag =false;
                }
            }
            characters.add(b);
            i+=count;
        }
        // 循环结束
        char [] chars =new char[characters.size()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = characters.get(i);
        }
        return chars;
    }

    /**
     * 将byte转为bit
     * @param b byte
     * @param flag 标志
     * @return string
     */
    public static String byteToBitString(boolean flag,byte b) {
        int temp =b;
        if (flag) {
            temp |=256;
        }
        String str =Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
    /**
     *  将文本压缩为byte数组
     *
     * @param text 文本
     * @param huffmanCodes 哈夫曼编码
     * @return byte[]数组
     */
    public static byte[] zip(String text, Map<Character, String> huffmanCodes) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char item : chars) {
            if (huffmanCodes.containsKey(item)) {
                sb.append(huffmanCodes.get(item));
            }
        }
        // 返回结果：sb.toString()=101010001011....，将其转为byte数组
        int len;
        if (sb.length() % 8 == 0) {
            len = sb.length() / 8;
        } else {
            len = sb.length() / 8 + 1;
        }
        byte[] huffmanByteCodes = new byte[len];
        // 游标
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }
            // 转为二进制
            huffmanByteCodes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        return huffmanByteCodes;
    }

    /**
     * 重载获取Huffman编码的方法
     *
     * @param root
     */
    public static Map<Character, String> getHuffmanCode(DataNode root) {
        if (root == null) {
            System.out.println("哈夫曼树为空！");
            return null;
        }
        getHuffmanCode(root.left, "0", stringBuilder);
        getHuffmanCode(root.right, "1", stringBuilder);
        return huffmanCodes;
    }


    /**
     * 获取每个叶子节点的Huffman编码
     *
     * @param node 子节点
     * @param code 0 or 1
     * @param sb   用于字符创拼接
     */
    public static void getHuffmanCode(DataNode node, String code, StringBuilder sb) {
        StringBuilder stringBuilder = new StringBuilder(sb);
        stringBuilder.append(code);
        if (node != null) {
            if (node.data == null) {
                getHuffmanCode(node.left, "0", stringBuilder);
                getHuffmanCode(node.right, "1", stringBuilder);
            } else {
                huffmanCodes.put(node.data, stringBuilder.toString());
            }
        }
    }


    /**
     * 创建Huffman树
     *
     * @param dataNodeList 节点集合
     * @return
     */
    public static DataNode createHuffmanTree(List<DataNode> dataNodeList) {
        while (dataNodeList.size() > 1) {
            Collections.sort(dataNodeList);
            //System.out.println(dataNodeList);
            DataNode leftNode = dataNodeList.get(0);
            DataNode rightNode = dataNodeList.get(1);
            DataNode parent = new DataNode(null, leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;
            dataNodeList.remove(leftNode);
            dataNodeList.remove(rightNode);
            dataNodeList.add(parent);
        }
        return dataNodeList.get(0);
    }


    /**
     * 创建DataNodeList
     *
     * @param text 文本
     */
    public static List<DataNode> createDataNodeList(String text) {
        Map<Character, Integer> map = new HashMap<>();
        List<DataNode> dataNodeList = new ArrayList<>();
        /*
            将文本转成char型数组
         */
        char[] chars = text.toCharArray();
        /*
            出现的个数放入map之中去
         */
        for (char item : chars) {
            if (map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        /*
            遍历map,将其转为DataNodeList
         */
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            dataNodeList.add(new DataNode(entry.getKey(), entry.getValue()));
        }
        return dataNodeList;
    }

}

/**
 * 压缩数据节点
 */
class DataNode implements Comparable<DataNode> {
    /**
     * 出现了多少次
     */
    int val;
    /**
     * 数据是什么
     */
    Character data;
    /**
     * 左节点
     */
    DataNode left;
    /**
     * 右节点
     */
    DataNode right;

    public DataNode(Character data, int val) {
        this.data = data;
        this.val = val;
    }

    @Override
    public int compareTo(DataNode o) {
        return this.val - o.val;
    }

    @Override
    public String toString() {
        return "DataNode[" +
                data + ":" +
                val +
                ']';
    }
}