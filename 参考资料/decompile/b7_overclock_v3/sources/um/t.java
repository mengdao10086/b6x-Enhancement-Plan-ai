package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f52272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f52273b;

    public t(f0 f0Var) {
        this.f52272a = gm.y.N(f0Var.K(0));
        this.f52273b = f0Var.K(1);
    }

    public t(gm.y yVar, gm.h hVar) {
        this.f52272a = yVar;
        this.f52273b = hVar;
    }

    public static t x(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52272a);
        iVar.a(this.f52273b);
        return new j2(iVar);
    }

    public gm.y y() {
        return new gm.y(this.f52272a.L());
    }

    public gm.h z() {
        return this.f52273b;
    }
}
