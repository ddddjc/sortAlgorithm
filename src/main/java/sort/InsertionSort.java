package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-16-22:22
 * @Description: 插入排序
 */
public class InsertionSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=1;i<len;i++){
            int num=ints[i];
            int j=i;
            while(j>0&&num<ints[j-1]){
                ints[j]=ints[j-1];
                j--;
            }
            if(j!=i){
                ints[j]=num;
            }
        }
        return ints;
    }
}
