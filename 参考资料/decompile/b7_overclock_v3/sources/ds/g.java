package ds;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.operator.OperatorCreationException;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f26482a = j.f26492b;

    public class a implements cs.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ X509CertificateHolder f26483a;

        public a(X509CertificateHolder x509CertificateHolder) {
            this.f26483a = x509CertificateHolder;
        }

        @Override // cs.h
        public cs.g a(zn.b bVar) throws OperatorCreationException {
            try {
                return g.this.new c(bVar, g.this.d(bVar, g.this.f(this.f26483a.p())));
            } catch (IOException e10) {
                throw new OperatorCreationException("exception on setup: " + e10, e10);
            }
        }

        @Override // cs.h
        public X509CertificateHolder c() {
            return this.f26483a;
        }

        @Override // cs.h
        public boolean d() {
            return true;
        }
    }

    public class b implements cs.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ np.c f26485a;

        public b(np.c cVar) {
            this.f26485a = cVar;
        }

        @Override // cs.h
        public cs.g a(zn.b bVar) throws OperatorCreationException {
            return g.this.new c(bVar, g.this.d(bVar, this.f26485a));
        }

        @Override // cs.h
        public X509CertificateHolder c() {
            return null;
        }

        @Override // cs.h
        public boolean d() {
            return false;
        }
    }

    public class c implements cs.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f26487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f26488b;

        public c(zn.b bVar, t tVar) {
            this.f26488b = bVar;
            this.f26487a = tVar;
        }

        @Override // cs.g
        public zn.b a() {
            return this.f26488b;
        }

        @Override // cs.g
        public OutputStream b() {
            t tVar = this.f26487a;
            if (tVar != null) {
                return tVar;
            }
            throw new IllegalStateException("verifier not initialised");
        }

        @Override // cs.g
        public boolean verify(byte[] bArr) {
            return this.f26487a.c(bArr);
        }
    }

    public cs.h b(np.c cVar) throws OperatorCreationException {
        return new b(cVar);
    }

    public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return new a(x509CertificateHolder);
    }

    public final t d(zn.b bVar, np.c cVar) throws OperatorCreationException {
        e0 e0VarE = e(bVar);
        e0VarE.a(false, cVar);
        return new t(e0VarE);
    }

    public abstract e0 e(zn.b bVar) throws OperatorCreationException;

    public abstract np.c f(c1 c1Var) throws IOException;
}
