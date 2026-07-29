package mq;

import co.r;
import java.util.HashMap;
import java.util.Map;
import pn.s;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41555a = "org.bouncycastle.jcajce.provider.asymmetric.dh.";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f41556b;

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyPairGenerator.DH", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyPairGeneratorSpi");
            aVar.h("Alg.Alias.KeyPairGenerator.DIFFIEHELLMAN", "DH");
            aVar.d("KeyAgreement.DH", b.f41556b);
            aVar.h("KeyAgreement.DH", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi");
            aVar.h("Alg.Alias.KeyAgreement.DIFFIEHELLMAN", "DH");
            aVar.k("KeyAgreement", s.f46841r6, "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            aVar.k("KeyAgreement", s.f46844s6, "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithRFC2631KDF");
            aVar.h("KeyFactory.DH", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyFactorySpi");
            aVar.h("Alg.Alias.KeyFactory.DIFFIEHELLMAN", "DH");
            aVar.h("AlgorithmParameters.DH", "org.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParametersSpi");
            aVar.h("Alg.Alias.AlgorithmParameters.DIFFIEHELLMAN", "DH");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.DIFFIEHELLMAN", "DH");
            aVar.h("AlgorithmParameterGenerator.DH", "org.bouncycastle.jcajce.provider.asymmetric.dh.AlgorithmParameterGeneratorSpi");
            aVar.h("Cipher.IES", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            aVar.h("Cipher.IESwithAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            aVar.h("Cipher.IESWITHAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            aVar.h("Cipher.IESWITHDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            aVar.h("Cipher.DHIES", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES");
            aVar.h("Cipher.DHIESwithAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            aVar.h("Cipher.DHIESWITHAES-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithAESCBC");
            aVar.h("Cipher.DHIESWITHDESEDE-CBC", "org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IESwithDESedeCBC");
            aVar.h("KeyAgreement.DHWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA1KDF");
            aVar.h("KeyAgreement.DHWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA224KDF");
            aVar.h("KeyAgreement.DHWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA256KDF");
            aVar.h("KeyAgreement.DHWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA384KDF");
            aVar.h("KeyAgreement.DHWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHwithSHA512KDF");
            aVar.h("KeyAgreement.DHUWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1KDF");
            aVar.h("KeyAgreement.DHUWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224KDF");
            aVar.h("KeyAgreement.DHUWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256KDF");
            aVar.h("KeyAgreement.DHUWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384KDF");
            aVar.h("KeyAgreement.DHUWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512KDF");
            aVar.h("KeyAgreement.DHUWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA1CKDF");
            aVar.h("KeyAgreement.DHUWITHSHA224CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA224CKDF");
            aVar.h("KeyAgreement.DHUWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA256CKDF");
            aVar.h("KeyAgreement.DHUWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA384CKDF");
            aVar.h("KeyAgreement.DHUWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$DHUwithSHA512CKDF");
            aVar.h("KeyAgreement.MQVWITHSHA1KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1KDF");
            aVar.h("KeyAgreement.MQVWITHSHA224KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224KDF");
            aVar.h("KeyAgreement.MQVWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256KDF");
            aVar.h("KeyAgreement.MQVWITHSHA384KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384KDF");
            aVar.h("KeyAgreement.MQVWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512KDF");
            aVar.h("KeyAgreement.MQVWITHSHA1CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA1CKDF");
            aVar.h("KeyAgreement.MQVWITHSHA224CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA224CKDF");
            aVar.h("KeyAgreement.MQVWITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA256CKDF");
            aVar.h("KeyAgreement.MQVWITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA384CKDF");
            aVar.h("KeyAgreement.MQVWITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.dh.KeyAgreementSpi$MQVwithSHA512CKDF");
            e(aVar, s.O3, "DH", new nq.f());
            e(aVar, r.f11161d1, "DH", new nq.f());
        }
    }

    static {
        HashMap map = new HashMap();
        f41556b = map;
        map.put("SupportedKeyClasses", "javax.crypto.interfaces.DHPublicKey|javax.crypto.interfaces.DHPrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
