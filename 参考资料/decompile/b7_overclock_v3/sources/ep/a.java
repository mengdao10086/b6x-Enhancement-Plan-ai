package ep;

import np.y0;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.k;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f27084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f27085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y0 f27086c;

    public a(f fVar) {
        this.f27084a = fVar;
    }

    public static byte[] f(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i10 = 0; i10 != sArr.length; i10++) {
            o.K(sArr[i10], bArr, i10 * 2);
        }
        return bArr;
    }

    public static short[] g(byte[] bArr) {
        if ((bArr.length & 1) != 0) {
            throw new IllegalArgumentException("data must be an even number of bytes for a wide radix");
        }
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 != length; i10++) {
            sArr[i10] = o.g(bArr, i10 * 2);
        }
        return sArr;
    }

    public abstract int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12);

    public abstract int b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12);

    public abstract String c();

    public abstract void d(boolean z10, k kVar);

    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        if (this.f27086c == null) {
            throw new IllegalStateException("FPE engine not initialized");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("input length cannot be negative");
        }
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("buffer value is null");
        }
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length >= i12 + i11) {
            return this.f27085b ? b(bArr, i10, i11, bArr2, i12) : a(bArr, i10, i11, bArr2, i12);
        }
        throw new OutputLengthException("output buffer too short");
    }
}
