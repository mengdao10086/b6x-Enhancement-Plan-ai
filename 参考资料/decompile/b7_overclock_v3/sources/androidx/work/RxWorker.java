package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import g.k0;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;
import xi.h0;
import xi.i0;
import xi.l0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RxWorker extends ListenableWorker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Executor f8286g = new v2.n();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public a<ListenableWorker.a> f8287f;

    public static class a<T> implements l0<T>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final androidx.work.impl.utils.futures.a<T> f8288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public io.reactivex.disposables.b f8289b;

        public a() {
            androidx.work.impl.utils.futures.a<T> aVarU = androidx.work.impl.utils.futures.a.u();
            this.f8288a = aVarU;
            aVarU.addListener(this, RxWorker.f8286g);
        }

        public void a() {
            io.reactivex.disposables.b bVar = this.f8289b;
            if (bVar != null) {
                bVar.dispose();
            }
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.f8288a.q(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f8289b = bVar;
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            this.f8288a.p(t10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f8288a.isCancelled()) {
                a();
            }
        }
    }

    public RxWorker(@n0 Context context, @n0 WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @n0
    public final xi.a A(@n0 d dVar) {
        return xi.a.T(t(dVar));
    }

    @n0
    @Deprecated
    public final i0<Void> B(@n0 d dVar) {
        return i0.i0(t(dVar));
    }

    @Override // androidx.work.ListenableWorker
    public void r() {
        super.r();
        a<ListenableWorker.a> aVar = this.f8287f;
        if (aVar != null) {
            aVar.a();
            this.f8287f = null;
        }
    }

    @Override // androidx.work.ListenableWorker
    @n0
    public ListenableFuture<ListenableWorker.a> w() {
        this.f8287f = new a<>();
        y().c1(z()).H0(lj.b.b(k().d())).a(this.f8287f);
        return this.f8287f.f8288a;
    }

    @k0
    @n0
    public abstract i0<ListenableWorker.a> y();

    @n0
    public h0 z() {
        return lj.b.b(c());
    }
}
