package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-08-17-14:49
 * @Description: 基数排序
 */
public class RadixSort implements IArraySorty{

    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, len);
        int max = getMax(sourceArray),exp=1;//确定比较位数
        while (max!=0){
            CountSort(ints,len,exp);
            max=max/10;
            exp*=10;
        }
        return ints;
    }
    public int getMax(int[] ints){
        int max=Integer.MIN_VALUE;
        for (int i:ints){
            max=Math.max(max,ints[i]);
        }
        return max;
    }
    public void CountSort(int nums[],int len,int exp){
        List<Integer>[] lists=new List[10];         //按为排序
        for (int i=0;i<10;i++){
            lists[i]=new LinkedList<>();
        }
        for (int i = 0; i < len; i++) {
            lists[(nums[i]/exp)%10].add(nums[i]);
        }
        int idex=0;
        for (List<Integer> l:lists){
            if (l!=null){
                for(int i:l){
                    nums[idex++]=i;
                }
            }
        }
    }
}
