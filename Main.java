/*Group members:
* Ahmed Al-Dulaijan 201701214
* Majed Al-Gahtani 202002370
* Abdullah Al-Qahtani 201901895
* */


import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {


    public static int[] arrayGenerator (int n){
        Random rd = new Random();
        int[] myArray = new int[n];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i]= rd.nextInt(200);
        }
        return myArray;
    }

    public static void insertionSort(int arr[],int p, int r)//modify
    {
//        System.out.println("got");
//        printArrayRestricted(arr,p,r);


        int length = 0;
        int index = 0;

        length = r-p+1;
        index = p;

        int i, key, j;
        i=0; key=0; j=0;

        for (i = index+1; i < r+1; i++) {
            key = arr[i];
            j = i - 1;

            while (j >= index && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

//        System.out.println("delivered");
//        printArrayRestricted(arr,p,r);

    }

    //printer functions
    public static void printArray(int[]a){
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void printArrayRestricted(int[]a,int p, int r){
        System.out.print("[");
        for (int i = p; i <= r; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println("]");
    }

    //merge function.
    public static void merge(int[]a,int p, int q, int r){

        int ln = q-p+1; //since q is part of p
        int rn = r-q; //since q is not part of p
        int fullSize = r-p+1; //the size of a completed array

        int[] L = new int[ln+1]; //+1 reserves a space for our constant INF
        int[] R = new int[rn+1];


        int lPointer = p; //initialize pointer to start of left
        int rPointer = q+1; //initialize pointer to start of right

        //populating each array
        for (int i = 0; i < L.length-1; i++) { //populate L
            L[i]=a[lPointer++];
        }

        for (int i = 0; i < R.length-1; i++) { //populate L
            R[i]=a[rPointer++];
        }

        L[L.length-1]=Integer.MAX_VALUE;
        R[R.length-1]=Integer.MAX_VALUE;


        int i = 0,j = 0;
        int portionPointer = p;

        for (int k = 0; k < fullSize ; k++){ //be sure that we do not go into restricted areas of array

            if (L[i]<=R[j]){
                a[p]=L[i++];
                p++;
            }

            else {
                a[p]=R[j++];
                p++;

            }
        }

    }

    public static void mergeSort(int[]array,int p,int r, int s){

        if (p<r){

            int n = r-p+1;

            if (n>s){
                int q = (p+r) / 2;
                mergeSort(array, p, q,s);//needs its own break condition
                mergeSort(array, q+1, r,s);//needs its own break condition
                merge(array,p,q,r);
//                System.out.println("mergesort has been used");
            }
            else if (n<=s){
                insertionSort(array,p,r);
//                System.out.println("insertion sort has been used");


            }

        }



    }


    public static void main(String[] args) {
        int max = 20000000;//will temporarily change
        int s;
        s=1;



        for (int i = 0; i < 100 ; i++) {
            int[] a = arrayGenerator(max);
            int p = 0;
            int r = a.length-1;
            int q = r+p/2;


            Instant start = Instant.now();

            mergeSort(a,p,r,s);

            Instant end = Instant.now();

            System.out.println("The Time for S = "+s+" is: ");
            System.out.println(Duration.between(start,end));

            s+=10;

        }










    }
}