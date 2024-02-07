import java.util.Scanner;
import java.util.Random;

public class GameRunner extends Hangman{
	
	Scanner scanner = new Scanner(System.in);
	GameWords gameWords = new GameWords();
	Random random = new Random();
	GameArt art = new GameArt();
	
	String secretWord = getSecretWord();
	boolean endOfGame = false;
	String board = "_";
	char userGuess;
	int hearts = 6;
	
	
	@Override
	public String getSecretWord() {
		String randomWord;
		
		randomWord = gameWords.wordList[random.nextInt(gameWords.wordList.length)];
		return randomWord.toLowerCase();
	}
	
	
	@Override
	public void displayBoard() {
		for(int i = 0; i < secretWord.length(); i++) {
			board += "_ ";
		}
		System.out.println(board);
		System.out.println(secretWord);
	}
	
	
	@Override
	public void getGuess() {
		String input;
		
		do {
		    System.out.println("Guess a Letter: ");
		    input = scanner.next();
		} while (input.length() != 1);
		userGuess = input.toLowerCase().charAt(0);
	}

	
	@Override
	public boolean checkGuess(char letter) {
		for(int position = 0; position < secretWord.length(); position++) {	
			if (letter == secretWord.charAt(position)) {
				return true;
			} 
		}
		hearts -= 1;
		return false;
	}
	

	@Override
	public void updateBoard(char letter) {
		
		for(int position = 0; position < secretWord.length(); position++) {
			if (letter == secretWord.charAt(position)) {
				board += letter;
			}else {
				board += "_ ";
			}
		}
		System.out.println(board);
		System.out.println(secretWord);
	}

	@Override
	public boolean checkLose() {
		if (hearts == 0) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public void gameLoop() {
		
		while (!endOfGame) {
			
			while(!endOfGame)
			System.out.println(art.logo[0]);
			
			displayBoard();
			getGuess();
			
			if (checkGuess(userGuess)) {
				updateBoard(userGuess);
			}
			
			if (checkLose()) {
				System.out.println("get gud kid");
				endOfGame = true;
			}
					
		}
	}
	
	
	public static void main(String[] args) {
		
		GameRunner runner = new GameRunner();
		runner.displayBoard();
		//runner.gameLoop();
		while(true) {
			
			runner.getGuess();
			
			if (runner.checkGuess(runner.userGuess)) {
				runner.updateBoard(runner.userGuess);
			}
		}
		
		
	}
}
