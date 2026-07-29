package zn;

import gm.j2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0[] f58682a;

    public c0(gm.f0 f0Var) {
        this.f58682a = new b0[f0Var.size()];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            this.f58682a[i10] = b0.z(f0Var.K(i10));
        }
    }

    public c0(b0 b0Var) {
        this.f58682a = new b0[]{b0Var};
    }

    public c0(b0[] b0VarArr) {
        this.f58682a = x(b0VarArr);
    }

    public static c0 A(Object obj) {
        if (obj instanceof c0) {
            return (c0) obj;
        }
        if (obj != null) {
            return new c0(gm.f0.J(obj));
        }
        return null;
    }

    public static b0[] x(b0[] b0VarArr) {
        b0[] b0VarArr2 = new b0[b0VarArr.length];
        System.arraycopy(b0VarArr, 0, b0VarArr2, 0, b0VarArr.length);
        return b0VarArr2;
    }

    public static c0 y(z zVar, gm.y yVar) {
        return A(z.E(zVar, yVar));
    }

    public static c0 z(gm.n0 n0Var, boolean z10) {
        return new c0(gm.f0.I(n0Var, z10));
    }

    public b0[] B() {
        return x(this.f58682a);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(this.f58682a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("GeneralNames:");
        stringBuffer.append(strE);
        for (int i10 = 0; i10 != this.f58682a.length; i10++) {
            stringBuffer.append(wn.a.f54751a);
            stringBuffer.append(this.f58682a[i10]);
            stringBuffer.append(strE);
        }
        return stringBuffer.toString();
    }
}
