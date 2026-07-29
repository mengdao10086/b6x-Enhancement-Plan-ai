package xq;

import gm.d2;
import gm.e1;
import gm.f2;
import gm.i;
import gm.i1;
import gm.j2;
import gm.l2;
import gm.t1;
import gm.y;
import gm.z;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.j;
import pn.b0;
import pn.p;
import pn.q;
import pn.r;
import pn.s;
import pn.t;
import so.a0;
import zn.b1;
import zn.c1;
import zn.z1;

/* JADX INFO: loaded from: classes7.dex */
public class a extends KeyStoreSpi implements s, z1, er.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f55763n = "org.bouncycastle.pkcs12.max_it_count";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f55764o = 20;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f55765p = 51200;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g f55766q = new g();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f55767r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f55768s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f55769t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f55770u = 3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f55771v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f55772w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f55773x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f55774y = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f55776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f55777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f55778d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CertificateFactory f55782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y f55783i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y f55784j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f55775a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Hashtable f55779e = new Hashtable();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Hashtable f55780f = new Hashtable();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public SecureRandom f55781g = n.f();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zn.b f55785k = new zn.b(on.b.f44365i, d2.f29657b);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f55786l = 102400;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f55787m = 20;

    public static class b extends yq.a {
        public b() {
            org.bouncycastle.jcajce.util.b bVar = new org.bouncycastle.jcajce.util.b();
            org.bouncycastle.jcajce.util.b bVar2 = new org.bouncycastle.jcajce.util.b();
            y yVar = s.f46820k6;
            super(bVar, new a(bVar2, yVar, yVar));
        }
    }

    public static class c extends yq.a {
        public c() {
            super(new org.bouncycastle.jcajce.util.b(), new a(new org.bouncycastle.jcajce.util.b(), s.f46820k6, s.f46829n6));
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f55788a;

        public d(PublicKey publicKey) {
            this.f55788a = a.this.f(publicKey).A();
        }

        public d(byte[] bArr) {
            this.f55788a = bArr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                return org.bouncycastle.util.a.g(this.f55788a, ((d) obj).f55788a);
            }
            return false;
        }

        public int hashCode() {
            return org.bouncycastle.util.a.s0(this.f55788a);
        }
    }

    public static class e extends yq.a {
        public e() {
            org.bouncycastle.jcajce.util.c cVar = new org.bouncycastle.jcajce.util.c();
            org.bouncycastle.jcajce.util.c cVar2 = new org.bouncycastle.jcajce.util.c();
            y yVar = s.f46820k6;
            super(cVar, new a(cVar2, yVar, yVar));
        }
    }

    public static class f extends yq.a {
        public f() {
            super(new org.bouncycastle.jcajce.util.c(), new a(new org.bouncycastle.jcajce.util.c(), s.f46820k6, s.f46829n6));
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f55790a;

        public g() {
            HashMap map = new HashMap();
            map.put(new y(a0.f50038g), j.g(128));
            map.put(s.Z3, j.g(192));
            map.put(kn.d.f37625y, j.g(128));
            map.put(kn.d.G, j.g(192));
            map.put(kn.d.O, j.g(256));
            map.put(mn.a.f41443a, j.g(128));
            map.put(mn.a.f41444b, j.g(192));
            map.put(mn.a.f41445c, j.g(256));
            map.put(qm.a.f47456f, j.g(256));
            this.f55790a = Collections.unmodifiableMap(map);
        }

        public int a(zn.b bVar) {
            Integer num = (Integer) this.f55790a.get(bVar.x());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Hashtable f55791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Hashtable f55792b;

        public h() {
            this.f55791a = new Hashtable();
            this.f55792b = new Hashtable();
        }

        public Enumeration b() {
            return this.f55791a.elements();
        }

        public Object c(String str) {
            String str2 = (String) this.f55792b.get(str == null ? null : Strings.k(str));
            if (str2 == null) {
                return null;
            }
            return this.f55791a.get(str2);
        }

        public Enumeration d() {
            return this.f55791a.keys();
        }

        public void e(String str, Object obj) {
            String strK = str == null ? null : Strings.k(str);
            String str2 = (String) this.f55792b.get(strK);
            if (str2 != null) {
                this.f55791a.remove(str2);
            }
            this.f55792b.put(strK, str);
            this.f55791a.put(str, obj);
        }

        public Object f(String str) {
            String str2 = (String) this.f55792b.remove(str == null ? null : Strings.k(str));
            if (str2 == null) {
                return null;
            }
            return this.f55791a.remove(str2);
        }

        public int g() {
            return this.f55791a.size();
        }
    }

    public a(org.bouncycastle.jcajce.util.d dVar, y yVar, y yVar2) {
        this.f55776b = new h();
        this.f55777c = new h();
        this.f55778d = new h();
        this.f55783i = yVar;
        this.f55784j = yVar2;
        try {
            this.f55782h = dVar.s("X.509");
        } catch (Exception e10) {
            throw new IllegalArgumentException("can't create cert factory - " + e10.toString());
        }
    }

    public static byte[] i(c1 c1Var) {
        org.bouncycastle.crypto.s sVarC = org.bouncycastle.crypto.util.f.c();
        byte[] bArr = new byte[sVarC.h()];
        byte[] bArrH = c1Var.C().H();
        sVarC.update(bArrH, 0, bArrH.length);
        sVarC.c(bArr, 0);
        return bArr;
    }

    @Override // er.a
    public void a(SecureRandom secureRandom) {
        this.f55781g = secureRandom;
    }

    public final byte[] c(y yVar, byte[] bArr, int i10, char[] cArr, boolean z10, byte[] bArr2) throws Exception {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i10);
        Mac macN = this.f55775a.n(yVar.L());
        macN.init(new PKCS12Key(cArr, z10), pBEParameterSpec);
        macN.update(bArr2);
        return macN.doFinal();
    }

    public final Cipher d(int i10, char[] cArr, zn.b bVar) throws NoSuchPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec jVar;
        p pVarY = p.y(bVar.A());
        q qVarX = q.x(pVarY.z().z());
        zn.b bVarZ = zn.b.z(pVarY.x());
        SecretKeyFactory secretKeyFactoryU = this.f55775a.u(pVarY.z().x().L());
        SecretKey secretKeyGenerateSecret = qVarX.C() ? secretKeyFactoryU.generateSecret(new PBEKeySpec(cArr, qVarX.B(), l(qVarX.y()), f55766q.a(bVarZ))) : secretKeyFactoryU.generateSecret(new cr.q(cArr, qVarX.B(), l(qVarX.y()), f55766q.a(bVarZ), qVarX.A()));
        Cipher cipherI = this.f55775a.i(pVarY.x().x().L());
        gm.h hVarZ = pVarY.x().z();
        if (hVarZ instanceof z) {
            jVar = new IvParameterSpec(z.I(hVarZ).J());
        } else {
            qm.d dVarA = qm.d.A(hVarZ);
            jVar = new cr.j(dVarA.x(), dVarA.y());
        }
        cipherI.init(i10, secretKeyGenerateSecret, jVar);
        return cipherI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b0 e(String str, Certificate certificate) throws CertificateEncodingException {
        pn.d dVar = new pn.d(s.N4, new f2(certificate.getEncoded()));
        i iVar = new i();
        boolean z10 = false;
        if (certificate instanceof er.g) {
            er.g gVar = (er.g) certificate;
            y yVar = s.J4;
            gm.c cVar = (gm.c) gVar.c(yVar);
            if ((cVar == null || !cVar.d().equals(str)) && str != null) {
                gVar.h(yVar, new t1(str));
            }
            Enumeration enumerationF = gVar.f();
            while (enumerationF.hasMoreElements()) {
                y yVar2 = (y) enumerationF.nextElement();
                if (!yVar2.C(s.K4)) {
                    i iVar2 = new i();
                    iVar2.a(yVar2);
                    iVar2.a(new l2(gVar.c(yVar2)));
                    iVar.a(new j2(iVar2));
                    z10 = true;
                }
            }
        }
        if (!z10) {
            i iVar3 = new i();
            iVar3.a(s.J4);
            iVar3.a(new l2(new t1(str)));
            iVar.a(new j2(iVar3));
        }
        return new b0(s.f46799d6, dVar.b(), new l2(iVar));
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationD = this.f55778d.d();
        while (enumerationD.hasMoreElements()) {
            hashtable.put(enumerationD.nextElement(), "cert");
        }
        Enumeration enumerationD2 = this.f55776b.d();
        while (enumerationD2.hasMoreElements()) {
            String str = (String) enumerationD2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.f55778d.c(str) == null && this.f55776b.c(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        Key key = (Key) this.f55776b.f(str);
        Certificate certificate = (Certificate) this.f55778d.f(str);
        if (certificate != null) {
            this.f55779e.remove(new d(certificate.getPublicKey()));
        }
        if (key != null) {
            String str2 = (String) this.f55777c.f(str);
            if (str2 != null) {
                certificate = (Certificate) this.f55780f.remove(str2);
            }
            if (certificate != null) {
                this.f55779e.remove(new d(certificate.getPublicKey()));
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate) this.f55778d.c(str);
        if (certificate != null) {
            return certificate;
        }
        String str2 = (String) this.f55777c.c(str);
        return (Certificate) (str2 != null ? this.f55780f.get(str2) : this.f55780f.get(str));
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumerationB = this.f55778d.b();
        Enumeration enumerationD = this.f55778d.d();
        while (enumerationB.hasMoreElements()) {
            Certificate certificate2 = (Certificate) enumerationB.nextElement();
            String str = (String) enumerationD.nextElement();
            if (certificate2.equals(certificate)) {
                return str;
            }
        }
        Enumeration enumerationElements = this.f55780f.elements();
        Enumeration enumerationKeys = this.f55780f.keys();
        while (enumerationElements.hasMoreElements()) {
            Certificate certificate3 = (Certificate) enumerationElements.nextElement();
            String str2 = (String) enumerationKeys.nextElement();
            if (certificate3.equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        byte[] bArrC;
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        Certificate[] certificateArr = null;
        if (!engineIsKeyEntry(str)) {
            return null;
        }
        Certificate certificateEngineGetCertificate = engineGetCertificate(str);
        if (certificateEngineGetCertificate != null) {
            Vector vector = new Vector();
            while (certificateEngineGetCertificate != null) {
                X509Certificate x509Certificate = (X509Certificate) certificateEngineGetCertificate;
                byte[] extensionValue = x509Certificate.getExtensionValue(zn.y.f59077v.L());
                Certificate certificate = (extensionValue == null || (bArrC = zn.i.B(z.I(extensionValue).J()).C()) == null) ? null : (Certificate) this.f55779e.get(new d(bArrC));
                if (certificate == null) {
                    Principal issuerDN = x509Certificate.getIssuerDN();
                    if (!issuerDN.equals(x509Certificate.getSubjectDN())) {
                        Enumeration enumerationKeys = this.f55779e.keys();
                        while (true) {
                            if (!enumerationKeys.hasMoreElements()) {
                                break;
                            }
                            X509Certificate x509Certificate2 = (X509Certificate) this.f55779e.get(enumerationKeys.nextElement());
                            if (x509Certificate2.getSubjectDN().equals(issuerDN)) {
                                try {
                                    x509Certificate.verify(x509Certificate2.getPublicKey());
                                    certificate = x509Certificate2;
                                    break;
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (!vector.contains(certificateEngineGetCertificate)) {
                    vector.addElement(certificateEngineGetCertificate);
                    if (certificate != certificateEngineGetCertificate) {
                        certificateEngineGetCertificate = certificate;
                    }
                }
                certificateEngineGetCertificate = null;
            }
            int size = vector.size();
            certificateArr = new Certificate[size];
            for (int i10 = 0; i10 != size; i10++) {
                certificateArr[i10] = (Certificate) vector.elementAt(i10);
            }
        }
        return certificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        Objects.requireNonNull(str, "alias == null");
        if (this.f55776b.c(str) == null && this.f55778d.c(str) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.f55776b.c(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.f55778d.c(str) != null && this.f55776b.c(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.f55776b.c(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARN: Type inference failed for: r0v26, types: [xq.a$h] */
    /* JADX WARN: Type inference failed for: r17v10, types: [gm.z] */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v14, types: [gm.z] */
    /* JADX WARN: Type inference failed for: r17v15 */
    /* JADX WARN: Type inference failed for: r17v16 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.security.cert.Certificate] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [gm.z] */
    /* JADX WARN: Type inference failed for: r4v28, types: [xq.a$h] */
    /* JADX WARN: Type inference failed for: r4v32 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r7v32, types: [xq.a$h] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void engineLoad(java.io.InputStream r23, char[] r24) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xq.a.engineLoad(java.io.InputStream, char[]):void");
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
        } else {
            if (loadStoreParameter instanceof jq.b) {
                engineLoad(((jq.b) loadStoreParameter).a(), yq.c.a(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineProbe(InputStream inputStream) throws IOException {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.f55776b.c(str) == null) {
            this.f55778d.e(str, certificate);
            this.f55779e.put(new d(certificate.getPublicKey()), certificate);
        } else {
            throw new KeyStoreException("There is a key entry with the name " + str + j3.b.f36044h);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        boolean z10 = key instanceof PrivateKey;
        if (!z10) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if (z10 && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.f55776b.c(str) != null) {
            engineDeleteEntry(str);
        }
        this.f55776b.e(str, key);
        if (certificateArr != null) {
            this.f55778d.e(str, certificateArr[0]);
            for (int i10 = 0; i10 != certificateArr.length; i10++) {
                this.f55779e.put(new d(certificateArr[i10].getPublicKey()), certificateArr[i10]);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationD = this.f55778d.d();
        while (enumerationD.hasMoreElements()) {
            hashtable.put(enumerationD.nextElement(), "cert");
        }
        Enumeration enumerationD2 = this.f55776b.d();
        while (enumerationD2.hasMoreElements()) {
            String str = (String) enumerationD2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        h(outputStream, cArr, false);
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        jq.c cVar;
        char[] password;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        boolean z10 = loadStoreParameter instanceof jq.c;
        if (!z10 && !(loadStoreParameter instanceof org.bouncycastle.jce.provider.j)) {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        if (z10) {
            cVar = (jq.c) loadStoreParameter;
        } else {
            org.bouncycastle.jce.provider.j jVar = (org.bouncycastle.jce.provider.j) loadStoreParameter;
            cVar = new jq.c(jVar.a(), loadStoreParameter.getProtectionParameter(), jVar.b());
        }
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            password = null;
        } else {
            if (!(protectionParameter instanceof KeyStore.PasswordProtection)) {
                throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
            }
            password = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
        }
        h(cVar.a(), password, cVar.b());
    }

    public final b1 f(PublicKey publicKey) {
        try {
            return new b1(i(c1.A(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    public byte[] g(boolean z10, zn.b bVar, char[] cArr, boolean z11, byte[] bArr) throws IOException {
        y yVarX = bVar.x();
        int i10 = z10 ? 1 : 2;
        if (yVarX.Q(s.f46811h6)) {
            r rVarY = r.y(bVar.A());
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(rVarY.x(), rVarY.z().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr, z11);
                Cipher cipherI = this.f55775a.i(yVarX.L());
                cipherI.init(i10, pKCS12Key, pBEParameterSpec);
                return cipherI.doFinal(bArr);
            } catch (Exception e10) {
                throw new IOException("exception decrypting data - " + e10.toString());
            }
        }
        if (!yVarX.C(s.W3)) {
            throw new IOException("unknown PBE algorithm: " + yVarX);
        }
        try {
            return d(i10, cArr, bVar).doFinal(bArr);
        } catch (Exception e11) {
            throw new IOException("exception decrypting data - " + e11.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.Hashtable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.Hashtable] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.Object, java.security.cert.Certificate] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object, java.security.cert.Certificate] */
    public final void h(OutputStream outputStream, char[] cArr, boolean z10) throws IOException {
        String str;
        boolean z11;
        boolean z12;
        int iG = this.f55776b.g();
        String str2 = gm.j.f29715c;
        if (iG != 0) {
            Objects.requireNonNull(cArr, "no password supplied for PKCS#12 KeyStore");
        } else if (cArr == null) {
            Enumeration enumerationD = this.f55778d.d();
            i iVar = new i();
            while (enumerationD.hasMoreElements()) {
                try {
                    String str3 = (String) enumerationD.nextElement();
                    iVar.a(e(str3, (Certificate) this.f55778d.c(str3)));
                } catch (CertificateEncodingException e10) {
                    throw new IOException("Error encoding certificate: " + e10.toString());
                }
            }
            y yVar = s.f46830o4;
            if (z10) {
                new t(new pn.g(yVar, new f2(new j2(new pn.g(yVar, new f2(new j2(iVar).getEncoded()))).getEncoded())), null).u(outputStream, gm.j.f29713a);
                return;
            } else {
                new t(new pn.g(yVar, new e1(new i1(new pn.g(yVar, new e1(new i1(iVar).getEncoded()))).getEncoded())), null).u(outputStream, gm.j.f29715c);
                return;
            }
        }
        i iVar2 = new i();
        Enumeration enumerationD2 = this.f55776b.d();
        while (enumerationD2.hasMoreElements()) {
            byte[] bArr = new byte[20];
            this.f55781g.nextBytes(bArr);
            String str4 = (String) enumerationD2.nextElement();
            PrivateKey privateKey = (PrivateKey) this.f55776b.c(str4);
            r rVar = new r(bArr, f55765p);
            pn.j jVar = new pn.j(new zn.b(this.f55783i, rVar.b()), m(this.f55783i.L(), privateKey, rVar, cArr));
            i iVar3 = new i();
            if (privateKey instanceof er.g) {
                er.g gVar = (er.g) privateKey;
                y yVar2 = s.J4;
                gm.c cVar = (gm.c) gVar.c(yVar2);
                if (cVar == null || !cVar.d().equals(str4)) {
                    gVar.h(yVar2, new t1(str4));
                }
                y yVar3 = s.K4;
                if (gVar.c(yVar3) == null) {
                    gVar.h(yVar3, f(engineGetCertificate(str4).getPublicKey()));
                }
                Enumeration enumerationF = gVar.f();
                z12 = false;
                while (enumerationF.hasMoreElements()) {
                    y yVar4 = (y) enumerationF.nextElement();
                    i iVar4 = new i();
                    iVar4.a(yVar4);
                    iVar4.a(new l2(gVar.c(yVar4)));
                    iVar3.a(new j2(iVar4));
                    z12 = true;
                }
            } else {
                z12 = false;
            }
            if (!z12) {
                i iVar5 = new i();
                Certificate certificateEngineGetCertificate = engineGetCertificate(str4);
                iVar5.a(s.K4);
                iVar5.a(new l2(f(certificateEngineGetCertificate.getPublicKey())));
                iVar3.a(new j2(iVar5));
                i iVar6 = new i();
                iVar6.a(s.J4);
                iVar6.a(new l2(new t1(str4)));
                iVar3.a(new j2(iVar6));
            }
            iVar2.a(new b0(s.f46796c6, jVar.b(), new l2(iVar3)));
        }
        e1 e1Var = new e1(new j2(iVar2).v(gm.j.f29713a));
        byte[] bArr2 = new byte[20];
        this.f55781g.nextBytes(bArr2);
        i iVar7 = new i();
        zn.b bVar = new zn.b(this.f55784j, new r(bArr2, f55765p).b());
        ?? hashtable = new Hashtable();
        Enumeration enumerationD3 = this.f55776b.d();
        while (enumerationD3.hasMoreElements()) {
            try {
                String str5 = (String) enumerationD3.nextElement();
                ?? EngineGetCertificate = engineGetCertificate(str5);
                Enumeration enumeration = enumerationD3;
                pn.d dVar = new pn.d(s.N4, new f2(EngineGetCertificate.getEncoded()));
                i iVar8 = new i();
                if (EngineGetCertificate instanceof er.g) {
                    er.g gVar2 = (er.g) EngineGetCertificate;
                    y yVar5 = s.J4;
                    gm.c cVar2 = (gm.c) gVar2.c(yVar5);
                    if (cVar2 == null || !cVar2.d().equals(str5)) {
                        gVar2.h(yVar5, new t1(str5));
                    }
                    y yVar6 = s.K4;
                    if (gVar2.c(yVar6) == null) {
                        gVar2.h(yVar6, f(EngineGetCertificate.getPublicKey()));
                    }
                    Enumeration enumerationF2 = gVar2.f();
                    z11 = false;
                    while (enumerationF2.hasMoreElements()) {
                        y yVar7 = (y) enumerationF2.nextElement();
                        Enumeration enumeration2 = enumerationF2;
                        i iVar9 = new i();
                        iVar9.a(yVar7);
                        iVar9.a(new l2(gVar2.c(yVar7)));
                        iVar8.a(new j2(iVar9));
                        enumerationF2 = enumeration2;
                        str2 = str2;
                        z11 = true;
                    }
                    str = str2;
                } else {
                    str = str2;
                    z11 = false;
                }
                if (!z11) {
                    i iVar10 = new i();
                    iVar10.a(s.K4);
                    iVar10.a(new l2(f(EngineGetCertificate.getPublicKey())));
                    iVar8.a(new j2(iVar10));
                    i iVar11 = new i();
                    iVar11.a(s.J4);
                    iVar11.a(new l2(new t1(str5)));
                    iVar8.a(new j2(iVar11));
                }
                iVar7.a(new b0(s.f46799d6, dVar.b(), new l2(iVar8)));
                hashtable.put(EngineGetCertificate, EngineGetCertificate);
                enumerationD3 = enumeration;
                str2 = str;
            } catch (CertificateEncodingException e11) {
                throw new IOException("Error encoding certificate: " + e11.toString());
            }
        }
        String str6 = str2;
        Enumeration enumerationD4 = this.f55778d.d();
        while (enumerationD4.hasMoreElements()) {
            try {
                String str7 = (String) enumerationD4.nextElement();
                Certificate certificate = (Certificate) this.f55778d.c(str7);
                if (this.f55776b.c(str7) == null) {
                    iVar7.a(e(str7, certificate));
                    hashtable.put(certificate, certificate);
                }
            } catch (CertificateEncodingException e12) {
                throw new IOException("Error encoding certificate: " + e12.toString());
            }
        }
        ?? J = j();
        Enumeration enumerationKeys = this.f55779e.keys();
        while (enumerationKeys.hasMoreElements()) {
            try {
                ?? r62 = (Certificate) this.f55779e.get((d) enumerationKeys.nextElement());
                if (J.contains(r62) && hashtable.get(r62) == null) {
                    pn.d dVar2 = new pn.d(s.N4, new f2(r62.getEncoded()));
                    i iVar12 = new i();
                    if (r62 instanceof er.g) {
                        er.g gVar3 = (er.g) r62;
                        Enumeration enumerationF3 = gVar3.f();
                        while (enumerationF3.hasMoreElements()) {
                            y yVar8 = (y) enumerationF3.nextElement();
                            if (!yVar8.C(s.K4)) {
                                i iVar13 = new i();
                                iVar13.a(yVar8);
                                iVar13.a(new l2(gVar3.c(yVar8)));
                                iVar12.a(new j2(iVar13));
                                hashtable = hashtable;
                            }
                        }
                    }
                    ?? r16 = hashtable;
                    iVar7.a(new b0(s.f46799d6, dVar2.b(), new l2(iVar12)));
                    hashtable = r16;
                }
            } catch (CertificateEncodingException e13) {
                throw new IOException("Error encoding certificate: " + e13.toString());
            }
        }
        byte[] bArrG = g(true, bVar, cArr, false, new j2(iVar7).v(gm.j.f29713a));
        y yVar9 = s.f46830o4;
        pn.g gVar4 = new pn.g(yVar9, new e1(new pn.b(new pn.g[]{new pn.g(yVar9, e1Var), new pn.g(s.f46845t4, new pn.i(yVar9, bVar, new e1(bArrG)).b())}).v(z10 ? gm.j.f29713a : str6)));
        byte[] bArr3 = new byte[this.f55787m];
        this.f55781g.nextBytes(bArr3);
        try {
            new t(gVar4, new pn.n(new zn.t(this.f55785k, c(this.f55785k.x(), bArr3, this.f55786l, cArr, false, ((z) gVar4.x()).J())), bArr3, this.f55786l)).u(outputStream, z10 ? gm.j.f29713a : str6);
        } catch (Exception e14) {
            throw new IOException("error constructing MAC: " + e14.toString());
        }
    }

    public final Set j() {
        HashSet hashSet = new HashSet();
        Enumeration enumerationD = this.f55776b.d();
        while (enumerationD.hasMoreElements()) {
            Certificate[] certificateArrEngineGetCertificateChain = engineGetCertificateChain((String) enumerationD.nextElement());
            for (int i10 = 0; i10 != certificateArrEngineGetCertificateChain.length; i10++) {
                hashSet.add(certificateArrEngineGetCertificateChain[i10]);
            }
        }
        Enumeration enumerationD2 = this.f55778d.d();
        while (enumerationD2.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) enumerationD2.nextElement()));
        }
        return hashSet;
    }

    public PrivateKey k(zn.b bVar, byte[] bArr, char[] cArr, boolean z10) throws IOException {
        y yVarX = bVar.x();
        try {
            if (yVarX.Q(s.f46811h6)) {
                r rVarY = r.y(bVar.A());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(rVarY.x(), l(rVarY.z()));
                Cipher cipherI = this.f55775a.i(yVarX.L());
                cipherI.init(4, new PKCS12Key(cArr, z10), pBEParameterSpec);
                return (PrivateKey) cipherI.unwrap(bArr, "", 2);
            }
            if (yVarX.C(s.W3)) {
                return (PrivateKey) d(4, cArr, bVar).unwrap(bArr, "", 2);
            }
            throw new IOException("exception unwrapping private key - cannot recognise: " + yVarX);
        } catch (Exception e10) {
            throw new IOException("exception unwrapping private key - " + e10.toString());
        }
    }

    public final int l(BigInteger bigInteger) {
        int iIntValue = bigInteger.intValue();
        if (iIntValue < 0) {
            throw new IllegalStateException("negative iteration count found");
        }
        BigInteger bigIntegerA = org.bouncycastle.util.p.a(f55763n);
        if (bigIntegerA == null || bigIntegerA.intValue() >= iIntValue) {
            return iIntValue;
        }
        throw new IllegalStateException("iteration count " + iIntValue + " greater than " + bigIntegerA.intValue());
    }

    public byte[] m(String str, Key key, r rVar, char[] cArr) throws IOException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory secretKeyFactoryU = this.f55775a.u(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(rVar.x(), rVar.z().intValue());
            Cipher cipherI = this.f55775a.i(str);
            cipherI.init(3, secretKeyFactoryU.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipherI.wrap(key);
        } catch (Exception e10) {
            throw new IOException("exception encrypting data - " + e10.toString());
        }
    }
}
