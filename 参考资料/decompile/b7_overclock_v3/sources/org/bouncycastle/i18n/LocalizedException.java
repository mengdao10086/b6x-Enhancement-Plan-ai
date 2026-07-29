package org.bouncycastle.i18n;

import java.util.Locale;
import yp.a;

/* JADX INFO: loaded from: classes5.dex */
public class LocalizedException extends Exception {
    private Throwable cause;
    public a message;

    public LocalizedException(a aVar) {
        super(aVar.n(Locale.getDefault()));
        this.message = aVar;
    }

    public LocalizedException(a aVar, Throwable th2) {
        super(aVar.n(Locale.getDefault()));
        this.message = aVar;
        this.cause = th2;
    }

    public a a() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
