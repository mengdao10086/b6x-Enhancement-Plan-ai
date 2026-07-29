package ht;

import cs.o;
import cs.p;
import gm.c2;
import gm.s;
import gm.y;
import gt.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import mm.k;
import mm.n;
import mm.v;
import mm.x0;
import mm.y0;
import mm.z0;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.cms.ImprintDigestInvalidException;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f31438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f31439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f31440c;

    public a(InputStream inputStream) throws IOException {
        try {
            l(n.A(new s(inputStream).n()));
        } catch (ClassCastException e10) {
            throw new IOException("Malformed content: " + e10);
        } catch (IllegalArgumentException e11) {
            throw new IOException("Malformed content: " + e11);
        }
    }

    public a(n nVar) {
        l(nVar);
    }

    public a(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public a a(h hVar) throws CMSException {
        x0[] x0VarArrI = this.f31440c.i();
        x0[] x0VarArr = new x0[x0VarArrI.length + 1];
        System.arraycopy(x0VarArrI, 0, x0VarArr, 0, x0VarArrI.length);
        x0VarArr[x0VarArrI.length] = new x0(hVar.l().q());
        return new a(new n(k.S2, new z0(this.f31438a.y(), this.f31438a.B(), this.f31438a.x(), new v(new y0(x0VarArr)))));
    }

    public byte[] b(o oVar) throws CMSException {
        return this.f31440c.a(oVar);
    }

    public byte[] c() {
        if (this.f31438a.x() != null) {
            return this.f31438a.x().J();
        }
        return null;
    }

    public URI d() throws URISyntaxException {
        c2 c2VarY = this.f31438a.y();
        if (c2VarY != null) {
            return new URI(c2VarY.d());
        }
        return null;
    }

    public byte[] e() throws IOException {
        return this.f31439b.getEncoded();
    }

    public String f() {
        return this.f31440c.c();
    }

    public String g() {
        return this.f31440c.d();
    }

    public o h(p pVar) throws OperatorCreationException {
        return this.f31440c.e(pVar);
    }

    public mm.b i() {
        return this.f31440c.f();
    }

    public h[] j() throws CMSException {
        return this.f31440c.h();
    }

    public void k(o oVar) throws CMSException {
        this.f31440c.j(oVar);
    }

    public final void l(n nVar) {
        this.f31439b = nVar;
        y yVar = k.S2;
        if (yVar.C(nVar.y())) {
            z0 z0VarA = z0.A(nVar.x());
            this.f31438a = z0VarA;
            this.f31440c = new f(z0VarA);
        } else {
            throw new IllegalArgumentException("Malformed content - type must be " + yVar.L());
        }
    }

    public void m(p pVar, byte[] bArr) throws ImprintDigestInvalidException, CMSException {
        this.f31440c.k(pVar, bArr);
    }

    public void n(p pVar, byte[] bArr, h hVar) throws ImprintDigestInvalidException, CMSException {
        this.f31440c.l(pVar, bArr, hVar);
    }
}
