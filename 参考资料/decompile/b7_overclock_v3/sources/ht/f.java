package ht;

import cs.o;
import cs.p;
import gm.j;
import gt.h;
import java.io.IOException;
import java.io.OutputStream;
import mm.a1;
import mm.x0;
import mm.z0;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.cms.ImprintDigestInvalidException;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0[] f31446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f31447b;

    public f(a1 a1Var) throws IOException {
        this.f31447b = new e(a1Var.e());
        this.f31446a = a1Var.f().A().A();
    }

    public f(z0 z0Var) {
        this.f31447b = new e(z0Var.B());
        this.f31446a = z0Var.C().A().A();
    }

    public byte[] a(o oVar) throws CMSException {
        x0 x0Var = this.f31446a[r0.length - 1];
        OutputStream outputStreamB = oVar.b();
        try {
            outputStreamB.write(x0Var.v(j.f29713a));
            outputStreamB.close();
            return oVar.c();
        } catch (IOException e10) {
            throw new CMSException("exception calculating hash: " + e10.getMessage(), e10);
        }
    }

    public final void b(h hVar, byte[] bArr) throws ImprintDigestInvalidException {
        if (!org.bouncycastle.util.a.g(bArr, hVar.i().h())) {
            throw new ImprintDigestInvalidException("hash calculated is different from MessageImprintDigest found in TimeStampToken", hVar);
        }
    }

    public String c() {
        return this.f31447b.b();
    }

    public String d() {
        return this.f31447b.c();
    }

    public o e(p pVar) throws OperatorCreationException {
        try {
            o oVarA = pVar.a(new zn.b(g(this.f31446a[0]).i().g()));
            j(oVarA);
            return oVarA;
        } catch (CMSException e10) {
            throw new OperatorCreationException("unable to extract algorithm ID: " + e10.getMessage(), e10);
        }
    }

    public mm.b f() {
        return new mm.b(this.f31447b.d());
    }

    public h g(x0 x0Var) throws CMSException {
        try {
            return new h(x0Var.A());
        } catch (IOException e10) {
            throw new CMSException("unable to parse token data: " + e10.getMessage(), e10);
        } catch (IllegalArgumentException e11) {
            throw new CMSException("token data invalid: " + e11.getMessage(), e11);
        } catch (TSPException e12) {
            if (e12.getCause() instanceof CMSException) {
                throw ((CMSException) e12.getCause());
            }
            throw new CMSException("token data invalid: " + e12.getMessage(), e12);
        }
    }

    public h[] h() throws CMSException {
        h[] hVarArr = new h[this.f31446a.length];
        int i10 = 0;
        while (true) {
            x0[] x0VarArr = this.f31446a;
            if (i10 >= x0VarArr.length) {
                return hVarArr;
            }
            hVarArr[i10] = g(x0VarArr[i10]);
            i10++;
        }
    }

    public x0[] i() {
        return this.f31446a;
    }

    public void j(o oVar) throws CMSException {
        this.f31447b.e(oVar);
    }

    public void k(p pVar, byte[] bArr) throws ImprintDigestInvalidException, CMSException {
        int i10 = 0;
        while (true) {
            x0[] x0VarArr = this.f31446a;
            if (i10 >= x0VarArr.length) {
                return;
            }
            try {
                h hVarG = g(x0VarArr[i10]);
                if (i10 > 0) {
                    o oVarA = pVar.a(hVarG.i().f());
                    oVarA.b().write(this.f31446a[i10 - 1].v(j.f29713a));
                    bArr = oVarA.c();
                }
                b(hVarG, bArr);
                i10++;
            } catch (IOException e10) {
                throw new CMSException("exception calculating hash: " + e10.getMessage(), e10);
            } catch (OperatorCreationException e11) {
                throw new CMSException("cannot create digest: " + e11.getMessage(), e11);
            }
        }
    }

    public void l(p pVar, byte[] bArr, h hVar) throws ImprintDigestInvalidException, CMSException {
        try {
            byte[] bArrD = hVar.d();
            int i10 = 0;
            while (true) {
                x0[] x0VarArr = this.f31446a;
                if (i10 >= x0VarArr.length) {
                    throw new ImprintDigestInvalidException("passed in token not associated with timestamps present", hVar);
                }
                try {
                    h hVarG = g(x0VarArr[i10]);
                    if (i10 > 0) {
                        o oVarA = pVar.a(hVarG.i().f());
                        oVarA.b().write(this.f31446a[i10 - 1].v(j.f29713a));
                        bArr = oVarA.c();
                    }
                    b(hVarG, bArr);
                    if (org.bouncycastle.util.a.g(hVarG.d(), bArrD)) {
                        return;
                    } else {
                        i10++;
                    }
                } catch (IOException e10) {
                    throw new CMSException("exception calculating hash: " + e10.getMessage(), e10);
                } catch (OperatorCreationException e11) {
                    throw new CMSException("cannot create digest: " + e11.getMessage(), e11);
                }
            }
        } catch (IOException e12) {
            throw new CMSException("exception encoding timeStampToken: " + e12.getMessage(), e12);
        }
    }
}
