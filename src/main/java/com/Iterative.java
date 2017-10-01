package com;

public class Iterative {
    
    public static boolean hasOneChange(String stringOne, String stringTwo) {
        if (stringOne == null || stringTwo == null) {
            return false;
        }
        
        int m = stringOne.length();
        int n = stringTwo.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        
        int count = 0;
        int i = 0;
        int j = 0;
        
        while (i < m && j < n) {
            if (stringOne.charAt(i) != stringTwo.charAt(j)) {
                if (count == 1) {
                    return false;
                }
                
                if (m > n) {
                    i++;
                } else if (m < n) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                
                count++;
            } else {
                i++;
                j++;
            }
        }
        
        if (i < m || j < n) {
            count++;
        }
        
        return count == 1;
    }

}
