import java.util.Random;

class Game {
    private int numberToGuess;
    private boolean isGameOver;

    public Game() {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        isGameOver = false;
    }

    public boolean guess(int guess) {
        if (isGameOver) {
            System.out.println("The game is over. You can't guess anymore.");
            return false;
        }

        if (guess < numberToGuess) {
            System.out.println("Too low! Try again.");
        } else if (guess > numberToGuess) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Congratulations! You guessed the number.");
            isGameOver = true;
        }

        return isGameOver;
    }
}
