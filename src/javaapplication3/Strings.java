/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.HashMap;

/**
 *
 * @author ian
 */
public class Strings {
    public static void main (String args[]){
        nonRepeat("hello my name is herbert howells");
        System.out.println(reverseString("Ian Bradford"));
        String s = "Hello";
        System.out.println(reverseString(s, 0));
        
        String s1 = "madam im adam";
        String s2 = "mada mim adam";
        System.out.println(isPalindrome(s1, s2));
        stringPermutations("Grzesiu");
        System.out.println(factorial(7));
    }
    
    public static void stringPermutations(String s){
        char c[] = s.toCharArray();
        
        int number = 1; 
        for (int x =0; x< c.length; x++){
            int swap1 = 1; 
            int swap2 = 2; 
            char temp; 
            int swaps = factorial (c.length) /c.length; //(c.length-1) *(c.length-2);
           // System.out.println("swaps: "+swaps);
            for (int y= 0 ; y< swaps ; y++){
                if (swap2 == c.length){
                    swap1 = 1; 
                    swap2 = 2; 
                }
                temp = c[swap2];
                c[swap2] = c[swap1];
                c[swap1]= temp; 
                swap1++; 
                swap2++; 
                
                System.out.println(number+":"+ new String (c));
                number++; 
            }
            for (int z = 0; z < c.length-1; z++){
                temp = c[z];
                c [z] = c[z+1];
                c[z+1] = temp; 
            }
           // System.out.println(number+":"+ new String (c));

        }
            
      
    }
    public static int factorial(int n){
        if (n ==1){
            return 1; 
        }
        else {
            return  n * factorial(n-1);
        }
    }
    public static boolean isPalindrome (String s1, String s2){
        int p1 = 0; 
        int p2 = 0; 
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        if (c1.length!= c2.length){return false;}
        else{
            while (p1 < c1.length && p2 < c2.length){
                
                if (c1[p1] == ' '){
                   p1++;  
                }
                if (c2[p2] == ' '){
                   p2++;  
                }
                if (c1[p1]==c2[p2]){
                    p1 = ++p2; 
                }
                else return false; 
            }
           
        }
        
        return true; 
    }
    public static void nonRepeat(String s){
        char chars [] = s.toCharArray();
        HashMap<Character, Integer> map  = new HashMap();
        
        for (int i =0; i< chars.length; i++){
            if (!map.containsKey(chars[i])){
                map.put(chars[i], 1);
            }else{
               int m =  map.get(chars[i]);
               m++; 
                map.put(chars[i],m );
            }
        }
        System.out.println(map);
        for (int i =0; i< chars.length; i++){
            int value = map.get(chars[i]);
            if (value == 1){
                System.out.println(chars[i]);
                break;
            }
        }
    }
    public static String reverseString(String s){
        
        char chars [] = s.toCharArray();
         for (int i =0; i< chars.length/2; i++){
             char temp = chars[i];
             chars[i] = chars[chars.length-1-i];
             chars[chars.length-1-i] = temp; 
         }
        return new String (chars);
    }
    public static String reverseString(String s, int position){
        
        
        if ( s.length()/2 ==position){
            System.out.println("termination condition : "+position);
            return s ;
        }
        else{
            char chars [] = s.toCharArray();
            char temp = chars[position];
            chars[position] = chars[chars.length-1-position];
            chars[chars.length-1-position] = temp;
            position++;
           
           String current = reverseString(new String (chars), position);
           System.out.println("call to return with : "+position + "current string "+current);
            return current;
        }

    }
}
