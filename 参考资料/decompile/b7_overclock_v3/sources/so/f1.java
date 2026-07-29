package so;

import java.io.IOException;
import java.util.List;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class f1 extends x1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public mm.c0 f50168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.z f50169i;

    public f1(mm.c0 c0Var, v1 v1Var, gm.z zVar, zn.b bVar, i0 i0Var, a aVar) {
        super(c0Var.z(), bVar, i0Var, aVar);
        this.f50168h = c0Var;
        this.f50340a = v1Var;
        this.f50169i = zVar;
    }

    public static void q(List list, mm.c0 c0Var, zn.b bVar, i0 i0Var, a aVar) {
        gm.f0 f0VarB = c0Var.B();
        for (int i10 = 0; i10 < f0VarB.size(); i10++) {
            mm.m0 m0VarA = mm.m0.A(f0VarB.K(i10));
            mm.b0 b0VarY = m0VarA.y();
            mm.y yVarZ = b0VarY.z();
            list.add(new f1(c0Var, yVarZ != null ? new d1(yVarZ.y(), yVarZ.z().K()) : new d1(b0VarY.A().B().J()), m0VarA.x(), bVar, i0Var, aVar));
        }
    }

    @Override // so.x1
    public z1 k(u1 u1Var) throws CMSException, IOException {
        c1 c1Var = (c1) u1Var;
        return c1Var.c(this.f50341b, this.f50342c, o(c1Var.f(), this.f50168h.A()), this.f50168h.C(), this.f50169i.J());
    }

    public mm.f0 l() {
        return this.f50168h.A();
    }

    public final zn.c1 m(l1 l1Var) throws CMSException {
        throw new CMSException("No support for 'originator' as IssuerAndSerialNumber or SubjectKeyIdentifier");
    }

    public final zn.c1 n(zn.b bVar, mm.h0 h0Var) {
        return new zn.c1(bVar, h0Var.A().H());
    }

    public final zn.c1 o(zn.b bVar, mm.f0 f0Var) throws CMSException, IOException {
        mm.h0 h0VarB = f0Var.B();
        if (h0VarB != null) {
            return n(bVar, h0VarB);
        }
        mm.y yVarA = f0Var.A();
        return m(yVarA != null ? new l1(yVarA.y(), yVarA.z().K()) : new l1(f0Var.C().A()));
    }

    public byte[] p() {
        gm.z zVarC = this.f50168h.C();
        if (zVarC != null) {
            return org.bouncycastle.util.a.p(zVarC.J());
        }
        return null;
    }
}
