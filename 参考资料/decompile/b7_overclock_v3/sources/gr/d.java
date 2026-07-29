package gr;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/* JADX INFO: loaded from: classes5.dex */
public class d extends ECParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f29942a;

    public d(String str, ir.e eVar, ir.i iVar, BigInteger bigInteger) {
        super(a(eVar, null), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(iVar), bigInteger, 1);
        this.f29942a = str;
    }

    public d(String str, ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        super(a(eVar, null), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(iVar), bigInteger, bigInteger2.intValue());
        this.f29942a = str;
    }

    public d(String str, ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(a(eVar, bArr), org.bouncycastle.jcajce.provider.asymmetric.util.h.f(iVar), bigInteger, bigInteger2.intValue());
        this.f29942a = str;
    }

    public d(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.f29942a = str;
    }

    public d(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.f29942a = str;
    }

    public static EllipticCurve a(ir.e eVar, byte[] bArr) {
        return new EllipticCurve(b(eVar.u()), eVar.o().v(), eVar.q().v(), bArr);
    }

    public static ECField b(qr.b bVar) {
        if (ir.c.p(bVar)) {
            return new ECFieldFp(bVar.e());
        }
        qr.f fVarC = ((qr.g) bVar).c();
        int[] iArrB = fVarC.b();
        return new ECFieldF2m(fVarC.a(), org.bouncycastle.util.a.O0(org.bouncycastle.util.a.Y(iArrB, 1, iArrB.length - 1)));
    }

    public String c() {
        return this.f29942a;
    }
}
