package com.zipcode.main;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karun Ahluwalia
 * @since Oct 2019
 * 
 * */

public class InputStreamModifier {
	private List<ZipCodeRange> zipCodeRangeList = new ArrayList<>();
	private int startRange = Integer.MIN_VALUE;
	private int endRange = Integer.MAX_VALUE;
	
	/**
	 * @param  inputStream This is the stream of zip code range entered by user
	 * @return finalList This is the final merged sorted list
	 * @throws throws illegal argument exception if the entered stream is not in correct format
	 * 
	 * This method takes @param and changes it to array of string to handle each range one by one.
	 * The method takes each range one by one and checks if it is in correct format and if it is then
	 * adds it to the list for sorting and merging.
	 * It finally returns the sorted and merged list.
	 */
	
	public List<ZipCodeRange> modifyInputStream(String inputStream){
		String[] inputStreamArray = inputStream.split(" ");
		for(String inputRange : inputStreamArray){
			if(isLegal(inputRange)){
				addToList();
			}else { 
				throw new IllegalArgumentException("Enter valid range");
			}
		}
		List<ZipCodeRange> finalList = sortAndMergeList(zipCodeRangeList);
		
		return finalList;
	}

	/**
	 * @param zipCodeRangeList List of all the ZipCodeRange
	 * @return finalRange Sorted and merged list
	 * 
	 * This method takes @param and send it to be sorted. After sort, the list gets merged
	 * and @return is returned.
	 * 
	 */
	public List<ZipCodeRange> sortAndMergeList(List<ZipCodeRange> zipCodeRangeList){
		ZipCodeRangeSort sort = new ZipCodeRangeSort();
		List<ZipCodeRange> sortedList = sort.sortUsingStartRange(zipCodeRangeList);
		
		MergeOverlappingZipCodeRange mergeRange = new MergeOverlappingZipCodeRange();
		List<ZipCodeRange> finalRange = mergeRange.merge(sortedList);
		
		return finalRange;
	}

	/**
	 * This method adds ZipCodeRange to the list 
	 * */
	private void addToList() {
		ZipCodeRange range = new ZipCodeRange(getStartRange(), getEndRange());
		zipCodeRangeList.add(range);
	}

	/**
	 * @param inputRange each range given in the initial input
	 * @return boolean whether the given range is in a valid form or not
	 * 
	 * This method takes the range as a parameter and do all kind of checks on it to make sure 
	 * that it is valid otherwise returns false
	 * */
	public boolean isLegal(String inputRange) {
		String[] checkInput = inputRange.replaceAll("\\[|\\]", "").split(",");
		if(checkInput.length != 2) return false;
		
		startRange = Integer.parseInt(checkInput[0]);
		endRange = Integer.parseInt(checkInput[1]);
		
		if(isLengthFive(startRange) && isLengthFive(endRange)){
			if(startRange <= endRange){
				return true;
			}else return false;
		}else return false;
		
	}

	/**
	 * @param zipCodeValue each zip code value
	 * @return true/false depending on if valid zip code length or not
	 * 
	 * This method takes the zip code and checks if it is of length 5 or not
	 * 
	 * */
	public boolean isLengthFive(int zipCodeValue) {
		int length = (int) Math.log10(zipCodeValue) + 1;
	    if (length != 5)
	      return false;
	    return true;
		  
	}
	
	public int getEndRange() {
		return endRange;
	}

	public int getStartRange() {
		return startRange;
	}
}
