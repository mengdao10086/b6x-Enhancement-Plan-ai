package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends org.bouncycastle.x509.v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f45444d = new n(zr.i.f59666l);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h0 f45445a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45446b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f45447c = null;

    @Override // org.bouncycastle.x509.v
    public void a(InputStream inputStream) {
        this.f45447c = inputStream;
        this.f45445a = null;
        this.f45446b = 0;
        if (inputStream.markSupported()) {
            return;
        }
        this.f45447c = new BufferedInputStream(this.f45447c);
    }

    @Override // org.bouncycastle.x509.v
    public Object b() throws StreamParsingException {
        try {
            gm.h0 h0Var = this.f45445a;
            if (h0Var != null) {
                if (this.f45446b != h0Var.size()) {
                    return d();
                }
                this.f45445a = null;
                this.f45446b = 0;
                return null;
            }
            this.f45447c.mark(10);
            int i10 = this.f45447c.read();
            if (i10 == -1) {
                return null;
            }
            if (i10 != 48) {
                this.f45447c.reset();
                return f(this.f45447c);
            }
            this.f45447c.reset();
            return e(this.f45447c);
        } catch (Exception e10) {
            throw new StreamParsingException(e10.toString(), e10);
        }
    }

    @Override // org.bouncycastle.x509.v
    public Collection c() throws StreamParsingException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            org.bouncycastle.x509.l lVar = (org.bouncycastle.x509.l) b();
            if (lVar == null) {
                return arrayList;
            }
            arrayList.add(lVar);
        }
    }

    public final org.bouncycastle.x509.l d() throws IOException {
        if (this.f45445a == null) {
            return null;
        }
        while (this.f45446b < this.f45445a.size()) {
            gm.h0 h0Var = this.f45445a;
            int i10 = this.f45446b;
            this.f45446b = i10 + 1;
            gm.h hVarJ = h0Var.J(i10);
            if (hVarJ instanceof gm.n0) {
                gm.n0 n0Var = (gm.n0) hVarJ;
                if (n0Var.q() == 2) {
                    return new org.bouncycastle.x509.y(gm.f0.I(n0Var, false).getEncoded());
                }
            }
        }
        return null;
    }

    public final org.bouncycastle.x509.l e(InputStream inputStream) throws IOException {
        gm.f0 f0VarJ = gm.f0.J(new gm.s(inputStream).n());
        if (f0VarJ.size() <= 1 || !(f0VarJ.K(0) instanceof gm.y) || !f0VarJ.K(0).equals(pn.s.f46833p4)) {
            return new org.bouncycastle.x509.y(f0VarJ.getEncoded());
        }
        this.f45445a = new pn.c0(gm.f0.I((gm.n0) f0VarJ.K(1), true)).y();
        return d();
    }

    public final org.bouncycastle.x509.l f(InputStream inputStream) throws IOException {
        gm.f0 f0VarB = f45444d.b(inputStream);
        if (f0VarB != null) {
            return new org.bouncycastle.x509.y(f0VarB.getEncoded());
        }
        return null;
    }
}
