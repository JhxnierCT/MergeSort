/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mergesort;

/**
 *
 * @author COTAYA
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int med = arr.length / 2;
        int[] izq = new int[med];
        int[] der = new int[arr.length - med];
        System.arraycopy(arr, 0, izq, 0, med);
        System.arraycopy(arr, med, der, 0, arr.length - med);
        mergeSort(izq);
        mergeSort(der);
        merge(arr, izq, der);

    }

    private static void merge(int[] arr, int[] izq, int[] der) {
        int i = 0, j = 0, k = 0;

        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                arr[k++] = izq[i++];
            } else {
                arr[k++] = der[j++];
            }

        }
        while (i < izq.length) {
            arr[k++] = izq[i++];
        }
        while (j < der.length) {
            arr[k++] = der[j++];
        }
    }

    public static void main(String[] args) {
        int[] data = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(data);
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
