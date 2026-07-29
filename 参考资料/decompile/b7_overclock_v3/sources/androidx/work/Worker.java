package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;
import g.j1;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Worker extends ListenableWorker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.work.impl.utils.futures.a<ListenableWorker.a> f8297f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.f8297f.p(Worker.this.y());
            } catch (Throwable th2) {
                Worker.this.f8297f.q(th2);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(@n0 Context context, @n0 WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override // androidx.work.ListenableWorker
    @n0
    public final ListenableFuture<ListenableWorker.a> w() {
        this.f8297f = androidx.work.impl.utils.futures.a.u();
        c().execute(new a());
        return this.f8297f;
    }

    @j1
    @n0
    public abstract ListenableWorker.a y();
}
