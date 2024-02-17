/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 12 eLMS Activity 1 - ARG	
*  
*  Program Name: Recursion Vowels
*  Description: Write a recursive method that will return the number of vowels in a given string.
*  Date Created: 1/21/2021
***********************************************************************************************************************************/

package recursionvowels;
public class RecursionVowels {
	public static void main(String[] args) {
		
		final String SENTENCE = "The quick brown fox jumped over the lazy dog."; //Initialize a constant variable
		System.out.println("Number of vowels: " + vowelCounter(SENTENCE, SENTENCE.length())); //Outputs after calling the vowelCounter recursion.
	}
	
	//Method that returns 1 if the letter is vowel
	public static int vowelIdentifier(char letter) {
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			return 1;
		} else {
			return 0;
		}
	}
	
	//Recursion method that counts the vowel
	public static int vowelCounter(String sentence, int sentenceLength) {
		if(sentenceLength == 1) {
			return vowelIdentifier(sentence.charAt(sentenceLength - 1)); //Base case
		} else {
			return vowelCounter(sentence, sentenceLength - 1) + vowelIdentifier(sentence.charAt(sentenceLength - 1)); //General case that calls the vowelIdentifier to add the number of vowels
		}
	}
}