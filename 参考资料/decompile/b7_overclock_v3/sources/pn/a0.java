package pn;

import gm.d2;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends gm.w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f46723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zn.b f46724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final gm.t f46725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.t f46726h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f46727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f46728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f46729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.t f46730d;

    static {
        zn.b bVar = new zn.b(on.b.f44365i, d2.f29657b);
        f46723e = bVar;
        f46724f = new zn.b(s.E3, bVar);
        f46725g = new gm.t(20L);
        f46726h = new gm.t(1L);
    }

    public a0() {
        this.f46727a = f46723e;
        this.f46728b = f46724f;
        this.f46729c = f46725g;
        this.f46730d = f46726h;
    }

    public a0(f0 f0Var) {
        this.f46727a = f46723e;
        this.f46728b = f46724f;
        this.f46729c = f46725g;
        this.f46730d = f46726h;
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            n0 n0Var = (n0) f0Var.K(i10);
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f46727a = zn.b.y(n0Var, true);
            } else if (iQ == 1) {
                this.f46728b = zn.b.y(n0Var, true);
            } else if (iQ == 2) {
                this.f46729c = gm.t.H(n0Var, true);
            } else {
                if (iQ != 3) {
                    throw new IllegalArgumentException("unknown tag");
                }
                this.f46730d = gm.t.H(n0Var, true);
            }
        }
    }

    public a0(zn.b bVar, zn.b bVar2, gm.t tVar, gm.t tVar2) {
        this.f46727a = bVar;
        this.f46728b = bVar2;
        this.f46729c = tVar;
        this.f46730d = tVar2;
    }

    public static a0 y(Object obj) {
        if (obj instanceof a0) {
            return (a0) obj;
        }
        if (obj != null) {
            return new a0(f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f46729c.K();
    }

    public BigInteger B() {
        return this.f46730d.K();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        if (!this.f46727a.equals(f46723e)) {
            iVar.a(new n2(true, 0, (gm.h) this.f46727a));
        }
        if (!this.f46728b.equals(f46724f)) {
            iVar.a(new n2(true, 1, (gm.h) this.f46728b));
        }
        if (!this.f46729c.C(f46725g)) {
            iVar.a(new n2(true, 2, (gm.h) this.f46729c));
        }
        if (!this.f46730d.C(f46726h)) {
            iVar.a(new n2(true, 3, (gm.h) this.f46730d));
        }
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f46727a;
    }

    public zn.b z() {
        return this.f46728b;
    }
}
