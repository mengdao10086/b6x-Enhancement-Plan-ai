package to;

import cs.a0;
import cs.b0;
import cs.d0;
import cs.f0;
import cs.q;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.cms.CMSException;
import pn.s;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f0 f51385e = cs.k.f25889a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f51386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f51388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f51389d;

    /* JADX INFO: renamed from: to.a$a, reason: collision with other inner class name */
    public static class C0584a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public jp.a f51390a;

        public C0584a(jp.a aVar) {
            this.f51390a = aVar;
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f51390a.j((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f51390a.k(bArr, i10, i11);
        }
    }

    public class b extends c implements b0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public jp.a f51391e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public a0 f51392f;

        public b(y yVar, int i10, SecureRandom secureRandom) throws CMSException {
            super(yVar, i10, secureRandom);
            this.f51391e = e();
        }

        @Override // to.a.c, cs.d0
        public OutputStream b(OutputStream outputStream) {
            a0 a0Var = new a0(outputStream, this.f51391e.d().length);
            this.f51392f = a0Var;
            return org.bouncycastle.crypto.util.c.d(a0Var, this.f51396c);
        }

        @Override // cs.a
        public OutputStream c() {
            return new C0584a(this.f51391e);
        }

        @Override // cs.a
        public byte[] d() {
            return this.f51392f.a();
        }

        public final jp.a e() {
            Object obj = this.f51396c;
            if (obj instanceof jp.a) {
                return (jp.a) obj;
            }
            throw new IllegalArgumentException("Unable to create Authenticated Output Encryptor without Authenticaed Data cipher!");
        }
    }

    public class c implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n1 f51394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f51395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f51396c;

        public c(y yVar, int i10, SecureRandom secureRandom) throws CMSException {
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            this.f51394a = new n1(a.this.f51388c.b(yVar, i10, secureRandom).a());
            zn.b bVarE = a.this.f51388c.e(yVar, this.f51394a, secureRandom);
            this.f51395b = bVarE;
            this.f51396c = p.a(true, this.f51394a, bVarE);
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f51395b;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return org.bouncycastle.crypto.util.c.d(outputStream, this.f51396c);
        }

        @Override // cs.d0
        public q getKey() {
            return new q(this.f51395b, this.f51394a.a());
        }
    }

    public a(y yVar) {
        this(yVar, f51385e.b(yVar));
    }

    public a(y yVar, int i10) {
        int i11;
        this.f51388c = new p();
        this.f51386a = yVar;
        int iB = f51385e.b(yVar);
        if (yVar.C(s.Z3)) {
            i11 = os.a.f46207a;
            if (i10 != 168 && i10 != iB) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else {
            if (!yVar.C(on.b.f44361e)) {
                if (iB > 0 && iB != i10) {
                    throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
                }
                this.f51387b = i10;
                return;
            }
            i11 = 56;
            if (i10 != 56 && i10 != iB) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        }
        this.f51387b = i11;
    }

    public d0 b() throws CMSException {
        return this.f51388c.g(this.f51386a) ? new b(this.f51386a, this.f51387b, this.f51389d) : new c(this.f51386a, this.f51387b, this.f51389d);
    }

    public a c(SecureRandom secureRandom) {
        this.f51389d = secureRandom;
        return this;
    }
}
