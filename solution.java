Here is a simple console application in Java that implements a hit counter for the past 5 minutes. This application uses a LinkedList to store the timestamps of the hits. When a hit is recorded, it adds the current timestamp to the end of the list. When the count is requested, it removes the timestamps more than 5 minutes ago from the front of the list, and returns the size of the list.

```java
import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    private Queue<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void recordHit() {
        int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
        hits.add(currentTimestamp);
    }

    public int getHits() {
        int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
        while (!hits.isEmpty()) {
            if (currentTimestamp - hits.peek() > 300) {
                hits.poll();
            } else {
                break;
            }
        }
        return hits.size();
    }

    public static void main(String[] args) throws InterruptedException {
        HitCounter counter = new HitCounter();
        counter.recordHit();
        Thread.sleep(1000);
        counter.recordHit();
        Thread.sleep(1000);
        counter.recordHit();
        Thread.sleep(1000);
        System.out.println("Hits in the last 5 minutes: " + counter.getHits());
        Thread.sleep(3000);
        System.out.println("Hits in the last 5 minutes: " + counter.getHits());
    }
}
```

This application records a hit every second for 3 seconds, then prints the number of hits in the past 5 minutes. It then waits for 3 more seconds and prints the number of hits in the past 5 minutes again. The output should be 3 for the first print statement and 0 for the second print statement.