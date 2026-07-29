package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public final class m2 extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42482c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42483d = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42484b;

    public m2(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[32];
        this.f42484b = bArr;
        if (32 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X25519 private key");
        }
    }

    public m2(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.f42484b = bArr;
        nr.a.d(secureRandom, bArr);
    }

    public m2(byte[] bArr) {
        this(g(bArr), 0);
    }

    public m2(byte[] bArr, int i10) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f42484b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 32);
    }

    public static byte[] g(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42484b, 0, bArr, i10, 32);
    }

    public n2 e() {
        byte[] bArr = new byte[32];
        nr.a.e(this.f42484b, 0, bArr, 0);
        return new n2(bArr, 0);
    }

    public void f(n2 n2Var, byte[] bArr, int i10) {
        byte[] bArr2 = new byte[32];
        n2Var.d(bArr2, 0);
        if (!nr.a.a(this.f42484b, 0, bArr2, 0, bArr, i10)) {
            throw new IllegalStateException("X25519 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42484b);
    }
}
