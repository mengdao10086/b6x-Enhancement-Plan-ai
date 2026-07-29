package lu;

import io.reactivex.exceptions.CompositeException;
import retrofit2.r;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T> extends z<r<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final retrofit2.b<T> f40465a;

    public static final class a implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f40466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f40467b;

        public a(retrofit2.b<?> bVar) {
            this.f40466a = bVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f40467b = true;
            this.f40466a.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f40467b;
        }
    }

    public c(retrofit2.b<T> bVar) {
        this.f40465a = bVar;
    }

    @Override // xi.z
    public void I5(g0<? super r<T>> g0Var) {
        boolean z10;
        retrofit2.b<T> bVarClone = this.f40465a.clone();
        a aVar = new a(bVarClone);
        g0Var.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        try {
            r<T> rVarX = bVarClone.X();
            if (!aVar.isDisposed()) {
                g0Var.onNext(rVarX);
            }
            if (aVar.isDisposed()) {
                return;
            }
            try {
                g0Var.onComplete();
            } catch (Throwable th2) {
                th = th2;
                z10 = true;
                io.reactivex.exceptions.a.b(th);
                if (z10) {
                    kj.a.Y(th);
                    return;
                }
                if (aVar.isDisposed()) {
                    return;
                }
                try {
                    g0Var.onError(th);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    kj.a.Y(new CompositeException(th, th3));
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z10 = false;
        }
    }
}
