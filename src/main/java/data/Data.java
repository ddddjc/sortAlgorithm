package data;

import java.util.Random;

/**
 * @Author: djc
 * @Date: 2023-08-16-21:12
 * @Description: 数据工具类
 */
public class Data {

    /**
     * 生成指定数量长度数组
     * @param n
     * @return
     */
    public static int[] getData(int n) {
        int[] data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(DataConstant.DATA_MAX_VALUE);
        }
        return data;
    }

    public static int[] getData(int n,int max) {
        int[] data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(max);
        }
        return data;
    }
    /**
     * 生成配置中数量长度数组
     * @return
     */
    public static int[] getData() {
        int n=DataConstant.DATA_NUM;
        int[] data = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(DataConstant.DATA_MAX_VALUE);
        }
        return data;
    }

    /**
     * 打印数组
     * @param ints
     */
    public static void printArray(int[] ints) {
        int len = ints.length;
        for (int i = 0; i < len; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    /**
     * 判断是否有序
     * @param ints
     * @return
     */
    public static boolean success(int[] ints) {
        int len = ints.length;
        boolean flag = true;
        for (int i = 0; i < len - 1; i++) {
            if (ints[i] > ints[i + 1]) flag = false;
        }
        return flag;
    }
}
