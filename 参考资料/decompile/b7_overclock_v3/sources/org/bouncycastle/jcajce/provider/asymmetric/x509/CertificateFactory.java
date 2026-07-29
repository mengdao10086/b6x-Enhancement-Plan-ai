package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.f0;
import gm.h;
import gm.h0;
import gm.n0;
import gm.s;
import gm.y;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import pn.c0;
import zn.o;
import zn.p;
import zr.i;

/* JADX INFO: loaded from: classes7.dex */
public class CertificateFactory extends CertificateFactorySpi {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f45060h = new b(i.f59660f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f45061i = new b("CRL");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f45062j = new b(i.f59664j);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45063a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f45064b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45065c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InputStream f45066d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public h0 f45067e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f45068f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InputStream f45069g = null;

    public class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        public ExCertificateException(Throwable th2) {
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public CRL a(p pVar) throws CRLException {
        return new X509CRLObject(this.f45063a, pVar);
    }

    public final CRL b(InputStream inputStream, boolean z10) throws CRLException {
        InputStream inputStream2 = this.f45069g;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.f45069g = inputStream;
            this.f45067e = null;
            this.f45068f = 0;
        }
        try {
            h0 h0Var = this.f45067e;
            if (h0Var != null) {
                if (this.f45068f != h0Var.size()) {
                    return d();
                }
                this.f45067e = null;
                this.f45068f = 0;
                return null;
            }
            if (!inputStream.markSupported()) {
                inputStream = new ByteArrayInputStream(kt.c.e(inputStream));
            }
            inputStream.mark(1);
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            inputStream.reset();
            return i10 != 48 ? j(inputStream, z10) : h(new s(inputStream, true));
        } catch (CRLException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new CRLException(e11.toString());
        }
    }

    public final Certificate c(InputStream inputStream, boolean z10) throws CertificateException {
        InputStream inputStream2 = this.f45066d;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.f45066d = inputStream;
            this.f45064b = null;
            this.f45065c = 0;
        }
        try {
            h0 h0Var = this.f45064b;
            if (h0Var != null) {
                if (this.f45065c != h0Var.size()) {
                    return f();
                }
                this.f45064b = null;
                this.f45065c = 0;
                return null;
            }
            if (!inputStream.markSupported()) {
                inputStream = new ByteArrayInputStream(kt.c.e(inputStream));
            }
            inputStream.mark(1);
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            inputStream.reset();
            return i10 != 48 ? k(inputStream, z10) : i(new s(inputStream));
        } catch (Exception e10) {
            throw new ExCertificateException("parsing issue: " + e10.getMessage(), e10);
        }
    }

    public final CRL d() throws CRLException {
        h0 h0Var = this.f45067e;
        if (h0Var == null || this.f45068f >= h0Var.size()) {
            return null;
        }
        h0 h0Var2 = this.f45067e;
        int i10 = this.f45068f;
        this.f45068f = i10 + 1;
        return a(p.y(h0Var2.J(i10)));
    }

    public final CRL e(f0 f0Var) throws CRLException {
        if (f0Var == null) {
            return null;
        }
        if (f0Var.size() <= 1 || !(f0Var.K(0) instanceof y) || !f0Var.K(0).equals(pn.s.f46833p4)) {
            return a(p.y(f0Var));
        }
        this.f45067e = c0.B(f0.I((n0) f0Var.K(1), true)).x();
        return d();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        return b(inputStream, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            CRL crlB = b(bufferedInputStream, arrayList.isEmpty());
            if (crlB == null) {
                return arrayList;
            }
            arrayList.add(crlB);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return new PKIXCertPath(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List list) throws CertificateException {
        for (Object obj : list) {
            if (obj != null && !(obj instanceof X509Certificate)) {
                throw new CertificateException("list contains non X509Certificate object while creating CertPath\n" + obj.toString());
            }
        }
        return new PKIXCertPath(list);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        return c(inputStream, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate certificateC = c(bufferedInputStream, arrayList.isEmpty());
            if (certificateC == null) {
                return arrayList;
            }
            arrayList.add(certificateC);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.f45070a.iterator();
    }

    public final Certificate f() throws CertificateParsingException {
        if (this.f45064b == null) {
            return null;
        }
        while (this.f45065c < this.f45064b.size()) {
            h0 h0Var = this.f45064b;
            int i10 = this.f45065c;
            this.f45065c = i10 + 1;
            h hVarJ = h0Var.J(i10);
            if (hVarJ instanceof f0) {
                return new X509CertificateObject(this.f45063a, o.z(hVarJ));
            }
        }
        return null;
    }

    public final Certificate g(f0 f0Var) throws CertificateParsingException {
        if (f0Var == null) {
            return null;
        }
        if (f0Var.size() <= 1 || !(f0Var.K(0) instanceof y) || !f0Var.K(0).equals(pn.s.f46833p4)) {
            return new X509CertificateObject(this.f45063a, o.z(f0Var));
        }
        this.f45064b = c0.B(f0.I((n0) f0Var.K(1), true)).y();
        return f();
    }

    public final CRL h(s sVar) throws IOException, CRLException {
        return e(f0.J(sVar.n()));
    }

    public final Certificate i(s sVar) throws CertificateParsingException, IOException {
        return g(f0.J(sVar.n()));
    }

    public final CRL j(InputStream inputStream, boolean z10) throws IOException, CRLException {
        return e(f45061i.c(inputStream, z10));
    }

    public final Certificate k(InputStream inputStream, boolean z10) throws CertificateParsingException, IOException {
        return g(f45060h.c(inputStream, z10));
    }
}
