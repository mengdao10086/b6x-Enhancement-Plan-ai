package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.h0;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends j0 implements h0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f36556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36560f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36561g;

    public c0(org.bouncycastle.crypto.f fVar) {
        super(fVar);
        this.f36556b = fVar;
        int iC = fVar.c();
        this.f36557c = iC;
        this.f36558d = new byte[iC];
        this.f36559e = new byte[iC];
        this.f36560f = new byte[iC];
        this.f36561g = 0;
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
        }
        v1 v1Var = (v1) kVar;
        byte[] bArrP = org.bouncycastle.util.a.p(v1Var.a());
        this.f36558d = bArrP;
        int i10 = this.f36557c;
        if (i10 < bArrP.length) {
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.f36557c + " bytes.");
        }
        int i11 = 8 > i10 / 2 ? i10 / 2 : 8;
        if (i10 - bArrP.length <= i11) {
            if (v1Var.b() != null) {
                this.f36556b.a(true, v1Var.b());
            }
            reset();
        } else {
            throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.f36557c - i11) + " bytes.");
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return this.f36556b.b() + "/SIC";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36556b.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        if (this.f36561g != 0) {
            e(bArr, i10, this.f36557c, bArr2, i11);
        } else {
            int i12 = this.f36557c;
            if (i10 + i12 > bArr.length) {
                throw new DataLengthException("input buffer too small");
            }
            if (i12 + i11 > bArr2.length) {
                throw new OutputLengthException("output buffer too short");
            }
            this.f36556b.d(this.f36559e, 0, this.f36560f, 0);
            for (int i13 = 0; i13 < this.f36557c; i13++) {
                bArr2[i11 + i13] = (byte) (bArr[i10 + i13] ^ this.f36560f[i13]);
            }
            o();
        }
        return this.f36557c;
    }

    @Override // org.bouncycastle.crypto.j0, org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        byte b10;
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = this.f36561g;
            if (i14 == 0) {
                this.f36556b.d(this.f36559e, 0, this.f36560f, 0);
                byte b11 = bArr[i10 + i13];
                byte[] bArr3 = this.f36560f;
                int i15 = this.f36561g;
                this.f36561g = i15 + 1;
                b10 = (byte) (b11 ^ bArr3[i15]);
            } else {
                byte b12 = bArr[i10 + i13];
                byte[] bArr4 = this.f36560f;
                int i16 = i14 + 1;
                this.f36561g = i16;
                b10 = (byte) (bArr4[i14] ^ b12);
                if (i16 == this.f36559e.length) {
                    this.f36561g = 0;
                    o();
                }
            }
            bArr2[i12 + i13] = b10;
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.g0
    public long g(long j10) {
        reset();
        return skip(j10);
    }

    @Override // org.bouncycastle.crypto.g0
    public long getPosition() {
        byte[] bArr = this.f36559e;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i10 = length - 1;
        while (i10 >= 1) {
            byte[] bArr3 = this.f36558d;
            int i11 = i10 < bArr3.length ? (bArr2[i10] & 255) - (bArr3[i10] & 255) : bArr2[i10] & 255;
            if (i11 < 0) {
                int i12 = i10 - 1;
                bArr2[i12] = (byte) (bArr2[i12] - 1);
                i11 += 256;
            }
            bArr2[i10] = (byte) i11;
            i10--;
        }
        return (org.bouncycastle.util.o.d(bArr2, length - 8) * ((long) this.f36557c)) + ((long) this.f36561g);
    }

    @Override // org.bouncycastle.crypto.j0
    public byte h(byte b10) throws IllegalStateException, DataLengthException {
        int i10 = this.f36561g;
        if (i10 == 0) {
            this.f36556b.d(this.f36559e, 0, this.f36560f, 0);
            byte[] bArr = this.f36560f;
            int i11 = this.f36561g;
            this.f36561g = i11 + 1;
            return (byte) (b10 ^ bArr[i11]);
        }
        byte[] bArr2 = this.f36560f;
        int i12 = i10 + 1;
        this.f36561g = i12;
        byte b11 = (byte) (b10 ^ bArr2[i10]);
        if (i12 == this.f36559e.length) {
            this.f36561g = 0;
            o();
        }
        return b11;
    }

    public final void j(long j10) {
        int i10;
        int i11 = 5;
        if (j10 >= 0) {
            long j11 = (((long) this.f36561g) + j10) / ((long) this.f36557c);
            long j12 = j11;
            if (j11 > 255) {
                while (i11 >= 1) {
                    long j13 = 1 << (i11 * 8);
                    while (j12 >= j13) {
                        n(i11);
                        j12 -= j13;
                    }
                    i11--;
                }
            }
            m((int) j12);
            i10 = (int) ((j10 + ((long) this.f36561g)) - (((long) this.f36557c) * j11));
        } else {
            long j14 = ((-j10) - ((long) this.f36561g)) / ((long) this.f36557c);
            long j15 = j14;
            if (j14 > 255) {
                while (i11 >= 1) {
                    long j16 = 1 << (i11 * 8);
                    while (j15 > j16) {
                        l(i11);
                        j15 -= j16;
                    }
                    i11--;
                }
            }
            for (long j17 = 0; j17 != j15; j17++) {
                l(0);
            }
            int i12 = (int) (((long) this.f36561g) + j10 + (((long) this.f36557c) * j14));
            if (i12 >= 0) {
                this.f36561g = 0;
                return;
            } else {
                l(0);
                i10 = this.f36557c + i12;
            }
        }
        this.f36561g = i10;
    }

    public final void k() {
        if (this.f36558d.length >= this.f36557c) {
            return;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f36558d;
            if (i10 == bArr.length) {
                return;
            }
            if (this.f36559e[i10] != bArr[i10]) {
                throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
            }
            i10++;
        }
    }

    public final void l(int i10) {
        byte b10;
        int length = this.f36559e.length - i10;
        do {
            length--;
            if (length < 0) {
                return;
            }
            b10 = (byte) (r1[length] - 1);
            this.f36559e[length] = b10;
        } while (b10 == -1);
    }

    public final void m(int i10) {
        byte[] bArr = this.f36559e;
        byte b10 = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + i10);
        if (b10 == 0 || bArr[bArr.length - 1] >= b10) {
            return;
        }
        n(1);
    }

    public final void n(int i10) {
        byte b10;
        int length = this.f36559e.length - i10;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.f36559e;
            b10 = (byte) (bArr[length] + 1);
            bArr[length] = b10;
        } while (b10 == 0);
    }

    public final void o() {
        byte b10;
        int length = this.f36559e.length;
        do {
            length--;
            if (length < 0) {
                break;
            }
            byte[] bArr = this.f36559e;
            b10 = (byte) (bArr[length] + 1);
            bArr[length] = b10;
        } while (b10 == 0);
        byte[] bArr2 = this.f36558d;
        if (length < bArr2.length && bArr2.length < this.f36557c) {
            throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        org.bouncycastle.util.a.d0(this.f36559e, (byte) 0);
        byte[] bArr = this.f36558d;
        System.arraycopy(bArr, 0, this.f36559e, 0, bArr.length);
        this.f36556b.reset();
        this.f36561g = 0;
    }

    @Override // org.bouncycastle.crypto.g0
    public long skip(long j10) {
        j(j10);
        k();
        this.f36556b.d(this.f36559e, 0, this.f36560f, 0);
        return j10;
    }
}
