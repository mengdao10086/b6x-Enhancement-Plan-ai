package yq;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Enumeration;
import org.bouncycastle.jcajce.util.d;

/* JADX INFO: loaded from: classes7.dex */
public class a extends KeyStoreSpi {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f57474d = "keystore.type.compat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f57475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyStoreSpi f57476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KeyStoreSpi f57477c;

    public a(d dVar, KeyStoreSpi keyStoreSpi) {
        this.f57475a = new b(dVar);
        this.f57476b = keyStoreSpi;
        this.f57477c = keyStoreSpi;
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return this.f57477c.engineAliases();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return this.f57477c.engineContainsAlias(str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        this.f57477c.engineDeleteEntry(str);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        return this.f57477c.engineGetCertificate(str);
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        return this.f57477c.engineGetCertificateAlias(certificate);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        return this.f57477c.engineGetCertificateChain(str);
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        return this.f57477c.engineGetCreationDate(str);
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return this.f57477c.engineGetKey(str, cArr);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.f57477c.engineIsCertificateEntry(str);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.f57477c.engineIsKeyEntry(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineLoad(java.io.InputStream r3, char[] r4) throws java.security.NoSuchAlgorithmException, java.io.IOException, java.security.cert.CertificateException {
        /*
            r2 = this;
            if (r3 != 0) goto Lb
            java.security.KeyStoreSpi r3 = r2.f57476b
            r2.f57477c = r3
            r0 = 0
            r3.engineLoad(r0, r4)
            goto L45
        Lb:
            java.lang.String r0 = "keystore.type.compat"
            boolean r0 = org.bouncycastle.util.p.d(r0)
            if (r0 != 0) goto L1d
            java.security.KeyStoreSpi r0 = r2.f57476b
            boolean r1 = r0 instanceof xq.a
            if (r1 != 0) goto L1a
            goto L1d
        L1a:
            r2.f57477c = r0
            goto L40
        L1d:
            boolean r0 = r3.markSupported()
            if (r0 != 0) goto L29
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            r0.<init>(r3)
            r3 = r0
        L29:
            r0 = 8
            r3.mark(r0)
            yq.b r0 = r2.f57475a
            boolean r0 = r0.engineProbe(r3)
            if (r0 == 0) goto L39
            yq.b r0 = r2.f57475a
            goto L3b
        L39:
            java.security.KeyStoreSpi r0 = r2.f57476b
        L3b:
            r2.f57477c = r0
            r3.reset()
        L40:
            java.security.KeyStoreSpi r0 = r2.f57477c
            r0.engineLoad(r3, r4)
        L45:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: yq.a.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        this.f57477c.engineLoad(loadStoreParameter);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineProbe(InputStream inputStream) throws IOException {
        KeyStoreSpi keyStoreSpi = this.f57477c;
        if (keyStoreSpi instanceof xq.a) {
            return ((xq.a) keyStoreSpi).engineProbe(inputStream);
        }
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        this.f57477c.engineSetCertificateEntry(str, certificate);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        this.f57477c.engineSetKeyEntry(str, key, cArr, certificateArr);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        this.f57477c.engineSetKeyEntry(str, bArr, certificateArr);
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f57477c.engineSize();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
        this.f57477c.engineStore(outputStream, cArr);
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        this.f57477c.engineStore(loadStoreParameter);
    }
}
