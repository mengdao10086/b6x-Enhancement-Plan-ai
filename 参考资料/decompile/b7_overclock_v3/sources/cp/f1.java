package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class f1 implements org.bouncycastle.crypto.h0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25285j = 20;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25286k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f25287l = org.bouncycastle.util.o.u(Strings.i("expand 16-byte kexpand 32-byte k"), 0, 8);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f25288m = Strings.i("expand 32-byte k");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f25289n = Strings.i("expand 16-byte k");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f25292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f25293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f25298i;

    public f1() {
        this(20);
    }

    public f1(int i10) {
        this.f25291b = 0;
        this.f25292c = new int[16];
        this.f25293d = new int[16];
        this.f25294e = new byte[64];
        this.f25295f = false;
        if (i10 <= 0 || (i10 & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.f25290a = i10;
    }

    public static void r(int i10, int[] iArr, int[] iArr2) {
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i10 % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        int i18 = 7;
        int i19 = iArr[7];
        int i20 = iArr[8];
        int i21 = 9;
        int i22 = iArr[9];
        int i23 = iArr[10];
        int i24 = iArr[11];
        int i25 = iArr[12];
        int i26 = 13;
        int i27 = iArr[13];
        int i28 = iArr[14];
        int iE = iArr[15];
        int iE2 = i28;
        int iE3 = i27;
        int iE4 = i25;
        int iE5 = i24;
        int iE6 = i23;
        int iE7 = i22;
        int i29 = i20;
        int iE8 = i19;
        int iE9 = i17;
        int iE10 = i16;
        int i30 = i15;
        int i31 = i14;
        int iE11 = i13;
        int iE12 = i12;
        int i32 = i11;
        int i33 = i10;
        while (i33 > 0) {
            int iE13 = org.bouncycastle.util.j.e(i32 + iE4, i18) ^ i30;
            int iE14 = i29 ^ org.bouncycastle.util.j.e(iE13 + i32, i21);
            int iE15 = iE4 ^ org.bouncycastle.util.j.e(iE14 + iE13, i26);
            int iE16 = org.bouncycastle.util.j.e(iE15 + iE14, 18) ^ i32;
            int iE17 = iE7 ^ org.bouncycastle.util.j.e(iE10 + iE12, i18);
            int iE18 = iE3 ^ org.bouncycastle.util.j.e(iE17 + iE10, i21);
            int iE19 = iE12 ^ org.bouncycastle.util.j.e(iE18 + iE17, i26);
            int iE20 = org.bouncycastle.util.j.e(iE19 + iE18, 18) ^ iE10;
            int iE21 = iE2 ^ org.bouncycastle.util.j.e(iE6 + iE9, 7);
            int iE22 = iE11 ^ org.bouncycastle.util.j.e(iE21 + iE6, 9);
            int iE23 = iE9 ^ org.bouncycastle.util.j.e(iE22 + iE21, 13);
            int iE24 = iE6 ^ org.bouncycastle.util.j.e(iE23 + iE22, 18);
            int iE25 = i31 ^ org.bouncycastle.util.j.e(iE + iE5, 7);
            int iE26 = iE8 ^ org.bouncycastle.util.j.e(iE25 + iE, 9);
            int i34 = i33;
            int iE27 = iE5 ^ org.bouncycastle.util.j.e(iE26 + iE25, 13);
            int iE28 = iE ^ org.bouncycastle.util.j.e(iE27 + iE26, 18);
            iE12 = iE19 ^ org.bouncycastle.util.j.e(iE16 + iE25, 7);
            iE11 = iE22 ^ org.bouncycastle.util.j.e(iE12 + iE16, 9);
            int iE29 = iE25 ^ org.bouncycastle.util.j.e(iE11 + iE12, 13);
            int iE30 = iE16 ^ org.bouncycastle.util.j.e(iE29 + iE11, 18);
            iE9 = iE23 ^ org.bouncycastle.util.j.e(iE20 + iE13, 7);
            iE8 = iE26 ^ org.bouncycastle.util.j.e(iE9 + iE20, 9);
            int iE31 = org.bouncycastle.util.j.e(iE8 + iE9, 13) ^ iE13;
            iE10 = iE20 ^ org.bouncycastle.util.j.e(iE31 + iE8, 18);
            iE5 = iE27 ^ org.bouncycastle.util.j.e(iE24 + iE17, 7);
            int iE32 = org.bouncycastle.util.j.e(iE5 + iE24, 9) ^ iE14;
            iE7 = iE17 ^ org.bouncycastle.util.j.e(iE32 + iE5, 13);
            iE6 = iE24 ^ org.bouncycastle.util.j.e(iE7 + iE32, 18);
            iE4 = iE15 ^ org.bouncycastle.util.j.e(iE28 + iE21, 7);
            iE3 = iE18 ^ org.bouncycastle.util.j.e(iE4 + iE28, 9);
            iE2 = iE21 ^ org.bouncycastle.util.j.e(iE3 + iE4, 13);
            iE = iE28 ^ org.bouncycastle.util.j.e(iE2 + iE3, 18);
            i31 = iE29;
            i29 = iE32;
            i32 = iE30;
            i30 = iE31;
            i26 = 13;
            i21 = 9;
            i18 = 7;
            i33 = i34 - 2;
        }
        iArr2[0] = i32 + iArr[0];
        iArr2[1] = iE12 + iArr[1];
        iArr2[2] = iE11 + iArr[2];
        iArr2[3] = i31 + iArr[3];
        iArr2[4] = i30 + iArr[4];
        iArr2[5] = iE10 + iArr[5];
        iArr2[6] = iE9 + iArr[6];
        iArr2[7] = iE8 + iArr[7];
        iArr2[8] = i29 + iArr[8];
        iArr2[9] = iE7 + iArr[9];
        iArr2[10] = iE6 + iArr[10];
        iArr2[11] = iE5 + iArr[11];
        iArr2[12] = iE4 + iArr[12];
        iArr2[13] = iE3 + iArr[13];
        iArr2[14] = iE2 + iArr[14];
        iArr2[15] = iE + iArr[15];
    }

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.v1)) {
            throw new IllegalArgumentException(b() + " Init parameters must include an IV");
        }
        np.v1 v1Var = (np.v1) kVar;
        byte[] bArrA = v1Var.a();
        if (bArrA == null || bArrA.length != j()) {
            throw new IllegalArgumentException(b() + " requires exactly " + j() + " bytes of IV");
        }
        org.bouncycastle.crypto.k kVarB = v1Var.b();
        if (kVarB == null) {
            if (!this.f25295f) {
                throw new IllegalStateException(b() + " KeyParameter can not be null for first initialisation");
            }
            s(null, bArrA);
        } else {
            if (!(kVarB instanceof np.n1)) {
                throw new IllegalArgumentException(b() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            s(((np.n1) kVarB).a(), bArrA);
        }
        reset();
        this.f25295f = true;
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        if (this.f25290a == 20) {
            return "Salsa20";
        }
        return "Salsa20" + fh.a.f28350w + this.f25290a;
    }

    public void c() {
        int[] iArr = this.f25292c;
        int i10 = iArr[8] + 1;
        iArr[8] = i10;
        if (i10 == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    public void d(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 > 0) {
            int[] iArr = this.f25292c;
            iArr[9] = iArr[9] + i10;
        }
        int[] iArr2 = this.f25292c;
        int i12 = iArr2[8];
        iArr2[8] = iArr2[8] + i11;
        if (i12 == 0 || iArr2[8] >= i12) {
            return;
        }
        iArr2[9] = iArr2[9] + 1;
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (!this.f25295f) {
            throw new IllegalStateException(b() + " not initialised");
        }
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (l(i11)) {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr3 = this.f25294e;
            int i14 = this.f25291b;
            bArr2[i13 + i12] = (byte) (bArr3[i14] ^ bArr[i13 + i10]);
            int i15 = (i14 + 1) & 63;
            this.f25291b = i15;
            if (i15 == 0) {
                c();
                h(this.f25294e);
            }
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        if (k()) {
            throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
        }
        byte[] bArr = this.f25294e;
        int i10 = this.f25291b;
        byte b11 = (byte) (b10 ^ bArr[i10]);
        int i11 = (i10 + 1) & 63;
        this.f25291b = i11;
        if (i11 == 0) {
            c();
            h(this.f25294e);
        }
        return b11;
    }

    @Override // org.bouncycastle.crypto.g0
    public long g(long j10) {
        reset();
        return skip(j10);
    }

    @Override // org.bouncycastle.crypto.g0
    public long getPosition() {
        return (i() * 64) + ((long) this.f25291b);
    }

    public void h(byte[] bArr) {
        r(this.f25290a, this.f25292c, this.f25293d);
        org.bouncycastle.util.o.o(this.f25293d, bArr, 0);
    }

    public long i() {
        int[] iArr = this.f25292c;
        return (((long) iArr[9]) << 32) | (((long) iArr[8]) & 4294967295L);
    }

    public int j() {
        return 8;
    }

    public final boolean k() {
        int i10 = this.f25296g + 1;
        this.f25296g = i10;
        if (i10 == 0) {
            int i11 = this.f25297h + 1;
            this.f25297h = i11;
            if (i11 == 0) {
                int i12 = this.f25298i + 1;
                this.f25298i = i12;
                return (i12 & 32) != 0;
            }
        }
        return false;
    }

    public final boolean l(int i10) {
        int i11 = this.f25296g + i10;
        this.f25296g = i11;
        if (i11 >= i10 || i11 < 0) {
            return false;
        }
        int i12 = this.f25297h + 1;
        this.f25297h = i12;
        if (i12 != 0) {
            return false;
        }
        int i13 = this.f25298i + 1;
        this.f25298i = i13;
        return (i13 & 32) != 0;
    }

    public void m(int i10, int[] iArr, int i11) {
        int i12 = (i10 - 16) / 4;
        int[] iArr2 = f25287l;
        iArr[i11] = iArr2[i12];
        iArr[i11 + 1] = iArr2[i12 + 1];
        iArr[i11 + 2] = iArr2[i12 + 2];
        iArr[i11 + 3] = iArr2[i12 + 3];
    }

    public void n() {
        int[] iArr = this.f25292c;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    public final void o() {
        this.f25296g = 0;
        this.f25297h = 0;
        this.f25298i = 0;
    }

    public void p() {
        int[] iArr = this.f25292c;
        if (iArr[8] == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i10 = iArr[8] - 1;
        iArr[8] = i10;
        if (i10 == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }

    public void q(long j10) {
        int i10 = (int) (j10 >>> 32);
        int i11 = (int) j10;
        if (i10 != 0) {
            int[] iArr = this.f25292c;
            if ((((long) iArr[9]) & 4294967295L) < (((long) i10) & 4294967295L)) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr[9] = iArr[9] - i10;
        }
        int[] iArr2 = this.f25292c;
        if ((((long) iArr2[8]) & 4294967295L) >= (4294967295L & ((long) i11))) {
            iArr2[8] = iArr2[8] - i11;
        } else {
            if (iArr2[9] == 0) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr2[9] = iArr2[9] - 1;
            iArr2[8] = iArr2[8] - i11;
        }
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        this.f25291b = 0;
        o();
        n();
        h(this.f25294e);
    }

    public void s(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(b() + " requires 128 bit or 256 bit key");
            }
            int length = (bArr.length - 16) / 4;
            int[] iArr = this.f25292c;
            int[] iArr2 = f25287l;
            iArr[0] = iArr2[length];
            iArr[5] = iArr2[length + 1];
            iArr[10] = iArr2[length + 2];
            iArr[15] = iArr2[length + 3];
            org.bouncycastle.util.o.t(bArr, 0, iArr, 1, 4);
            org.bouncycastle.util.o.t(bArr, bArr.length - 16, this.f25292c, 11, 4);
        }
        org.bouncycastle.util.o.t(bArr2, 0, this.f25292c, 6, 2);
    }

    @Override // org.bouncycastle.crypto.g0
    public long skip(long j10) {
        long j11;
        if (j10 >= 0) {
            if (j10 >= 64) {
                long j12 = j10 / 64;
                d(j12);
                j11 = j10 - (j12 * 64);
            } else {
                j11 = j10;
            }
            int i10 = this.f25291b;
            int i11 = (((int) j11) + i10) & 63;
            this.f25291b = i11;
            if (i11 < i10) {
                c();
            }
        } else {
            long j13 = -j10;
            if (j13 >= 64) {
                long j14 = j13 / 64;
                q(j14);
                j13 -= j14 * 64;
            }
            for (long j15 = 0; j15 < j13; j15++) {
                if (this.f25291b == 0) {
                    p();
                }
                this.f25291b = (this.f25291b - 1) & 63;
            }
        }
        h(this.f25294e);
        return j10;
    }
}
