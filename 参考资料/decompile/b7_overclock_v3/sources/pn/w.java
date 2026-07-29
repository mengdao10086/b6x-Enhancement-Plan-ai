package pn;

import gm.d2;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zn.b f46872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zn.b f46873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zn.b f46874f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f46875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f46876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f46877c;

    static {
        zn.b bVar = new zn.b(on.b.f44365i, d2.f29657b);
        f46872d = bVar;
        f46873e = new zn.b(s.E3, bVar);
        f46874f = new zn.b(s.F3, new f2(new byte[0]));
    }

    public w() {
        this.f46875a = f46872d;
        this.f46876b = f46873e;
        this.f46877c = f46874f;
    }

    public w(f0 f0Var) {
        this.f46875a = f46872d;
        this.f46876b = f46873e;
        this.f46877c = f46874f;
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            n0 n0Var = (n0) f0Var.K(i10);
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f46875a = zn.b.y(n0Var, true);
            } else if (iQ == 1) {
                this.f46876b = zn.b.y(n0Var, true);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("unknown tag");
                }
                this.f46877c = zn.b.y(n0Var, true);
            }
        }
    }

    public w(zn.b bVar, zn.b bVar2, zn.b bVar3) {
        this.f46875a = bVar;
        this.f46876b = bVar2;
        this.f46877c = bVar3;
    }

    public static w y(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj != null) {
            return new w(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f46877c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        if (!this.f46875a.equals(f46872d)) {
            iVar.a(new n2(true, 0, (gm.h) this.f46875a));
        }
        if (!this.f46876b.equals(f46873e)) {
            iVar.a(new n2(true, 1, (gm.h) this.f46876b));
        }
        if (!this.f46877c.equals(f46874f)) {
            iVar.a(new n2(true, 2, (gm.h) this.f46877c));
        }
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f46875a;
    }

    public zn.b z() {
        return this.f46876b;
    }
}
