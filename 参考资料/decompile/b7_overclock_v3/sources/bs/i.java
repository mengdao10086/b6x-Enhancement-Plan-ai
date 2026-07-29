package bs;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.openssl.PEMException;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f9629b = new org.bouncycastle.jcajce.util.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f9630c;

    public class a implements zr.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f9631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f9632b;

        public a(byte[] bArr, char[] cArr) {
            this.f9631a = bArr;
            this.f9632b = cArr;
        }

        @Override // zr.f
        public byte[] a(byte[] bArr) throws PEMException {
            return j.a(true, i.this.f9629b, bArr, this.f9632b, i.this.f9628a, this.f9631a);
        }

        @Override // zr.f
        public byte[] b() {
            return this.f9631a;
        }

        @Override // zr.f
        public String getAlgorithm() {
            return i.this.f9628a;
        }
    }

    public i(String str) {
        this.f9628a = str;
    }

    public zr.f c(char[] cArr) {
        if (this.f9630c == null) {
            this.f9630c = new SecureRandom();
        }
        byte[] bArr = new byte[this.f9628a.startsWith("AES-") ? 16 : 8];
        this.f9630c.nextBytes(bArr);
        return new a(bArr, cArr);
    }

    public i d(String str) {
        this.f9629b = new org.bouncycastle.jcajce.util.g(str);
        return this;
    }

    public i e(Provider provider) {
        this.f9629b = new org.bouncycastle.jcajce.util.i(provider);
        return this;
    }

    public i f(SecureRandom secureRandom) {
        this.f9630c = secureRandom;
        return this;
    }
}
