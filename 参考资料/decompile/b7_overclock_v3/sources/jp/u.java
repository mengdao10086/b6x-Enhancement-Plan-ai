package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class u extends org.bouncycastle.crypto.h {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f36764l = 135;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f36765m = 1061;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f36766n = 293;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f36767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f36768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long[] f36769i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long[] f36770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f36771k;

    public u(org.bouncycastle.crypto.f fVar) {
        this.f44684d = fVar;
        int iC = fVar.c();
        this.f36767g = iC;
        this.f36768h = k(iC);
        this.f36769i = new long[iC >>> 3];
        this.f36770j = new long[iC >>> 3];
        this.f36771k = -1;
    }

    public static void j(long j10, long[] jArr) {
        long j11 = 0;
        int i10 = 0;
        while (i10 < jArr.length) {
            long j12 = jArr[i10];
            jArr[i10] = j11 ^ (j12 << 1);
            i10++;
            j11 = j12 >>> 63;
        }
        jArr[0] = (j10 & (-j11)) ^ jArr[0];
    }

    public static long k(int i10) {
        if (i10 == 16) {
            return 135L;
        }
        if (i10 == 32) {
            return f36765m;
        }
        if (i10 == 64) {
            return 293L;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    @Override // org.bouncycastle.crypto.h
    public int a(byte[] bArr, int i10) {
        i();
        return 0;
    }

    @Override // org.bouncycastle.crypto.h
    public int c(int i10) {
        return i10;
    }

    @Override // org.bouncycastle.crypto.h
    public int e(int i10) {
        return i10;
    }

    @Override // org.bouncycastle.crypto.h
    public void f(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("Invalid parameters passed");
        }
        v1 v1Var = (v1) kVar;
        org.bouncycastle.crypto.k kVarB = v1Var.b();
        byte[] bArrA = v1Var.a();
        int length = bArrA.length;
        int i10 = this.f36767g;
        if (length != i10) {
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(bArrA, 0, bArr, 0, i10);
        this.f44684d.a(true, kVarB);
        this.f44684d.d(bArr, 0, bArr, 0);
        this.f44684d.a(z10, kVarB);
        org.bouncycastle.util.o.w(bArr, 0, this.f36769i);
        long[] jArr = this.f36769i;
        System.arraycopy(jArr, 0, this.f36770j, 0, jArr.length);
        this.f36771k = 0;
    }

    @Override // org.bouncycastle.crypto.h
    public int g(byte b10, byte[] bArr, int i10) {
        throw new IllegalStateException("unsupported operation");
    }

    @Override // org.bouncycastle.crypto.h
    public int h(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (bArr.length - i10 < i11) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr2.length - i10 < i11) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i11 % this.f36767g != 0) {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
        int i13 = 0;
        while (i13 < i11) {
            l(bArr, i10 + i13, bArr2, i12 + i13);
            i13 += this.f36767g;
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.h
    public void i() {
        this.f44684d.reset();
        long[] jArr = this.f36769i;
        System.arraycopy(jArr, 0, this.f36770j, 0, jArr.length);
        this.f36771k = 0;
    }

    public final void l(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = this.f36771k;
        if (i12 == -1) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.f36771k = i12 + 1;
        j(this.f36768h, this.f36770j);
        byte[] bArr3 = new byte[this.f36767g];
        org.bouncycastle.util.o.H(this.f36770j, bArr3, 0);
        int i13 = this.f36767g;
        byte[] bArr4 = new byte[i13];
        System.arraycopy(bArr3, 0, bArr4, 0, i13);
        for (int i14 = 0; i14 < this.f36767g; i14++) {
            bArr4[i14] = (byte) (bArr4[i14] ^ bArr[i10 + i14]);
        }
        this.f44684d.d(bArr4, 0, bArr4, 0);
        for (int i15 = 0; i15 < this.f36767g; i15++) {
            bArr2[i11 + i15] = (byte) (bArr4[i15] ^ bArr3[i15]);
        }
    }
}
