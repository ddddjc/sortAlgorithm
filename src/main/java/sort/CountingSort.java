package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-17-11:10
 * @Description: 计数排序
 */
public class CountingSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, len);
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min=Math.min(min,ints[i]);
            max=Math.max(max,ints[i]);
        }
        int[] nums=new int[max-min+1];
        for(int i=0;i<len;i++){
            nums[ints[i]-min]++;
        }
        int idex=0;
        for (int i = 0; i <=max-min;) {
            if(nums[i]>0){
                ints[idex++]=i+min;
                nums[i]--;
            }else i++;
        }
        return ints;
    }
}
