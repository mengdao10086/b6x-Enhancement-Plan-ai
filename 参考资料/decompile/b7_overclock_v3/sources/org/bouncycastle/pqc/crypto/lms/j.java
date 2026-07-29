package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMOtsParameters f45752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f45753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f45754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f45755d;

    public j(LMOtsParameters lMOtsParameters, byte[] bArr, int i10, byte[] bArr2) {
        this.f45752a = lMOtsParameters;
        this.f45753b = bArr;
        this.f45754c = i10;
        this.f45755d = bArr2;
    }

    public b0 a() {
        b0 b0Var = new b0(this.f45753b, this.f45755d, b.a(this.f45752a.b()));
        b0Var.i(this.f45754c);
        return b0Var;
    }

    public byte[] b() {
        return this.f45753b;
    }

    public byte[] c() {
        return this.f45755d;
    }

    public LMOtsParameters d() {
        return this.f45752a;
    }

    public int e() {
        return this.f45754c;
    }

    public n f(LMSigParameters lMSigParameters, byte[][] bArr) {
        byte[] bArr2 = new byte[32];
        b0 b0VarA = a();
        b0VarA.h(-3);
        b0VarA.a(bArr2, false);
        org.bouncycastle.crypto.s sVarA = b.a(this.f45752a.b());
        a0.b(b(), sVarA);
        a0.e(e(), sVarA);
        a0.d(z.f45809h, sVarA);
        a0.b(bArr2, sVarA);
        return new n(this, lMSigParameters, sVarA, bArr2, bArr);
    }
}
