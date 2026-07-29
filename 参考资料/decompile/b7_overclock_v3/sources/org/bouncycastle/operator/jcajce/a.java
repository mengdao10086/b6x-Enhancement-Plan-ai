package org.bouncycastle.operator.jcajce;

import gm.c0;
import gm.d2;
import gm.f2;
import gm.y;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import pn.s;
import pn.w;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public zn.b a(y yVar, AlgorithmParameters algorithmParameters) throws InvalidAlgorithmParameterException {
        try {
            return new zn.b(yVar, c0.D(algorithmParameters.getEncoded()));
        } catch (IOException e10) {
            throw new InvalidAlgorithmParameterException("unable to encode parameters object: " + e10.getMessage());
        }
    }

    public zn.b b(y yVar, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
        if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new InvalidAlgorithmParameterException("unknown parameter spec passed.");
        }
        if (algorithmParameterSpec.equals(OAEPParameterSpec.DEFAULT)) {
            return new zn.b(yVar, new w(w.f46872d, w.f46873e, w.f46874f));
        }
        OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        PSource pSource = oAEPParameterSpec.getPSource();
        if (!oAEPParameterSpec.getMGFAlgorithm().equals(OAEPParameterSpec.DEFAULT.getMGFAlgorithm())) {
            throw new InvalidAlgorithmParameterException("only " + OAEPParameterSpec.DEFAULT.getMGFAlgorithm() + " mask generator supported.");
        }
        zn.b bVarA = new cs.j().a(oAEPParameterSpec.getDigestAlgorithm());
        if (bVarA.A() == null) {
            bVarA = new zn.b(bVarA.x(), d2.f29657b);
        }
        zn.b bVarA2 = new cs.j().a(((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm());
        if (bVarA2.A() == null) {
            bVarA2 = new zn.b(bVarA2.x(), d2.f29657b);
        }
        return new zn.b(yVar, new w(bVarA, new zn.b(s.E3, bVarA2), new zn.b(s.F3, new f2(((PSource.PSpecified) pSource).getValue()))));
    }
}
