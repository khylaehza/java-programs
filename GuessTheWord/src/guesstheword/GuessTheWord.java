/*
 * Name: Khyla Ehza Hondrade
 * Activity: 06 Hands-on-Act-1
 * Description: Create a guessing game with IO file
 * Date Submitted: 11/18/2021
 */
package guesstheword;
import java.io.*;
import java.util.*;

public class GuessTheWord {

     // scanner
    public static char askUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your guess letter: ");
        char guessLetter = input.next().charAt(0);
        guessLetter = Character.toLowerCase(guessLetter);
        
        return guessLetter;
    }
        
    // replacing the word with '?'
    public static char[] replaceLetters(String word) {
        int replaceQuantity = (int) (Math.random() * (word.length() - 1));
        char[] replaceLetter = word.toCharArray();
        
        for(int index = 0; index <= replaceQuantity; index++) {
            int pos = (int) (Math.random() * (word.length() - 1));
            
            if (word.indexOf(word.charAt(pos)) == pos) {
                replaceLetter[pos] = '?';
            }
        }       
        return replaceLetter;      
    }
    
    // main method
    public static void main(String[] args) {
         ArrayList<String> wordList = new ArrayList<>();
        String words, randomWord;
        char[] incompleteWord;
        int wordsIndex;
        boolean willRepeat = true;
        
        try {
            // accessing the text file
            File fileName = new File("C:\\path\\words.txt");
            BufferedReader readWords = new BufferedReader(new FileReader(fileName));
            
            while((words = readWords.readLine()) != null) {
                wordList.add(words);
            }
                    
            wordsIndex = (int) (Math.random() * (wordList.size() - 1));
            randomWord = wordList.get(wordsIndex);           
            incompleteWord = replaceLetters(randomWord);

            System.out.println("WELCOME TO JAVA KEYWORDS GUESSING GAME!\n");
            System.out.print("Here is your word: ");
            System.out.println(incompleteWord);
            System.out.println();
            
            // checks if the user guess matches with the right letter
            while (willRepeat) {
                char userGuess = askUser();
                String convertGuess = Character.toString(userGuess);
                if(Arrays.toString(incompleteWord).contains(convertGuess)) {
                    System.out.println("Letter already exist.");
                } else if(randomWord.contains(convertGuess)) {
                    int i = randomWord.indexOf(userGuess);
                    for(int ind = 0; ind < randomWord.length(); ind++) {
                        incompleteWord[i] = userGuess;
  
                        if((!Arrays.toString(incompleteWord).contains("?")) || randomWord.toCharArray() == incompleteWord) {                      
                            willRepeat = false;
                        }                           
                    }
                    System.out.println(incompleteWord);
                } else {
                    System.out.println("You guessed a wrong letter. Try again.");
                }             
            }
            System.out.println("\nCONGRATULATIONS! You have completed the word!");
                    
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
