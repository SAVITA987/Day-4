package test;

import java.util.Random;

public class SnakeAndLadder {

	     // UC 1 to UC 5: Single Player Game
	    private static void playGameWithSinglePlayer() {
	        int playerPosition = 0;
	        int diceRollCount = 0;

	        while (playerPosition < 100) {
	            int diceNumber = rollDice();
	            int option = getOption();
	            
	            switch (option) {
	                case 0:
	                    // No Play
	                    break;
	                case 1:
	                    // Ladder
	                    playerPosition += diceNumber;
	                    break;
	                case 2:
	                    // Snake
	                    playerPosition -= diceNumber;
	                    break;
	            }

	            // Ensure the player position is not below 0
	            if (playerPosition < 0) {
	                playerPosition = 0;
	            }

	            // Ensure the player gets to the exact winning position 100
	            if (playerPosition > 100) {
	                playerPosition -= diceNumber;
	            }

	            System.out.println("Dice Roll: " + diceNumber + ", Option: " + option + ", Position: " + playerPosition);
	            diceRollCount++;
	        }

	        System.out.println("Player won the game in " + diceRollCount + " dice rolls.");
	    }

	    // UC 6 and UC 7: Two Player Game
	    private static void playGameWithTwoPlayers() {
	        int player1Position = 0;
	        int player2Position = 0;

	        while (player1Position < 100 && player2Position < 100) {
	            // Player 1's turn
	            player1Position = playTurn(player1Position, "Player 1");

	            // Check if Player 1 won
	            if (player1Position >= 100) {
	                System.out.println("Player 1 won the game.");
	                break;
	            }

	            // Player 2's turn
	            player2Position = playTurn(player2Position, "Player 2");

	            // Check if Player 2 won
	            if (player2Position >= 100) {
	                System.out.println("Player 2 won the game.");
	                break;
	            }
	        }
	    }

	    private static int playTurn(int currentPosition, String playerName) {
	        int diceNumber = rollDice();
	        int option = getOption();

	        switch (option) {
	            case 0:
	                // No Play
	                break;
	            case 1:
	                // Ladder
	                currentPosition += diceNumber;
	                break;
	            case 2:
	                // Snake
	                currentPosition -= diceNumber;
	                break;
	        }

	        // Ensure the player position is not below 0
	        if (currentPosition < 0) {
	            currentPosition = 0;
	        }

	        // Ensure the player gets to the exact winning position 100
	        if (currentPosition > 100) {
	            currentPosition -= diceNumber;
	        }

	        System.out.println(playerName + " - Dice Roll: " + diceNumber + ", Option: " + option + ", Position: " + currentPosition);

	        // If the player gets a ladder, play again
	        if (option == 1) {
	            currentPosition = playTurn(currentPosition, playerName);
	        }

	        return currentPosition;
	    }

	    private static int rollDice() {
	        // Generate a random number between 1 and 6
	        Random random = new Random();
	        return random.nextInt(6) + 1;
	    }

	    private static int getOption() {
	        // Generate a random number between 0 and 2 (0: No Play, 1: Ladder, 2: Snake)
	        Random random = new Random();
	        return random.nextInt(3);
	    }
	    
	    public static void main(String[] args) {
	        playGameWithSinglePlayer();
	        playGameWithTwoPlayers();
	    }	
}

