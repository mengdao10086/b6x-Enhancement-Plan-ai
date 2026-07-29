package rm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import java.util.Arrays;
import zn.s0;

/* JADX INFO: loaded from: classes5.dex */
public class l extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s0[] f48899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f48900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f48901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48902d;

    public l(s0[] s0VarArr) {
        this.f48900b = false;
        this.f48901c = false;
        this.f48902d = false;
        this.f48899a = x(s0VarArr);
    }

    public l(s0[] s0VarArr, boolean z10, boolean z11, boolean z12) {
        this.f48900b = false;
        this.f48901c = false;
        this.f48902d = false;
        this.f48899a = x(s0VarArr);
        this.f48900b = z10;
        this.f48901c = z11;
        this.f48902d = z12;
    }

    public static l A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static l B(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj == null) {
            return null;
        }
        f0 f0VarJ = f0.J(obj);
        l lVar = new l(y(f0.J(f0VarJ.K(0))));
        for (int i10 = 1; i10 < f0VarJ.size(); i10++) {
            gm.h hVarK = f0VarJ.K(i10);
            if (hVarK instanceof gm.f) {
                lVar.H(gm.f.J(hVarK).L());
            } else if (hVarK instanceof n0) {
                n0 n0VarT = n0.T(hVarK);
                int iQ = n0VarT.q();
                if (iQ == 0) {
                    lVar.F(gm.f.I(n0VarT, false).L());
                } else {
                    if (iQ != 1) {
                        throw new IllegalArgumentException("Unknown tag encountered: " + n0VarT.q());
                    }
                    lVar.G(gm.f.I(n0VarT, false).L());
                }
            } else {
                continue;
            }
        }
        return lVar;
    }

    public static s0[] y(f0 f0Var) {
        int size = f0Var.size();
        s0[] s0VarArr = new s0[size];
        for (int i10 = 0; i10 != size; i10++) {
            s0VarArr[i10] = s0.x(f0Var.K(i10));
        }
        return s0VarArr;
    }

    public boolean C() {
        return this.f48901c;
    }

    public boolean D() {
        return this.f48902d;
    }

    public boolean E() {
        return this.f48900b;
    }

    public final void F(boolean z10) {
        this.f48901c = z10;
    }

    public final void G(boolean z10) {
        this.f48902d = z10;
    }

    public final void H(boolean z10) {
        this.f48900b = z10;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        gm.i iVar2 = new gm.i(this.f48899a.length);
        int i10 = 0;
        while (true) {
            s0[] s0VarArr = this.f48899a;
            if (i10 == s0VarArr.length) {
                break;
            }
            iVar2.a(s0VarArr[i10]);
            i10++;
        }
        iVar.a(new j2(iVar2));
        boolean z10 = this.f48900b;
        if (z10) {
            iVar.a(gm.f.K(z10));
        }
        boolean z11 = this.f48901c;
        if (z11) {
            iVar.a(new n2(false, 0, (gm.h) gm.f.K(z11)));
        }
        boolean z12 = this.f48902d;
        if (z12) {
            iVar.a(new n2(false, 1, (gm.h) gm.f.K(z12)));
        }
        return new j2(iVar);
    }

    public String toString() {
        return "PathProcInput: {\nacceptablePolicySet: " + Arrays.asList(this.f48899a) + "\ninhibitPolicyMapping: " + this.f48900b + "\nexplicitPolicyReqd: " + this.f48901c + "\ninhibitAnyPolicy: " + this.f48902d + "\n}\n";
    }

    public final s0[] x(s0[] s0VarArr) {
        int length = s0VarArr.length;
        s0[] s0VarArr2 = new s0[length];
        System.arraycopy(s0VarArr, 0, s0VarArr2, 0, length);
        return s0VarArr2;
    }

    public s0[] z() {
        return x(this.f48899a);
    }
}
