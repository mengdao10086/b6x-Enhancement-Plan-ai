package gs;

import cr.j;
import cs.f0;
import cs.k;
import cs.s;
import cs.t;
import gm.y;
import gm.z;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.jcajce.PBKDF1Key;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.operator.OperatorCreationException;
import pn.o;
import pn.p;
import pn.q;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f29996a = new org.bouncycastle.jcajce.util.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29997b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f29998c = k.f25889a;

    public class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cipher f29999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public zn.b f30000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ char[] f30001c;

        /* JADX INFO: renamed from: gs.g$a$a, reason: collision with other inner class name */
        public class C0353a implements s {
            public C0353a() {
            }

            @Override // cs.s
            public zn.b a() {
                return a.this.f30000b;
            }

            @Override // cs.s
            public InputStream b(InputStream inputStream) {
                return new lq.a(inputStream, a.this.f29999a);
            }
        }

        public a(char[] cArr) {
            this.f30001c = cArr;
        }

        @Override // cs.t
        public s a(zn.b bVar) throws OperatorCreationException {
            SecretKey secretKeyGenerateSecret;
            y yVarX = bVar.x();
            try {
                if (yVarX.Q(pn.s.f46811h6)) {
                    r rVarY = r.y(bVar.A());
                    Cipher cipherI = g.this.f29996a.i(yVarX.L());
                    this.f29999a = cipherI;
                    cipherI.init(2, new PKCS12KeyWithParameters(this.f30001c, g.this.f29997b, rVarY.x(), rVarY.z().intValue()));
                    this.f30000b = bVar;
                } else if (yVarX.C(pn.s.W3)) {
                    p pVarY = p.y(bVar.A());
                    if (in.c.M.C(pVarY.z().x())) {
                        in.f fVarZ = in.f.z(pVarY.z().z());
                        secretKeyGenerateSecret = g.this.f29996a.u("SCRYPT").generateSecret(new cr.t(this.f30001c, fVarZ.C(), fVarZ.y().intValue(), fVarZ.x().intValue(), fVarZ.B().intValue(), g.this.f29998c.a(zn.b.z(pVarY.x()))));
                    } else {
                        SecretKeyFactory secretKeyFactoryU = g.this.f29996a.u(pVarY.z().x().L());
                        q qVarX = q.x(pVarY.z().z());
                        zn.b bVarZ = zn.b.z(pVarY.x());
                        secretKeyGenerateSecret = qVarX.C() ? secretKeyFactoryU.generateSecret(new PBEKeySpec(this.f30001c, qVarX.B(), qVarX.y().intValue(), g.this.f29998c.a(bVarZ))) : secretKeyFactoryU.generateSecret(new cr.q(this.f30001c, qVarX.B(), qVarX.y().intValue(), g.this.f29998c.a(bVarZ), qVarX.A()));
                    }
                    this.f29999a = g.this.f29996a.i(pVarY.x().x().L());
                    this.f30000b = zn.b.z(pVarY.x());
                    gm.h hVarZ = pVarY.x().z();
                    if (hVarZ instanceof z) {
                        this.f29999a.init(2, secretKeyGenerateSecret, new IvParameterSpec(z.I(hVarZ).J()));
                    } else if ((hVarZ instanceof gm.f0) && g.this.f(pVarY.x())) {
                        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(pVarY.x().x().L());
                        algorithmParameters.init(((gm.f0) hVarZ).getEncoded());
                        this.f29999a.init(2, secretKeyGenerateSecret, algorithmParameters);
                    } else if (hVarZ == null) {
                        this.f29999a.init(2, secretKeyGenerateSecret);
                    } else {
                        qm.d dVarA = qm.d.A(hVarZ);
                        this.f29999a.init(2, secretKeyGenerateSecret, new j(dVarA.x(), dVarA.y()));
                    }
                } else {
                    if (!yVarX.C(pn.s.S3) && !yVarX.C(pn.s.U3)) {
                        throw new OperatorCreationException("unable to create InputDecryptor: algorithm " + yVarX + " unknown.");
                    }
                    o oVarX = o.x(bVar.A());
                    Cipher cipherI2 = g.this.f29996a.i(yVarX.L());
                    this.f29999a = cipherI2;
                    cipherI2.init(2, new PBKDF1Key(this.f30001c, PasswordConverter.ASCII), new PBEParameterSpec(oVarX.z(), oVarX.y().intValue()));
                }
                return new C0353a();
            } catch (Exception e10) {
                throw new OperatorCreationException("unable to create InputDecryptor: " + e10.getMessage(), e10);
            }
        }
    }

    public t e(char[] cArr) {
        return new a(cArr);
    }

    public final boolean f(gm.h hVar) {
        gm.h hVarA = zn.b.z(hVar).A();
        if (!(hVarA instanceof gm.f0)) {
            return false;
        }
        gm.f0 f0VarJ = gm.f0.J(hVarA);
        if (f0VarJ.size() == 2) {
            return f0VarJ.K(1) instanceof gm.t;
        }
        return false;
    }

    public g g(f0 f0Var) {
        this.f29998c = f0Var;
        return this;
    }

    public g h(String str) {
        this.f29996a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public g i(Provider provider) {
        this.f29996a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }

    public g j(boolean z10) {
        this.f29997b = z10;
        return this;
    }
}
