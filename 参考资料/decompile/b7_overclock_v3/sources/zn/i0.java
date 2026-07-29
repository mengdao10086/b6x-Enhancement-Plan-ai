package zn;

import gm.j2;
import gm.n2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f58766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f58767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f58768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y0 f58769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f58770e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58771f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.f0 f58772g;

    public i0(gm.f0 f0Var) {
        this.f58772g = f0Var;
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f58766a = w.y(n0VarT, true);
            } else if (iQ == 1) {
                this.f58767b = gm.f.I(n0VarT, false).L();
            } else if (iQ == 2) {
                this.f58768c = gm.f.I(n0VarT, false).L();
            } else if (iQ == 3) {
                this.f58769d = new y0(gm.d.J(n0VarT, false));
            } else if (iQ == 4) {
                this.f58770e = gm.f.I(n0VarT, false).L();
            } else {
                if (iQ != 5) {
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
                this.f58771f = gm.f.I(n0VarT, false).L();
            }
        }
    }

    public i0(w wVar, boolean z10, boolean z11) {
        this(wVar, false, false, null, z10, z11);
    }

    public i0(w wVar, boolean z10, boolean z11, y0 y0Var, boolean z12, boolean z13) {
        this.f58766a = wVar;
        this.f58770e = z12;
        this.f58771f = z13;
        this.f58768c = z11;
        this.f58767b = z10;
        this.f58769d = y0Var;
        gm.i iVar = new gm.i(6);
        if (wVar != null) {
            iVar.a(new n2(true, 0, (gm.h) wVar));
        }
        if (z10) {
            iVar.a(new n2(false, 1, (gm.h) gm.f.K(true)));
        }
        if (z11) {
            iVar.a(new n2(false, 2, (gm.h) gm.f.K(true)));
        }
        if (y0Var != null) {
            iVar.a(new n2(false, 3, (gm.h) y0Var));
        }
        if (z12) {
            iVar.a(new n2(false, 4, (gm.h) gm.f.K(true)));
        }
        if (z13) {
            iVar.a(new n2(false, 5, (gm.h) gm.f.K(true)));
        }
        this.f58772g = new j2(iVar);
    }

    public static i0 A(gm.n0 n0Var, boolean z10) {
        return B(gm.f0.I(n0Var, z10));
    }

    public static i0 B(Object obj) {
        if (obj instanceof i0) {
            return (i0) obj;
        }
        if (obj != null) {
            return new i0(gm.f0.J(obj));
        }
        return null;
    }

    public y0 C() {
        return this.f58769d;
    }

    public boolean D() {
        return this.f58770e;
    }

    public boolean E() {
        return this.f58771f;
    }

    public boolean F() {
        return this.f58768c;
    }

    public boolean G() {
        return this.f58767b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58772g;
    }

    public String toString() {
        String strE = Strings.e();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(strE);
        w wVar = this.f58766a;
        if (wVar != null) {
            x(stringBuffer, strE, "distributionPoint", wVar.toString());
        }
        boolean z10 = this.f58767b;
        if (z10) {
            x(stringBuffer, strE, "onlyContainsUserCerts", y(z10));
        }
        boolean z11 = this.f58768c;
        if (z11) {
            x(stringBuffer, strE, "onlyContainsCACerts", y(z11));
        }
        y0 y0Var = this.f58769d;
        if (y0Var != null) {
            x(stringBuffer, strE, "onlySomeReasons", y0Var.toString());
        }
        boolean z12 = this.f58771f;
        if (z12) {
            x(stringBuffer, strE, "onlyContainsAttributeCerts", y(z12));
        }
        boolean z13 = this.f58770e;
        if (z13) {
            x(stringBuffer, strE, "indirectCRL", y(z13));
        }
        stringBuffer.append("]");
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }

    public final void x(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append(wn.a.f54751a);
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append(wn.a.f54751a);
        stringBuffer.append(wn.a.f54751a);
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    public final String y(boolean z10) {
        return z10 ? "true" : "false";
    }

    public w z() {
        return this.f58766a;
    }
}
