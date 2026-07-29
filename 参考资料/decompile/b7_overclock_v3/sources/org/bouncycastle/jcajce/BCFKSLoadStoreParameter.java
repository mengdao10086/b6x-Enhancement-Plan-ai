package org.bouncycastle.jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.crypto.util.i;
import org.bouncycastle.crypto.util.j;

/* JADX INFO: loaded from: classes7.dex */
public class BCFKSLoadStoreParameter extends jq.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f44859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EncryptionAlgorithm f44860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MacAlgorithm f44861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SignatureAlgorithm f44862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Key f44863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final X509Certificate[] f44864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f44865j;

    public enum EncryptionAlgorithm {
        AES256_CCM,
        AES256_KWP
    }

    public enum MacAlgorithm {
        HmacSHA512,
        HmacSHA3_512
    }

    public enum SignatureAlgorithm {
        SHA512withDSA,
        SHA3_512withDSA,
        SHA512withECDSA,
        SHA3_512withECDSA,
        SHA512withRSA,
        SHA3_512withRSA
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f44866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f44867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final KeyStore.ProtectionParameter f44868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Key f44869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public j f44870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EncryptionAlgorithm f44871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public MacAlgorithm f44872g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public SignatureAlgorithm f44873h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public X509Certificate[] f44874i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public c f44875j;

        public b() {
            this((OutputStream) null, (KeyStore.ProtectionParameter) null);
        }

        public b(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.f44870e = new i.b().e(16384).g(64).f(i.f44744g).d();
            this.f44871f = EncryptionAlgorithm.AES256_CCM;
            this.f44872g = MacAlgorithm.HmacSHA512;
            this.f44873h = SignatureAlgorithm.SHA512withECDSA;
            this.f44874i = null;
            this.f44867b = inputStream;
            this.f44866a = null;
            this.f44868c = protectionParameter;
            this.f44869d = null;
        }

        public b(InputStream inputStream, PublicKey publicKey) {
            this.f44870e = new i.b().e(16384).g(64).f(i.f44744g).d();
            this.f44871f = EncryptionAlgorithm.AES256_CCM;
            this.f44872g = MacAlgorithm.HmacSHA512;
            this.f44873h = SignatureAlgorithm.SHA512withECDSA;
            this.f44874i = null;
            this.f44867b = inputStream;
            this.f44866a = null;
            this.f44868c = null;
            this.f44869d = publicKey;
        }

        public b(InputStream inputStream, c cVar) {
            this.f44870e = new i.b().e(16384).g(64).f(i.f44744g).d();
            this.f44871f = EncryptionAlgorithm.AES256_CCM;
            this.f44872g = MacAlgorithm.HmacSHA512;
            this.f44873h = SignatureAlgorithm.SHA512withECDSA;
            this.f44874i = null;
            this.f44867b = inputStream;
            this.f44866a = null;
            this.f44868c = null;
            this.f44875j = cVar;
            this.f44869d = null;
        }

        public b(InputStream inputStream, char[] cArr) {
            this(inputStream, new KeyStore.PasswordProtection(cArr));
        }

        public b(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.f44870e = new i.b().e(16384).g(64).f(i.f44744g).d();
            this.f44871f = EncryptionAlgorithm.AES256_CCM;
            this.f44872g = MacAlgorithm.HmacSHA512;
            this.f44873h = SignatureAlgorithm.SHA512withECDSA;
            this.f44874i = null;
            this.f44867b = null;
            this.f44866a = outputStream;
            this.f44868c = protectionParameter;
            this.f44869d = null;
        }

        public b(OutputStream outputStream, PrivateKey privateKey) {
            this.f44870e = new i.b().e(16384).g(64).f(i.f44744g).d();
            this.f44871f = EncryptionAlgorithm.AES256_CCM;
            this.f44872g = MacAlgorithm.HmacSHA512;
            this.f44873h = SignatureAlgorithm.SHA512withECDSA;
            this.f44874i = null;
            this.f44867b = null;
            this.f44866a = outputStream;
            this.f44868c = null;
            this.f44869d = privateKey;
        }

        public b(OutputStream outputStream, char[] cArr) {
            this(outputStream, new KeyStore.PasswordProtection(cArr));
        }

        public BCFKSLoadStoreParameter k() {
            return new BCFKSLoadStoreParameter(this);
        }

        public b l(X509Certificate[] x509CertificateArr) {
            int length = x509CertificateArr.length;
            X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
            System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
            this.f44874i = x509CertificateArr2;
            return this;
        }

        public b m(EncryptionAlgorithm encryptionAlgorithm) {
            this.f44871f = encryptionAlgorithm;
            return this;
        }

        public b n(MacAlgorithm macAlgorithm) {
            this.f44872g = macAlgorithm;
            return this;
        }

        public b o(j jVar) {
            this.f44870e = jVar;
            return this;
        }

        public b p(SignatureAlgorithm signatureAlgorithm) {
            this.f44873h = signatureAlgorithm;
            return this;
        }
    }

    public interface c {
        boolean a(X509Certificate[] x509CertificateArr);
    }

    public BCFKSLoadStoreParameter(b bVar) {
        super(bVar.f44867b, bVar.f44866a, bVar.f44868c);
        this.f44859d = bVar.f44870e;
        this.f44860e = bVar.f44871f;
        this.f44861f = bVar.f44872g;
        this.f44862g = bVar.f44873h;
        this.f44863h = bVar.f44869d;
        this.f44864i = bVar.f44874i;
        this.f44865j = bVar.f44875j;
    }

    public c c() {
        return this.f44865j;
    }

    public X509Certificate[] d() {
        return this.f44864i;
    }

    public EncryptionAlgorithm e() {
        return this.f44860e;
    }

    public MacAlgorithm f() {
        return this.f44861f;
    }

    public j g() {
        return this.f44859d;
    }

    public SignatureAlgorithm h() {
        return this.f44862g;
    }

    public Key i() {
        return this.f44863h;
    }
}
