package okhttp3.internal.connection;

import f0.v;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import okhttp3.internal.connection.e;
import okhttp3.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001d\u0018\u0000 \u00032\u00020\u0001:\u0001\u000eB'\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010!¨\u0006*"}, d2 = {"Lokhttp3/internal/connection/f;", "", "", "f", "d", "Lokhttp3/a;", m7.a.f40701a, "Lokhttp3/internal/connection/e;", v.E0, "", "Lokhttp3/f0;", "routes", "", "requireMultiplexed", "a", "Lokhttp3/internal/connection/RealConnection;", xl.e.f55522j, "Lkotlin/z1;", "h", "c", "e", "", "now", "b", "g", "I", "maxIdleConnections", "J", "keepAliveDurationNs", "okhttp3/internal/connection/f$b", "Lokhttp3/internal/connection/f$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "Lul/d;", "taskRunner", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lul/d;IJLjava/util/concurrent/TimeUnit;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final a f43850f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f43852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final ul.c f43853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final b f43854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final ConcurrentLinkedQueue<RealConnection> f43855e;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/f$a;", "", "Lokhttp3/j;", "connectionPool", "Lokhttp3/internal/connection/f;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final f a(@k j connectionPool) {
            f0.p(connectionPool, "connectionPool");
            return connectionPool.c();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/f$b", "Lul/a;", "", "f", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b extends ul.a {
        public b(String str) {
            super(str, false, 2, null);
        }

        @Override // ul.a
        public long f() {
            return f.this.b(System.nanoTime());
        }
    }

    public f(@k ul.d taskRunner, int i10, long j10, @k TimeUnit timeUnit) {
        f0.p(taskRunner, "taskRunner");
        f0.p(timeUnit, "timeUnit");
        this.f43851a = i10;
        this.f43852b = timeUnit.toNanos(j10);
        this.f43853c = taskRunner.j();
        this.f43854d = new b(f0.C(rl.f.f48804i, " ConnectionPool"));
        this.f43855e = new ConcurrentLinkedQueue<>();
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(f0.C("keepAliveDuration <= 0: ", Long.valueOf(j10)).toString());
        }
    }

    public final boolean a(@k okhttp3.a address, @k e call, @l List<okhttp3.f0> list, boolean z10) {
        f0.p(address, "address");
        f0.p(call, "call");
        for (RealConnection connection : this.f43855e) {
            f0.o(connection, "connection");
            synchronized (connection) {
                if (z10) {
                    if (!connection.A()) {
                    }
                    z1 z1Var = z1.f38230a;
                }
                if (connection.y(address, list)) {
                    call.c(connection);
                    return true;
                }
                z1 z1Var2 = z1.f38230a;
            }
        }
        return false;
    }

    public final long b(long j10) {
        int i10 = 0;
        long j11 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i11 = 0;
        for (RealConnection connection : this.f43855e) {
            f0.o(connection, "connection");
            synchronized (connection) {
                if (g(connection, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long jU = j10 - connection.u();
                    if (jU > j11) {
                        realConnection = connection;
                        j11 = jU;
                    }
                    z1 z1Var = z1.f38230a;
                }
            }
        }
        long j12 = this.f43852b;
        if (j11 < j12 && i10 <= this.f43851a) {
            if (i10 > 0) {
                return j12 - j11;
            }
            if (i11 > 0) {
                return j12;
            }
            return -1L;
        }
        f0.m(realConnection);
        synchronized (realConnection) {
            if (!realConnection.s().isEmpty()) {
                return 0L;
            }
            if (realConnection.u() + j11 != j10) {
                return 0L;
            }
            realConnection.H(true);
            this.f43855e.remove(realConnection);
            rl.f.q(realConnection.d());
            if (this.f43855e.isEmpty()) {
                this.f43853c.a();
            }
            return 0L;
        }
    }

    public final boolean c(@k RealConnection connection) {
        f0.p(connection, "connection");
        if (rl.f.f48803h && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
        }
        if (!connection.v() && this.f43851a != 0) {
            ul.c.p(this.f43853c, this.f43854d, 0L, 2, null);
            return false;
        }
        connection.H(true);
        this.f43855e.remove(connection);
        if (!this.f43855e.isEmpty()) {
            return true;
        }
        this.f43853c.a();
        return true;
    }

    public final int d() {
        return this.f43855e.size();
    }

    public final void e() {
        Socket socketD;
        Iterator<RealConnection> it2 = this.f43855e.iterator();
        f0.o(it2, "connections.iterator()");
        while (it2.hasNext()) {
            RealConnection connection = it2.next();
            f0.o(connection, "connection");
            synchronized (connection) {
                if (connection.s().isEmpty()) {
                    it2.remove();
                    connection.H(true);
                    socketD = connection.d();
                } else {
                    socketD = null;
                }
            }
            if (socketD != null) {
                rl.f.q(socketD);
            }
        }
        if (this.f43855e.isEmpty()) {
            this.f43853c.a();
        }
    }

    public final int f() {
        boolean zIsEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.f43855e;
        int i10 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection it2 : concurrentLinkedQueue) {
                f0.o(it2, "it");
                synchronized (it2) {
                    zIsEmpty = it2.s().isEmpty();
                }
                if (zIsEmpty && (i10 = i10 + 1) < 0) {
                    CollectionsKt__CollectionsKt.V();
                }
            }
        }
        return i10;
    }

    public final int g(RealConnection realConnection, long j10) {
        if (rl.f.f48803h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List<Reference<e>> listS = realConnection.s();
        int i10 = 0;
        while (i10 < listS.size()) {
            Reference<e> reference = listS.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                zl.h.f58636a.g().o("A connection to " + realConnection.b().d().w() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                listS.remove(i10);
                realConnection.H(true);
                if (listS.isEmpty()) {
                    realConnection.G(j10 - this.f43852b);
                    return 0;
                }
            }
        }
        return listS.size();
    }

    public final void h(@k RealConnection connection) {
        f0.p(connection, "connection");
        if (!rl.f.f48803h || Thread.holdsLock(connection)) {
            this.f43855e.add(connection);
            ul.c.p(this.f43853c, this.f43854d, 0L, 2, null);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }
}
