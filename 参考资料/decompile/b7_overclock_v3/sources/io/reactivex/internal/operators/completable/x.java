package io.reactivex.internal.operators.completable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class x extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.g f33137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f33138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f33139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h0 f33140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.g f33141e;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f33142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f33143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.d f33144c;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.completable.x$a$a, reason: collision with other inner class name */
        public final class C0383a implements xi.d {
            public C0383a() {
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                a.this.f33143b.dispose();
                a.this.f33144c.onComplete();
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                a.this.f33143b.dispose();
                a.this.f33144c.onError(th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                a.this.f33143b.b(bVar);
            }
        }

        public a(AtomicBoolean atomicBoolean, io.reactivex.disposables.a aVar, xi.d dVar) {
            this.f33142a = atomicBoolean;
            this.f33143b = aVar;
            this.f33144c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f33142a.compareAndSet(false, true)) {
                this.f33143b.e();
                xi.g gVar = x.this.f33141e;
                if (gVar != null) {
                    gVar.a(new C0383a());
                    return;
                }
                xi.d dVar = this.f33144c;
                x xVar = x.this;
                dVar.onError(new TimeoutException(ExceptionHelper.e(xVar.f33138b, xVar.f33139c)));
            }
        }
    }

    public static final class b implements xi.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.disposables.a f33147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f33148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final xi.d f33149c;

        public b(io.reactivex.disposables.a aVar, AtomicBoolean atomicBoolean, xi.d dVar) {
            this.f33147a = aVar;
            this.f33148b = atomicBoolean;
            this.f33149c = dVar;
        }

        @Override // xi.d, xi.t
        public void onComplete() {
            if (this.f33148b.compareAndSet(false, true)) {
                this.f33147a.dispose();
                this.f33149c.onComplete();
            }
        }

        @Override // xi.d
        public void onError(Throwable th2) {
            if (!this.f33148b.compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                this.f33147a.dispose();
                this.f33149c.onError(th2);
            }
        }

        @Override // xi.d
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f33147a.b(bVar);
        }
    }

    public x(xi.g gVar, long j10, TimeUnit timeUnit, h0 h0Var, xi.g gVar2) {
        this.f33137a = gVar;
        this.f33138b = j10;
        this.f33139c = timeUnit;
        this.f33140d = h0Var;
        this.f33141e = gVar2;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
        dVar.onSubscribe(aVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        aVar.b(this.f33140d.g(new a(atomicBoolean, aVar, dVar), this.f33138b, this.f33139c));
        this.f33137a.a(new b(aVar, atomicBoolean, dVar));
    }
}
