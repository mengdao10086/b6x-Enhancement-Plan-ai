package lu;

import io.reactivex.exceptions.CompositeException;
import retrofit2.r;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class e<T> extends z<d<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<r<T>> f40470a;

    public static class a<R> implements g0<r<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0<? super d<R>> f40471a;

        public a(g0<? super d<R>> g0Var) {
            this.f40471a = g0Var;
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            this.f40471a.onNext(d.d(rVar));
        }

        @Override // xi.g0
        public void onComplete() {
            this.f40471a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            try {
                this.f40471a.onNext(d.b(th2));
                this.f40471a.onComplete();
            } catch (Throwable th3) {
                try {
                    this.f40471a.onError(th3);
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    kj.a.Y(new CompositeException(th3, th4));
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f40471a.onSubscribe(bVar);
        }
    }

    public e(z<r<T>> zVar) {
        this.f40470a = zVar;
    }

    @Override // xi.z
    public void I5(g0<? super d<T>> g0Var) {
        this.f40470a.c(new a(g0Var));
    }
}
