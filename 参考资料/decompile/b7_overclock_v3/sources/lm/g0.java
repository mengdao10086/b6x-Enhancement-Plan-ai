package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f39897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f39898b;

    public g0(gm.f0 f0Var) {
        this.f39897a = w.A(f0Var.K(0));
        this.f39898b = s.z(f0Var.K(1));
    }

    public g0(w wVar, s sVar) {
        this.f39897a = wVar;
        this.f39898b = sVar;
    }

    public static g0 z(Object obj) {
        if (obj instanceof g0) {
            return (g0) obj;
        }
        if (obj != null) {
            return new g0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f39897a);
        iVar.a(this.f39898b);
        return new j2(iVar);
    }

    public s x() {
        return this.f39898b;
    }

    public w y() {
        return this.f39897a;
    }
}
