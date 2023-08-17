package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-17-9:28
 * @Description: 快速排序
 */
public class QuickSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(sourceArray,0,sourceArray.length-1);
    }
    public int[] quickSort(int[] arr,int left,int right){
        if(left<right){
            int idex=partition(arr,left,right);
            quickSort(arr,left,idex-1);
            quickSort(arr,idex+1,right);
        }
        return arr;
    }
    public int partition(int[] arr,int left,int right){
        //设置基准值
        int pivot=left;
        int idex=pivot+1;
        for(int i=idex;i<=right;i++){
            if (arr[i]<arr[pivot]){
                int a=arr[i];
                arr[i]=arr[idex];
                arr[idex]=a;
                idex++;//只在出现小于的时候++，这样idex左边的都小于它，右边的都大于它。
            }
        }
        //把基准与最后那个小于他的换位
        int a=arr[idex-1];
        arr[idex-1]=arr[pivot];
        arr[pivot]=a;
        return idex-1;
    }
}
