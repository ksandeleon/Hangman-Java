
public abstract class Hangman {
	
	//randomly fetches the word to be guessed by the player from the words database and sets it to lowercases. 
	public abstract String getSecretWord();
	
	//outputs the current state of the board, including blanks for unknown letters, correctly guessed letters, and the parts of the hangman figure that have been revealed so far based on the number of incorrect guesses. guessed is a list of letters that have been guessed already.
	public abstract void displayBoard();
	
	//gets the player's letter guess and returns it. Should validate that they entered a single letter.
	public abstract void getGuess();
	
	//Checks if the letter guess is in the target word. Returns True if it is, False if it isn't.
	public abstract boolean checkGuess(char letter);
	
	//updates the board display with the new guess by replacing blanks with correctly guessed letters. Returns an updated board string.
	public abstract void updateBoard(char letter);
	
	//
	public abstract boolean checkLose();
	
	public abstract void gameLoop();

	
}
