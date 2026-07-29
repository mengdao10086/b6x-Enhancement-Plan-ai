package uk;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import uk.q;

/* JADX INFO: loaded from: classes5.dex */
@k
public final class c implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final q f52167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f52168b;

    public c(q mark, long j10) {
        f0.p(mark, "mark");
        this.f52167a = mark;
        this.f52168b = j10;
    }

    public /* synthetic */ c(q qVar, long j10, u uVar) {
        this(qVar, j10);
    }

    @Override // uk.q
    @yt.k
    public q a(long j10) {
        return q.a.c(this, j10);
    }

    @Override // uk.q
    @yt.k
    public q b(long j10) {
        return new c(this.f52167a, e.h0(this.f52168b, j10), null);
    }

    @Override // uk.q
    public boolean c() {
        return q.a.b(this);
    }

    @Override // uk.q
    public long d() {
        return e.g0(this.f52167a.d(), this.f52168b);
    }

    @Override // uk.q
    public boolean e() {
        return q.a.a(this);
    }

    public final long f() {
        return this.f52168b;
    }

    @yt.k
    public final q g() {
        return this.f52167a;
    }
}
