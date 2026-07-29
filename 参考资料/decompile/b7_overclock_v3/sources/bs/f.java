package bs;

import cs.s;
import cs.t;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Strings;
import pn.k;
import pn.m;
import pn.o;
import pn.p;
import pn.q;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f9593a = new org.bouncycastle.jcajce.util.c();

    public class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f9594a;

        /* JADX INFO: renamed from: bs.f$a$a, reason: collision with other inner class name */
        public class C0099a implements org.bouncycastle.crypto.i {
            public C0099a() {
            }

            @Override // org.bouncycastle.crypto.i
            public byte[] convert(char[] cArr) {
                return Strings.j(cArr);
            }

            @Override // org.bouncycastle.crypto.i
            public String getType() {
                return "ASCII";
            }
        }

        public class b implements s {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ zn.b f9597a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Cipher f9598b;

            public b(zn.b bVar, Cipher cipher) {
                this.f9597a = bVar;
                this.f9598b = cipher;
            }

            @Override // cs.s
            public zn.b a() {
                return this.f9597a;
            }

            @Override // cs.s
            public InputStream b(InputStream inputStream) {
                return new lq.a(inputStream, this.f9598b);
            }
        }

        public a(char[] cArr) {
            this.f9594a = cArr;
        }

        @Override // cs.t
        public s a(zn.b bVar) throws OperatorCreationException {
            Cipher cipherI;
            Key pBKDF1KeyWithParameters;
            try {
                if (j.k(bVar.x())) {
                    p pVarY = p.y(bVar.A());
                    m mVarZ = pVarY.z();
                    k kVarX = pVarY.x();
                    q qVar = (q) mVarZ.z();
                    int iIntValue = qVar.y().intValue();
                    byte[] bArrB = qVar.B();
                    String strL = kVarX.x().L();
                    SecretKey secretKeyB = j.h(qVar.A()) ? j.b(f.this.f9593a, strL, this.f9594a, bArrB, iIntValue) : j.c(f.this.f9593a, strL, this.f9594a, bArrB, iIntValue, qVar.A());
                    cipherI = f.this.f9593a.i(strL);
                    AlgorithmParameters algorithmParametersT = f.this.f9593a.t(strL);
                    algorithmParametersT.init(kVarX.z().b().getEncoded());
                    cipherI.init(2, secretKeyB, algorithmParametersT);
                } else {
                    if (j.i(bVar.x())) {
                        r rVarY = r.y(bVar.A());
                        cipherI = f.this.f9593a.i(bVar.x().L());
                        pBKDF1KeyWithParameters = new PKCS12KeyWithParameters(this.f9594a, rVarY.x(), rVarY.z().intValue());
                    } else {
                        if (!j.j(bVar.x())) {
                            throw new PEMException("Unknown algorithm: " + bVar.x());
                        }
                        o oVarX = o.x(bVar.A());
                        cipherI = f.this.f9593a.i(bVar.x().L());
                        pBKDF1KeyWithParameters = new PBKDF1KeyWithParameters(this.f9594a, new C0099a(), oVarX.z(), oVarX.y().intValue());
                    }
                    cipherI.init(2, pBKDF1KeyWithParameters);
                }
                return new b(bVar, cipherI);
            } catch (IOException e10) {
                throw new OperatorCreationException(bVar.x() + " not available: " + e10.getMessage(), e10);
            } catch (GeneralSecurityException e11) {
                throw new OperatorCreationException(bVar.x() + " not available: " + e11.getMessage(), e11);
            }
        }
    }

    public t b(char[] cArr) throws OperatorCreationException {
        return new a(cArr);
    }

    public f c(String str) {
        this.f9593a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public f d(Provider provider) {
        this.f9593a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
