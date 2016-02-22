
/**
 * The NumberDisplay class represents a digital number display that can hold
 * values from zero to a given limit. The limit can be specified when creating
 * the display. The values range from zero (inclusive) to limit-1. If used,
 * for example, for the seconds on a digital clock, the limit would be 60, 
 * resulting in display values from 0 to 59. When incremented, the display 
 * automatically rolls over to zero when reaching the limit.
 * 
 * Isaiah Wesley
 * February 15, 2016
 */
public class NumberDisplay
{
    // instance variables - replace the example below with your own
    private int limit;
    private int value;
    /**
     * Constructor for objects of class NumberDisplay
     */
    public NumberDisplay(int rollOverLimit)
    {
        // initialise instance variables
        limit = rollOverLimit;
        value = 0;
    }
    /**
     * Returns value. 
     */
    public int getValue(){
        return value;
    }
    /**
     * Returns a string that displays the value under a set of conditions. 
     */
    public String getDisplayValue(){
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }
    /**
     * Replaces the limit value.
     */
    public void setValue(int replacementValue) {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = (value + 1) % limit;
        }
    }
    /**
     * Increments the time + 1. 
     */
    public void increment() {
        value = (value + 1) % limit;
    }
}
