package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-17-7:57
 * @Description: 希尔排序
 */
public class ShellSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, length);
        int temp;
        for (int step = length/2; step >=1; step/=2) { //设置每次步长减半
            for (int i = step; i < length; i++) {
                temp=ints[i];
                int j=i-step;
                while(j>=0&&ints[j]>temp){ //比较的是j当先所表示的数，所以可以到0
                    ints[j+step]=ints[j];
                    j-=step;
                }
                ints[j+step]=temp;
            }
        }
        return ints;
    }
}
