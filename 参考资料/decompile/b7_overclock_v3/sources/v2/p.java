package v2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class p implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f52614g = androidx.work.l.f("WorkForegroundRunnable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<Void> f52615a = androidx.work.impl.utils.futures.a.u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f52616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2.r f52617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ListenableWorker f52618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.work.h f52619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w2.a f52620f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f52621a;

        public a(final androidx.work.impl.utils.futures.a val$foregroundFuture) {
            this.f52621a = val$foregroundFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f52621a.r(p.this.f52618d.d());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f52623a;

        public b(final androidx.work.impl.utils.futures.a val$foregroundFuture) {
            this.f52623a = val$foregroundFuture;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.work.g gVar = (androidx.work.g) this.f52623a.get();
                if (gVar == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", p.this.f52617c.f51843c));
                }
                androidx.work.l.c().a(p.f52614g, String.format("Updating notification for %s", p.this.f52617c.f51843c), new Throwable[0]);
                p.this.f52618d.u(true);
                p pVar = p.this;
                pVar.f52615a.r(pVar.f52619e.a(pVar.f52616b, pVar.f52618d.e(), gVar));
            } catch (Throwable th2) {
                p.this.f52615a.q(th2);
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public p(@n0 Context context, @n0 u2.r workSpec, @n0 ListenableWorker worker, @n0 androidx.work.h foregroundUpdater, @n0 w2.a taskExecutor) {
        this.f52616b = context;
        this.f52617c = workSpec;
        this.f52618d = worker;
        this.f52619e = foregroundUpdater;
        this.f52620f = taskExecutor;
    }

    @n0
    public ListenableFuture<Void> a() {
        return this.f52615a;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f52617c.f51857q || androidx.core.os.a.i()) {
            this.f52615a.p(null);
            return;
        }
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        this.f52620f.b().execute(new a(aVarU));
        aVarU.addListener(new b(aVarU), this.f52620f.b());
    }
}
