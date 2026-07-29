package org.bouncycastle.cms;

/* JADX INFO: loaded from: classes5.dex */
public class CMSAttributeTableGenerationException extends CMSRuntimeException {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Exception f44494e;

    public CMSAttributeTableGenerationException(String str) {
        super(str);
    }

    public CMSAttributeTableGenerationException(String str, Exception exc) {
        super(str);
        this.f44494e = exc;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException
    public Exception a() {
        return this.f44494e;
    }

    @Override // org.bouncycastle.cms.CMSRuntimeException, java.lang.Throwable
    public Throwable getCause() {
        return this.f44494e;
    }
}
