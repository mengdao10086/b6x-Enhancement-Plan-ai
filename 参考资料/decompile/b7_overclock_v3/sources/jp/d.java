package jp;

import java.io.ByteArrayOutputStream;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class d implements jp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public org.bouncycastle.crypto.k f36568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f36569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f36570i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f36571j = new a();

    public class a extends ByteArrayOutputStream {
        public a() {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public d(org.bouncycastle.crypto.f fVar) {
        this.f36562a = fVar;
        int iC = fVar.c();
        this.f36563b = iC;
        this.f36569h = new byte[iC];
        if (iC != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.k kVarB;
        this.f36564c = z10;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            this.f36565d = aVar.d();
            this.f36566e = aVar.a();
            this.f36567f = n(z10, aVar.c());
            kVarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to CCM: " + kVar.getClass().getName());
            }
            v1 v1Var = (v1) kVar;
            this.f36565d = v1Var.a();
            this.f36566e = null;
            this.f36567f = n(z10, 64);
            kVarB = v1Var.b();
        }
        if (kVarB != null) {
            this.f36568g = kVarB;
        }
        byte[] bArr = this.f36565d;
        if (bArr == null || bArr.length < 7 || bArr.length > 13) {
            throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
        }
        reset();
    }

    @Override // jp.b
    public String b() {
        return this.f36562a.b() + "/CCM";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        int iP = p(this.f36571j.a(), 0, this.f36571j.size(), bArr, i10);
        reset();
        return iP;
    }

    @Override // jp.b
    public byte[] d() {
        int i10 = this.f36567f;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f36569h, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, DataLengthException {
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("Input buffer too short");
        }
        this.f36571j.write(bArr, i10, i11);
        return 0;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36562a;
    }

    @Override // jp.b
    public int g(int i10) {
        return 0;
    }

    @Override // jp.b
    public int h(int i10) {
        int size = i10 + this.f36571j.size();
        if (this.f36564c) {
            return size + this.f36567f;
        }
        int i11 = this.f36567f;
        if (size < i11) {
            return 0;
        }
        return size - i11;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        this.f36571j.write(b10);
        return 0;
    }

    @Override // jp.b
    public void j(byte b10) {
        this.f36570i.write(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        this.f36570i.write(bArr, i10, i11);
    }

    public final int l(byte[] bArr, int i10, int i11, byte[] bArr2) {
        ip.c cVar = new ip.c(this.f36562a, this.f36567f * 8);
        cVar.a(this.f36568g);
        byte[] bArr3 = new byte[16];
        if (o()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i12 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((cVar.d() - 2) / 2) & 7) << 3));
        byte b10 = bArr3[0];
        byte[] bArr4 = this.f36565d;
        bArr3[0] = (byte) (b10 | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i13 = i11;
        int i14 = 1;
        while (i13 > 0) {
            bArr3[16 - i14] = (byte) (i13 & 255);
            i13 >>>= 8;
            i14++;
        }
        cVar.update(bArr3, 0, 16);
        if (o()) {
            int iM = m();
            if (iM < 65280) {
                cVar.update((byte) (iM >> 8));
                cVar.update((byte) iM);
            } else {
                cVar.update((byte) -1);
                cVar.update((byte) -2);
                cVar.update((byte) (iM >> 24));
                cVar.update((byte) (iM >> 16));
                cVar.update((byte) (iM >> 8));
                cVar.update((byte) iM);
                i12 = 6;
            }
            byte[] bArr5 = this.f36566e;
            if (bArr5 != null) {
                cVar.update(bArr5, 0, bArr5.length);
            }
            if (this.f36570i.size() > 0) {
                cVar.update(this.f36570i.a(), 0, this.f36570i.size());
            }
            int i15 = (i12 + iM) % 16;
            if (i15 != 0) {
                while (i15 != 16) {
                    cVar.update((byte) 0);
                    i15++;
                }
            }
        }
        cVar.update(bArr, i10, i11);
        return cVar.c(bArr2, 0);
    }

    public final int m() {
        int size = this.f36570i.size();
        byte[] bArr = this.f36566e;
        return size + (bArr == null ? 0 : bArr.length);
    }

    public final int n(boolean z10, int i10) {
        if (!z10 || (i10 >= 32 && i10 <= 128 && (i10 & 15) == 0)) {
            return i10 >>> 3;
        }
        throw new IllegalArgumentException("tag length in octets must be one of {4,6,8,10,12,14,16}");
    }

    public final boolean o() {
        return m() > 0;
    }

    public int p(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        int i13;
        if (this.f36568g == null) {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
        byte[] bArr3 = this.f36565d;
        int length = 15 - bArr3.length;
        if (length < 4 && i11 >= (1 << (length * 8))) {
            throw new IllegalStateException("CCM packet too large for choice of q.");
        }
        byte[] bArr4 = new byte[this.f36563b];
        bArr4[0] = (byte) ((length - 1) & 7);
        System.arraycopy(bArr3, 0, bArr4, 1, bArr3.length);
        c0 c0Var = new c0(this.f36562a);
        c0Var.a(this.f36564c, new v1(this.f36568g, bArr4));
        if (!this.f36564c) {
            int i14 = this.f36567f;
            if (i11 < i14) {
                throw new InvalidCipherTextException("data too short");
            }
            int i15 = i11 - i14;
            if (bArr2.length < i15 + i12) {
                throw new OutputLengthException("Output buffer too short.");
            }
            int i16 = i10 + i15;
            System.arraycopy(bArr, i16, this.f36569h, 0, i14);
            byte[] bArr5 = this.f36569h;
            c0Var.d(bArr5, 0, bArr5, 0);
            int i17 = this.f36567f;
            while (true) {
                byte[] bArr6 = this.f36569h;
                if (i17 == bArr6.length) {
                    break;
                }
                bArr6[i17] = 0;
                i17++;
            }
            int i18 = i10;
            int i19 = i12;
            while (true) {
                i13 = this.f36563b;
                if (i18 >= i16 - i13) {
                    break;
                }
                c0Var.d(bArr, i18, bArr2, i19);
                int i20 = this.f36563b;
                i19 += i20;
                i18 += i20;
            }
            byte[] bArr7 = new byte[i13];
            int i21 = i15 - (i18 - i10);
            System.arraycopy(bArr, i18, bArr7, 0, i21);
            c0Var.d(bArr7, 0, bArr7, 0);
            System.arraycopy(bArr7, 0, bArr2, i19, i21);
            byte[] bArr8 = new byte[this.f36563b];
            l(bArr2, i12, i15, bArr8);
            if (org.bouncycastle.util.a.I(this.f36569h, bArr8)) {
                return i15;
            }
            throw new InvalidCipherTextException("mac check in CCM failed");
        }
        int i22 = this.f36567f + i11;
        if (bArr2.length < i22 + i12) {
            throw new OutputLengthException("Output buffer too short.");
        }
        l(bArr, i10, i11, this.f36569h);
        byte[] bArr9 = new byte[this.f36563b];
        c0Var.d(this.f36569h, 0, bArr9, 0);
        int i23 = i10;
        int i24 = i12;
        while (true) {
            int i25 = i10 + i11;
            int i26 = this.f36563b;
            if (i23 >= i25 - i26) {
                byte[] bArr10 = new byte[i26];
                int i27 = i25 - i23;
                System.arraycopy(bArr, i23, bArr10, 0, i27);
                c0Var.d(bArr10, 0, bArr10, 0);
                System.arraycopy(bArr10, 0, bArr2, i24, i27);
                System.arraycopy(bArr9, 0, bArr2, i12 + i11, this.f36567f);
                return i22;
            }
            c0Var.d(bArr, i23, bArr2, i24);
            int i28 = this.f36563b;
            i24 += i28;
            i23 += i28;
        }
    }

    public byte[] q(byte[] bArr, int i10, int i11) throws InvalidCipherTextException, IllegalStateException {
        int i12;
        if (this.f36564c) {
            i12 = this.f36567f + i11;
        } else {
            int i13 = this.f36567f;
            if (i11 < i13) {
                throw new InvalidCipherTextException("data too short");
            }
            i12 = i11 - i13;
        }
        byte[] bArr2 = new byte[i12];
        p(bArr, i10, i11, bArr2, 0);
        return bArr2;
    }

    @Override // jp.b
    public void reset() {
        this.f36562a.reset();
        this.f36570i.reset();
        this.f36571j.reset();
    }
}
