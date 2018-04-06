/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ian
 */
public class string_to_map {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Map m = stringToMap(("1=one&2=two&3=three"));
            System.out.println(m);
        }catch (Exception e){
            
        }
        
    }
    
    public static Map stringToMap (String s) throws Exception{
        HashMap <String, String> map = new HashMap();
        String [] groups = s.split("&");
        for (String group : groups) {
            System.out.println(group);
            if (!group.contains("=")){
                throw new Exception();
            }
            String[] pair = group.split("=");
            map.put(pair[0], pair[1]);
        }
       
        return map; 
    }
    
}
