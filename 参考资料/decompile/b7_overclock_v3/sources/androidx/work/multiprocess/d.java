package androidx.work.multiprocess;

import android.os.RemoteException;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class d<I> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f8651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f8652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListenableFuture<I> f8653c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class a<I> implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f8654b = androidx.work.l.f("ListenableCallbackRbl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<I> f8655a;

        public a(@n0 d<I> dVar) {
            this.f8655a = dVar;
        }

        public static void a(@n0 c cVar, @n0 Throwable th2) {
            try {
                cVar.d0(th2.getMessage());
            } catch (RemoteException e10) {
                androidx.work.l.c().b(f8654b, "Unable to notify failures in operation", e10);
            }
        }

        public static void b(@n0 c cVar, @n0 byte[] bArr) {
            try {
                cVar.z0(bArr);
            } catch (RemoteException e10) {
                androidx.work.l.c().b(f8654b, "Unable to notify successful operation", e10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                I i10 = this.f8655a.f8653c.get();
                d<I> dVar = this.f8655a;
                b(dVar.f8652b, dVar.b(i10));
            } catch (Throwable th2) {
                a(this.f8655a.f8652b, th2);
            }
        }
    }

    public d(@n0 Executor executor, @n0 c cVar, @n0 ListenableFuture<I> listenableFuture) {
        this.f8651a = executor;
        this.f8652b = cVar;
        this.f8653c = listenableFuture;
    }

    public void a() {
        this.f8653c.addListener(new a(this), this.f8651a);
    }

    @n0
    public abstract byte[] b(@n0 I i10);
}
