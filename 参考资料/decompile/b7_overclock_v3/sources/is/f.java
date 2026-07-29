package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ft.e f35773c;

    public f(int i10, int i11, ft.e eVar) {
        this.f35771a = i10;
        this.f35772b = i11;
        this.f35773c = new ft.e(eVar);
    }

    public f(f0 f0Var) {
        this.f35771a = ((t) f0Var.K(0)).Q();
        this.f35772b = ((t) f0Var.K(1)).Q();
        this.f35773c = new ft.e(((z) f0Var.K(2)).J());
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f35772b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(this.f35771a));
        iVar.a(new t(this.f35772b));
        iVar.a(new f2(this.f35773c.b()));
        return new j2(iVar);
    }

    public ft.e x() {
        return new ft.e(this.f35773c);
    }

    public int z() {
        return this.f35771a;
    }
}
