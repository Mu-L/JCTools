package org.jctools.queues;

import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.jctools.util.ExperimentalTestUtil.*;

@RunWith(Parameterized.class)
public class MpqSanityTestMpmcVarHandleArray extends MpqSanityTestMpmcArray
{
    public MpqSanityTestMpmcVarHandleArray(ConcurrentQueueSpec spec, MessagePassingQueue<Integer> queue)
    {
        super(spec, queue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(makeVarHandle(0, 0, 2, Ordering.FIFO));
        list.add(makeVarHandle(0, 0, SIZE, Ordering.FIFO));
        return list;
    }
}
