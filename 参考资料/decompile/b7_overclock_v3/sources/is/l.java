package is;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes6.dex */
public class l extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f35820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f35822c;

    public l(int i10, zn.b bVar) {
        this.f35820a = new t(0L);
        this.f35821b = i10;
        this.f35822c = bVar;
    }

    public l(f0 f0Var) {
        this.f35820a = t.I(f0Var.K(0));
        this.f35821b = t.I(f0Var.K(1)).Q();
        this.f35822c = zn.b.z(f0Var.K(2));
    }

    public static l y(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35820a);
        iVar.a(new t(this.f35821b));
        iVar.a(this.f35822c);
        return new j2(iVar);
    }

    public int x() {
        return this.f35821b;
    }

    public zn.b z() {
        return this.f35822c;
    }
}
