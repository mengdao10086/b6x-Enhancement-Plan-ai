package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class x1<T, B, V> extends io.reactivex.internal.operators.observable.a<T, xi.z<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<B> f34771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super B, ? extends xi.e0<V>> f34772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34773d;

    public static final class a<T, V> extends io.reactivex.observers.d<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c<T, ?, V> f34774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final UnicastSubject<T> f34775c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34776d;

        public a(c<T, ?, V> cVar, UnicastSubject<T> unicastSubject) {
            this.f34774b = cVar;
            this.f34775c = unicastSubject;
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.f34776d) {
                return;
            }
            this.f34776d = true;
            this.f34774b.j(this);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.f34776d) {
                kj.a.Y(th2);
            } else {
                this.f34776d = true;
                this.f34774b.m(th2);
            }
        }

        @Override // xi.g0
        public void onNext(V v10) {
            dispose();
            onComplete();
        }
    }

    public static final class b<T, B> extends io.reactivex.observers.d<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c<T, B, ?> f34777b;

        public b(c<T, B, ?> cVar) {
            this.f34777b = cVar;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34777b.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34777b.m(th2);
        }

        @Override // xi.g0
        public void onNext(B b10) {
            this.f34777b.n(b10);
        }
    }

    public static final class c<T, B, V> extends gj.k<T, Object, xi.z<T>> implements io.reactivex.disposables.b {
        public final dj.o<? super B, ? extends xi.e0<V>> C2;
        public final io.reactivex.disposables.a E7;
        public io.reactivex.disposables.b F7;
        public final AtomicReference<io.reactivex.disposables.b> G7;
        public final List<UnicastSubject<T>> H7;
        public final AtomicLong I7;
        public final AtomicBoolean J7;
        public final int K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final xi.e0<B> f34778v2;

        public c(xi.g0<? super xi.z<T>> g0Var, xi.e0<B> e0Var, dj.o<? super B, ? extends xi.e0<V>> oVar, int i10) {
            super(g0Var, new MpscLinkedQueue());
            this.G7 = new AtomicReference<>();
            AtomicLong atomicLong = new AtomicLong();
            this.I7 = atomicLong;
            this.J7 = new AtomicBoolean();
            this.f34778v2 = e0Var;
            this.C2 = oVar;
            this.K2 = i10;
            this.E7 = new io.reactivex.disposables.a();
            this.H7 = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.J7.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.G7);
                if (this.I7.decrementAndGet() == 0) {
                    this.F7.dispose();
                }
            }
        }

        @Override // gj.k, io.reactivex.internal.util.j
        public void g(xi.g0<? super xi.z<T>> g0Var, Object obj) {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.J7.get();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void j(a<T, V> aVar) {
            this.E7.c(aVar);
            this.f29583k1.offer((U) new d(aVar.f34775c, null));
            if (a()) {
                l();
            }
        }

        public void k() {
            this.E7.dispose();
            DisposableHelper.dispose(this.G7);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void l() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f29583k1;
            xi.g0<? super V> g0Var = this.K0;
            List<UnicastSubject<T>> list = this.H7;
            int iF = 1;
            while (true) {
                boolean z10 = this.C1;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z11 = objPoll == null;
                if (z10 && z11) {
                    k();
                    Throwable th2 = this.K1;
                    if (th2 != null) {
                        Iterator<UnicastSubject<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onError(th2);
                        }
                    } else {
                        Iterator<UnicastSubject<T>> it3 = list.iterator();
                        while (it3.hasNext()) {
                            it3.next().onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z11) {
                    iF = f(-iF);
                    if (iF == 0) {
                        return;
                    }
                } else if (objPoll instanceof d) {
                    d dVar = (d) objPoll;
                    UnicastSubject<T> unicastSubject = dVar.f34779a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            dVar.f34779a.onComplete();
                            if (this.I7.decrementAndGet() == 0) {
                                k();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.J7.get()) {
                        UnicastSubject<T> unicastSubjectO8 = UnicastSubject.o8(this.K2);
                        list.add(unicastSubjectO8);
                        g0Var.onNext(unicastSubjectO8);
                        try {
                            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.C2.apply(dVar.f34780b), "The ObservableSource supplied is null");
                            a aVar = new a(this, unicastSubjectO8);
                            if (this.E7.b(aVar)) {
                                this.I7.getAndIncrement();
                                e0Var.c(aVar);
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.J7.set(true);
                            g0Var.onError(th3);
                        }
                    }
                } else {
                    Iterator<UnicastSubject<T>> it4 = list.iterator();
                    while (it4.hasNext()) {
                        it4.next().onNext(NotificationLite.getValue(objPoll));
                    }
                }
            }
        }

        public void m(Throwable th2) {
            this.F7.dispose();
            this.E7.dispose();
            onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void n(B b10) {
            this.f29583k1.offer((U) new d(null, b10));
            if (a()) {
                l();
            }
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.C1) {
                return;
            }
            this.C1 = true;
            if (a()) {
                l();
            }
            if (this.I7.decrementAndGet() == 0) {
                this.E7.dispose();
            }
            this.K0.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.C1) {
                kj.a.Y(th2);
                return;
            }
            this.K1 = th2;
            this.C1 = true;
            if (a()) {
                l();
            }
            if (this.I7.decrementAndGet() == 0) {
                this.E7.dispose();
            }
            this.K0.onError(th2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onNext(T t10) {
            if (d()) {
                Iterator<UnicastSubject<T>> it2 = this.H7.iterator();
                while (it2.hasNext()) {
                    it2.next().onNext(t10);
                }
                if (f(-1) == 0) {
                    return;
                }
            } else {
                this.f29583k1.offer((U) NotificationLite.next(t10));
                if (!a()) {
                    return;
                }
            }
            l();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.F7, bVar)) {
                this.F7 = bVar;
                this.K0.onSubscribe(this);
                if (this.J7.get()) {
                    return;
                }
                b bVar2 = new b(this);
                if (this.G7.compareAndSet(null, bVar2)) {
                    this.f34778v2.c(bVar2);
                }
            }
        }
    }

    public static final class d<T, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UnicastSubject<T> f34779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B f34780b;

        public d(UnicastSubject<T> unicastSubject, B b10) {
            this.f34779a = unicastSubject;
            this.f34780b = b10;
        }
    }

    public x1(xi.e0<T> e0Var, xi.e0<B> e0Var2, dj.o<? super B, ? extends xi.e0<V>> oVar, int i10) {
        super(e0Var);
        this.f34771b = e0Var2;
        this.f34772c = oVar;
        this.f34773d = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super xi.z<T>> g0Var) {
        this.f34421a.c(new c(new io.reactivex.observers.l(g0Var), this.f34771b, this.f34772c, this.f34773d));
    }
}
