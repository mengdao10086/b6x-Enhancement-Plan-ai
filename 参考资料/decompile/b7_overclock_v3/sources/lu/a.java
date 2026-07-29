package lu;

import io.reactivex.exceptions.CompositeException;
import retrofit2.adapter.rxjava2.HttpException;
import retrofit2.r;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class a<T> extends z<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<r<T>> f40457a;

    /* JADX INFO: renamed from: lu.a$a, reason: collision with other inner class name */
    public static class C0447a<R> implements g0<r<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g0<? super R> f40458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f40459b;

        public C0447a(g0<? super R> g0Var) {
            this.f40458a = g0Var;
        }

        @Override // xi.g0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            if (rVar.g()) {
                this.f40458a.onNext(rVar.a());
                return;
            }
            this.f40459b = true;
            HttpException httpException = new HttpException(rVar);
            try {
                this.f40458a.onError(httpException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                kj.a.Y(new CompositeException(httpException, th2));
            }
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f40459b) {
                return;
            }
            this.f40458a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.f40459b) {
                this.f40458a.onError(th2);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th2);
            kj.a.Y(assertionError);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f40458a.onSubscribe(bVar);
        }
    }

    public a(z<r<T>> zVar) {
        this.f40457a = zVar;
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        this.f40457a.c(new C0447a(g0Var));
    }
}
