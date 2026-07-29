package pn;

import gm.f0;
import gm.j2;
import gm.u1;

/* JADX INFO: loaded from: classes5.dex */
public class e extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f46753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f46754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u1 f46755c;

    public e() {
        this.f46753a = null;
        this.f46754b = null;
        this.f46755c = null;
    }

    public e(f0 f0Var) {
        this.f46753a = null;
        this.f46754b = null;
        this.f46755c = null;
        this.f46753a = f.y(f0Var.K(0));
        this.f46754b = zn.b.z(f0Var.K(1));
        this.f46755c = (u1) f0Var.K(2);
    }

    public e(f fVar, zn.b bVar, u1 u1Var) {
        this.f46753a = fVar;
        this.f46754b = bVar;
        this.f46755c = u1Var;
    }

    public static e y(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f46754b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f46753a);
        iVar.a(this.f46754b);
        iVar.a(this.f46755c);
        return new j2(iVar);
    }

    public f x() {
        return this.f46753a;
    }

    public u1 z() {
        return this.f46755c;
    }
}
