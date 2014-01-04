/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class wordProduct {
    public BitMap[] b;
    class BitMap{
        private int size;
        private int len;
        private int[] array;
        public BitMap(){
            size = 26;
            len = (26 % 8 == 0) ? 26 /8: 26 /8 + 1;
            array = new int[len];
            for(int i = 0; i != len; i++) {
                array[i] = 0;
            }            
        }
        
        public BitMap(int s){
            size = s;
            len = (s % 8 == 0) ? s /8: s /8 + 1;
            array = new int[len];
            for(int i = 0; i != len; i++) {
                array[i] = 0;
            }            
        }
        
        private void set(int i) {
            int block = i/8;
            int index = i % 8;
            array[block] =array[block] | (1<<index);
        }
        public void set(String s) {
            char c;
            for(int i = 0; i != s.length(); i++){
                c = s.charAt(i);
                set((int)(c - 'a'));
            }
        }
        
        public boolean cross(BitMap that){
            assert(that.size == this.size);
            for(int i = 0; i < this.len; i++)
                if ( (this.array[i] & that.array[i]) != 0) return false;
            return true;
        }
    }
    
    public wordProduct(int i){
        b = new BitMap[i];
        for(int j =0; j < i; j++)
            b[j] = new BitMap();
    }
    public static void main(String[] args) {       
        String[] s = {"hello", "world","morning","lunch","bad", "fast"};
        wordProduct w = new wordProduct(s.length);
        for(int i = 0; i != s.length; i++) {
          w.b[i].set(s[i]);
        }
        for(int i = 0; i < s.length; i++){
            for(int j = i+1; j < s.length; j++) System.out.print(w.b[i].cross(w.b[j]) + " ");
            System.out.println();
        }
    }
    
}
