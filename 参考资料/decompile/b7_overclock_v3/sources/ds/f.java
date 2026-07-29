package ds;

import java.io.OutputStream;
import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RuntimeOperatorException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f26475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f26476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f26477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l f26478d = j.f26492b;

    public class a implements cs.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t f26479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f26480b;

        public a(e0 e0Var) {
            this.f26480b = e0Var;
            this.f26479a = new t(e0Var);
        }

        @Override // cs.f
        public zn.b a() {
            return f.this.f26476b;
        }

        @Override // cs.f
        public OutputStream b() {
            return this.f26479a;
        }

        @Override // cs.f
        public byte[] getSignature() {
            try {
                return this.f26479a.a();
            } catch (CryptoException e10) {
                throw new RuntimeOperatorException("exception obtaining signature: " + e10.getMessage(), e10);
            }
        }
    }

    public f(zn.b bVar, zn.b bVar2) {
        this.f26476b = bVar;
        this.f26477c = bVar2;
    }

    public cs.f b(np.c cVar) throws OperatorCreationException {
        e0 e0VarC = c(this.f26476b, this.f26477c);
        SecureRandom secureRandom = this.f26475a;
        if (secureRandom != null) {
            e0VarC.a(true, new w1(cVar, secureRandom));
        } else {
            e0VarC.a(true, cVar);
        }
        return new a(e0VarC);
    }

    public abstract e0 c(zn.b bVar, zn.b bVar2) throws OperatorCreationException;

    public f d(SecureRandom secureRandom) {
        this.f26475a = secureRandom;
        return this;
    }
}
