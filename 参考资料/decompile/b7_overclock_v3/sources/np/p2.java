package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public final class p2 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42504c = 56;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42505d = 56;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42506b;

    public p2(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[56];
        this.f42506b = bArr;
        if (56 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 private key");
        }
    }

    public p2(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[56];
        this.f42506b = bArr;
        nr.c.d(secureRandom, bArr);
    }

    public p2(byte[] bArr) {
        this(g(bArr), 0);
    }

    public p2(byte[] bArr, int i10) {
        super(true);
        byte[] bArr2 = new byte[56];
        this.f42506b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 56);
    }

    public static byte[] g(byte[] bArr) {
        if (bArr.length == 56) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42506b, 0, bArr, i10, 56);
    }

    public q2 e() {
        byte[] bArr = new byte[56];
        nr.c.e(this.f42506b, 0, bArr, 0);
        return new q2(bArr, 0);
    }

    public void f(q2 q2Var, byte[] bArr, int i10) {
        byte[] bArr2 = new byte[56];
        q2Var.d(bArr2, 0);
        if (!nr.c.a(this.f42506b, 0, bArr2, 0, bArr, i10)) {
            throw new IllegalStateException("X448 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42506b);
    }
}
