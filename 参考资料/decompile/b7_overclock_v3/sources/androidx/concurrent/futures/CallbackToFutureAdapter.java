package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public final class CallbackToFutureAdapter {

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c<T> f2910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.concurrent.futures.a<Void> f2911c = androidx.concurrent.futures.a.u();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2912d;

        public void a(@n0 Runnable runnable, @n0 Executor executor) {
            androidx.concurrent.futures.a<Void> aVar = this.f2911c;
            if (aVar != null) {
                aVar.addListener(runnable, executor);
            }
        }

        public void b() {
            this.f2909a = null;
            this.f2910b = null;
            this.f2911c.p(null);
        }

        public boolean c(T t10) {
            this.f2912d = true;
            c<T> cVar = this.f2910b;
            boolean z10 = cVar != null && cVar.b(t10);
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean d() {
            this.f2912d = true;
            c<T> cVar = this.f2910b;
            boolean z10 = cVar != null && cVar.a(true);
            if (z10) {
                e();
            }
            return z10;
        }

        public final void e() {
            this.f2909a = null;
            this.f2910b = null;
            this.f2911c = null;
        }

        public boolean f(@n0 Throwable th2) {
            this.f2912d = true;
            c<T> cVar = this.f2910b;
            boolean z10 = cVar != null && cVar.c(th2);
            if (z10) {
                e();
            }
            return z10;
        }

        public void finalize() {
            androidx.concurrent.futures.a<Void> aVar;
            c<T> cVar = this.f2910b;
            if (cVar != null && !cVar.isDone()) {
                cVar.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f2909a));
            }
            if (this.f2912d || (aVar = this.f2911c) == null) {
                return;
            }
            aVar.p(null);
        }
    }

    public interface b<T> {
        @p0
        Object a(@n0 a<T> aVar) throws Exception;
    }

    public static final class c<T> implements ListenableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<a<T>> f2913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractResolvableFuture<T> f2914b = new a();

        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public String m() {
                a<T> aVar = c.this.f2913a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f2909a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f2913a = new WeakReference<>(aVar);
        }

        public boolean a(boolean z10) {
            return this.f2914b.cancel(z10);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(@n0 Runnable runnable, @n0 Executor executor) {
            this.f2914b.addListener(runnable, executor);
        }

        public boolean b(T t10) {
            return this.f2914b.p(t10);
        }

        public boolean c(Throwable th2) {
            return this.f2914b.q(th2);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a<T> aVar = this.f2913a.get();
            boolean zCancel = this.f2914b.cancel(z10);
            if (zCancel && aVar != null) {
                aVar.b();
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return this.f2914b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f2914b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f2914b.isDone();
        }

        public String toString() {
            return this.f2914b.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, @n0 TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f2914b.get(j10, timeUnit);
        }
    }

    @n0
    public static <T> ListenableFuture<T> a(@n0 b<T> bVar) {
        a<T> aVar = new a<>();
        c<T> cVar = new c<>(aVar);
        aVar.f2910b = cVar;
        aVar.f2909a = bVar.getClass();
        try {
            Object objA = bVar.a(aVar);
            if (objA != null) {
                aVar.f2909a = objA;
            }
        } catch (Exception e10) {
            cVar.c(e10);
        }
        return cVar;
    }
}
