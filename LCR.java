import java.util.Scanner;

/**
 * Luke Mason, Sami, Cole, Lauren
 * LCR.java
 * Driver class for implementation of the
 *  game LCR with a twist
 * v. 1.0
 */

public class LCR {
    private static LCRPlayer[] playersArray; // Array of players in the game
    private static LCRCenterPot center = new LCRCenterPot(); // Center pot of the game

    /**
     * Main function that runs the driver class
     * @param args for command line arguments
     */
    public static void main(String[] args) {
        gameSetup();
        play();
    }

    /**
     * Play function that runs the game
     */
    private static void play() {
        printBoard();
        do {
            for (int i = 0; i < playersArray.length - 1; i++) {
                if (playersArray[i].isInGame()) {
                    System.out.print(i + ": ");
                    playersArray[i].rollDice();
                    playersArray[i].moveChips(playersArray, center, i);
                }
                printBoard();
            }
        } while (thereIsNoWinner());
    }

    /**
     * Setup function to get the number of players
     * from the user and initializes the players array
     */
    private static void gameSetup() {
        Scanner kb = new Scanner(System.in);
        int players;
        System.out.print("How many players are in the game?: ");
        players = Integer.parseInt(kb.next());
        playersArray = new LCRPlayer[players];
        for (int i = 0; i < players; i++) {
            playersArray[i] = new LCRPlayer();
        }
    }

    /**
     * Boolean function to tell if there is a winner of the game
     * @return true is there is no winner, false otherwise
     */
    private static Boolean thereIsNoWinner () {
        int playersInGame = 0;
        for (LCRPlayer lcrPlayer : playersArray) {
            if (lcrPlayer.isInGame()) {
                playersInGame += 1;
            }
            if (playersInGame > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Print function for debugging
     */
    private static void printBoard() {
        System.out.println("-------------------");
        System.out.println("Player        Chips");
        for (int i = 0; i < playersArray.length; i++) {
            System.out.println(i + "            " + playersArray[i].getChipNumber());
        }
        System.out.println("Center      " + center.getChipCount());
        System.out.println("-------------------");
    }
}



