/*
Author: Nicole Hackler
Date: 11/30/2023

Exercise 23-3
Description:
(Generic quick sort) Write the following two generic methods using quick sort. The first method
sorts the elements using the Comparable interface and the second uses the Comparator interface.

1: public static <E extends Comparable<E>> void quickSort(E[] list)
2: public static <E> void quickSort(E[] list, Comparator<? super E> comparator)
*/
import java.util.Comparator;

public class Exercise23_03 {
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)};
        quickSort(list1, new GeometricObjectComparator());
        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i] + " ");
        }
    }
    //Sort method
    public static <E extends Comparable<E>> void quickSort(E[] list){
        quickSort(list, 0, list.length - 1);
    }
    //Helper method
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1); //Recursive call
            quickSort(list, pivotIndex + 1, last); //Recursive call
        }
    }
    //Partition the array list
    public static <E extends Comparable<E>> int partition(E[] list, int first, int last){
        E pivot = list[first]; //Choose the first element as the pivot
        int low = first + 1; //Index for forward search
        int high = last; //Index for backward search

        while (high > low){
            //search forward from left
            while (low <= high && pivot.compareTo(list[low]) >= 0)
                low++;

            //search backward from right
            while(low <= high && pivot.compareTo(list[high]) < 0)
                high--;

            //Swap two elements in the list
            if(high > low){
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && pivot.compareTo(list[high]) <= 0)
            high--;

        //Swap pivot with last[high]
        if(pivot.compareTo(list[high]) > 0){
            list[first] = list[high];
            list[high] = pivot; //place pivot
            return high; //pivot's new index
        }
        else{
            return first; //pivot's original index
        }
    }
    //Sort method
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator){
        quickSort(list, comparator, 0, list.length - 1);
    }
    //Helper method
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator, int first, int last){
        if(last > first){
            int pivotIndex = partition(list, comparator, first, last);
            quickSort(list, comparator, first, pivotIndex - 1); //Recursive call
            quickSort(list, comparator, pivotIndex + 1, last); //Recursive call
        }
    }
    //Partition method
    public static <E> int partition(E[] list,  Comparator<? super E> comparator, int first, int last){
        E pivot = list[first]; //Choose the first element as the pivot
        int low = first + 1; //Index for forward search
        int high = last; //Index for backward search

        while (high > low){
            //search forward from left
            while (low <= high && comparator.compare(pivot, list[low]) >= 0)
                low++;

            //search backward from right
            while(low <= high && comparator.compare(pivot, list[high]) < 0)
                high--;

            //Swap two elements in the list
            if(high > low){
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(pivot, list[high]) <= 0)
            high--;

        //Swap pivot with last[high]
        if(comparator.compare(pivot, list[high]) > 0){
            list[first] = list[high];
            list[high] = pivot; //place pivot
            return high; //pivot's new index
        }
        else{
            return first; //pivot's original index
        }
    }
}

