/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuan
 */
public class LPS {
   
    public String longestPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.length()  <=1) return s;
     
        int n = s.length();
        int indexS = 0;
        int indexE = 0;
        boolean[][] len = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            len[i][i] = true;
        }
        for(int i = 0; i < n -1; i++) {
            len[i][i + 1] = s.charAt(i) == s.charAt(i+1);
            if (len[i][i + 1] ) {
                indexS = i;
                indexE = i+ 1;
            }
        }
        for(int d = 2; d < n; d++) {
            for(int i = 0; i < n - d; i++) {
                int j = i + d;
                len[i][j] = len[i + 1][j - 1] &&  (s. charAt(i) == s.charAt(j));
                if(len[i][j]) {
                    indexS = i;
                    indexE = j;
                }
            }
        }
        return s.substring(indexS, indexE + 1);
    }
    
    public static void main(String[] args) {
        LPS lps = new LPS();
        String s = "cabcbabcbabcba";
        System.out.println(lps.longestPalindrome(s));
    }
}
