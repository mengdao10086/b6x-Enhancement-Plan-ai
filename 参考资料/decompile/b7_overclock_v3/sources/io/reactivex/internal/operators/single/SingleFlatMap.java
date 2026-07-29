package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFlatMap<T, R> extends i0<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<? extends T> f34946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends o0<? extends R>> f34947b;

    public static final class SingleFlatMapCallback<T, R> extends AtomicReference<io.reactivex.disposables.b> implements l0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 3258103020495908596L;
        public final l0<? super R> downstream;
        public final dj.o<? super T, ? extends o0<? extends R>> mapper;

        public static final class a<R> implements l0<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicReference<io.reactivex.disposables.b> f34948a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final l0<? super R> f34949b;

            public a(AtomicReference<io.reactivex.disposables.b> atomicReference, l0<? super R> l0Var) {
                this.f34948a = atomicReference;
                this.f34949b = l0Var;
            }

            @Override // xi.l0
            public void onError(Throwable th2) {
                this.f34949b.onError(th2);
            }

            @Override // xi.l0
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this.f34948a, bVar);
            }

            @Override // xi.l0
            public void onSuccess(R r10) {
                this.f34949b.onSuccess(r10);
            }
        }

        public SingleFlatMapCallback(l0<? super R> l0Var, dj.o<? super T, ? extends o0<? extends R>> oVar) {
            this.downstream = l0Var;
            this.mapper = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.l0
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.l0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.l0
        public void onSuccess(T t10) {
            try {
                o0 o0Var = (o0) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The single returned by the mapper is null");
                if (isDisposed()) {
                    return;
                }
                o0Var.a(new a(this, this.downstream));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public SingleFlatMap(o0<? extends T> o0Var, dj.o<? super T, ? extends o0<? extends R>> oVar) {
        this.f34947b = oVar;
        this.f34946a = o0Var;
    }

    @Override // xi.i0
    public void b1(l0<? super R> l0Var) {
        this.f34946a.a(new SingleFlatMapCallback(l0Var, this.f34947b));
    }
}
