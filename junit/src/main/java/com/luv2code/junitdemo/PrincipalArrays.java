package com.luv2code.junitdemo;

import java.util.Arrays;

public class PrincipalArrays {
	
	public static void main(String[] args) {
		
		String[] arr1 = {"A","B","C"};
		String[] arr2 = {"A","B","C"};
		
		System.out.println(arr1.equals(arr2)); //false
		System.out.println(Arrays.equals(arr1, arr2)); //true

		
	}

}
