package to;

import fp.j0;
import gm.z;
import np.n1;
import np.v1;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.l0;
import pn.q;
import so.q1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j implements q1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f51414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51415d = 1;

    public j(char[] cArr) {
        this.f51414c = cArr;
    }

    @Override // so.q1
    public byte[] b(int i10, zn.b bVar, int i11) throws CMSException {
        q qVarX = q.x(bVar.A());
        byte[] bArrB = i10 == 0 ? c0.b(this.f51414c) : c0.c(this.f51414c);
        try {
            j0 j0Var = new j0(p.f(qVarX.A()));
            j0Var.j(bArrB, qVarX.B(), qVarX.y().intValue());
            return ((n1) j0Var.e(i11)).a();
        } catch (Exception e10) {
            throw new CMSException("exception creating derived key: " + e10.getMessage(), e10);
        }
    }

    @Override // so.q1
    public int d() {
        return this.f51415d;
    }

    public n1 g(zn.b bVar, zn.b bVar2, byte[] bArr, byte[] bArr2) throws CMSException {
        l0 l0VarC = p.c(bVar.x());
        l0VarC.a(false, new v1(new n1(bArr), z.I(bVar.A()).J()));
        try {
            return new n1(l0VarC.c(bArr2, 0, bArr2.length));
        } catch (InvalidCipherTextException e10) {
            throw new CMSException("unable to unwrap key: " + e10.getMessage(), e10);
        }
    }

    @Override // so.q1
    public char[] getPassword() {
        return this.f51414c;
    }

    public j h(int i10) {
        this.f51415d = i10;
        return this;
    }
}
