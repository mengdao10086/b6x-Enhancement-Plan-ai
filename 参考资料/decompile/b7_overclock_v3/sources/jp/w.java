package jp;

import java.util.Vector;
import np.n1;
import np.v1;
import okio.w0;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class w implements a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f36777w = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Vector f36783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f36785h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f36789l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f36790m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36791n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f36792o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f36793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f36794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public byte[] f36795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public byte[] f36796s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f36798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f36799v;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f36786i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f36787j = new byte[24];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f36788k = new byte[16];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte[] f36797t = new byte[16];

    public w(org.bouncycastle.crypto.f fVar, org.bouncycastle.crypto.f fVar2) {
        if (fVar == null) {
            throw new IllegalArgumentException("'hashCipher' cannot be null");
        }
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
        }
        if (fVar2 == null) {
            throw new IllegalArgumentException("'mainCipher' cannot be null");
        }
        if (fVar2.c() != 16) {
            throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        if (!fVar.b().equals(fVar2.b())) {
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
        }
        this.f36778a = fVar;
        this.f36779b = fVar2;
    }

    public static byte[] l(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) ((135 >>> ((1 - u(bArr, bArr2)) << 3)) ^ bArr2[15]);
        return bArr2;
    }

    public static void m(byte[] bArr, int i10) {
        bArr[i10] = -128;
        while (true) {
            i10++;
            if (i10 >= 16) {
                return;
            } else {
                bArr[i10] = 0;
            }
        }
    }

    public static int n(long j10) {
        if (j10 == 0) {
            return 64;
        }
        int i10 = 0;
        while ((1 & j10) == 0) {
            i10++;
            j10 >>>= 1;
        }
        return i10;
    }

    public static int u(byte[] bArr, byte[] bArr2) {
        int i10 = 16;
        int i11 = 0;
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11;
            }
            int i12 = bArr[i10] & 255;
            bArr2[i10] = (byte) (i11 | (i12 << 1));
            i11 = (i12 >>> 7) & 1;
        }
    }

    public static void w(byte[] bArr, byte[] bArr2) {
        for (int i10 = 15; i10 >= 0; i10--) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        n1 n1VarB;
        boolean z11 = this.f36780c;
        this.f36780c = z10;
        this.f36799v = null;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            bArrA = aVar.d();
            this.f36782e = aVar.a();
            int iC = aVar.c();
            if (iC < 64 || iC > 128 || iC % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + iC);
            }
            this.f36781d = iC / 8;
            n1VarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to OCB");
            }
            v1 v1Var = (v1) kVar;
            bArrA = v1Var.a();
            this.f36782e = null;
            this.f36781d = 16;
            n1VarB = (n1) v1Var.b();
        }
        this.f36789l = new byte[16];
        this.f36790m = new byte[z10 ? 16 : this.f36781d + 16];
        if (bArrA == null) {
            bArrA = new byte[0];
        }
        if (bArrA.length > 15) {
            throw new IllegalArgumentException("IV must be no more than 15 bytes");
        }
        if (n1VarB != null) {
            this.f36778a.a(true, n1VarB);
            this.f36779b.a(z10, n1VarB);
            this.f36786i = null;
        } else if (z11 != z10) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
        byte[] bArr = new byte[16];
        this.f36784g = bArr;
        this.f36778a.d(bArr, 0, bArr, 0);
        this.f36785h = l(this.f36784g);
        Vector vector = new Vector();
        this.f36783f = vector;
        vector.addElement(l(this.f36785h));
        int iS = s(bArrA);
        int i10 = iS % 8;
        int i11 = iS / 8;
        if (i10 == 0) {
            System.arraycopy(this.f36787j, i11, this.f36788k, 0, 16);
        } else {
            for (int i12 = 0; i12 < 16; i12++) {
                byte[] bArr2 = this.f36787j;
                int i13 = bArr2[i11] & 255;
                i11++;
                this.f36788k[i12] = (byte) (((bArr2[i11] & 255) >>> (8 - i10)) | (i13 << i10));
            }
        }
        this.f36791n = 0;
        this.f36792o = 0;
        this.f36793p = 0L;
        this.f36794q = 0L;
        this.f36795r = new byte[16];
        this.f36796s = new byte[16];
        System.arraycopy(this.f36788k, 0, this.f36797t, 0, 16);
        this.f36798u = new byte[16];
        byte[] bArr3 = this.f36782e;
        if (bArr3 != null) {
            k(bArr3, 0, bArr3.length);
        }
    }

    @Override // jp.b
    public String b() {
        return this.f36779b.b() + "/OCB";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        byte[] bArr2;
        if (this.f36780c) {
            bArr2 = null;
        } else {
            int i11 = this.f36792o;
            int i12 = this.f36781d;
            if (i11 < i12) {
                throw new InvalidCipherTextException("data too short");
            }
            int i13 = i11 - i12;
            this.f36792o = i13;
            bArr2 = new byte[i12];
            System.arraycopy(this.f36790m, i13, bArr2, 0, i12);
        }
        int i14 = this.f36791n;
        if (i14 > 0) {
            m(this.f36789l, i14);
            v(this.f36784g);
        }
        int i15 = this.f36792o;
        if (i15 > 0) {
            if (this.f36780c) {
                m(this.f36790m, i15);
                w(this.f36798u, this.f36790m);
            }
            w(this.f36797t, this.f36784g);
            byte[] bArr3 = new byte[16];
            this.f36778a.d(this.f36797t, 0, bArr3, 0);
            w(this.f36790m, bArr3);
            int length = bArr.length;
            int i16 = this.f36792o;
            if (length < i10 + i16) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.f36790m, 0, bArr, i10, i16);
            if (!this.f36780c) {
                m(this.f36790m, this.f36792o);
                w(this.f36798u, this.f36790m);
            }
        }
        w(this.f36798u, this.f36797t);
        w(this.f36798u, this.f36785h);
        org.bouncycastle.crypto.f fVar = this.f36778a;
        byte[] bArr4 = this.f36798u;
        fVar.d(bArr4, 0, bArr4, 0);
        w(this.f36798u, this.f36796s);
        int i17 = this.f36781d;
        byte[] bArr5 = new byte[i17];
        this.f36799v = bArr5;
        System.arraycopy(this.f36798u, 0, bArr5, 0, i17);
        int i18 = this.f36792o;
        if (this.f36780c) {
            int length2 = bArr.length;
            int i19 = i10 + i18;
            int i20 = this.f36781d;
            if (length2 < i19 + i20) {
                throw new OutputLengthException("Output buffer too short");
            }
            System.arraycopy(this.f36799v, 0, bArr, i19, i20);
            i18 += this.f36781d;
        } else if (!org.bouncycastle.util.a.I(this.f36799v, bArr2)) {
            throw new InvalidCipherTextException("mac check in OCB failed");
        }
        t(false);
        return i18;
    }

    @Override // jp.b
    public byte[] d() {
        byte[] bArr = this.f36799v;
        return bArr == null ? new byte[this.f36781d] : org.bouncycastle.util.a.p(bArr);
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("Input buffer too short");
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i11; i14++) {
            byte[] bArr3 = this.f36790m;
            int i15 = this.f36792o;
            bArr3[i15] = bArr[i10 + i14];
            int i16 = i15 + 1;
            this.f36792o = i16;
            if (i16 == bArr3.length) {
                r(bArr2, i12 + i13);
                i13 += 16;
            }
        }
        return i13;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36779b;
    }

    @Override // jp.b
    public int g(int i10) {
        int i11 = i10 + this.f36792o;
        if (!this.f36780c) {
            int i12 = this.f36781d;
            if (i11 < i12) {
                return 0;
            }
            i11 -= i12;
        }
        return i11 - (i11 % 16);
    }

    @Override // jp.b
    public int h(int i10) {
        int i11 = i10 + this.f36792o;
        if (this.f36780c) {
            return i11 + this.f36781d;
        }
        int i12 = this.f36781d;
        if (i11 < i12) {
            return 0;
        }
        return i11 - i12;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
        byte[] bArr2 = this.f36790m;
        int i11 = this.f36792o;
        bArr2[i11] = b10;
        int i12 = i11 + 1;
        this.f36792o = i12;
        if (i12 != bArr2.length) {
            return 0;
        }
        r(bArr, i10);
        return 16;
    }

    @Override // jp.b
    public void j(byte b10) {
        byte[] bArr = this.f36789l;
        int i10 = this.f36791n;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this.f36791n = i11;
        if (i11 == bArr.length) {
            q();
        }
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.f36789l;
            int i13 = this.f36791n;
            bArr2[i13] = bArr[i10 + i12];
            int i14 = i13 + 1;
            this.f36791n = i14;
            if (i14 == bArr2.length) {
                q();
            }
        }
    }

    public void o(byte[] bArr) {
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
    }

    public byte[] p(int i10) {
        while (i10 >= this.f36783f.size()) {
            Vector vector = this.f36783f;
            vector.addElement(l((byte[]) vector.lastElement()));
        }
        return (byte[]) this.f36783f.elementAt(i10);
    }

    public void q() {
        long j10 = this.f36793p + 1;
        this.f36793p = j10;
        v(p(n(j10)));
        this.f36791n = 0;
    }

    public void r(byte[] bArr, int i10) {
        if (bArr.length < i10 + 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.f36780c) {
            w(this.f36798u, this.f36790m);
            this.f36792o = 0;
        }
        byte[] bArr2 = this.f36797t;
        long j10 = this.f36794q + 1;
        this.f36794q = j10;
        w(bArr2, p(n(j10)));
        w(this.f36790m, this.f36797t);
        org.bouncycastle.crypto.f fVar = this.f36779b;
        byte[] bArr3 = this.f36790m;
        fVar.d(bArr3, 0, bArr3, 0);
        w(this.f36790m, this.f36797t);
        System.arraycopy(this.f36790m, 0, bArr, i10, 16);
        if (this.f36780c) {
            return;
        }
        w(this.f36798u, this.f36790m);
        byte[] bArr4 = this.f36790m;
        System.arraycopy(bArr4, 16, bArr4, 0, this.f36781d);
        this.f36792o = this.f36781d;
    }

    @Override // jp.b
    public void reset() {
        t(true);
    }

    public int s(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i10 = 0;
        System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
        bArr2[0] = (byte) (this.f36781d << 4);
        int length = 15 - bArr.length;
        bArr2[length] = (byte) (bArr2[length] | 1);
        int i11 = bArr2[15] & w0.f44229a;
        bArr2[15] = (byte) (bArr2[15] & i1.a.f31667o7);
        byte[] bArr3 = this.f36786i;
        if (bArr3 == null || !org.bouncycastle.util.a.g(bArr2, bArr3)) {
            byte[] bArr4 = new byte[16];
            this.f36786i = bArr2;
            this.f36778a.d(bArr2, 0, bArr4, 0);
            System.arraycopy(bArr4, 0, this.f36787j, 0, 16);
            while (i10 < 8) {
                byte[] bArr5 = this.f36787j;
                int i12 = i10 + 16;
                byte b10 = bArr4[i10];
                i10++;
                bArr5[i12] = (byte) (b10 ^ bArr4[i10]);
            }
        }
        return i11;
    }

    public void t(boolean z10) {
        this.f36778a.reset();
        this.f36779b.reset();
        o(this.f36789l);
        o(this.f36790m);
        this.f36791n = 0;
        this.f36792o = 0;
        this.f36793p = 0L;
        this.f36794q = 0L;
        o(this.f36795r);
        o(this.f36796s);
        System.arraycopy(this.f36788k, 0, this.f36797t, 0, 16);
        o(this.f36798u);
        if (z10) {
            this.f36799v = null;
        }
        byte[] bArr = this.f36782e;
        if (bArr != null) {
            k(bArr, 0, bArr.length);
        }
    }

    public void v(byte[] bArr) {
        w(this.f36795r, bArr);
        w(this.f36789l, this.f36795r);
        org.bouncycastle.crypto.f fVar = this.f36778a;
        byte[] bArr2 = this.f36789l;
        fVar.d(bArr2, 0, bArr2, 0);
        w(this.f36796s, this.f36789l);
    }
}
