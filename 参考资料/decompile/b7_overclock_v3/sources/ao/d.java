package ao;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f8781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f8782c;

    public d(c cVar, int i10, int i11) {
        this.f8780a = cVar;
        this.f8781b = new t(i10);
        this.f8782c = new t(i11);
    }

    public d(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f8780a = c.y(enumerationL.nextElement());
        this.f8781b = t.I(enumerationL.nextElement());
        this.f8782c = t.I(enumerationL.nextElement());
    }

    public static d A(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(3);
        iVar.a(this.f8780a);
        iVar.a(this.f8781b);
        iVar.a(this.f8782c);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f8781b.K();
    }

    public c y() {
        return this.f8780a;
    }

    public BigInteger z() {
        return this.f8782c.K();
    }
}
