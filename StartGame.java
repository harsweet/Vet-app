import java.util.Scanner;

public class StartGame {
    static  Scanner scanner = new Scanner(System.in);

    private Player getGamePlayer() {
        System.out.println("Welcome to the Guess the Number game!");
        System.out.print("Enter your name: ");
        
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        return player;
    }

    private int getGuess() {
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        return guess;
    }

    private String getNewGameResponse(Player currPlayer, int attempts) {
        System.out.println(currPlayer.getName() + ", you guessed the number in " + attempts + " attempts.");
        System.out.println("Your score: " + currPlayer.getScore());

        System.out.print("Play again? (yes/no): ");
        String playAgainInput = scanner.nextLine().toLowerCase();
        return playAgainInput;
    }

    private void simulateGame(Player player) {
        boolean playAgain = true;
        while (playAgain) {
            Game game = new Game();
            boolean gameOver = false;
            int attempts = 0;

            System.out.println("I'm thinking of a number between 1 and 100.");
            while (!gameOver) {
                gameOver = game.guess(getGuess());
                attempts++;
            }

            player.increaseScore();
            playAgain = getNewGameResponse(player, attempts).equals("yes");
        }
        System.out.println("Thanks for playing!");
    }

    private void playGame() {
        Player gamePlayer = getGamePlayer();

        simulateGame(gamePlayer);
        scanner.close();
    }

    public static void main(String[] args) {
        StartGame newGame = new StartGame();
        newGame.playGame();
    }
}