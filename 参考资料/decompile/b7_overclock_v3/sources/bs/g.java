package bs;

import cs.d0;
import cs.q;
import gm.c0;
import gm.d2;
import gm.f2;
import gm.j2;
import gm.t;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.operator.OperatorCreationException;
import pn.k;
import pn.m;
import pn.p;
import pn.r;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9600l = kn.d.f37625y.L();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9601m = kn.d.G.L();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9602n = kn.d.O.L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9603o = s.Z3.L();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9604p = s.f46814i6.L();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9605q = s.f46817j6.L();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9606r = s.f46820k6.L();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9607s = s.f46823l6.L();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f9608t = s.f46826m6.L();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9609u = s.f46829n6.L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AlgorithmParameters f9611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f9612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f9613d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Cipher f9615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f9616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AlgorithmParameterGenerator f9617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public char[] f9618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SecretKey f9619j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f9610a = new org.bouncycastle.jcajce.util.c();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zn.b f9620k = new zn.b(s.f46806g4, d2.f29657b);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9614e = 2048;

    public class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f9621a;

        public a(zn.b bVar) {
            this.f9621a = bVar;
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f9621a;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return new lq.b(outputStream, g.this.f9615f);
        }

        @Override // cs.d0
        public q getKey() {
            return new org.bouncycastle.operator.jcajce.g(this.f9621a, g.this.f9619j);
        }
    }

    public g(y yVar) {
        this.f9612c = yVar;
    }

    public d0 c() throws OperatorCreationException {
        zn.b bVar;
        if (this.f9616g == null) {
            this.f9616g = new SecureRandom();
        }
        try {
            this.f9615f = this.f9610a.i(this.f9612c.L());
            if (j.k(this.f9612c)) {
                this.f9617h = this.f9610a.q(this.f9612c.L());
            }
            if (j.k(this.f9612c)) {
                byte[] bArr = new byte[j.g(this.f9620k.x())];
                this.f9613d = bArr;
                this.f9616g.nextBytes(bArr);
                AlgorithmParameters algorithmParametersGenerateParameters = this.f9617h.generateParameters();
                this.f9611b = algorithmParametersGenerateParameters;
                try {
                    k kVar = new k(this.f9612c, c0.D(algorithmParametersGenerateParameters.getEncoded()));
                    m mVar = new m(s.X3, new pn.q(this.f9613d, this.f9614e, this.f9620k));
                    gm.i iVar = new gm.i();
                    iVar.a(mVar);
                    iVar.a(kVar);
                    bVar = new zn.b(s.W3, p.y(new j2(iVar)));
                    try {
                        this.f9619j = j.h(this.f9620k) ? j.b(this.f9610a, this.f9612c.L(), this.f9618i, this.f9613d, this.f9614e) : j.c(this.f9610a, this.f9612c.L(), this.f9618i, this.f9613d, this.f9614e, this.f9620k);
                        this.f9615f.init(1, this.f9619j, this.f9611b);
                    } catch (GeneralSecurityException e10) {
                        throw new OperatorCreationException(e10.getMessage(), e10);
                    }
                } catch (IOException e11) {
                    throw new OperatorCreationException(e11.getMessage(), e11);
                }
            } else {
                if (!j.i(this.f9612c)) {
                    throw new OperatorCreationException("unknown algorithm: " + this.f9612c, null);
                }
                gm.i iVar2 = new gm.i();
                byte[] bArr2 = new byte[20];
                this.f9613d = bArr2;
                this.f9616g.nextBytes(bArr2);
                iVar2.a(new f2(this.f9613d));
                iVar2.a(new t(this.f9614e));
                zn.b bVar2 = new zn.b(this.f9612c, r.y(new j2(iVar2)));
                try {
                    this.f9615f.init(1, new PKCS12KeyWithParameters(this.f9618i, this.f9613d, this.f9614e));
                    bVar = bVar2;
                } catch (GeneralSecurityException e12) {
                    throw new OperatorCreationException(e12.getMessage(), e12);
                }
            }
            return new a(bVar);
        } catch (GeneralSecurityException e13) {
            throw new OperatorCreationException(this.f9612c + " not available: " + e13.getMessage(), e13);
        }
    }

    public g d(int i10) {
        this.f9614e = i10;
        return this;
    }

    public g e(zn.b bVar) {
        this.f9620k = bVar;
        return this;
    }

    public g f(char[] cArr) {
        this.f9618i = cArr;
        return this;
    }

    public g g(char[] cArr) {
        this.f9618i = cArr;
        return this;
    }

    public g h(String str) {
        this.f9610a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public g i(Provider provider) {
        this.f9610a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }

    public g j(SecureRandom secureRandom) {
        this.f9616g = secureRandom;
        return this;
    }
}
