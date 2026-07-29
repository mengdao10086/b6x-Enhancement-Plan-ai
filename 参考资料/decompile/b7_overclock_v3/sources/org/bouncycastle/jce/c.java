package org.bouncycastle.jce;

import ir.e;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes5.dex */
public class c {
    public static ECPoint a(EllipticCurve ellipticCurve, byte[] bArr) {
        ir.e c0401e;
        if (ellipticCurve.getField() instanceof ECFieldFp) {
            c0401e = new e.f(((ECFieldFp) ellipticCurve.getField()).getP(), ellipticCurve.getA(), ellipticCurve.getB());
        } else {
            int[] midTermsOfReductionPolynomial = ((ECFieldF2m) ellipticCurve.getField()).getMidTermsOfReductionPolynomial();
            c0401e = midTermsOfReductionPolynomial.length == 3 ? new e.C0401e(((ECFieldF2m) ellipticCurve.getField()).getM(), midTermsOfReductionPolynomial[2], midTermsOfReductionPolynomial[1], midTermsOfReductionPolynomial[0], ellipticCurve.getA(), ellipticCurve.getB()) : new e.C0401e(((ECFieldF2m) ellipticCurve.getField()).getM(), midTermsOfReductionPolynomial[0], ellipticCurve.getA(), ellipticCurve.getB());
        }
        return org.bouncycastle.jcajce.provider.asymmetric.util.h.f(c0401e.k(bArr));
    }
}
