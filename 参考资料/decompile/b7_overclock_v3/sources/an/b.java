package an;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f806b;

    public b(int i10, z zVar) {
        this.f805a = new t(i10);
        this.f806b = zVar;
    }

    public b(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f805a = t.I(enumerationL.nextElement());
        this.f806b = z.I(enumerationL.nextElement());
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f805a);
        iVar.a(this.f806b);
        return new j2(iVar);
    }

    public z x() {
        return this.f806b;
    }

    public int y() {
        return this.f805a.Q();
    }
}
