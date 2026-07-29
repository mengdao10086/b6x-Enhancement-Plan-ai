package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nLimitedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,134:1\n66#1,8:135\n66#1,8:143\n28#2,4:151\n28#2,4:156\n20#3:155\n20#3:160\n*S KotlinDebug\n*F\n+ 1 LimitedDispatcher.kt\nkotlinx/coroutines/internal/LimitedDispatcher\n*L\n48#1:135,8\n55#1:143,8\n79#1:151,4\n92#1:156,4\n79#1:155\n92#1:160\n*E\n"})
public final class q extends CoroutineDispatcher implements kotlinx.coroutines.w0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38824h = AtomicIntegerFieldUpdater.newUpdater(q.class, "runningWorkers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final CoroutineDispatcher f38825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.w0 f38827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final w<Runnable> f38828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final Object f38829g;

    @hk.v
    private volatile int runningWorkers;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public Runnable f38830a;

        public a(@yt.k Runnable runnable) {
            this.f38830a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f38830a.run();
                } catch (Throwable th2) {
                    kotlinx.coroutines.l0.b(EmptyCoroutineContext.f37755a, th2);
                }
                Runnable runnableP2 = q.this.p2();
                if (runnableP2 == null) {
                    return;
                }
                this.f38830a = runnableP2;
                i10++;
                if (i10 >= 16 && q.this.f38825c.j2(q.this)) {
                    q.this.f38825c.h2(q.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(@yt.k CoroutineDispatcher coroutineDispatcher, int i10) {
        this.f38825c = coroutineDispatcher;
        this.f38826d = i10;
        kotlinx.coroutines.w0 w0Var = coroutineDispatcher instanceof kotlinx.coroutines.w0 ? (kotlinx.coroutines.w0) coroutineDispatcher : null;
        this.f38827e = w0Var == null ? kotlinx.coroutines.t0.a() : w0Var;
        this.f38828f = new w<>(false);
        this.f38829g = new Object();
    }

    @Override // kotlinx.coroutines.w0
    @yt.k
    public g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
        return this.f38827e.h1(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        Runnable runnableP2;
        this.f38828f.a(runnable);
        if (f38824h.get(this) >= this.f38826d || !q2() || (runnableP2 = p2()) == null) {
            return;
        }
        this.f38825c.h2(this, new a(runnableP2));
    }

    @Override // kotlinx.coroutines.w0
    public void i(long j10, @yt.k kotlinx.coroutines.o<? super z1> oVar) {
        this.f38827e.i(j10, oVar);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @y1
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        Runnable runnableP2;
        this.f38828f.a(runnable);
        if (f38824h.get(this) >= this.f38826d || !q2() || (runnableP2 = p2()) == null) {
            return;
        }
        this.f38825c.i2(this, new a(runnableP2));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @s1
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        r.a(i10);
        return i10 >= this.f38826d ? this : super.k2(i10);
    }

    @Override // kotlinx.coroutines.w0
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @yt.l
    public Object m1(long j10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return this.f38827e.m1(j10, cVar);
    }

    public final void o2(Runnable runnable, ik.l<? super a, z1> lVar) {
        Runnable runnableP2;
        this.f38828f.a(runnable);
        if (f38824h.get(this) < this.f38826d && q2() && (runnableP2 = p2()) != null) {
            lVar.i(new a(runnableP2));
        }
    }

    public final Runnable p2() {
        while (true) {
            Runnable runnableH = this.f38828f.h();
            if (runnableH != null) {
                return runnableH;
            }
            synchronized (this.f38829g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38824h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f38828f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean q2() {
        synchronized (this.f38829g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38824h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f38826d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
