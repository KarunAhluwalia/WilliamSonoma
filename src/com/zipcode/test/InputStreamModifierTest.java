package com.zipcode.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zipcode.main.InputStreamModifier;
import com.zipcode.main.ZipCodeRange;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class InputStreamModifierTest {
	private InputStreamModifier modifier;
	
	@Test
	public void modifyInputStreamTest(){
		String inputString = "[94112,94250] [94200,94300]";
		modifier = new InputStreamModifier();
		
		List<ZipCodeRange> actualList = modifier.modifyInputStream(inputString);
		
		List<ZipCodeRange> expectedList = new ArrayList<>();
		expectedList.add(new ZipCodeRange(94112,94300));
		
		assertEquals(expectedList.get(0).getStartRange(), actualList.get(0).getStartRange());
		assertEquals(expectedList.get(0).getEndRange(), actualList.get(0).getEndRange());
	}
	
	@Test
	public void isLegalTest_singleZipCode(){
		modifier = new InputStreamModifier();
		String zipCodeRange = "[94112]";
				
		boolean actual = modifier.isLegal(zipCodeRange);
		
		assertFalse(actual);
	}
	
	@Test
	public void isLegalTest_correctZipCode(){
		modifier = new InputStreamModifier();
		String zipCodeRange = "[94112,94112]";
				
		boolean actual = modifier.isLegal(zipCodeRange);
		
		assertTrue(actual);
	}
	
	@Test
	public void isLegalTest_zipCodeWrongLength(){
		modifier = new InputStreamModifier();
		String zipCodeRange = "[9411,94112]";
				
		boolean actual = modifier.isLegal(zipCodeRange);
		
		assertFalse(actual);
	}
	
	@Test
	public void isLegalTest_startZipCodeGreaterThanEndZipCode(){
		modifier = new InputStreamModifier();
		String zipCodeRange = "[94113,94112]";
				
		boolean actual = modifier.isLegal(zipCodeRange);
		
		assertFalse(actual);
	}
	
	@Test
	public void sortAndMergeListTest(){
		int startRange1 = 94112;
		int startRange2 = 94200;
		int endRange1 = 94250;
		int endRange2 = 94300;
		ZipCodeRange zip1 = new ZipCodeRange(startRange1, endRange1);
		ZipCodeRange zip2 = new ZipCodeRange(startRange2, endRange2);
		List<ZipCodeRange> list = new ArrayList<>();
		list.add(zip1);
		list.add(zip2);
		
		modifier = new InputStreamModifier();	
		List<ZipCodeRange> actualFinalList = modifier.sortAndMergeList(list);
		
		List<ZipCodeRange> expectedFinalList = new ArrayList<>();
		expectedFinalList.add(new ZipCodeRange(94112,94300));
		
		assertEquals(expectedFinalList.get(0).getStartRange(), actualFinalList.get(0).getStartRange());
		assertEquals(expectedFinalList.get(0).getEndRange(), actualFinalList.get(0).getEndRange());
		
	}
	
	@Test
	public void isLengthFive_wrongLength(){
		int zip = 9411;
		modifier = new InputStreamModifier();
		
		boolean actual = modifier.isLengthFive(zip);
		
		assertFalse(actual);
	}
	
	@Test
	public void isLengthFive_correctLength(){
		int zip = 94112;
		modifier = new InputStreamModifier();
		
		boolean actual = modifier.isLengthFive(zip);
		
		assertTrue(actual);
	}
	

}
