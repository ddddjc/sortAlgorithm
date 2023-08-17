package sort;

import java.util.Arrays;

/**
 * @Author: djc
 * @Date: 2023-08-17-10:34
 * @Description: 堆排序
 */
public class HeapSort implements IArraySorty {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = ints.length;
        buildMaxHeap(ints, len); //构建堆
        for (int i = len-1; i > 0; i--) { //又堆的特性，根节点最大，把根节点放后面，然后令长度减一，重新排序，又可得到根节点最大的堆。
            int a = ints[0];
            ints[0] = ints[i];
            ints[i] = a;
            len--;
            heapify(ints, 0, len);
        }
        return ints;
    }

    private void heapify(int[] ints, int i, int len) {//堆调整
        int left = 2 * i + 1;    //左子树节点
        int right = 2 * i + 2;   //又子树节点
        int largest = i;         //寻找最大数节点
        if (left < len && ints[left] > ints[largest]) {
            largest = left;
        }
        if (right < len && ints[right] > ints[largest]) {
            largest = right;
        }
        if (largest != i) { //最大节点不是父节点，则交换。
            int a = ints[i];
            ints[i] = ints[largest];
            ints[largest] = a;
            heapify(ints, largest, len);//递归，每次都是使父节点最大，循环中i逐渐减少，等价于树的层数之间上升，多次递归后，小值的节点下降，使所有根节点大于子节点。
        }
    }

    private void buildMaxHeap(int[] ints, int len) { //建立堆
        for (int i = len / 2; i >= 0; i--) {
            heapify(ints, i, len);
        }
    }
}
