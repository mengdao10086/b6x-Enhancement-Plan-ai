package org.bouncycastle.jce.provider;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collection;
import org.bouncycastle.x509.util.StreamParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends org.bouncycastle.x509.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InputStream f45469a = null;

    @Override // org.bouncycastle.x509.v
    public void a(InputStream inputStream) {
        this.f45469a = inputStream;
        if (inputStream.markSupported()) {
            return;
        }
        this.f45469a = new BufferedInputStream(this.f45469a);
    }

    @Override // org.bouncycastle.x509.v
    public Object b() throws StreamParsingException {
        try {
            this.f45469a.mark(10);
            if (this.f45469a.read() == -1) {
                return null;
            }
            this.f45469a.reset();
            return d(this.f45469a);
        } catch (Exception e10) {
            throw new StreamParsingException(e10.toString(), e10);
        }
    }

    @Override // org.bouncycastle.x509.v
    public Collection c() throws StreamParsingException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            org.bouncycastle.x509.p pVar = (org.bouncycastle.x509.p) b();
            if (pVar == null) {
                return arrayList;
            }
            arrayList.add(pVar);
        }
    }

    public final org.bouncycastle.x509.p d(InputStream inputStream) throws CertificateParsingException, IOException {
        return new org.bouncycastle.x509.p(zn.q.y((gm.f0) new gm.s(inputStream).n()));
    }
}
