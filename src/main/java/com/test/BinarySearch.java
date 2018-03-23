package com.test;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 3, 5, 8, 12, 55};
        int i = binarySearch.binary_search_1(arr, 8);
        System.out.println(i);

    }

    public int binary_search(int[] arr, int key) {
        int high = arr.length - 1;
        int low = 0;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            System.out.println("mid=" + mid);
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    int binary_search_1(int a[], int key) {
        int m, l = 0, r = a.length - 1;//闭区间[0, n - 1]
        while (l < r) {
            m = l + ((r - l) >> 1);//向下取整
            System.out.println("mid=" + m);
            if (a[m] < key) l = m + 1;
            else r = m;
        }
        if (a[r] == key) return r;
        return -1;
    }

}
