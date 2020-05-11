//David Nygren
//4/23/2020

//This class implements three different sorting methods with an integer array
public class Sort
{
    //Bubble sort goes through the array one by one and swaps integers based on comparison to previous/next
    public static int[] bubbleSort(int[] array){
        boolean check = false;
        if (array.length < 20)check = true;

        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]) 
                { 
                    //creating a temp integer to swap values
                    int temp = array[j]; 
                    array[j] = array[j+1]; 
                    array[j+1] = temp; 
                } 
            }
            if (check == true && i<array.length-2)retArray(array);
        }
        return array;
    }
    //Insertion sort traverses the array and finds the smallest value and then swaps it in front
    public static int[] insertionSort(int[]array){
        boolean check = false;
        if (array.length < 20)check = true;

        for (int i = 1; i < array.length; ++i) { 
            int k = array[i]; 
            int q = i - 1; 
            while (q >= 0 && array[q] > k) { 
                array[q + 1] = array[q]; 
                q -= 1; 
            } 
            array[q + 1] = k; 
            //If there's less than 20 values, it'll print out the iterations one by one
            if (check == true )retArray(array);
        } 
        return array;
    }

    //This method implements Merge sort and sorts the sub arrays
    public static int[] mergeSort(int[] array){
        int left = 0;
        int right = array.length - 1;

        if (left < right){
            int m = left+(right-left)/2; 
            int[] l = new int[m+1-left];
            int[] r = new int[right-m];            
            for(int i = left; i<=m; i++){
                l[i] = array[i];
            }
            int index = 0;
            for(int i = m+1; i<=right; i++){
                r[index] = array[i];
                index++;
            }
            // Sort left and right half arrays
            mergeSort(l); 
            mergeSort(r); 

            merge(array, l, r); 
        }
        return array;
    }

    //This method continues on merge Sort and combines the left and right subarray back into the original array
    static void merge(int[]array, int[] leftA, int[] rightA){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftA.length && j < rightA.length) 
        { 
            if (leftA[i] <= rightA[j]) 
            { 
                array[k] = leftA[i]; 
                i++; 
            } 
            else
            { 
                array[k] = rightA[j]; 
                j++; 
            } 
            k++; 
        } 
        //Finish combining the last elements from the subarrays
        while (i < leftA.length) 
        { 
            array[k] = leftA[i]; 
            i++; 
            k++; 
        } 
        while (j < rightA.length) 
        { 
            array[k] = rightA[j]; 
            j++; 
            k++; 
        } 
    }

    //This is a method more for ease; returns the array input in the parameters
    public static void retArray(int[] array){
        for (int i=0; i<array.length; ++i) 
            System.out.print(array[i] + " "); 
        System.out.println(); 
    }
}
