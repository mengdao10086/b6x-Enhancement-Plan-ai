package qp;

import np.n1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class d implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f47575g = 140737488355328L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f47576h = 262144;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f47577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f47578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f47579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public pp.d f47580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a0 f47581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f47582f;

    public d(a0 a0Var, int i10, pp.d dVar, byte[] bArr, byte[] bArr2) {
        if (i10 > g.b(a0Var)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (dVar.c() < i10) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this.f47582f = i10;
        this.f47580d = dVar;
        this.f47581e = a0Var;
        byte[] bArrC = org.bouncycastle.util.a.C(d(), bArr2, bArr);
        byte[] bArr3 = new byte[a0Var.d()];
        this.f47577a = bArr3;
        byte[] bArr4 = new byte[bArr3.length];
        this.f47578b = bArr4;
        org.bouncycastle.util.a.d0(bArr4, (byte) 1);
        e(bArrC);
        this.f47579c = 1L;
    }

    @Override // qp.f
    public void a(byte[] bArr) {
        e(org.bouncycastle.util.a.B(d(), bArr));
        this.f47579c = 1L;
    }

    @Override // qp.f
    public int b(byte[] bArr, byte[] bArr2, boolean z10) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this.f47579c > 140737488355328L) {
            return -1;
        }
        if (z10) {
            a(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            e(bArr2);
        }
        int length2 = bArr.length;
        byte[] bArr3 = new byte[length2];
        int length3 = bArr.length / this.f47578b.length;
        this.f47581e.a(new n1(this.f47577a));
        for (int i10 = 0; i10 < length3; i10++) {
            a0 a0Var = this.f47581e;
            byte[] bArr4 = this.f47578b;
            a0Var.update(bArr4, 0, bArr4.length);
            this.f47581e.c(this.f47578b, 0);
            byte[] bArr5 = this.f47578b;
            System.arraycopy(bArr5, 0, bArr3, bArr5.length * i10, bArr5.length);
        }
        byte[] bArr6 = this.f47578b;
        if (bArr6.length * length3 < length2) {
            this.f47581e.update(bArr6, 0, bArr6.length);
            this.f47581e.c(this.f47578b, 0);
            byte[] bArr7 = this.f47578b;
            System.arraycopy(bArr7, 0, bArr3, bArr7.length * length3, length2 - (length3 * bArr7.length));
        }
        e(bArr2);
        this.f47579c++;
        System.arraycopy(bArr3, 0, bArr, 0, bArr.length);
        return length;
    }

    @Override // qp.f
    public int c() {
        return this.f47578b.length * 8;
    }

    public final byte[] d() {
        byte[] bArrA = this.f47580d.a();
        if (bArrA.length >= (this.f47582f + 7) / 8) {
            return bArrA;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final void e(byte[] bArr) {
        f(bArr, (byte) 0);
        if (bArr != null) {
            f(bArr, (byte) 1);
        }
    }

    public final void f(byte[] bArr, byte b10) {
        this.f47581e.a(new n1(this.f47577a));
        a0 a0Var = this.f47581e;
        byte[] bArr2 = this.f47578b;
        a0Var.update(bArr2, 0, bArr2.length);
        this.f47581e.update(b10);
        if (bArr != null) {
            this.f47581e.update(bArr, 0, bArr.length);
        }
        this.f47581e.c(this.f47577a, 0);
        this.f47581e.a(new n1(this.f47577a));
        a0 a0Var2 = this.f47581e;
        byte[] bArr3 = this.f47578b;
        a0Var2.update(bArr3, 0, bArr3.length);
        this.f47581e.c(this.f47578b, 0);
    }
}
