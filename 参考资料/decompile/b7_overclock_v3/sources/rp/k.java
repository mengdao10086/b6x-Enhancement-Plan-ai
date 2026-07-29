package rp;

import java.io.ByteArrayOutputStream;
import np.o0;
import np.p0;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class k implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f49005g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f49006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o0 f49008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p0 f49009k;

    public static class b extends ByteArrayOutputStream {
        public b() {
        }

        public synchronized byte[] a(o0 o0Var, byte[] bArr) {
            byte[] bArr2;
            bArr2 = new byte[64];
            o0Var.g(1, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr2, 0);
            reset();
            return bArr2;
        }

        public synchronized boolean c(p0 p0Var, byte[] bArr, byte[] bArr2) {
            if (64 != bArr2.length) {
                reset();
                return false;
            }
            boolean zR0 = or.a.r0(bArr2, 0, p0Var.getEncoded(), 0, bArr, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            reset();
            return zR0;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            org.bouncycastle.util.a.e0(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }
    }

    public k(byte[] bArr) {
        this.f49006h = org.bouncycastle.util.a.p(bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49007i = z10;
        if (z10) {
            this.f49008j = (o0) kVar;
            this.f49009k = null;
        } else {
            this.f49008j = null;
            this.f49009k = (p0) kVar;
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        p0 p0Var;
        if (this.f49007i || (p0Var = this.f49009k) == null) {
            throw new IllegalStateException("Ed25519ctxSigner not initialised for verification");
        }
        return this.f49005g.c(p0Var, this.f49006h, bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        o0 o0Var;
        if (!this.f49007i || (o0Var = this.f49008j) == null) {
            throw new IllegalStateException("Ed25519ctxSigner not initialised for signature generation.");
        }
        return this.f49005g.a(o0Var, this.f49006h);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49005g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49005g.write(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49005g.write(bArr, i10, i11);
    }
}
