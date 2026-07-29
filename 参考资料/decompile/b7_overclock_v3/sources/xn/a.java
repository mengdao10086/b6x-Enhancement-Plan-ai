package xn;

import gm.c0;
import gm.f0;
import gm.h;
import gm.i;
import gm.j2;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f55652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f55653b;

    public a(f0 f0Var) {
        this.f55652a = (y) f0Var.K(0);
        this.f55653b = f0Var.K(1);
    }

    public a(y yVar, h hVar) {
        this.f55652a = yVar;
        this.f55653b = hVar;
    }

    public static a x(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f55652a);
        iVar.a(this.f55653b);
        return new j2(iVar);
    }

    public y y() {
        return this.f55652a;
    }

    public h z() {
        return this.f55653b;
    }
}
