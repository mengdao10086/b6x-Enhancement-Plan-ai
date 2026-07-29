package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableResumeNext extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super Throwable, ? extends xi.g> f33059b;

    public static final class ResumeNextObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
        private static final long serialVersionUID = 5018523762564524046L;
        public final xi.d downstream;
        public final dj.o<? super Throwable, ? extends xi.g> errorMapper;
        public boolean once;

        public ResumeNextObserver(xi.d dVar, dj.o<? super Throwable, ? extends xi.g> oVar) {
            this.downstream = dVar;
            this.errorMapper = oVar;
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
            this.downstream.onComplete();
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (this.once) {
                this.downstream.onError(th2);
                return;
            }
            this.once = true;
            try {
                ((xi.g) io.reactivex.internal.functions.a.g(this.errorMapper.apply(th2), "The errorMapper returned a null CompletableSource")).a(this);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public CompletableResumeNext(xi.g gVar, dj.o<? super Throwable, ? extends xi.g> oVar) {
        this.f33058a = gVar;
        this.f33059b = oVar;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(dVar, this.f33059b);
        dVar.onSubscribe(resumeNextObserver);
        this.f33058a.a(resumeNextObserver);
    }
}
