package ua.com.foxminded.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Anagram anagram = new Anagram();
        String sentenceBefore, stringToConsole;

        InputStreamReader consoleStream = new InputStreamReader(System.in);
        BufferedReader consoleBuffer = new BufferedReader(consoleStream);
        System.out.println("Please, type in anagram, for input press ENTER");
        System.out.println("An empty line or Ctrl-Z terminates the program");
        while ((sentenceBefore = consoleBuffer.readLine()) != null && sentenceBefore.length() != 0) {
            stringToConsole = String.format("\"%s\" => \"%s\"", sentenceBefore, anagram.makeAnagram(sentenceBefore));
            System.out.println(stringToConsole);
        }
    }

}
