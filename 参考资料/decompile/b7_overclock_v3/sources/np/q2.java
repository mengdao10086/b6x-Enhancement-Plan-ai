package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class q2 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42517c = 56;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42518b;

    public q2(InputStream inputStream) throws IOException {
        super(false);
        byte[] bArr = new byte[56];
        this.f42518b = bArr;
        if (56 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 public key");
        }
    }

    public q2(byte[] bArr) {
        this(e(bArr), 0);
    }

    public q2(byte[] bArr, int i10) {
        super(false);
        byte[] bArr2 = new byte[56];
        this.f42518b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 56);
    }

    public static byte[] e(byte[] bArr) {
        if (bArr.length == 56) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42518b, 0, bArr, i10, 56);
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42518b);
    }
}
