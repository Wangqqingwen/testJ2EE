package array;

public class FindMax {
    public static void main(String[] args) {
        int arrs[] = new int[10];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = (int) (Math.random() * 10);
        }
        for (int arr :
                arrs) {
            System.out.print(arr + " ");
        }
        System.out.println();
        System.out.println("-----------");

        //用foreach找出最大的数
        int max = 0;
        for (int arr :
                arrs) {
            if (arr > max) {
                max = arr;
            }
        }
        System.out.println(max);
    }
}
