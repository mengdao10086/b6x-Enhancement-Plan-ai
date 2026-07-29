package gs;

import cr.t;
import cs.d0;
import cs.f0;
import cs.k;
import cs.q;
import gm.c0;
import gm.y;
import java.io.OutputStream;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.util.i;
import org.bouncycastle.crypto.util.j;
import org.bouncycastle.jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.operator.OperatorCreationException;
import pn.m;
import pn.p;
import pn.r;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f30004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f30005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f30006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f30007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f30008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f0 f30009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cs.b f30010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f30011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i.b f30012i;

    public class a implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f30013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Cipher f30014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ char[] f30015c;

        public a(zn.b bVar, Cipher cipher, char[] cArr) {
            this.f30013a = bVar;
            this.f30014b = cipher;
            this.f30015c = cArr;
        }

        @Override // cs.d0
        public zn.b a() {
            return this.f30013a;
        }

        @Override // cs.d0
        public OutputStream b(OutputStream outputStream) {
            return new lq.b(outputStream, this.f30014b);
        }

        @Override // cs.d0
        public q getKey() {
            return h.this.g(this.f30013a.x()) ? new q(this.f30013a, h.a(this.f30015c)) : new q(this.f30013a, h.b(this.f30015c));
        }
    }

    public h(y yVar) {
        this.f30005b = new org.bouncycastle.jcajce.util.c();
        this.f30009f = k.f25889a;
        this.f30010g = new cs.i();
        this.f30011h = 1024;
        this.f30012i = new i.b();
        this.f30004a = null;
        if (g(yVar)) {
            this.f30006c = yVar;
        } else {
            this.f30006c = s.W3;
        }
        this.f30007d = yVar;
    }

    public h(j jVar, y yVar) {
        this.f30005b = new org.bouncycastle.jcajce.util.c();
        this.f30009f = k.f25889a;
        this.f30010g = new cs.i();
        this.f30011h = 1024;
        this.f30012i = new i.b();
        this.f30006c = s.W3;
        this.f30004a = jVar;
        this.f30007d = yVar;
    }

    public static byte[] a(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i10 = 0; i10 != cArr.length; i10++) {
            int i11 = i10 * 2;
            bArr[i11] = (byte) (cArr[i10] >>> '\b');
            bArr[i11 + 1] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static byte[] b(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public d0 f(char[] cArr) throws OperatorCreationException {
        Cipher cipherI;
        zn.b bVar;
        Cipher cipherI2;
        if (this.f30008e == null) {
            this.f30008e = new SecureRandom();
        }
        try {
            if (g(this.f30006c)) {
                byte[] bArr = new byte[20];
                this.f30008e.nextBytes(bArr);
                cipherI2 = this.f30005b.i(this.f30006c.L());
                cipherI2.init(1, new PKCS12KeyWithParameters(cArr, bArr, this.f30011h));
                bVar = new zn.b(this.f30006c, new r(bArr, this.f30011h));
            } else {
                if (!this.f30006c.C(s.W3)) {
                    throw new OperatorCreationException("unrecognised algorithm");
                }
                j jVarD = this.f30004a;
                if (jVarD == null) {
                    jVarD = this.f30012i.d();
                }
                y yVar = in.c.M;
                if (yVar.C(jVarD.a())) {
                    org.bouncycastle.crypto.util.q qVar = (org.bouncycastle.crypto.util.q) jVarD;
                    byte[] bArr2 = new byte[qVar.e()];
                    this.f30008e.nextBytes(bArr2);
                    in.f fVar = new in.f(bArr2, qVar.c(), qVar.b(), qVar.d());
                    SecretKey secretKeyGenerateSecret = this.f30005b.u("SCRYPT").generateSecret(new t(cArr, bArr2, qVar.c(), qVar.b(), qVar.d(), this.f30009f.a(new zn.b(this.f30007d))));
                    cipherI = this.f30005b.i(this.f30007d.L());
                    cipherI.init(1, n(secretKeyGenerateSecret), this.f30008e);
                    bVar = new zn.b(this.f30006c, cipherI.getParameters() != null ? new p(new m(yVar, fVar), new pn.k(this.f30007d, c0.D(cipherI.getParameters().getEncoded()))) : new p(new m(yVar, fVar), new pn.k(this.f30007d)));
                } else {
                    org.bouncycastle.crypto.util.i iVar = (org.bouncycastle.crypto.util.i) jVarD;
                    byte[] bArr3 = new byte[iVar.d()];
                    this.f30008e.nextBytes(bArr3);
                    SecretKey secretKeyGenerateSecret2 = this.f30005b.u(i.a(iVar.c().x())).generateSecret(new PBEKeySpec(cArr, bArr3, iVar.b(), this.f30009f.a(new zn.b(this.f30007d))));
                    cipherI = this.f30005b.i(this.f30007d.L());
                    cipherI.init(1, n(secretKeyGenerateSecret2), this.f30008e);
                    bVar = new zn.b(this.f30006c, cipherI.getParameters() != null ? new p(new m(s.X3, new pn.q(bArr3, iVar.b(), iVar.c())), new pn.k(this.f30007d, c0.D(cipherI.getParameters().getEncoded()))) : new p(new m(s.X3, new pn.q(bArr3, iVar.b(), iVar.c())), new pn.k(this.f30007d)));
                }
                cipherI2 = cipherI;
            }
            return new a(bVar, cipherI2, cArr);
        } catch (Exception e10) {
            throw new OperatorCreationException("unable to create OutputEncryptor: " + e10.getMessage(), e10);
        }
    }

    public final boolean g(y yVar) {
        return yVar.Q(s.f46811h6) || yVar.Q(im.a.f32487i) || yVar.Q(im.a.f32489k);
    }

    public h h(int i10) {
        if (this.f30004a != null) {
            throw new IllegalStateException("set iteration count using PBKDFDef");
        }
        this.f30011h = i10;
        this.f30012i.e(i10);
        return this;
    }

    public h i(f0 f0Var) {
        this.f30009f = f0Var;
        return this;
    }

    public h j(zn.b bVar) {
        if (this.f30004a != null) {
            throw new IllegalStateException("set PRF count using PBKDFDef");
        }
        this.f30012i.f(bVar);
        return this;
    }

    public h k(String str) {
        this.f30005b = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public h l(Provider provider) {
        this.f30005b = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }

    public h m(SecureRandom secureRandom) {
        this.f30008e = secureRandom;
        return this;
    }

    public final SecretKey n(SecretKey secretKey) {
        return (!this.f30010g.a(this.f30007d) || this.f30010g.c(this.f30007d).indexOf(m5.b.f40641c) < 0) ? secretKey : new SecretKeySpec(secretKey.getEncoded(), m5.b.f40641c);
    }
}
