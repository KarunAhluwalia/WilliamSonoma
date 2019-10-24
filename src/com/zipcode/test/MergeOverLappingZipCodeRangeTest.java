package com.zipcode.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zipcode.main.MergeOverlappingZipCodeRange;
import com.zipcode.main.ZipCodeRange;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class MergeOverLappingZipCodeRangeTest {
	private MergeOverlappingZipCodeRange merge;
	
	@Test
	public void mergeTest_oneRange(){
		merge = new MergeOverlappingZipCodeRange();
		int startRange1 = 94112;
		int endRange1 = 94250;
		ZipCodeRange zip1 = new ZipCodeRange(startRange1, endRange1);
		List<ZipCodeRange> list = new ArrayList<>();
		list.add(zip1);
		
		List<ZipCodeRange> actualList = merge.merge(list);
		
		List<ZipCodeRange> expectedList = new ArrayList<>();
		expectedList.add(new ZipCodeRange(94112,94250));
		
		assertEquals(expectedList.get(0).getStartRange(), actualList.get(0).getStartRange());
		assertEquals(expectedList.get(0).getEndRange(), actualList.get(0).getEndRange());	
		
	}
	
	@Test
	public void mergeTest_multipleRange(){
		merge = new MergeOverlappingZipCodeRange();
		int startRange1 = 94112;
		int endRange1 = 94250;
		int startRange2 = 94200;
		int endRange2 = 94300;
		ZipCodeRange zip1 = new ZipCodeRange(startRange1, endRange1);
		ZipCodeRange zip2 = new ZipCodeRange(startRange2, endRange2);

		List<ZipCodeRange> list = new ArrayList<>();
		list.add(zip1);
		list.add(zip2);
		
		List<ZipCodeRange> actualList = merge.merge(list);
		
		List<ZipCodeRange> expectedList = new ArrayList<>();
		expectedList.add(new ZipCodeRange(94112,94300));
		
		assertEquals(expectedList.get(0).getStartRange(), actualList.get(0).getStartRange());
		assertEquals(expectedList.get(0).getEndRange(), actualList.get(0).getEndRange());	
		
	}
}
