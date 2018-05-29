import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Iv {
    public static int numberNeeded(String first, String second) {
    	String[] one = new String[first.length()];
    	String[] two = new String[second.length()];
        for(int i = 0; i<one.length;i++){
            one[i]=first.charAt(i)+"";
        }
        for(int i = 0; i<two.length;i++){
            two[i]=first.charAt(i)+"";
        }
        for(int i = 0; i<one.length;i++){
       
        	 for(String s : two) {
        		 System.out.println(s);
        	 }
                
             
        }
        return 2 ;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}