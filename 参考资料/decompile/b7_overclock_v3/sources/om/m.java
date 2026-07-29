package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f44310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f44311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f44312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f44313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f44314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.d f44315f;

    public m(f0 f0Var) {
        int i10 = 0;
        while (f0Var.K(i10) instanceof n0) {
            n0 n0Var = (n0) f0Var.K(i10);
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f44310a = zn.b.y(n0Var, false);
            } else if (iQ == 1) {
                this.f44311b = zn.b.y(n0Var, false);
            } else if (iQ == 2) {
                this.f44312c = gm.d.J(n0Var, false);
            } else if (iQ == 3) {
                this.f44313d = zn.b.y(n0Var, false);
            } else {
                if (iQ != 4) {
                    throw new IllegalArgumentException("Unknown tag encountered: " + n0Var.q());
                }
                this.f44314e = z.H(n0Var, false);
            }
            i10++;
        }
        this.f44315f = gm.d.K(f0Var.K(i10));
    }

    public m(zn.b bVar, zn.b bVar2, gm.d dVar, zn.b bVar3, z zVar, gm.d dVar2) {
        if (dVar2 == null) {
            throw new IllegalArgumentException("'encValue' cannot be null");
        }
        this.f44310a = bVar;
        this.f44311b = bVar2;
        this.f44312c = dVar;
        this.f44313d = bVar3;
        this.f44314e = zVar;
        this.f44315f = dVar2;
    }

    public static m A(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(f0.J(obj));
        }
        return null;
    }

    public zn.b B() {
        return this.f44310a;
    }

    public zn.b C() {
        return this.f44313d;
    }

    public zn.b D() {
        return this.f44311b;
    }

    public z E() {
        return this.f44314e;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        x(iVar, 0, this.f44310a);
        x(iVar, 1, this.f44311b);
        x(iVar, 2, this.f44312c);
        x(iVar, 3, this.f44313d);
        x(iVar, 4, this.f44314e);
        iVar.a(this.f44315f);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(false, i10, hVar));
        }
    }

    public gm.d y() {
        return this.f44312c;
    }

    public gm.d z() {
        return this.f44315f;
    }
}
