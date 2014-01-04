/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class ZigZag {
    
     public String convert(String s, int nRows) {
         if(nRows == 1 ) return s;
         int len = s.length();   
         int unit = 2 * nRows - 2;
         int num = (len % unit != 0) ? (len / unit + 1) : len/unit;
         char[][] matrix = new char[num][unit];
         int index = 0;
         for(int i = 0; i != num; i++)
             for(int j = 0; j != unit; j++) {
                 if(index < len) {
                     matrix[i][j] = s.charAt(index++);
                 }
                 else matrix[i][j] = '\0';
             }
         index = 0;
         char[] result = new char[len];         
         for(int r =0 ; r < num; r ++)result[index++] = matrix[r][0];
         for(int c = 1;  c < nRows -1 ; c++) {
             for(int r = 0; r < num -1 ; r++) {
                 result[index++] = matrix[r][c];
                 result[index++] = matrix[r][unit - c];
             } 
             if( matrix[num -1][c] != '\0') result[index++] = matrix[num - 1][c];             
             if( matrix[num -1][unit -c] != '\0') result[index++] = matrix[num -1][unit -c];
         }
         for(int r =0 ; r < num -1 ; r ++) result[index++] = matrix[r][nRows -1];
         if( matrix[num -1][nRows - 1] != '\0') result[index++] = matrix[num -1][nRows - 1];
         return String.valueOf(result);        
    }
     
     
     public static void main(String[] args){
         ZigZag z = new ZigZag();
         String s = z.convert("PAYPALISHIRING", 3);
         System.out.println(s);
         
         System.getenv();
     
     }
    
}
