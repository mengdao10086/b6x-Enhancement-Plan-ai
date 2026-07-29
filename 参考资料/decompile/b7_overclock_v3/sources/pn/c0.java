package pn;

import gm.f0;
import gm.h0;
import gm.i1;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends gm.w implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f46739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f46740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h0 f46741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h0 f46742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f46743f;

    public c0(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f46738a = (gm.t) enumerationL.nextElement();
        this.f46739b = (h0) enumerationL.nextElement();
        this.f46740c = g.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            gm.c0 c0Var = (gm.c0) enumerationL.nextElement();
            if (c0Var instanceof n0) {
                n0 n0Var = (n0) c0Var;
                int iQ = n0Var.q();
                if (iQ == 0) {
                    this.f46741d = h0.H(n0Var, false);
                } else {
                    if (iQ != 1) {
                        throw new IllegalArgumentException("unknown tag value " + n0Var.q());
                    }
                    this.f46742e = h0.H(n0Var, false);
                }
            } else {
                this.f46743f = (h0) c0Var;
            }
        }
    }

    public c0(gm.t tVar, h0 h0Var, g gVar, h0 h0Var2, h0 h0Var3, h0 h0Var4) {
        this.f46738a = tVar;
        this.f46739b = h0Var;
        this.f46740c = gVar;
        this.f46741d = h0Var2;
        this.f46742e = h0Var3;
        this.f46743f = h0Var4;
    }

    public static c0 B(Object obj) {
        if (obj instanceof c0) {
            return (c0) obj;
        }
        if (obj != null) {
            return new c0(f0.J(obj));
        }
        return null;
    }

    public h0 A() {
        return this.f46739b;
    }

    public h0 C() {
        return this.f46743f;
    }

    public gm.t D() {
        return this.f46738a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(this.f46738a);
        iVar.a(this.f46739b);
        iVar.a(this.f46740c);
        h0 h0Var = this.f46741d;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        h0 h0Var2 = this.f46742e;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var2));
        }
        iVar.a(this.f46743f);
        return new i1(iVar);
    }

    public h0 x() {
        return this.f46742e;
    }

    public h0 y() {
        return this.f46741d;
    }

    public g z() {
        return this.f46740c;
    }
}
