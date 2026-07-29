package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import com.google.common.util.concurrent.ListenableFuture;
import g.i1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.List;
import l2.i;
import q2.c;
import q2.d;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8553k = l.f("ConstraintTrkngWrkr");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8554l = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WorkerParameters f8555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f8556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f8557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.work.impl.utils.futures.a<ListenableWorker.a> f8558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public ListenableWorker f8559j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.C();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8561a;

        public b(final ListenableFuture val$innerFuture) {
            this.f8561a = val$innerFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f8556g) {
                if (ConstraintTrackingWorker.this.f8557h) {
                    ConstraintTrackingWorker.this.B();
                } else {
                    ConstraintTrackingWorker.this.f8558i.r(this.f8561a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(@n0 Context appContext, @n0 WorkerParameters workerParams) {
        super(appContext, workerParams);
        this.f8555f = workerParams;
        this.f8556g = new Object();
        this.f8557h = false;
        this.f8558i = androidx.work.impl.utils.futures.a.u();
    }

    public void A() {
        this.f8558i.p(ListenableWorker.a.a());
    }

    public void B() {
        this.f8558i.p(ListenableWorker.a.d());
    }

    public void C() {
        String strA = g().A(f8554l);
        if (TextUtils.isEmpty(strA)) {
            l.c().b(f8553k, "No worker to delegate to.", new Throwable[0]);
            A();
            return;
        }
        ListenableWorker listenableWorkerB = n().b(a(), strA, this.f8555f);
        this.f8559j = listenableWorkerB;
        if (listenableWorkerB == null) {
            l.c().a(f8553k, "No worker to delegate to.", new Throwable[0]);
            A();
            return;
        }
        r rVarU = z().W().u(e().toString());
        if (rVarU == null) {
            A();
            return;
        }
        d dVar = new d(a(), k(), this);
        dVar.d(Collections.singletonList(rVarU));
        if (!dVar.c(e().toString())) {
            l.c().a(f8553k, String.format("Constraints not met for delegate %s. Requesting retry.", strA), new Throwable[0]);
            B();
            return;
        }
        l.c().a(f8553k, String.format("Constraints met for delegate %s", strA), new Throwable[0]);
        try {
            ListenableFuture<ListenableWorker.a> listenableFutureW = this.f8559j.w();
            listenableFutureW.addListener(new b(listenableFutureW), c());
        } catch (Throwable th2) {
            l lVarC = l.c();
            String str = f8553k;
            lVarC.a(str, String.format("Delegated worker %s threw exception in startWork.", strA), th2);
            synchronized (this.f8556g) {
                if (this.f8557h) {
                    l.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                    B();
                } else {
                    A();
                }
            }
        }
    }

    @Override // q2.c
    public void b(@n0 List<String> workSpecIds) {
        l.c().a(f8553k, String.format("Constraints changed for %s", workSpecIds), new Throwable[0]);
        synchronized (this.f8556g) {
            this.f8557h = true;
        }
    }

    @Override // q2.c
    public void f(@n0 List<String> workSpecIds) {
    }

    @Override // androidx.work.ListenableWorker
    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public w2.a k() {
        return i.H(a()).O();
    }

    @Override // androidx.work.ListenableWorker
    public boolean o() {
        ListenableWorker listenableWorker = this.f8559j;
        return listenableWorker != null && listenableWorker.o();
    }

    @Override // androidx.work.ListenableWorker
    public void r() {
        super.r();
        ListenableWorker listenableWorker = this.f8559j;
        if (listenableWorker == null || listenableWorker.p()) {
            return;
        }
        this.f8559j.x();
    }

    @Override // androidx.work.ListenableWorker
    @n0
    public ListenableFuture<ListenableWorker.a> w() {
        c().execute(new a());
        return this.f8558i;
    }

    @i1
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableWorker y() {
        return this.f8559j;
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public WorkDatabase z() {
        return i.H(a()).M();
    }
}
