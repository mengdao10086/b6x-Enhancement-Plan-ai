package gs;

import cs.q;
import cs.y;
import gm.d2;
import java.io.OutputStream;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.operator.OperatorCreationException;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class f implements es.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f29988a = new org.bouncycastle.jcajce.util.c();

    public class a implements es.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f29989a;

        /* JADX INFO: renamed from: gs.f$a$a, reason: collision with other inner class name */
        public class C0352a implements y {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ gm.y f29991a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r f29992b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Mac f29993c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ SecretKey f29994d;

            public C0352a(gm.y yVar, r rVar, Mac mac, SecretKey secretKey) {
                this.f29991a = yVar;
                this.f29992b = rVar;
                this.f29993c = mac;
                this.f29994d = secretKey;
            }

            @Override // cs.y
            public zn.b a() {
                return new zn.b(this.f29991a, this.f29992b);
            }

            @Override // cs.y
            public OutputStream b() {
                return new lq.d(this.f29993c);
            }

            @Override // cs.y
            public byte[] d() {
                return this.f29993c.doFinal();
            }

            @Override // cs.y
            public q getKey() {
                return new q(a(), this.f29994d.getEncoded());
            }
        }

        public a(zn.b bVar) {
            this.f29989a = bVar;
        }

        @Override // es.d
        public zn.b a() {
            return new zn.b(this.f29989a.x(), d2.f29657b);
        }

        @Override // es.d
        public y b(char[] cArr) throws OperatorCreationException {
            r rVarY = r.y(this.f29989a.A());
            try {
                gm.y yVarX = this.f29989a.x();
                Mac macN = f.this.f29988a.n(yVarX.L());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(rVarY.x(), rVarY.z().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr);
                macN.init(pKCS12Key, pBEParameterSpec);
                return new C0352a(yVarX, rVarY, macN, pKCS12Key);
            } catch (Exception e10) {
                throw new OperatorCreationException("unable to create MAC calculator: " + e10.getMessage(), e10);
            }
        }
    }

    @Override // es.e
    public es.d a(zn.b bVar) {
        return new a(bVar);
    }

    public f c(String str) {
        this.f29988a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public f d(Provider provider) {
        this.f29988a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
