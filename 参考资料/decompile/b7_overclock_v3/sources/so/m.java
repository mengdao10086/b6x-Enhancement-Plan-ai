package so;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class m implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.n f50227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.l f50228b;

    public m(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public m(mm.n nVar) throws CMSException {
        this.f50227a = nVar;
        try {
            this.f50228b = mm.l.A(nVar.x());
        } catch (ClassCastException e10) {
            throw new CMSException("Malformed content.", e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("Malformed content.", e11);
        }
    }

    public m(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public gm.y a() {
        return this.f50228b.y().y();
    }

    public byte[] b(cs.v vVar) throws CMSException {
        try {
            return t0.w(vVar.a(this.f50228b.x()).b(((gm.z) this.f50228b.y().x()).a()));
        } catch (IOException e10) {
            throw new CMSException("exception reading compressed stream.", e10);
        }
    }

    public s0 c(cs.v vVar) {
        mm.n nVarY = this.f50228b.y();
        return new s0(nVarY.y(), vVar.a(this.f50228b.x()).b(((gm.z) nVarY.x()).a()));
    }

    public gm.y d() {
        return this.f50227a.y();
    }

    public mm.n e() {
        return this.f50227a;
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50227a.getEncoded();
    }
}
