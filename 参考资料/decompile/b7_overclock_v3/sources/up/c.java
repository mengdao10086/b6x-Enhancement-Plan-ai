package up;

import gm.y;
import ir.e;
import ir.i;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.eac.EACException;
import qr.f;
import qr.g;
import sm.l;
import sm.m;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f52385a = new a();

    public static ir.e a(EllipticCurve ellipticCurve, BigInteger bigInteger, int i10) {
        ECField field = ellipticCurve.getField();
        BigInteger a10 = ellipticCurve.getA();
        BigInteger b10 = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return new e.f(((ECFieldFp) field).getP(), a10, b10, bigInteger, BigInteger.valueOf(i10));
        }
        throw new IllegalStateException("not implemented yet!!!");
    }

    public static EllipticCurve b(ir.e eVar) {
        return new EllipticCurve(c(eVar.u()), eVar.o().v(), eVar.q().v(), null);
    }

    public static ECField c(qr.b bVar) {
        if (ir.c.p(bVar)) {
            return new ECFieldFp(bVar.e());
        }
        f fVarC = ((g) bVar).c();
        int[] iArrB = fVarC.b();
        return new ECFieldF2m(fVarC.a(), org.bouncycastle.util.a.O0(org.bouncycastle.util.a.Y(iArrB, 1, iArrB.length - 1)));
    }

    public static i d(ir.e eVar, ECPoint eCPoint) {
        return eVar.h(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    public final PublicKey e(sm.i iVar) throws EACException, InvalidKeySpecException {
        try {
            return this.f52385a.b("ECDSA").generatePublic(new ECPublicKeySpec(i(iVar), g(iVar)));
        } catch (NoSuchAlgorithmException e10) {
            throw new EACException("cannot find algorithm ECDSA: " + e10.getMessage(), e10);
        } catch (NoSuchProviderException e11) {
            throw new EACException("cannot find provider: " + e11.getMessage(), e11);
        }
    }

    public PublicKey f(l lVar) throws EACException, InvalidKeySpecException {
        if (lVar.y().Q(sm.g.f49917r)) {
            return e((sm.i) lVar);
        }
        m mVar = (m) lVar;
        try {
            return this.f52385a.b("RSA").generatePublic(new RSAPublicKeySpec(mVar.z(), mVar.A()));
        } catch (NoSuchAlgorithmException e10) {
            throw new EACException("cannot find algorithm ECDSA: " + e10.getMessage(), e10);
        } catch (NoSuchProviderException e11) {
            throw new EACException("cannot find provider: " + e11.getMessage(), e11);
        }
    }

    public final ECParameterSpec g(sm.i iVar) {
        if (!iVar.H()) {
            throw new IllegalArgumentException("Public key does not contains EC Params");
        }
        e.f fVar = new e.f(iVar.E(), iVar.C(), iVar.G(), iVar.D(), iVar.B());
        i iVarK = fVar.k(iVar.A());
        return new ECParameterSpec(b(fVar), new ECPoint(iVarK.f().v(), iVarK.g().v()), iVar.D(), iVar.B().intValue());
    }

    public l h(y yVar, PublicKey publicKey) {
        if (publicKey instanceof RSAPublicKey) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
            return new m(yVar, rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
        ECParameterSpec params = eCPublicKey.getParams();
        EllipticCurve curve = params.getCurve();
        ir.e eVarA = a(curve, params.getOrder(), params.getCofactor());
        return new sm.i(yVar, ((ECFieldFp) curve.getField()).getP(), curve.getA(), curve.getB(), d(eVarA, params.getGenerator()).l(false), params.getOrder(), d(eVarA, eCPublicKey.getW()).l(false), params.getCofactor());
    }

    public final ECPoint i(sm.i iVar) {
        if (!iVar.H()) {
            throw new IllegalArgumentException("Public key does not contains EC Params");
        }
        i.e eVar = (i.e) new e.f(iVar.E(), iVar.C(), iVar.G(), iVar.D(), iVar.B()).k(iVar.F());
        return new ECPoint(eVar.f().v(), eVar.g().v());
    }

    public c j(String str) {
        this.f52385a = new d(str);
        return this;
    }

    public c k(Provider provider) {
        this.f52385a = new e(provider);
        return this;
    }
}
