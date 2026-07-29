package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.x509.NameConstraintValidatorException;

/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.q0 f45513a = new zn.q0();

    public void a(zn.e0 e0Var) {
        this.f45513a.d(e0Var);
    }

    public void b(zn.b0 b0Var) throws PKIXNameConstraintValidatorException {
        try {
            this.f45513a.a(b0Var);
        } catch (NameConstraintValidatorException e10) {
            throw new PKIXNameConstraintValidatorException(e10.getMessage(), e10);
        }
    }

    public void c(gm.f0 f0Var) throws PKIXNameConstraintValidatorException {
        try {
            this.f45513a.i(xn.d.A(f0Var));
        } catch (NameConstraintValidatorException e10) {
            throw new PKIXNameConstraintValidatorException(e10.getMessage(), e10);
        }
    }

    public void d(zn.b0 b0Var) throws PKIXNameConstraintValidatorException {
        try {
            this.f45513a.e(b0Var);
        } catch (NameConstraintValidatorException e10) {
            throw new PKIXNameConstraintValidatorException(e10.getMessage(), e10);
        }
    }

    public void e(gm.f0 f0Var) throws PKIXNameConstraintValidatorException {
        try {
            this.f45513a.p(xn.d.A(f0Var));
        } catch (NameConstraintValidatorException e10) {
            throw new PKIXNameConstraintValidatorException(e10.getMessage(), e10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.f45513a.equals(((v) obj).f45513a);
        }
        return false;
    }

    public void f(int i10) {
        this.f45513a.c(i10);
    }

    public void g(zn.e0 e0Var) {
        this.f45513a.b(e0Var);
    }

    public void h(zn.e0[] e0VarArr) {
        this.f45513a.f(e0VarArr);
    }

    public int hashCode() {
        return this.f45513a.hashCode();
    }

    public String toString() {
        return this.f45513a.toString();
    }
}
