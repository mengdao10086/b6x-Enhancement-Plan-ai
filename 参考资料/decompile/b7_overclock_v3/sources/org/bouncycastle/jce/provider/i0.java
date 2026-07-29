package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends org.bouncycastle.x509.v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f45462d = new n("CRL");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h0 f45463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45464b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f45465c = null;

    @Override // org.bouncycastle.x509.v
    public void a(InputStream inputStream) {
        this.f45465c = inputStream;
        this.f45463a = null;
        this.f45464b = 0;
        if (inputStream.markSupported()) {
            return;
        }
        this.f45465c = new BufferedInputStream(this.f45465c);
    }

    @Override // org.bouncycastle.x509.v
    public Object b() throws StreamParsingException {
        try {
            gm.h0 h0Var = this.f45463a;
            if (h0Var != null) {
                if (this.f45464b != h0Var.size()) {
                    return d();
                }
                this.f45463a = null;
                this.f45464b = 0;
                return null;
            }
            this.f45465c.mark(10);
            int i10 = this.f45465c.read();
            if (i10 == -1) {
                return null;
            }
            if (i10 != 48) {
                this.f45465c.reset();
                return f(this.f45465c);
            }
            this.f45465c.reset();
            return e(this.f45465c);
        } catch (Exception e10) {
            throw new StreamParsingException(e10.toString(), e10);
        }
    }

    @Override // org.bouncycastle.x509.v
    public Collection c() throws StreamParsingException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            CRL crl = (CRL) b();
            if (crl == null) {
                return arrayList;
            }
            arrayList.add(crl);
        }
    }

    public final CRL d() throws CRLException {
        gm.h0 h0Var = this.f45463a;
        if (h0Var == null || this.f45464b >= h0Var.size()) {
            return null;
        }
        gm.h0 h0Var2 = this.f45463a;
        int i10 = this.f45464b;
        this.f45464b = i10 + 1;
        return new h0(zn.p.y(h0Var2.J(i10)));
    }

    public final CRL e(InputStream inputStream) throws IOException, CRLException {
        gm.f0 f0Var = (gm.f0) new gm.s(inputStream).n();
        if (f0Var.size() <= 1 || !(f0Var.K(0) instanceof gm.y) || !f0Var.K(0).equals(pn.s.f46833p4)) {
            return new h0(zn.p.y(f0Var));
        }
        this.f45463a = new pn.c0(gm.f0.I((gm.n0) f0Var.K(1), true)).x();
        return d();
    }

    public final CRL f(InputStream inputStream) throws IOException, CRLException {
        gm.f0 f0VarB = f45462d.b(inputStream);
        if (f0VarB != null) {
            return new h0(zn.p.y(f0VarB));
        }
        return null;
    }
}
