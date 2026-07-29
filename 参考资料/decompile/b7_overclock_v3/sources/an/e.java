package an;

import gm.c0;
import gm.d0;
import gm.f0;
import gm.i;
import gm.i2;
import gm.j2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f813b;

    public e(f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("sequence wrong size for LDSVersionInfo");
        }
        this.f812a = d0.I(f0Var.K(0));
        this.f813b = d0.I(f0Var.K(1));
    }

    public e(String str, String str2) {
        this.f812a = new i2(str);
        this.f813b = new i2(str2);
    }

    public static e x(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f812a);
        iVar.a(this.f813b);
        return new j2(iVar);
    }

    public String y() {
        return this.f812a.d();
    }

    public String z() {
        return this.f813b.d();
    }
}
