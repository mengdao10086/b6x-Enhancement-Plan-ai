package gd;

import hd.u0;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f29238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f29240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f29241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29242e;

    public c(int i10, byte[] bArr, long j10, long j11) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            this.f29238a = cipher;
            int blockSize = cipher.getBlockSize();
            this.f29239b = blockSize;
            this.f29240c = new byte[blockSize];
            this.f29241d = new byte[blockSize];
            int i11 = (int) (j11 % ((long) blockSize));
            cipher.init(i10, new SecretKeySpec(bArr, u0.o1(cipher.getAlgorithm(), fh.a.f28350w)[0]), new IvParameterSpec(a(j10, j11 / ((long) blockSize))));
            if (i11 != 0) {
                d(new byte[i11], 0, i11);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final byte[] a(long j10, long j11) {
        return ByteBuffer.allocate(16).putLong(j10).putLong(j11).array();
    }

    public final int b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        try {
            return this.f29238a.update(bArr, i10, i11, bArr2, i12);
        } catch (ShortBufferException e10) {
            throw new RuntimeException(e10);
        }
    }

    public void c(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int i13 = i10;
        do {
            int i14 = this.f29242e;
            if (i14 <= 0) {
                int iB = b(bArr, i13, i11, bArr2, i12);
                if (i11 == iB) {
                    return;
                }
                int i15 = i11 - iB;
                int i16 = 0;
                hd.a.i(i15 < this.f29239b);
                int i17 = i12 + iB;
                int i18 = this.f29239b - i15;
                this.f29242e = i18;
                hd.a.i(b(this.f29240c, 0, i18, this.f29241d, 0) == this.f29239b);
                while (i16 < i15) {
                    bArr2[i17] = this.f29241d[i16];
                    i16++;
                    i17++;
                }
                return;
            }
            bArr2[i12] = (byte) (bArr[i13] ^ this.f29241d[this.f29239b - i14]);
            i12++;
            i13++;
            this.f29242e = i14 - 1;
            i11--;
        } while (i11 != 0);
    }

    public void d(byte[] bArr, int i10, int i11) {
        c(bArr, i10, i11, bArr, i10);
    }
}
