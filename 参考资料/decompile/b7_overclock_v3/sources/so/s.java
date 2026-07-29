package so;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class s implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.n f50299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.p f50300b;

    public s(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public s(mm.n nVar) throws CMSException {
        this.f50299a = nVar;
        try {
            this.f50300b = mm.p.B(nVar.x());
        } catch (ClassCastException e10) {
            throw new CMSException("Malformed content.", e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("Malformed content.", e11);
        }
    }

    public s(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public gm.y a() {
        return this.f50299a.y();
    }

    public zn.b b() {
        return this.f50300b.y();
    }

    public d0 c() throws CMSException {
        mm.n nVarZ = this.f50300b.z();
        try {
            return new e0(nVarZ.y(), ((gm.z) nVarZ.x()).J());
        } catch (Exception e10) {
            throw new CMSException("exception reading digested stream.", e10);
        }
    }

    public mm.n d() {
        return this.f50299a;
    }

    public boolean e(cs.p pVar) throws CMSException {
        try {
            mm.n nVarZ = this.f50300b.z();
            cs.o oVarA = pVar.a(this.f50300b.y());
            oVarA.b().write(((gm.z) nVarZ.x()).J());
            return org.bouncycastle.util.a.g(this.f50300b.x(), oVarA.c());
        } catch (IOException e10) {
            throw new CMSException("unable process content: " + e10.getMessage(), e10);
        } catch (OperatorCreationException e11) {
            throw new CMSException("unable to create digest calculator: " + e11.getMessage(), e11);
        }
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50299a.getEncoded();
    }
}
