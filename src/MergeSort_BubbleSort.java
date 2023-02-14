import java.util.Random;

public class MergeSort_BubbleSort {
    public static void main(String[] args) throws Exception {
        int arrayLength = 1000;
        int[] array = createRandomArray(arrayLength);
         long start_time = System.currentTimeMillis() ;
        System.out.println("Bofore Bubble Sort: "+ isSorted(array));
        bubbleSort(array);
        long time_spent = System.currentTimeMillis() - start_time;
        System.out.println("Bubble sort time: " + time_spent + "ms\nIs sorted: " + isSorted(array));
        int[] array2 = createRandomArray(arrayLength);
        System.out.println("Bofore Merge Sort: "+ isSorted(array2));
        start_time = System.currentTimeMillis() ;
        mergeSort(array2);
        time_spent = System.currentTimeMillis()  - start_time;
        System.out.println("Merge Sort: "  + time_spent + "ms\nIs sorted: " + isSorted(array2));
        //System.out.println(System.currentTimeMillis());
    }
    public static void swap (int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void swap(int[] array, int n){
        for(int i =0; i < n; i ++){
            if (array[i] > array[i+1]){
                swap(array, i, i+1);
            }
        }
    }
    public static void bubbleSort(int[] array){
        for(int i= array.length -1 ; i >1; i --){
            for ( int j = 0; j < i;j++ ){
                if (array[j] > array[j+1]){
                    swap(array, j, j +1);
                }
            }
        }
    }
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++ ) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static int[] mergeArray(int[] a, int[]b){
        int[] c = new int [a.length + b.length];
        int i = 0, j = 0, k = 0;
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                c[k] =a[i];
                k++;
                i++;
            }else {
                c[k] =b[j];
                k++;
                j++;
        }
        }
        while(i < a.length){
            c[k] =a[i];
                k++;
                i++;
        }
        while( j < b.length){
            c[k] =b[j];
                k++;
                j++;
        }
        return c;
    }

    public static void mergeArray(int[] a , int start, int middle, int end){
        int[] c = new int[end - start];
        int i = start, j = middle, k = 0;
        while(i < middle && j < end){
            if(a[i] <= a[j]){
                c[k] = a[i];
                k++;
                i++;
            }else {
                c[k] = a[j];
                k++;
                j++;
            }
        }
        while (i < middle){
            c[k] = a[i];
                k++;
                i++;
        }
        while( j < end){
            c[k] = a[j];
                k++;
                j++;
        }
        for ( i=start;i  < end; i ++){
        a[i] = c[i - start];
        }
    }
    public static void mergeSort(int[] a, int start, int end){
        if (end - start <=1){
            return;
        }
        int middle = (start + end )/2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }
    public static void mergeSort(int[] a){
        mergeSort(a, 0, a.length);
    }
}
    