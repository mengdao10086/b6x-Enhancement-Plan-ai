package so;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.n f50314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.s f50315b;

    public t(mm.n nVar) {
        this.f50314a = nVar;
        this.f50315b = mm.s.y(nVar.x());
    }

    public byte[] a(cs.t tVar) throws CMSException {
        try {
            return t0.w(b(tVar).b());
        } catch (IOException e10) {
            throw new CMSException("unable to parse internal stream: " + e10.getMessage(), e10);
        }
    }

    public s0 b(cs.t tVar) throws CMSException {
        try {
            mm.q qVarX = this.f50315b.x();
            return new s0(qVarX.y(), tVar.a(qVarX.x()).b(new ByteArrayInputStream(qVarX.z().J())));
        } catch (Exception e10) {
            throw new CMSException("unable to create stream: " + e10.getMessage(), e10);
        }
    }

    public mm.n c() {
        return this.f50314a;
    }
}
