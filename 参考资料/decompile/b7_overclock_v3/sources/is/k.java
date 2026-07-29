package is;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes6.dex */
public class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f35818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f35819b;

    public k(f0 f0Var) {
        this.f35818a = t.I(f0Var.K(0));
        this.f35819b = zn.b.z(f0Var.K(1));
    }

    public k(zn.b bVar) {
        this.f35818a = new t(0L);
        this.f35819b = bVar;
    }

    public static final k x(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35818a);
        iVar.a(this.f35819b);
        return new j2(iVar);
    }

    public zn.b y() {
        return this.f35819b;
    }
}
