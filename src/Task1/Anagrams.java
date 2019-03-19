package Task1;

public class Anagrams {
	public String makeAnagram(String sentence) {
		return reverseString(sentence);
	}

	private String reverseString(String sentence) {
		String outputSentence = "";
		for (String word : sentence.split("[\\n|\\r|\\t|\\u0020]+")) {
			outputSentence += reverseWord(word);
		}
		return outputSentence.trim();
	}

	private String reverseWord(String word) {
		int wordLength = word.length();
		char[] reversedBuffer = new char[wordLength];
		char[] buffer = word.toCharArray();

		for (int i = 0; i < wordLength; i++) {
			reversedBuffer[wordLength - 1 - i] = buffer[i];
		}

		for (int i = 0, j = 0; i < wordLength; i++) {
			if (Character.isLetter(buffer[i])) {
				while (!Character.isLetter(reversedBuffer[j++])) {
				}
				;
				buffer[i] = reversedBuffer[j - 1];
			}
		}

		return String.copyValueOf(buffer) + '\u0020';
	}

	public static void main(String[] args) {
		Anagrams anagram = new Anagrams();
		String sentenceBefore = "a1bcd2ef1 3ghij" + '\n' + "4  5";
		String sentenceAfter = anagram.makeAnagram(sentenceBefore);
		System.out.println("Sentence before: " + sentenceBefore);
		System.out.println("Sentence after: " + sentenceAfter);
	}
}
