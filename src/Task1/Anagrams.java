package Task1;

import java.util.*;

public class Anagrams {
	// necessary for visual comparison
	private String inputString;
	private StringBuilder outputStringBuilder;

	public Anagrams(String source) {
		inputString = source.replaceAll("  ", " ");
		outputStringBuilder = new StringBuilder();
	}

	public void process() {
		ArrayList<String> wordsArray = new ArrayList<>();
		Collections.addAll(wordsArray, inputString.split(" "));

		// use collect to assemble results string
		outputStringBuilder = wordsArray.parallelStream().collect(StringBuilder::new,
				(sBuilder, word) -> sBuilder.append(reverseWord(word)),
				(sBuilder1, sBuilder2) -> sBuilder1.append(sBuilder2));
	}

	private StringBuilder reverseWord(String someWord) {
		// i want to refuse of index manipulating, so i use 2 iterators in function walkingReversely
		LinkedList<String> letterList = new LinkedList<>();
		Collections.addAll(letterList, someWord.split(""));

		// travel linked list
		StringBuilder strBuilder = walkingReversely(letterList);

		// separate current word from another
		strBuilder.append(" ");

		return strBuilder;
	}

	private StringBuilder walkingReversely(LinkedList<String> letterList) {
		StringBuilder strBuilder = new StringBuilder();
		Iterator<String> iterator = letterList.listIterator(), descIterator = letterList.descendingIterator();

		// char has useful method isLetter
		char LetterOrOther;

		while (iterator.hasNext()) {
			// at previous step i split my string, so i get element length by one char
			LetterOrOther = iterator.next().charAt(0);
			if (Character.isLetter(LetterOrOther)) {

				do {
					LetterOrOther = descIterator.next().charAt(0);
				} while (!Character.isLetter(LetterOrOther));
				// 1. both iterators point to the letter, get letter from desc iterator
				strBuilder.append(LetterOrOther);

				// 2. asc iterator point to non letter symbol, it stay on the same place
			} else
				strBuilder.append(LetterOrOther);
		}
		return strBuilder;

	}

	@Override
	public String toString() {
		return outputStringBuilder.toString().trim();
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
