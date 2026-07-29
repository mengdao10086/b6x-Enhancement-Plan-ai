package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes5.dex */
public class CMSRuntimeException extends RuntimeException {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f44496e;

    public CMSRuntimeException(String str) {
        super(str);
    }

    public CMSRuntimeException(String str, Exception exc) {
        super(str);
        this.f44496e = exc;
    }

    public Exception a() {
        return this.f44496e;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f44496e;
    }
}
