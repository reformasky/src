/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class Water {
   
    public int maxArea(int[] height) {
        int v = -1;
        int h = -1;
        int h1 = -1;
        int h2 = -1;
        int tmp = -1;
        for(int i = 0; i < height.length; i++) {
            h1 = height[i];
            if (h < h1) h = h1;
            else continue;
            for(int j = height.length -1; j > i; j-- ){
               h2 = height[j];
               if (h2 >= h1) {
                   tmp= h1 * (j -i);
                   if (tmp > v) v = tmp;
                   break;
               }
               else {
                   tmp = h2 *(j -i);
                   if (tmp > v) v = tmp;
               }             
               
            }
        }
        return v;        
    }
}
