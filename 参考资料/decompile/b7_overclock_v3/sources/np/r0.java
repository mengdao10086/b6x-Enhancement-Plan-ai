package np;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public final class r0 extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42520d = 57;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42521e = 114;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s0 f42523c;

    public r0(InputStream inputStream) throws IOException {
        super(true);
        byte[] bArr = new byte[57];
        this.f42522b = bArr;
        if (57 != kt.c.g(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 private key");
        }
    }

    public r0(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[57];
        this.f42522b = bArr;
        or.b.u(secureRandom, bArr);
    }

    public r0(byte[] bArr) {
        this(h(bArr), 0);
    }

    public r0(byte[] bArr, int i10) {
        super(true);
        byte[] bArr2 = new byte[57];
        this.f42522b = bArr2;
        System.arraycopy(bArr, i10, bArr2, 0, 57);
    }

    public static byte[] h(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void d(byte[] bArr, int i10) {
        System.arraycopy(this.f42522b, 0, bArr, i10, 57);
    }

    public s0 e() {
        s0 s0Var;
        synchronized (this.f42522b) {
            if (this.f42523c == null) {
                byte[] bArr = new byte[57];
                or.b.v(this.f42522b, 0, bArr, 0);
                this.f42523c = new s0(bArr, 0);
            }
            s0Var = this.f42523c;
        }
        return s0Var;
    }

    public void f(int i10, s0 s0Var, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        g(i10, bArr, bArr2, i11, i12, bArr3, i13);
    }

    public void g(int i10, byte[] bArr, byte[] bArr2, int i11, int i12, byte[] bArr3, int i13) {
        byte[] bArr4 = new byte[57];
        e().d(bArr4, 0);
        if (i10 == 0) {
            or.b.Y(this.f42522b, 0, bArr4, 0, bArr, bArr2, i11, i12, bArr3, i13);
        } else {
            if (i10 != 1) {
                throw new IllegalArgumentException("algorithm");
            }
            if (64 != i12) {
                throw new IllegalArgumentException("msgLen");
            }
            or.b.b0(this.f42522b, 0, bArr4, 0, bArr, bArr2, i11, bArr3, i13);
        }
    }

    public byte[] getEncoded() {
        return org.bouncycastle.util.a.p(this.f42522b);
    }
}
