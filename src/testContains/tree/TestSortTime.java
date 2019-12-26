package testContains.tree;

import testContains.Node;

import java.util.Arrays;
import java.util.List;

public class TestSortTime {
    public static void main(String[] args) {
        //创建4万个随机数，然后用分别用冒泡法，选择法，二叉树3种排序算法进行排序，比较哪种更快
        int[] arr = foundRandom();

        // 从初始化了的随机数组复制过来，以保证，每一种排序算法的目标数组，都是一样的
        int[] use4sort;

        use4sort = Arrays.copyOf(arr, arr.length);
        int[] sortedNumbersBySelection = performance(new SelectSort(use4sort), "选择法");

        use4sort = Arrays.copyOf(arr, arr.length);
        int[] sortedNumbersByBubbling = performance(new ButtleSort(use4sort), "冒泡法");

        use4sort = Arrays.copyOf(arr, arr.length);
        int[] sortedNumbersByTree = performance(new TreeSort(use4sort), "二叉树");

        System.out.println("查看排序结果，是否是不同的数组对象");
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersByTree);

        System.out.println("查看排序结果，内容是否相同");
        System.out.println("比较 选择法 和 冒泡法  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByBubbling));
        System.out.println("比较 选择法 和 二叉树  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByTree));


    }

    //计算时间
    private static int[] performance(Sort algorithm, String type) {
        long start = System.currentTimeMillis();
        algorithm.sort();
        int sortedNumbers[] = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("%s排序，一共耗时 %d 毫秒%n", type, end - start);
        return sortedNumbers;
    }

    private static int[] foundRandom() {
        int[] arr = new int[40000];
        for (int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*10000);
        }
        return arr;
    }

    interface Sort{
        void sort();//排序方法
        int[] values();//返回排序的数组
    }

    static class ButtleSort implements Sort{

        int[] arr;
        ButtleSort(int[] arr){
            this.arr = arr;
        }

        @Override
        public void sort() {
            for (int i=0;i<arr.length-1;i++){
                for (int j=0;j<arr.length-i-1;j++){
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            return arr;
        }
    }



    static class SelectSort implements Sort{

        int[] arr;
        SelectSort(int[] arr){
            this.arr = arr;
        }

        @Override
        public void sort() {
            for (int i=0;i<arr.length;i++){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            return arr;
        }
    }


    //你用来排序的数组要保证不能被其他算法排过序，否则再用二树杈算法超过一定数量就会栈溢出。
    // 用来排序的数组都要用一个中间变量保存后在排序
    static class TreeSort implements Sort{

        int[] arr;
        Node roots;
        TreeSort(int[] arr){
            this.arr = arr;
            roots = new Node();
        }

        @Override
        public void sort() {

            long start = System.currentTimeMillis();
            for (int num :
                    arr) {
                roots.add(num);
            }
            long end = System.currentTimeMillis();
            System.out.printf("二叉数排序创建耗时 %d 毫秒%n", end - start);

        }

        @Override
        public int[] values() {
            List<Object> list = roots.values1();
            int[] lastArr = new int[list.size()];
            for (int i = 0;i<lastArr.length;i++){
                lastArr[i]=Integer.parseInt(list.get(i).toString());
            }
            return lastArr;
        }
    }

}
