package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-16-21:22
 * @Description: 冒泡排序
 */
public class DoubbleSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        //进行拷贝，不改变参数内容
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=0;i<len-1;i++){
            //判断是否进行了排序，若无，则说明有序，直接返回
            boolean flag=true;
            for (int j=0;j<len-i-1;j++){
                if(ints[j]>ints[j+1]){
                    flag=false;
                    int a=ints[j];
                    ints[j]=ints[j+1];
                    ints[j+1]=a;
                }
            }
            if(flag) return ints;
        }
        return ints;
    }
}
