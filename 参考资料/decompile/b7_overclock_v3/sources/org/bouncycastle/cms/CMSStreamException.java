package org.bouncycastle.cms;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class CMSStreamException extends IOException {
    private final Throwable underlying;

    public CMSStreamException(String str) {
        super(str);
        this.underlying = null;
    }

    public CMSStreamException(String str, Throwable th2) {
        super(str);
        this.underlying = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlying;
    }
}
