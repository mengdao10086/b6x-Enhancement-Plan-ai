package so;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class i1 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cs.d f50190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.y f50191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f50192c;

    public i1(mm.y yVar, cs.d dVar) {
        this.f50191b = yVar;
        this.f50190a = dVar;
    }

    public i1(byte[] bArr, cs.d dVar) {
        this.f50192c = bArr;
        this.f50190a = dVar;
    }

    @Override // so.w1
    public final mm.o0 a(cs.q qVar) throws CMSException {
        try {
            byte[] bArrB = this.f50190a.b(qVar);
            mm.y yVar = this.f50191b;
            return new mm.o0(new mm.d0(yVar != null ? new mm.n0(yVar) : new mm.n0((gm.z) new gm.f2(this.f50192c)), this.f50190a.a(), new gm.f2(bArrB)));
        } catch (OperatorException e10) {
            throw new CMSException("exception wrapping content key: " + e10.getMessage(), e10);
        }
    }
}
