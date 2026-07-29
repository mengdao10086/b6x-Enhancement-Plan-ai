package rm;

import gm.c0;
import gm.f0;
import gm.n0;
import gm.n2;
import gm.w;
import lm.b0;
import zn.o;
import zn.p;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w implements gm.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f48806d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f48807e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f48808f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f48809g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48810h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f48811i = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f48812j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f48813k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f48814l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean[] f48815m = {false, true, false, true, false, true, false, false, true};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f48816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f48817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f48818c;

    public a(int i10, gm.h hVar) {
        this.f48816a = i10;
        this.f48817b = hVar;
    }

    public a(n0 n0Var) {
        gm.h hVarY;
        int iQ = n0Var.q();
        this.f48816a = iQ;
        switch (iQ) {
            case 0:
                hVarY = o.y(n0Var, false);
                break;
            case 1:
                hVarY = vm.c.y(n0Var.U());
                break;
            case 2:
                hVarY = b0.y(n0Var, false);
                break;
            case 3:
                hVarY = mm.n.A(n0Var.U());
                break;
            case 4:
                hVarY = p.x(n0Var, false);
                break;
            case 5:
                hVarY = nn.c.y(n0Var.U());
                break;
            case 6:
                hVarY = nn.b.y(n0Var, false);
                break;
            case 7:
                hVarY = nn.g.x(n0Var, false);
                break;
            case 8:
                hVarY = sn.b.y(n0Var.U());
                break;
            default:
                throw new IllegalArgumentException("Unknown tag: " + this.f48816a);
        }
        this.f48817b = hVarY;
    }

    public a(y yVar) {
        this.f48816a = -1;
        this.f48818c = yVar;
    }

    public static a[] x(f0 f0Var) {
        int size = f0Var.size();
        a[] aVarArr = new a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = z(f0Var.K(i10));
        }
        return aVarArr;
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj instanceof n0) {
            return new a((n0) obj);
        }
        if (obj != null) {
            return new a(y.B(obj));
        }
        return null;
    }

    public gm.h A() {
        return this.f48817b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        y yVar = this.f48818c;
        if (yVar != null) {
            return yVar.b();
        }
        boolean[] zArr = f48815m;
        int i10 = this.f48816a;
        return new n2(zArr[i10], i10, this.f48817b);
    }

    public int q() {
        return this.f48816a;
    }

    public String toString() {
        return "CertEtcToken {\n" + this.f48817b + "}\n";
    }

    public y y() {
        return this.f48818c;
    }
}
