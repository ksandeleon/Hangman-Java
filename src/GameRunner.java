import java.util.Scanner;
import java.util.Random;

public class GameRunner extends Hangman{
	
	Random random = new Random();
	GameWords gameWords = new GameWords();
	Scanner scanner = new Scanner(System.in);
	
	String secretWord = getSecretWord();
	String userGuess;
	String board = "_";
	
	
	@Override
	public String getSecretWord() {
		String randomWord;
		
		randomWord = gameWords.wordList[random.nextInt(gameWords.wordList.length)];
		
		return randomWord.toLowerCase();
	}
	
	
	@Override
	public void displayBoard() {
		
		for(int i = 1; i < secretWord.length(); i++) {
			board += " _";
		}
		
		System.out.println(board);
	}
	
	
	@Override
	public void getGuess() {
		String input;
		
		do {
		    System.out.println("Guess a Letter: ");
		    input = scanner.next();
		} while (input.length() != 1);
		
		userGuess = input.toLowerCase();
	}

	
	@Override
	public void checkGuess() {
		char playerGuess = userGuess.charAt(0);
		for(int position = 0; position < secretWord.length(); position++) {	
			char letter = secretWord.charAt(position);
			if (letter == playerGuess) {
				updateBoard();
			}
			
		}
		
	}
	

	@Override
	public void updateBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkWin() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		GameArt art = new GameArt();
		GameRunner runner = new GameRunner();

		
		int maxGuesses = 6;
		boolean endOfGame = false;
		
		
		
		System.out.println(art.logo[0]);
		
		runner.displayBoard();
		runner.getGuess();
		runner.checkGuess();
		

	}



	
}
