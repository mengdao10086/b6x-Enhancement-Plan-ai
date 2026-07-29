package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.LocalizedException;

/* JADX INFO: loaded from: classes6.dex */
public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath;
    private int index;

    public CertPathReviewerException(yp.a aVar) {
        super(aVar);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(yp.a aVar, Throwable th2) {
        super(aVar, th2);
        this.index = -1;
        this.certPath = null;
    }

    public CertPathReviewerException(yp.a aVar, Throwable th2, CertPath certPath, int i10) {
        super(aVar, th2);
        this.index = -1;
        this.certPath = null;
        if (certPath == null || i10 == -1) {
            throw new IllegalArgumentException();
        }
        if (i10 < -1 || i10 >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.index = i10;
    }

    public CertPathReviewerException(yp.a aVar, CertPath certPath, int i10) {
        super(aVar);
        this.index = -1;
        this.certPath = null;
        if (certPath == null || i10 == -1) {
            throw new IllegalArgumentException();
        }
        if (i10 < -1 || i10 >= certPath.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        }
        this.certPath = certPath;
        this.index = i10;
    }

    public CertPath b() {
        return this.certPath;
    }

    public int c() {
        return this.index;
    }
}
