package com.al.in;

public class Test {
	public static void main(String[] args) {
		int [] a= {2,5,7,8,9,2,5,5};
		for(int i=0;i<a.length;i++) {
			for (int j =i+ 1; j <a.length; j++) {
				if(a[i]==a[j] ){
					System.out.println("Duplicate value :"+a[j]);
					
				}
				
			}
			
		}
	}

}
