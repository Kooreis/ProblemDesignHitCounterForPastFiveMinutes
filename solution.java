public void recordHit() {
        int currentTimestamp = (int) (System.currentTimeMillis() / 1000);
        hits.add(currentTimestamp);
    }