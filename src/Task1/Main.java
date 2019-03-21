package Task1;


public class Main {
    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String sentenceBefore = "abcd efgh", stringToConsole = "";
        stringToConsole = String.format("E.g. \"%s\" => \"%s\"", sentenceBefore, anagram.makeAnagram(sentenceBefore));
        System.out.println(stringToConsole);

        sentenceBefore = "a1bcd efg!h";
        stringToConsole = String.format("E.g. \"%s\" => \"%s\"", sentenceBefore, anagram.makeAnagram(sentenceBefore));
        System.out.println(stringToConsole);
    }

}
