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
public class MpqSanityTestMpscVarHandleArray extends MpqSanityTestMpscArray
{
    public MpqSanityTestMpscVarHandleArray(ConcurrentQueueSpec spec, MessagePassingQueue<Integer> queue)
    {
        super(spec, queue);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> parameters()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        list.add(makeVarHandle(0, 1, 1, Ordering.FIFO));// MPSC size 1
        list.add(makeVarHandle(0, 1, SIZE, Ordering.FIFO));// MPSC size SIZE
        return list;
    }
}
