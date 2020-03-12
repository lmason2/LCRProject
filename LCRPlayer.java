import java.util.Scanner;

/**
 * Luke Mason, Sami, Cole, Lauren
 * LCRPlayer.java
 * Class to simulate the object of a player
 *  in LCR for Software Development final project
 * v. 1.0
 */

public class LCRPlayer {
    // Data
    private int chipNumber;
    private String rollResult; // 0 = L; 1 = C; 2 = R; >=3 = Dot

    // Methods


    /**
     * Contructor for an LCR Player which initializes the chip number
     *  to 3 and sets the inGame variable to true
     */
    public LCRPlayer() {
        chipNumber = 3;
    }

    /**
     * Roll dice function which rolls a dice a number of times based
     *  on the chips that the player has
     */
    public void rollDice () {
        int diceNumber = chipNumber;
        rollResult = "";
        LCRDice dice = new LCRDice();

        if (chipNumber > 3) {
            // Player has more than 3 chips so the dice max of 3 has been reached
            diceNumber = 3;
        }

        for (int i = 0; i < diceNumber; i++) {
            rollResult += dice.roll();
        }
        System.out.println(rollResult); // Debugging purposes
    }

    /**
     * Function to move chips from player to player based on the string value built up from
     *  rollDice()
     * @param playersArray is the array of players passed from driver class
     * @param center is the center pot to be able to manipulate chip count
     * @param playerNumber is the number of players in the game
     */
    void moveChips(LCRPlayer[] playersArray, LCRCenterPot center, int playerNumber) {
        int moveIndex; // Represents index of where the chips need to go
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < rollResult.length(); i++) {
            if (rollResult.charAt(i) == '1') {
                // Chip goes to center pot
                center.setChipCount(center.getChipCount() + 1);
                chipNumber -= 1;
            }
            else if (rollResult.charAt(i) >= '3') {
                // Player rolled a dot
                System.out.print("Would you like to give your chip to another player? y/n: ");
                if (kb.next().equals("y")) {
                    System.out.print("\nWhich player would you like to give it to? [0," + (playersArray.length - 1) + "]: ");
                    moveIndex = Integer.parseInt(kb.next());
                    playersArray[moveIndex].setChipNumber(playersArray[moveIndex].getChipNumber() + 1);
                    chipNumber -= 1;
                }
            }
            else {
                // Chips either move left or right
                moveIndex = getMoveIndex(rollResult.charAt(i), playerNumber, playersArray.length);
                System.out.println("move index: " + moveIndex); // Debugging purposes
                playersArray[moveIndex].setChipNumber(playersArray[moveIndex].getChipNumber() + 1);
                chipNumber -= 1;
            }
        }
    }

    /**
     * The chip either move left or right and this function determines which direction and returns
     *  the index of the player that the chip is moved to
     * @param moveChar is the number that represents a left movement (0) or a right movement (1)
     * @param playerNumber is the index of the player who rolled the value
     * @param playersInGame is the number of players in the game used for indexing purposes
     * @return the index of the player to have the chip passed to
     */
    private static int getMoveIndex(char moveChar, int playerNumber, int playersInGame) {
        int moveIndex;
        if (moveChar == '0') {
            // Player rolled an 'L'
            moveIndex = playerNumber - 1;
            if (moveIndex < 0) {
                moveIndex = playersInGame - 1;
            }
        }
        else {
            // Player rolled an 'R'
            moveIndex = playerNumber + 1;
            if (moveIndex == playersInGame) {
                moveIndex = 0;
            }
        }
        return moveIndex;
    }


    /**
     * Getter for whether or not the player is in the game based on chip number
     * @return true if chip number does not equal 0
     */
    public Boolean isInGame() {
        return chipNumber != 0;
    }

    /**
     * Setter for the chip number
     * @param chipNumber is the number of chips the player has
     */
    public void setChipNumber(int chipNumber) {
        this.chipNumber = chipNumber;
    }

    /**
     * Getter for the chip number
     * @return the number of chips the player has
     */
    public int getChipNumber() {
        return chipNumber;
    }
}
