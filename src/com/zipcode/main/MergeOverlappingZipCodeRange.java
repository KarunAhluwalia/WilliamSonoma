package com.zipcode.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */
public class MergeOverlappingZipCodeRange {
	
	/**
	 * @param list This is the sorted list which is to be merged
	 * @return mergedList the final list
	 * 
	 * This method takes the sorted list based on the startRange of the set and merge the sets
	 * 
	 * */
	public List<ZipCodeRange> merge(List<ZipCodeRange> list){
		List<ZipCodeRange> mergedList = new ArrayList<>();
	    ZipCodeRange zipRange = list.get(0);
	    for (int i = 1; i < list.size(); i++) {
	      ZipCodeRange zipCodeRange = list.get(i);

          if (zipRange.getEndRange() >= zipCodeRange.getStartRange()) {
        	int endRange = Math.max(zipRange.getEndRange(), zipCodeRange.getEndRange());
        	zipRange.setEndRange(endRange);;
          } else {
            mergedList.add(zipRange);
            zipRange = zipCodeRange;
          }
	      
	    }
	    mergedList.add(zipRange);
	    return mergedList;
	}
}
