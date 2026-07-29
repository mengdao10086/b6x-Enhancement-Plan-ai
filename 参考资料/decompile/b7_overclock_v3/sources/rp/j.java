package rp;

import java.io.ByteArrayOutputStream;
import np.o0;
import np.p0;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class j implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f49001g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f49002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o0 f49003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public p0 f49004j;

    public static class b extends ByteArrayOutputStream {
        public b() {
        }

        public synchronized byte[] a(o0 o0Var) {
            byte[] bArr;
            bArr = new byte[64];
            o0Var.g(0, null, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, bArr, 0);
            reset();
            return bArr;
        }

        public synchronized boolean c(p0 p0Var, byte[] bArr) {
            if (64 != bArr.length) {
                reset();
                return false;
            }
            boolean zQ0 = or.a.q0(bArr, 0, p0Var.getEncoded(), 0, ((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count);
            reset();
            return zQ0;
        }

        @Override // java.io.ByteArrayOutputStream
        public synchronized void reset() {
            org.bouncycastle.util.a.e0(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count, (byte) 0);
            ((ByteArrayOutputStream) this).count = 0;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49002h = z10;
        if (z10) {
            this.f49003i = (o0) kVar;
            this.f49004j = null;
        } else {
            this.f49003i = null;
            this.f49004j = (p0) kVar;
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        p0 p0Var;
        if (this.f49002h || (p0Var = this.f49004j) == null) {
            throw new IllegalStateException("Ed25519Signer not initialised for verification");
        }
        return this.f49001g.c(p0Var, bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        o0 o0Var;
        if (!this.f49002h || (o0Var = this.f49003i) == null) {
            throw new IllegalStateException("Ed25519Signer not initialised for signature generation.");
        }
        return this.f49001g.a(o0Var);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49001g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49001g.write(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49001g.write(bArr, i10, i11);
    }
}
