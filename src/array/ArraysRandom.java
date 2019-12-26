package array;

public class ArraysRandom {
    public static void main(String[] args) {
        int arrs[] = new int[9];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = (int) (Math.random() * 10);
        }
        for (int arr :
                arrs) {
            System.out.print(arr + " ");
        }
        System.out.println("---------");

        //数组反转
        /*for(int j = arrs.length-1;j>= arrs.length/2;j--){
            int temp = arrs[j];
            arrs[j] = arrs[arrs.length-1-j];
            arrs[arrs.length-1-j] = temp;
        }*/
        for (int i = 0, j = arrs.length - 1; j >= arrs.length / 2; i++, j--) {
            int temp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = temp;
        }
        for (int arr :
                arrs) {
            System.out.print(arr + " ");
        }
        System.out.println("---------");
    }
}
