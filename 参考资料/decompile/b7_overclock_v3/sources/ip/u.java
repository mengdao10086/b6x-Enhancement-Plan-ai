package ip;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class u implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f35597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f35598b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f35599c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f35600d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f35601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35602f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f35603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte f35604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte f35605i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte f35606j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte f35607k;

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof v1)) {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
        }
        v1 v1Var = (v1) kVar;
        n1 n1Var = (n1) v1Var.b();
        if (!(v1Var.b() instanceof n1)) {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        byte[] bArrA = v1Var.a();
        this.f35602f = bArrA;
        if (bArrA == null || bArrA.length < 1 || bArrA.length > 768) {
            throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
        }
        this.f35603g = n1Var.a();
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return "VMPC-MAC";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        for (int i11 = 1; i11 < 25; i11++) {
            byte[] bArr2 = this.f35599c;
            byte b10 = this.f35600d;
            byte b11 = this.f35598b;
            byte b12 = bArr2[(b10 + bArr2[b11 & 255]) & 255];
            this.f35600d = b12;
            byte b13 = this.f35607k;
            byte b14 = this.f35606j;
            byte b15 = bArr2[(b13 + b14 + i11) & 255];
            this.f35607k = b15;
            byte b16 = this.f35605i;
            byte b17 = bArr2[(b14 + b16 + i11) & 255];
            this.f35606j = b17;
            byte b18 = this.f35604h;
            byte b19 = bArr2[(b16 + b18 + i11) & 255];
            this.f35605i = b19;
            byte b20 = bArr2[(b18 + b12 + i11) & 255];
            this.f35604h = b20;
            byte[] bArr3 = this.f35601e;
            byte b21 = this.f35597a;
            bArr3[b21 & 31] = (byte) (b20 ^ bArr3[b21 & 31]);
            bArr3[(b21 + 1) & 31] = (byte) (b19 ^ bArr3[(b21 + 1) & 31]);
            bArr3[(b21 + 2) & 31] = (byte) (b17 ^ bArr3[(b21 + 2) & 31]);
            bArr3[(b21 + 3) & 31] = (byte) (b15 ^ bArr3[(b21 + 3) & 31]);
            this.f35597a = (byte) ((b21 + 4) & 31);
            byte b22 = bArr2[b11 & 255];
            bArr2[b11 & 255] = bArr2[b12 & 255];
            bArr2[b12 & 255] = b22;
            this.f35598b = (byte) ((b11 + 1) & 255);
        }
        for (int i12 = 0; i12 < 768; i12++) {
            byte[] bArr4 = this.f35599c;
            int i13 = i12 & 255;
            byte b23 = bArr4[(this.f35600d + bArr4[i13] + this.f35601e[i12 & 31]) & 255];
            this.f35600d = b23;
            byte b24 = bArr4[i13];
            bArr4[i13] = bArr4[b23 & 255];
            bArr4[b23 & 255] = b24;
        }
        byte[] bArr5 = new byte[20];
        for (int i14 = 0; i14 < 20; i14++) {
            byte[] bArr6 = this.f35599c;
            int i15 = i14 & 255;
            byte b25 = bArr6[(this.f35600d + bArr6[i15]) & 255];
            this.f35600d = b25;
            bArr5[i14] = bArr6[(bArr6[bArr6[b25 & 255] & 255] + 1) & 255];
            byte b26 = bArr6[i15];
            bArr6[i15] = bArr6[b25 & 255];
            bArr6[b25 & 255] = b26;
        }
        System.arraycopy(bArr5, 0, bArr, i10, 20);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return 20;
    }

    public final void e(byte[] bArr, byte[] bArr2) {
        this.f35600d = (byte) 0;
        this.f35599c = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            this.f35599c[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr3 = this.f35599c;
            int i12 = i11 & 255;
            byte b10 = bArr3[(this.f35600d + bArr3[i12] + bArr[i11 % bArr.length]) & 255];
            this.f35600d = b10;
            byte b11 = bArr3[i12];
            bArr3[i12] = bArr3[b10 & 255];
            bArr3[b10 & 255] = b11;
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.f35599c;
            int i14 = i13 & 255;
            byte b12 = bArr4[(this.f35600d + bArr4[i14] + bArr2[i13 % bArr2.length]) & 255];
            this.f35600d = b12;
            byte b13 = bArr4[i14];
            bArr4[i14] = bArr4[b12 & 255];
            bArr4[b12 & 255] = b13;
        }
        this.f35598b = (byte) 0;
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        e(this.f35603g, this.f35602f);
        this.f35598b = (byte) 0;
        this.f35607k = (byte) 0;
        this.f35606j = (byte) 0;
        this.f35605i = (byte) 0;
        this.f35604h = (byte) 0;
        this.f35597a = (byte) 0;
        this.f35601e = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            this.f35601e[i10] = 0;
        }
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.f35599c;
        byte b11 = this.f35600d;
        byte b12 = this.f35598b;
        byte b13 = bArr[(b11 + bArr[b12 & 255]) & 255];
        this.f35600d = b13;
        byte b14 = (byte) (b10 ^ bArr[(bArr[bArr[b13 & 255] & 255] + 1) & 255]);
        byte b15 = this.f35607k;
        byte b16 = this.f35606j;
        byte b17 = bArr[(b15 + b16) & 255];
        this.f35607k = b17;
        byte b18 = this.f35605i;
        byte b19 = bArr[(b16 + b18) & 255];
        this.f35606j = b19;
        byte b20 = this.f35604h;
        byte b21 = bArr[(b18 + b20) & 255];
        this.f35605i = b21;
        byte b22 = bArr[(b20 + b13 + b14) & 255];
        this.f35604h = b22;
        byte[] bArr2 = this.f35601e;
        byte b23 = this.f35597a;
        bArr2[b23 & 31] = (byte) (b22 ^ bArr2[b23 & 31]);
        bArr2[(b23 + 1) & 31] = (byte) (b21 ^ bArr2[(b23 + 1) & 31]);
        bArr2[(b23 + 2) & 31] = (byte) (b19 ^ bArr2[(b23 + 2) & 31]);
        bArr2[(b23 + 3) & 31] = (byte) (b17 ^ bArr2[(b23 + 3) & 31]);
        this.f35597a = (byte) ((b23 + 4) & 31);
        byte b24 = bArr[b12 & 255];
        bArr[b12 & 255] = bArr[b13 & 255];
        bArr[b13 & 255] = b24;
        this.f35598b = (byte) ((b12 + 1) & 255);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        for (int i12 = 0; i12 < i11; i12++) {
            update(bArr[i10 + i12]);
        }
    }
}
