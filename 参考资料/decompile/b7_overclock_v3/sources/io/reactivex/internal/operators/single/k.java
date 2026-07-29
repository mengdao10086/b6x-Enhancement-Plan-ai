package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.EmptyDisposable;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f35044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super io.reactivex.disposables.b> f35045b;

    public static final class a<T> implements l0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l0<? super T> f35046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super io.reactivex.disposables.b> f35047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f35048c;

        public a(l0<? super T> l0Var, dj.g<? super io.reactivex.disposables.b> gVar) {
            this.f35046a = l0Var;
            this.f35047b = gVar;
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            if (this.f35048c) {
                kj.a.Y(th2);
            } else {
                this.f35046a.onError(th2);
            }
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            try {
                this.f35047b.accept(bVar);
                this.f35046a.onSubscribe(bVar);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f35048c = true;
                bVar.dispose();
                EmptyDisposable.error(th2, this.f35046a);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            if (this.f35048c) {
                return;
            }
            this.f35046a.onSuccess(t10);
        }
    }

    public k(o0<T> o0Var, dj.g<? super io.reactivex.disposables.b> gVar) {
        this.f35044a = o0Var;
        this.f35045b = gVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f35044a.a(new a(l0Var, this.f35045b));
    }
}
