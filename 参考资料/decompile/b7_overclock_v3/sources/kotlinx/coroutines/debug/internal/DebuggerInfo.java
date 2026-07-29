package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.s0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@s0
public final class DebuggerInfo implements Serializable {

    @l
    private final Long coroutineId;

    @l
    private final String dispatcher;

    @k
    private final List<StackTraceElement> lastObservedStackTrace;

    @l
    private final String lastObservedThreadName;

    @l
    private final String lastObservedThreadState;

    @l
    private final String name;
    private final long sequenceNumber;

    @k
    private final String state;

    public DebuggerInfo(@k DebugCoroutineInfoImpl debugCoroutineInfoImpl, @k CoroutineContext coroutineContext) {
        Thread.State state;
        m0 m0Var = (m0) coroutineContext.c(m0.f38908c);
        this.coroutineId = m0Var != null ? Long.valueOf(m0Var.k2()) : null;
        kotlin.coroutines.d dVar = (kotlin.coroutines.d) coroutineContext.c(kotlin.coroutines.d.f37759u2);
        this.dispatcher = dVar != null ? dVar.toString() : null;
        n0 n0Var = (n0) coroutineContext.c(n0.f38910c);
        this.name = n0Var != null ? n0Var.k2() : null;
        this.state = debugCoroutineInfoImpl.g();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.h();
        this.sequenceNumber = debugCoroutineInfoImpl.f38419b;
    }

    @l
    public final Long a() {
        return this.coroutineId;
    }

    @l
    public final String b() {
        return this.dispatcher;
    }

    @k
    public final List<StackTraceElement> c() {
        return this.lastObservedStackTrace;
    }

    @l
    public final String d() {
        return this.lastObservedThreadName;
    }

    @l
    public final String f() {
        return this.lastObservedThreadState;
    }

    @l
    public final String h() {
        return this.name;
    }

    public final long i() {
        return this.sequenceNumber;
    }

    @k
    public final String k() {
        return this.state;
    }
}
