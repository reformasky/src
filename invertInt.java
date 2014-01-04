/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class invertInt {
    public int reverse(int x) {
        int result = 0;
        boolean neg = x <0;
        x = neg? -x: x;
        while(x != 0) {
            result = result * 10 + x %10;
            x /=10;
        }
        return neg? -result: result;
    }
    
    
    public static void main(String[] args) {
        invertInt i = new invertInt();
        System.out.println(i.reverse(-123));
    }
}
