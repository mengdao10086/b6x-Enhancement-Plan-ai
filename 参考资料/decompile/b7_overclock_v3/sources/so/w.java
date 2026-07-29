package so;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.cms.CMSException;
import so.b0;

/* JADX INFO: loaded from: classes5.dex */
public class w implements org.bouncycastle.util.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y1 f50332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm.n f50333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f50334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.h0 f50335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n1 f50336e;

    public w(InputStream inputStream) throws CMSException {
        this(t0.u(inputStream));
    }

    public w(mm.n nVar) throws CMSException {
        this.f50333b = nVar;
        try {
            mm.t tVarA = mm.t.A(nVar.x());
            if (tVarA.B() != null) {
                this.f50336e = new n1(tVarA.B());
            }
            gm.h0 h0VarC = tVarA.C();
            mm.q qVarY = tVarA.y();
            this.f50334c = qVarY.x();
            this.f50332a = b0.a(h0VarC, this.f50334c, new b0.c(this.f50334c, qVarY.y(), new e0(qVarY.z().J())));
            this.f50335d = tVarA.D();
        } catch (ClassCastException e10) {
            throw new CMSException("Malformed content.", e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("Malformed content.", e11);
        }
    }

    public w(byte[] bArr) throws CMSException {
        this(t0.v(bArr));
    }

    public final byte[] a(gm.h hVar) throws IOException {
        if (hVar != null) {
            return hVar.b().getEncoded();
        }
        return null;
    }

    public zn.b b() {
        return this.f50334c;
    }

    public String c() {
        return this.f50334c.x().L();
    }

    public byte[] d() {
        try {
            return a(this.f50334c.A());
        } catch (Exception e10) {
            throw new RuntimeException("exception getting encryption parameters " + e10);
        }
    }

    public n1 e() {
        return this.f50336e;
    }

    public y1 f() {
        return this.f50332a;
    }

    public mm.b g() {
        gm.h0 h0Var = this.f50335d;
        if (h0Var == null) {
            return null;
        }
        return new mm.b(h0Var);
    }

    @Override // org.bouncycastle.util.g
    public byte[] getEncoded() throws IOException {
        return this.f50333b.getEncoded();
    }

    public mm.n h() {
        return this.f50333b;
    }
}
