package cp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class q0 implements org.bouncycastle.crypto.k0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25609e = 256;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f25610a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25611b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25612c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25613d = null;

    @Override // org.bouncycastle.crypto.k0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof np.n1) {
            byte[] bArrA = ((np.n1) kVar).a();
            this.f25613d = bArrA;
            c(bArrA);
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC4 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.k0
    public String b() {
        return "RC4";
    }

    public final void c(byte[] bArr) {
        this.f25613d = bArr;
        this.f25611b = 0;
        this.f25612c = 0;
        if (this.f25610a == null) {
            this.f25610a = new byte[256];
        }
        for (int i10 = 0; i10 < 256; i10++) {
            this.f25610a[i10] = (byte) i10;
        }
        int length = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            int i13 = bArr[length] & 255;
            byte[] bArr2 = this.f25610a;
            i11 = (i13 + bArr2[i12] + i11) & 255;
            byte b10 = bArr2[i12];
            bArr2[i12] = bArr2[i11];
            bArr2[i11] = b10;
            length = (length + 1) % bArr.length;
        }
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
            int i14 = (this.f25611b + 1) & 255;
            this.f25611b = i14;
            byte[] bArr3 = this.f25610a;
            int i15 = (bArr3[i14] + this.f25612c) & 255;
            this.f25612c = i15;
            byte b10 = bArr3[i14];
            bArr3[i14] = bArr3[i15];
            bArr3[i15] = b10;
            bArr2[i13 + i12] = (byte) (bArr3[(bArr3[i14] + bArr3[i15]) & 255] ^ bArr[i13 + i10]);
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public byte f(byte b10) {
        int i10 = (this.f25611b + 1) & 255;
        this.f25611b = i10;
        byte[] bArr = this.f25610a;
        int i11 = (bArr[i10] + this.f25612c) & 255;
        this.f25612c = i11;
        byte b11 = bArr[i10];
        bArr[i10] = bArr[i11];
        bArr[i11] = b11;
        return (byte) (b10 ^ bArr[(bArr[i10] + bArr[i11]) & 255]);
    }

    @Override // org.bouncycastle.crypto.k0
    public void reset() {
        c(this.f25613d);
    }
}
