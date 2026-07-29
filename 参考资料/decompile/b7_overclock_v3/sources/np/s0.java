package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42533c = 57;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42534b;

    public s0(InputStream inputStream) throws IOException {
        super(false);
        byte[] bArr = new byte[57];
        this.f42534b = bArr;
        if (57 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 public key");
        }
    }

    public s0(byte[] bArr) {
        this(e(bArr), 0);
    }

    public s0(byte[] bArr, int i10) {
        super(false);
        byte[] bArr2 = new byte[57];
        this.f42534b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 57);
    }

    public static byte[] e(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42534b, 0, bArr, i10, 57);
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42534b);
    }
}
