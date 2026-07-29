package androidx.activity;

import androidx.annotation.RestrictTo;
import g.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nFullyDrawnReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,192:1\n1#2:193\n1855#3,2:194\n*S KotlinDebug\n*F\n+ 1 FullyDrawnReporter.kt\nandroidx/activity/FullyDrawnReporter\n*L\n157#1:194,2\n*E\n"})
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Executor f1371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.a<z1> f1372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Object f1373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0("lock")
    public int f1374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b0("lock")
    public boolean f1375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b0("lock")
    public boolean f1376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    @b0("lock")
    public final List<ik.a<z1>> f1377g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final Runnable f1378h;

    public l(@yt.k Executor executor, @yt.k ik.a<z1> reportFullyDrawn) {
        f0.p(executor, "executor");
        f0.p(reportFullyDrawn, "reportFullyDrawn");
        this.f1371a = executor;
        this.f1372b = reportFullyDrawn;
        this.f1373c = new Object();
        this.f1377g = new ArrayList();
        this.f1378h = new Runnable() { // from class: androidx.activity.k
            @Override // java.lang.Runnable
            public final void run() {
                l.i(this.f1370a);
            }
        };
    }

    public static final void i(l this$0) {
        f0.p(this$0, "this$0");
        synchronized (this$0.f1373c) {
            this$0.f1375e = false;
            if (this$0.f1374d == 0 && !this$0.f1376f) {
                this$0.f1372b.o();
                this$0.d();
            }
            z1 z1Var = z1.f38230a;
        }
    }

    public final void b(@yt.k ik.a<z1> callback) {
        boolean z10;
        f0.p(callback, "callback");
        synchronized (this.f1373c) {
            if (this.f1376f) {
                z10 = true;
            } else {
                this.f1377g.add(callback);
                z10 = false;
            }
        }
        if (z10) {
            callback.o();
        }
    }

    public final void c() {
        synchronized (this.f1373c) {
            if (!this.f1376f) {
                this.f1374d++;
            }
            z1 z1Var = z1.f38230a;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void d() {
        synchronized (this.f1373c) {
            this.f1376f = true;
            Iterator<T> it2 = this.f1377g.iterator();
            while (it2.hasNext()) {
                ((ik.a) it2.next()).o();
            }
            this.f1377g.clear();
            z1 z1Var = z1.f38230a;
        }
    }

    public final boolean e() {
        boolean z10;
        synchronized (this.f1373c) {
            z10 = this.f1376f;
        }
        return z10;
    }

    public final void f() {
        if (this.f1375e || this.f1374d != 0) {
            return;
        }
        this.f1375e = true;
        this.f1371a.execute(this.f1378h);
    }

    public final void g(@yt.k ik.a<z1> callback) {
        f0.p(callback, "callback");
        synchronized (this.f1373c) {
            this.f1377g.remove(callback);
            z1 z1Var = z1.f38230a;
        }
    }

    public final void h() {
        synchronized (this.f1373c) {
            if (!this.f1376f) {
                int i10 = this.f1374d;
                if (!(i10 > 0)) {
                    throw new IllegalStateException("removeReporter() called when all reporters have already been removed.".toString());
                }
                this.f1374d = i10 - 1;
                f();
            }
            z1 z1Var = z1.f38230a;
        }
    }
}
