package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public static final Method f38789a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f38789a = method;
    }

    public static /* synthetic */ void a() {
    }

    @yt.k
    public static final <E> Set<E> b(int i10) {
        return Collections.newSetFromMap(new IdentityHashMap(i10));
    }

    public static final boolean c(@yt.k Executor executor) {
        Method method;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor == null || (method = f38789a) == null) {
                return false;
            }
            method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final <T> T d(@yt.k ReentrantLock reentrantLock, @yt.k ik.a<? extends T> aVar) {
        reentrantLock.lock();
        try {
            return aVar.o();
        } finally {
            kotlin.jvm.internal.c0.d(1);
            reentrantLock.unlock();
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
