package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends org.bouncycastle.x509.v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n f45471d = new n(zr.i.f59660f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h0 f45472a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45473b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f45474c = null;

    @Override // org.bouncycastle.x509.v
    public void a(InputStream inputStream) {
        this.f45474c = inputStream;
        this.f45472a = null;
        this.f45473b = 0;
        if (inputStream.markSupported()) {
            return;
        }
        this.f45474c = new BufferedInputStream(this.f45474c);
    }

    @Override // org.bouncycastle.x509.v
    public Object b() throws StreamParsingException {
        try {
            gm.h0 h0Var = this.f45472a;
            if (h0Var != null) {
                if (this.f45473b != h0Var.size()) {
                    return d();
                }
                this.f45472a = null;
                this.f45473b = 0;
                return null;
            }
            this.f45474c.mark(10);
            int i10 = this.f45474c.read();
            if (i10 == -1) {
                return null;
            }
            if (i10 != 48) {
                this.f45474c.reset();
                return f(this.f45474c);
            }
            this.f45474c.reset();
            return e(this.f45474c);
        } catch (Exception e10) {
            throw new StreamParsingException(e10.toString(), e10);
        }
    }

    @Override // org.bouncycastle.x509.v
    public Collection c() throws StreamParsingException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate certificate = (Certificate) b();
            if (certificate == null) {
                return arrayList;
            }
            arrayList.add(certificate);
        }
    }

    public final Certificate d() throws CertificateParsingException {
        if (this.f45472a == null) {
            return null;
        }
        while (this.f45473b < this.f45472a.size()) {
            gm.h0 h0Var = this.f45472a;
            int i10 = this.f45473b;
            this.f45473b = i10 + 1;
            gm.h hVarJ = h0Var.J(i10);
            if (hVarJ instanceof gm.f0) {
                return new X509CertificateObject(zn.o.z(hVarJ));
            }
        }
        return null;
    }

    public final Certificate e(InputStream inputStream) throws CertificateParsingException, IOException {
        gm.f0 f0Var = (gm.f0) new gm.s(inputStream).n();
        if (f0Var.size() <= 1 || !(f0Var.K(0) instanceof gm.y) || !f0Var.K(0).equals(pn.s.f46833p4)) {
            return new X509CertificateObject(zn.o.z(f0Var));
        }
        this.f45472a = new pn.c0(gm.f0.I((gm.n0) f0Var.K(1), true)).y();
        return d();
    }

    public final Certificate f(InputStream inputStream) throws CertificateParsingException, IOException {
        gm.f0 f0VarB = f45471d.b(inputStream);
        if (f0VarB != null) {
            return new X509CertificateObject(zn.o.z(f0VarB));
        }
        return null;
    }
}
