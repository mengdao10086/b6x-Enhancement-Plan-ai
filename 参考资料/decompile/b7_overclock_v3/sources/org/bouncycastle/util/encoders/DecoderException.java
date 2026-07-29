package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes6.dex */
public class DecoderException extends IllegalStateException {
    private Throwable cause;

    public DecoderException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
