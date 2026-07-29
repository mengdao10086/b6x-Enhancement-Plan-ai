package en;

import gm.c0;
import gm.d0;
import gm.f0;
import gm.i2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import java.util.Enumeration;
import zn.b0;
import zn.h0;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f27054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.b f27055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f27056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f27057d;

    public g(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0VarT = n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            if (iQ == 1) {
                this.f27054a = d0.H(n0VarT, true).d();
            } else if (iQ == 2) {
                this.f27055b = xn.b.x(n0VarT, true);
            } else {
                if (iQ != 3) {
                    throw new IllegalArgumentException("Bad tag number: " + n0VarT.q());
                }
                c0 c0VarU = n0VarT.U();
                if (c0VarU instanceof n0) {
                    this.f27056c = b0.z(c0VarU);
                } else {
                    this.f27057d = h0.y(c0VarU);
                }
            }
        }
    }

    public g(String str, xn.b bVar, b0 b0Var) {
        this.f27054a = str;
        this.f27055b = bVar;
        this.f27056c = b0Var;
        this.f27057d = null;
    }

    public g(String str, xn.b bVar, h0 h0Var) {
        this.f27054a = str;
        this.f27055b = bVar;
        this.f27056c = null;
        this.f27057d = h0Var;
    }

    public static g z(Object obj) {
        if (obj == null || (obj instanceof g)) {
            return (g) obj;
        }
        if (obj instanceof f0) {
            return new g((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public b0 A() {
        return this.f27056c;
    }

    public xn.b B() {
        return this.f27055b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        if (this.f27054a != null) {
            iVar.a(new n2(true, 1, (gm.h) new i2(this.f27054a, true)));
        }
        xn.b bVar = this.f27055b;
        if (bVar != null) {
            iVar.a(new n2(true, 2, (gm.h) bVar));
        }
        b0 b0Var = this.f27056c;
        if (b0Var != null) {
            iVar.a(new n2(true, 3, (gm.h) b0Var));
        } else {
            iVar.a(new n2(true, 3, (gm.h) this.f27057d));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f27057d;
    }

    public String y() {
        return this.f27054a;
    }
}
