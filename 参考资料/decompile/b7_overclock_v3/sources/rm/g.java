package rm;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.o;
import gm.t;
import gm.w;
import java.math.BigInteger;
import zn.c0;
import zn.s0;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f48861j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48862k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48863l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48864m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48865n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48866o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f48868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f48869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f48870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c0 f48871e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s0 f48872f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0 f48873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c0 f48874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z f48875i;

    public g(f0 f0Var) {
        int i10;
        this.f48867a = 1;
        if (f0Var.K(0) instanceof t) {
            this.f48867a = t.I(f0Var.K(0)).Q();
            i10 = 1;
        } else {
            this.f48867a = 1;
            i10 = 0;
        }
        this.f48868b = m.y(f0Var.K(i10));
        for (int i11 = i10 + 1; i11 < f0Var.size(); i11++) {
            gm.h hVarK = f0Var.K(i11);
            if (hVarK instanceof t) {
                this.f48869c = t.I(hVarK).K();
            } else if (!(hVarK instanceof o) && (hVarK instanceof n0)) {
                n0 n0VarT = n0.T(hVarK);
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    this.f48871e = c0.z(n0VarT, false);
                } else if (iQ == 1) {
                    this.f48872f = s0.x(f0.I(n0VarT, false));
                } else if (iQ == 2) {
                    this.f48873g = c0.z(n0VarT, false);
                } else if (iQ == 3) {
                    this.f48874h = c0.z(n0VarT, false);
                } else {
                    if (iQ != 4) {
                        throw new IllegalArgumentException("unknown tag number encountered: " + iQ);
                    }
                    this.f48875i = z.F(n0VarT, false);
                }
            } else {
                this.f48870d = j.z(hVarK);
            }
        }
    }

    public static g A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static g B(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    public BigInteger C() {
        return this.f48869c;
    }

    public s0 D() {
        return this.f48872f;
    }

    public j E() {
        return this.f48870d;
    }

    public c0 F() {
        return this.f48871e;
    }

    public m G() {
        return this.f48868b;
    }

    public int H() {
        return this.f48867a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(9);
        if (this.f48867a != 1) {
            iVar.a(new t(this.f48867a));
        }
        iVar.a(this.f48868b);
        if (this.f48869c != null) {
            iVar.a(new t(this.f48869c));
        }
        j jVar = this.f48870d;
        if (jVar != null) {
            iVar.a(jVar);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        gm.h[] hVarArr = {this.f48871e, this.f48872f, this.f48873g, this.f48874h, this.f48875i};
        for (int i10 = 0; i10 < 5; i10++) {
            int i11 = iArr[i10];
            gm.h hVar = hVarArr[i10];
            if (hVar != null) {
                iVar.a(new n2(false, i11, hVar));
            }
        }
        return new j2(iVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSRequestInformation {\n");
        if (this.f48867a != 1) {
            stringBuffer.append("version: " + this.f48867a + "\n");
        }
        stringBuffer.append("service: " + this.f48868b + "\n");
        if (this.f48869c != null) {
            stringBuffer.append("nonce: " + this.f48869c + "\n");
        }
        if (this.f48870d != null) {
            stringBuffer.append("requestTime: " + this.f48870d + "\n");
        }
        if (this.f48871e != null) {
            stringBuffer.append("requester: " + this.f48871e + "\n");
        }
        if (this.f48872f != null) {
            stringBuffer.append("requestPolicy: " + this.f48872f + "\n");
        }
        if (this.f48873g != null) {
            stringBuffer.append("dvcs: " + this.f48873g + "\n");
        }
        if (this.f48874h != null) {
            stringBuffer.append("dataLocations: " + this.f48874h + "\n");
        }
        if (this.f48875i != null) {
            stringBuffer.append("extensions: " + this.f48875i + "\n");
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public c0 x() {
        return this.f48873g;
    }

    public c0 y() {
        return this.f48874h;
    }

    public z z() {
        return this.f48875i;
    }
}
