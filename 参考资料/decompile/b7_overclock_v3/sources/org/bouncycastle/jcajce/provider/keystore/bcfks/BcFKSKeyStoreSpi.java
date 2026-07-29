package org.bouncycastle.jcajce.provider.keystore.bcfks;

import co.r;
import fp.j0;
import fp.n0;
import gm.d2;
import gm.y;
import im.l;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAKey;
import java.security.interfaces.RSAKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import np.n1;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.bouncycastle.util.Strings;
import pn.k;
import pn.m;
import pn.p;
import pn.q;
import pn.s;
import pn.u;
import zn.o;
import zn.z1;
import zo.g0;
import zo.h0;

/* JADX INFO: loaded from: classes7.dex */
public class BcFKSKeyStoreSpi extends KeyStoreSpi {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, y> f45159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<y, String> f45160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final BigInteger f45161n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final BigInteger f45162o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final BigInteger f45163p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final BigInteger f45164q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f45165r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PublicKey f45166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BCFKSLoadStoreParameter.c f45167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45168c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zn.b f45171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f45172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zn.b f45173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Date f45174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Date f45175j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, im.f> f45169d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, PrivateKey> f45170e = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public y f45176k = kn.d.T;

    public static class ExtKeyStoreException extends KeyStoreException {
        private final Throwable cause;

        public ExtKeyStoreException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public class a implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f45177a;

        public a(Iterator it2) {
            this.f45177a = it2;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f45177a.hasNext();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return this.f45177a.next();
        }
    }

    public static class b extends BcFKSKeyStoreSpi {
        public b() {
            super(new org.bouncycastle.jcajce.util.c());
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class c extends yq.a {
        public c() {
            super(new org.bouncycastle.jcajce.util.c(), new BcFKSKeyStoreSpi(new org.bouncycastle.jcajce.util.c()));
        }
    }

    public static class d extends f {
        public d() {
            super(new org.bouncycastle.jcajce.util.c());
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class e extends yq.a {
        public e() {
            super(new org.bouncycastle.jcajce.util.c(), new BcFKSKeyStoreSpi(new org.bouncycastle.jcajce.util.c()));
        }
    }

    public static class f extends BcFKSKeyStoreSpi implements s, z1 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Map<String, byte[]> f45179s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final byte[] f45180t;

        public f(org.bouncycastle.jcajce.util.d dVar) {
            super(dVar);
            try {
                byte[] bArr = new byte[32];
                this.f45180t = bArr;
                dVar.e("DEFAULT").nextBytes(bArr);
                this.f45179s = new HashMap();
            } catch (GeneralSecurityException e10) {
                throw new IllegalArgumentException("can't create random - " + e10.toString());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineDeleteEntry(String str) throws KeyStoreException {
            throw new KeyStoreException("delete operation not supported in shared mode");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            try {
                byte[] bArrR = r(str, cArr);
                if (!this.f45179s.containsKey(str) || org.bouncycastle.util.a.I(this.f45179s.get(str), bArrR)) {
                    Key keyEngineGetKey = super.engineGetKey(str, cArr);
                    if (keyEngineGetKey != null && !this.f45179s.containsKey(str)) {
                        this.f45179s.put(str, bArrR);
                    }
                    return keyEngineGetKey;
                }
                throw new UnrecoverableKeyException("unable to recover key (" + str + ee.a.f26979d);
            } catch (InvalidKeyException e10) {
                throw new UnrecoverableKeyException("unable to recover key (" + str + "): " + e10.getMessage());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }

        public final byte[] r(String str, char[] cArr) throws NoSuchAlgorithmException, InvalidKeyException {
            return n0.i(cArr != null ? org.bouncycastle.util.a.B(Strings.n(cArr), Strings.m(str)) : org.bouncycastle.util.a.B(this.f45180t, Strings.m(str)), this.f45180t, 16384, 8, 1, 32);
        }
    }

    public static class g extends BcFKSKeyStoreSpi {
        public g() {
            super(new org.bouncycastle.jcajce.util.b());
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class h extends yq.a {
        public h() {
            super(new org.bouncycastle.jcajce.util.c(), new BcFKSKeyStoreSpi(new org.bouncycastle.jcajce.util.b()));
        }
    }

    public static class i extends f {
        public i() {
            super(new org.bouncycastle.jcajce.util.b());
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.f, org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class j extends yq.a {
        public j() {
            super(new org.bouncycastle.jcajce.util.b(), new BcFKSKeyStoreSpi(new org.bouncycastle.jcajce.util.b()));
        }
    }

    static {
        HashMap map = new HashMap();
        f45159l = map;
        HashMap map2 = new HashMap();
        f45160m = map2;
        y yVar = on.b.f44364h;
        map.put("DESEDE", yVar);
        map.put("TRIPLEDES", yVar);
        map.put("TDEA", yVar);
        map.put("HMACSHA1", s.f46806g4);
        map.put("HMACSHA224", s.f46809h4);
        map.put("HMACSHA256", s.f46812i4);
        map.put("HMACSHA384", s.f46815j4);
        map.put("HMACSHA512", s.f46818k4);
        map.put("SEED", gn.a.f29838a);
        map.put("CAMELLIA.128", mn.a.f41443a);
        map.put("CAMELLIA.192", mn.a.f41444b);
        map.put("CAMELLIA.256", mn.a.f41445c);
        map.put("ARIA.128", ln.a.f40038h);
        map.put("ARIA.192", ln.a.f40043m);
        map.put("ARIA.256", ln.a.f40048r);
        map2.put(s.f46854x3, "RSA");
        map2.put(r.f11174l0, "EC");
        map2.put(on.b.f44368l, "DH");
        map2.put(s.O3, "DH");
        map2.put(r.W0, "DSA");
        f45161n = BigInteger.valueOf(0L);
        f45162o = BigInteger.valueOf(1L);
        f45163p = BigInteger.valueOf(2L);
        f45164q = BigInteger.valueOf(3L);
        f45165r = BigInteger.valueOf(4L);
    }

    public BcFKSKeyStoreSpi(org.bouncycastle.jcajce.util.d dVar) {
        this.f45168c = dVar;
    }

    public static String n(y yVar) {
        String str = f45160m.get(yVar);
        return str != null ? str : yVar.L();
    }

    public final byte[] a(byte[] bArr, zn.b bVar, m mVar, char[] cArr) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        String strL = bVar.x().L();
        Mac macN = this.f45168c.n(strL);
        try {
            if (cArr == null) {
                cArr = new char[0];
            }
            macN.init(new SecretKeySpec(g(mVar, "INTEGRITY_CHECK", cArr, -1), strL));
            return macN.doFinal(bArr);
        } catch (InvalidKeyException e10) {
            throw new IOException("Cannot set up MAC calculation: " + e10.getMessage());
        }
    }

    public final Cipher b(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException {
        Cipher cipherI = this.f45168c.i(str);
        cipherI.init(1, new SecretKeySpec(bArr, m5.b.f40641c));
        return cipherI;
    }

    public final im.c c(pn.j jVar, Certificate[] certificateArr) throws CertificateEncodingException {
        o[] oVarArr = new o[certificateArr.length];
        for (int i10 = 0; i10 != certificateArr.length; i10++) {
            oVarArr[i10] = o.z(certificateArr[i10].getEncoded());
        }
        return new im.c(jVar, oVarArr);
    }

    public final Certificate d(Object obj) {
        org.bouncycastle.jcajce.util.d dVar = this.f45168c;
        if (dVar != null) {
            try {
                return dVar.s("X.509").generateCertificate(new ByteArrayInputStream(o.z(obj).getEncoded()));
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(o.z(obj).getEncoded()));
        } catch (Exception unused2) {
            return null;
        }
    }

    public final byte[] e(String str, zn.b bVar, char[] cArr, byte[] bArr) throws IOException {
        Cipher cipherI;
        AlgorithmParameters algorithmParametersT;
        if (!bVar.x().C(s.W3)) {
            throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
        }
        p pVarY = p.y(bVar.A());
        k kVarX = pVarY.x();
        try {
            if (kVarX.x().C(kn.d.T)) {
                cipherI = this.f45168c.i("AES/CCM/NoPadding");
                algorithmParametersT = this.f45168c.t("CCM");
                algorithmParametersT.init(cq.a.y(kVarX.z()).getEncoded());
            } else {
                if (!kVarX.x().C(kn.d.U)) {
                    throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");
                }
                cipherI = this.f45168c.i("AESKWP");
                algorithmParametersT = null;
            }
            m mVarZ = pVarY.z();
            if (cArr == null) {
                cArr = new char[0];
            }
            cipherI.init(2, new SecretKeySpec(g(mVarZ, str, cArr, 32), m5.b.f40641c), algorithmParametersT);
            return cipherI.doFinal(bArr);
        } catch (IOException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IOException(e11.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        return new a(new HashSet(this.f45169d.keySet()).iterator());
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        Objects.requireNonNull(str, "alias value is null");
        return this.f45169d.containsKey(str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        if (this.f45169d.get(str) == null) {
            return;
        }
        this.f45170e.remove(str);
        this.f45169d.remove(str);
        this.f45175j = new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        im.f fVar = this.f45169d.get(str);
        if (fVar == null) {
            return null;
        }
        if (fVar.D().equals(f45162o) || fVar.D().equals(f45164q)) {
            return d(im.c.z(fVar.z()).x()[0]);
        }
        if (fVar.D().equals(f45161n)) {
            return d(fVar.z());
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        try {
            byte[] encoded = certificate.getEncoded();
            for (String str : this.f45169d.keySet()) {
                im.f fVar = this.f45169d.get(str);
                if (fVar.D().equals(f45161n)) {
                    if (org.bouncycastle.util.a.g(fVar.z(), encoded)) {
                        return str;
                    }
                } else if (fVar.D().equals(f45162o) || fVar.D().equals(f45164q)) {
                    try {
                        if (org.bouncycastle.util.a.g(im.c.z(fVar.z()).x()[0].b().getEncoded(), encoded)) {
                            return str;
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        } catch (CertificateEncodingException unused2) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        im.f fVar = this.f45169d.get(str);
        if (fVar == null) {
            return null;
        }
        if (!fVar.D().equals(f45162o) && !fVar.D().equals(f45164q)) {
            return null;
        }
        o[] oVarArrX = im.c.z(fVar.z()).x();
        int length = oVarArrX.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i10 = 0; i10 != length; i10++) {
            x509CertificateArr[i10] = d(oVarArrX[i10]);
        }
        return x509CertificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        im.f fVar = this.f45169d.get(str);
        if (fVar == null) {
            return null;
        }
        try {
            return fVar.C().K();
        } catch (ParseException unused) {
            return new Date();
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws UnrecoverableKeyException, NoSuchAlgorithmException {
        im.f fVar = this.f45169d.get(str);
        if (fVar == null) {
            return null;
        }
        if (fVar.D().equals(f45162o) || fVar.D().equals(f45164q)) {
            PrivateKey privateKey = this.f45170e.get(str);
            if (privateKey != null) {
                return privateKey;
            }
            pn.j jVarZ = pn.j.z(im.c.z(fVar.z()).y());
            try {
                u uVarZ = u.z(e("PRIVATE_KEY_ENCRYPTION", jVarZ.y(), cArr, jVarZ.x()));
                PrivateKey privateKeyGeneratePrivate = this.f45168c.b(n(uVarZ.B().x())).generatePrivate(new PKCS8EncodedKeySpec(uVarZ.getEncoded()));
                this.f45170e.put(str, privateKeyGeneratePrivate);
                return privateKeyGeneratePrivate;
            } catch (Exception e10) {
                throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover private key (" + str + "): " + e10.getMessage());
            }
        }
        if (!fVar.D().equals(f45163p) && !fVar.D().equals(f45165r)) {
            throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + str + "): type not recognized");
        }
        im.d dVarY = im.d.y(fVar.z());
        try {
            l lVarX = l.x(e("SECRET_KEY_ENCRYPTION", dVarY.z(), cArr, dVarY.x()));
            return this.f45168c.u(lVarX.y().L()).generateSecret(new SecretKeySpec(lVarX.z(), lVarX.y().L()));
        } catch (Exception e11) {
            throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + str + "): " + e11.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        im.f fVar = this.f45169d.get(str);
        if (fVar != null) {
            return fVar.D().equals(f45161n);
        }
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        im.f fVar = this.f45169d.get(str);
        if (fVar == null) {
            return false;
        }
        BigInteger bigIntegerD = fVar.D();
        return bigIntegerD.equals(f45162o) || bigIntegerD.equals(f45163p) || bigIntegerD.equals(f45164q) || bigIntegerD.equals(f45165r);
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
        zn.b bVarA;
        gm.h hVarZ;
        PublicKey publicKey;
        im.i iVarZ;
        this.f45169d.clear();
        this.f45170e.clear();
        this.f45174i = null;
        this.f45175j = null;
        this.f45171f = null;
        if (inputStream == null) {
            Date date = new Date();
            this.f45174i = date;
            this.f45175j = date;
            this.f45166a = null;
            this.f45167b = null;
            this.f45171f = new zn.b(s.f46818k4, d2.f29657b);
            this.f45172g = h(s.X3, 64);
            return;
        }
        try {
            im.h hVarX = im.h.x(new gm.s(inputStream).n());
            im.j jVarY = hVarX.y();
            if (jVarY.z() == 0) {
                im.k kVarX = im.k.x(jVarY.y());
                this.f45171f = kVarX.z();
                this.f45172g = kVarX.A();
                bVarA = this.f45171f;
                try {
                    p(hVarX.z().b().getEncoded(), kVarX, cArr);
                } catch (NoSuchProviderException e10) {
                    throw new IOException(e10.getMessage());
                }
            } else {
                if (jVarY.z() != 1) {
                    throw new IOException("BCFKS KeyStore unable to recognize integrity check.");
                }
                im.m mVarY = im.m.y(jVarY.y());
                bVarA = mVarY.A();
                try {
                    o[] oVarArrX = mVarY.x();
                    if (this.f45167b == null) {
                        hVarZ = hVarX.z();
                        publicKey = this.f45166a;
                    } else {
                        if (oVarArrX == null) {
                            throw new IOException("validator specified but no certifcates in store");
                        }
                        CertificateFactory certificateFactoryS = this.f45168c.s("X.509");
                        int length = oVarArrX.length;
                        X509Certificate[] x509CertificateArr = new X509Certificate[length];
                        for (int i10 = 0; i10 != length; i10++) {
                            x509CertificateArr[i10] = (X509Certificate) certificateFactoryS.generateCertificate(new ByteArrayInputStream(oVarArrX[i10].getEncoded()));
                        }
                        if (!this.f45167b.a(x509CertificateArr)) {
                            throw new IOException("certificate chain in key store signature not valid");
                        }
                        hVarZ = hVarX.z();
                        publicKey = x509CertificateArr[0].getPublicKey();
                    }
                    q(hVarZ, mVarY, publicKey);
                } catch (GeneralSecurityException e11) {
                    throw new IOException("error verifying signature: " + e11.getMessage(), e11);
                }
            }
            gm.h hVarZ2 = hVarX.z();
            if (hVarZ2 instanceof im.b) {
                im.b bVar = (im.b) hVarZ2;
                iVarZ = im.i.z(e("STORE_ENCRYPTION", bVar.y(), cArr, bVar.x().J()));
            } else {
                iVarZ = im.i.z(hVarZ2);
            }
            try {
                this.f45174i = iVarZ.y().K();
                this.f45175j = iVarZ.B().K();
                if (!iVarZ.A().equals(bVarA)) {
                    throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
                }
                Iterator<gm.h> it2 = iVarZ.C().iterator();
                while (it2.hasNext()) {
                    im.f fVarB = im.f.B(it2.next());
                    this.f45169d.put(fVarB.A(), fVarB);
                }
            } catch (ParseException unused) {
                throw new IOException("BCFKS KeyStore unable to parse store data information.");
            }
        } catch (Exception e12) {
            throw new IOException(e12.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
            return;
        }
        if (!(loadStoreParameter instanceof BCFKSLoadStoreParameter)) {
            if (loadStoreParameter instanceof jq.b) {
                engineLoad(((jq.b) loadStoreParameter).a(), yq.c.a(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'parameter' of type " + loadStoreParameter.getClass().getName());
        }
        BCFKSLoadStoreParameter bCFKSLoadStoreParameter = (BCFKSLoadStoreParameter) loadStoreParameter;
        char[] cArrA = yq.c.a(bCFKSLoadStoreParameter);
        this.f45172g = i(bCFKSLoadStoreParameter.g(), 64);
        this.f45176k = bCFKSLoadStoreParameter.e() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? kn.d.T : kn.d.U;
        this.f45171f = bCFKSLoadStoreParameter.f() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new zn.b(s.f46818k4, d2.f29657b) : new zn.b(kn.d.f37618r, d2.f29657b);
        this.f45166a = (PublicKey) bCFKSLoadStoreParameter.i();
        this.f45167b = bCFKSLoadStoreParameter.c();
        this.f45173h = k(this.f45166a, bCFKSLoadStoreParameter.h());
        y yVar = this.f45176k;
        InputStream inputStreamA = bCFKSLoadStoreParameter.a();
        engineLoad(inputStreamA, cArrA);
        if (inputStreamA != null) {
            if (!o(bCFKSLoadStoreParameter.g(), this.f45172g) || !yVar.C(this.f45176k)) {
                throw new IOException("configuration parameters do not match existing store");
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        Date dateF;
        im.f fVar = this.f45169d.get(str);
        Date date = new Date();
        if (fVar == null) {
            dateF = date;
        } else {
            if (!fVar.D().equals(f45161n)) {
                throw new KeyStoreException("BCFKS KeyStore already has a key entry with alias " + str);
            }
            dateF = f(fVar, date);
        }
        try {
            this.f45169d.put(str, new im.f(f45161n, str, dateF, date, certificate.getEncoded(), null));
            this.f45175j = date;
        } catch (CertificateEncodingException e10) {
            throw new ExtKeyStoreException("BCFKS KeyStore unable to handle certificate: " + e10.getMessage(), e10);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        l lVar;
        im.d dVar;
        pn.j jVar;
        Date date = new Date();
        im.f fVar = this.f45169d.get(str);
        Date dateF = fVar != null ? f(fVar, date) : date;
        this.f45170e.remove(str);
        if (key instanceof PrivateKey) {
            if (certificateArr == null) {
                throw new KeyStoreException("BCFKS KeyStore requires a certificate chain for private key storage.");
            }
            try {
                byte[] encoded = key.getEncoded();
                m mVarH = h(s.X3, 32);
                if (cArr == null) {
                    cArr = new char[0];
                }
                byte[] bArrG = g(mVarH, "PRIVATE_KEY_ENCRYPTION", cArr, 32);
                y yVar = this.f45176k;
                y yVar2 = kn.d.T;
                if (yVar.C(yVar2)) {
                    Cipher cipherB = b("AES/CCM/NoPadding", bArrG);
                    jVar = new pn.j(new zn.b(s.W3, new p(mVarH, new k(yVar2, cq.a.y(cipherB.getParameters().getEncoded())))), cipherB.doFinal(encoded));
                } else {
                    jVar = new pn.j(new zn.b(s.W3, new p(mVarH, new k(kn.d.U))), b("AESKWP", bArrG).doFinal(encoded));
                }
                this.f45169d.put(str, new im.f(f45162o, str, dateF, date, c(jVar, certificateArr).getEncoded(), null));
            } catch (Exception e10) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e10.toString(), e10);
            }
        } else {
            if (!(key instanceof SecretKey)) {
                throw new KeyStoreException("BCFKS KeyStore unable to recognize key.");
            }
            if (certificateArr != null) {
                throw new KeyStoreException("BCFKS KeyStore cannot store certificate chain with secret key.");
            }
            try {
                byte[] encoded2 = key.getEncoded();
                m mVarH2 = h(s.X3, 32);
                if (cArr == null) {
                    cArr = new char[0];
                }
                byte[] bArrG2 = g(mVarH2, "SECRET_KEY_ENCRYPTION", cArr, 32);
                String strO = Strings.o(key.getAlgorithm());
                if (strO.indexOf(m5.b.f40641c) > -1) {
                    lVar = new l(kn.d.f37623w, encoded2);
                } else {
                    Map<String, y> map = f45159l;
                    y yVar3 = map.get(strO);
                    if (yVar3 != null) {
                        lVar = new l(yVar3, encoded2);
                    } else {
                        y yVar4 = map.get(strO + j3.b.f36044h + (encoded2.length * 8));
                        if (yVar4 == null) {
                            throw new KeyStoreException("BCFKS KeyStore cannot recognize secret key (" + strO + ") for storage.");
                        }
                        lVar = new l(yVar4, encoded2);
                    }
                }
                y yVar5 = this.f45176k;
                y yVar6 = kn.d.T;
                if (yVar5.C(yVar6)) {
                    Cipher cipherB2 = b("AES/CCM/NoPadding", bArrG2);
                    dVar = new im.d(new zn.b(s.W3, new p(mVarH2, new k(yVar6, cq.a.y(cipherB2.getParameters().getEncoded())))), cipherB2.doFinal(lVar.getEncoded()));
                } else {
                    dVar = new im.d(new zn.b(s.W3, new p(mVarH2, new k(kn.d.U))), b("AESKWP", bArrG2).doFinal(lVar.getEncoded()));
                }
                this.f45169d.put(str, new im.f(f45163p, str, dateF, date, dVar.getEncoded(), null));
            } catch (Exception e11) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e11.toString(), e11);
            }
        }
        this.f45175j = date;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        Date date = new Date();
        im.f fVar = this.f45169d.get(str);
        Date dateF = fVar != null ? f(fVar, date) : date;
        if (certificateArr != null) {
            try {
                pn.j jVarZ = pn.j.z(bArr);
                try {
                    this.f45170e.remove(str);
                    this.f45169d.put(str, new im.f(f45164q, str, dateF, date, c(jVarZ, certificateArr).getEncoded(), null));
                } catch (Exception e10) {
                    throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e10.toString(), e10);
                }
            } catch (Exception e11) {
                throw new ExtKeyStoreException("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", e11);
            }
        } else {
            try {
                this.f45169d.put(str, new im.f(f45165r, str, dateF, date, bArr, null));
            } catch (Exception e12) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e12.toString(), e12);
            }
        }
        this.f45175j = date;
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f45169d.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
        m mVar;
        BigInteger bigIntegerZ;
        if (this.f45174i == null) {
            throw new IOException("KeyStore not initialized");
        }
        im.b bVarM = m(this.f45171f, cArr);
        if (in.c.M.C(this.f45172g.x())) {
            in.f fVarZ = in.f.z(this.f45172g.z());
            mVar = this.f45172g;
            bigIntegerZ = fVarZ.A();
        } else {
            q qVarX = q.x(this.f45172g.z());
            mVar = this.f45172g;
            bigIntegerZ = qVarX.z();
        }
        this.f45172g = j(mVar, bigIntegerZ.intValue());
        try {
            outputStream.write(new im.h(bVarM, new im.j(new im.k(this.f45171f, this.f45172g, a(bVarM.getEncoded(), this.f45171f, this.f45172g, cArr)))).getEncoded());
            outputStream.flush();
        } catch (NoSuchProviderException e10) {
            throw new IOException("cannot calculate mac: " + e10.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        im.m mVar;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'parameter' arg cannot be null");
        }
        if (loadStoreParameter instanceof jq.a) {
            jq.a aVar = (jq.a) loadStoreParameter;
            char[] cArrA = yq.c.a(loadStoreParameter);
            this.f45172g = i(aVar.b(), 64);
            engineStore(aVar.a(), cArrA);
            return;
        }
        if (!(loadStoreParameter instanceof BCFKSLoadStoreParameter)) {
            if (loadStoreParameter instanceof jq.b) {
                engineStore(((jq.b) loadStoreParameter).b(), yq.c.a(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'parameter' of type " + loadStoreParameter.getClass().getName());
        }
        BCFKSLoadStoreParameter bCFKSLoadStoreParameter = (BCFKSLoadStoreParameter) loadStoreParameter;
        if (bCFKSLoadStoreParameter.i() == null) {
            char[] cArrA2 = yq.c.a(bCFKSLoadStoreParameter);
            this.f45172g = i(bCFKSLoadStoreParameter.g(), 64);
            this.f45176k = bCFKSLoadStoreParameter.e() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? kn.d.T : kn.d.U;
            this.f45171f = bCFKSLoadStoreParameter.f() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new zn.b(s.f46818k4, d2.f29657b) : new zn.b(kn.d.f37618r, d2.f29657b);
            engineStore(bCFKSLoadStoreParameter.b(), cArrA2);
            return;
        }
        this.f45173h = k(bCFKSLoadStoreParameter.i(), bCFKSLoadStoreParameter.h());
        this.f45172g = i(bCFKSLoadStoreParameter.g(), 64);
        this.f45176k = bCFKSLoadStoreParameter.e() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? kn.d.T : kn.d.U;
        this.f45171f = bCFKSLoadStoreParameter.f() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new zn.b(s.f46818k4, d2.f29657b) : new zn.b(kn.d.f37618r, d2.f29657b);
        im.b bVarM = m(this.f45173h, yq.c.a(bCFKSLoadStoreParameter));
        try {
            Signature signatureA = this.f45168c.a(this.f45173h.x().L());
            signatureA.initSign((PrivateKey) bCFKSLoadStoreParameter.i());
            signatureA.update(bVarM.getEncoded());
            X509Certificate[] x509CertificateArrD = bCFKSLoadStoreParameter.d();
            if (x509CertificateArrD != null) {
                int length = x509CertificateArrD.length;
                o[] oVarArr = new o[length];
                for (int i10 = 0; i10 != length; i10++) {
                    oVarArr[i10] = o.z(x509CertificateArrD[i10].getEncoded());
                }
                mVar = new im.m(this.f45173h, oVarArr, signatureA.sign());
            } else {
                mVar = new im.m(this.f45173h, signatureA.sign());
            }
            bCFKSLoadStoreParameter.b().write(new im.h(bVarM, new im.j(mVar)).getEncoded());
            bCFKSLoadStoreParameter.b().flush();
        } catch (GeneralSecurityException e10) {
            throw new IOException("error creating signature: " + e10.getMessage(), e10);
        }
    }

    public final Date f(im.f fVar, Date date) {
        try {
            return fVar.y().K();
        } catch (ParseException unused) {
            return date;
        }
    }

    public final byte[] g(m mVar, String str, char[] cArr, int i10) throws IOException {
        byte[] bArrA = c0.a(cArr);
        byte[] bArrA2 = c0.a(str.toCharArray());
        if (in.c.M.C(mVar.x())) {
            in.f fVarZ = in.f.z(mVar.z());
            if (fVarZ.A() != null) {
                i10 = fVarZ.A().intValue();
            } else if (i10 == -1) {
                throw new IOException("no keyLength found in ScryptParams");
            }
            return n0.i(org.bouncycastle.util.a.B(bArrA, bArrA2), fVarZ.C(), fVarZ.y().intValue(), fVarZ.x().intValue(), fVarZ.x().intValue(), i10);
        }
        if (!mVar.x().C(s.X3)) {
            throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
        }
        q qVarX = q.x(mVar.z());
        if (qVarX.z() != null) {
            i10 = qVarX.z().intValue();
        } else if (i10 == -1) {
            throw new IOException("no keyLength found in PBKDF2Params");
        }
        if (qVarX.A().x().C(s.f46818k4)) {
            j0 j0Var = new j0(new h0());
            j0Var.j(org.bouncycastle.util.a.B(bArrA, bArrA2), qVarX.B(), qVarX.y().intValue());
            return ((n1) j0Var.e(i10 * 8)).a();
        }
        if (qVarX.A().x().C(kn.d.f37618r)) {
            j0 j0Var2 = new j0(new g0(512));
            j0Var2.j(org.bouncycastle.util.a.B(bArrA, bArrA2), qVarX.B(), qVarX.y().intValue());
            return ((n1) j0Var2.e(i10 * 8)).a();
        }
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF: " + qVarX.A().x());
    }

    public final m h(y yVar, int i10) {
        byte[] bArr = new byte[64];
        l().nextBytes(bArr);
        y yVar2 = s.X3;
        if (yVar2.C(yVar)) {
            return new m(yVar2, new q(bArr, xq.a.f55765p, i10, new zn.b(s.f46818k4, d2.f29657b)));
        }
        throw new IllegalStateException("unknown derivation algorithm: " + yVar);
    }

    public final m i(org.bouncycastle.crypto.util.j jVar, int i10) {
        y yVar = in.c.M;
        if (yVar.C(jVar.a())) {
            org.bouncycastle.crypto.util.q qVar = (org.bouncycastle.crypto.util.q) jVar;
            byte[] bArr = new byte[qVar.e()];
            l().nextBytes(bArr);
            return new m(yVar, new in.f(bArr, qVar.c(), qVar.b(), qVar.d(), i10));
        }
        org.bouncycastle.crypto.util.i iVar = (org.bouncycastle.crypto.util.i) jVar;
        byte[] bArr2 = new byte[iVar.d()];
        l().nextBytes(bArr2);
        return new m(s.X3, new q(bArr2, iVar.b(), i10, iVar.c()));
    }

    public final m j(m mVar, int i10) {
        y yVar = in.c.M;
        boolean zC = yVar.C(mVar.x());
        gm.h hVarZ = mVar.z();
        if (zC) {
            in.f fVarZ = in.f.z(hVarZ);
            byte[] bArr = new byte[fVarZ.C().length];
            l().nextBytes(bArr);
            return new m(yVar, new in.f(bArr, fVarZ.y(), fVarZ.x(), fVarZ.B(), BigInteger.valueOf(i10)));
        }
        q qVarX = q.x(hVarZ);
        byte[] bArr2 = new byte[qVarX.B().length];
        l().nextBytes(bArr2);
        return new m(s.X3, new q(bArr2, qVarX.y().intValue(), i10, qVarX.A()));
    }

    public final zn.b k(Key key, BCFKSLoadStoreParameter.SignatureAlgorithm signatureAlgorithm) throws IOException {
        if (key == null) {
            return null;
        }
        if (key instanceof er.b) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withECDSA) {
                return new zn.b(r.f11184q0);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withECDSA) {
                return new zn.b(kn.d.f37605i0);
            }
        }
        if (key instanceof DSAKey) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withDSA) {
                return new zn.b(kn.d.f37589a0);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withDSA) {
                return new zn.b(kn.d.f37597e0);
            }
        }
        if (key instanceof RSAKey) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withRSA) {
                return new zn.b(s.J3, d2.f29657b);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withRSA) {
                return new zn.b(kn.d.f37613m0, d2.f29657b);
            }
        }
        throw new IOException("unknown signature algorithm");
    }

    public final SecureRandom l() {
        return n.f();
    }

    public final im.b m(zn.b bVar, char[] cArr) throws NoSuchAlgorithmException, IOException {
        im.f[] fVarArr = (im.f[]) this.f45169d.values().toArray(new im.f[this.f45169d.size()]);
        m mVarJ = j(this.f45172g, 32);
        if (cArr == null) {
            cArr = new char[0];
        }
        byte[] bArrG = g(mVarJ, "STORE_ENCRYPTION", cArr, 32);
        im.i iVar = new im.i(bVar, this.f45174i, this.f45175j, new im.g(fVarArr), null);
        try {
            y yVar = this.f45176k;
            y yVar2 = kn.d.T;
            if (!yVar.C(yVar2)) {
                return new im.b(new zn.b(s.W3, new p(mVarJ, new k(kn.d.U))), b("AESKWP", bArrG).doFinal(iVar.getEncoded()));
            }
            Cipher cipherB = b("AES/CCM/NoPadding", bArrG);
            return new im.b(new zn.b(s.W3, new p(mVarJ, new k(yVar2, cq.a.y(cipherB.getParameters().getEncoded())))), cipherB.doFinal(iVar.getEncoded()));
        } catch (InvalidKeyException e10) {
            throw new IOException(e10.toString());
        } catch (NoSuchProviderException e11) {
            throw new IOException(e11.toString());
        } catch (BadPaddingException e12) {
            throw new IOException(e12.toString());
        } catch (IllegalBlockSizeException e13) {
            throw new IOException(e13.toString());
        } catch (NoSuchPaddingException e14) {
            throw new NoSuchAlgorithmException(e14.toString());
        }
    }

    public final boolean o(org.bouncycastle.crypto.util.j jVar, m mVar) {
        if (!jVar.a().C(mVar.x())) {
            return false;
        }
        if (in.c.M.C(mVar.x())) {
            if (!(jVar instanceof org.bouncycastle.crypto.util.q)) {
                return false;
            }
            org.bouncycastle.crypto.util.q qVar = (org.bouncycastle.crypto.util.q) jVar;
            in.f fVarZ = in.f.z(mVar.z());
            return qVar.e() == fVarZ.C().length && qVar.b() == fVarZ.x().intValue() && qVar.c() == fVarZ.y().intValue() && qVar.d() == fVarZ.B().intValue();
        }
        if (!(jVar instanceof org.bouncycastle.crypto.util.i)) {
            return false;
        }
        org.bouncycastle.crypto.util.i iVar = (org.bouncycastle.crypto.util.i) jVar;
        q qVarX = q.x(mVar.z());
        return iVar.d() == qVarX.B().length && iVar.b() == qVarX.y().intValue();
    }

    public final void p(byte[] bArr, im.k kVar, char[] cArr) throws NoSuchAlgorithmException, IOException, NoSuchProviderException {
        if (!org.bouncycastle.util.a.I(a(bArr, kVar.z(), kVar.A(), cArr), kVar.y())) {
            throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed");
        }
    }

    public final void q(gm.h hVar, im.m mVar, PublicKey publicKey) throws GeneralSecurityException, IOException {
        Signature signatureA = this.f45168c.a(mVar.A().x().L());
        signatureA.initVerify(publicKey);
        signatureA.update(hVar.b().v(gm.j.f29713a));
        if (!signatureA.verify(mVar.z().L())) {
            throw new IOException("BCFKS KeyStore corrupted: signature calculation failed");
        }
    }
}
