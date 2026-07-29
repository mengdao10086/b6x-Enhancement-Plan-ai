package fo;

import cs.y;
import gm.j;
import gm.j2;
import gm.u1;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lm.o;
import lm.s;
import lm.v;
import lm.w;
import lm.x;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.cmp.CMPException;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x f28538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f28539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f28540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f28541d;

    public g(int i10, b0 b0Var, b0 b0Var2) {
        this.f28540c = new ArrayList();
        this.f28541d = new ArrayList();
        this.f28538a = new x(i10, b0Var, b0Var2);
    }

    public g(b0 b0Var, b0 b0Var2) {
        this(2, b0Var, b0Var2);
    }

    public g a(X509CertificateHolder x509CertificateHolder) {
        this.f28541d.add(x509CertificateHolder);
        return this;
    }

    public g b(o oVar) {
        this.f28540c.add(oVar);
        return this;
    }

    public f c(cs.f fVar) throws CMPException {
        if (this.f28539b == null) {
            throw new IllegalStateException("body must be set before building");
        }
        g(fVar.a());
        w wVarB = this.f28538a.b();
        try {
            return h(wVarB, new u1(f(fVar, wVarB, this.f28539b)));
        } catch (IOException e10) {
            throw new CMPException("unable to encode signature input: " + e10.getMessage(), e10);
        }
    }

    public f d(y yVar) throws CMPException {
        if (this.f28539b == null) {
            throw new IllegalStateException("body must be set before building");
        }
        g(yVar.a());
        w wVarB = this.f28538a.b();
        try {
            return h(wVarB, new u1(e(yVar, wVarB, this.f28539b)));
        } catch (IOException e10) {
            throw new CMPException("unable to encode MAC input: " + e10.getMessage(), e10);
        }
    }

    public final byte[] e(y yVar, w wVar, s sVar) throws IOException {
        gm.i iVar = new gm.i();
        iVar.a(wVar);
        iVar.a(sVar);
        OutputStream outputStreamB = yVar.b();
        outputStreamB.write(new j2(iVar).v(j.f29713a));
        outputStreamB.close();
        return yVar.d();
    }

    public final byte[] f(cs.f fVar, w wVar, s sVar) throws IOException {
        gm.i iVar = new gm.i();
        iVar.a(wVar);
        iVar.a(sVar);
        OutputStream outputStreamB = fVar.b();
        outputStreamB.write(new j2(iVar).v(j.f29713a));
        outputStreamB.close();
        return fVar.getSignature();
    }

    public final void g(zn.b bVar) {
        this.f28538a.j(bVar);
        if (this.f28540c.isEmpty()) {
            return;
        }
        this.f28538a.h((o[]) this.f28540c.toArray(new o[this.f28540c.size()]));
    }

    public final f h(w wVar, u1 u1Var) {
        if (this.f28541d.isEmpty()) {
            return new f(new lm.y(wVar, this.f28539b, u1Var));
        }
        int size = this.f28541d.size();
        lm.b[] bVarArr = new lm.b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = new lm.b(((X509CertificateHolder) this.f28541d.get(i10)).y());
        }
        return new f(new lm.y(wVar, this.f28539b, u1Var, bVarArr));
    }

    public g i(s sVar) {
        this.f28539b = sVar;
        return this;
    }

    public g j(v vVar) {
        this.f28538a.e(vVar);
        return this;
    }

    public g k(Date date) {
        this.f28538a.i(new gm.o(date));
        return this;
    }

    public g l(byte[] bArr) {
        this.f28538a.l(bArr);
        return this;
    }

    public g m(byte[] bArr) {
        this.f28538a.n(bArr);
        return this;
    }

    public g n(byte[] bArr) {
        this.f28538a.p(bArr);
        return this;
    }

    public g o(byte[] bArr) {
        this.f28538a.r(bArr);
        return this;
    }

    public g p(byte[] bArr) {
        this.f28538a.t(bArr);
        return this;
    }
}
