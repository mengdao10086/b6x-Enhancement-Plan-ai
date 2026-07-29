package mq;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import pn.s;
import zn.z1;

/* JADX INFO: loaded from: classes7.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41571a = "org.bouncycastle.jcajce.provider.asymmetric.rsa.";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f41572b;

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            String str;
            String str2;
            aVar.h("AlgorithmParameters.OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            aVar.h("AlgorithmParameters.PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA3-224WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA3-256WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA3-384WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.SHA3-512WITHRSAANDMGF1", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            aVar.h("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            aVar.d("Cipher.RSA", l.f41572b);
            aVar.h("Cipher.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            aVar.h("Cipher.RSA/RAW", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            aVar.h("Cipher.RSA/PKCS1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            y yVar = s.f46854x3;
            aVar.k("Cipher", yVar, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            y yVar2 = z1.f59124r7;
            aVar.k("Cipher", yVar2, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            aVar.h("Cipher.RSA/1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            aVar.h("Cipher.RSA/2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            aVar.h("Cipher.RSA/OAEP", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            y yVar3 = s.D3;
            aVar.k("Cipher", yVar3, "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            aVar.h("Cipher.RSA/ISO9796-1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            aVar.h("Alg.Alias.Cipher.RSA//RAW", "RSA");
            aVar.h("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            aVar.h("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            aVar.h("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            aVar.h("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            aVar.h("KeyFactory.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            aVar.h("KeyPairGenerator.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            aVar.h("KeyFactory.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            aVar.h("KeyPairGenerator.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi$PSS");
            tq.e eVar = new tq.e();
            e(aVar, yVar, "RSA", eVar);
            e(aVar, yVar2, "RSA", eVar);
            e(aVar, yVar3, "RSA", eVar);
            y yVar4 = s.G3;
            e(aVar, yVar4, "RSA", eVar);
            g(aVar, yVar, "RSA");
            g(aVar, yVar2, "RSA");
            g(aVar, yVar3, "OAEP");
            g(aVar, yVar4, "PSS");
            aVar.h("Signature.RSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            aVar.h("Signature." + yVar4, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            aVar.h("Signature.OID." + yVar4, "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            aVar.h("Signature.RSA", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            aVar.h("Signature.RAWRSASSA-PSS", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            aVar.h("Alg.Alias.Signature.RAWRSA", "RSA");
            aVar.h("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            aVar.h("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            aVar.h("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            aVar.h("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            aVar.h("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            aVar.h("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            k(aVar, "SHA224", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            k(aVar, "SHA256", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            k(aVar, "SHA384", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            k(aVar, "SHA512", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            k(aVar, "SHA512(224)", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
            k(aVar, "SHA512(256)", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
            k(aVar, "SHA3-224", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA");
            k(aVar, "SHA3-256", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA");
            k(aVar, "SHA3-384", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA");
            k(aVar, "SHA3-512", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA");
            j(aVar, "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHAKE128WithRSAPSS", cq.b.f25791o);
            j(aVar, "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHAKE256WithRSAPSS", cq.b.f25792p);
            k(aVar, "SHA224", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSAandSHAKE128");
            k(aVar, "SHA256", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSAandSHAKE128");
            k(aVar, "SHA384", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSAandSHAKE128");
            k(aVar, "SHA512", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSAandSHAKE128");
            k(aVar, "SHA512(224)", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSAandSHAKE128");
            k(aVar, "SHA512(256)", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSAandSHAKE128");
            k(aVar, "SHA224", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSAandSHAKE256");
            k(aVar, "SHA256", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSAandSHAKE256");
            k(aVar, "SHA384", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSAandSHAKE256");
            k(aVar, "SHA512", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSAandSHAKE256");
            k(aVar, "SHA512(224)", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSAandSHAKE256");
            k(aVar, "SHA512(256)", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSAandSHAKE256");
            k(aVar, "SHA3-224", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSAandSHAKE128");
            k(aVar, "SHA3-256", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSAandSHAKE128");
            k(aVar, "SHA3-384", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSAandSHAKE128");
            k(aVar, "SHA3-512", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSAandSHAKE128");
            k(aVar, "SHA3-224", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSAandSHAKE256");
            k(aVar, "SHA3-256", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSAandSHAKE256");
            k(aVar, "SHA3-384", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSAandSHAKE256");
            k(aVar, "SHA3-512", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSAandSHAKE256");
            if (aVar.c("MessageDigest", "MD2")) {
                str2 = "SHA3-512";
                str = "SHA3-384";
                h(aVar, "MD2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", s.f46857y3);
            } else {
                str = "SHA3-384";
                str2 = "SHA3-512";
            }
            if (aVar.c("MessageDigest", "MD4")) {
                h(aVar, "MD4", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", s.f46860z3);
            }
            if (aVar.c("MessageDigest", "MD5")) {
                h(aVar, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", s.A3);
                i(aVar, "MD5", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
            }
            if (aVar.c("MessageDigest", "SHA1")) {
                aVar.h("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                aVar.h("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                k(aVar, "SHA1", "MGF1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                k(aVar, "SHA1", "SHAKE128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSAandSHAKE128");
                k(aVar, "SHA1", "SHAKE256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSAandSHAKE256");
                h(aVar, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", s.B3);
                i(aVar, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Alg.Alias.Signature.");
                y yVar5 = on.b.f44367k;
                sb2.append(yVar5);
                aVar.h(sb2.toString(), "SHA1WITHRSA");
                aVar.h("Alg.Alias.Signature.OID." + yVar5, "SHA1WITHRSA");
                l(aVar, "SHA1", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
            }
            h(aVar, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", s.K3);
            h(aVar, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", s.H3);
            h(aVar, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", s.I3);
            h(aVar, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", s.J3);
            h(aVar, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", s.L3);
            h(aVar, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", s.M3);
            h(aVar, "SHA3-224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224", kn.d.f37607j0);
            h(aVar, "SHA3-256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256", kn.d.f37609k0);
            h(aVar, str, "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384", kn.d.f37611l0);
            h(aVar, str2, "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512", kn.d.f37613m0);
            i(aVar, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
            i(aVar, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
            i(aVar, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
            i(aVar, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
            i(aVar, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
            i(aVar, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
            l(aVar, "SHA224", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
            l(aVar, "SHA256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
            l(aVar, "SHA384", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
            l(aVar, "SHA512", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
            l(aVar, "SHA512(224)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
            l(aVar, "SHA512(256)", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
            if (aVar.c("MessageDigest", "RIPEMD128")) {
                h(aVar, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", tn.b.f51365g);
                h(aVar, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", null);
                l(aVar, "RMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
                l(aVar, "RIPEMD128", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
            }
            if (aVar.c("MessageDigest", "RIPEMD160")) {
                h(aVar, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", tn.b.f51364f);
                h(aVar, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", null);
                aVar.h("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                aVar.h("Signature.RIPEMD160withRSA/ISO9796-2", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
                l(aVar, "RMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
                l(aVar, "RIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (aVar.c("MessageDigest", "RIPEMD256")) {
                h(aVar, "RIPEMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", tn.b.f51366h);
                h(aVar, "RMD256", "org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", null);
            }
            if (aVar.c("MessageDigest", "WHIRLPOOL")) {
                i(aVar, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                i(aVar, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                l(aVar, "Whirlpool", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
                l(aVar, "WHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            }
        }

        public final void h(uq.a aVar, String str, String str2, y yVar) {
            String str3 = str + "WITHRSA";
            String str4 = str + "withRSA";
            String str5 = str + "WithRSA";
            String str6 = str + "/RSA";
            String str7 = str + "WITHRSAENCRYPTION";
            String str8 = str + "withRSAEncryption";
            aVar.h("Signature." + str3, str2);
            aVar.h("Alg.Alias.Signature." + str4, str3);
            aVar.h("Alg.Alias.Signature." + str5, str3);
            aVar.h("Alg.Alias.Signature." + str7, str3);
            aVar.h("Alg.Alias.Signature." + str8, str3);
            aVar.h("Alg.Alias.Signature." + (str + "WithRSAEncryption"), str3);
            aVar.h("Alg.Alias.Signature." + str6, str3);
            if (yVar != null) {
                aVar.h("Alg.Alias.Signature." + yVar, str3);
                aVar.h("Alg.Alias.Signature.OID." + yVar, str3);
            }
        }

        public final void i(uq.a aVar, String str, String str2) {
            aVar.h("Alg.Alias.Signature." + str + "withRSA/ISO9796-2", str + "WITHRSA/ISO9796-2");
            aVar.h("Alg.Alias.Signature." + str + "WithRSA/ISO9796-2", str + "WITHRSA/ISO9796-2");
            aVar.h("Signature." + str + "WITHRSA/ISO9796-2", str2);
        }

        public final void j(uq.a aVar, String str, String str2, y yVar) {
            aVar.h("Alg.Alias.Signature." + str + "withRSA/PSS", str + "WITHRSAPSS");
            aVar.h("Alg.Alias.Signature." + str + "WithRSA/PSS", str + "WITHRSAPSS");
            aVar.h("Alg.Alias.Signature." + str + "withRSASSA-PSS", str + "WITHRSAPSS");
            aVar.h("Alg.Alias.Signature." + str + "WithRSASSA-PSS", str + "WITHRSAPSS");
            aVar.h("Alg.Alias.Signature." + str + "WITHRSASSA-PSS", str + "WITHRSAPSS");
            aVar.k("Signature", yVar, str2);
            aVar.h("Signature." + str + "WITHRSAPSS", str2);
        }

        public final void k(uq.a aVar, String str, String str2, String str3) {
            String str4 = "WITHRSAAND" + str2;
            if (str2.equals("MGF1")) {
                aVar.h("Alg.Alias.Signature." + str + "withRSA/PSS", str + str4);
                aVar.h("Alg.Alias.Signature." + str + "WithRSA/PSS", str + str4);
                aVar.h("Alg.Alias.Signature." + str + "withRSASSA-PSS", str + str4);
                aVar.h("Alg.Alias.Signature." + str + "WithRSASSA-PSS", str + str4);
                aVar.h("Alg.Alias.Signature." + str + "WITHRSASSA-PSS", str + str4);
            }
            aVar.h("Alg.Alias.Signature." + str + "withRSAand" + str2, str + str4);
            aVar.h("Alg.Alias.Signature." + str + "WithRSAAnd" + str2, str + str4);
            aVar.h("Signature." + str + "WITHRSAAND" + str2, str3);
        }

        public final void l(uq.a aVar, String str, String str2) {
            aVar.h("Alg.Alias.Signature." + str + "withRSA/X9.31", str + "WITHRSA/X9.31");
            aVar.h("Alg.Alias.Signature." + str + "WithRSA/X9.31", str + "WITHRSA/X9.31");
            aVar.h("Signature." + str + "WITHRSA/X9.31", str2);
        }
    }

    static {
        HashMap map = new HashMap();
        f41572b = map;
        map.put("SupportedKeyClasses", "javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
