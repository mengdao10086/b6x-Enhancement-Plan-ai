package al;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.s0;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,213:1\n1#2:214\n*E\n"})
@s0
public class c extends ExecutorCoroutineDispatcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final String f731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public CoroutineScheduler f732h;

    public /* synthetic */ c(int i10, int i11, long j10, String str, int i12, u uVar) {
        this(i10, i11, j10, (i12 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public static /* synthetic */ CoroutineDispatcher o2(c cVar, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
        }
        if ((i11 & 1) != 0) {
            i10 = 16;
        }
        return cVar.n2(i10);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        this.f732h.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        try {
            CoroutineScheduler.z(this.f732h, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.s0.f38948i.h2(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void i2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        try {
            CoroutineScheduler.z(this.f732h, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.s0.f38948i.i2(coroutineContext, runnable);
        }
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @yt.k
    public Executor m2() {
        return this.f732h;
    }

    @yt.k
    public final CoroutineDispatcher n2(int i10) {
        if (i10 > 0) {
            return new e(this, i10, null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i10).toString());
    }

    public final CoroutineScheduler p2() {
        return new CoroutineScheduler(this.f728d, this.f729e, this.f730f, this.f731g);
    }

    public final void q2(@yt.k Runnable runnable, @yt.k j jVar, boolean z10) {
        try {
            this.f732h.u(runnable, jVar, z10);
        } catch (RejectedExecutionException unused) {
            kotlinx.coroutines.s0.f38948i.F2(this.f732h.i(runnable, jVar));
        }
    }

    @yt.k
    public final CoroutineDispatcher r2(int i10) {
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i10).toString());
        }
        if (i10 <= this.f728d) {
            return new e(this, i10, null, 0);
        }
        throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.f728d + "), but have " + i10).toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        return super.toString() + "[scheduler = " + this.f732h + ']';
    }

    public c(int i10, int i11, long j10, @yt.k String str) {
        this.f728d = i10;
        this.f729e = i11;
        this.f730f = j10;
        this.f731g = str;
        this.f732h = p2();
    }

    public /* synthetic */ c(int i10, int i11, String str, int i12, u uVar) {
        this((i12 & 1) != 0 ? m.f751c : i10, (i12 & 2) != 0 ? m.f752d : i11, (i12 & 4) != 0 ? m.f749a : str);
    }

    public c(int i10, int i11, @yt.k String str) {
        this(i10, i11, m.f753e, str);
    }

    public /* synthetic */ c(int i10, int i11, int i12, u uVar) {
        this((i12 & 1) != 0 ? m.f751c : i10, (i12 & 2) != 0 ? m.f752d : i11);
    }

    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ c(int i10, int i11) {
        this(i10, i11, m.f753e, null, 8, null);
    }
}
