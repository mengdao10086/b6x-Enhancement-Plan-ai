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
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f47480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f47481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f47482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f47483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f47484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t f47485f;

    public c(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f47482c = (t) enumerationL.nextElement();
        this.f47483d = (t) enumerationL.nextElement();
        this.f47480a = (t) enumerationL.nextElement();
        this.f47481b = (t) enumerationL.nextElement();
        this.f47484e = (t) enumerationL.nextElement();
        this.f47485f = (t) enumerationL.nextElement();
    }

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10, BigInteger bigInteger5) {
        this.f47482c = new t(bigInteger);
        this.f47483d = new t(bigInteger2);
        this.f47480a = new t(bigInteger3);
        this.f47481b = new t(bigInteger4);
        this.f47484e = new t(i10);
        this.f47485f = new t(bigInteger5);
    }

    public static c y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static c z(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof f0) {
            return new c((f0) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public BigInteger A() {
        return this.f47480a.J();
    }

    public BigInteger B() {
        return this.f47481b.J();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(this.f47482c);
        iVar.a(this.f47483d);
        iVar.a(this.f47480a);
        iVar.a(this.f47481b);
        iVar.a(this.f47484e);
        iVar.a(this.f47485f);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f47482c.J();
    }
}
