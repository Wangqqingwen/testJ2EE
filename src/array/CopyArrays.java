package array;

public class CopyArrays {
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
        int arrsB[] = new int[8];
        System.arraycopy(arrs,1,arrsB,0,8);
        for (int arr :
                arrsB) {
            System.out.print(arr + " ");
        }
    }
}
