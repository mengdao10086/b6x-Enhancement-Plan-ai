package org.bouncycastle.openssl;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class PEMException extends IOException {
    public Exception underlying;

    public PEMException(String str) {
        super(str);
    }

    public PEMException(String str, Exception exc) {
        super(str);
        this.underlying = exc;
    }

    public Exception a() {
        return this.underlying;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlying;
    }
}
