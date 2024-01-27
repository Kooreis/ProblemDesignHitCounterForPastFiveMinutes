using System;
using System.Collections.Generic;

public class HitCounter
{
    private Queue<DateTime> hits;

    public HitCounter()
    {
        hits = new Queue<DateTime>();
    }
}