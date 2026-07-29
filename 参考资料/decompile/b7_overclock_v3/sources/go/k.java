package go;

import cs.y;
import gm.d2;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import lm.r;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f29875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f29877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f29879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f29880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public r f29881g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29882h;

    public class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteArrayOutputStream f29883a = new ByteArrayOutputStream();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f29884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f29885c;

        public a(r rVar, byte[] bArr) {
            this.f29884b = rVar;
            this.f29885c = bArr;
        }

        @Override // cs.y
        public zn.b a() {
            return new zn.b(lm.c.f39859a, this.f29884b);
        }

        @Override // cs.y
        public OutputStream b() {
            return this.f29883a;
        }

        @Override // cs.y
        public byte[] d() {
            try {
                return k.this.f29880f.c(this.f29885c, this.f29883a.toByteArray());
            } catch (CRMFException e10) {
                throw new RuntimeOperatorException("exception calculating mac: " + e10.getMessage(), e10);
            }
        }

        @Override // cs.y
        public cs.q getKey() {
            return new cs.q(a(), this.f29885c);
        }
    }

    public k(n nVar) {
        this(new zn.b(on.b.f44365i), 1000, new zn.b(zm.a.f58655o, d2.f29657b), nVar);
    }

    public k(n nVar, int i10) {
        this.f29878d = 20;
        this.f29882h = i10;
        this.f29880f = nVar;
    }

    public k(zn.b bVar, int i10, zn.b bVar2, n nVar) {
        this.f29878d = 20;
        this.f29875a = bVar;
        this.f29876b = i10;
        this.f29877c = bVar2;
        this.f29880f = nVar;
    }

    public y b(char[] cArr) throws CRMFException {
        r rVar = this.f29881g;
        if (rVar != null) {
            return d(rVar, cArr);
        }
        byte[] bArr = new byte[this.f29878d];
        if (this.f29879e == null) {
            this.f29879e = new SecureRandom();
        }
        this.f29879e.nextBytes(bArr);
        return d(new r(bArr, this.f29875a, this.f29876b, this.f29877c), cArr);
    }

    public final void c(int i10) {
        int i11 = this.f29882h;
        if (i11 <= 0 || i10 <= i11) {
            return;
        }
        throw new IllegalArgumentException("iteration count exceeds limit (" + i10 + " > " + this.f29882h + ee.a.f26979d);
    }

    public final y d(r rVar, char[] cArr) throws CRMFException {
        byte[] bArrN = Strings.n(cArr);
        byte[] bArrJ = rVar.B().J();
        byte[] bArrB = new byte[bArrN.length + bArrJ.length];
        System.arraycopy(bArrN, 0, bArrB, 0, bArrN.length);
        System.arraycopy(bArrJ, 0, bArrB, bArrN.length, bArrJ.length);
        this.f29880f.a(rVar.A(), rVar.z());
        int iQ = rVar.y().Q();
        do {
            bArrB = this.f29880f.b(bArrB);
            iQ--;
        } while (iQ > 0);
        return new a(rVar, bArrB);
    }

    public k e(int i10) {
        if (i10 < 100) {
            throw new IllegalArgumentException("iteration count must be at least 100");
        }
        c(i10);
        this.f29876b = i10;
        return this;
    }

    public k f(r rVar) {
        c(rVar.y().Q());
        this.f29881g = rVar;
        return this;
    }

    public k g(int i10) {
        if (i10 < 8) {
            throw new IllegalArgumentException("salt length must be at least 8 bytes");
        }
        this.f29878d = i10;
        return this;
    }

    public k h(SecureRandom secureRandom) {
        this.f29879e = secureRandom;
        return this;
    }
}
