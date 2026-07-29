package so;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a1 implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mm.z f50059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cs.i0 f50060b;

    public a1(mm.z zVar, cs.i0 i0Var) {
        this.f50059a = zVar;
        this.f50060b = i0Var;
    }

    @Override // so.w1
    public final mm.o0 a(cs.q qVar) throws CMSException {
        try {
            return new mm.o0(new mm.a0(this.f50059a, this.f50060b.a(), new gm.f2(this.f50060b.b(qVar))));
        } catch (OperatorException e10) {
            throw new CMSException("exception wrapping content key: " + e10.getMessage(), e10);
        }
    }
}
