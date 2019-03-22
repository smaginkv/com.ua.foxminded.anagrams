package ua.com.foxminded.anagrams;

public class Anagram {
    public String makeAnagram(String sentence) {
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
}
