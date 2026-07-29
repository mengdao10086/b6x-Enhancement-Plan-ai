package org.bouncycastle.tsp;

/* JADX INFO: loaded from: classes6.dex */
public class TSPValidationException extends TSPException {
    private int failureCode;

    public TSPValidationException(String str) {
        super(str);
        this.failureCode = -1;
    }

    public TSPValidationException(String str, int i10) {
        super(str);
        this.failureCode = i10;
    }

    public int b() {
        return this.failureCode;
    }
}
