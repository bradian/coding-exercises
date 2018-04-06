/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author ian
 */
public class DynamicProgramming {
    public static void main (String args[]){
        eratosthenes(40);
    }
    //this is not dynamic 
    public static void eratosthenes(int n){
        //the 0th position of the array is not used
        n= n+1; 
        boolean [] sieve = new boolean [n];
        for (int x = 1; x < sieve.length; x++){
           sieve[x] = true; 
              
        } 
        double sqrt = Math.sqrt(n);
        long limit = Math.round(sqrt);  
        for (int i = 2; i <= limit; i++){
            if (sieve[i]){
                int sq = i*i; 
                int j = sq;
                int m = 1; 
                while (j < n){
                    
                   sieve[j] = false; 
                   j = sq+ (i*m);
                   m++; 
                }
                
            }
        }
       for (int x = 0; x < sieve.length; x++){
           if (sieve[x]){
               System.out.println(x);
           }
       } 
    }
}
