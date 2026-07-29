package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f52260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f52261b;

    public n(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f52260a = zn.b.z(f0Var.K(0));
            this.f52261b = z.I(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public n(zn.b bVar, z zVar) {
        this.f52260a = bVar;
        this.f52261b = zVar;
    }

    public static n z(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52260a);
        iVar.a(this.f52261b);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f52260a;
    }

    public z y() {
        return this.f52261b;
    }
}
