package org.bouncycastle.jcajce.provider.asymmetric.ec;

import co.j;
import co.l;
import co.n;
import gm.d2;
import gm.u;
import gm.y;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.util.i;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static np.c a(PublicKey publicKey) throws InvalidKeyException {
        return publicKey instanceof BCECPublicKey ? ((BCECPublicKey) publicKey).d() : i.d(publicKey);
    }

    public static l b(ECGenParameterSpec eCGenParameterSpec, uq.c cVar) {
        return d(eCGenParameterSpec.getName(), cVar);
    }

    public static j c(ECParameterSpec eCParameterSpec, boolean z10) {
        if (!(eCParameterSpec instanceof gr.d)) {
            if (eCParameterSpec == null) {
                return new j((u) d2.f29657b);
            }
            ir.e eVarA = org.bouncycastle.jcajce.provider.asymmetric.util.h.a(eCParameterSpec.getCurve());
            return new j(new l(eVarA, new n(org.bouncycastle.jcajce.provider.asymmetric.util.h.d(eVarA, eCParameterSpec.getGenerator()), z10), eCParameterSpec.getOrder(), BigInteger.valueOf(eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed()));
        }
        gr.d dVar = (gr.d) eCParameterSpec;
        y yVarL = i.l(dVar.c());
        if (yVarL == null) {
            yVarL = new y(dVar.c());
        }
        return new j(yVarL);
    }

    public static l d(String str, uq.c cVar) {
        if (str == null || str.length() < 1) {
            return null;
        }
        int iIndexOf = str.indexOf(32);
        if (iIndexOf > 0) {
            str = str.substring(iIndexOf + 1);
        }
        y yVarE = e(str);
        if (yVarE == null) {
            return i.i(str);
        }
        l lVarJ = i.j(yVarE);
        return (lVarJ != null || cVar == null) ? lVarJ : (l) cVar.a().get(yVarE);
    }

    public static y e(String str) {
        char cCharAt = str.charAt(0);
        if (cCharAt < '0' || cCharAt > '2') {
            return null;
        }
        try {
            return new y(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
