package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public final class BouncyCastleProvider extends Provider implements uq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f45328a = "BouncyCastle Security Provider v1.70";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f45333f = "org.bouncycastle.jcajce.provider.symmetric.";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f45337j = "org.bouncycastle.jcajce.provider.asymmetric.";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f45340m = "org.bouncycastle.jcajce.provider.digest.";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f45342o = "org.bouncycastle.jcajce.provider.keystore.";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f45344q = "org.bouncycastle.jcajce.provider.drbg.";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final uq.c f45330c = new org.bouncycastle.jce.provider.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f45331d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class f45332e = ar.f.a(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f45334g = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f45335h = {"SipHash", "SipHash128", "Poly1305"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f45336i = {m5.b.f40641c, "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f45338k = {"X509", "IES", "COMPOSITE"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f45339l = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f45341n = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f45329b = "BC";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f45343p = {f45329b, "BCFKS", "PKCS12"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f45345r = {"DRBG"};

    public class a implements PrivilegedAction {
        public a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            BouncyCastleProvider.this.t();
            return null;
        }
    }

    public BouncyCastleProvider() {
        super(f45329b, 1.7d, f45328a);
        AccessController.doPrivileged(new a());
    }

    public static br.c n(gm.y yVar) {
        br.c cVar;
        Map map = f45331d;
        synchronized (map) {
            cVar = (br.c) map.get(yVar);
        }
        return cVar;
    }

    public static PrivateKey o(pn.u uVar) throws IOException {
        br.c cVarN = n(uVar.B().x());
        if (cVarN == null) {
            return null;
        }
        return cVarN.b(uVar);
    }

    public static PublicKey p(c1 c1Var) throws IOException {
        br.c cVarN = n(c1Var.x().x());
        if (cVarN == null) {
            return null;
        }
        return cVarN.a(c1Var);
    }

    @Override // uq.a
    public void a(String str, Object obj) {
        uq.c cVar = f45330c;
        synchronized (cVar) {
            ((org.bouncycastle.jce.provider.a) cVar).f(str, obj);
        }
    }

    @Override // uq.a
    public void b(gm.y yVar, br.c cVar) {
        Map map = f45331d;
        synchronized (map) {
            map.put(yVar, cVar);
        }
    }

    @Override // uq.a
    public boolean c(String str, String str2) {
        if (!containsKey(str + j3.b.f36044h + str2)) {
            if (!containsKey("Alg.Alias." + str + j3.b.f36044h + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // uq.a
    public void d(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String str3 = str + com.blankj.utilcode.util.i0.f11861z + str2;
            if (containsKey(str3)) {
                throw new IllegalStateException("duplicate provider attribute key (" + str3 + ") found");
            }
            put(str3, map.get(str2));
        }
    }

    @Override // uq.a
    public void h(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    @Override // uq.a
    public void k(String str, gm.y yVar, String str2) {
        h(str + j3.b.f36044h + yVar, str2);
        h(str + ".OID." + yVar, str2);
    }

    @Override // uq.a
    public br.c l(gm.y yVar) {
        return (br.c) f45331d.get(yVar);
    }

    public final void q(String str, String[] strArr) {
        for (int i10 = 0; i10 != strArr.length; i10++) {
            Class clsA = ar.f.a(BouncyCastleProvider.class, str + strArr[i10] + "$Mappings");
            if (clsA != null) {
                try {
                    ((br.a) clsA.newInstance()).a(this);
                } catch (Exception e10) {
                    throw new InternalError("cannot create instance of " + str + strArr[i10] + "$Mappings : " + e10);
                }
            }
        }
    }

    public final void r() {
        b(is.g.f35791r, new bt.b());
        b(is.g.f35795v, new ys.b());
        b(is.g.f35796w, new dt.b());
        b(bn.a.f9499a, new dt.b());
        b(is.g.F, new dt.d());
        b(bn.a.f9500b, new dt.d());
        b(is.g.f35786m, new xs.f());
        b(is.g.f35787n, new xs.a());
        b(is.g.f35774a, new at.a());
        b(is.g.X, new zs.c());
        b(is.g.Y, new zs.c());
        b(pn.s.f46801e5, new ws.b());
    }

    public final void t() {
        String str;
        String str2;
        q(f45340m, f45341n);
        q(f45333f, f45334g);
        q(f45333f, f45335h);
        q(f45333f, f45336i);
        q(f45337j, f45338k);
        q(f45337j, f45339l);
        q(f45342o, f45343p);
        q(f45344q, f45345r);
        r();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class cls = f45332e;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (cls != null) {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
        } else {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        }
        put("CertPathBuilder.RFC3280", str2);
        put("CertPathValidator.PKIX", str);
        put("CertPathBuilder.PKIX", str2);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }
}
