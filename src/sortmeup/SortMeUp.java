/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmeup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael
 */
public class SortMeUp {
    static List<Integer> array = new ArrayList();
    
    public static void printArray(List<Integer> a){
        System.out.println("");
        for(int i: a){
            System.out.print(i + " ");
        }
    }
    
    public static List<Integer> mergeSort(List<Integer> a){
        int length = a.size();
        if(length <= 1){
            return a;
        }
        
        List<Integer> kappa = new ArrayList();
        for(Integer i: a.subList(0, length/2)){
                kappa.add(i);
        }
        List<Integer> kappa2 = new ArrayList();
        for(Integer i: a.subList(length/2, length)){
                kappa2.add(i);
        }
        List<Integer> half1 = mergeSort(kappa);
        List<Integer> half2 = mergeSort(kappa2);
        
        return merge(half1,half2);
    }
    
    public static List<Integer> merge(List<Integer> a1,List<Integer> a2){
        List<Integer> result = new ArrayList();
        
        while(a1.size() > 0 && a2.size() > 0){
            if(a1.get(0) > a2.get(0)){
                result.add(a1.get(0));
                a1.remove(0);
            }
            else{
                result.add(a2.get(0));
                a2.remove(0);
            }
        }
        
        if(a1.size() == 0){
            for(int i: a2){
                result.add(i);
            }
        }
        else{
            for(int i: a1){
                result.add(i);
            }
        }
        
        return result;
    }
            
    public static void main(String[] args) {
       
       Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            array.add(rn.nextInt(100));
        }
        printArray(array);
        printArray(mergeSort(array));
        
    }
    
}
