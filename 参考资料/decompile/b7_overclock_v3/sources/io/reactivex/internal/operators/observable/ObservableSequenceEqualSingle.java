package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSequenceEqualSingle<T> extends xi.i0<Boolean> implements fj.d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T> f34330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends T> f34331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super T, ? super T> f34332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34333d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final dj.d<? super T, ? super T> comparer;
        public final xi.l0<? super Boolean> downstream;
        public final xi.e0<? extends T> first;
        public final a<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final xi.e0<? extends T> second;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public T f34334v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public T f34335v2;

        public EqualCoordinator(xi.l0<? super Boolean> l0Var, int i10, xi.e0<? extends T> e0Var, xi.e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar) {
            this.downstream = l0Var;
            this.first = e0Var;
            this.second = e0Var2;
            this.comparer = dVar;
            this.observers = new a[]{new a<>(this, 0, i10), new a<>(this, 1, i10)};
        }

        public void a(io.reactivex.internal.queue.a<T> aVar, io.reactivex.internal.queue.a<T> aVar2) {
            this.cancelled = true;
            aVar.clear();
            aVar2.clear();
        }

        public void b() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T>[] aVarArr = this.observers;
            a<T> aVar = aVarArr[0];
            io.reactivex.internal.queue.a<T> aVar2 = aVar.f34337b;
            a<T> aVar3 = aVarArr[1];
            io.reactivex.internal.queue.a<T> aVar4 = aVar3.f34337b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = aVar.f34339d;
                if (z10 && (th3 = aVar.f34340e) != null) {
                    a(aVar2, aVar4);
                    this.downstream.onError(th3);
                    return;
                }
                boolean z11 = aVar3.f34339d;
                if (z11 && (th2 = aVar3.f34340e) != null) {
                    a(aVar2, aVar4);
                    this.downstream.onError(th2);
                    return;
                }
                if (this.f34334v1 == null) {
                    this.f34334v1 = aVar2.poll();
                }
                boolean z12 = this.f34334v1 == null;
                if (this.f34335v2 == null) {
                    this.f34335v2 = aVar4.poll();
                }
                T t10 = this.f34335v2;
                boolean z13 = t10 == null;
                if (z10 && z11 && z12 && z13) {
                    this.downstream.onSuccess(Boolean.TRUE);
                    return;
                }
                if (z10 && z11 && z12 != z13) {
                    a(aVar2, aVar4);
                    this.downstream.onSuccess(Boolean.FALSE);
                    return;
                }
                if (!z12 && !z13) {
                    try {
                        if (!this.comparer.a(this.f34334v1, t10)) {
                            a(aVar2, aVar4);
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        } else {
                            this.f34334v1 = null;
                            this.f34335v2 = null;
                        }
                    } catch (Throwable th4) {
                        io.reactivex.exceptions.a.b(th4);
                        a(aVar2, aVar4);
                        this.downstream.onError(th4);
                        return;
                    }
                }
                if (z12 || z13) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar2.clear();
            aVar4.clear();
        }

        public boolean c(io.reactivex.disposables.b bVar, int i10) {
            return this.resources.b(i10, bVar);
        }

        public void d() {
            a<T>[] aVarArr = this.observers;
            this.first.c(aVarArr[0]);
            this.second.c(aVarArr[1]);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                a<T>[] aVarArr = this.observers;
                aVarArr[0].f34337b.clear();
                aVarArr[1].f34337b.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class a<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EqualCoordinator<T> f34336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.internal.queue.a<T> f34337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f34339d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Throwable f34340e;

        public a(EqualCoordinator<T> equalCoordinator, int i10, int i11) {
            this.f34336a = equalCoordinator;
            this.f34338c = i10;
            this.f34337b = new io.reactivex.internal.queue.a<>(i11);
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34339d = true;
            this.f34336a.b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34340e = th2;
            this.f34339d = true;
            this.f34336a.b();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34337b.offer(t10);
            this.f34336a.b();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34336a.c(bVar, this.f34338c);
        }
    }

    public ObservableSequenceEqualSingle(xi.e0<? extends T> e0Var, xi.e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar, int i10) {
        this.f34330a = e0Var;
        this.f34331b = e0Var2;
        this.f34332c = dVar;
        this.f34333d = i10;
    }

    @Override // fj.d
    public xi.z<Boolean> b() {
        return kj.a.U(new ObservableSequenceEqual(this.f34330a, this.f34331b, this.f34332c, this.f34333d));
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(l0Var, this.f34333d, this.f34330a, this.f34331b, this.f34332c);
        l0Var.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
