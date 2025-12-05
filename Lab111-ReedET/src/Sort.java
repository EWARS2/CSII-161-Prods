
// Arrays is not allowed to be used, with the exception of Code Fragment 12.2
import java.util.Arrays;

/**
 * Lab111
 *
 * Various sorting algorithms
 *
 * @author Ethan T. Reed
 * @version 2025/12/5
 */
public class Sort {

    /**
     * A generic, stable, brute force bubble sort that just uses a pair of
     * nested loops.
     *
     * @param <E>
     * @param array
     * @param comp
     */
    public static <E> void simpleBubbleSort(E[] array, Comparator<E> comp) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * A generic, stable, brute force bubble sort that just uses a pair of
     * nested loops. Enhanced feature stops the sort as soon as it knows the
     * list is sorted, and only sorts the unsorted portion.
     *
     * @param <E>
     * @param array
     * @param comp
     */
    public static <E> void enhancedBubbleSort(E[] array, Comparator<E> comp) {
        int lastSwap = array.length - 1;
        while (lastSwap > 0) {
            int unsortedBound = lastSwap;
            lastSwap = 0;
            for (int j = 0; j < unsortedBound; j++) {
                if (comp.compare(array[j], array[j + 1]) > 0) {
                    E temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    lastSwap = j;
                }
            }
        }
    }

    /**
     * Performs an Insertion Sort on an integer array
     *
     * @param <E>
     * @param array to sort
     * @param comp
     */
    public static <E> void insertionSort(E[] array, Comparator<E> comp) {
        int j;
        E temp;
        for (int i = 1; i < array.length; i++) {
            j = i;
            temp = array[i];
            while (j != 0 && comp.compare(array[j - 1], temp) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    /**
     * Performs a Selection Sort on a generic array
     *
     * @param <E>
     * @param array to sort
     * @param comp
     */
    public static <E> void selectionSort(E[] array, Comparator<E> comp) {
        E temp; // temporary location for swap
        int max;  // index of maximum value in subarray
        for (int i = 0; i < array.length; i++) {
            // find index of largest value in subarray
            max = indexOfLargestElement(array, array.length - i, comp);
            // swap array[max] and array[array.length - i - 1]
            temp = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Finds index of largest element
     *
     * @param array
     * @param size of the sub-array
     * @param comp
     * @return the index of the largest element in the sub-array
     */
    private static <E> int indexOfLargestElement(E[] array, int size,
            Comparator<E> comp) {
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (comp.compare(array[i], array[index]) > 0) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Code Fragment 12.1: An implementation of the merge operation for a Java
     * array. Merge contents of arrays S1 and S2 into properly sized array S.
     *
     * @param <K>
     * @param S1
     * @param S2
     * @param S
     * @param comp
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length
                    && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }

    /**
     * Code Fragment 12.2: An implementation of the recursive merge-sort
     * algorithm for a Java array (using the merge method defined in Code
     * Fragment 12.1). Merge-sort contents of array S.
     *
     * @param <K>
     * @param S
     * @param comp
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return; // array is trivially sorted
        }
        int mid = n / 2;                        // divide
        K[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp);                    // sort copy of first half
        mergeSort(S2, comp);                    // sort copy of second half
        // merge results
        merge(S1, S2, S, comp);     // merge sorted halves back into original
    }

    /**
     * Code Fragment 12.5: Quick-sort for a sequence S implemented as a queue.
     * Quick-sort contents of a queue.
     *
     * @param <K>
     * @param S
     * @param comp
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return; // queue is trivially sorted
        }// divide
        K pivot = S.first(); // using first as arbitrary pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) { // divide original into L, E, and G
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) // element is less than pivot
            {
                L.enqueue(element);
            } else if (c == 0) // element is equal to pivot
            {
                E.enqueue(element);
            } else // element is greater than pivot
            {
                G.enqueue(element);
            }
        }
        // conquer
        quickSort(L, comp); // sort elements less than pivot
        quickSort(G, comp); // sort elements greater than pivot
        // concatenate results
        while (!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }

    /**
     * Code Fragment 12.6: In-place quick-sort for an array S. The entire array
     * can be sorted as quickSortInPlace(S, comp, 0, S.length−1). Sort the
     * sub-array S[a..b] inclusive.
     *
     * @param <K>
     * @param S
     * @param comp
     * @param a
     * @param b
     */
    private static <K> void quickSortInPlace(K[] S, Comparator<K> comp,
            int a, int b) {
        if (a >= b) {
            return; // subarray is trivially sorted
        }
        int left = a;
        int right = b - 1;
        K pivot = S[b];
        K temp; // temp object used for swapping
        while (left <= right) {
            // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && comp.compare(S[left], pivot) < 0) {
                left++;
            }
            // scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right && comp.compare(S[right], pivot) > 0) {
                right--;
            }
            if (left <= right) { // indices did not strictly cross
                // so swap values and shrink range
                temp = S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        // put pivot into its final place (currently marked by left index)
        temp = S[left];
        S[left] = S[b];
        S[b] = temp;
        // make recursive calls
        quickSortInPlace(S, comp, a, left - 1);
        quickSortInPlace(S, comp, left + 1, b);
    }

    /**
     * Quick sort in place
     *
     * @param <K>
     * @param S
     * @param comp
     */
    public static <K> void quickSort(K[] S, Comparator<K> comp) {
        quickSortInPlace(S, comp, 0, S.length - 1);
    }

    /**
     * @param <E>
     * @param array
     * @param comp1
     * @param comp2
     * @param comp3
     * @param comp4
     */
    public static <E> void radixSort(E[] array, Comparator<E> comp1,
            Comparator<E> comp2, Comparator<E> comp3, Comparator<E> comp4) {
        enhancedBubbleSort(array, comp4);
        radixSort(array, comp1, comp2, comp3);
    }

    /**
     * @param <E>
     * @param array
     * @param comp1
     * @param comp2
     * @param comp3
     */
    public static <E> void radixSort(E[] array, Comparator<E> comp1,
            Comparator<E> comp2, Comparator<E> comp3) {
        enhancedBubbleSort(array, comp3);
        radixSort(array, comp1, comp2);
    }

    /**
     * @param <E>
     * @param array
     * @param comp1
     * @param comp2
     */
    public static <E> void radixSort(E[] array, Comparator<E> comp1,
            Comparator<E> comp2) {
        enhancedBubbleSort(array, comp2);
        enhancedBubbleSort(array, comp1);
    }
}
