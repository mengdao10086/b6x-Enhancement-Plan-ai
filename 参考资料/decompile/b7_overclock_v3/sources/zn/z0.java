package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class z0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f59110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f59111b;

    public z0(gm.f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f59110a = c0.z(n0VarT, false);
            } else {
                if (iQ != 1) {
                    throw new IllegalArgumentException("Unknown tag in RoleSyntax");
                }
                this.f59111b = b0.y(n0VarT, true);
            }
        }
    }

    public z0(String str) {
        this(new b0(6, str == null ? "" : str));
    }

    public z0(b0 b0Var) {
        this(null, b0Var);
    }

    public z0(c0 c0Var, b0 b0Var) {
        if (b0Var == null || b0Var.q() != 6 || ((gm.k0) b0Var.A()).d().equals("")) {
            throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
        }
        this.f59110a = c0Var;
        this.f59111b = b0Var;
    }

    public static z0 x(Object obj) {
        if (obj instanceof z0) {
            return (z0) obj;
        }
        if (obj != null) {
            return new z0(gm.f0.J(obj));
        }
        return null;
    }

    public b0 A() {
        return this.f59111b;
    }

    public String B() {
        return ((gm.k0) this.f59111b.A()).d();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        c0 c0Var = this.f59110a;
        if (c0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) c0Var));
        }
        iVar.a(new n2(true, 1, (gm.h) this.f59111b));
        return new j2(iVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Name: " + B() + " - Auth: ");
        c0 c0Var = this.f59110a;
        if (c0Var == null || c0Var.B().length == 0) {
            stringBuffer.append("N/A");
        } else {
            String[] strArrZ = z();
            stringBuffer.append('[');
            stringBuffer.append(strArrZ[0]);
            for (int i10 = 1; i10 < strArrZ.length; i10++) {
                stringBuffer.append(", ");
                stringBuffer.append(strArrZ[i10]);
            }
            stringBuffer.append(']');
        }
        return stringBuffer.toString();
    }

    public c0 y() {
        return this.f59110a;
    }

    public String[] z() {
        c0 c0Var = this.f59110a;
        if (c0Var == null) {
            return new String[0];
        }
        b0[] b0VarArrB = c0Var.B();
        String[] strArr = new String[b0VarArrB.length];
        for (int i10 = 0; i10 < b0VarArrB.length; i10++) {
            gm.h hVarA = b0VarArrB[i10].A();
            if (hVarA instanceof gm.k0) {
                strArr[i10] = ((gm.k0) hVarA).d();
            } else {
                strArr[i10] = hVarA.toString();
            }
        }
        return strArr;
    }
}
