package okhttp3;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.t0;
import kotlin.z1;
import okhttp3.internal.connection.e;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<B\u0011\b\u0016\u0012\u0006\u0010:\u001a\u00020\u0014¢\u0006\u0004\b;\u0010=J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\nJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0019\u001a\b\u0018\u00010\u0002R\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J+\u0010\u001f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001f\u0010 R*\u0010!\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R*\u0010'\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R.\u00101\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010*8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00102R\u001e\u00107\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u0003048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001e\u00108\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u0003048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00106R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\u0003048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00106R\u0011\u0010:\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b5\u0010\u0016¨\u0006>"}, d2 = {"Lokhttp3/p;", "", "Lokhttp3/internal/connection/e$a;", "Lokhttp3/internal/connection/e;", f0.v.E0, "Lkotlin/z1;", "c", "(Lokhttp3/internal/connection/e$a;)V", "b", "d", "(Lokhttp3/internal/connection/e;)V", "h", "i", "", "Lokhttp3/e;", "n", "p", "", "o", "q", "Ljava/util/concurrent/ExecutorService;", "a", "()Ljava/util/concurrent/ExecutorService;", "", xl.e.f55523k, "f", "", m0.k.f40564b, i1.a.f31577d5, "Ljava/util/Deque;", "calls", "g", "(Ljava/util/Deque;Ljava/lang/Object;)V", "maxRequests", "I", "k", "()I", an.aB, "(I)V", "maxRequestsPerHost", com.flydigi.sdk.bluetooth.l.f16298a, "t", "Ljava/lang/Runnable;", "<set-?>", "Ljava/lang/Runnable;", xf.j.f55230b, "()Ljava/lang/Runnable;", SsManifestParser.e.J, "(Ljava/lang/Runnable;)V", "idleCallback", "Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "Ljava/util/ArrayDeque;", "e", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "runningAsyncCalls", "runningSyncCalls", "executorService", "<init>", "()V", "(Ljava/util/concurrent/ExecutorService;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public Runnable f43930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public ExecutorService f43931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ArrayDeque<e.a> f43932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final ArrayDeque<e.a> f43933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final ArrayDeque<okhttp3.internal.connection.e> f43934g;

    public p() {
        this.f43928a = 64;
        this.f43929b = 5;
        this.f43932e = new ArrayDeque<>();
        this.f43933f = new ArrayDeque<>();
        this.f43934g = new ArrayDeque<>();
    }

    @hk.h(name = "-deprecated_executorService")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "executorService", imports = {}))
    @yt.k
    public final ExecutorService a() {
        return e();
    }

    public final synchronized void b() {
        Iterator<e.a> it2 = this.f43932e.iterator();
        while (it2.hasNext()) {
            it2.next().b().cancel();
        }
        Iterator<e.a> it3 = this.f43933f.iterator();
        while (it3.hasNext()) {
            it3.next().b().cancel();
        }
        Iterator<okhttp3.internal.connection.e> it4 = this.f43934g.iterator();
        while (it4.hasNext()) {
            it4.next().cancel();
        }
    }

    public final void c(@yt.k e.a call) {
        e.a aVarF;
        kotlin.jvm.internal.f0.p(call, "call");
        synchronized (this) {
            this.f43932e.add(call);
            if (!call.b().n() && (aVarF = f(call.d())) != null) {
                call.f(aVarF);
            }
            z1 z1Var = z1.f38230a;
        }
        m();
    }

    public final synchronized void d(@yt.k okhttp3.internal.connection.e call) {
        kotlin.jvm.internal.f0.p(call, "call");
        this.f43934g.add(call);
    }

    @hk.h(name = "executorService")
    @yt.k
    public final synchronized ExecutorService e() {
        ExecutorService executorService;
        if (this.f43931d == null) {
            this.f43931d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), rl.f.Y(kotlin.jvm.internal.f0.C(rl.f.f48804i, " Dispatcher"), false));
        }
        executorService = this.f43931d;
        kotlin.jvm.internal.f0.m(executorService);
        return executorService;
    }

    public final e.a f(String str) {
        for (e.a aVar : this.f43933f) {
            if (kotlin.jvm.internal.f0.g(aVar.d(), str)) {
                return aVar;
            }
        }
        for (e.a aVar2 : this.f43932e) {
            if (kotlin.jvm.internal.f0.g(aVar2.d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    public final <T> void g(Deque<T> deque, T t10) {
        Runnable runnableJ;
        synchronized (this) {
            if (!deque.remove(t10)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnableJ = j();
            z1 z1Var = z1.f38230a;
        }
        if (m() || runnableJ == null) {
            return;
        }
        runnableJ.run();
    }

    public final void h(@yt.k e.a call) {
        kotlin.jvm.internal.f0.p(call, "call");
        call.c().decrementAndGet();
        g(this.f43933f, call);
    }

    public final void i(@yt.k okhttp3.internal.connection.e call) {
        kotlin.jvm.internal.f0.p(call, "call");
        g(this.f43934g, call);
    }

    @yt.l
    public final synchronized Runnable j() {
        return this.f43930c;
    }

    public final synchronized int k() {
        return this.f43928a;
    }

    public final synchronized int l() {
        return this.f43929b;
    }

    public final boolean m() {
        int i10;
        boolean z10;
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e.a> it2 = this.f43932e.iterator();
            kotlin.jvm.internal.f0.o(it2, "readyAsyncCalls.iterator()");
            while (it2.hasNext()) {
                e.a asyncCall = it2.next();
                if (this.f43933f.size() >= k()) {
                    break;
                }
                if (asyncCall.c().get() < l()) {
                    it2.remove();
                    asyncCall.c().incrementAndGet();
                    kotlin.jvm.internal.f0.o(asyncCall, "asyncCall");
                    arrayList.add(asyncCall);
                    this.f43933f.add(asyncCall);
                }
            }
            z10 = q() > 0;
            z1 z1Var = z1.f38230a;
        }
        int size = arrayList.size();
        for (i10 = 0; i10 < size; i10++) {
            ((e.a) arrayList.get(i10)).a(e());
        }
        return z10;
    }

    @yt.k
    public final synchronized List<e> n() {
        List<e> listUnmodifiableList;
        ArrayDeque<e.a> arrayDeque = this.f43932e;
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(arrayDeque, 10));
        Iterator<T> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            arrayList.add(((e.a) it2.next()).b());
        }
        listUnmodifiableList = Collections.unmodifiableList(arrayList);
        kotlin.jvm.internal.f0.o(listUnmodifiableList, "unmodifiableList(readyAsyncCalls.map { it.call })");
        return listUnmodifiableList;
    }

    public final synchronized int o() {
        return this.f43932e.size();
    }

    @yt.k
    public final synchronized List<e> p() {
        List<e> listUnmodifiableList;
        ArrayDeque<okhttp3.internal.connection.e> arrayDeque = this.f43934g;
        ArrayDeque<e.a> arrayDeque2 = this.f43933f;
        ArrayList arrayList = new ArrayList(kotlin.collections.t.Y(arrayDeque2, 10));
        Iterator<T> it2 = arrayDeque2.iterator();
        while (it2.hasNext()) {
            arrayList.add(((e.a) it2.next()).b());
        }
        listUnmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.y4(arrayDeque, arrayList));
        kotlin.jvm.internal.f0.o(listUnmodifiableList, "unmodifiableList(running…yncCalls.map { it.call })");
        return listUnmodifiableList;
    }

    public final synchronized int q() {
        return this.f43933f.size() + this.f43934g.size();
    }

    public final synchronized void r(@yt.l Runnable runnable) {
        this.f43930c = runnable;
    }

    public final void s(int i10) {
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("max < 1: ", Integer.valueOf(i10)).toString());
        }
        synchronized (this) {
            this.f43928a = i10;
            z1 z1Var = z1.f38230a;
        }
        m();
    }

    public final void t(int i10) {
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("max < 1: ", Integer.valueOf(i10)).toString());
        }
        synchronized (this) {
            this.f43929b = i10;
            z1 z1Var = z1.f38230a;
        }
        m();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p(@yt.k ExecutorService executorService) {
        this();
        kotlin.jvm.internal.f0.p(executorService, "executorService");
        this.f43931d = executorService;
    }
}
