package sort;

import data.DataConstant;

import java.util.*;

/**
 * @Author: djc
 * @Date: 2023-08-17-11:56
 * @Description: 桶排序
 */
public class BucketSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int length = sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, length);
        int bucketNums= DataConstant.BUCKET_NUM;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            max=Math.max(max,ints[i]);
            min=Math.min(min,ints[i]);
        }
        int count=(max-min)/bucketNums+1; //计算映射方法，使数据分配到桶里
        List<List<Integer>> buckets =new ArrayList<>();
        for (int i = 0; i < bucketNums; i++) {
            buckets.add(new LinkedList<>());
        }
        for (int i = 0; i < length; i++) {
            buckets.get(ints[i]/count).add(ints[i]);
        }
        for (int i = 0; i < bucketNums; i++) {
            if(!buckets.get(i).isEmpty()){
                Collections.sort(buckets.get(i));
            }
        }
        int idex=0;
        for (List<Integer> list:buckets){
            for(int data:list){
                ints[idex++]=data;
            }
        }
        return ints;
    }
}
