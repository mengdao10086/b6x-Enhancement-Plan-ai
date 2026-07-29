package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSequenceEqual<T> extends xi.z<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T> f34319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends T> f34320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super T, ? super T> f34321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34322d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -6178010334400373240L;
        public volatile boolean cancelled;
        public final dj.d<? super T, ? super T> comparer;
        public final xi.g0<? super Boolean> downstream;
        public final xi.e0<? extends T> first;
        public final a<T>[] observers;
        public final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        public final xi.e0<? extends T> second;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public T f34323v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public T f34324v2;

        public EqualCoordinator(xi.g0<? super Boolean> g0Var, int i10, xi.e0<? extends T> e0Var, xi.e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar) {
            this.downstream = g0Var;
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
            io.reactivex.internal.queue.a<T> aVar2 = aVar.f34326b;
            a<T> aVar3 = aVarArr[1];
            io.reactivex.internal.queue.a<T> aVar4 = aVar3.f34326b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = aVar.f34328d;
                if (z10 && (th3 = aVar.f34329e) != null) {
                    a(aVar2, aVar4);
                    this.downstream.onError(th3);
                    return;
                }
                boolean z11 = aVar3.f34328d;
                if (z11 && (th2 = aVar3.f34329e) != null) {
                    a(aVar2, aVar4);
                    this.downstream.onError(th2);
                    return;
                }
                if (this.f34323v1 == null) {
                    this.f34323v1 = aVar2.poll();
                }
                boolean z12 = this.f34323v1 == null;
                if (this.f34324v2 == null) {
                    this.f34324v2 = aVar4.poll();
                }
                T t10 = this.f34324v2;
                boolean z13 = t10 == null;
                if (z10 && z11 && z12 && z13) {
                    this.downstream.onNext(Boolean.TRUE);
                    this.downstream.onComplete();
                    return;
                }
                if (z10 && z11 && z12 != z13) {
                    a(aVar2, aVar4);
                    this.downstream.onNext(Boolean.FALSE);
                    this.downstream.onComplete();
                    return;
                }
                if (!z12 && !z13) {
                    try {
                        if (!this.comparer.a(this.f34323v1, t10)) {
                            a(aVar2, aVar4);
                            this.downstream.onNext(Boolean.FALSE);
                            this.downstream.onComplete();
                            return;
                        }
                        this.f34323v1 = null;
                        this.f34324v2 = null;
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
                aVarArr[0].f34326b.clear();
                aVarArr[1].f34326b.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class a<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EqualCoordinator<T> f34325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.internal.queue.a<T> f34326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f34327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f34328d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Throwable f34329e;

        public a(EqualCoordinator<T> equalCoordinator, int i10, int i11) {
            this.f34325a = equalCoordinator;
            this.f34327c = i10;
            this.f34326b = new io.reactivex.internal.queue.a<>(i11);
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34328d = true;
            this.f34325a.b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34329e = th2;
            this.f34328d = true;
            this.f34325a.b();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34326b.offer(t10);
            this.f34325a.b();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34325a.c(bVar, this.f34327c);
        }
    }

    public ObservableSequenceEqual(xi.e0<? extends T> e0Var, xi.e0<? extends T> e0Var2, dj.d<? super T, ? super T> dVar, int i10) {
        this.f34319a = e0Var;
        this.f34320b = e0Var2;
        this.f34321c = dVar;
        this.f34322d = i10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super Boolean> g0Var) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(g0Var, this.f34322d, this.f34319a, this.f34320b, this.f34321c);
        g0Var.onSubscribe(equalCoordinator);
        equalCoordinator.d();
    }
}
