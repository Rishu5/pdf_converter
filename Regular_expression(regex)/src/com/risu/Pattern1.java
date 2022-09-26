package com.risu;

public class Pattern1 {
	public static void main(String args[]) {
//System.out.println("hello");
		int n=4;
		for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
						 if(i+j>=n-1) {
							 	System.out.print("* ");
						 }
						 else
							 System.out.print("  ");
				} 
				System.out.println();
		}
	}

}
