package org.jctools.queues;

import org.jctools.queues.spec.ConcurrentQueueSpec;
import org.jctools.queues.spec.Ordering;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.jctools.util.ExperimentalTestUtil.makeVarHandle;
import static org.jctools.util.TestUtil.*;

@RunWith(Parameterized.class)
public class MpqSanityTestSpscVarHandleArray extends MpqSanityTestSpscArray
{
    public MpqSanityTestSpscVarHandleArray(ConcurrentQueueSpec spec, MessagePassingQueue<Integer> queue)
    {
        super(spec, queue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(makeVarHandle(1, 1, 4, Ordering.FIFO));// SPSC size 4
        list.add(makeVarHandle(1, 1, SIZE, Ordering.FIFO));// SPSC size SIZE
        return list;
    }
}
