package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class p0 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42499c = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42500b;

    public p0(InputStream inputStream) throws IOException {
        super(false);
        byte[] bArr = new byte[32];
        this.f42500b = bArr;
        if (32 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 public key");
        }
    }

    public p0(byte[] bArr) {
        this(e(bArr), 0);
    }

    public p0(byte[] bArr, int i10) {
        super(false);
        byte[] bArr2 = new byte[32];
        this.f42500b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 32);
    }

    public static byte[] e(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42500b, 0, bArr, i10, 32);
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42500b);
    }
}
