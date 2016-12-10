package com;

public class App {

	/**
	 * Determine if number of changes in String (deletion, insertion, substitution).
	 * If there is 1 substitution return true, if there are zero or 2+ return false.
	 */
	public static boolean hasOneChange(String stringOne, String stringTwo) {
		if (stringOne == null) stringOne = "";
		if (stringTwo == null) stringTwo = "";
		int changes = numberOfChanges(stringOne, stringTwo);
		return changes == 1;
	}
	
	public static int numberOfChanges(String stringOne, String stringTwo) {
		int[][] matrix = new int[stringOne.length() + 1][stringTwo.length() + 1];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0) {
					matrix[i][j] = j;
				} else if (j == 0) {
					matrix[i][j] = i;
				} else if (stringOne.charAt(i-1) == stringTwo.charAt(j-1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]);
				}
			}
		}
		
		return matrix[stringOne.length()][stringTwo.length()];
	}
	
}
