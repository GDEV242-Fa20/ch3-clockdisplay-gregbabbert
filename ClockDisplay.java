
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Greg Babbert
 * @version 2020.09.26
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String meridian;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00 AM.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        meridian = "AM";
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at a time between 0 and 23.
     * Meridian value should either be "AM" or "PM"
     */
    public ClockDisplay(int hour, int minute, String meridian)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        this.meridian = meridian;
        setTime(hour, minute, meridian);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (hours.getValue() == 11) {
                meridian = "PM";
            }
            if (hours.getValue() == 0) {
                meridian = "AM";
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute. Hour should be between 0 and 23.
     * Meridian should be "AM" or "PM"
     */
    public void setTime(int hour, int minute, String meridian)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        this.meridian = meridian;
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM meridian.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Return the 12 hour internal display.
     */
    public String get24HourInternalDisplay()
    {
        return displayString;
    }
     
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue() + " " + meridian;
    }
}
