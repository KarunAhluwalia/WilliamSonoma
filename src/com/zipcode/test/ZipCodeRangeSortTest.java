package com.zipcode.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zipcode.main.ZipCodeRange;
import com.zipcode.main.ZipCodeRangeSort;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class ZipCodeRangeSortTest {

	private ZipCodeRangeSort sort;
	
	@Test
	public void sortUsingStartRangeTest(){
		sort = new ZipCodeRangeSort();
		int startRange1 = 94200;
		int endRange1 = 94300;
		int startRange2 = 94112;
		int endRange2 = 94250;

		ZipCodeRange zip1 = new ZipCodeRange(startRange1, endRange1);
		ZipCodeRange zip2 = new ZipCodeRange(startRange2, endRange2);
		
		List<ZipCodeRange> list = new ArrayList<>();
		list.add(zip1);
		list.add(zip2);
		
		List<ZipCodeRange> actualList = sort.sortUsingStartRange(list);
		
		List<ZipCodeRange> expectedList = new ArrayList<>();
		expectedList.add(new ZipCodeRange(94112,94250));
		expectedList.add(new ZipCodeRange(94200,94300));
		
		assertEquals(expectedList.get(0).getStartRange(), actualList.get(0).getStartRange());
		assertEquals(expectedList.get(1).getStartRange(), actualList.get(1).getStartRange());		
		assertTrue(actualList.get(0).getStartRange() < actualList.get(1).getStartRange());
	}
}
