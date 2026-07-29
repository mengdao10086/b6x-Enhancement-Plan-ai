package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class o1 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f25591a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f25592b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte f25593c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25595e;

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.v1)) {
            throw new IllegalArgumentException("VMPC init parameters must include an IV");
        }
        np.v1 v1Var = (np.v1) kVar;
        if (!(v1Var.b() instanceof np.n1)) {
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        np.n1 n1Var = (np.n1) v1Var.b();
        byte[] bArrA = v1Var.a();
        this.f25594d = bArrA;
        if (bArrA == null || bArrA.length < 1 || bArrA.length > 768) {
            throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
        }
        byte[] bArrA2 = n1Var.a();
        this.f25595e = bArrA2;
        c(bArrA2, this.f25594d);
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "VMPC";
    }

    public void c(byte[] bArr, byte[] bArr2) {
        this.f25593c = (byte) 0;
        this.f25592b = new byte[256];
        for (int i10 = 0; i10 < 256; i10++) {
            this.f25592b[i10] = (byte) i10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr3 = this.f25592b;
            int i12 = i11 & 255;
            byte b10 = bArr3[(this.f25593c + bArr3[i12] + bArr[i11 % bArr.length]) & 255];
            this.f25593c = b10;
            byte b11 = bArr3[i12];
            bArr3[i12] = bArr3[b10 & 255];
            bArr3[b10 & 255] = b11;
        }
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr4 = this.f25592b;
            int i14 = i13 & 255;
            byte b12 = bArr4[(this.f25593c + bArr4[i14] + bArr2[i13 % bArr2.length]) & 255];
            this.f25593c = b12;
            byte b13 = bArr4[i14];
            bArr4[i14] = bArr4[b12 & 255];
            bArr4[b12 & 255] = b13;
        }
        this.f25591a = (byte) 0;
    }

    @Override // org.bouncycastle.crypto.k0
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (i10 + i11 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr3 = this.f25592b;
            byte b10 = this.f25593c;
            byte b11 = this.f25591a;
            byte b12 = bArr3[(b10 + bArr3[b11 & 255]) & 255];
            this.f25593c = b12;
            byte b13 = bArr3[(bArr3[bArr3[b12 & 255] & 255] + 1) & 255];
            byte b14 = bArr3[b11 & 255];
            bArr3[b11 & 255] = bArr3[b12 & 255];
            bArr3[b12 & 255] = b14;
            this.f25591a = (byte) ((b11 + 1) & 255);
            bArr2[i13 + i12] = (byte) (bArr[i13 + i10] ^ b13);
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        byte[] bArr = this.f25592b;
        byte b11 = this.f25593c;
        byte b12 = this.f25591a;
        byte b13 = bArr[(b11 + bArr[b12 & 255]) & 255];
        this.f25593c = b13;
        byte b14 = bArr[(bArr[bArr[b13 & 255] & 255] + 1) & 255];
        byte b15 = bArr[b12 & 255];
        bArr[b12 & 255] = bArr[b13 & 255];
        bArr[b13 & 255] = b15;
        this.f25591a = (byte) ((b12 + 1) & 255);
        return (byte) (b10 ^ b14);
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        c(this.f25595e, this.f25594d);
    }
}
