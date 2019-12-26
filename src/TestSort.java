public class TestSort {
    public static void main(String[] args) {
        int[] arrs = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(arrs.length);
        /*for (int i=0;i<arrs.length;i++){
            arrs[i]=(int)(Math.random()*10);
        }*/

        for (int arr:
             arrs) {
            System.out.print(arr+" ");
        }
        System.out.println();
        buttleSort(arrs);
        //selectSort(arrs);
        for (int arr:
                arrs) {
            System.out.print(arr+" ");
        }
    }

    //冒泡
    public static void buttleSort(int[] arrs){
        for(int i=0;i<arrs.length-1;i++){
            for(int j=0;j<arrs.length-1-i;j++){
                if (arrs[j]<arrs[j+1]){
                    int temp = arrs[j];
                    arrs[j] = arrs[j+1];
                    arrs[j+1] = temp;
                }
            }
        }
    }

    //选择(从大到小)
    public static void selectSort(int[] arrs){
        for (int i = 0;i<arrs.length;i++){
            for (int j=i+1;j<arrs.length;j++){
                if (arrs[i]<arrs[j]){
                    int temp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = temp;
                }
            }
        }
    }


}
