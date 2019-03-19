package Task1;

import java.util.*;

public class Anagrams {
	// maybe it will be useful for visual comparison
	private String inputString;
	private String outputString;

	public Anagrams(String source) {
		inputString = source.replaceAll("  ", " ");
		outputString = "";
	}

	public void process() {
		outputString = "";
		//reverse every word in phrase
		for(String word: inputString.split(" ")) {
			outputString += reverseWord(word);
		}
	}

	private String reverseWord(String someWord) {
		//separate word from another
		String reverseWord = (outputString == "")? "":" ";		
		for(int i = 0, j = someWord.length();i < someWord.length();i++) {	
			if (Character.isLetter(someWord.charAt(i))) {

				do {
				} while (!Character.isLetter(someWord.charAt(--j)));
				// 1. both indexes point to the letter, get letter from desc index
				reverseWord += someWord.charAt(j);

				// 2. asc index point to non letter symbol, it stay on the same place
			} else
				reverseWord += someWord.charAt(i);
		}
		return  reverseWord;
	}
	
	@Override
	public String toString() {
		return outputString;
	}

	public String getInputString() {
		return inputString;
	}

	public static void main(String[] args) {
		Anagrams anagram = new Anagrams("a1bcd2ef1 3ghij 4  5");

		// to run calculations in constructor it is not best idea
		anagram.process();
		System.out.println(anagram.toString());
	}
}
