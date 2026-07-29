package gs;

import cs.q;
import gm.d2;
import gm.y;
import java.io.OutputStream;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.operator.OperatorCreationException;
import pn.r;

/* JADX INFO: loaded from: classes6.dex */
public class e implements es.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f29979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f29980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f29981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29983e;

    public class a implements cs.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f29984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Mac f29985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SecretKey f29986c;

        public a(byte[] bArr, Mac mac, SecretKey secretKey) {
            this.f29984a = bArr;
            this.f29985b = mac;
            this.f29986c = secretKey;
        }

        @Override // cs.y
        public zn.b a() {
            return new zn.b(e.this.f29980b, new r(this.f29984a, e.this.f29983e));
        }

        @Override // cs.y
        public OutputStream b() {
            return new lq.d(this.f29985b);
        }

        @Override // cs.y
        public byte[] d() {
            return this.f29985b.doFinal();
        }

        @Override // cs.y
        public q getKey() {
            return new q(a(), this.f29986c.getEncoded());
        }
    }

    public e() {
        this(on.b.f44365i);
    }

    public e(y yVar) {
        this.f29979a = new org.bouncycastle.jcajce.util.c();
        this.f29983e = 1024;
        this.f29980b = yVar;
    }

    @Override // es.d
    public zn.b a() {
        return new zn.b(this.f29980b, d2.f29657b);
    }

    @Override // es.d
    public cs.y b(char[] cArr) throws OperatorCreationException {
        if (this.f29981c == null) {
            this.f29981c = new SecureRandom();
        }
        try {
            Mac macN = this.f29979a.n(this.f29980b.L());
            int macLength = macN.getMacLength();
            this.f29982d = macLength;
            byte[] bArr = new byte[macLength];
            this.f29981c.nextBytes(bArr);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, this.f29983e);
            PKCS12Key pKCS12Key = new PKCS12Key(cArr);
            macN.init(pKCS12Key, pBEParameterSpec);
            return new a(bArr, macN, pKCS12Key);
        } catch (Exception e10) {
            throw new OperatorCreationException("unable to create MAC calculator: " + e10.getMessage(), e10);
        }
    }

    public e e(int i10) {
        this.f29983e = i10;
        return this;
    }

    public e f(String str) {
        this.f29979a = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public e g(Provider provider) {
        this.f29979a = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }
}
