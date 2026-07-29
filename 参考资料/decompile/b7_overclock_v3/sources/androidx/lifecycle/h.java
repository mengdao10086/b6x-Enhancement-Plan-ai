package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import g.i1;
import g.j1;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Executor f6196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final LiveData<T> f6197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final LiveData<T> f6198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final AtomicBoolean f6199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final AtomicBoolean f6200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Runnable f6201f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Runnable f6202g;

    public static final class a extends LiveData<T> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ h<T> f6203m;

        public a(h<T> hVar) {
            this.f6203m = hVar;
        }

        @Override // androidx.lifecycle.LiveData
        public void m() {
            this.f6203m.e().execute(this.f6203m.f6201f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @hk.i
    public h() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @hk.i
    public h(@yt.k Executor executor) {
        kotlin.jvm.internal.f0.p(executor, "executor");
        this.f6196a = executor;
        a aVar = new a(this);
        this.f6197b = aVar;
        this.f6198c = aVar;
        this.f6199d = new AtomicBoolean(true);
        this.f6200e = new AtomicBoolean(false);
        this.f6201f = new Runnable() { // from class: androidx.lifecycle.f
            @Override // java.lang.Runnable
            public final void run() {
                h.l(this.f6193a);
            }
        };
        this.f6202g = new Runnable() { // from class: androidx.lifecycle.g
            @Override // java.lang.Runnable
            public final void run() {
                h.k(this.f6195a);
            }
        };
    }

    @i1
    public static /* synthetic */ void g() {
    }

    @i1
    public static /* synthetic */ void i() {
    }

    public static final void k(h this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        boolean zH = this$0.h().h();
        if (this$0.f6199d.compareAndSet(false, true) && zH) {
            this$0.f6196a.execute(this$0.f6201f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(h this$0) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        do {
            boolean z10 = false;
            if (this$0.f6200e.compareAndSet(false, true)) {
                Object objC = null;
                boolean z11 = false;
                while (this$0.f6199d.compareAndSet(true, false)) {
                    try {
                        objC = this$0.c();
                        z11 = true;
                    } catch (Throwable th2) {
                        this$0.f6200e.set(false);
                        throw th2;
                    }
                }
                if (z11) {
                    this$0.h().o(objC);
                }
                this$0.f6200e.set(false);
                z10 = z11;
            }
            if (!z10) {
                return;
            }
        } while (this$0.f6199d.get());
    }

    @j1
    public abstract T c();

    @yt.k
    public final AtomicBoolean d() {
        return this.f6200e;
    }

    @yt.k
    public final Executor e() {
        return this.f6196a;
    }

    @yt.k
    public final AtomicBoolean f() {
        return this.f6199d;
    }

    @yt.k
    public LiveData<T> h() {
        return this.f6198c;
    }

    public void j() {
        n.c.h().b(this.f6202g);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ h(Executor executor, int i10, kotlin.jvm.internal.u uVar) {
        if ((i10 & 1) != 0) {
            executor = n.c.g();
            kotlin.jvm.internal.f0.o(executor, "getIOThreadExecutor()");
        }
        this(executor);
    }
}
