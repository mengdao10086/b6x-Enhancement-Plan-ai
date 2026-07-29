package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class q<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33721f;

    public static final class a<T> implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f33724c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final h0.c f33725d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f33726e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public bu.e f33727f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.q$a$a, reason: collision with other inner class name */
        public final class RunnableC0386a implements Runnable {
            public RunnableC0386a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f33722a.onComplete();
                } finally {
                    a.this.f33725d.dispose();
                }
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f33729a;

            public b(Throwable th2) {
                this.f33729a = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f33722a.onError(this.f33729a);
                } finally {
                    a.this.f33725d.dispose();
                }
            }
        }

        public final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f33731a;

            public c(T t10) {
                this.f33731a = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f33722a.onNext(this.f33731a);
            }
        }

        public a(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.f33722a = dVar;
            this.f33723b = j10;
            this.f33724c = timeUnit;
            this.f33725d = cVar;
            this.f33726e = z10;
        }

        @Override // bu.e
        public void cancel() {
            this.f33727f.cancel();
            this.f33725d.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33725d.c(new RunnableC0386a(), this.f33723b, this.f33724c);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33725d.c(new b(th2), this.f33726e ? this.f33723b : 0L, this.f33724c);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33725d.c(new c(t10), this.f33723b, this.f33724c);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.f33727f, eVar)) {
                this.f33727f = eVar;
                this.f33722a.onSubscribe(this);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            this.f33727f.request(j10);
        }
    }

    public q(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(jVar);
        this.f33718c = j10;
        this.f33719d = timeUnit;
        this.f33720e = h0Var;
        this.f33721f = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new a(this.f33721f ? dVar : new io.reactivex.subscribers.e(dVar), this.f33718c, this.f33719d, this.f33720e.d(), this.f33721f));
    }
}
