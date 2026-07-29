package sp;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.dvcs.DVCSParsingException;
import zn.c0;
import zn.s0;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public rm.g f50374a;

    public i(rm.g gVar) {
        this.f50374a = gVar;
    }

    public i(byte[] bArr) {
        this(rm.g.B(bArr));
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj == null && obj2 == null) || (obj != null && obj.equals(obj2));
    }

    public static boolean k(i iVar, i iVar2) {
        rm.g gVar = iVar.f50374a;
        rm.g gVar2 = iVar2.f50374a;
        if (gVar.H() != gVar2.H() || !a(gVar.G(), gVar2.G()) || !a(gVar.E(), gVar2.E()) || !a(gVar.D(), gVar2.D()) || !a(gVar.z(), gVar2.z())) {
            return false;
        }
        if (gVar.C() == null) {
            return true;
        }
        if (gVar2.C() == null) {
            return false;
        }
        byte[] byteArray = gVar.C().toByteArray();
        byte[] byteArray2 = gVar2.C().toByteArray();
        return byteArray2.length >= byteArray.length && org.bouncycastle.util.a.g(byteArray, org.bouncycastle.util.a.W(byteArray2, 0, byteArray.length));
    }

    public c0 b() {
        return this.f50374a.x();
    }

    public c0 c() {
        return this.f50374a.y();
    }

    public BigInteger d() {
        return this.f50374a.C();
    }

    public s0 e() {
        if (this.f50374a.D() != null) {
            return this.f50374a.D();
        }
        return null;
    }

    public Date f() throws DVCSParsingException {
        rm.j jVarE = this.f50374a.E();
        if (jVarE == null) {
            return null;
        }
        try {
            return jVarE.x() != null ? jVarE.x().K() : new gt.h(jVarE.A()).i().d();
        } catch (Exception e10) {
            throw new DVCSParsingException("unable to extract time: " + e10.getMessage(), e10);
        }
    }

    public c0 g() {
        return this.f50374a.F();
    }

    public int h() {
        return this.f50374a.G().z().intValue();
    }

    public int i() {
        return this.f50374a.H();
    }

    public rm.g j() {
        return this.f50374a;
    }
}
