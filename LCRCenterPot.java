/**
 * Luke Mason, Sami, Cole, Lauren
 * LCRCenterPot.java
 * Class that simulates the center pot of
 *  the game LCR
 * v. 1.0
 */

public class LCRCenterPot {
    // Data
    private int chipCount;


    // Methods

    /**
     * Constructor for the center pot that sets the chip count to 0
     */
    public LCRCenterPot() {
        chipCount = 0;
    }

    /**
     * Getter for chip count
     * @return the chip count
     */
    public int getChipCount() {
        return chipCount;
    }

    /**
     * Setter for chip count
     * @param chipCount sets the chip count for the pot
     */
    public void setChipCount(int chipCount) {
        this.chipCount = chipCount;
    }
}
