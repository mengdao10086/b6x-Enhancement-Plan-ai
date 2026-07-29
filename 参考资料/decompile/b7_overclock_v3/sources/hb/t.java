package hb;

import hb.a0;
import hb.u;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f30900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f30901e;

    public t(u uVar, long j10) {
        this.f30900d = uVar;
        this.f30901e = j10;
    }

    public final b0 b(long j10, long j11) {
        return new b0((j10 * 1000000) / ((long) this.f30900d.f30909e), this.f30901e + j11);
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        hd.a.k(this.f30900d.f30915k);
        u uVar = this.f30900d;
        u.a aVar = uVar.f30915k;
        long[] jArr = aVar.f30917a;
        long[] jArr2 = aVar.f30918b;
        int iJ = u0.j(jArr, uVar.l(j10), true, false);
        b0 b0VarB = b(iJ == -1 ? 0L : jArr[iJ], iJ != -1 ? jArr2[iJ] : 0L);
        if (b0VarB.f30805a == j10 || iJ == jArr.length - 1) {
            return new a0.a(b0VarB);
        }
        int i10 = iJ + 1;
        return new a0.a(b0VarB, b(jArr[i10], jArr2[i10]));
    }

    @Override // hb.a0
    public long h() {
        return this.f30900d.h();
    }
}
