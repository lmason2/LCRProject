import java.util.Random;

/**
 * Luke Mason, Sami, Cole, Lauren
 * LCRDice.java
 * LCR Dice class which inherits from
 *  more generic Dice.java with added functionality
 * v. 1.0
 */

public class LCRDice{
    // Data
    int sideUp;


    // Methods

    /**
     * Constructor that sets the sideUp to negative 1 until rolled
     */
    public LCRDice() {
        sideUp = -1;
    }

    /**
     * Roll function that sets the bound to 6 (rolls [0,5])
     * @return The string representation of the roll
     */
    public String roll() {
        Random random = new Random();
        sideUp = random.nextInt(6);
        return String.valueOf(sideUp);
    }
}
