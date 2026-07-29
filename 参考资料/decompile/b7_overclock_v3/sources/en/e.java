package en;

import gm.c0;
import gm.d0;
import gm.f0;
import gm.i2;
import gm.j2;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f27047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f27048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f27049c;

    public e(f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        this.f27047a = d0.I(enumerationL.nextElement());
        this.f27048b = t.I(enumerationL.nextElement());
        this.f27049c = t.I(enumerationL.nextElement());
    }

    public e(String str, int i10, int i11) {
        this.f27047a = new i2(str, true);
        this.f27048b = new t(i10);
        this.f27049c = new t(i11);
    }

    public static e A(Object obj) {
        if (obj == null || (obj instanceof e)) {
            return (e) obj;
        }
        if (obj instanceof f0) {
            return new e(f0.J(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f27047a);
        iVar.a(this.f27048b);
        iVar.a(this.f27049c);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f27048b.K();
    }

    public String y() {
        return this.f27047a.d();
    }

    public BigInteger z() {
        return this.f27049c.K();
    }
}
