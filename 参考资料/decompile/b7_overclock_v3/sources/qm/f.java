package qm;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f47495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f47496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f47497d;

    public f(int i10, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f47494a = i10;
        this.f47495b = new t(bigInteger);
        this.f47496c = new t(bigInteger2);
        this.f47497d = new t(bigInteger3);
    }

    public f(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f47494a = ((t) enumerationL.nextElement()).Q();
        this.f47495b = (t) enumerationL.nextElement();
        this.f47496c = (t) enumerationL.nextElement();
        this.f47497d = (t) enumerationL.nextElement();
    }

    public static f y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static f z(Object obj) {
        if (obj == null || (obj instanceof f)) {
            return (f) obj;
        }
        if (obj instanceof f0) {
            return new f((f0) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public int A() {
        return this.f47494a;
    }

    public int B() {
        return this.f47494a;
    }

    public BigInteger C() {
        return this.f47495b.J();
    }

    public BigInteger D() {
        return this.f47496c.J();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(new t(this.f47494a));
        iVar.a(this.f47495b);
        iVar.a(this.f47496c);
        iVar.a(this.f47497d);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f47497d.J();
    }
}
