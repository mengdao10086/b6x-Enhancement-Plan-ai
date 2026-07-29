package ho;

import fp.d0;
import go.g;
import java.security.SecureRandom;
import np.o1;
import org.bouncycastle.crypto.s;
import zo.c0;

/* JADX INFO: loaded from: classes5.dex */
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f31384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f31385c;

    public c(int i10) {
        this(i10, null);
    }

    public c(int i10, SecureRandom secureRandom) {
        this.f31385c = new c0();
        this.f31383a = i10;
        this.f31384b = secureRandom;
    }

    @Override // go.g
    public byte[] a(byte[] bArr) {
        int i10 = this.f31383a;
        byte[] bArr2 = new byte[i10];
        int iH = this.f31385c.h();
        byte[] bArr3 = new byte[iH];
        int iH2 = this.f31383a - this.f31385c.h();
        byte[] bArr4 = new byte[iH2];
        if (this.f31384b == null) {
            this.f31384b = new SecureRandom();
        }
        this.f31384b.nextBytes(bArr3);
        d0 d0Var = new d0(this.f31385c);
        d0Var.a(new o1(bArr3));
        d0Var.b(bArr4, 0, iH2);
        System.arraycopy(bArr3, 0, bArr2, 0, iH);
        System.arraycopy(bArr, 0, bArr2, iH, bArr.length);
        int length = bArr.length + iH;
        while (true) {
            length++;
            if (length == i10) {
                break;
            }
            bArr2[length] = (byte) (this.f31384b.nextInt(255) + 1);
        }
        for (int i11 = 0; i11 != iH2; i11++) {
            int i12 = i11 + iH;
            bArr2[i12] = (byte) (bArr2[i12] ^ bArr4[i11]);
        }
        return bArr2;
    }

    @Override // go.g
    public byte[] b(byte[] bArr) {
        int iH = this.f31385c.h();
        byte[] bArr2 = new byte[iH];
        int iH2 = this.f31383a - this.f31385c.h();
        byte[] bArr3 = new byte[iH2];
        System.arraycopy(bArr, 0, bArr2, 0, iH);
        d0 d0Var = new d0(this.f31385c);
        d0Var.a(new o1(bArr2));
        d0Var.b(bArr3, 0, iH2);
        for (int i10 = 0; i10 != iH2; i10++) {
            int i11 = i10 + iH;
            bArr[i11] = (byte) (bArr[i11] ^ bArr3[i10]);
        }
        int length = bArr.length - 1;
        while (true) {
            if (length == iH) {
                length = 0;
                break;
            }
            if (bArr[length] == 0) {
                break;
            }
            length--;
        }
        if (length == 0) {
            throw new IllegalStateException("bad padding in encoding");
        }
        int i12 = length - iH;
        byte[] bArr4 = new byte[i12];
        System.arraycopy(bArr, iH, bArr4, 0, i12);
        return bArr4;
    }
}
