package ao;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import gm.y;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w implements b, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f8783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f8784b;

    public e(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f8783a = y.N(enumerationL.nextElement());
        if (enumerationL.hasMoreElements()) {
            this.f8784b = (gm.h) enumerationL.nextElement();
        }
    }

    public e(y yVar) {
        this.f8783a = yVar;
        this.f8784b = null;
    }

    public e(y yVar, gm.h hVar) {
        this.f8783a = yVar;
        this.f8784b = hVar;
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
        iVar.a(this.f8783a);
        gm.h hVar = this.f8784b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public y y() {
        return this.f8783a;
    }

    public gm.h z() {
        return this.f8784b;
    }
}
