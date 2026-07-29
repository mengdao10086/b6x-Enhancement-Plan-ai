package lu;

import io.reactivex.exceptions.CompositeException;
import retrofit2.r;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> extends z<r<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final retrofit2.b<T> f40460a;

    public static final class a<T> implements io.reactivex.disposables.b, retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f40461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g0<? super r<T>> f40462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f40463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f40464d = false;

        public a(retrofit2.b<?> bVar, g0<? super r<T>> g0Var) {
            this.f40461a = bVar;
            this.f40462b = g0Var;
        }

        @Override // retrofit2.d
        public void a(retrofit2.b<T> bVar, Throwable th2) {
            if (bVar.W()) {
                return;
            }
            try {
                this.f40462b.onError(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                kj.a.Y(new CompositeException(th2, th3));
            }
        }

        @Override // retrofit2.d
        public void b(retrofit2.b<T> bVar, r<T> rVar) {
            if (this.f40463c) {
                return;
            }
            try {
                this.f40462b.onNext(rVar);
                if (this.f40463c) {
                    return;
                }
                this.f40464d = true;
                this.f40462b.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                if (this.f40464d) {
                    kj.a.Y(th2);
                    return;
                }
                if (this.f40463c) {
                    return;
                }
                try {
                    this.f40462b.onError(th2);
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    kj.a.Y(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f40463c = true;
            this.f40461a.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f40463c;
        }
    }

    public b(retrofit2.b<T> bVar) {
        this.f40460a = bVar;
    }

    @Override // xi.z
    public void I5(g0<? super r<T>> g0Var) {
        retrofit2.b<T> bVarClone = this.f40460a.clone();
        a aVar = new a(bVarClone, g0Var);
        g0Var.onSubscribe(aVar);
        if (aVar.isDisposed()) {
            return;
        }
        bVarClone.z(aVar);
    }
}
