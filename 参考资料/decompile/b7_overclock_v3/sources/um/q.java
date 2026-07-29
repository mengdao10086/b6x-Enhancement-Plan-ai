package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f52267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f52268c;

    public q(f0 f0Var) {
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            if (iQ == 0) {
                f0 f0Var2 = (f0) n0Var.U();
                Enumeration enumerationL2 = f0Var2.L();
                while (enumerationL2.hasMoreElements()) {
                    zn.p.y(enumerationL2.nextElement());
                }
                this.f52266a = f0Var2;
            } else if (iQ == 1) {
                f0 f0Var3 = (f0) n0Var.U();
                Enumeration enumerationL3 = f0Var3.L();
                while (enumerationL3.hasMoreElements()) {
                    nn.a.z(enumerationL3.nextElement());
                }
                this.f52267b = f0Var3;
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("invalid tag: " + n0Var.q());
                }
                this.f52268c = p.x(n0Var.U());
            }
        }
    }

    public q(zn.p[] pVarArr, nn.a[] aVarArr, p pVar) {
        if (pVarArr != null) {
            this.f52266a = new j2(pVarArr);
        }
        if (aVarArr != null) {
            this.f52267b = new j2(aVarArr);
        }
        this.f52268c = pVar;
    }

    public static q y(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(f0.J(obj));
        }
        return null;
    }

    public p A() {
        return this.f52268c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        f0 f0Var = this.f52266a;
        if (f0Var != null) {
            iVar.a(new n2(true, 0, (gm.h) f0Var));
        }
        f0 f0Var2 = this.f52267b;
        if (f0Var2 != null) {
            iVar.a(new n2(true, 1, (gm.h) f0Var2));
        }
        p pVar = this.f52268c;
        if (pVar != null) {
            iVar.a(new n2(true, 2, (gm.h) pVar.b()));
        }
        return new j2(iVar);
    }

    public zn.p[] x() {
        f0 f0Var = this.f52266a;
        if (f0Var == null) {
            return new zn.p[0];
        }
        int size = f0Var.size();
        zn.p[] pVarArr = new zn.p[size];
        for (int i10 = 0; i10 < size; i10++) {
            pVarArr[i10] = zn.p.y(this.f52266a.K(i10));
        }
        return pVarArr;
    }

    public nn.a[] z() {
        f0 f0Var = this.f52267b;
        if (f0Var == null) {
            return new nn.a[0];
        }
        int size = f0Var.size();
        nn.a[] aVarArr = new nn.a[size];
        for (int i10 = 0; i10 < size; i10++) {
            aVarArr[i10] = nn.a.z(this.f52267b.K(i10));
        }
        return aVarArr;
    }
}
