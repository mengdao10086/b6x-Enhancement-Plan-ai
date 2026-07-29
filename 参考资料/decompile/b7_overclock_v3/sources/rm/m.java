package rm;

import gm.c0;
import gm.n0;
import gm.w;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class m extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f48903b = new m(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f48904c = new m(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f48905d = new m(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f48906e = new m(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.k f48907a;

    public m(int i10) {
        this.f48907a = new gm.k(i10);
    }

    public m(gm.k kVar) {
        this.f48907a = kVar;
    }

    public static m x(n0 n0Var, boolean z10) {
        return y(gm.k.H(n0Var, z10));
    }

    public static m y(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(gm.k.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f48907a;
    }

    public String toString() {
        int iM = this.f48907a.M();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(iM);
        sb2.append(iM == f48903b.f48907a.M() ? "(CPD)" : iM == f48904c.f48907a.M() ? "(VSD)" : iM == f48905d.f48907a.M() ? "(VPKC)" : iM == f48906e.f48907a.M() ? "(CCPD)" : "?");
        return sb2.toString();
    }

    public BigInteger z() {
        return this.f48907a.J();
    }
}
