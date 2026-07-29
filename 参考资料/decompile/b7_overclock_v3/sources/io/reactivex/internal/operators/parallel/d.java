package io.reactivex.internal.operators.parallel;

import dj.r;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r<? super T> f34874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34875c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34876a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f34876a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34876a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34876a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static abstract class b<T> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r<? super T> f34877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public bu.e f34879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34880d;

        public b(r<? super T> rVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            this.f34877a = rVar;
            this.f34878b = cVar;
        }

        @Override // bu.e
        public final void cancel() {
            this.f34879c.cancel();
        }

        @Override // bu.d
        public final void onNext(T t10) {
            if (m(t10) || this.f34880d) {
                return;
            }
            this.f34879c.request(1L);
        }

        @Override // bu.e
        public final void request(long j10) {
            this.f34879c.request(j10);
        }
    }

    public static final class c<T> extends b<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final fj.a<? super T> f34881e;

        public c(fj.a<? super T> aVar, r<? super T> rVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            super(rVar, cVar);
            this.f34881e = aVar;
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (!this.f34880d) {
                long j10 = 0;
                do {
                    try {
                        return this.f34877a.a(t10) && this.f34881e.m(t10);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        try {
                            j10++;
                            i10 = a.f34876a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34878b.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            cancel();
                            onError(new CompositeException(th2, th3));
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
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34880d) {
                return;
            }
            this.f34880d = true;
            this.f34881e.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34880d) {
                kj.a.Y(th2);
            } else {
                this.f34880d = true;
                this.f34881e.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34879c, eVar)) {
                this.f34879c = eVar;
                this.f34881e.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.d$d, reason: collision with other inner class name */
    public static final class C0394d<T> extends b<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final bu.d<? super T> f34882e;

        public C0394d(bu.d<? super T> dVar, r<? super T> rVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            super(rVar, cVar);
            this.f34882e = dVar;
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (!this.f34880d) {
                long j10 = 0;
                do {
                    try {
                        if (!this.f34877a.a(t10)) {
                            return false;
                        }
                        this.f34882e.onNext(t10);
                        return true;
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        try {
                            j10++;
                            i10 = a.f34876a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34878b.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            cancel();
                            onError(new CompositeException(th2, th3));
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
            return false;
        }

        @Override // bu.d
        public void onComplete() {
            if (this.f34880d) {
                return;
            }
            this.f34880d = true;
            this.f34882e.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34880d) {
                kj.a.Y(th2);
            } else {
                this.f34880d = true;
                this.f34882e.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34879c, eVar)) {
                this.f34879c = eVar;
                this.f34882e.onSubscribe(this);
            }
        }
    }

    public d(jj.a<T> aVar, r<? super T> rVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        this.f34873a = aVar;
        this.f34874b = rVar;
        this.f34875c = cVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34873a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                bu.d<? super T> dVar = dVarArr[i10];
                if (dVar instanceof fj.a) {
                    dVarArr2[i10] = new c((fj.a) dVar, this.f34874b, this.f34875c);
                } else {
                    dVarArr2[i10] = new C0394d(dVar, this.f34874b, this.f34875c);
                }
            }
            this.f34873a.Q(dVarArr2);
        }
    }
}
