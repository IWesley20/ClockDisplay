
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero. 
 *
 * Isaiah Wesley 
 * February 15, 2016
 */
public class ClockDisplay
{
    // instance variables - replace the example below with your own
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayInternationalString;
    private String displayUSString;
 
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplayInternational();
        updateDisplayUS();
    }
 
    /**
     * Constructor for ClockDisplay objects.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }
 
    /**
     * The timeTick method makes the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplayInternational();
        updateDisplayUS();
    }
 
    /**
     * Sets the time of the display to the specified hour and minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplayInternational();
        updateDisplayUS();       
    }
 
    /**
     * Return the current time of this display in the format 00:00.
     */
    public String getInternationalTime()
    {
        return displayInternationalString;
    }
     /**
      * Returns the specified string. 
      */
    public String getUSTime()
    {
        return displayUSString;
    }
     
        /**
     * Updates the internal string that represents the display.
     */
    private void updateDisplayInternational()
    {
        displayInternationalString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
         
      } 
       /**
        * Updates display for standard time structure. 
        */
    private void updateDisplayUS()
    {
         
        if(hours.getValue() < 12)
         {
             displayUSString = hours.getDisplayValue() + ":" +
            minutes.getDisplayValue() + " am";
         }
                 
       else if(hours.getValue() > 12 && hours.getValue() <24)
          {
            displayUSString = Integer.toString(hours.getValue() - 12) + ":" + 
            minutes.getDisplayValue() + " pm";
          }
       else if(hours.getValue() == 0) 
         {
            hours.setValue(12); 
            displayUSString = hours.getDisplayValue() + ":"+
            minutes.getDisplayValue() + " am";    
                       
         }  
              
       else
        {
         hours.setValue(12);
         displayUSString = hours.getDisplayValue() + ":" + 
                    minutes.getDisplayValue() + " pm";
       }
   }
}