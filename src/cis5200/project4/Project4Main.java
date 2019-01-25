package cis5200.project4;

import java.security.SecureRandom;
import java.util.PriorityQueue;

/**
 * CIS5200-W01
 * Project 4, Time Priority Queue
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project4Main {
    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();
        
        Time1 time0 = new Time1();
        time0.setTime(generator.nextInt(24), generator.nextInt(60), generator.nextInt(60));
        Time1 time1 = new Time1();
        time1.setTime(generator.nextInt(24), generator.nextInt(60), generator.nextInt(60));
        Time1 time2 = new Time1();
        time2.setTime(generator.nextInt(24), generator.nextInt(60), generator.nextInt(60));
        Time1 time3 = new Time1();
        time3.setTime(generator.nextInt(24), generator.nextInt(60), generator.nextInt(60));
        Time1 time4 = new Time1();
        time4.setTime(generator.nextInt(24), generator.nextInt(60), generator.nextInt(60));
        
        System.out.printf("Time0 universal time: %s" + System.lineSeparator(), 
                time0.toUniversalString());
        System.out.printf("Time1 universal time: %s" + System.lineSeparator(), 
                time1.toUniversalString());
        System.out.printf("Time2 universal time: %s" + System.lineSeparator(), 
                time2.toUniversalString());
        System.out.printf("Time3 universal time: %s" + System.lineSeparator(), 
                time3.toUniversalString());
        System.out.printf("Time4 universal time: %s" + System.lineSeparator(), 
                time4.toUniversalString());
  
        
        PriorityQueue<Time1> queue = new PriorityQueue<>(5, new Time1());
        queue.offer(time0);
        queue.offer(time1);
        queue.offer(time2);
        queue.offer(time3);
        queue.offer(time4);
        
        while (queue.size() > 0) {
            System.out.printf("Queue peek: %s" + System.lineSeparator(), 
                    queue.peek().toUniversalString());
            
            queue.poll();
        }
    }
}
