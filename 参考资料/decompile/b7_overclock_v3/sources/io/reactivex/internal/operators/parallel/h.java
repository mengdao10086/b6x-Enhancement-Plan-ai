package io.reactivex.internal.operators.parallel;

import dj.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;

/* JADX INFO: loaded from: classes5.dex */
public final class h<T, R> extends jj.a<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<T> f34899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends R> f34900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34901c;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34902a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f34902a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34902a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f34902a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final class b<T, R> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fj.a<? super R> f34903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends R> f34904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34905c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f34906d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34907e;

        public b(fj.a<? super R> aVar, o<? super T, ? extends R> oVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            this.f34903a = aVar;
            this.f34904b = oVar;
            this.f34905c = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34906d.cancel();
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (this.f34907e) {
                return false;
            }
            long j10 = 0;
            do {
                try {
                    return this.f34903a.m(io.reactivex.internal.functions.a.g(this.f34904b.apply(t10), "The mapper returned a null value"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    try {
                        j10++;
                        i10 = a.f34902a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34905c.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
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
            if (this.f34907e) {
                return;
            }
            this.f34907e = true;
            this.f34903a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34907e) {
                kj.a.Y(th2);
            } else {
                this.f34907e = true;
                this.f34903a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10) || this.f34907e) {
                return;
            }
            this.f34906d.request(1L);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34906d, eVar)) {
                this.f34906d = eVar;
                this.f34903a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34906d.request(j10);
        }
    }

    public static final class c<T, R> implements fj.a<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super R> f34908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o<? super T, ? extends R> f34909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.c<? super Long, ? super Throwable, ParallelFailureHandling> f34910c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public bu.e f34911d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34912e;

        public c(bu.d<? super R> dVar, o<? super T, ? extends R> oVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
            this.f34908a = dVar;
            this.f34909b = oVar;
            this.f34910c = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.f34911d.cancel();
        }

        @Override // fj.a
        public boolean m(T t10) {
            int i10;
            if (this.f34912e) {
                return false;
            }
            long j10 = 0;
            do {
                try {
                    this.f34908a.onNext(io.reactivex.internal.functions.a.g(this.f34909b.apply(t10), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    try {
                        j10++;
                        i10 = a.f34902a[((ParallelFailureHandling) io.reactivex.internal.functions.a.g(this.f34910c.apply(Long.valueOf(j10), th2), "The errorHandler returned a null item")).ordinal()];
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
            if (this.f34912e) {
                return;
            }
            this.f34912e = true;
            this.f34908a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.f34912e) {
                kj.a.Y(th2);
            } else {
                this.f34912e = true;
                this.f34908a.onError(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (m(t10) || this.f34912e) {
                return;
            }
            this.f34911d.request(1L);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f34911d, eVar)) {
                this.f34911d = eVar;
                this.f34908a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f34911d.request(j10);
        }
    }

    public h(jj.a<T> aVar, o<? super T, ? extends R> oVar, dj.c<? super Long, ? super Throwable, ParallelFailureHandling> cVar) {
        this.f34899a = aVar;
        this.f34900b = oVar;
        this.f34901c = cVar;
    }

    @Override // jj.a
    public int F() {
        return this.f34899a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super R>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<? super T>[] dVarArr2 = new bu.d[length];
            for (int i10 = 0; i10 < length; i10++) {
                bu.d<? super R> dVar = dVarArr[i10];
                if (dVar instanceof fj.a) {
                    dVarArr2[i10] = new b((fj.a) dVar, this.f34900b, this.f34901c);
                } else {
                    dVarArr2[i10] = new c(dVar, this.f34900b, this.f34901c);
                }
            }
            this.f34899a.Q(dVarArr2);
        }
    }
}
