package en;

import gm.c0;
import gm.d0;
import gm.f0;
import gm.f2;
import gm.i2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.y;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final y f27058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final y f27059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f27060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final y f27061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final y f27062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final y f27063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final y f27064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final y f27065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final y f27066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final y f27067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final y f27068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y f27069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final y f27070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final y f27071s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final y f27072t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final y f27073u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final y f27074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final y f27075w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final y f27076x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f27077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f27078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f27079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f27080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f27081e;

    static {
        StringBuilder sb2 = new StringBuilder();
        y yVar = f.f27050d;
        sb2.append(yVar);
        sb2.append(".1");
        f27058f = new y(sb2.toString());
        f27059g = new y(yVar + ".2");
        f27060h = new y(yVar + ".3");
        f27061i = new y(yVar + ".4");
        f27062j = new y(yVar + ".5");
        f27063k = new y(yVar + ".6");
        f27064l = new y(yVar + ".7");
        f27065m = new y(yVar + ".8");
        f27066n = new y(yVar + ".9");
        f27067o = new y(yVar + ".10");
        f27068p = new y(yVar + ".11");
        f27069q = new y(yVar + ".12");
        f27070r = new y(yVar + ".13");
        f27071s = new y(yVar + ".14");
        f27072t = new y(yVar + ".15");
        f27073u = new y(yVar + ".16");
        f27074v = new y(yVar + ".17");
        f27075w = new y(yVar + ".18");
        f27076x = new y(yVar + ".19");
    }

    public h(f fVar, xn.b[] bVarArr, y[] yVarArr, String str, z zVar) {
        this.f27077a = fVar;
        this.f27078b = new j2(bVarArr);
        if (yVarArr != null) {
            this.f27079c = new j2(yVarArr);
        }
        this.f27080d = str;
        this.f27081e = zVar;
    }

    public h(f0 f0Var) {
        if (f0Var.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        gm.h hVar = (gm.h) enumerationL.nextElement();
        if (hVar instanceof n0) {
            n0 n0Var = (n0) hVar;
            if (n0Var.q() != 0) {
                throw new IllegalArgumentException("Bad tag number: " + n0Var.q());
            }
            this.f27077a = f.x(n0Var, true);
            hVar = (gm.h) enumerationL.nextElement();
        }
        this.f27078b = f0.J(hVar);
        if (enumerationL.hasMoreElements()) {
            gm.h hVar2 = (gm.h) enumerationL.nextElement();
            if (hVar2 instanceof f0) {
                this.f27079c = f0.J(hVar2);
            } else if (hVar2 instanceof d0) {
                this.f27080d = d0.I(hVar2).d();
            } else {
                if (!(hVar2 instanceof z)) {
                    throw new IllegalArgumentException("Bad object encountered: " + hVar2.getClass());
                }
                this.f27081e = z.I(hVar2);
            }
        }
        if (enumerationL.hasMoreElements()) {
            gm.h hVar3 = (gm.h) enumerationL.nextElement();
            if (hVar3 instanceof d0) {
                this.f27080d = d0.I(hVar3).d();
            } else {
                if (!(hVar3 instanceof f2)) {
                    throw new IllegalArgumentException("Bad object encountered: " + hVar3.getClass());
                }
                this.f27081e = (f2) hVar3;
            }
        }
        if (enumerationL.hasMoreElements()) {
            gm.h hVar4 = (gm.h) enumerationL.nextElement();
            if (hVar4 instanceof f2) {
                this.f27081e = (f2) hVar4;
                return;
            }
            throw new IllegalArgumentException("Bad object encountered: " + hVar4.getClass());
        }
    }

    public static h y(Object obj) {
        if (obj == null || (obj instanceof h)) {
            return (h) obj;
        }
        if (obj instanceof f0) {
            return new h((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public xn.b[] A() {
        xn.b[] bVarArr = new xn.b[this.f27078b.size()];
        Enumeration enumerationL = this.f27078b.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            bVarArr[i10] = xn.b.y(enumerationL.nextElement());
            i10++;
        }
        return bVarArr;
    }

    public y[] B() {
        f0 f0Var = this.f27079c;
        int i10 = 0;
        if (f0Var == null) {
            return new y[0];
        }
        y[] yVarArr = new y[f0Var.size()];
        Enumeration enumerationL = this.f27079c.L();
        while (enumerationL.hasMoreElements()) {
            yVarArr[i10] = y.N(enumerationL.nextElement());
            i10++;
        }
        return yVarArr;
    }

    public String C() {
        return this.f27080d;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        f fVar = this.f27077a;
        if (fVar != null) {
            iVar.a(new n2(true, 0, (gm.h) fVar));
        }
        iVar.a(this.f27078b);
        f0 f0Var = this.f27079c;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        if (this.f27080d != null) {
            iVar.a(new i2(this.f27080d, true));
        }
        z zVar = this.f27081e;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public z x() {
        return this.f27081e;
    }

    public f z() {
        return this.f27077a;
    }
}
