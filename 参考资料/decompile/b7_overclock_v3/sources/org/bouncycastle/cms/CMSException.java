package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes5.dex */
public class CMSException extends Exception {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f44495e;

    public CMSException(String str) {
        super(str);
    }

    public CMSException(String str, Exception exc) {
        super(str);
        this.f44495e = exc;
    }

    public Exception a() {
        return this.f44495e;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f44495e;
    }
}
