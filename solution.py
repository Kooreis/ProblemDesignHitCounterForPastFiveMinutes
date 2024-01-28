class HitCounter:
    def __init__(self):
        self.hits = deque()

    def record_hit(self):
        self.hits.append(time.time())

    def hits_in_last_five_minutes(self):
        while self.hits and time.time() - self.hits[0] > 300:
            self.hits.popleft()
        return len(self.hits)