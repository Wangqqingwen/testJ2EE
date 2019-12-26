package array;

public class TwoDimensionalArrays {
    public static void main(String[] args) {
        //定义一个5X5的二维数组。 然后使用随机数填充该二维数组。
        int[][] arrs = new int[5][5];
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[0].length; j++) {
                arrs[i][j] = (int) (Math.random() * 100);
            }
        }

        for (int i = 0; i < arrs.length; i++) {
            for (int arr :
                    arrs[i]) {
                System.out.print(arr + " ");
            }
            System.out.println();
        }
        //找出这个二维数组里，最大的那个值，并打印出其二维坐标
        findMax(arrs);
    }

    public static void findMax(int[][] arrs) {
        int max = 0;
        int m = 0;
        int n = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                if (max < arrs[i][j]) {
                    max = arrs[i][j];
                    m = i;
                    n = j;
                }
            }
        }
        System.out.println("最大的数是：" + max);
        System.out.println("对应数组中的：arrs[" + m + "]" + "[" + n + "]");
    }
}
