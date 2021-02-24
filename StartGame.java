import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guess the Number game!");

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);

        boolean playAgain = true;
        while (playAgain) {
            Game game = new Game();
            boolean gameOver = false;
            int attempts = 0;

            System.out.println("I'm thinking of a number between 1 and 100.");
            while (!gameOver) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                gameOver = game.guess(guess);
                attempts++;
            }

            player.increaseScore();
            System.out.println(player.getName() + ", you guessed the number in " + attempts + " attempts.");
            System.out.println("Your score: " + player.getScore());

            System.out.print("Play again? (yes/no): ");
            String playAgainInput = scanner.nextLine().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}