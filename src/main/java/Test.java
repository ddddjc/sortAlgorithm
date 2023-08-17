import data.Data;
import sort.*;

/**
 * @Author: djc
 * @Date: 2023-08-16-21:11
 * @Description:
 */
public class Test {
    /**
     * 封装的测试方法
     * @param num
     * @param iArraySorty
     */
    public void test(int num, IArraySorty iArraySorty){
        long l = System.currentTimeMillis();
//        System.out.println("当前时间为："+l+"ms");
        int[] data = Data.getData(num);
        int[] sort = iArraySorty.sort(data);
        System.out.println(Data.success(sort));
        Data.printArray(data);
        Data.printArray(sort);
        long l1 = System.currentTimeMillis();
//        System.out.println("结束时间为："+l1);
        System.out.println("\n"+iArraySorty.getClass()+"的运行时间为："+(l1-l)+"ms");
    }

    /**
     * 通过数量，最大值获取
     * @param num
     * @param max
     * @param iArraySorty
     */
    public void test(int num,int max, IArraySorty iArraySorty){
        long l = System.currentTimeMillis();
//        System.out.println("当前时间为："+l+"ms");
        int[] data = Data.getData(num,max);
        int[] sort = iArraySorty.sort(data);
        System.out.println(Data.success(sort));
        Data.printArray(data);
        System.out.println("---------------------------------------------------------------------------------");
        Data.printArray(sort);
        long l1 = System.currentTimeMillis();
//        System.out.println("结束时间为："+l1);
        System.out.println("\n"+iArraySorty.getClass()+"的运行时间为："+(l1-l)+"ms");
    }

    public void test(IArraySorty iArraySorty){
        long l = System.currentTimeMillis();
//        System.out.println("当前时间为："+l);
        int[] data = Data.getData();
        int[] sort = iArraySorty.sort(data);
        System.out.println(Data.success(sort));
//        data.Data.printArray(sort);
        long l1 = System.currentTimeMillis();
//        System.out.println("结束时间为："+l1);
        System.out.println("\n"+iArraySorty.getClass()+"的运行时间为："+(l1-l)+"ms");
    }
    @org.junit.jupiter.api.Test
    public void t1(){
        test(new SelectSort());
    }
    @org.junit.jupiter.api.Test
    public void t2(){
        test(new DoubbleSort());
    }
    @org.junit.jupiter.api.Test
    public void t3(){
        test(new InsertionSort());
    }
    @org.junit.jupiter.api.Test
    public void t4(){
        test(new ShellSort());
    }
    @org.junit.jupiter.api.Test
    public void t5(){
        test(new ShellSort());
    }
    @org.junit.jupiter.api.Test
    public void t6(){
        test(new QuickSort());
    }
    @org.junit.jupiter.api.Test
    public void t7(){
        test(new HeapSort());
    }
    @org.junit.jupiter.api.Test
    public void t8(){
        test(new CountingSort());
    }
    @org.junit.jupiter.api.Test
    public void t9(){
        test(new BucketSort());
    }
    @org.junit.jupiter.api.Test
    public void t10(){
        test(20,20,new RadixSort());
    }
}
