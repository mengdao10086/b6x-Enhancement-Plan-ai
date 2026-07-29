package org.bouncycastle.util.test;

/* JADX INFO: loaded from: classes6.dex */
public class TestFailedException extends RuntimeException {
    private f _result;

    public TestFailedException(f fVar) {
        this._result = fVar;
    }

    public f a() {
        return this._result;
    }
}
