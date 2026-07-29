package io.reactivex.internal.schedulers;

import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h0 f35165c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h0.c f35166d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final io.reactivex.disposables.b f35167e;

    public static final class a extends h0.c {
        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            runnable.run();
            return c.f35167e;
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b d(@bj.e Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return false;
        }
    }

    static {
        io.reactivex.disposables.b bVarB = io.reactivex.disposables.c.b();
        f35167e = bVarB;
        bVarB.dispose();
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return f35166d;
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b f(@bj.e Runnable runnable) {
        runnable.run();
        return f35167e;
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b h(@bj.e Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
