package jp;

import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class a0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f36541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f36542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f36543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f36548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36549i;

    public a0(org.bouncycastle.crypto.f fVar, boolean z10) {
        this.f36545e = fVar;
        this.f36549i = z10;
        int iC = fVar.c();
        this.f36547g = iC;
        this.f36541a = new byte[iC];
        this.f36542b = new byte[iC];
        this.f36543c = new byte[iC];
        this.f36544d = new byte[iC];
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f36548h = z10;
        if (kVar instanceof v1) {
            v1 v1Var = (v1) kVar;
            byte[] bArrA = v1Var.a();
            int length = bArrA.length;
            byte[] bArr = this.f36541a;
            if (length < bArr.length) {
                System.arraycopy(bArrA, 0, bArr, bArr.length - bArrA.length, bArrA.length);
                int i10 = 0;
                while (true) {
                    byte[] bArr2 = this.f36541a;
                    if (i10 >= bArr2.length - bArrA.length) {
                        break;
                    }
                    bArr2[i10] = 0;
                    i10++;
                }
            } else {
                System.arraycopy(bArrA, 0, bArr, 0, bArr.length);
            }
            reset();
            fVar = this.f36545e;
            kVar = v1Var.b();
        } else {
            reset();
            fVar = this.f36545e;
        }
        fVar.a(true, kVar);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        StringBuilder sb2;
        String str;
        if (this.f36549i) {
            sb2 = new StringBuilder();
            sb2.append(this.f36545e.b());
            str = "/PGPCFBwithIV";
        } else {
            sb2 = new StringBuilder();
            sb2.append(this.f36545e.b());
            str = "/PGPCFB";
        }
        sb2.append(str);
        return sb2.toString();
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f36545e.c();
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        return this.f36549i ? this.f36548h ? h(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11) : this.f36548h ? g(bArr, i10, bArr2, i11) : e(bArr, i10, bArr2, i11);
    }

    public final int e(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12 = this.f36547g;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i13 = 0;
        this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
        for (int i14 = 0; i14 < this.f36547g; i14++) {
            bArr2[i11 + i14] = i(bArr[i10 + i14], i14);
        }
        while (true) {
            int i15 = this.f36547g;
            if (i13 >= i15) {
                return i15;
            }
            this.f36542b[i13] = bArr[i10 + i13];
            i13++;
        }
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12;
        int i13 = this.f36547g;
        if (i10 + i13 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + i13 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i14 = this.f36546f;
        if (i14 == 0) {
            for (int i15 = 0; i15 < this.f36547g; i15++) {
                this.f36542b[i15] = bArr[i10 + i15];
            }
            this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
            this.f36546f += this.f36547g;
            return 0;
        }
        if (i14 != i13) {
            if (i14 >= i13 + 2) {
                System.arraycopy(bArr, i10, this.f36544d, 0, i13);
                bArr2[i11 + 0] = i(this.f36544d[0], this.f36547g - 2);
                bArr2[i11 + 1] = i(this.f36544d[1], this.f36547g - 1);
                System.arraycopy(this.f36544d, 0, this.f36542b, this.f36547g - 2, 2);
                this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
                int i16 = 0;
                while (true) {
                    i12 = this.f36547g;
                    if (i16 >= i12 - 2) {
                        break;
                    }
                    bArr2[i11 + i16 + 2] = i(this.f36544d[i16 + 2], i16);
                    i16++;
                }
                System.arraycopy(this.f36544d, 2, this.f36542b, 0, i12 - 2);
            }
            return this.f36547g;
        }
        System.arraycopy(bArr, i10, this.f36544d, 0, i13);
        byte[] bArr3 = this.f36542b;
        System.arraycopy(bArr3, 2, bArr3, 0, this.f36547g - 2);
        byte[] bArr4 = this.f36542b;
        int i17 = this.f36547g;
        byte[] bArr5 = this.f36544d;
        bArr4[i17 - 2] = bArr5[0];
        bArr4[i17 - 1] = bArr5[1];
        this.f36545e.d(bArr4, 0, this.f36543c, 0);
        int i18 = 0;
        while (true) {
            int i19 = this.f36547g;
            if (i18 >= i19 - 2) {
                System.arraycopy(this.f36544d, 2, this.f36542b, 0, i19 - 2);
                this.f36546f += 2;
                return this.f36547g - 2;
            }
            bArr2[i11 + i18] = i(this.f36544d[i18 + 2], i18);
            i18++;
        }
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12 = this.f36547g;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i13 = 0;
        this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
        for (int i14 = 0; i14 < this.f36547g; i14++) {
            bArr2[i11 + i14] = i(bArr[i10 + i14], i14);
        }
        while (true) {
            int i15 = this.f36547g;
            if (i13 >= i15) {
                return i15;
            }
            this.f36542b[i13] = bArr2[i11 + i13];
            i13++;
        }
    }

    public final int h(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12;
        int i13;
        int i14 = this.f36547g;
        if (i10 + i14 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int i15 = this.f36546f;
        if (i15 != 0) {
            if (i15 >= i14 + 2) {
                if (i14 + i11 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
                int i16 = 0;
                while (true) {
                    i12 = this.f36547g;
                    if (i16 >= i12) {
                        break;
                    }
                    bArr2[i11 + i16] = i(bArr[i10 + i16], i16);
                    i16++;
                }
                System.arraycopy(bArr2, i11, this.f36542b, 0, i12);
            }
            return this.f36547g;
        }
        if ((i14 * 2) + i11 + 2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
        int i17 = 0;
        while (true) {
            i13 = this.f36547g;
            if (i17 >= i13) {
                break;
            }
            bArr2[i11 + i17] = i(this.f36541a[i17], i17);
            i17++;
        }
        System.arraycopy(bArr2, i11, this.f36542b, 0, i13);
        this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
        int i18 = this.f36547g;
        bArr2[i11 + i18] = i(this.f36541a[i18 - 2], 0);
        int i19 = this.f36547g;
        bArr2[i11 + i19 + 1] = i(this.f36541a[i19 - 1], 1);
        System.arraycopy(bArr2, i11 + 2, this.f36542b, 0, this.f36547g);
        this.f36545e.d(this.f36542b, 0, this.f36543c, 0);
        int i20 = 0;
        while (true) {
            int i21 = this.f36547g;
            if (i20 >= i21) {
                System.arraycopy(bArr2, i11 + i21 + 2, this.f36542b, 0, i21);
                int i22 = this.f36546f;
                int i23 = this.f36547g;
                this.f36546f = i22 + (i23 * 2) + 2;
                return (i23 * 2) + 2;
            }
            bArr2[i21 + i11 + 2 + i20] = i(bArr[i10 + i20], i20);
            i20++;
        }
    }

    public final byte i(byte b10, int i10) {
        return (byte) (b10 ^ this.f36543c[i10]);
    }

    public org.bouncycastle.crypto.f j() {
        return this.f36545e;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
        this.f36546f = 0;
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f36542b;
            if (i10 == bArr.length) {
                this.f36545e.reset();
                return;
            }
            if (this.f36549i) {
                bArr[i10] = 0;
            } else {
                bArr[i10] = this.f36541a[i10];
            }
            i10++;
        }
    }
}
