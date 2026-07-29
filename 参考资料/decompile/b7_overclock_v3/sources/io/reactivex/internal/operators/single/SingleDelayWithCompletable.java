package io.reactivex.internal.operators.single;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xi.i0;
import xi.l0;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleDelayWithCompletable<T> extends i0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0<T> f34934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.g f34935b;

    public static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8565274649390031272L;
        public final l0<? super T> downstream;
        public final o0<T> source;

        public OtherObserver(l0<? super T> l0Var, o0<T> o0Var) {
            this.downstream = l0Var;
            this.source = o0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            this.source.a(new gj.o(this, this.downstream));
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithCompletable(o0<T> o0Var, xi.g gVar) {
        this.f34934a = o0Var;
        this.f34935b = gVar;
    }

    @Override // xi.i0
    public void b1(l0<? super T> l0Var) {
        this.f34935b.a(new OtherObserver(l0Var, this.f34934a));
    }
}
