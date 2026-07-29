package zn;

import gm.n2;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f59017c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f59018d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f59019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59020b;

    public w(int i10, gm.h hVar) {
        this.f59020b = i10;
        this.f59019a = hVar;
    }

    public w(gm.n0 n0Var) {
        int iQ = n0Var.q();
        this.f59020b = iQ;
        this.f59019a = iQ == 0 ? c0.z(n0Var, false) : gm.h0.H(n0Var, false);
    }

    public w(c0 c0Var) {
        this(0, c0Var);
    }

    public static w y(gm.n0 n0Var, boolean z10) {
        return z(gm.n0.S(n0Var, true));
    }

    public static w z(Object obj) {
        if (obj == null || (obj instanceof w)) {
            return (w) obj;
        }
        if (obj instanceof gm.n0) {
            return new w((gm.n0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public gm.h A() {
        return this.f59019a;
    }

    public int B() {
        return this.f59020b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(false, this.f59020b, this.f59019a);
    }

    public String toString() {
        String string;
        String str;
        String strE = Strings.e();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(strE);
        if (this.f59020b == 0) {
            string = this.f59019a.toString();
            str = "fullName";
        } else {
            string = this.f59019a.toString();
            str = "nameRelativeToCRLIssuer";
        }
        x(stringBuffer, strE, str, string);
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
}
