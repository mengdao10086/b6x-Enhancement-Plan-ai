package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.h1;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class x2<T> extends LiveData<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RoomDatabase f7563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Callable<T> f7565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final f1 f7566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final h1.c f7567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicBoolean f7568r = new AtomicBoolean(true);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicBoolean f7569s = new AtomicBoolean(false);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f7570t = new AtomicBoolean(false);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Runnable f7571u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Runnable f7572v = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @g.j1
        public void run() {
            boolean z10;
            if (x2.this.f7570t.compareAndSet(false, true)) {
                x2.this.f7563m.o().b(x2.this.f7567q);
            }
            do {
                if (x2.this.f7569s.compareAndSet(false, true)) {
                    T tCall = null;
                    z10 = false;
                    while (x2.this.f7568r.compareAndSet(true, false)) {
                        try {
                            try {
                                tCall = x2.this.f7565o.call();
                                z10 = true;
                            } catch (Exception e10) {
                                throw new RuntimeException("Exception while computing database live data.", e10);
                            }
                        } finally {
                            x2.this.f7569s.set(false);
                        }
                    }
                    if (z10) {
                        x2.this.o(tCall);
                    }
                } else {
                    z10 = false;
                }
                if (!z10) {
                    return;
                }
            } while (x2.this.f7568r.get());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        @g.k0
        public void run() {
            boolean zH = x2.this.h();
            if (x2.this.f7568r.compareAndSet(false, true) && zH) {
                x2.this.t().execute(x2.this.f7571u);
            }
        }
    }

    public class c extends h1.c {
        public c(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.h1.c
        public void b(@g.n0 Set<String> set) {
            n.c.h().b(x2.this.f7572v);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public x2(RoomDatabase roomDatabase, f1 f1Var, boolean z10, Callable<T> callable, String[] strArr) {
        this.f7563m = roomDatabase;
        this.f7564n = z10;
        this.f7565o = callable;
        this.f7566p = f1Var;
        this.f7567q = new c(strArr);
    }

    @Override // androidx.lifecycle.LiveData
    public void m() {
        super.m();
        this.f7566p.b(this);
        t().execute(this.f7571u);
    }

    @Override // androidx.lifecycle.LiveData
    public void n() {
        super.n();
        this.f7566p.c(this);
    }

    public Executor t() {
        return this.f7564n ? this.f7563m.u() : this.f7563m.q();
    }
}
