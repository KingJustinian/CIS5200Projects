package cis5200.project4;

import java.util.Comparator;

/**
 * CIS5200-W01
 * Project 4, Time Priority Queue
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Time1 implements Comparator<Time1> {
    private int hour; // 0 - 23
    private int minute; // 0 - 59
    private int second; // 0 - 59

    // set a new time value using universal time; throw an
   // exception if the hour, minute or second is invalid
   public void setTime(int hour, int minute, int second) {
      // validate hour, minute and second
      if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 ||
         second < 0 || second >= 60) {
         throw new IllegalArgumentException(
            "hour, minute and/or second was out of range");
      }

      this.hour = hour;
      this.minute = minute;
      this.second = second;
   }

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString() {
      return String.format("%02d:%02d:%02d", hour, minute, second);
   }

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d:%02d:%02d %s",
         ((hour == 0 || hour == 12) ? 12 : hour % 12),
         minute, second, (hour < 12 ? "AM" : "PM"));
   }
   
   public int calculateTotalTimeInSeconds()
   {
       return (hour * 3600) + (minute * 60) + second;
   }

    @Override
    public int compare(Time1 t, Time1 t1) {
        if (t.calculateTotalTimeInSeconds() < t1.calculateTotalTimeInSeconds()) {
            // Smaller values infer higher priority, so the order needs to be lower
            return -1;
        } else if (t.calculateTotalTimeInSeconds() > t1.calculateTotalTimeInSeconds()) {
            return 1;
        } else {
            return 0;
        }
    }
}
