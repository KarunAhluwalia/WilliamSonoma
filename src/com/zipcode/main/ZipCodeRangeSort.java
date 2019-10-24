package com.zipcode.main;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class ZipCodeRangeSort {
	
	/**
	 * @param  zipCodeRangeList Takes list of set of zip code range
	 * @return sorted list based on start range of zip code range
	 * 
	 * This method takes the list of zip code range and sort them based on the start range
	 */
	public List<ZipCodeRange> sortUsingStartRange(List<ZipCodeRange> zipCodeRangeList){
		Comparator<ZipCodeRange> compareByStartRange = Comparator
														.comparing(ZipCodeRange::getStartRange);
		
		List<ZipCodeRange> sortedList = zipCodeRangeList.stream()
											.sorted(compareByStartRange).collect(Collectors.toList());
		
		return sortedList;
	}
}
