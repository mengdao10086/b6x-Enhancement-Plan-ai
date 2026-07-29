package ho;

import cs.d0;
import cs.q;
import gm.y;
import java.io.OutputStream;
import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.crypto.n;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f31375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f31376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f31377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f31378d;

    /* JADX INFO: renamed from: ho.a$a, reason: collision with other inner class name */
    public class C0370a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n1 f31379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f31380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f31381c;

        public C0370a(y yVar, int i10, SecureRandom secureRandom) throws CRMFException {
            SecureRandom secureRandomG = n.g(secureRandom);
            this.f31379a = new n1(a.this.f31377c.b(yVar, secureRandomG).a());
            this.f31380b = a.this.f31377c.c(yVar, this.f31379a, secureRandomG);
            d unused = a.this.f31377c;
            this.f31381c = d.a(true, this.f31379a, this.f31380b);
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f31380b;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return org.bouncycastle.crypto.util.c.d(outputStream, this.f31381c);
        }

        @Override // cs.d0
        public q getKey() {
            return new q(this.f31380b, this.f31379a.a());
        }
    }

    public a(y yVar) {
        this(yVar, -1);
    }

    public a(y yVar, int i10) {
        this.f31377c = new d();
        this.f31375a = yVar;
        this.f31376b = i10;
    }

    public d0 b() throws CRMFException {
        return new C0370a(this.f31375a, this.f31376b, this.f31378d);
    }

    public a c(SecureRandom secureRandom) {
        this.f31378d = secureRandom;
        return this;
    }
}
