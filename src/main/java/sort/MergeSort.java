package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-17-8:57
 * @Description: 归并排序
 */
public class MergeSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, len);
        if(len<2) return ints;
        int mid=len/2;
        int[] left=Arrays.copyOfRange(ints,0,mid);
        int[] right = Arrays.copyOfRange(ints, mid, len);
        return merge(sort(left),sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int llen=left.length,rlen=right.length;
        int[] result=new int[llen+rlen];
        int l=0,r=0,res=0;
        while(l<llen&&r<rlen){
            if(left[l]<right[r]){
                result[res++]=left[l++];
            }else{
                result[res++]=right[r++];
            }
        }
        for(;l<llen;l++){
                result[res++]=left[l++];
        }
        for(;r<rlen;r++){
                result[res++]=right[r++];
            }
        return result;
    }
}
