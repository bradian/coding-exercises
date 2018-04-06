/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Random;

/**
 *
 * @author ian
 */
public class General {
    public static void main (String args[]){
//        printBinary (12);
//        
//        parseInt("160");
//        System.out.println(multiply(13, 5));
//        exponent(2,0);
       // System.out.print (rand5());
       System.out.println(recursiveMultiply(2,4));
    }
    
    public static int multiply (int x, int y){
        int result = 0; 
        for (int i= 0; i< y; i++){
            result = result + x; 
        }
        return result; 
    }
    public static int recursiveMultiply(int x, int y){
         
        if (y==1){return x;}
        else{
            y--;
            return recursiveMultiply(x, y)+x;
        }
        
    }
    
    public static int rand5(){
        Random r = new Random(); 
        return r.nextInt(6);
        
    }
    //this is not correct - fine for ints
    public static void exponent (int x, int y){
        for (int i= 1; i< y; i++){
            x = x*x; 
        }
        System.out.println(x);
    }
    public static void printBinary(int n){
        int r = 0; 
        
        if (n > 0){
            
            r = n%2;
            printBinary(n/2);
            System.out.print(r);
        }
        System.out.println();
       
    }
    
    
    public static void parseInt (String s){
        char []characters = s.toCharArray();
        int value = 0; 
        int exp = characters.length-1; 
        for (int i = 0; i < characters.length; i++){
            int temp = Character.getNumericValue(characters[i]);
            if (value >=0){
                value = value +(temp * (int) Math.pow(10, exp-i));
            }
        }
        System.out.println (value);
        
    }
}
