package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f39835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f39836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f39837c;

    public a(gm.f0 f0Var) {
        this.f39835a = b.x(f0Var.K(0));
        this.f39836b = b.x(f0Var.K(1));
        this.f39837c = b.x(f0Var.K(2));
    }

    public a(b bVar, b bVar2, b bVar3) {
        this.f39835a = bVar;
        this.f39836b = bVar2;
        this.f39837c = bVar3;
    }

    public static a x(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(gm.f0.J(obj));
        }
        return null;
    }

    public b A() {
        return this.f39835a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39835a);
        iVar.a(this.f39836b);
        iVar.a(this.f39837c);
        return new j2(iVar);
    }

    public b y() {
        return this.f39837c;
    }

    public b z() {
        return this.f39836b;
    }
}
