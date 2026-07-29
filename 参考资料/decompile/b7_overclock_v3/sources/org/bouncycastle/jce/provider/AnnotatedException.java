package org.bouncycastle.jce.provider;

/* JADX INFO: loaded from: classes5.dex */
public class AnnotatedException extends Exception implements dr.a {
    private Throwable _underlyingException;

    public AnnotatedException(String str) {
        this(str, null);
    }

    public AnnotatedException(String str, Throwable th2) {
        super(str);
        this._underlyingException = th2;
    }

    public Throwable a() {
        return this._underlyingException;
    }

    @Override // java.lang.Throwable, dr.a
    public Throwable getCause() {
        return this._underlyingException;
    }
}
