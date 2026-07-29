package org.bouncycastle.jcajce.provider.asymmetric.x509;

import co.r;
import cr.h;
import gm.d2;
import gm.f0;
import gm.u;
import gm.y;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.a0;
import pn.s;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<y, String> f45101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f45102b;

    static {
        HashMap map = new HashMap();
        f45101a = map;
        map.put(tm.a.f51340d, h.f25815b);
        map.put(tm.a.f51341e, h.f25816c);
        map.put(on.b.f44366j, "SHA1withDSA");
        map.put(r.X0, "SHA1withDSA");
        f45102b = d2.f29657b;
    }

    public static String a(y yVar) {
        String strE;
        String strE2;
        Provider provider = Security.getProvider(BouncyCastleProvider.f45329b);
        if (provider != null && (strE2 = e(provider, yVar)) != null) {
            return strE2;
        }
        Provider[] providers = Security.getProviders();
        for (int i10 = 0; i10 != providers.length; i10++) {
            if (provider != providers[i10] && (strE = e(providers[i10], yVar)) != null) {
                return strE;
            }
        }
        return yVar.L();
    }

    public static String b(y yVar) {
        String strA = org.bouncycastle.jcajce.util.f.a(yVar);
        int iIndexOf = strA.indexOf(45);
        if (iIndexOf <= 0 || strA.startsWith("SHA3")) {
            return strA;
        }
        return strA.substring(0, iIndexOf) + strA.substring(iIndexOf + 1);
    }

    public static String c(zn.b bVar) {
        gm.h hVarA = bVar.A();
        if (hVarA != null && !f45102b.B(hVarA)) {
            if (bVar.x().C(s.G3)) {
                return b(a0.y(hVarA).x().x()) + "withRSAandMGF1";
            }
            if (bVar.x().C(r.f11176m0)) {
                return b((y) f0.J(hVarA).K(0)) + "withECDSA";
            }
        }
        String str = f45101a.get(bVar.x());
        return str != null ? str : a(bVar.x());
    }

    public static boolean d(zn.b bVar) {
        return in.c.N.C(bVar.x());
    }

    public static String e(Provider provider, y yVar) {
        String property = provider.getProperty("Alg.Alias.Signature." + yVar);
        if (property != null) {
            return property;
        }
        String property2 = provider.getProperty("Alg.Alias.Signature.OID." + yVar);
        if (property2 != null) {
            return property2;
        }
        return null;
    }

    public static void f(byte[] bArr, StringBuffer stringBuffer, String str) {
        int length = bArr.length;
        stringBuffer.append("            Signature: ");
        if (length <= 20) {
            stringBuffer.append(jt.h.j(bArr));
            stringBuffer.append(str);
            return;
        }
        stringBuffer.append(jt.h.k(bArr, 0, 20));
        stringBuffer.append(str);
        int i10 = 20;
        while (i10 < bArr.length) {
            int length2 = bArr.length - 20;
            stringBuffer.append("                       ");
            stringBuffer.append(i10 < length2 ? jt.h.k(bArr, i10, 20) : jt.h.k(bArr, i10, bArr.length - i10));
            stringBuffer.append(str);
            i10 += 20;
        }
    }

    public static void g(Signature signature, gm.h hVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (hVar == null || f45102b.B(hVar)) {
            return;
        }
        AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
        try {
            algorithmParameters.init(hVar.b().getEncoded());
            if (signature.getAlgorithm().endsWith("MGF1")) {
                try {
                    signature.setParameter(algorithmParameters.getParameterSpec(PSSParameterSpec.class));
                } catch (GeneralSecurityException e10) {
                    throw new SignatureException("Exception extracting parameters: " + e10.getMessage());
                }
            }
        } catch (IOException e11) {
            throw new SignatureException("IOException decoding parameters: " + e11.getMessage());
        }
    }
}
