package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.e0;
import org.bouncycastle.pqc.crypto.xmss.f0;

/* JADX INFO: loaded from: classes6.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f45923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f45924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f45925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e0 f45926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f0 f45927e;

    public n(d0 d0Var, SecureRandom secureRandom) {
        Objects.requireNonNull(d0Var, "params == null");
        this.f45923a = d0Var;
        this.f45924b = d0Var.i();
        this.f45925c = secureRandom;
    }

    public e0 a() {
        return this.f45926d;
    }

    public f0 b() {
        return this.f45927e;
    }

    public void c() {
        q qVar = new q();
        qVar.a(new p(e(), this.f45925c));
        org.bouncycastle.crypto.c cVarB = qVar.b();
        this.f45926d = (e0) cVarB.a();
        this.f45927e = (f0) cVarB.b();
        this.f45924b.l(new byte[this.f45923a.h()], this.f45926d.j());
    }

    public int d() {
        return this.f45926d.g();
    }

    public d0 e() {
        return this.f45923a;
    }

    public e0 f() {
        return this.f45926d;
    }

    public byte[] g() {
        return this.f45926d.j();
    }

    public byte[] h() {
        return this.f45926d.k();
    }

    public h i() {
        return this.f45924b;
    }

    public void j(e0 e0Var, f0 f0Var) {
        if (!org.bouncycastle.util.a.g(e0Var.k(), f0Var.g())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!org.bouncycastle.util.a.g(e0Var.j(), f0Var.f())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.f45926d = e0Var;
        this.f45927e = f0Var;
        this.f45924b.l(new byte[this.f45923a.h()], this.f45926d.j());
    }

    public void k(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "privateKey == null");
        Objects.requireNonNull(bArr2, "publicKey == null");
        e0 e0VarJ = new e0.b(this.f45923a).n(bArr).j();
        f0 f0VarE = new f0.b(this.f45923a).f(bArr2).e();
        if (!org.bouncycastle.util.a.g(e0VarJ.k(), f0VarE.g())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!org.bouncycastle.util.a.g(e0VarJ.j(), f0VarE.f())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.f45926d = e0VarJ;
        this.f45927e = f0VarE;
        this.f45924b.l(new byte[this.f45923a.h()], this.f45926d.j());
    }

    public void l(int i10) {
        this.f45926d = new e0.b(this.f45923a).r(this.f45926d.m()).q(this.f45926d.l()).o(this.f45926d.j()).p(this.f45926d.k()).k(this.f45926d.f()).j();
    }

    public void m(byte[] bArr) {
        this.f45926d = new e0.b(this.f45923a).r(this.f45926d.m()).q(this.f45926d.l()).o(bArr).p(h()).k(this.f45926d.f()).j();
        this.f45927e = new f0.b(this.f45923a).h(h()).g(bArr).e();
        this.f45924b.l(new byte[this.f45923a.h()], bArr);
    }

    public void n(byte[] bArr) {
        this.f45926d = new e0.b(this.f45923a).r(this.f45926d.m()).q(this.f45926d.l()).o(g()).p(bArr).k(this.f45926d.f()).j();
        this.f45927e = new f0.b(this.f45923a).h(bArr).g(g()).e();
    }

    public byte[] o(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        i0 i0Var = new i0();
        i0Var.a(true, this.f45926d);
        byte[] bArrB = i0Var.b(bArr);
        e0 e0Var = (e0) i0Var.c();
        this.f45926d = e0Var;
        j(e0Var, this.f45927e);
        return bArrB;
    }

    public boolean p(byte[] bArr, byte[] bArr2, byte[] bArr3) throws ParseException {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(bArr3, "publicKey == null");
        i0 i0Var = new i0();
        i0Var.a(false, new f0.b(e()).f(bArr3).e());
        return i0Var.d(bArr, bArr2);
    }

    public m q(byte[] bArr, g gVar) {
        if (bArr.length != this.f45923a.h()) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        h hVar = this.f45924b;
        hVar.l(hVar.k(this.f45926d.m(), gVar), g());
        return this.f45924b.m(bArr, gVar);
    }
}
