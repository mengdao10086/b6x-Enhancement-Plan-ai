package rp;

import java.io.ByteArrayOutputStream;
import np.r0;
import np.s0;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class m implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f49015g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f49016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r0 f49018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s0 f49019k;

    public static class b extends ByteArrayOutputStream {
        public b() {
        }

        public synchronized byte[] a(r0 r0Var, byte[] bArr) {
            byte[] bArr2;
            bArr2 = new byte[114];
            r0Var.g(0, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr2, 0);
            reset();
            return bArr2;
        }

        public synchronized boolean c(s0 s0Var, byte[] bArr, byte[] bArr2) {
            if (114 != bArr2.length) {
                reset();
                return false;
            }
            boolean zG0 = or.b.g0(bArr2, 0, s0Var.getEncoded(), 0, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            reset();
            return zG0;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            org.bouncycastle.util.a.e0(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }
    }

    public m(byte[] bArr) {
        this.f49016h = org.bouncycastle.util.a.p(bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49017i = z10;
        if (z10) {
            this.f49018j = (r0) kVar;
            this.f49019k = null;
        } else {
            this.f49018j = null;
            this.f49019k = (s0) kVar;
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        s0 s0Var;
        if (this.f49017i || (s0Var = this.f49019k) == null) {
            throw new IllegalStateException("Ed448Signer not initialised for verification");
        }
        return this.f49015g.c(s0Var, this.f49016h, bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        r0 r0Var;
        if (!this.f49017i || (r0Var = this.f49018j) == null) {
            throw new IllegalStateException("Ed448Signer not initialised for signature generation.");
        }
        return this.f49015g.a(r0Var, this.f49016h);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49015g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49015g.write(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49015g.write(bArr, i10, i11);
    }
}
