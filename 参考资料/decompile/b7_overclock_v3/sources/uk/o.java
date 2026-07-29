package uk;

import kotlin.v0;
import uk.r;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public final class o implements r.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final o f52182b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f52183c = System.nanoTime();

    @Override // uk.r.c, uk.r
    public /* bridge */ /* synthetic */ d a() {
        return r.b.a.f(e());
    }

    public final long b(long j10, long j11) {
        return r.b.a.i(l.c(j10, j11));
    }

    public final long c(long j10, long j11) {
        return l.g(j10, j11);
    }

    public final long d(long j10) {
        return l.e(f(), j10);
    }

    public long e() {
        return r.b.a.i(f());
    }

    public final long f() {
        return System.nanoTime() - f52183c;
    }

    @yt.k
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    @Override // uk.r
    public /* bridge */ /* synthetic */ q a() {
        return r.b.a.f(e());
    }
}
