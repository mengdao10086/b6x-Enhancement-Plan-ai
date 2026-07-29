package jp;

import java.io.ByteArrayOutputStream;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class t implements jp.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36750m = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.h f36752b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public lp.d f36758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long[] f36759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f36760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f36761k = new a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f36762l = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36753c = -1;

    public class a extends ByteArrayOutputStream {
        public a() {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public t(org.bouncycastle.crypto.f fVar) {
        this.f36751a = fVar;
        this.f36752b = new org.bouncycastle.crypto.h(new s(fVar));
        int iC = this.f36751a.c();
        this.f36760j = iC;
        this.f36755e = new byte[iC];
        this.f36757g = new byte[iC];
        this.f36758h = m(iC);
        this.f36759i = new long[iC >>> 3];
        this.f36756f = null;
    }

    public static lp.d m(int i10) {
        if (i10 == 16) {
            return new lp.i();
        }
        if (i10 == 32) {
            return new lp.j();
        }
        if (i10 == 64) {
            return new lp.h();
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    public static void o(long[] jArr, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = jArr[i11] ^ org.bouncycastle.util.o.v(bArr, i10);
            i10 += 8;
        }
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        n1 n1VarB;
        this.f36754d = z10;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            byte[] bArrD = aVar.d();
            byte[] bArr = this.f36757g;
            int length = bArr.length - bArrD.length;
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
            System.arraycopy(bArrD, 0, this.f36757g, length, bArrD.length);
            this.f36755e = aVar.a();
            int iC = aVar.c();
            if (iC < 64 || iC > (this.f36760j << 3) || (iC & 7) != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + iC);
            }
            this.f36753c = iC >>> 3;
            n1VarB = aVar.b();
            byte[] bArr2 = this.f36755e;
            if (bArr2 != null) {
                k(bArr2, 0, bArr2.length);
            }
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("Invalid parameter passed");
            }
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            byte[] bArr3 = this.f36757g;
            int length2 = bArr3.length - bArrA.length;
            org.bouncycastle.util.a.d0(bArr3, (byte) 0);
            System.arraycopy(bArrA, 0, this.f36757g, length2, bArrA.length);
            this.f36755e = null;
            this.f36753c = this.f36760j;
            n1VarB = (n1) v1Var.b();
        }
        this.f36756f = new byte[this.f36760j];
        this.f36752b.f(true, new v1(n1VarB, this.f36757g));
        this.f36751a.a(true, n1VarB);
    }

    @Override // jp.b
    public String b() {
        return this.f36751a.b() + "/KGCM";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        int iA;
        int size = this.f36762l.size();
        if (!this.f36754d && size < this.f36753c) {
            throw new InvalidCipherTextException("data too short");
        }
        byte[] bArr2 = new byte[this.f36760j];
        this.f36751a.d(bArr2, 0, bArr2, 0);
        long[] jArr = new long[this.f36760j >>> 3];
        org.bouncycastle.util.o.w(bArr2, 0, jArr);
        this.f36758h.b(jArr);
        org.bouncycastle.util.a.d0(bArr2, (byte) 0);
        org.bouncycastle.util.a.k0(jArr, 0L);
        int size2 = this.f36761k.size();
        if (size2 > 0) {
            n(this.f36761k.a(), 0, size2);
        }
        if (!this.f36754d) {
            int i11 = size - this.f36753c;
            if (bArr.length - i10 < i11) {
                throw new OutputLengthException("Output buffer too short");
            }
            l(this.f36762l.a(), 0, i11, size2);
            int iH = this.f36752b.h(this.f36762l.a(), 0, i11, bArr, i10);
            iA = iH + this.f36752b.a(bArr, i10 + iH);
        } else {
            if ((bArr.length - i10) - this.f36753c < size) {
                throw new OutputLengthException("Output buffer too short");
            }
            int iH2 = this.f36752b.h(this.f36762l.a(), 0, size, bArr, i10);
            iA = iH2 + this.f36752b.a(bArr, i10 + iH2);
            l(bArr, i10, size, size2);
        }
        byte[] bArr3 = this.f36756f;
        if (bArr3 == null) {
            throw new IllegalStateException("mac is not calculated");
        }
        if (this.f36754d) {
            System.arraycopy(bArr3, 0, bArr, i10 + iA, this.f36753c);
            reset();
            return iA + this.f36753c;
        }
        byte[] bArr4 = new byte[this.f36753c];
        byte[] bArrA = this.f36762l.a();
        int i12 = this.f36753c;
        System.arraycopy(bArrA, size - i12, bArr4, 0, i12);
        int i13 = this.f36753c;
        byte[] bArr5 = new byte[i13];
        System.arraycopy(this.f36756f, 0, bArr5, 0, i13);
        if (!org.bouncycastle.util.a.I(bArr4, bArr5)) {
            throw new InvalidCipherTextException("mac verification failed");
        }
        reset();
        return iA;
    }

    @Override // jp.b
    public byte[] d() {
        int i10 = this.f36753c;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f36756f, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, DataLengthException {
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("input buffer too short");
        }
        this.f36762l.write(bArr, i10, i11);
        return 0;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36751a;
    }

    @Override // jp.b
    public int g(int i10) {
        return 0;
    }

    @Override // jp.b
    public int h(int i10) {
        int size = i10 + this.f36762l.size();
        if (this.f36754d) {
            return size + this.f36753c;
        }
        int i11 = this.f36753c;
        if (size < i11) {
            return 0;
        }
        return size - i11;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        this.f36762l.write(b10);
        return 0;
    }

    @Override // jp.b
    public void j(byte b10) {
        this.f36761k.write(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        this.f36761k.write(bArr, i10, i11);
    }

    public final void l(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i11;
        while (i10 < i13) {
            o(this.f36759i, bArr, i10);
            this.f36758h.a(this.f36759i);
            i10 += this.f36760j;
        }
        long[] jArr = this.f36759i;
        jArr[0] = ((((long) i12) & 4294967295L) << 3) ^ jArr[0];
        int i14 = this.f36760j >>> 4;
        jArr[i14] = jArr[i14] ^ ((4294967295L & ((long) i11)) << 3);
        byte[] bArrJ = org.bouncycastle.util.o.J(jArr);
        this.f36756f = bArrJ;
        this.f36751a.d(bArrJ, 0, bArrJ, 0);
    }

    public final void n(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        while (i10 < i12) {
            o(this.f36759i, bArr, i10);
            this.f36758h.a(this.f36759i);
            i10 += this.f36760j;
        }
    }

    @Override // jp.b
    public void reset() {
        org.bouncycastle.util.a.k0(this.f36759i, 0L);
        this.f36751a.reset();
        this.f36762l.reset();
        this.f36761k.reset();
        byte[] bArr = this.f36755e;
        if (bArr != null) {
            k(bArr, 0, bArr.length);
        }
    }
}
