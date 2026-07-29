package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f44260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f44261b;

    public a(f0 f0Var) {
        this.f44260a = (y) f0Var.K(0);
        this.f44261b = f0Var.K(1);
    }

    public a(y yVar, gm.h hVar) {
        this.f44260a = yVar;
        this.f44261b = hVar;
    }

    public a(String str, gm.h hVar) {
        this(new y(str), hVar);
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

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44260a);
        iVar.a(this.f44261b);
        return new j2(iVar);
    }

    public y y() {
        return this.f44260a;
    }

    public gm.h z() {
        return this.f44261b;
    }
}
