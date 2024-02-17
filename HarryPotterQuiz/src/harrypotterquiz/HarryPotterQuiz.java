/***********************************************************************************************************************************
*  Author: Khyla Ehza Hondrade
*  Activity Type: 12 Task Performance 1/Final Exam - ARG	
*  
*  Program Name: HarryPotterQuiz
*  Description: Create a simple 5-question quiz with three (3) choices that will display the score of the user. 
*  Date Created: 1/22/2021
***********************************************************************************************************************************/

package harrypotterquiz;
import java.util.Scanner;
public class HarryPotterQuiz {
	public static void main(String[] args) {
		/* Uses of the main method:
		 *	1. To initialize the questions, choices, and answer list.
		 *  2. To call the takeQuiz method.
		 *	3. To display the score by calling the displayScore method. */	
			
		String[] questionList = {
			"What shape is Harry's scar?",
			"Who is the oldest Weasley child?",
			"Who or what killed Severus Snape?",
			"What is the name of Harry's snowy owl?",
			"Who does Harry sit with on the Hogwarts Express?"	
		};
		String[][] choicesList = {
			{"A. Moon", 	"B. Owl", 		"C. Lightning Bolt"},
			{"A. Charlie",  "B. Bill", 		"C. Percy"},
			{"A. Nagini", 	"B. Dumbledore","C. Buckbeak"},
			{"A. Hellium", 	"B. Hedwig", 	"C. Henry"},
			{"A. Hermione", "B. Neville", 	"C. Ron"}
		};
		
		char[] answerList = {'C', 'B', 'A', 'B', 'C'};
		
		System.out.println("Welcome to Harry Potter Quiz Game! Please type the letter of your answer.");
		int score = takeQuiz(questionList, choicesList, answerList);
		displayScore(score);
	}
	
	public static int takeQuiz(String[] _questionList, String[][] _choicesList, char[] _answerList) {
		/* Uses of the takeQuiz method:
		 *	1. To print the questions and choices through looping.
		 *  2. To ask the answers of user.
		 *	3. To return the score (points that were incremented if the user gets the correct answer). */
		
		Scanner scanner = new Scanner(System.in);
		int score = 0;
			
		for(int questionItem = 1; questionItem <= _questionList.length; questionItem++) {
			System.out.printf("%d. %s\n", questionItem, _questionList[questionItem-1]);
			
			for(int choicesItem = 1; choicesItem <= _choicesList[questionItem-1].length; choicesItem++) {
				System.out.printf("\t%s\n", _choicesList[questionItem-1][choicesItem-1]);
			}
			
			System.out.print("Your answer: ");
			char answer = scanner.next().charAt(0);
			System.out.println();
			
			if(_answerList[questionItem - 1] == answer) {
				score++;
			}
		}
		return score;
	}
	
	public static void displayScore(int _score) {
		/* Use of the displayScore method:
		 *    To print the score of the user with feedback. */
		
		int totalItems = 5;
		switch(_score) {
			case 5:
			case 4:
			case 3:
				System.out.printf("Congratulations! You got %d/%d!", _score, totalItems);
				break;
			case 2:
			case 1:
				System.out.printf("Oops! You only got %d/%d!", _score, totalItems);
				break;
			case 0:
				System.out.printf("You got %d/%d! Please study more!", _score, totalItems);
				break;
		}
	}
}