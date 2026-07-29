package gt;

import gm.s;
import gm.z2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import lm.u;
import lm.v;
import mm.n;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TSPValidationException;
import un.l;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f30043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f30044b;

    public f(z2 z2Var) throws TSPException, IOException {
        try {
            this.f30043a = l.x(z2Var);
            this.f30044b = new h(n.A(z2Var.K(1)));
        } catch (ClassCastException e10) {
            throw new TSPException("malformed timestamp response: " + e10, e10);
        } catch (IllegalArgumentException e11) {
            throw new TSPException("malformed timestamp response: " + e11, e11);
        }
    }

    public f(InputStream inputStream) throws TSPException, IOException {
        this(g(inputStream));
    }

    public f(l lVar) throws TSPException, IOException {
        this.f30043a = lVar;
        if (lVar.z() != null) {
            this.f30044b = new h(lVar.z());
        }
    }

    public f(byte[] bArr) throws TSPException, IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public static l g(InputStream inputStream) throws TSPException, IOException {
        try {
            return l.x(new s(inputStream).n());
        } catch (ClassCastException e10) {
            throw new TSPException("malformed timestamp response: " + e10, e10);
        } catch (IllegalArgumentException e11) {
            throw new TSPException("malformed timestamp response: " + e11, e11);
        }
    }

    public byte[] a() throws IOException {
        return this.f30043a.getEncoded();
    }

    public byte[] b(String str) throws IOException {
        return (gm.j.f29714b.equals(str) ? this.f30044b == null ? new z2(this.f30043a.y()) : new z2(new gm.h[]{this.f30043a.y(), this.f30044b.l().q()}) : this.f30043a).v(str);
    }

    public u c() {
        if (this.f30043a.y().x() != null) {
            return new u(this.f30043a.y().x());
        }
        return null;
    }

    public int d() {
        return this.f30043a.y().A().intValue();
    }

    public String e() {
        if (this.f30043a.y().B() == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        v vVarB = this.f30043a.y().B();
        for (int i10 = 0; i10 != vVarB.size(); i10++) {
            stringBuffer.append(vVarB.A(i10).d());
        }
        return stringBuffer.toString();
    }

    public h f() {
        return this.f30044b;
    }

    public void h(d dVar) throws TSPException {
        h hVarF = f();
        if (hVarF == null) {
            if (d() == 0 || d() == 1) {
                throw new TSPValidationException("no time stamp token found and one expected.");
            }
            return;
        }
        j jVarI = hVarF.i();
        if (dVar.l() != null && !dVar.l().equals(jVarI.i())) {
            throw new TSPValidationException("response contains wrong nonce value.");
        }
        if (d() != 0 && d() != 1) {
            throw new TSPValidationException("time stamp token found in failed request.");
        }
        if (!org.bouncycastle.util.a.I(dVar.j(), jVarI.h())) {
            throw new TSPValidationException("response for different message imprint digest.");
        }
        if (!jVarI.g().C(dVar.i())) {
            throw new TSPValidationException("response for different message imprint algorithm.");
        }
        mm.a aVarD = hVarF.g().d(pn.s.f46853w5);
        mm.a aVarD2 = hVarF.g().d(pn.s.f46856x5);
        if (aVarD == null && aVarD2 == null) {
            throw new TSPValidationException("no signing certificate attribute present.");
        }
        if (dVar.m() != null && !dVar.m().C(jVarI.j())) {
            throw new TSPValidationException("TSA policy wrong for request.");
        }
    }
}
