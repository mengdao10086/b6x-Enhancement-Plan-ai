package lm;

import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zn.b0 f39999m = new zn.b0(xn.d.A(new j2()));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f40000n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f40001o = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f40002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b0 f40003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b0 f40004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f40005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f40006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.z f40007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.z f40008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.z f40009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.z f40010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.z f40011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public v f40012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gm.f0 f40013l;

    public w(int i10, zn.b0 b0Var, zn.b0 b0Var2) {
        this(new gm.t(i10), b0Var, b0Var2);
    }

    public w(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f40002a = gm.t.I(enumerationL.nextElement());
        this.f40003b = zn.b0.z(enumerationL.nextElement());
        this.f40004c = zn.b0.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            switch (n0Var.q()) {
                case 0:
                    this.f40005d = gm.o.L(n0Var, true);
                    break;
                case 1:
                    this.f40006e = zn.b.y(n0Var, true);
                    break;
                case 2:
                    this.f40007f = gm.z.H(n0Var, true);
                    break;
                case 3:
                    this.f40008g = gm.z.H(n0Var, true);
                    break;
                case 4:
                    this.f40009h = gm.z.H(n0Var, true);
                    break;
                case 5:
                    this.f40010i = gm.z.H(n0Var, true);
                    break;
                case 6:
                    this.f40011j = gm.z.H(n0Var, true);
                    break;
                case 7:
                    this.f40012k = v.x(n0Var, true);
                    break;
                case 8:
                    this.f40013l = gm.f0.I(n0Var, true);
                    break;
                default:
                    throw new IllegalArgumentException("unknown tag number: " + n0Var.q());
            }
        }
    }

    public w(gm.t tVar, zn.b0 b0Var, zn.b0 b0Var2) {
        this.f40002a = tVar;
        this.f40003b = b0Var;
        this.f40004c = b0Var2;
    }

    public static w A(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj != null) {
            return new w(gm.f0.J(obj));
        }
        return null;
    }

    public gm.o B() {
        return this.f40005d;
    }

    public zn.b C() {
        return this.f40006e;
    }

    public gm.t D() {
        return this.f40002a;
    }

    public gm.z E() {
        return this.f40008g;
    }

    public gm.z F() {
        return this.f40011j;
    }

    public zn.b0 G() {
        return this.f40004c;
    }

    public zn.b0 H() {
        return this.f40003b;
    }

    public gm.z I() {
        return this.f40007f;
    }

    public gm.z J() {
        return this.f40010i;
    }

    public gm.z K() {
        return this.f40009h;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(12);
        iVar.a(this.f40002a);
        iVar.a(this.f40003b);
        iVar.a(this.f40004c);
        x(iVar, 0, this.f40005d);
        x(iVar, 1, this.f40006e);
        x(iVar, 2, this.f40007f);
        x(iVar, 3, this.f40008g);
        x(iVar, 4, this.f40009h);
        x(iVar, 5, this.f40010i);
        x(iVar, 6, this.f40011j);
        x(iVar, 7, this.f40012k);
        x(iVar, 8, this.f40013l);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public v y() {
        return this.f40012k;
    }

    public o[] z() {
        gm.f0 f0Var = this.f40013l;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        o[] oVarArr = new o[size];
        for (int i10 = 0; i10 < size; i10++) {
            oVarArr[i10] = o.z(this.f40013l.K(i10));
        }
        return oVarArr;
    }
}
