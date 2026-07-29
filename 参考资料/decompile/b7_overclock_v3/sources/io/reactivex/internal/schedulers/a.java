package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.i;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends h0 implements i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f35147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f35148f = "RxComputationThreadPool";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final RxThreadFactory f35149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f35150h = "rx2.computation-threads";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f35151i = l(Runtime.getRuntime().availableProcessors(), Integer.getInteger(f35150h, 0).intValue());

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f35152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f35153k = "rx2.computation-priority";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f35154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference<b> f35155d;

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    public static final class C0398a extends h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ej.b f35156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.disposables.a f35157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ej.b f35158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f35159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f35160e;

        public C0398a(c cVar) {
            this.f35159d = cVar;
            ej.b bVar = new ej.b();
            this.f35156a = bVar;
            io.reactivex.disposables.a aVar = new io.reactivex.disposables.a();
            this.f35157b = aVar;
            ej.b bVar2 = new ej.b();
            this.f35158c = bVar2;
            bVar2.b(bVar);
            bVar2.b(aVar);
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            return this.f35160e ? EmptyDisposable.INSTANCE : this.f35159d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f35156a);
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            return this.f35160e ? EmptyDisposable.INSTANCE : this.f35159d.e(runnable, j10, timeUnit, this.f35157b);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f35160e) {
                return;
            }
            this.f35160e = true;
            this.f35158c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35160e;
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f35162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f35163c;

        public b(int i10, ThreadFactory threadFactory) {
            this.f35161a = i10;
            this.f35162b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f35162b[i11] = new c(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.i
        public void a(int i10, i.a aVar) {
            int i11 = this.f35161a;
            if (i11 == 0) {
                for (int i12 = 0; i12 < i10; i12++) {
                    aVar.a(i12, a.f35152j);
                }
                return;
            }
            int i13 = ((int) this.f35163c) % i11;
            for (int i14 = 0; i14 < i10; i14++) {
                aVar.a(i14, new C0398a(this.f35162b[i13]));
                i13++;
                if (i13 == i11) {
                    i13 = 0;
                }
            }
            this.f35163c = i13;
        }

        public c b() {
            int i10 = this.f35161a;
            if (i10 == 0) {
                return a.f35152j;
            }
            c[] cVarArr = this.f35162b;
            long j10 = this.f35163c;
            this.f35163c = 1 + j10;
            return cVarArr[(int) (j10 % ((long) i10))];
        }

        public void c() {
            for (c cVar : this.f35162b) {
                cVar.dispose();
            }
        }
    }

    public static final class c extends g {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f35152j = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory(f35148f, Math.max(1, Math.min(10, Integer.getInteger(f35153k, 5).intValue())), true);
        f35149g = rxThreadFactory;
        b bVar = new b(0, rxThreadFactory);
        f35147e = bVar;
        bVar.c();
    }

    public a() {
        this(f35149g);
    }

    public static int l(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // io.reactivex.internal.schedulers.i
    public void a(int i10, i.a aVar) {
        io.reactivex.internal.functions.a.h(i10, "number > 0 required");
        this.f35155d.get().a(i10, aVar);
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new C0398a(this.f35155d.get().b());
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f35155d.get().b().f(runnable, j10, timeUnit);
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b h(@bj.e Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f35155d.get().b().g(runnable, j10, j11, timeUnit);
    }

    @Override // xi.h0
    public void i() {
        b bVar;
        b bVar2;
        do {
            bVar = this.f35155d.get();
            bVar2 = f35147e;
            if (bVar == bVar2) {
                return;
            }
        } while (!this.f35155d.compareAndSet(bVar, bVar2));
        bVar.c();
    }

    @Override // xi.h0
    public void j() {
        b bVar = new b(f35151i, this.f35154c);
        if (this.f35155d.compareAndSet(f35147e, bVar)) {
            return;
        }
        bVar.c();
    }

    public a(ThreadFactory threadFactory) {
        this.f35154c = threadFactory;
        this.f35155d = new AtomicReference<>(f35147e);
        j();
    }
}
