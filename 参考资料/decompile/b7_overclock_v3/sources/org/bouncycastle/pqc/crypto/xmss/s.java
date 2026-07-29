package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Objects;
import org.bouncycastle.pqc.crypto.xmss.x;
import org.bouncycastle.pqc.crypto.xmss.y;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f45944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d0 f45945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f45946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x f45947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y f45948e;

    public s(w wVar, SecureRandom secureRandom) {
        Objects.requireNonNull(wVar, "params == null");
        this.f45944a = wVar;
        this.f45945b = wVar.j();
        this.f45946c = secureRandom;
        this.f45947d = new x.b(wVar).k();
        this.f45948e = new y.b(wVar).e();
    }

    public byte[] a() {
        return this.f45947d.toByteArray();
    }

    public byte[] b() {
        return this.f45948e.toByteArray();
    }

    public void c() {
        u uVar = new u();
        uVar.a(new t(d(), this.f45946c));
        org.bouncycastle.crypto.c cVarB = uVar.b();
        this.f45947d = (x) cVarB.a();
        y yVar = (y) cVarB.b();
        this.f45948e = yVar;
        g(this.f45947d, yVar);
    }

    public w d() {
        return this.f45944a;
    }

    public byte[] e() {
        return this.f45947d.j();
    }

    public d0 f() {
        return this.f45945b;
    }

    public final void g(x xVar, y yVar) {
        this.f45945b.i().l(new byte[this.f45944a.g()], this.f45947d.j());
        this.f45947d = xVar;
        this.f45948e = yVar;
    }

    public void h(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "privateKey == null");
        Objects.requireNonNull(bArr2, "publicKey == null");
        x xVarK = new x.b(this.f45944a).o(bArr).k();
        y yVarE = new y.b(this.f45944a).f(bArr2).e();
        if (!org.bouncycastle.util.a.g(xVarK.k(), yVarE.g())) {
            throw new IllegalStateException("root of private key and public key do not match");
        }
        if (!org.bouncycastle.util.a.g(xVarK.j(), yVarE.f())) {
            throw new IllegalStateException("public seed of private key and public key do not match");
        }
        this.f45945b.i().l(new byte[this.f45944a.g()], xVarK.j());
        this.f45947d = xVarK;
        this.f45948e = yVarE;
    }

    public byte[] i(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        a0 a0Var = new a0();
        a0Var.a(true, this.f45947d);
        byte[] bArrB = a0Var.b(bArr);
        x xVar = (x) a0Var.c();
        this.f45947d = xVar;
        g(xVar, this.f45948e);
        return bArrB;
    }

    public boolean j(byte[] bArr, byte[] bArr2, byte[] bArr3) throws ParseException {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(bArr3, "publicKey == null");
        a0 a0Var = new a0();
        a0Var.a(false, new y.b(d()).f(bArr3).e());
        return a0Var.d(bArr, bArr2);
    }
}
