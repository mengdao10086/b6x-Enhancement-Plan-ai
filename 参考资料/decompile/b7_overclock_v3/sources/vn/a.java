package vn;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f53247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f53248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53250d;

    public a(int i10, int i11) {
        this(i10, i11, 0, 0);
    }

    public a(int i10, int i11, int i12, int i13) {
        this.f53247a = i10;
        this.f53248b = i11;
        this.f53249c = i12;
        this.f53250d = i13;
    }

    public a(f0 f0Var) {
        this.f53247a = t.I(f0Var.K(0)).O();
        if (f0Var.K(1) instanceof t) {
            this.f53248b = ((t) f0Var.K(1)).O();
        } else {
            if (!(f0Var.K(1) instanceof f0)) {
                throw new IllegalArgumentException("object parse error");
            }
            f0 f0VarJ = f0.J(f0Var.K(1));
            this.f53248b = t.I(f0VarJ.K(0)).O();
            this.f53249c = t.I(f0VarJ.K(1)).O();
            this.f53250d = t.I(f0VarJ.K(2)).O();
        }
    }

    public static a x(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f53250d;
    }

    public int B() {
        return this.f53247a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(new t(this.f53247a));
        if (this.f53249c == 0) {
            iVar.a(new t(this.f53248b));
        } else {
            i iVar2 = new i(3);
            iVar2.a(new t(this.f53248b));
            iVar2.a(new t(this.f53249c));
            iVar2.a(new t(this.f53250d));
            iVar.a(new j2(iVar2));
        }
        return new j2(iVar);
    }

    public int y() {
        return this.f53248b;
    }

    public int z() {
        return this.f53249c;
    }
}
