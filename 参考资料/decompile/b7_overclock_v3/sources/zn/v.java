package zn;

import gm.j2;
import gm.n2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f59010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y0 f59011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f59012c;

    public v(gm.f0 f0Var) {
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f59010a = w.y(n0VarT, true);
            } else if (iQ == 1) {
                this.f59011b = new y0(gm.u1.R(n0VarT, false));
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("Unknown tag encountered in structure: " + n0VarT.q());
                }
                this.f59012c = c0.z(n0VarT, false);
            }
        }
    }

    public v(w wVar, y0 y0Var, c0 c0Var) {
        this.f59010a = wVar;
        this.f59011b = y0Var;
        this.f59012c = c0Var;
    }

    public static v A(gm.n0 n0Var, boolean z10) {
        return B(gm.f0.I(n0Var, z10));
    }

    public static v B(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof gm.f0) {
            return new v((gm.f0) obj);
        }
        throw new IllegalArgumentException("Invalid DistributionPoint: " + obj.getClass().getName());
    }

    public y0 C() {
        return this.f59011b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        w wVar = this.f59010a;
        if (wVar != null) {
            iVar.a(new n2(0, wVar));
        }
        y0 y0Var = this.f59011b;
        if (y0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) y0Var));
        }
        c0 c0Var = this.f59012c;
        if (c0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) c0Var));
        }
        return new j2(iVar);
    }

    public String toString() {
        String strE = Strings.e();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPoint: [");
        stringBuffer.append(strE);
        w wVar = this.f59010a;
        if (wVar != null) {
            x(stringBuffer, strE, "distributionPoint", wVar.toString());
        }
        y0 y0Var = this.f59011b;
        if (y0Var != null) {
            x(stringBuffer, strE, "reasons", y0Var.toString());
        }
        c0 c0Var = this.f59012c;
        if (c0Var != null) {
            x(stringBuffer, strE, "cRLIssuer", c0Var.toString());
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

    public c0 y() {
        return this.f59012c;
    }

    public w z() {
        return this.f59010a;
    }
}
