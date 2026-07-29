package androidx.work.multiprocess;

import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p.a<byte[], Void> f8688a = new a();

    public class a implements p.a<byte[], Void> {
        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void apply(byte[] bArr) {
            return null;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f8689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p.a f8690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f8691c;

        public b(ListenableFuture listenableFuture, p.a aVar, androidx.work.impl.utils.futures.a aVar2) {
            this.f8689a = listenableFuture;
            this.f8690b = aVar;
            this.f8691c = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f8691c.p(this.f8690b.apply(this.f8689a.get()));
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                this.f8691c.q(th);
            }
        }
    }

    @n0
    public static <I, O> ListenableFuture<O> a(@n0 ListenableFuture<I> listenableFuture, @n0 p.a<I, O> aVar, @n0 Executor executor) {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        listenableFuture.addListener(new b(listenableFuture, aVar, aVarU), executor);
        return aVarU;
    }
}
