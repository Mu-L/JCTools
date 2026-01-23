package org.jctools.queues.varhandle;

import org.jctools.util.InternalAPI;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

@InternalAPI
public final class VarHandleQueueUtil
{
    static final VarHandle REF_ARRAY_VAR_HANDLE = MethodHandles.arrayElementVarHandle(Object[].class);
    static final VarHandle LONG_ARRAY_VAR_HANDLE = MethodHandles.arrayElementVarHandle(long[].class);

    static VarHandle longFieldVarHandle(Class c, String field) {
        try {
            return MethodHandles.lookup().findVarHandle(c, field, long.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }
    public static <E> E lvRefElement(E[] buffer, int offset)
    {
        //noinspection unchecked
        return (E) REF_ARRAY_VAR_HANDLE.getVolatile(buffer, offset);
    }

    public static <E> E lpRefElement(E[] buffer, int offset)
    {
        return buffer[offset];
    }

    public static <E> void spRefElement(E[] buffer, int offset, E value)
    {
        buffer[offset] = value;
    }

    public static  <E> void soRefElement(E[] buffer, int offset, E value)
    {
        REF_ARRAY_VAR_HANDLE.setRelease(buffer, offset, value);
    }

    public static <E> void svRefElement(E[] buffer, int offset, E value)
    {
        REF_ARRAY_VAR_HANDLE.setVolatile(buffer, offset, value);
    }

    public static int calcRefElementOffset(long index)
    {
        return (int) index;
    }

    public static int calcCircularRefElementOffset(long index, long mask)
    {
        return (int) (index & mask);
    }

    public static <E> E[] allocateRefArray(int capacity)
    {
        //noinspection unchecked
        return (E[]) new Object[capacity];
    }

    public static void spLongElement(long[] buffer, int offset, long e)
    {
        buffer[offset] = e;
    }

    public static void soLongElement(long[] buffer, int offset, long e)
    {
        LONG_ARRAY_VAR_HANDLE.setRelease(buffer, offset, e);
    }

    public static long lpLongElement(long[] buffer, int offset)
    {
        return buffer[offset];
    }

    public static long lvLongElement(long[] buffer, int offset)
    {
        return (long)LONG_ARRAY_VAR_HANDLE.getVolatile(buffer, offset);
    }

    public static int calcLongElementOffset(long index)
    {
        return (int) index;
    }

    public static int calcCircularLongElementOffset(long index, long mask)
    {
        return (int) (index & mask);
    }

    public static long[] allocateLongArray(int capacity)
    {
        return new long[capacity];
    }

    public static int length(Object[] buf)
    {
        return buf.length;
    }

    /**
     * This method assumes index is actually (index << 1) because lower bit is used for resize hence the >> 1
     */
    public static int modifiedCalcCircularRefElementOffset(long index, long mask)
    {
        return (int) (index & mask) >> 1;
    }

    public static int nextArrayOffset(Object[] curr)
    {
        return length(curr) - 1;
    }

}
