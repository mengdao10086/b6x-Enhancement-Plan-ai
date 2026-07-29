package org.bouncycastle.jce.provider;

import gm.d2;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PSSParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gm.u f45489a = d2.f29657b;

    public static String a(gm.y yVar) {
        return pn.s.f46803f4.C(yVar) ? "MD5" : on.b.f44365i.C(yVar) ? "SHA1" : kn.d.f37598f.C(yVar) ? "SHA224" : kn.d.f37592c.C(yVar) ? "SHA256" : kn.d.f37594d.C(yVar) ? "SHA384" : kn.d.f37596e.C(yVar) ? "SHA512" : tn.b.f51361c.C(yVar) ? "RIPEMD128" : tn.b.f51360b.C(yVar) ? "RIPEMD160" : tn.b.f51362d.C(yVar) ? "RIPEMD256" : qm.a.f47452b.C(yVar) ? "GOST3411" : yVar.L();
    }

    public static String b(zn.b bVar) {
        gm.h hVarA = bVar.A();
        if (hVarA != null && !f45489a.B(hVarA)) {
            if (bVar.x().C(pn.s.G3)) {
                return a(pn.a0.y(hVarA).x().x()) + "withRSAandMGF1";
            }
            if (bVar.x().C(co.r.f11176m0)) {
                return a(gm.y.N(gm.f0.J(hVarA).K(0))) + "withECDSA";
            }
        }
        return bVar.x().L();
    }

    public static void c(Signature signature, gm.h hVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (hVar == null || f45489a.B(hVar)) {
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
