package no;

import java.util.Collections;
import java.util.Set;
import org.bouncycastle.cert.path.CertPathValidationException;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f42312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertPathValidationException f42313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f42314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f42316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CertPathValidationException[] f42317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f42318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f42319h;

    public e(d dVar) {
        Set setUnmodifiableSet = Collections.unmodifiableSet(dVar.b());
        this.f42314c = setUnmodifiableSet;
        this.f42312a = setUnmodifiableSet.isEmpty();
        this.f42315d = -1;
        this.f42316e = -1;
        this.f42313b = null;
    }

    public e(d dVar, int i10, int i11, CertPathValidationException certPathValidationException) {
        this.f42314c = Collections.unmodifiableSet(dVar.b());
        this.f42312a = false;
        this.f42315d = i10;
        this.f42316e = i11;
        this.f42313b = certPathValidationException;
    }

    public e(d dVar, int[] iArr, int[] iArr2, CertPathValidationException[] certPathValidationExceptionArr) {
        this.f42314c = Collections.unmodifiableSet(dVar.b());
        this.f42312a = false;
        this.f42313b = certPathValidationExceptionArr[0];
        this.f42315d = iArr[0];
        this.f42316e = iArr2[0];
        this.f42317f = certPathValidationExceptionArr;
        this.f42318g = iArr;
        this.f42319h = iArr2;
    }

    public CertPathValidationException a() {
        CertPathValidationException certPathValidationException = this.f42313b;
        if (certPathValidationException != null) {
            return certPathValidationException;
        }
        if (this.f42314c.isEmpty()) {
            return null;
        }
        return new CertPathValidationException("Unhandled Critical Extensions");
    }

    public CertPathValidationException[] b() {
        CertPathValidationException[] certPathValidationExceptionArr = this.f42317f;
        if (certPathValidationExceptionArr != null) {
            CertPathValidationException[] certPathValidationExceptionArr2 = new CertPathValidationException[certPathValidationExceptionArr.length];
            System.arraycopy(certPathValidationExceptionArr, 0, certPathValidationExceptionArr2, 0, certPathValidationExceptionArr.length);
            return certPathValidationExceptionArr2;
        }
        if (this.f42314c.isEmpty()) {
            return null;
        }
        return new CertPathValidationException[]{new CertPathValidationException("Unhandled Critical Extensions")};
    }

    public int c() {
        return this.f42315d;
    }

    public int[] d() {
        return org.bouncycastle.util.a.s(this.f42318g);
    }

    public int e() {
        return this.f42316e;
    }

    public int[] f() {
        return org.bouncycastle.util.a.s(this.f42319h);
    }

    public Set g() {
        return this.f42314c;
    }

    public boolean h() {
        return this.f42318g != null;
    }

    public boolean i() {
        return this.f42312a;
    }
}
