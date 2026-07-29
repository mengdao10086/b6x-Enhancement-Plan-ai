package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<U> f34116d;

    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8223395059921494546L;
        public final Callable<U> bufferSupplier;
        public final ArrayDeque<U> buffers = new ArrayDeque<>();
        public final int count;
        public final xi.g0<? super U> downstream;
        public long index;
        public final int skip;
        public io.reactivex.disposables.b upstream;

        public BufferSkipObserver(xi.g0<? super U> g0Var, int i10, int i11, Callable<U> callable) {
            this.downstream = g0Var;
            this.count = i10;
            this.skip = i11;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.buffers.clear();
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long j10 = this.index;
            this.index = 1 + j10;
            if (j10 % ((long) this.skip) == 0) {
                try {
                    this.buffers.offer((U) ((Collection) io.reactivex.internal.functions.a.g(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
                } catch (Throwable th2) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th2);
                    return;
                }
            }
            Iterator<U> it2 = this.buffers.iterator();
            while (it2.hasNext()) {
                U next = it2.next();
                next.add(t10);
                if (this.count <= next.size()) {
                    it2.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public static final class a<T, U extends Collection<? super T>> implements xi.g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super U> f34117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f34118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Callable<U> f34119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public U f34120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f34121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public io.reactivex.disposables.b f34122f;

        public a(xi.g0<? super U> g0Var, int i10, Callable<U> callable) {
            this.f34117a = g0Var;
            this.f34118b = i10;
            this.f34119c = callable;
        }

        public boolean a() {
            try {
                this.f34120d = (U) io.reactivex.internal.functions.a.g(this.f34119c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f34120d = null;
                io.reactivex.disposables.b bVar = this.f34122f;
                if (bVar == null) {
                    EmptyDisposable.error(th2, this.f34117a);
                    return false;
                }
                bVar.dispose();
                this.f34117a.onError(th2);
                return false;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f34122f.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f34122f.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            U u6 = this.f34120d;
            if (u6 != null) {
                this.f34120d = null;
                if (!u6.isEmpty()) {
                    this.f34117a.onNext(u6);
                }
                this.f34117a.onComplete();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34120d = null;
            this.f34117a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            U u6 = this.f34120d;
            if (u6 != null) {
                u6.add(t10);
                int i10 = this.f34121e + 1;
                this.f34121e = i10;
                if (i10 >= this.f34118b) {
                    this.f34117a.onNext(u6);
                    this.f34121e = 0;
                    a();
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f34122f, bVar)) {
                this.f34122f = bVar;
                this.f34117a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(xi.e0<T> e0Var, int i10, int i11, Callable<U> callable) {
        super(e0Var);
        this.f34114b = i10;
        this.f34115c = i11;
        this.f34116d = callable;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        int i10 = this.f34115c;
        int i11 = this.f34114b;
        if (i10 != i11) {
            this.f34421a.c(new BufferSkipObserver(g0Var, this.f34114b, this.f34115c, this.f34116d));
            return;
        }
        a aVar = new a(g0Var, i11, this.f34116d);
        if (aVar.a()) {
            this.f34421a.c(aVar);
        }
    }
}
