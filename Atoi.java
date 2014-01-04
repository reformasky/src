/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class Atoi {
    static final int pos_q = Integer.MAX_VALUE /10;
     static final int pos_m = Integer.MAX_VALUE %10;
    private boolean number(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean white(char c) {
        return c == ' ' || c == '\t' || c == '\n';
    }
    public int atoi(String str) {
        int result = 0;
        boolean neg = false;
        boolean num = false;
        boolean pos  = false;
        
        int len = str.length();
        for(int i = 0; i != len; i++) {
           char c = str.charAt(i);
           
           int a = 0;
           if (num) {
               if (!number(c)){
                   break;
               }
               else {
                   if (result > pos_q) return neg ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                   else if (result == pos_q && pos_m > (int)(c - '0')) {
                       result = result * 10 + (int)(c - '0');
                   }
                    else if (result == pos_q && pos_m == (int)(c - '0') && neg) {
                       result = result * 10 + (int)(c - '0');
                       return -result;
                   }
                   else if (result == pos_q) return neg ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                   else  result = result * 10 + (int)(c - '0');
                   
               }
           }
           else {
               if (number(c)) {
                   num = true;
                   result = result * 10 + (int)(c - '0');
               }
               else if (white(c));
               else if (c =='+'){
                   if(i < len -1 && number(str.charAt(i+ 1)));
                   else break;

               }
               else if (c == '-'){
                   if(i < len -1 && number(str.charAt(i+ 1)));
                   else break;
                    neg = true;
               }
               else break;
           }
        }
      return neg? -result : result;
        
    }
    
    public static void main(String[] args) {
        Atoi a = new Atoi();
        String[] s = {"2147483648","-2147483648"   ,"-2147483647"  , " -  123"           
        };
        for(String ss : s)
        System.out.println(a.atoi(ss));
    }
}
