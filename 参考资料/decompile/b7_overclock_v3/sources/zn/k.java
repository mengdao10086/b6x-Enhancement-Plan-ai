package zn;

import gm.j2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58803a;

    public k(gm.f0 f0Var) {
        this.f58803a = f0Var;
    }

    public k(v[] vVarArr) {
        this.f58803a = null;
        this.f58803a = new j2(vVarArr);
    }

    public static k A(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(gm.f0.J(obj));
        }
        return null;
    }

    public static k x(z zVar) {
        return A(z.E(zVar, y.f59074s));
    }

    public static k z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58803a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("CRLDistPoint:");
        stringBuffer.append(strE);
        v[] vVarArrY = y();
        for (int i10 = 0; i10 != vVarArrY.length; i10++) {
            stringBuffer.append(wn.a.f54751a);
            stringBuffer.append(vVarArrY[i10]);
            stringBuffer.append(strE);
        }
        return stringBuffer.toString();
    }

    public v[] y() {
        v[] vVarArr = new v[this.f58803a.size()];
        for (int i10 = 0; i10 != this.f58803a.size(); i10++) {
            vVarArr[i10] = v.B(this.f58803a.K(i10));
        }
        return vVarArr;
    }
}
