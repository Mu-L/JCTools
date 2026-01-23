package org.jctools.util;

import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;

import static org.jctools.util.VarHandleQueueFactory.newVarHandleQueue;

public class ExperimentalTestUtil extends TestUtil
{
    public static Object[] makeVarHandle(int producers, int consumers, int capacity, Ordering ordering)
    {
        ConcurrentQueueSpec spec = makeSpec(producers, consumers, capacity, ordering);
        return new Object[] {spec, newVarHandleQueue(spec)};
    }
}
