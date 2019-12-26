package array;

public class TestSort {
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
        //选择正排
        selectSort(arrs);

        for (int arr:
             arrs) {
            System.out.print(arr+" ");
        }
        System.out.println();
        System.out.println("------------");
        //冒泡倒排
        buttleSort(arrs);
        for (int arr:
                arrs) {
            System.out.print(arr+" ");
        }
    }

    public static void buttleSort(int[] arrs) {
        for (int i = 0; i < arrs.length - 1; i++) {
            for (int j = 0; j < arrs.length - 1 - i; j++) {
                if (arrs[j] < arrs[j + 1]) {
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    int temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }


}
