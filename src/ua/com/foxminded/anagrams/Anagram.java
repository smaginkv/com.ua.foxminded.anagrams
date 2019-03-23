package ua.com.foxminded.anagrams;

public class Anagram {

    final String ONE_OR_MULTIPLE_WHITESPACES_REGEXP = "[\\n|\\r|\\t| ]+";

    public String makeAnagram(String sentence) {
        String outputSentence = "";
        for (String word : sentence.split(ONE_OR_MULTIPLE_WHITESPACES_REGEXP)) {
            outputSentence += reverseWord(word);
        }
        return outputSentence.trim();
    }

    private String reverseWord(String word) {
        int wordLength = word.length();
        // two buffers used for change place letter for one travel
        char[] reversedBuffer = new char[wordLength];
        char[] buffer = word.toCharArray();

        // fill reverse buffer
        for (int i = 0; i < wordLength; i++) {
            reversedBuffer[wordLength - 1 - i] = buffer[i];
        }

        // travel direct buffer
        for (int i = 0, j = 0; i < wordLength; i++) {
            if (Character.isLetter(buffer[i])) {
                while (!Character.isLetter(reversedBuffer[j])) {
                    j++;
                }
                ;
                // if it is letter change to reverse letter
                buffer[i] = reversedBuffer[j++];
            }
        }

        return String.copyValueOf(buffer) + " ";
    }
}
