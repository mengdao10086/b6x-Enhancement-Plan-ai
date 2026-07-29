package qc;

import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends eb.f implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public f f47269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f47270e;

    @Override // qc.f
    public int c(long j10) {
        return ((f) hd.a.g(this.f47269d)).c(j10 - this.f47270e);
    }

    @Override // qc.f
    public long d(int i10) {
        return ((f) hd.a.g(this.f47269d)).d(i10) + this.f47270e;
    }

    @Override // qc.f
    public List<b> e(long j10) {
        return ((f) hd.a.g(this.f47269d)).e(j10 - this.f47270e);
    }

    @Override // qc.f
    public int f() {
        return ((f) hd.a.g(this.f47269d)).f();
    }

    @Override // eb.a
    public void h() {
        super.h();
        this.f47269d = null;
    }

    public void q(long j10, f fVar, long j11) {
        this.f26793b = j10;
        this.f47269d = fVar;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.f47270e = j10;
    }
}
