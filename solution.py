Here is a simple Python console application that uses a deque (double-ended queue) to store the timestamps of hits. When a hit is recorded, it is added to the right side of the deque. When the count of hits in the last 5 minutes is requested, timestamps older than 5 minutes are removed from the left side of the deque. The count of hits in the last 5 minutes is then the number of timestamps remaining in the deque.

```python
import time
from collections import deque

class HitCounter:
    def __init__(self):
        self.hits = deque()

    def record_hit(self):
        self.hits.append(time.time())

    def hits_in_last_five_minutes(self):
        while self.hits and time.time() - self.hits[0] > 300:
            self.hits.popleft()
        return len(self.hits)

def main():
    counter = HitCounter()
    while True:
        print("Enter 'h' to record a hit or 'c' to count the hits in the last 5 minutes.")
        command = input()
        if command == 'h':
            counter.record_hit()
        elif command == 'c':
            print(f"There have been {counter.hits_in_last_five_minutes()} hits in the last 5 minutes.")

if __name__ == "__main__":
    main()
```

This application runs in an infinite loop, waiting for the user to enter commands. If the user enters 'h', a hit is recorded. If the user enters 'c', the number of hits in the last 5 minutes is printed.