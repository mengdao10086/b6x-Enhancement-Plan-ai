package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42492d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42493e = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p0 f42495c;

    public o0(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[32];
        this.f42494b = bArr;
        if (32 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 private key");
        }
    }

    public o0(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.f42494b = bArr;
        or.a.t(secureRandom, bArr);
    }

    public o0(byte[] bArr) {
        this(h(bArr), 0);
    }

    public o0(byte[] bArr, int i10) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f42494b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 32);
    }

    public static byte[] h(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42494b, 0, bArr, i10, 32);
    }

    public p0 e() {
        p0 p0Var;
        synchronized (this.f42494b) {
            if (this.f42495c == null) {
                byte[] bArr = new byte[32];
                or.a.u(this.f42494b, 0, bArr, 0);
                this.f42495c = new p0(bArr, 0);
            }
            p0Var = this.f42495c;
        }
        return p0Var;
    }

    public void f(int i10, p0 p0Var, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        g(i10, bArr, bArr2, i11, i12, bArr3, i13);
    }

    public void g(int i10, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        byte[] bArr4 = new byte[32];
        e().d(bArr4, 0);
        if (i10 == 0) {
            if (bArr != null) {
                throw new IllegalArgumentException("ctx");
            }
            or.a.h0(this.f42494b, 0, bArr4, 0, bArr2, i11, i12, bArr3, i13);
        } else if (i10 == 1) {
            or.a.i0(this.f42494b, 0, bArr4, 0, bArr, bArr2, i11, i12, bArr3, i13);
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException("algorithm");
            }
            if (64 != i12) {
                throw new IllegalArgumentException("msgLen");
            }
            or.a.l0(this.f42494b, 0, bArr4, 0, bArr, bArr2, i11, bArr3, i13);
        }
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42494b);
    }
}
