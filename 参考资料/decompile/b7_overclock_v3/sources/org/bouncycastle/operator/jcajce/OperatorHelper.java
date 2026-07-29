package org.bouncycastle.operator.jcajce;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import gm.f0;
import gm.t;
import gm.y;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import pn.a0;
import pn.s;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class OperatorHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f45579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f45580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f45581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f45582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f45583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static cs.m f45584g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f45585a;

    public static class OpCertificateException extends CertificateException {
        private Throwable cause;

        public OpCertificateException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    static {
        HashMap map = new HashMap();
        f45579b = map;
        HashMap map2 = new HashMap();
        f45580c = map2;
        HashMap map3 = new HashMap();
        f45581d = map3;
        HashMap map4 = new HashMap();
        f45582e = map4;
        HashMap map5 = new HashMap();
        f45583f = map5;
        f45584g = new cs.m();
        map.put(on.b.f44365i, "SHA1");
        map.put(kn.d.f37598f, "SHA224");
        map.put(kn.d.f37592c, "SHA256");
        map.put(kn.d.f37594d, "SHA384");
        map.put(kn.d.f37596e, "SHA512");
        map.put(tn.b.f51361c, "RIPEMD128");
        map.put(tn.b.f51360b, "RIPEMD160");
        map.put(tn.b.f51362d, "RIPEMD256");
        map2.put(s.f46854x3, "RSA/ECB/PKCS1Padding");
        map2.put(qm.a.f47463m, "ECGOST3410");
        y yVar = s.f46835p6;
        map3.put(yVar, "DESEDEWrap");
        map3.put(s.f46838q6, "RC2Wrap");
        y yVar2 = kn.d.B;
        map3.put(yVar2, "AESWrap");
        y yVar3 = kn.d.J;
        map3.put(yVar3, "AESWrap");
        y yVar4 = kn.d.R;
        map3.put(yVar4, "AESWrap");
        y yVar5 = mn.a.f41446d;
        map3.put(yVar5, "CamelliaWrap");
        y yVar6 = mn.a.f41447e;
        map3.put(yVar6, "CamelliaWrap");
        y yVar7 = mn.a.f41448f;
        map3.put(yVar7, "CamelliaWrap");
        y yVar8 = gn.a.f29841d;
        map3.put(yVar8, "SEEDWrap");
        y yVar9 = s.Z3;
        map3.put(yVar9, "DESede");
        map5.put(yVar, org.bouncycastle.util.j.g(192));
        map5.put(yVar2, org.bouncycastle.util.j.g(128));
        map5.put(yVar3, org.bouncycastle.util.j.g(192));
        map5.put(yVar4, org.bouncycastle.util.j.g(256));
        map5.put(yVar5, org.bouncycastle.util.j.g(128));
        map5.put(yVar6, org.bouncycastle.util.j.g(192));
        map5.put(yVar7, org.bouncycastle.util.j.g(256));
        map5.put(yVar8, org.bouncycastle.util.j.g(128));
        map5.put(yVar9, org.bouncycastle.util.j.g(192));
        map4.put(kn.d.f37623w, m5.b.f40641c);
        map4.put(kn.d.f37625y, m5.b.f40641c);
        map4.put(kn.d.G, m5.b.f40641c);
        map4.put(kn.d.O, m5.b.f40641c);
        map4.put(yVar9, "DESede");
        map4.put(s.f46788a4, "RC2");
    }

    public OperatorHelper(org.bouncycastle.jcajce.util.d dVar) {
        this.f45585a = dVar;
    }

    public static String l(y yVar) {
        String strA = org.bouncycastle.jcajce.util.f.a(yVar);
        int iIndexOf = strA.indexOf(45);
        if (iIndexOf <= 0 || strA.startsWith("SHA3")) {
            return strA;
        }
        return strA.substring(0, iIndexOf) + strA.substring(iIndexOf + 1);
    }

    public static String o(zn.b bVar) {
        return f45584g.b(bVar);
    }

    public X509Certificate a(X509CertificateHolder x509CertificateHolder) throws CertificateException {
        try {
            return (X509Certificate) this.f45585a.s("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e10) {
            throw new OpCertificateException("cannot get encoded form of certificate: " + e10.getMessage(), e10);
        } catch (NoSuchProviderException e11) {
            throw new OpCertificateException("cannot find factory provider: " + e11.getMessage(), e11);
        }
    }

    public PublicKey b(c1 c1Var) throws OperatorCreationException {
        try {
            return this.f45585a.b(c1Var.x().x().L()).generatePublic(new X509EncodedKeySpec(c1Var.getEncoded()));
        } catch (IOException e10) {
            throw new OperatorCreationException("cannot get encoded form of key: " + e10.getMessage(), e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new OperatorCreationException("cannot create key factory: " + e11.getMessage(), e11);
        } catch (NoSuchProviderException e12) {
            throw new OperatorCreationException("cannot find factory provider: " + e12.getMessage(), e12);
        } catch (InvalidKeySpecException e13) {
            throw new OperatorCreationException("cannot create key factory: " + e13.getMessage(), e13);
        }
    }

    public AlgorithmParameters c(zn.b bVar) throws OperatorCreationException {
        if (bVar.x().C(s.f46854x3)) {
            return null;
        }
        try {
            AlgorithmParameters algorithmParametersT = this.f45585a.t(bVar.x().L());
            try {
                algorithmParametersT.init(bVar.A().b().getEncoded());
                return algorithmParametersT;
            } catch (IOException e10) {
                throw new OperatorCreationException("cannot initialise algorithm parameters: " + e10.getMessage(), e10);
            }
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (NoSuchProviderException e11) {
            throw new OperatorCreationException("cannot create algorithm parameters: " + e11.getMessage(), e11);
        }
    }

    public Cipher d(y yVar, Map map) throws OperatorCreationException {
        try {
            String str = map.isEmpty() ? null : (String) map.get(yVar);
            if (str == null) {
                str = (String) f45580c.get(yVar);
            }
            if (str != null) {
                try {
                    return this.f45585a.i(str);
                } catch (NoSuchAlgorithmException unused) {
                    if (str.equals("RSA/ECB/PKCS1Padding")) {
                        try {
                            return this.f45585a.i("RSA/NONE/PKCS1Padding");
                        } catch (NoSuchAlgorithmException unused2) {
                        }
                    }
                    return this.f45585a.i(yVar.L());
                }
            }
            return this.f45585a.i(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public Cipher e(y yVar) throws OperatorCreationException {
        try {
            return this.f45585a.i(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.security.MessageDigest] */
    public MessageDigest f(zn.b bVar) throws GeneralSecurityException {
        org.bouncycastle.jcajce.util.d dVar;
        String strA;
        try {
            if (bVar.x().C(kn.d.f37620t)) {
                dVar = this.f45585a;
                strA = "SHAKE256-" + t.I(bVar.A()).K();
            } else if (bVar.x().C(kn.d.f37619s)) {
                dVar = this.f45585a;
                strA = "SHAKE128-" + t.I(bVar.A()).K();
            } else {
                dVar = this.f45585a;
                strA = org.bouncycastle.jcajce.util.f.a(bVar.x());
            }
            bVar = dVar.g(strA);
            return bVar;
        } catch (NoSuchAlgorithmException e10) {
            Map map = f45579b;
            if (map.get(bVar.x()) == null) {
                throw e10;
            }
            return this.f45585a.g((String) map.get(bVar.x()));
        }
    }

    public KeyAgreement g(y yVar) throws OperatorCreationException {
        try {
            return this.f45585a.k(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create key agreement: " + e10.getMessage(), e10);
        }
    }

    public KeyPairGenerator h(y yVar) throws CMSException {
        try {
            return this.f45585a.d(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create key agreement: " + e10.getMessage(), e10);
        }
    }

    public Signature i(zn.b bVar) {
        try {
            String strO = o(bVar);
            String str = HlsPlaylistParser.M + strO.substring(strO.indexOf("WITH"));
            Signature signatureA = this.f45585a.a(str);
            if (bVar.x().C(s.G3)) {
                AlgorithmParameters algorithmParametersT = this.f45585a.t(str);
                org.bouncycastle.jcajce.util.a.b(algorithmParametersT, bVar.A());
                signatureA.setParameter((PSSParameterSpec) algorithmParametersT.getParameterSpec(PSSParameterSpec.class));
            }
            return signatureA;
        } catch (Exception unused) {
            return null;
        }
    }

    public Signature j(zn.b bVar) throws GeneralSecurityException {
        Signature signatureA;
        String strO = o(bVar);
        try {
            signatureA = this.f45585a.a(strO);
        } catch (NoSuchAlgorithmException e10) {
            if (!strO.endsWith("WITHRSAANDMGF1")) {
                throw e10;
            }
            signatureA = this.f45585a.a(strO.substring(0, strO.indexOf(87)) + "WITHRSASSA-PSS");
        }
        if (bVar.x().C(s.G3)) {
            f0 f0VarJ = f0.J(bVar.A());
            if (q(f0VarJ)) {
                try {
                    AlgorithmParameters algorithmParametersT = this.f45585a.t("PSS");
                    algorithmParametersT.init(f0VarJ.getEncoded());
                    signatureA.setParameter(algorithmParametersT.getParameterSpec(PSSParameterSpec.class));
                } catch (IOException e11) {
                    throw new GeneralSecurityException("unable to process PSS parameters: " + e11.getMessage());
                }
            }
        }
        return signatureA;
    }

    public Cipher k(y yVar) throws OperatorCreationException {
        try {
            String str = (String) f45581d.get(yVar);
            if (str != null) {
                try {
                    return this.f45585a.i(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f45585a.i(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new OperatorCreationException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public String m(y yVar) {
        String str = (String) f45582e.get(yVar);
        return str != null ? str : yVar.L();
    }

    public int n(y yVar) {
        return ((Integer) f45583f.get(yVar)).intValue();
    }

    public String p(y yVar) {
        return (String) f45581d.get(yVar);
    }

    public final boolean q(f0 f0Var) throws GeneralSecurityException {
        if (f0Var == null || f0Var.size() == 0) {
            return false;
        }
        a0 a0VarY = a0.y(f0Var);
        if (a0VarY.z().x().C(s.E3) && a0VarY.x().equals(zn.b.z(a0VarY.z().A()))) {
            return a0VarY.A().intValue() != f(a0VarY.x()).getDigestLength();
        }
        return true;
    }
}
