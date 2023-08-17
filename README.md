# 十大经典排序算法

排序算法可以分为内部排序和外部排序，内部排序是记录在内存中进行排序，而外部排序是因排序的数据很大，一次不能容纳全部的排序记录，在排序过程中需要访问外存。常见的内部排序算法有：插入排序、希尔排序、选择排序、冒泡排序、归并排序、快速排序、 堆排序、基数排序等。

![image-20230816210330533](https://cdn.jsdelivr.net/gh/mydy930657303/djcPicture@master/202308162103590.png)

![image-20230816210352806](https://cdn.jsdelivr.net/gh/mydy930657303/djcPicture@master/202308162103848.png)

关于时间复杂度

平方阶 (O(n2)) 排序 各类简单排序：直接插入、直接选择和冒泡排序。

线性对数阶 (O(nlog2n)) 排序 快速排序、堆排序和归并排序；

O(n1+§)) 排序，§ 是介于 0 和 1 之间的常数。 希尔排序

线性阶 (O(n)) 排序 基数排序，此外还有桶、箱排序。

关于稳定性

稳定的排序算法：冒泡排序、插入排序、归并排序和基数排序。

不是稳定的排序算法：选择排序、快速排序、希尔排序、堆排序。

名词解释：

- n：数据规模
- k："桶"的个数
- In-place：占用常数内存，不占用额外内存
- Out-place：占用额外内存
- 稳定性：排序后 2 个相等键值的顺序和排序之前它们的顺序相同



## 1、冒泡排序

[冒泡排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/DoubbleSort.java)

冒泡排序的思想就是从底开始往上排序，相邻的两个如果排序错误，则交换过来。经过多次交换，最大那个数`冒泡到顶部`

下次仍然从头开始，这样每次排序随都会把循环内最大那个数冒泡到上面，经过n`次循环的循环`，到达顶部就排序完成。

代码：

```java
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
```



## 2、选择排序

[选择排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/SelectSort.java)

选择排序无论什么数据进去都是O(n^2)的时间复杂度，用到它时数据规模小越小越好。

算法步骤：

- 在整个数组中找到最小（大）元素，存放到排序序列的起始位置
- 在从剩余元素中找到最值，存放到第二个位置……

```java
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
```

## 3、插入排序

[插入排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/InsertionSort.java)

从头到尾扫描每一个元素，把元素插入到合适的位置。

```JAVA
public class insertionSort implements IArraySorty{
    @Override
    public int[] sort(int[] sourceArray) {
        int len=sourceArray.length;
        int[] ints = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=1;i<len;i++){
            int num=ints[i];
            int j=i;
            while(j>0&&num<ints[j-1]){ //比较的是前一个数，所以不需要等于0
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
```



## 4、希尔排序

[希尔排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/ShellSort.java)

希尔排序也称为递减增量排序，是插入排序的一种更高效的改进版本。但希尔排序是非稳定的排序算法。

希尔排序是基于插入排序以下两点性质

- 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
- 但插入排序一般来说是低效的，因为插入排序每次只能移动数据一次

希尔排序的思想是：先将这个待排序列分割成若干子序列**（间隔为增量的子序列）**分别进行直接插入排序，待整个序列中觉得记录“基本有序”时，再对全体记录进行依次直接插入排序。

**步骤：**

- 选择一个增量序列t1,t2,t3.....tk，其中ti>tj,tk=1;
- 按增量序列个数k，对序列进行k趟排序
- 每趟排序，根据对应的增量ti，将待排序列分割成长度为m的子序列，分别对个子表进行直接插入排序。仅曾量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度

```java
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
```

## 5、归并排序

[归并排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/MergeSort.java)

主要思想是分治的方法，递归调用，划分区域，直到每块区域大小为一，后在上层的递归调用中合并到一起，就得到有序地小区域，然后上层继续合并。

```java
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
```

## 6、快速排序

[快速排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/QuickSort.java)

快排的思想主要利用了分治策略，选择一个基准，递归中范围内的数据中，小于它的放到它的前面。大于它的放到它的后面，递归实现到最后排序成功。

```java
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
```

## 7、堆排序

[堆排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/HeapSort.java)

主要利用了数据结构：堆的特性（某个节点的值总是小于或等于根节点的值，是一颗完全二叉树）

> 堆的定义如下：n个元素的序列{k1,k2,ki,…,kn}当且仅当满足下关系时，称之为堆。
>
> (ki <= k2i,ki <= k2i+1)或者(ki >= k2i,ki >= k2i+1), (i = 1,2,3,4...n/2)
>
> 将根节点最大的堆叫做最大堆或大根堆，根节点最小的堆叫做最小堆或小根堆。常见的堆有二叉堆、斐波那契堆等。



![imags](https://img-blog.csdnimg.cn/20190611232646539.gif)

堆排序通过维护一个堆，每次取堆顶的节点放置在数组最后，然后令长度减一，然后调整堆，达到排序的效果。

```java
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
```



## 8、计数排序

[计数排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/CountingSort.java)

主要思想是把排序对象放到容量只够的数组中，统计每个数出现的次数，后遍历新数组，达到排序目的。

```java
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
```

## 9、桶排序

[桶排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/BucketSort.java)

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否在于这个映射函数的确定。为了使排序更加高效，我们需要做到这两点：

1. 在额外空间充足的情况下，尽量增大桶的数量
2. 使用的映射函数能够将输入的N个数据均匀分布到K个桶中，第i各个桶中的每一个数据都都要比第i-1个桶中所有数据大。

同时，对于桶中元素的排序，选择何种比较排序算法对于性能的影响至关重要。



桶排序的平均时间复杂度为线性的O（N+C），其中C=N*(logN-logM)。如果对于相同的N，同数量M越大，最好的时间复杂度达到O（N)。当桶排序的空间复杂度为O（N+M），如果输入的数据非常庞大，而桶的数量也非常多，则空间代价无疑是昂贵的。

> 最快的情况：
>
> - 输入的数据可以均匀地分配到每一个桶中
>
> 最慢的情况：
>
> - 输入的数据被分配到同一个桶中

```java
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
```



## 10、基数排序

[基数排序](https://github.com/mydy930657303/sortAlgorithm/blob/master/src/main/java/sort/RadixSort.java)

主要思想是：从个位到最高位，每次排序比较位数所在的值，后依次存到一个桶中，再取出，按高一位的值比较，往复循环，找到最大的数的最高位比较晚，则排序完好。

![](https://img-blog.csdnimg.cn/20190611232645793.gif)



```java
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

```





> 参考：
>
> [1.0 十大经典排序算法 | 菜鸟教程 (runoob.com)](https://www.runoob.com/w3cnote/ten-sorting-algorithm.html)
>
> [十大经典排序算法(C++、Java实现)动图演示及代码解析-冒泡排序、选择排序、插入排序、快速排序、堆排序、希尔排序、归并排序、计数排序、桶排序、基数排序_OH,CGWLMXUP的博客-CSDN博客](https://blog.csdn.net/xiaomucgwlmx/article/details/82589626)
