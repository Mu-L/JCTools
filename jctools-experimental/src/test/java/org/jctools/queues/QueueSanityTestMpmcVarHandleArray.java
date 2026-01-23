package org.jctools.queues;

import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;

import static org.jctools.util.ExperimentalTestUtil.makeVarHandle;

@RunWith(Parameterized.class)
public class QueueSanityTestMpmcVarHandleArray extends QueueSanityTestMpmcArray
{
    public QueueSanityTestMpmcVarHandleArray(ConcurrentQueueSpec spec, Queue<Integer> queue)
    {
        super(spec, queue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        // Mpmc minimal size is 2
        list.add(makeVarHandle(0, 0, 2, Ordering.FIFO));
        list.add(makeVarHandle(0, 0, SIZE, Ordering.FIFO));
        return list;
    }
}
