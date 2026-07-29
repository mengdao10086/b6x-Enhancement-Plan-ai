package jp;

import java.io.ByteArrayOutputStream;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class o implements jp.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36688n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36689o = 8;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f36690p = 12;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f36691q = 2147483623;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte f36692r = -128;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final byte f36693s = -31;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f36694t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f36695u = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f36696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kp.d f36697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f36698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f36699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f36700e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f36701f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f36702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f36703h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36704i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f36705j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f36706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f36707l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f36708m;

    public static class b extends ByteArrayOutputStream {
        public void a() {
            org.bouncycastle.util.a.d0(c(), (byte) 0);
        }

        public byte[] c() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f36709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f36710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f36711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f36712d;

        public c() {
            this.f36709a = new byte[16];
            this.f36710b = new byte[1];
        }

        public void a() {
            if (this.f36711c > 0) {
                org.bouncycastle.util.a.d0(o.this.f36699d, (byte) 0);
                o.x(this.f36709a, 0, this.f36711c, o.this.f36699d);
                o oVar = o.this;
                oVar.y(oVar.f36699d);
            }
        }

        public long b() {
            return this.f36712d;
        }

        public void c() {
            this.f36711c = 0;
            this.f36712d = 0L;
        }

        public void d(byte b10) {
            byte[] bArr = this.f36710b;
            bArr[0] = b10;
            e(bArr, 0, 1);
        }

        public void e(byte[] bArr, int i10, int i11) {
            int i12;
            int i13 = this.f36711c;
            int i14 = 16 - i13;
            int i15 = 0;
            if (i13 <= 0 || i11 < i14) {
                i12 = i11;
            } else {
                System.arraycopy(bArr, i10, this.f36709a, i13, i14);
                o.x(this.f36709a, 0, 16, o.this.f36699d);
                o oVar = o.this;
                oVar.y(oVar.f36699d);
                i12 = i11 - i14;
                this.f36711c = 0;
                i15 = i14 + 0;
            }
            while (i12 >= 16) {
                o.x(bArr, i10 + i15, 16, o.this.f36699d);
                o oVar2 = o.this;
                oVar2.y(oVar2.f36699d);
                i15 += i14;
                i12 -= i14;
            }
            if (i12 > 0) {
                System.arraycopy(bArr, i10 + i15, this.f36709a, this.f36711c, i12);
                this.f36711c += i12;
            }
            this.f36712d += (long) i11;
        }
    }

    public o() {
        this(new cp.a());
    }

    public o(org.bouncycastle.crypto.f fVar) {
        this(fVar, new kp.g());
    }

    public o(org.bouncycastle.crypto.f fVar, kp.d dVar) {
        this.f36698c = new byte[16];
        this.f36699d = new byte[16];
        this.f36708m = new byte[16];
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("Cipher required with a block size of 16.");
        }
        this.f36696a = fVar;
        this.f36697b = dVar;
        this.f36700e = new c();
        this.f36701f = new c();
    }

    public static void A(byte[] bArr) {
        for (int i10 = 0; i10 < 4; i10++) {
            byte b10 = (byte) (bArr[i10] + 1);
            bArr[i10] = b10;
            if (b10 != 0) {
                return;
            }
        }
    }

    public static void B(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            byte b10 = bArr[i11];
            bArr[i11] = (byte) (i10 | ((b10 >> 1) & 127));
            i10 = (b10 & 1) == 0 ? 0 : -128;
        }
        if (i10 != 0) {
            bArr[0] = (byte) (bArr[0] ^ (-31));
        }
    }

    public static void D(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < 16; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    public static void E(byte[] bArr, byte[] bArr2, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i12 + i10]);
        }
    }

    public static int o(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public static void r(byte[] bArr, int i10, int i11, boolean z10) {
        int iO = o(bArr);
        int i12 = i10 + i11;
        if ((i11 < 0 || i10 < 0 || i12 < 0) || i12 > iO) {
            if (!z10) {
                throw new DataLengthException("Input buffer too short.");
            }
        }
    }

    public static void x(byte[] bArr, int i10, int i11, byte[] bArr2) {
        int i12 = 0;
        int i13 = 15;
        while (i12 < i11) {
            bArr2[i13] = bArr[i10 + i12];
            i12++;
            i13--;
        }
    }

    public final void C() {
        b bVar = this.f36702g;
        if (bVar != null) {
            bVar.a();
        }
        this.f36700e.c();
        this.f36701f.c();
        this.f36702g = new b();
        this.f36703h = this.f36704i ? null : new b();
        this.f36707l &= -3;
        org.bouncycastle.util.a.d0(this.f36698c, (byte) 0);
        byte[] bArr = this.f36705j;
        if (bArr != null) {
            this.f36700e.e(bArr, 0, bArr.length);
        }
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        n1 n1VarB;
        byte[] bArrA2;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            bArrA2 = aVar.a();
            bArrA = aVar.d();
            n1VarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM-SIV");
            }
            v1 v1Var = (v1) kVar;
            bArrA = v1Var.a();
            n1VarB = (n1) v1Var.b();
            bArrA2 = null;
        }
        if (bArrA == null || bArrA.length != 12) {
            throw new IllegalArgumentException("Invalid nonce");
        }
        if (n1VarB == null || !(n1VarB.a().length == 16 || n1VarB.a().length == 32)) {
            throw new IllegalArgumentException("Invalid key");
        }
        this.f36704i = z10;
        this.f36705j = bArrA2;
        this.f36706k = bArrA;
        v(n1VarB);
        C();
    }

    @Override // jp.b
    public String b() {
        return this.f36696a.b() + "-GCM-SIV";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        s(0);
        r(bArr, i10, h(0), true);
        if (!this.f36704i) {
            u();
            int size = this.f36702g.size();
            System.arraycopy(this.f36702g.c(), 0, bArr, i10, size);
            C();
            return size;
        }
        byte[] bArrP = p();
        int iW = w(bArrP, bArr, i10) + 16;
        System.arraycopy(bArrP, 0, bArr, i10 + this.f36702g.size(), 16);
        byte[] bArr2 = this.f36708m;
        System.arraycopy(bArrP, 0, bArr2, 0, bArr2.length);
        C();
        return iW;
    }

    @Override // jp.b
    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f36708m);
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        s(i11);
        r(bArr, i10, i11, false);
        if (this.f36704i) {
            this.f36702g.write(bArr, i10, i11);
            this.f36701f.e(bArr, i10, i11);
        } else {
            this.f36703h.write(bArr, i10, i11);
        }
        return 0;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36696a;
    }

    @Override // jp.b
    public int g(int i10) {
        return 0;
    }

    @Override // jp.b
    public int h(int i10) {
        if (this.f36704i) {
            return i10 + this.f36702g.size() + 16;
        }
        int size = i10 + this.f36703h.size();
        if (size > 16) {
            return size - 16;
        }
        return 0;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
        s(1);
        if (!this.f36704i) {
            this.f36703h.write(b10);
            return 0;
        }
        this.f36702g.write(b10);
        this.f36701f.d(b10);
        return 0;
    }

    @Override // jp.b
    public void j(byte b10) {
        q(1);
        this.f36700e.d(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        q(i11);
        r(bArr, i10, i11, false);
        this.f36700e.e(bArr, i10, i11);
    }

    public final byte[] p() {
        this.f36701f.a();
        byte[] bArrT = t();
        byte[] bArr = new byte[16];
        for (int i10 = 0; i10 < 12; i10++) {
            bArrT[i10] = (byte) (bArrT[i10] ^ this.f36706k[i10]);
        }
        bArrT[15] = (byte) (bArrT[15] & (-129));
        this.f36696a.d(bArrT, 0, bArr, 0);
        return bArr;
    }

    public final void q(int i10) {
        int i11 = this.f36707l;
        if ((i11 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i11 & 2) != 0) {
            throw new IllegalStateException("AEAD data cannot be processed after ordinary data");
        }
        if (this.f36700e.b() - Long.MIN_VALUE > ((long) (f36691q - i10)) - Long.MIN_VALUE) {
            throw new IllegalStateException("AEAD byte count exceeded");
        }
    }

    @Override // jp.b
    public void reset() {
        C();
    }

    public final void s(int i10) {
        int i11 = this.f36707l;
        if ((i11 & 1) == 0) {
            throw new IllegalStateException("Cipher is not initialised");
        }
        if ((i11 & 2) == 0) {
            this.f36700e.a();
            this.f36707l |= 2;
        }
        long j10 = 2147483623;
        long size = this.f36702g.size();
        if (!this.f36704i) {
            j10 = 2147483639;
            size = this.f36703h.size();
        }
        if (size - Long.MIN_VALUE > (j10 - ((long) i10)) - Long.MIN_VALUE) {
            throw new IllegalStateException("byte count exceeded");
        }
    }

    public final byte[] t() {
        byte[] bArr = new byte[16];
        z();
        x(this.f36698c, 0, 16, bArr);
        return bArr;
    }

    public final void u() throws InvalidCipherTextException {
        byte[] bArrC = this.f36703h.c();
        int size = this.f36703h.size() - 16;
        if (size < 0) {
            throw new InvalidCipherTextException("Data too short");
        }
        byte[] bArrW = org.bouncycastle.util.a.W(bArrC, size, size + 16);
        byte[] bArrP = org.bouncycastle.util.a.p(bArrW);
        bArrP[15] = (byte) (bArrP[15] | (-128));
        byte[] bArr = new byte[16];
        int i10 = 0;
        while (size > 0) {
            this.f36696a.d(bArrP, 0, bArr, 0);
            int iMin = Math.min(16, size);
            E(bArr, bArrC, i10, iMin);
            this.f36702g.write(bArr, 0, iMin);
            this.f36701f.e(bArr, 0, iMin);
            size -= iMin;
            i10 += iMin;
            A(bArrP);
        }
        byte[] bArrP2 = p();
        if (!org.bouncycastle.util.a.I(bArrP2, bArrW)) {
            reset();
            throw new InvalidCipherTextException("mac check failed");
        }
        byte[] bArr2 = this.f36708m;
        System.arraycopy(bArrP2, 0, bArr2, 0, bArr2.length);
    }

    public final void v(n1 n1Var) {
        byte[] bArr = new byte[16];
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        int length = n1Var.a().length;
        byte[] bArr4 = new byte[length];
        System.arraycopy(this.f36706k, 0, bArr, 4, 12);
        this.f36696a.a(true, n1Var);
        this.f36696a.d(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.f36696a.d(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr3, 8, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.f36696a.d(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 0, 8);
        bArr[0] = (byte) (bArr[0] + 1);
        this.f36696a.d(bArr, 0, bArr2, 0);
        System.arraycopy(bArr2, 0, bArr4, 8, 8);
        if (length == 32) {
            bArr[0] = (byte) (bArr[0] + 1);
            this.f36696a.d(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 16, 8);
            bArr[0] = (byte) (bArr[0] + 1);
            this.f36696a.d(bArr, 0, bArr2, 0);
            System.arraycopy(bArr2, 0, bArr4, 24, 8);
        }
        this.f36696a.a(true, new n1(bArr4));
        x(bArr3, 0, 16, bArr2);
        B(bArr2);
        this.f36697b.a(bArr2);
        this.f36707l |= 1;
    }

    public final int w(byte[] bArr, byte[] bArr2, int i10) {
        byte[] bArrC = this.f36702g.c();
        byte[] bArrP = org.bouncycastle.util.a.p(bArr);
        bArrP[15] = (byte) (bArrP[15] | (-128));
        byte[] bArr3 = new byte[16];
        int size = this.f36702g.size();
        int i11 = 0;
        while (size > 0) {
            this.f36696a.d(bArrP, 0, bArr3, 0);
            int iMin = Math.min(16, size);
            E(bArr3, bArrC, i11, iMin);
            System.arraycopy(bArr3, 0, bArr2, i10 + i11, iMin);
            size -= iMin;
            i11 += iMin;
            A(bArrP);
        }
        return this.f36702g.size();
    }

    public final void y(byte[] bArr) {
        D(this.f36698c, bArr);
        this.f36697b.b(this.f36698c);
    }

    public final void z() {
        byte[] bArr = new byte[16];
        org.bouncycastle.util.o.z(this.f36701f.b() * 8, bArr, 0);
        org.bouncycastle.util.o.z(this.f36700e.b() * 8, bArr, 8);
        y(bArr);
    }
}
