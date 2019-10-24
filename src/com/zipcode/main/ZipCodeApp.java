package com.zipcode.main;

import java.util.List;
import java.util.Scanner;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class ZipCodeApp {

	/**
	 * Main method. Application starts from here. It reads the input from user and prints the final 
	 * list
	 */
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Zip Codes");
		System.out.println("Please enter in the following format");
		System.out.println("[StartRange,EndRange]");
		
		String in = input.nextLine();
		
		InputStreamModifier modify = new InputStreamModifier();
		List<ZipCodeRange> modifiedFinalRange = modify.modifyInputStream(in);
		
		for(ZipCodeRange zipCode : modifiedFinalRange){
			System.out.println("[" + zipCode.getStartRange() + "," + zipCode.getEndRange() + "]");
		}
	}
}
