package org.bouncycastle.operator.jcajce;

import cs.q;
import gm.d2;
import gm.f2;
import gm.y;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.operator.OperatorException;
import pn.s;
import pn.w;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class f extends cs.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f45625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f45626g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OperatorHelper f45627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f45628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PublicKey f45629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f45630e;

    static {
        HashSet hashSet = new HashSet();
        f45625f = hashSet;
        hashSet.add(qm.a.E);
        hashSet.add(qm.a.f47463m);
        hashSet.add(qn.a.f47522l);
        hashSet.add(qn.a.f47523m);
        hashSet.add(qn.a.f47517g);
        hashSet.add(qn.a.f47518h);
        HashMap map = new HashMap();
        f45626g = map;
        y yVar = on.b.f44365i;
        d2 d2Var = d2.f29657b;
        map.put("SHA1", new zn.b(yVar, d2Var));
        map.put(et.e.f27137f, new zn.b(yVar, d2Var));
        y yVar2 = kn.d.f37598f;
        map.put("SHA224", new zn.b(yVar2, d2Var));
        map.put(et.e.f27138g, new zn.b(yVar2, d2Var));
        y yVar3 = kn.d.f37592c;
        map.put("SHA256", new zn.b(yVar3, d2Var));
        map.put("SHA-256", new zn.b(yVar3, d2Var));
        y yVar4 = kn.d.f37594d;
        map.put("SHA384", new zn.b(yVar4, d2Var));
        map.put(et.e.f27140i, new zn.b(yVar4, d2Var));
        y yVar5 = kn.d.f37596e;
        map.put("SHA512", new zn.b(yVar5, d2Var));
        map.put("SHA-512", new zn.b(yVar5, d2Var));
        y yVar6 = kn.d.f37600g;
        map.put("SHA512/224", new zn.b(yVar6, d2Var));
        map.put("SHA-512/224", new zn.b(yVar6, d2Var));
        map.put("SHA-512(224)", new zn.b(yVar6, d2Var));
        y yVar7 = kn.d.f37602h;
        map.put("SHA512/256", new zn.b(yVar7, d2Var));
        map.put(rs.h.f49168c, new zn.b(yVar7, d2Var));
        map.put("SHA-512(256)", new zn.b(yVar7, d2Var));
    }

    public f(AlgorithmParameters algorithmParameters, PublicKey publicKey) throws InvalidParameterSpecException {
        super(c(algorithmParameters.getParameterSpec(AlgorithmParameterSpec.class)));
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45628c = new HashMap();
        this.f45629d = publicKey;
    }

    public f(PublicKey publicKey) {
        super(c1.A(publicKey.getEncoded()).x());
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45628c = new HashMap();
        this.f45629d = publicKey;
    }

    public f(X509Certificate x509Certificate) {
        this(x509Certificate.getPublicKey());
    }

    public f(AlgorithmParameterSpec algorithmParameterSpec, PublicKey publicKey) {
        super(c(algorithmParameterSpec));
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45628c = new HashMap();
        this.f45629d = publicKey;
    }

    public f(zn.b bVar, PublicKey publicKey) {
        super(bVar);
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.c());
        this.f45628c = new HashMap();
        this.f45629d = publicKey;
    }

    public static zn.b c(AlgorithmParameterSpec algorithmParameterSpec) {
        if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new IllegalArgumentException("unknown spec: " + algorithmParameterSpec.getClass().getName());
        }
        OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        if (!oAEPParameterSpec.getMGFAlgorithm().equals(OAEPParameterSpec.DEFAULT.getMGFAlgorithm())) {
            throw new IllegalArgumentException("unknown MGF: " + oAEPParameterSpec.getMGFAlgorithm());
        }
        if (oAEPParameterSpec.getPSource() instanceof PSource.PSpecified) {
            return new zn.b(s.D3, new w(d(oAEPParameterSpec.getDigestAlgorithm()), new zn.b(s.E3, d(((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm())), new zn.b(s.F3, new f2(((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue()))));
        }
        throw new IllegalArgumentException("unknown PSource: " + oAEPParameterSpec.getPSource().getAlgorithm());
    }

    public static zn.b d(String str) {
        zn.b bVar = (zn.b) f45626g.get(str);
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("unknown digest name: " + str);
    }

    public static boolean e(y yVar) {
        return f45625f.contains(yVar);
    }

    @Override // cs.x
    public byte[] b(q qVar) throws OperatorException {
        byte[] bArrWrap;
        if (!e(a().x())) {
            Cipher cipherD = this.f45627b.d(a().x(), this.f45628c);
            try {
                AlgorithmParameters algorithmParametersC = this.f45627b.c(a());
                if (algorithmParametersC != null) {
                    cipherD.init(3, this.f45629d, algorithmParametersC, this.f45630e);
                } else {
                    cipherD.init(3, this.f45629d, this.f45630e);
                }
                bArrWrap = cipherD.wrap(m.a(qVar));
            } catch (IllegalStateException | UnsupportedOperationException | InvalidKeyException | GeneralSecurityException | ProviderException unused) {
                bArrWrap = null;
            }
            if (bArrWrap != null) {
                return bArrWrap;
            }
            try {
                cipherD.init(1, this.f45629d, this.f45630e);
                return cipherD.doFinal(m.a(qVar).getEncoded());
            } catch (InvalidKeyException e10) {
                throw new OperatorException("unable to encrypt contents key", e10);
            } catch (GeneralSecurityException e11) {
                throw new OperatorException("unable to encrypt contents key", e11);
            }
        }
        try {
            this.f45630e = n.g(this.f45630e);
            KeyPairGenerator keyPairGeneratorH = this.f45627b.h(a().x());
            keyPairGeneratorH.initialize(((ECPublicKey) this.f45629d).getParams(), this.f45630e);
            KeyPair keyPairGenerateKeyPair = keyPairGeneratorH.generateKeyPair();
            byte[] bArr = new byte[8];
            this.f45630e.nextBytes(bArr);
            c1 c1VarA = c1.A(keyPairGenerateKeyPair.getPublic().getEncoded());
            qm.k kVar = c1VarA.x().x().Q(qn.a.f47512b) ? new qm.k(qn.a.f47530t, c1VarA, bArr) : new qm.k(qm.a.f47458h, c1VarA, bArr);
            KeyAgreement keyAgreementG = this.f45627b.g(a().x());
            keyAgreementG.init(keyPairGenerateKeyPair.getPrivate(), new cr.w(kVar.B()));
            keyAgreementG.doPhase(this.f45629d, true);
            y yVar = qm.a.f47455e;
            SecretKey secretKeyGenerateSecret = keyAgreementG.generateSecret(yVar.L());
            byte[] encoded = m.a(qVar).getEncoded();
            Cipher cipherE = this.f45627b.e(yVar);
            cipherE.init(3, secretKeyGenerateSecret, new cr.k(kVar.x(), kVar.B()));
            byte[] bArrWrap2 = cipherE.wrap(new SecretKeySpec(encoded, "GOST"));
            return new qm.j(new qm.h(org.bouncycastle.util.a.W(bArrWrap2, 0, 32), org.bouncycastle.util.a.W(bArrWrap2, 32, 36)), kVar).getEncoded();
        } catch (Exception e12) {
            throw new OperatorException("exception wrapping key: " + e12.getMessage(), e12);
        }
    }

    public f f(y yVar, String str) {
        this.f45628c.put(yVar, str);
        return this;
    }

    public f g(String str) {
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.g(str));
        return this;
    }

    public f h(Provider provider) {
        this.f45627b = new OperatorHelper(new org.bouncycastle.jcajce.util.i(provider));
        return this;
    }

    public f i(SecureRandom secureRandom) {
        this.f45630e = secureRandom;
        return this;
    }
}
