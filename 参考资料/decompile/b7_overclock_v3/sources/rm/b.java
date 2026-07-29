package rm;

import gm.c0;
import gm.f0;
import gm.h0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import lm.b0;
import zn.s0;
import zn.t;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48819k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48820l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f48821m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f48822n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f48823o = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f48825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f48826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.t f48827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j f48828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b0 f48829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s0 f48830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h0 f48831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f0 f48832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f48833j;

    public b(f0 f0Var) {
        int i10;
        this.f48824a = 1;
        gm.h hVarK = f0Var.K(0);
        try {
            this.f48824a = gm.t.I(hVarK).Q();
            try {
                hVarK = f0Var.K(1);
            } catch (IllegalArgumentException unused) {
            }
            i10 = 2;
        } catch (IllegalArgumentException unused2) {
            i10 = 1;
        }
        this.f48825b = g.B(hVarK);
        int i11 = i10 + 1;
        this.f48826c = t.A(f0Var.K(i10));
        int i12 = i11 + 1;
        this.f48827d = gm.t.I(f0Var.K(i11));
        int i13 = i12 + 1;
        this.f48828e = j.z(f0Var.K(i12));
        while (i13 < f0Var.size()) {
            int i14 = i13 + 1;
            gm.h hVarK2 = f0Var.K(i13);
            if (hVarK2 instanceof n0) {
                n0 n0VarT = n0.T(hVarK2);
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    this.f48829f = b0.y(n0VarT, false);
                } else if (iQ == 1) {
                    this.f48830g = s0.x(f0.I(n0VarT, false));
                } else if (iQ == 2) {
                    this.f48831h = h0.H(n0VarT, false);
                } else {
                    if (iQ != 3) {
                        throw new IllegalArgumentException("Unknown tag encountered: " + iQ);
                    }
                    this.f48832i = f0.I(n0VarT, false);
                }
            } else {
                try {
                    this.f48833j = z.G(hVarK2);
                } catch (IllegalArgumentException unused3) {
                }
            }
            i13 = i14;
        }
    }

    public b(g gVar, t tVar, gm.t tVar2, j jVar) {
        this.f48824a = 1;
        this.f48825b = gVar;
        this.f48826c = tVar;
        this.f48827d = tVar2;
        this.f48828e = jVar;
    }

    public static b B(n0 n0Var, boolean z10) {
        return C(f0.I(n0Var, z10));
    }

    public static b C(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public z A() {
        return this.f48833j;
    }

    public t D() {
        return this.f48826c;
    }

    public s0 E() {
        return this.f48830g;
    }

    public h0 F() {
        return this.f48831h;
    }

    public j G() {
        return this.f48828e;
    }

    public gm.t H() {
        return this.f48827d;
    }

    public int I() {
        return this.f48824a;
    }

    public final void J(g gVar) {
        this.f48825b = gVar;
    }

    public final void K(t tVar) {
        this.f48826c = tVar;
    }

    public final void L(int i10) {
        this.f48824a = i10;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(10);
        if (this.f48824a != 1) {
            iVar.a(new gm.t(this.f48824a));
        }
        iVar.a(this.f48825b);
        iVar.a(this.f48826c);
        iVar.a(this.f48827d);
        iVar.a(this.f48828e);
        b0 b0Var = this.f48829f;
        if (b0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) b0Var));
        }
        s0 s0Var = this.f48830g;
        if (s0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) s0Var));
        }
        h0 h0Var = this.f48831h;
        if (h0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) h0Var));
        }
        f0 f0Var = this.f48832i;
        if (f0Var != null) {
            iVar.a(new n2(false, 3, (gm.h) f0Var));
        }
        z zVar = this.f48833j;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSCertInfo {\n");
        if (this.f48824a != 1) {
            stringBuffer.append("version: " + this.f48824a + "\n");
        }
        stringBuffer.append("dvReqInfo: " + this.f48825b + "\n");
        stringBuffer.append("messageImprint: " + this.f48826c + "\n");
        stringBuffer.append("serialNumber: " + this.f48827d + "\n");
        stringBuffer.append("responseTime: " + this.f48828e + "\n");
        if (this.f48829f != null) {
            stringBuffer.append("dvStatus: " + this.f48829f + "\n");
        }
        if (this.f48830g != null) {
            stringBuffer.append("policy: " + this.f48830g + "\n");
        }
        if (this.f48831h != null) {
            stringBuffer.append("reqSignature: " + this.f48831h + "\n");
        }
        if (this.f48832i != null) {
            stringBuffer.append("certs: " + this.f48832i + "\n");
        }
        if (this.f48833j != null) {
            stringBuffer.append("extensions: " + this.f48833j + "\n");
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }

    public n[] x() {
        f0 f0Var = this.f48832i;
        if (f0Var != null) {
            return n.x(f0Var);
        }
        return null;
    }

    public g y() {
        return this.f48825b;
    }

    public b0 z() {
        return this.f48829f;
    }
}
