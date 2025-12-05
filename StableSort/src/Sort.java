
import java.util.Arrays;

public class Sort {

    public static <K> void bubbleSort1(K[] data, Comparator<K> comp) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comp.compare(data[j], data[j + 1]) >= 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static <K> void bubbleSort2(K[] data, Comparator<K> comp) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - 1; j++) {
                if (comp.compare(data[j], data[j + 1]) > 0) {
                    K temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static <K> void radixSort(K[] data, Comparator<K> comp1, Comparator<K> comp2, Comparator<K> comp3) {
        bubbleSort2(data, comp3);
        bubbleSort2(data, comp2);
        bubbleSort2(data, comp1);
    }

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

    public static <E> void radixSort(E[] array, Comparator comp1, Comparator comp2, Comparator comp3, Comparator comp4, Comparator comp5) {
        Sort.bubbleSort2(array, comp5);
        Sort.radixSort(array, comp1, comp2, comp3, comp4);
    }

    public static <E> void radixSort(E[] array, Comparator comp1, Comparator comp2, Comparator comp3, Comparator comp4) {
        Sort.bubbleSort2(array, comp4);
        Sort.radixSort(array, comp1, comp2, comp3);
    }

    public static <E> void radixSort3(E[] array, Comparator comp1, Comparator comp2, Comparator comp3) {
        Sort.bubbleSort2(array, comp3);
        Sort.radixSort(array, comp1, comp2);
    }

    public static <E> void radixSort(E[] array, Comparator comp1, Comparator comp2) {
        Sort.bubbleSort2(array, comp2);
        Sort.bubbleSort2(array, comp1);
    }
}
