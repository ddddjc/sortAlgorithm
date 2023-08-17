package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-16-22:11
 * @Description: 选择排序
 */
public class SelectSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=0;i<ints.length-1;i++){
            int idex=i;
            for(int j=i;j<ints.length;j++){
                if (ints[j]<ints[idex]){
                    idex=j;
                }
            }
            int a=ints[i];
            ints[i]=ints[idex];
            ints[idex]=a;
        }
        return ints;
    }
}
