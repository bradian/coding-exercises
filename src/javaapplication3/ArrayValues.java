/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Find the most frequent integer in an array
 * @author ian
 */
public class ArrayValues {
    public static void main(String args[]){
        int [] array1 = {84,4,1, 7, 2, 5,5, 7, 67, 6, 3, 1,4, 99, 5,3,39}; 
        int [] array2 = {39, -2, -7, 15, 19, 18}; 
        //work(array);
       // pairsEqualToTen(array);
       // System.out.println(singleOccurence(array));
       Arrays.sort(array1);
       printArray(array1);
        System.out.println(binarySearch(array1, 0, array1.length, 2));
        int []  a={1,2,3,4,5,6,7,8};
        int []b ={5,6,7,8,1,2,3,4};
        //commonElement2 (array1,array2);
        //System.out.println( rotatedArray(a, b));
        
        //fibonacci(10);
        //recursiveFibonacci(10, 0, 1, 0);
    }
    
    public static int binarySearch(int array [],int l, int r, int key){
         
        
        
        if (l<r){
            int m = (l + r)/2; 
            System.out.println(l+":"+m+":"+r);
            if (key < array [m]){
                return binarySearch(array, l, m, key);
            }
            else if (key > array [m]){
                return binarySearch(array, m+1, r, key);
            }else return m; 
        }
        return - (l +1); 
          
       
    }
    //uses Java wizardry
    public static void commonElement1(int [] array1, int []array2){
        List<Integer> list1 = Arrays.stream(array1).boxed().collect(Collectors.toList());
        Set<Integer> set1 = new HashSet<>(list1);
       
        List<Integer> list2 = Arrays.stream(array2).boxed().collect(Collectors.toList());
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        System.out.println(set1);
        
    }
    //using no hashset 
    public static void commonElement2(int [] array1, int []array2){
        int pointer1 = 0; 
        int pointer2 = 0; 
        Arrays.sort(array1);
        Arrays.sort(array2);
        while (pointer1 < array1.length&& pointer2 < array2.length){
            if (array1[pointer1]==array2[pointer2]){
                System.out.println(array1[pointer1]);
                break; 
            }
            else if (array1[pointer1]>array2[pointer2]){
                pointer2++; 
            }
            else if (array1[pointer1]<array2[pointer2]){
                pointer1++; 
            }
        }
    }
    
    public static int singleOccurence(int [] array){
//        
    int value = array[0]; 
     Arrays.sort(array);
     if (array[0] != array[1]&& array[1] == array[2]){
         value =  array[0];
     }
     else if (array[array.length-1] != array[array.length-2]&& array[array.length-2] == array[array.length-3]){
         value =  array[array.length-1];
     }
     else{
         for (int i=1; i < array.length-1; i++){
            if (array[i-1] != array[i] &&array[i] != array[i+1]){
                value =  array[i];
                break; 
            }
         }
     }
      return value; 
    }
    public static void fibonacci(int limit){
        int n1 = 0; 
        int n2 = 1; 
        int sum = 1;
        for (int i=0; i < limit; i++){
            System.out.println(sum);
            sum = n1 + n2; 
            
            n1 = n2; 
            n2 = sum; 
            
        }
    }
    public static void recursiveFibonacci(int limit,int current, int n1, int n2 ){
        if (current < limit){
            current+=1; 
            int sum = n1+n2; 
            System.out.println(sum);
            
            recursiveFibonacci(limit, current, n2, sum);
        }
    }
    public static boolean rotatedArray(int [] array1, int []array2){
       
        boolean isRotated = false; 
        if (array1.length != array2.length){
            return false; 
        }
         //take centre
       //integer division: 7 = 3, 8 = 4
        int firstHalf = array1.length/2;
        // 7: 4, 8: 4 
        int secondHalf = array1.length-firstHalf; 
        for (int i = 0; i < firstHalf; i++){
            if ( array1[i] != array2[i+secondHalf])
            return false; 
        }
         for (int i = 0; i < secondHalf; i++){
            if(array2[i] != array1[i+firstHalf])
            return false; 
        }
        return true; 
    }
    //Find the most frequent integer in an array
    public static void work (int [] array){
        Arrays.sort (array);
        int count = 0; 
        int total = 0; 
        int value = 0; 
        //int current = value; 
        for (int i = 1; i < array.length-1; i++){
            if (array[i]== array[i+1]){
                count++;
            }
            else{
                if (count >total){
                    total = count; 
                    count =0; 
                    value = array[i];
                }
            }
        }
        System.out.println(value);
    }
    public static void pairsEqualToTen(int[]array){
        for (int i = 0; i < array.length; i++){
            for (int j = i; j< array.length; j++){
                if ((i != j) && (array[i]+array[j] == 10)){
                    System.out.println(i+":"+array[i]+"+ "+j+":"+array[j]);
                    System.out.println(j+":"+array[j]+i+":"+array[i]);
                }
            }
            
        }
    }
    public static void printArray(int []array){
        for (int i=0; i< array.length; i++){
            System.out.print(i+":"+array[i]+" ");
        }
        System.out.println();
    }
}
