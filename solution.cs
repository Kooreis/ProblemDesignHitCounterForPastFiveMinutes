Here is a simple console application in C# that implements a hit counter for the past 5 minutes. It uses a Queue data structure to store the timestamps of the hits. When a hit is recorded, it is added to the queue. When the count is requested, it removes all hits that are older than 5 minutes from the front of the queue, then returns the count of the remaining hits.

```C#
using System;
using System.Collections.Generic;

public class HitCounter
{
    private Queue<DateTime> hits;

    public HitCounter()
    {
        hits = new Queue<DateTime>();
    }

    public void RecordHit()
    {
        hits.Enqueue(DateTime.Now);
    }

    public int GetHits()
    {
        while (hits.Count > 0 && DateTime.Now.Subtract(hits.Peek()).TotalMinutes > 5)
        {
            hits.Dequeue();
        }

        return hits.Count;
    }
}

class Program
{
    static void Main(string[] args)
    {
        HitCounter hitCounter = new HitCounter();

        string command;
        do
        {
            Console.WriteLine("Enter 'hit' to record a hit, 'count' to get the number of hits in the past 5 minutes, or 'exit' to quit.");
            command = Console.ReadLine();

            if (command == "hit")
            {
                hitCounter.RecordHit();
                Console.WriteLine("Hit recorded.");
            }
            else if (command == "count")
            {
                Console.WriteLine("Hits in the past 5 minutes: " + hitCounter.GetHits());
            }
        } while (command != "exit");
    }
}
```

This console application will keep running until the user enters 'exit'. It will record a hit when the user enters 'hit', and it will print the number of hits in the past 5 minutes when the user enters 'count'.