package fq;

import gm.t;
import org.bouncycastle.its.ITSValidityPeriod;
import xr.a1;
import xr.b1;
import xr.d2;
import xr.e0;
import xr.n;
import xr.n1;
import xr.o1;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.a f28707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f28708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f28709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f28710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f28711e;

    public b(a aVar, d2.a aVar2) {
        this.f28709c = new t(3L);
        this.f28710d = new e0.c(new byte[3]);
        this.f28711e = new n(0);
        this.f28708b = aVar;
        this.f28707a = aVar2;
        aVar2.h(this.f28710d);
        aVar2.i(this.f28711e);
    }

    public b(d2.a aVar) {
        this(null, aVar);
    }

    public a a() {
        return this.f28708b;
    }

    public b b(b1... b1VarArr) {
        o1.a aVarX = o1.x();
        for (int i10 = 0; i10 != b1VarArr.length; i10++) {
            aVarX.b(b1VarArr[i10]);
        }
        this.f28707a.b(aVarX.a());
        return this;
    }

    public b c(a1... a1VarArr) {
        this.f28707a.e(n1.x().a(a1VarArr).b());
        return this;
    }

    public b d(byte[] bArr) {
        e0.c cVar = new e0.c(bArr);
        this.f28710d = cVar;
        this.f28707a.h(cVar);
        return this;
    }

    public b e(int i10) {
        n nVar = new n(i10);
        this.f28711e = nVar;
        this.f28707a.i(nVar);
        return this;
    }

    public b f(ITSValidityPeriod iTSValidityPeriod) {
        this.f28707a.l(iTSValidityPeriod.c());
        return this;
    }

    public b g(int i10) {
        this.f28709c = new t(i10);
        return this;
    }
}
