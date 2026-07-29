package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.g<? super T> f34853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34854c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34855a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f34855a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34855a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34855a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.b$b, reason: collision with other inner class name */
    public static final class C0392b<T> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fj.a<? super T> f34856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super T> f34857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f34859d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34860e;

        public C0392b(fj.a<? super T> aVar, dj.g<? super T> gVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            this.f34856a = aVar;
            this.f34857b = gVar;
            this.f34858c = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34859d.cancel();
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (this.f34860e) {
                return false;
            }
            long j10 = 0;
            do {
                try {
                    this.f34857b.accept(t10);
                    return this.f34856a.m(t10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    try {
                        j10++;
                        i10 = a.f34855a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34858c.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        cancel();
                        onError(new CompositeException(th2, th3));
                        return false;
                    }
                }
            } while (i10 == 1);
            if (i10 != 2) {
                if (i10 != 3) {
                    cancel();
                    onError(th2);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34860e) {
                return;
            }
            this.f34860e = true;
            this.f34856a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34860e) {
                kj.a.Y(th2);
            } else {
                this.f34860e = true;
                this.f34856a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10) || this.f34860e) {
                return;
            }
            this.f34859d.request(1L);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34859d, eVar)) {
                this.f34859d = eVar;
                this.f34856a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34859d.request(j10);
        }
    }

    public static final class c<T> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f34861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.g<? super T> f34862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f34864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34865e;

        public c(bu.d<? super T> dVar, dj.g<? super T> gVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            this.f34861a = dVar;
            this.f34862b = gVar;
            this.f34863c = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34864d.cancel();
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (this.f34865e) {
                return false;
            }
            long j10 = 0;
            do {
                try {
                    this.f34862b.accept(t10);
                    this.f34861a.onNext(t10);
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    try {
                        j10++;
                        i10 = a.f34855a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34863c.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        cancel();
                        onError(new CompositeException(th2, th3));
                        return false;
                    }
                }
            } while (i10 == 1);
            if (i10 != 2) {
                if (i10 != 3) {
                    cancel();
                    onError(th2);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34865e) {
                return;
            }
            this.f34865e = true;
            this.f34861a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34865e) {
                kj.a.Y(th2);
            } else {
                this.f34865e = true;
                this.f34861a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10)) {
                return;
            }
            this.f34864d.request(1L);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34864d, eVar)) {
                this.f34864d = eVar;
                this.f34861a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34864d.request(j10);
        }
    }

    public b(jj.a<T> aVar, dj.g<? super T> gVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        this.f34852a = aVar;
        this.f34853b = gVar;
        this.f34854c = cVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34852a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                bu.d<? super T> dVar = dVarArr[i10];
                if (dVar instanceof fj.a) {
                    dVarArr2[i10] = new C0392b((fj.a) dVar, this.f34853b, this.f34854c);
                } else {
                    dVarArr2[i10] = new c(dVar, this.f34853b, this.f34854c);
                }
            }
            this.f34852a.Q(dVarArr2);
        }
    }
}
